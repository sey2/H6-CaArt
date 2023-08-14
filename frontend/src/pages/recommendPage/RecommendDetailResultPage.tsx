import React from 'react';
import styled from 'styled-components';
import { Header } from '../../components/common/header/Header';
import { ResultMain } from '../../components/common/result/ResultMain';
import SquareButton from '../../components/common/SquareButton';
import { TagList } from '../../components/common/TagList';

function RecommendDetailResultPage() {
  return (
    <RecommendDetailResultPageBox>
      <Header size="minimal" page={2}></Header>

      <RecommendDetailResultPageCarImgBox>
        <FlexBox>
          <TagList
            tagArr={['1년 이하', '1인', '출퇴근용', '디자인', '4200만원']}
            type="result"
          ></TagList>
          <RecommendDetailResultPageCarTextBox>
            <span className="head-medium-26 text-grey-0">
              질문에 기반한 추천 차량이에요.
            </span>
            <span className="body-regular-14 text-grey-200">
              전국의 카마스터분들이 엄선하여 추천했어요.
            </span>
          </RecommendDetailResultPageCarTextBox>
        </FlexBox>
      </RecommendDetailResultPageCarImgBox>
      <RecommendDetailResultPageBottomBox>
        <RecommendDetailResultPageCarImg src="/images/car.png"></RecommendDetailResultPageCarImg>
      </RecommendDetailResultPageBottomBox>

      <ResultMain></ResultMain>
      <RecommendDetailResultPageBtnBox>
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
      </RecommendDetailResultPageBtnBox>
    </RecommendDetailResultPageBox>
  );
}

const RecommendDetailResultPageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  g
`;

const RecommendDetailResultPageCarImgBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 16px;
  width: 100%;
  height: 218px;
  background: linear-gradient(180deg, #e6eaef 0%, #f1f4f7 100%);
`;

const FlexBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 16px;
  align-items: flex-start;
  width: 608px;
  padding-top: 64px;
`;

const RecommendDetailResultPageCarTextBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 8px;
`;

const RecommendDetailResultPageBottomBox = styled.div`
  width: 100%;
  height: 116px;
  background: var(--grey-300);
  margin-bottom: 56px;
  position: relative;
`;

const RecommendDetailResultPageCarImg = styled.img`
  position: absolute;
  top: -217px;
  right: 10%;
  width: 538px;
  height: 334px;
`;

const RecommendDetailResultPageBtnBox = styled.div`
  display: flex;
  gap: 12px;
  margin-top: 60px;
  margin-bottom: 36px;
`;

export { RecommendDetailResultPage };
