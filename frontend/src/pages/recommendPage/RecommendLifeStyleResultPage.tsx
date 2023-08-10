import React from 'react';
import styled from 'styled-components';
import { Header } from '../../components/common/header/Header';
import { ResultMain } from '../../components/common/result/ResultMain';
import SquareButton from '../../components/common/SquareButton';
import { RecommendResultCard } from '../../components/recommendPage/ageAndLifeStyle/RecommendResultCard';

function RecommendLifeStyleResultPage() {
  return (
    <RecommendLifeStyleResultPageBox>
      <Header size="minimal" page={2}></Header>
      <RecommendLifeStyleResultPageCarImgBox>
        <RecommendResultCard></RecommendResultCard>
      </RecommendLifeStyleResultPageCarImgBox>
      <ResultMain></ResultMain>
      <RecommendLifeStyleResultPageBtnBox>
        <SquareButton
          size="m"
          color="grey-50"
          bg="grey-1000"
          border
          onClick={() => {}}
        >
          커스텀하기
        </SquareButton>
        <SquareButton
          size="m"
          color="grey-1000"
          bg="primary-blue"
          onClick={() => {}}
        >
          빠른 견적내기
        </SquareButton>
      </RecommendLifeStyleResultPageBtnBox>
    </RecommendLifeStyleResultPageBox>
  );
}

const RecommendLifeStyleResultPageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const RecommendLifeStyleResultPageCarImgBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 485px;
  margin-bottom: 56px;
  background: linear-gradient(180deg, #a2b1d3 0%, #edf2fe 100%);
`;

const RecommendLifeStyleResultPageBtnBox = styled.div`
  display: flex;
  gap: 12px;
  margin-top: 60px;
  margin-bottom: 36px;
`;

export { RecommendLifeStyleResultPage };
