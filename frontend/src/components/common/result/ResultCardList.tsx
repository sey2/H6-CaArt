import React from 'react';
import styled from 'styled-components';
import { ResultCard } from './ResultCard';

function ResultCardList() {
  return (
    <ResultCardListBox>
      <ResultCardListSetBox>
        <ResultCardListSetName className="caption-regular-12 text-grey-300">
          색상
        </ResultCardListSetName>
        <ResultCardListSet>
          <ResultCard
            title="외장"
            price={0}
            imgSrc="https://picsum.photos/200/300"
            text="75%의 사용자"
          ></ResultCard>
          <ResultCard
            title="외장"
            price={0}
            imgSrc="https://picsum.photos/200/300"
            text="75%의 사용자"
          ></ResultCard>
        </ResultCardListSet>
      </ResultCardListSetBox>
      <ResultCardListMiddleLine></ResultCardListMiddleLine>
      <ResultCardListSetBox>
        <ResultCardListSetName className="caption-regular-12 text-grey-300">
          옵션
        </ResultCardListSetName>
        <ResultCardListSet>
          <ResultCard
            title="외장"
            price={0}
            imgSrc="https://picsum.photos/200/300"
            text="75%의 사용자"
          ></ResultCard>
          <ResultCard
            title="외장"
            price={0}
            imgSrc="https://picsum.photos/200/300"
            text="75%의 사용자"
          ></ResultCard>
        </ResultCardListSet>
      </ResultCardListSetBox>
    </ResultCardListBox>
  );
}

const ResultCardListBox = styled.div``;

const ResultCardListSetBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 6px;
  margin-top: 26px;
  margin-bottom: 40px;
`;

const ResultCardListSetName = styled.div``;

const ResultCardListSet = styled.div`
  display: flex;
  gap: 16px;
`;

const ResultCardListMiddleLine = styled.div`
  width: 608px;
  height: 1px;
  background: var(--grey-700);
`;

export { ResultCardList };
