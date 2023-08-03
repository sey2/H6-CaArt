import React from 'react';
import styled from 'styled-components';
import { Logo } from '../components/common/Logo';
import SquareButton from '../components/common/SquareButton';

function HomePage() {
  return (
    <Wrapper>
      <HomePageVideo autoPlay muted loop>
        <source src="/videos/homePageVideo.mp4" type="video/mp4" />
      </HomePageVideo>
      <GradientTop />
      <TextContainer>
        <LogoBox>
          <Logo type="home" />
        </LogoBox>
        <TextBox>
          당신의 <span>라이프스타일</span>에 맞게
          <br /> 차량을 추천해드려요
        </TextBox>
      </TextContainer>
      <ButtonContainer>
        <SquareButton size="m" color="grey-900" border={true}>
          직접 만들래요
        </SquareButton>
        <SquareButton size="m" color="primary-blue" bg="grey-1000">
          추천받기
        </SquareButton>
      </ButtonContainer>
      <GradientBottom />
    </Wrapper>
  );
}

export default HomePage;

const Wrapper = styled.div`
  padding-top: 32px;
  padding-left: 128px;
`;

const TextContainer = styled.div`
  display: flex;
  flex-direction: column;
  gap: 90px;
`;

const LogoBox = styled.div`
  display: inline-flex;
  align-items: center;
  gap: 16px;
`;

const TextBox = styled.div`
  color: #fff;
  font-family: Hyundai Sans Head KR;
  font-size: 28px;
  font-style: normal;
  font-weight: 400;
  line-height: 150%; /* 42px */
  letter-spacing: -0.3px;
  span {
    font-weight: 700;
  }
`;

const GradientTop = styled.div`
  width: 100%;
  height: 338px;
  position: absolute;
  top: 0;
  left: 0;
  background: linear-gradient(180deg, #0f1114 0%, rgba(15, 17, 20, 0) 100%);
  z-index: -1;
`;

const GradientBottom = styled.div`
  width: 100%;
  height: 338px;
  position: absolute;
  bottom: 0;
  left: 0;
  background: linear-gradient(0deg, #0f1114 0%, rgba(15, 17, 20, 0) 100%);
  z-index: -1;
`;

const HomePageVideo = styled.video`
  position: absolute;
  object-fit: cover;
  width: 100%;
  height: 100vh;
  left: 0;
  top: 0;
  z-index: -2;
`;

const ButtonContainer = styled.div`
  display: flex;
  gap: 8px;
  position: absolute;
  bottom: 36px;
  left: 50%;
  transform: translateX(-50%);
`;
