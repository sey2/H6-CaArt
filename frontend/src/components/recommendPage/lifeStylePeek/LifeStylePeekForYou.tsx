import React from 'react';
import styled from 'styled-components';
import { LifeStyleModalProps } from './LifeStylePeekModal';

function LifeStylePeekForYou({
  recommendation,
}: Pick<LifeStyleModalProps, 'recommendation'>) {
  return (
    <LifeStylePeekForYouBox>
      <div className="head-medium-24 text-grey-0">For You</div>
      <LifeStylePeekForYouImgBox>
        <LifeStylePeekForYouImgUpperBox>
          <LifeStylePeekForYouTextBox>
            <div className="body-medium-14 text-grey-1000">
              {recommendation.model.trimName}
            </div>
            <div className="body-regular-12 text-grey-500">
              {recommendation.model.compositions}
            </div>
          </LifeStylePeekForYouTextBox>
          <LifeStylePeekForYouImgBackground
            greyColor={100}
          ></LifeStylePeekForYouImgBackground>
          <LifeStylePeekForYouImgBackground
            greyColor={500}
          ></LifeStylePeekForYouImgBackground>
          <img src={recommendation.model.trimImage}></img>
        </LifeStylePeekForYouImgUpperBox>
        <LifeStylePeekForYouImgLowerBox>
          <LifeStylePeekForYouImgLowerImgBox>
            <img src={recommendation.options[0].optionImage}></img>
            <div className="body-regular-14 text-grey-200">
              {recommendation.options[0].optionName}
            </div>
          </LifeStylePeekForYouImgLowerImgBox>
          <LifeStylePeekForYouImgLowerImgBox>
            <img src={recommendation.options[1].optionImage}></img>
            <div className="body-regular-14 text-grey-200">
              {recommendation.options[1].optionName}
            </div>
          </LifeStylePeekForYouImgLowerImgBox>
        </LifeStylePeekForYouImgLowerBox>
      </LifeStylePeekForYouImgBox>
    </LifeStylePeekForYouBox>
  );
}

const LifeStylePeekForYouBox = styled.div`
  width: 608px;
  padding-bottom: 32px;
  border-bottom: 1px solid var(--grey-700);
`;

const LifeStylePeekForYouImgBox = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 25px;
`;

const LifeStylePeekForYouImgUpperBox = styled.div`
  position: relative;
  overflow: hidden;

  img {
    width: 282px;
    height: 150px;
    position: absolute;
    top: 9px;
    left: 366px;
  }
`;

const LifeStylePeekForYouTextBox = styled.div`
  position: absolute;
  top: 20px;
  left: 16px;
`;

const LifeStylePeekForYouImgBackground = styled.div<{ greyColor: number }>`
  width: 608px;
  height: 80px;
  background: ${props => `var(--grey-${props.greyColor})`};
`;

const LifeStylePeekForYouImgLowerBox = styled.div`
  display: flex;
  img {
    width: 304px;
    height: 202px;
  }
`;

const LifeStylePeekForYouImgLowerImgBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;
`;

export { LifeStylePeekForYou };
