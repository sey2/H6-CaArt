import React from 'react';
import styled from 'styled-components';

function ResultHeader() {
  return (
    <ResultHeaderBox>
      <ResultHeaderUpperBox>
        <ResultHeaderCar>
          <span className="head-medium-20 text-grey-50">펠리세이드</span>
          <span className="body-medium-18 text-grey-300">Le Blanc(르블랑)</span>
        </ResultHeaderCar>
        <ResultHeaderPrice className="head-medium-16 text-grey-100">
          43,460,000원
        </ResultHeaderPrice>
      </ResultHeaderUpperBox>
      <ResultHeaderLowerBox className="body-regular-14 text-grey-400">
        가솔린 ・ 2WD ・ 8인승
      </ResultHeaderLowerBox>
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

const ResultHeaderPrice = styled.div``;

const ResultHeaderLowerBox = styled.div``;

export { ResultHeader };
