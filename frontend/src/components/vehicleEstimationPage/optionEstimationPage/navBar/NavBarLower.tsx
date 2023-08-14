import React from 'react';
import styled from 'styled-components';
import { OptionNavBarProps } from '../../../../pages/vehicleEstimationPage/OptionEstimationPage';

function OptionNavBarLower({
  isBasicOptionPage,
  optionCategory,
  setOptionCategory,
}: Pick<
  OptionNavBarProps,
  'isBasicOptionPage' | 'optionCategory' | 'setOptionCategory'
>) {
  const selectedClassName = `body-medium-14 text-primary-blue`;
  const unSelectedClassName = `body-regular-14 text-grey-400`;
  const categoryList = isBasicOptionPage
    ? basicCategoryArr
    : addtionalCategoryArr;

  const categoryLists = categoryList.map(item => {
    return (
      <OptionNavCategoryBox
        key={item.name}
        className={item.name === optionCategory ? 'selected' : ''}
        onClick={() => {
          setOptionCategory(item.name);
        }}
      >
        <img
          src={`${item.imgSrc}_${
            item.name === optionCategory ? 'blue' : 'black'
          }.svg`}
        ></img>
        <span
          className={
            item.name === optionCategory
              ? selectedClassName
              : unSelectedClassName
          }
        >
          {item.name}
        </span>
      </OptionNavCategoryBox>
    );
  });

  return <OptionNavBarLowerBox>{categoryLists}</OptionNavBarLowerBox>;
}

const OptionNavBarLowerBox = styled.div`
  display: flex;
  gap: 8px;
  padding-top: 14px;
  padding-left: 128px;
`;

const OptionNavCategoryBox = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 7px 10px;
  border-radius: 4px;
  cursor: pointer;
  background: ${props =>
    props.className === 'selected' ? `var(--grey-1000)` : 'var(--grey-800)'};
  border: ${props =>
    props.className === 'selected'
      ? `1.5px solid var(--primary-blue)`
      : `1.5px solid transparent`};
  transition: all 0.5s;

  &:hover {
    border: 1.5px solid var(--primary-blue);
    background: var(--grey-1000);

    span {
      color: var(--primary-blue);
    }
  }
`;

export default OptionNavBarLower;

const addtionalCategoryArr = [
  { name: '전체', imgSrc: '/images/optionCategoryIcon/category_icon_all' },
  {
    name: '주행안전',
    imgSrc: '/images/optionCategoryIcon/category_icon_driving',
  },
  {
    name: '사용편의',
    imgSrc: '/images/optionCategoryIcon/category_icon_convenience',
  },
  {
    name: '추위/더위',
    imgSrc: '/images/optionCategoryIcon/category_icon_temperature',
  },
  {
    name: '주차/출차',
    imgSrc: '/images/optionCategoryIcon/category_icon_parking',
  },
  {
    name: '퍼포먼스',
    imgSrc: '/images/optionCategoryIcon/category_icon_performance',
  },
  { name: '스타일', imgSrc: '/images/optionCategoryIcon/category_icon_style' },
];
const basicCategoryArr = [
  { name: '대표', imgSrc: '/images/optionCategoryIcon/category_icon_main' },
  { name: '전체', imgSrc: '/images/optionCategoryIcon/category_icon_all' },
  {
    name: '주행안전',
    imgSrc: '/images/optionCategoryIcon/category_icon_driving',
  },
  {
    name: '사용편의',
    imgSrc: '/images/optionCategoryIcon/category_icon_convenience',
  },
  {
    name: '추위/더위',
    imgSrc: '/images/optionCategoryIcon/category_icon_temperature',
  },
  {
    name: '주차/출차',
    imgSrc: '/images/optionCategoryIcon/category_icon_parking',
  },
  {
    name: '퍼포먼스',
    imgSrc: '/images/optionCategoryIcon/category_icon_performance',
  },
  { name: '스타일', imgSrc: '/images/optionCategoryIcon/category_icon_style' },
];
