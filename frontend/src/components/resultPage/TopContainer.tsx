import React from 'react';
import { Link } from 'react-router-dom';
import { styled } from 'styled-components';
import ResultImage from './ResultImage';

function TopContainer() {
  return (
    <Background>
      <Link to="/">
        <Logo>
          <img src="/images/hyundai_logo_default.svg" />
        </Logo>
      </Link>
      <Flex>
        <p className="text-grey-0 head-medium-26">나만의 차가 완성되었어요!</p>
        <p className="text-grey-200 body-regular-14">
          만든 차는 저장하고 공유할 수 있어요.
        </p>
      </Flex>
      <ResultImage />
    </Background>
  );
}

export default TopContainer;

const Background = styled.div`
  width: 100vw;
  height: 506px;
  flex-shrink: 0;
  padding-top: 89px;
  padding-bottom: 52px;
  background-color: var(--grey-700);
  position: relative;
  text-align: center;
`;
const Logo = styled.div`
  position: absolute;
  width: 150px;
  height: 21px;
  top: 32px;
  left: 40px;
`;

const Flex = styled.div`
  display: flex;
  flex-direction: column;
  gap: 4px;
  justify-content: center;
  margin-bottom: 33px;
`;
