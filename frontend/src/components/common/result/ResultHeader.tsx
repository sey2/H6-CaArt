import React, { useContext } from 'react';
import styled from 'styled-components';
import { EstimationContext } from '../../../util/Context';
import { priceToString } from '../../../util/PriceToString';

function ResultHeader() {
  const { currentEstimation } = useContext(EstimationContext)!;
  return (
    <ResultHeaderBox>
      <ResultHeaderUpperBox>
        <ResultHeaderCar>
          <span className="head-medium-20 text-grey-50">팰리세이드</span>
          <span className="body-medium-18 text-grey-300">
            {currentEstimation.trim.name}
          </span>
        </ResultHeaderCar>
        <span className="head-medium-16 text-grey-100">
          {priceToString(currentEstimation.trim.price)}
        </span>
      </ResultHeaderUpperBox>
      <span className="body-regular-14 text-grey-400">
        {`${currentEstimation.engine.name} ・ ${currentEstimation.wd.name} ・ ${currentEstimation.body.name}`}
      </span>
    </ResultHeaderBox>
  );
}

const ResultHeaderBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 5px;
  width: 608px;
  height: 67px;
  border-bottom: 1px solid var(--grey-700);
`;

const ResultHeaderUpperBox = styled.div`
  display: flex;
  justify-content: space-between;
`;

const ResultHeaderCar = styled.div`
  display: inline-flex;
  gap: 8px;
`;

export default ResultHeader;
