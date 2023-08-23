import React, { useCallback, useContext, useMemo, useState } from 'react';
import styled from 'styled-components';
import { EstimationContext } from '../../../../util/Context';
import { useFetch } from '../../../../hooks/useFetch';
import OptionCard from '../optionCard/OptionCard';
import ErrorPopup from '../../../common/ErrorPopup';
import OptionInfoPopupBtn from '../optionInfoPopup/OptionInfoPopupBtn';
import { OptionComponentProps } from '../../../../pages/vehicleEstimationPage/OptionEstimationPage';
import OptionCardListButton from './OptionCardListButton';

export interface OptionCardListProps {
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}

export interface AdditionalOptionListProps {
  totalElements: number;
  totalPages: number;
  additionalOptions: OptionProps[];
}

export interface basicOptionListProps {
  totalElements: number;
  totalPages: number;
  baseOptions: OptionProps[];
}

export interface OptionProps {
  optionId: number;
  optionName: string;
  description: string;
  optionImage: string;
  tags: string[];
  optionPrice?: number;
  summary?: string;
  badge?: 'string';
  adoptionRate?: number;
  position?: null;
  subOptions?: SubOptionProps[];
}

export interface SubOptionProps {
  optionName: string;
  description: string;
  optionImage: string;
}

function OptionCardList({
  optionCategory,
  setOptionCategory,
  setOpenedModalId,
}: OptionComponentProps & OptionCardListProps) {
  const { currentEstimation } = useContext(EstimationContext)!;
  const [clickedPlusBtn, setClickecPlusBtn] = useState(-1);

  const idMapping = useCallback(() => {
    const trimId =
      currentEstimation.trim.name === 'Exclusive'
        ? 2
        : currentEstimation.trim.name === 'Le Blanc'
        ? 1
        : currentEstimation.trim.name === 'Prestige'
        ? 3
        : 4;
    const engineId = currentEstimation.engine.name === '디젤 2.2' ? 1 : 2;
    const bodyTypeId = currentEstimation.body.name === '7인승' ? 1 : 2;
    const wdId = currentEstimation.wd.name === '2WD' ? 1 : 2;

    return {
      trimId,
      engineId,
      bodyTypeId,
      wdId,
    };
  }, [
    currentEstimation.trim,
    currentEstimation.engine,
    currentEstimation.body,
    currentEstimation.wd,
  ]);

  const { trimId, engineId, bodyTypeId, wdId } = useMemo(() => {
    return idMapping();
  }, [idMapping]);

  const pageSize = optionCategory.isBasic ? 12 : 8;
  const apiUrl = `/options/${
    optionCategory.isBasic ? 'basic' : 'additional'
  }/list?${
    optionCategory.name !== '전체' ? `tagId=${optionCategory.id}&` : ``
  }trimId=${trimId}&engineId=${engineId}&bodyTypeId=${bodyTypeId}&wdId=${wdId}&offset=${
    optionCategory.page
  }&pageSize=${pageSize}`;
  const { data, status, error } = useFetch<
    AdditionalOptionListProps | basicOptionListProps
  >(apiUrl);
  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;
  const maxPageNum = data.totalPages;

  const options =
    'baseOptions' in data ? data.baseOptions : data.additionalOptions;

  const optionCardListShow = options.map(item => {
    const optionData = {
      id: item.optionId,
      name: item.optionName,
      description: item.summary || item.description,
      imgSrc: item.optionImage,
      price: item.optionPrice || 0,
      badge: item.badge || '',
      percent: item.adoptionRate || 0,
    };

    const popupData = {
      top: item.position || item.optionId * 10,
      left: item.position || item.optionId * 10,
      id: item.optionId,
      name: item.optionName,
      img: item.optionImage,
      category: optionCategory.name,
      price: item.optionPrice || 0,
    };

    const $isSelected = currentEstimation.options.some(
      option => option.name === item.optionName,
    );

    return (
      <>
        <OptionCard
          key={`${item.optionId}1${item.optionName}`}
          data={optionData}
          optionCategory={optionCategory}
          selected={$isSelected}
          setOpenedModalId={setOpenedModalId}
        ></OptionCard>
        {!optionCategory.isBasic && optionCategory.name !== '전체' && (
          <OptionInfoPopupBtn
            key={`${item.optionId}2${item.optionName}`}
            option={popupData}
            clickedPlusBtn={clickedPlusBtn}
            setClickecPlusBtn={setClickecPlusBtn}
            setOpenedModalId={setOpenedModalId}
          ></OptionInfoPopupBtn>
        )}
      </>
    );
  });

  function pageMoveHandler(page: 'right' | 'left' | number) {
    if (page === 'left') {
      setOptionCategory({
        ...optionCategory,
        page: optionCategory.page === 0 ? 0 : optionCategory.page - 1,
      });
    } else if (page === 'right') {
      setOptionCategory({
        ...optionCategory,
        page:
          optionCategory.page === maxPageNum - 1
            ? maxPageNum - 1
            : optionCategory.page + 1,
      });
    } else {
      setOptionCategory({ ...optionCategory, page: page });
    }
  }

  if (optionCategory.isBasic || optionCategory.name === '전체') {
    return (
      <OptionCardListAdditionalAllBox>
        <TotalOptionNumber>
          <span className="body-medium-16 text-grey-300">전체</span>
          <span className="body-medium-16 text-secondary-active-blue">
            {data.totalElements}
          </span>
        </TotalOptionNumber>
        <OptionCardListBox>{optionCardListShow}</OptionCardListBox>
        {maxPageNum > 1 &&
          OptionCardListButton({
            page: optionCategory.page,
            maxPage: maxPageNum,
            pageMoveHandler: pageMoveHandler,
          })}
      </OptionCardListAdditionalAllBox>
    );
  } else {
    return (
      <OptionCardListAdditionalTagBox>
        <OptionCardListAdditionalTagImg
          src={optionCategory.img}
        ></OptionCardListAdditionalTagImg>
        <OptionCardListBox>{optionCardListShow}</OptionCardListBox>
        <OptionCardListAdditionalTagCaption className="caption-regular-12 text-grey-500">
          *상기 이미지는 이해를 돕기 위한 이미지로 실제 옵션 사진은 상세보기에서
          확인해주세요.
        </OptionCardListAdditionalTagCaption>
      </OptionCardListAdditionalTagBox>
    );
  }
}

const OptionCardListAdditionalAllBox = styled.div`
  display: flex;
  width: 1024px;
  flex-direction: column;
`;

const OptionCardListBox = styled.div`
  display: inline-flex;
  align-items: flex-start;
  gap: 16px;
  flex-wrap: wrap;

  > div {
    margin-bottom: 44px;
  }
`;

const TotalOptionNumber = styled.div`
  display: flex;
  margin-top: 19px;
  margin-bottom: 16px;
  gap: 5px;
`;

const OptionCardListAdditionalTagBox = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;
  width: 1024px;
  margin-top: 24px;
`;

const OptionCardListAdditionalTagImg = styled.img`
  width: 1024px;
  height: 490px;
  margin-bottom: 40px;
`;

const OptionCardListAdditionalTagCaption = styled.div`
  display: flex;
`;

export default React.memo(OptionCardList);
