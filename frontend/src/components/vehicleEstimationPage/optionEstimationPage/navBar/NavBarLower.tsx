import React from 'react';
import styled from 'styled-components';
import { useFetch } from '../../../../hooks/useFetch';
import { OptionComponentProps } from '../../../../pages/vehicleEstimationPage/OptionEstimationPage';
import ErrorPopup from '../../../common/ErrorPopup';

interface optionTagProps {
  tagId: number;
  tagName: string;
  tagImage: string;
  tagIcon: string;
  tagIconSelected: string;
  priority: number;
}

function OptionNavBarLower({
  optionCategory,
  setOptionCategory,
}: OptionComponentProps) {
  const selectedClassName = `body-medium-14 text-primary-blue`;
  const unSelectedClassName = `body-regular-14 text-grey-400`;

  const { data, status, error } = useFetch<optionTagProps[]>(
    `/tags/${optionCategory.isBasic ? 'basic' : 'additional'}`,
  );
  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  const categoryLists = data.map(item => {
    const $isSelected = item.tagName === optionCategory.name;

    return (
      <OptionNavCategoryBox
        key={item.tagName}
        $isSelected={$isSelected}
        onClick={() => {
          setOptionCategory({
            isBasic: optionCategory.isBasic,
            name: item.tagName,
            img: item.tagImage,
            id: item.tagId,
            page: 0,
          });
        }}
      >
        <img src={$isSelected ? item.tagIconSelected : item.tagIcon}></img>
        <span className={$isSelected ? selectedClassName : unSelectedClassName}>
          {item.tagName}
        </span>
      </OptionNavCategoryBox>
    );
  });

  return <OptionNavBarLowerBox>{categoryLists}</OptionNavBarLowerBox>;
}

const OptionNavBarLowerBox = styled.div`
  display: flex;
  gap: 8px;
  width: 1024px;
  padding-top: 14px;
  margin: auto;
`;

const OptionNavCategoryBox = styled.div<{ $isSelected: boolean }>`
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 7px 10px;
  border-radius: 4px;
  cursor: pointer;
  background: ${props =>
    props.$isSelected ? `var(--grey-1000)` : 'var(--grey-800)'};
  border: ${props =>
    props.$isSelected
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
