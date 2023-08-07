import React from 'react';
import styled from 'styled-components';
import { OptionNavBarLower } from './navBarLower';
import { OptionNavBarUpper } from './navBarUpper';

function OptionNavBar() {
  return (
    <OptionNavBarBox>
      <OptionNavBarUpper></OptionNavBarUpper>
      <OptionNavBarLower></OptionNavBarLower>
      <OptionNavBarBottomLine />
    </OptionNavBarBox>
  );
}

const OptionNavBarBox = styled.div`
  width: 100%;
  height: 128px;
  flex-shrink: 0;
  padding-top: 20px;
  padding-bottom: 18px;
  background: var(--grey-1000);
`;

const OptionNavBarBottomLine = styled.div`
  height: 1px;
  margin: 18px 128px 0px 128px;

  background: var(--grey-700);
`;

export { OptionNavBar };
