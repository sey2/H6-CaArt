import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

export interface LogoProps {
  type: 'default' | 'home';
}

function Logo({ type }: LogoProps) {
  const logoImgSrc =
    type === 'default'
      ? '/images/hyundai_logo_default.svg'
      : '/images/hyundai_logo_home.svg';

  return (
    <LogoBox>
      <Link to="/">
        <img src={logoImgSrc} />
      </Link>
      <CarListBox type={type}>
        <span className="head-medium-16">펠리세이드</span>
      </CarListBox>
    </LogoBox>
  );
}

const LogoBox = styled.div`
  display: inline-flex;
  align-items: center;
  gap: 16px;

  img {
    cursor: pointer;
    transform: translateY(2px);
  }
`;

const CarListBox = styled.div<LogoProps>`
  display: flex;
  flex-direction: column;
  gap: 8px;
  position: relative;

  span {
    color: ${props => (props.type === 'default' ? '#696969' : '#bebebe')};
    cursor: pointer;
    z-index: 3;
  }
`;

export default React.memo(Logo);
