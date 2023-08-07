import React from 'react';
import styled from 'styled-components';

function OptionNavBarLower() {
  const selectedClassName = `body-medium-14 text-primary-blue`;
  const unSelectedClassName = `body-regular-14 text-grey-400`;

  const addtionalCategoryArr = [
    { name: '전체', imgSrc: '/images/category_icon_all.svg' },
    { name: '주행안전', imgSrc: '/images/category_icon_driving-safety.svg' },
    { name: '사용편의', imgSrc: '/images/category_icon_convenience.svg' },
    { name: '추위/더위', imgSrc: '/images/category_icon_cold-hot.svg' },
    { name: '주차/출차', imgSrc: '/images/category_icon_parking.svg' },
    { name: '퍼포먼스', imgSrc: '/images/category_icon_performance.svg' },
    { name: '스타일', imgSrc: '/images/category_icon_style.svg' },
  ];
  const basicCategoryArr = [
    { name: '대표', imgSrc: '/images/category_icon_main.svg' },
    { name: '전체', imgSrc: '/images/category_icon_all.svg' },
    { name: '주행안전', imgSrc: '/images/category_icon_driving-safety.svg' },
    { name: '사용편의', imgSrc: '/images/category_icon_convenience.svg' },
    { name: '추위/더위', imgSrc: '/images/category_icon_cold-hot.svg' },
    { name: '주차/출차', imgSrc: '/images/category_icon_parking.svg' },
    { name: '퍼포먼스', imgSrc: '/images/category_icon_performance.svg' },
    { name: '스타일', imgSrc: '/images/category_icon_style.svg' },
  ];

  const a: number = 1;
  const target = a === 0 ? addtionalCategoryArr : basicCategoryArr;

  const categoryLists = target.map(item => {
    return (
      <OptionNavCategoryBox
        key={item.name}
        className={item.name === '전체' ? 'selected' : ''}
      >
        <img src={item.imgSrc}></img>
        <span
          className={
            item.name === '전체' ? selectedClassName : unSelectedClassName
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
  padding: 7px 10px;
  align-items: center;
  gap: 8px;
  border-radius: 4px;

  background: ${props =>
    props.className === 'selected' ? `var(--grey-1000)` : 'var(--grey-800)'};
  border: ${props =>
    props.className === 'selected' ? `1.5px solid var(--primary-blue)` : ``};
`;

export { OptionNavBarLower };
