import React, { useState, useContext } from 'react';
import styled from 'styled-components';
import OptionCard from '../optionCard/OptionCard';
import OptionInfoPopupBtn from '../optionInfoPopup/OptionInfoPopupBtn';
import { EstimationContext } from '../../../../util/Context';
import { useFetch } from '../../../../hooks/useFetch';
import { ErrorPopup } from '../../../common/ErrorPopup';
import { additionalOptionListProps } from './OptionCardList';
import { optionCategoryProps } from '../navBar/NavBar';

function OptionCardListAdditionalTag({
  optionCategory,
  setOpenedModalId,
}: {
  optionCategory: optionCategoryProps;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}) {
  const { currentEstimation } = useContext(EstimationContext)!;
  const [clickedPlusBtn, setClickecPlusBtn] = useState(-1);
  const trimId = 1;
  // const trimID =
  //   currentEstimation.trim === 'Exclusive'
  //     ? 1
  //     : currentEstimation.trim === 'Le Blanc'
  //     ? 2
  //     : currentEstimation.trim === 'Prestige'
  //     ? 3
  //     : 4;
  const engineId = currentEstimation.engine.name === '디젤 2.2' ? 1 : 2;
  const bodyTypeId = currentEstimation.engine.name === '7인승' ? 1 : 2;
  const wdId = currentEstimation.engine.name === '2WD' ? 1 : 2;
  const pageSize = 8;
  const apiUrl = `/options/additional/list?tagId=${optionCategory.id}&trimId=${trimId}&engineId=${engineId}&bodyTypeId=${bodyTypeId}&wdId=${wdId}&offset=0&pageSize=${pageSize}`;
  const { data, status, error } = useFetch<additionalOptionListProps>(apiUrl);
  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  const tagOptionCardList = data.additionalOptions.map(item => {
    const optionData = {
      id: item.optionId,
      name: item.optionName,
      description: item.summary,
      imgSrc: item.optionImage,
      price: item.optionPrice,
      badge: item.badge || '',
      percent: item.adoptionRate,
    };

    return (
      <>
        <OptionCard
          key={item.optionId}
          data={optionData}
          type={'additionalTag'}
          selected={
            currentEstimation.options.findIndex(
              option => option.name === item.optionName,
            ) !== -1
          }
          setOpenedModalId={setOpenedModalId}
        ></OptionCard>
        <OptionInfoPopupBtn
          top={item.position || item.optionId * 10}
          left={item.position || item.optionId * 10}
          clickedPlusBtn={clickedPlusBtn}
          setClickecPlusBtn={setClickecPlusBtn}
          setOpenedModalId={setOpenedModalId}
          id={item.optionId}
          name={item.optionName}
          category={optionCategory.name}
          img={item.optionImage}
          price={item.optionPrice}
        ></OptionInfoPopupBtn>
      </>
    );
  });

  return (
    <OptionCardListAdditionalTagBox>
      <OptionCardListAdditionalTagImg
        src={optionCategory.img}
      ></OptionCardListAdditionalTagImg>
      <OptionCardListBox>{tagOptionCardList}</OptionCardListBox>
      <OptionCardListAdditionalTagCaption className="caption-regular-12 text-grey-500">
        *상기 이미지는 이해를 돕기 위한 이미지로 실제 옵션 사진은 상세보기에서
        확인해주세요.
      </OptionCardListAdditionalTagCaption>
    </OptionCardListAdditionalTagBox>
  );
}

const OptionCardListAdditionalTagBox = styled.div`
  position: relative;
  display: inline-flex;
  flex-direction: column;
`;

const OptionCardListAdditionalTagImg = styled.img`
  width: 1024px;
  height: 490px;
  padding-top: 24px;
  padding-bottom: 40px;
`;

const OptionCardListBox = styled.div`
  display: inline-flex;
  align-items: flex-start;
  gap: 16px;
`;

const OptionCardListAdditionalTagCaption = styled.div`
  display: flex;
  margin-top: 36px;
`;

export default OptionCardListAdditionalTag;
