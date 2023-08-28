import React from 'react';
import styled from 'styled-components';
import { OptionComponentProps } from '../../../../pages/vehicleEstimationPage/OptionEstimationPage';
import OptionNavBarLower from './NavBarLower';
import OptionNavBarUpper from './NavBarUpper';

function OptionNavBar({
  optionCategory,
  setOptionCategory,
}: OptionComponentProps) {
  return (
    <OptionNavBarBox>
      <OptionNavBarUpper
        optionCategory={optionCategory}
        setOptionCategory={setOptionCategory}
      ></OptionNavBarUpper>
      <OptionNavBarLower
        optionCategory={optionCategory}
        setOptionCategory={setOptionCategory}
      ></OptionNavBarLower>
      <OptionNavBarBottomLine />
    </OptionNavBarBox>
  );
}

const OptionNavBarBox = styled.div`
  width: 100%;
  height: 128px;
  padding-top: 20px;
  padding-bottom: 18px;
  background: var(--grey-1000);
`;

const OptionNavBarBottomLine = styled.div`
  width: 1024px;
  height: 1px;
  margin: 18px auto 0px auto;
  background: var(--grey-700);
`;

export default React.memo(OptionNavBar);
