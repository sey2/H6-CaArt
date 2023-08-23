import React, { useContext } from 'react';
import styled from 'styled-components';
import ResultCard from './ResultCard';
import { EstimationContext } from '../../../util/Context';

function ResultCardList() {
  const { currentEstimation } = useContext(EstimationContext)!;

  const optionResultList = currentEstimation.options.map(item => {
    return (
      <ResultCard
        key={item.name}
        title={item.name}
        price={item.price}
        imgSrc={item.img}
        text={item.msg || ''}
      ></ResultCard>
    );
  });

  return (
    <ResultCardListBox>
      <ResultCardListSetBox>
        <ResultCardListSetName className="caption-regular-12 text-grey-300">
          색상
        </ResultCardListSetName>
        <ResultCardListSet>
          <ResultCard
            key={currentEstimation.outerColor.name}
            title={currentEstimation.outerColor.name}
            price={currentEstimation.outerColor.price}
            imgSrc={currentEstimation.outerColor.img}
            text={currentEstimation.outerColor.msg || ''}
          ></ResultCard>
          <ResultCard
            key={currentEstimation.interiorColor.name}
            title={currentEstimation.interiorColor.name}
            price={currentEstimation.interiorColor.price}
            imgSrc={currentEstimation.interiorColor.img}
            text={currentEstimation.interiorColor.msg || ''}
          ></ResultCard>
        </ResultCardListSet>
      </ResultCardListSetBox>
      {currentEstimation.options.length > 0 && (
        <>
          <ResultCardListMiddleLine></ResultCardListMiddleLine>
          <ResultCardListSetBox>
            <ResultCardListSetName className="caption-regular-12 text-grey-300">
              옵션
            </ResultCardListSetName>
            <ResultCardListSet>{optionResultList}</ResultCardListSet>
          </ResultCardListSetBox>
        </>
      )}
    </ResultCardListBox>
  );
}

const ResultCardListBox = styled.div``;

const ResultCardListSetBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 6px;
  margin-top: 26px;
  margin-bottom: 26px;
`;

const ResultCardListSetName = styled.div``;

const ResultCardListSet = styled.div`
  display: flex;
  gap: 16px;
  flex-wrap: wrap;
`;

const ResultCardListMiddleLine = styled.div`
  width: 608px;
  height: 1px;
  background: var(--grey-700);
`;

export default ResultCardList;
