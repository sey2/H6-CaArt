import React from 'react';
import styled from 'styled-components';
import { OptionNavBarProps } from '../../../../pages/vehicleEstimationPage/OptionEstimationPage';

function OptionNavBarUpper({
  isBasicOptionPage,
  setIsBasicOptionPage,
  setOptionCategory,
}: Pick<
  OptionNavBarProps,
  'isBasicOptionPage' | 'setIsBasicOptionPage' | 'setOptionCategory'
>) {
  const selectedClassName = `head-medium-20 text-grey-200`;
  const unSelectedClassName = `head-medium-20 text-grey-600`;

  return (
    <OptionNavBarUpperBox>
      <span
        className={!isBasicOptionPage ? selectedClassName : unSelectedClassName}
        onClick={() => {
          setIsBasicOptionPage(false);
          setOptionCategory('전체');
        }}
      >
        추가 옵션
      </span>
      <span
        className={isBasicOptionPage ? selectedClassName : unSelectedClassName}
        onClick={() => {
          setIsBasicOptionPage(true);
          setOptionCategory('대표');
        }}
      >
        기본 포함 옵션
      </span>
    </OptionNavBarUpperBox>
  );
}

const OptionNavBarUpperBox = styled.div`
  display: flex;
  gap: 40px;
  border-bottom: 1px solid var(--grey-700);

  span {
    padding-bottom: 8px;
    cursor: pointer;
  }

  span.text-grey-200 {
    border-bottom: 2px solid var(--grey-200);
  }

  span:first-child {
    margin-left: 132px;
  }
`;

export { OptionNavBarUpper };
