import React, { useContext } from 'react';
import styled from 'styled-components';
import OptionCard, { OptionCardType } from '../optionCard/OptionCard';
import { EstimationContext } from '../../../../util/Context';
import { ErrorPopup } from '../../../common/ErrorPopup';
import { useFetch } from '../../../../hooks/useFetch';

interface OptionCardListProps {
  page: number;
  setPage: React.Dispatch<React.SetStateAction<number>>;
  type: OptionCardType;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}

interface AdditionalOption {
  optionId: number;
  optionName: string;
  optionPrice: number;
  description: string;
  summary: string;
  badge: null | 'string';
  adoptionRate: number;
  position: null;
  optionImage: string;
  tags: string[];
  subOptions: SubOption[];
}

interface SubOption {
  optionName: string;
  description: string;
  optionImage: string;
}

export interface additionalOptionListProps {
  totalElements: number;
  totalPages: number;
  additionalOptions: AdditionalOption[];
}

function OptionCardList({
  page,
  setPage,
  type,
  setOpenedModalId,
}: OptionCardListProps) {
  const { currentEstimation } = useContext(EstimationContext)!;
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
  const apiUrl = `/options/additional/list?trimId=${trimId}&engineId=${engineId}&bodyTypeId=${bodyTypeId}&wdId=${wdId}&offset=${page}&pageSize=${pageSize}`;
  const { data, status, error } = useFetch<additionalOptionListProps>(apiUrl);
  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  const maxPageNum = data.totalPages;

  const optionCardListShow = data.additionalOptions.map(item => {
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
      <OptionCard
        key={item.optionId}
        data={optionData}
        type={type}
        selected={
          currentEstimation.options.findIndex(
            option => option.name === item.optionName,
          ) !== -1
        }
        setOpenedModalId={setOpenedModalId}
      ></OptionCard>
    );
  });

  const OptionMoveBtnList = () => {
    const buttons = [];
    const btnStartIndex = Math.floor(page / 5) * 5;
    const btnEndIndex = Math.min(btnStartIndex + 4, maxPageNum);
    for (let i = btnStartIndex; i < btnEndIndex; i++) {
      buttons.push(
        <OptionCardPageMoveBtn
          key={i}
          index={i}
          page={page}
          onClick={() => setPage(i)}
        >
          {i + 1}
        </OptionCardPageMoveBtn>,
      );
    }
    return buttons;
  };

  const OptionMoveBtn = (
    <OptionCardPageMoveBtnBox>
      <img
        src="/images/leftArrow_icon_basic.svg"
        onClick={() => {
          setPage(page === 0 ? 0 : page - 1);
        }}
      ></img>
      <div className="btn_list">{OptionMoveBtnList()}</div>
      <img
        src="/images/rightArrow_icon_basic.svg"
        onClick={() => {
          setPage(page === maxPageNum - 1 ? maxPageNum - 1 : page + 1);
        }}
      ></img>
    </OptionCardPageMoveBtnBox>
  );

  return (
    <OptionCardListAdditionalAllBox>
      <TotalOptionNumber>
        <span className="body-medium-16 text-grey-300">전체</span>
        <span className="body-medium-16 text-secondary-active-blue">
          {data.totalElements}
        </span>
      </TotalOptionNumber>
      <OptionCardListBox>{optionCardListShow}</OptionCardListBox>
      {maxPageNum > 1 && OptionMoveBtn}
    </OptionCardListAdditionalAllBox>
  );
}

const OptionCardListAdditionalAllBox = styled.div`
  display: flex;
  width: 100%;
  flex-direction: column;
`;

const OptionCardListBox = styled.div`
  display: inline-flex;
  align-items: flex-start;
  gap: 16px;
  flex-wrap: wrap;
  margin-left: 128px;

  > div {
    margin-bottom: 44px;
  }
`;

const TotalOptionNumber = styled.div`
  display: flex;
  margin-top: 19px;
  margin-bottom: 16px;
  margin-left: 128px;
  gap: 5px;
`;

const OptionCardPageMoveBtnBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  margin-top: 20px;

  .btn_list {
    display: flex;
  }

  img {
    cursor: pointer;
  }
`;

const OptionCardPageMoveBtn = styled.div<{ index: number; page: number }>`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 36px;
  height: 36px;
  border-radius: 50%;
  background: ${props =>
    props.page == props.index ? `var(--grey-700)` : ` var(--grey-1000)`};
  cursor: pointer;
`;

export default OptionCardList;
