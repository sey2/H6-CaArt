import React, { useContext } from 'react';
import styled from 'styled-components';
import { EstimationContext } from '../../../store/Context';
import { priceToString } from '../../../util/PriceToString';

function ResultFooter() {
  const { totalPrice } = useContext(EstimationContext)!;
  return (
    <ResultFooterBox>
      <span className="body-medium-16 text-grey-400">총 금액</span>
      <span className="head-medium-24 text-grey-0">
        {priceToString(totalPrice)}
      </span>
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

export default ResultFooter;
