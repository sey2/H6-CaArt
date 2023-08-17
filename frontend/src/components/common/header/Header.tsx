import React from 'react';
import styled from 'styled-components';
import Logo from '../Logo';
import HeaderMain from './HeaderMain';
import HeaderProgressBar from './HeaderProgressBar';

type HeaderSizeProps = 'small' | 'medium' | 'large';

interface HeaderPrips {
  size: HeaderSizeProps;
  page: number;
}

function Header({ size, page }: HeaderPrips) {
  page;
  return (
    <HeaderBox size={size}>
      <Container>
        <LogoBox>
          <Logo type={size === 'small' ? 'home' : 'default'}></Logo>
        </LogoBox>
        {size === 'medium' && <HeaderProgressBar></HeaderProgressBar>}
        {size === 'large' && <HeaderMain></HeaderMain>}
      </Container>
    </HeaderBox>
  );
}

const HeaderBox = styled.div<{ size: HeaderSizeProps }>`
  width: 100%;
  display: flex;
  justify-content: center;
  position: sticky;
  top: 0px;
  z-index: 20;

  ${props => cssHandler(props.size)};
`;

const Container = styled.div`
  width: 1280px;
`;

const cssHandler = (size: HeaderSizeProps) => {
  const shadow = `0px 4px 6px 0px rgba(0, 0, 0, 0.08)`;

  switch (size) {
    case 'small':
      return `background: transparent; height: 92px`;
      break;
    case 'medium':
      return `background: var(--grey-1000); height: 92px; box-shadow: ${shadow}`;
      break;
    case 'large':
      return `background: var(--grey-1000); height: 120px; box-shadow: ${shadow}`;
      break;
  }
};

const LogoBox = styled.div`
  width: 1024px;
  padding-top: 32px;
  margin: auto;
`;

export default Header;
