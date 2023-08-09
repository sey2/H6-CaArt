import React from 'react';
import { styled } from 'styled-components';

function OptionButton({
  type,
  selected,
}: {
  type: 'ex' | 'in' | '360' | string;
  selected?: boolean;
}) {
  function getButtonType(type: string) {
    switch (type) {
      case 'ex':
        return (
          <>
            <Flex>
              <img src="/images/ex_img.svg" />
              <span>외장</span>
            </Flex>
          </>
        );
      case 'in':
        return (
          <>
            <Flex>
              <img src="/images/in_img.svg" />
              <span>내장</span>
            </Flex>
          </>
        );

      case '360':
        return (
          <>
            <Flex style={{ width: 96 }}>
              <img src="/images/360_img.svg" />
              <span>360</span>
            </Flex>
          </>
        );
    }
  }

  return (
    <Box className="caption-medium-12 text-grey-0" selected={selected}>
      {getButtonType(type)}
    </Box>
  );
}

export default OptionButton;

const Box = styled.div<{ selected?: boolean }>`
  animation: width 0.5s linear;
  background-color: white;
  width: 52px;
  height: 52px;
  overflow: hidden;
  padding: 10px;
  border-radius: 4px;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
  ${props => props.selected && 'width: 96px'};
  cursor: pointer;
`;

const Flex = styled.div`
  display: flex;
  gap: 16px;
  align-items: center;
`;
