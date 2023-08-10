import React from 'react';
import styled from 'styled-components';

function RecommendResultCard() {
  return (
    <RecommendResultCardBox>
      <RecommendResultCardLogo src="/images/hyundai_logo_mini.svg"></RecommendResultCardLogo>
      <RecommendResultCardTitle>
        <RecommendResultCardTag className="head-medium-12 text-grey-1000">
          <span>펠리세이드 - Le Blanc(르블랑)</span>
        </RecommendResultCardTag>
        <RecommendResultCardTitleText className="head-regular-20">
          <span className="text-primary-blue">가족</span>
          <span className="text-grey-0">
            을 생각하는 당신을 위한
            <br />
            펠리세이드
          </span>
        </RecommendResultCardTitleText>
      </RecommendResultCardTitle>
      <RecommendResultCardImg src="/images/car.png"></RecommendResultCardImg>
      <RecommendResultCardText className="body-medium-14 text-grey-400">
        우리 아이들과 함께 타는 차는 항상 안전해야 한다고 생각해요
      </RecommendResultCardText>
    </RecommendResultCardBox>
  );
}

const RecommendResultCardBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 300px;
  height: 419px;
  position: relative;
  border-radius: 12px;
  border: 2px solid rgba(255, 255, 255, 0.5);
  background: rgba(255, 255, 255, 0.3);
  box-shadow: 0px 4px 30px 0px rgba(97, 129, 177, 0.2);
  backdrop-filter: blur(5px);
  overflow: hidden;
`;

const RecommendResultCardLogo = styled.img`
  position: absolute;
  top: 17px;
  left: 19px;
`;

const RecommendResultCardTitle = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 8px;
  margin-top: 29px;
`;

const RecommendResultCardTag = styled.div`
  display: inline-flex;
  padding: 6px 12px;
  align-items: center;
  justify-content: center;
  width: fit-content;
  border-radius: 30px;
  background: var(--primary-blue);
`;

const RecommendResultCardTitleText = styled.div`
  text-align: center;
`;

const RecommendResultCardImg = styled.img`
  width: 496px;
  height: 246px;
  position: absolute;
  top: 91px;
  left: 30px;
`;

const RecommendResultCardText = styled.div`
  display: flex;
  align-items: center;
  gap: 4px;
  width: 257px;
  height: 55px;
  padding: 8px 12px;
  margin-top: 223px;
  border-radius: 8px;
  background: var(--grey-1000);

  &::after {
    content: '';
    position: absolute;
    bottom: 73px;
    left: 30px;
    width: 0;
    height: 0;

    border-top: 10px solid transparent;
    border-right: 10px solid transparent;
    border-bottom: 10px solid var(--grey-1000);
    border-left: 10px solid transparent;
    border-radius: 1px;
    margin-bottom: -6px;
  }
`;

export { RecommendResultCard };
