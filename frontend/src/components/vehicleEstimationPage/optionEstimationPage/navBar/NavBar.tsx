import React from 'react';
import styled from 'styled-components';
import OptionNavBarLower from './NavBarLower';
import OptionNavBarUpper from './NavBarUpper';

export interface optionCategoryProps {
  name: string;
  img: string;
  id: number;
}
export interface OptionNavBarProps {
  isBasicOptionPage: boolean;
  setIsBasicOptionPage: React.Dispatch<React.SetStateAction<boolean>>;
  optionCategory: optionCategoryProps;
  setOptionCategory: React.Dispatch<React.SetStateAction<optionCategoryProps>>;
}

function OptionNavBar({
  isBasicOptionPage,
  setIsBasicOptionPage,
  optionCategory,
  setOptionCategory,
}: OptionNavBarProps) {
  return (
    <OptionNavBarBox>
      <OptionNavBarUpper
        isBasicOptionPage={isBasicOptionPage}
        setIsBasicOptionPage={setIsBasicOptionPage}
        setOptionCategory={setOptionCategory}
      ></OptionNavBarUpper>
      <OptionNavBarLower
        isBasicOptionPage={isBasicOptionPage}
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

export default OptionNavBar;
