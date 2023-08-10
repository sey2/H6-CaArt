import React from 'react';
import { styled } from 'styled-components';


function OptionButton({
  type,
  state,
  setter
}: {
  type: 'ex' | 'in' | '360' | string;
  state: 'ex'|'in'|'360'|string,
  setter: React.Dispatch<React.SetStateAction<'ex'|'in'|'360'|string>>
}) {
  function getButtonType(type: string) {
    switch (type) {
      case 'ex':
        return (
          <>
            <Flex onClick={()=>setter(type)}>
              <img src="/images/ex_img.svg" />
              <span>외장</span>
            </Flex>
          </>
        );
      case 'in':
        return (
          <>
            <Flex onClick={()=>setter(type)}>
              <img src="/images/in_img.svg" />
              <span>내장</span>
            </Flex>
          </>
        );

      case '360':
        return (
          <>
            <Flex style={{ width: 96 }} onClick={()=>setter(type)}>
              <img src="/images/360_img.svg" />
              <span>360</span>
            </Flex>
          </>
        );
    }
  }
  console.log(state)

  return (
    <Box className="caption-medium-12 text-grey-0">
      {getButtonType(type)}
    </Box>
  );
}

export default OptionButton;

const Box = styled.div`
  animation: width 0.5s linear;
  background-color: white;
  width: 52px;
  height: 52px;
  overflow: hidden;
  padding: 10px;
  border-radius: 4px;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
  cursor: pointer;
`;

const Flex = styled.div`
  display: flex;
  gap: 16px;
  align-items: center;
`
