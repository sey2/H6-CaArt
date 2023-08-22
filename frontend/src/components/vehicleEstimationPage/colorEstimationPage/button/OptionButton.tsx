import React from 'react';
import { styled } from 'styled-components';
import { FlexBox } from '../../../common/FlexBox';

type ButtonType = 'ex' | 'in' | '360' | string;

interface OptionButtonProps {
  type: ButtonType;
  state: ButtonType;
  setter: React.Dispatch<React.SetStateAction<ButtonType>>;
}

function OptionButton({ type, state, setter }: OptionButtonProps) {
  function returnByType(type: string) {
    switch (type) {
      case 'ex':
        return (
          <>
            <FlexBox
              gap={16}
              align="center"
              width={96}
              onClick={() => {
                setter(type);
              }}
            >
              <img src="/images/ex_img.svg" />
              <span>외장</span>
            </FlexBox>
          </>
        );
      case 'in':
        return (
          <>
            <FlexBox
              gap={16}
              align="center"
              width={96}
              onClick={() => {
                setter(type);
              }}
            >
              <img src="/images/in_img.svg" />
              <span>내장</span>
            </FlexBox>
          </>
        );
      case '360':
        return (
          <>
            <FlexBox
              gap={16}
              align="center"
              width={96}
              onClick={() => {
                setter(type);
              }}
            >
              <img src="/images/360_img.svg" />
              <span>360</span>
            </FlexBox>
          </>
        );
    }
  }

  function getButtonType(type: string) {
    return (
      <Box
        className="caption-medium-12 text-grey-0"
        selected={state}
        type={type}
      >
        {returnByType(type)}
      </Box>
    );
  }

  return getButtonType(type);
}

export default OptionButton;

const Box = styled.div<{ type: string; selected: string }>`
  transition: width 0.1s linear;
  background-color: rgba(255, 255, 255, 0.8);
  width: 52px;
  height: 52px;
  overflow: hidden;
  padding: 10px;
  border-radius: 4px;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
  cursor: pointer;
  ${props => (props.type === props.selected ? 'width: 96px' : 'width:52px')};
`;
