import React from 'react';
import styled from 'styled-components';

function OptionNavBarUpper() {
  const selectedClassName = `head-medium-20 text-grey-200`;
  const unSelectedClassName = `head-medium-20 text-grey-600`;

  return (
    <OptionNavBarUpperBox>
      <span className={selectedClassName} onClick={() => {}}>
        추가 옵션
      </span>
      <span className={unSelectedClassName} onClick={() => {}}>
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
