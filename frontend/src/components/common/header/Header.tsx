import React, { useState } from 'react';
import styled from 'styled-components';
import { Logo } from '../Logo';
import { HeaderMain } from './HeaderMain';
import { HeaderProgressBar } from './HeaderProgressBar';

function Header({ size, page, currentEstimateObj }: HeaderProps) {
  const [step, setStep] = useState(page);

  console.log(step);
  console.log(currentEstimateObj);
  console.log(setStep);

  return (
    <HeaderBox size={size}>
      <LogoBox>
        <Logo type={'default'}></Logo>
      </LogoBox>
      {size === 'minimal' && (
        <HeaderProgressBar step={step}></HeaderProgressBar>
      )}
      {size !== 'minimal' && <HeaderMain step={step}></HeaderMain>}
    </HeaderBox>
  );
}

const HeaderBox = styled.div<{ size: 'minimal' | 'default' }>`
  width: 100%;
  position: sticky;
  top: 0px;
  background: #fff;
  box-shadow: 0px 4px 6px 0px rgba(0, 0, 0, 0.08);

  ${props => getHeaderHeight(props.size)};
`;

const getHeaderHeight = (size: 'minimal' | 'default') => {
  switch (size) {
    case 'minimal':
      return `height: 92px`;
    case 'default':
      return `height: 120px`;
  }
};

const LogoBox = styled.div`
  padding-left: 128px;
  padding-top: 32px;
`;

export interface HeaderProps {
  size: 'minimal' | 'default';
  page: number;
  currentEstimateObj?: currentEstimateObjProps;
}

export interface currentEstimateObjProps {
  trim: string;
  color: string;
  option: string[];
}

export { Header };
