import React from 'react';
import { styled } from 'styled-components';

interface ColorButton {
  src: string,
  selected?: boolean
}

function ColorButton(props: ColorButton) {
  return <Button src={props.src} selected={props.selected}/>;
}

export default ColorButton;

const Button = styled.img<{ selected?: boolean }>`
  width: 68px;
  height: 68px;
  flex-shrink: 0;
  border-radius: 4px;
  ${props => props.selected && `opacity: 0.4`};
  cursor: pointer;
`;
