import React from 'react';
import styled from 'styled-components';

function ResultFooter() {
  return (
    <ResultFooterBox>
      <span className="body-medium-16 text-grey-400">총 금액</span>
      <span className="head-medium-24 text-grey-0">48,120,000원</span>
    </ResultFooterBox>
  );
}

const ResultFooterBox = styled.div`
  display: flex;
  align-items: flex-end;
  justify-content: space-between;
  width: 608px;
  height: 43px;
  border-top: 1px solid var(--grey-700);
`;

export { ResultFooter };
