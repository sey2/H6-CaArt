import React, { useState } from 'react';
import styled from 'styled-components';

function Logo({ type }: LogoProps) {
  const carList = ['펠리세이드', '베뉴', '투싼', '싼타페'];
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
    if (index === carNum) return null;
    return (
      <span key={item} className="head-medium-16">
        {item}
      </span>
    );
  });

  return (
    <LogoBox>
      <img src={logoImgSrc} />
      <CarListBox type={type}>
        <TextBox>
          <span className="head-medium-16">{carList[carNum]}</span>
          <img
            src={dropdownImgSrc}
            onClick={() => {
              setIsOpened(!isOpened);
            }}
          />
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
  align-items: flex-start;
  gap: 16px;
`;

const TextBox = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;

  img {
    cursor: pointer;
  }
`;

const CarListBox = styled.div<LogoProps>`
  display: flex;
  flex-direction: column;
  gap: 8px;

  span {
    color: ${props => (props.type === 'default' ? '#696969' : '#bebebe')};
    cursor: pointer;
  }
`;

export { Logo };
