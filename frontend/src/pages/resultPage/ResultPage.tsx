import React from 'react';
import TopContainer from '../../components/resultPage/TopContainer';
import { ResultMain } from '../../components/common/result/ResultMain';
import { styled } from 'styled-components';
import SquareButton from '../../components/common/SquareButton';
import BuyCarContainer from '../../components/resultPage/BuyCarContainer';

function ResultPage() {
  return (
    <>
      <TopContainer />
      <MainContainer>
        <ResultMain />
        <ButtonContainer>
          <SquareButton size="s" color="grey-200" border>
            내 계정에 저장
          </SquareButton>
          <SquareButton size="s" color="grey-200" border>
            PDF로 저장
          </SquareButton>
          <SquareButton size="s" color="grey-200" border>
            내 메일로 발송
          </SquareButton>
        </ButtonContainer>
      </MainContainer>
      <Hr />
      <BuyCarContainer />
      <ButtonContainer className="last">
        <SquareButton size="m" color="grey-50" border>수정</SquareButton>
        <SquareButton size="m" color="grey-1000" bg="primary-blue">구매/상담</SquareButton>
      </ButtonContainer>
    </>
  );
}

export default ResultPage;

const MainContainer = styled.div`
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  margin-top: 36px;
`;

const ButtonContainer = styled.div`
  display: flex;
  height: 52px;
  justify-content: center;
  align-items: center;
  gap: 8px;
  margin-top: 33px;
  margin-bottom: 52px;
  .last {
    gap: 18px;
    margin-top:66px;
    margin-bottom: 36px;
  }
`;

const Hr = styled.div`
  margin: 0 auto;
  width: 608px;
  height: 1px;
  background: var(--grey-700);
`;
