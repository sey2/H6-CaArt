import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

function Logo({ type }: LogoProps) {
  const carList = ['펠리세이드', '베뉴'];
  const [carNum] = useState(0);
  const [isOpened, setIsOpened] = useState(false);

  const logoImgSrc =
    type === 'default'
      ? '/images/hyundai_logo_default.svg'
      : '/images/hyundai_logo_home.svg';
  const dropdownImgSrc =
    type === 'default'
      ? '/images/dropdown_icon_default.svg'
      : '/images/dropdown_icon_home.svg';

  const dropdownList = carList.map((item, index) => {
    const indexClassName = `body-medium-16 floating${index}`;
    if (index === carNum) return null;
    return (
      <span key={item} className={indexClassName}>
        {item}
      </span>
    );
  });

  return (
    <LogoBox>
      <Link to="/">
        <img src={logoImgSrc} />
      </Link>
      <CarListBox type={type}>
        <TextBox
          onClick={() => {
            setIsOpened(!isOpened);
          }}
        >
          <span className="head-medium-16">{carList[carNum]}</span>
          <img src={dropdownImgSrc} />
        </TextBox>
        {isOpened && dropdownList}
      </CarListBox>
    </LogoBox>
  );
}

export interface LogoProps {
  type: 'default' | 'home';
}

const LogoBox = styled.div`
  display: inline-flex;
  align-items: center;
  gap: 16px;

  img {
    cursor: pointer;
  }
`;

const TextBox = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;
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

  .floating1 {
    position: absolute;
    top: 20px;
  }
`;

export default Logo;
