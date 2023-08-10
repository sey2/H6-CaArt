import React from 'react';
import { styled } from 'styled-components';


function OptionButton({
  type,
  state,
  setter,
}: {
  type: 'ex' | 'in' | '360' | string;
  state: 'ex' | 'in' | '360' | string;
  setter: React.Dispatch<React.SetStateAction<'ex' | 'in' | '360' | string>>;
}) {
  function returnByType(type: string) {
    switch (type) {
      case 'ex':
        return (
          <>
            <Flex
              onClick={() => {
                setter(type);
              }}
            >
              <img src="/images/ex_img.svg" />
              <span>외장</span>
            </Flex>
          </>
        );
      case 'in':
        return (
          <>
            <Flex
              onClick={() => {
                setter(type);
              }}
            >
              <img src="/images/in_img.svg" />
              <span>내장</span>
            </Flex>
          </>
        );
      case '360':
        return (
          <>
            <Flex
              style={{ width: 96 }}
              onClick={() => {
                setter(type);
              }}
            >
              <img src="/images/360_img.svg" />
              <span>360</span>
            </Flex>
          </>
        );
    }
  }
  console.log(state)

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
  background-color: white;
  width: 52px;
  height: 52px;
  overflow: hidden;
  padding: 10px;
  border-radius: 4px;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
  cursor: pointer;
  ${props => (props.type === props.selected ? 'width: 96px' : 'width:52px')};
`;

const Flex = styled.div`
  display: flex;
  gap: 16px;
  align-items: center;
  width: 96px;
`;
