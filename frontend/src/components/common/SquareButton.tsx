import React from 'react';
import styled from 'styled-components';

interface buttonOption {
  size: 'xl' | 'l' | 'xm' | 'm' | 's' | 'xs' | 'xxs' | 'ms' | 'mms' | 'auto';
  height?: number | undefined;
  color:
    | 'grey-900'
    | 'primary-blue'
    | 'grey-1000'
    | 'grey-400'
    | 'grey-200'
    | 'grey-50';
  bg?: 'grey-1000' | 'primary-blue';
  children: React.ReactNode;
  border?: boolean;
  onClick?: () => void;
  className?: string;
}

function calcWidth(size: string) {
  switch (size) {
    case 'xl':
      return 608;
    case 'l':
      return 363;
    case 'xm':
      return 309;
    case 'm':
      return 298;
    case 'ms':
      return 186;
    case 'mms':
      return 178;
    case 's':
      return 168;
    case 'xs':
      return 150;
    case 'xxs':
      return 120;
    case 'auto':
      return 'auto';
    default:
      return 'auto';
  }
}

function SquareButton(props: buttonOption) {
  return (
    <Button
      className="body-medium-16"
      size={props.size}
      color={props.color}
      bg={props.bg}
      border={props.border}
      height={props.height}
      onClick={props.onClick}
    >
      {props.children}
    </Button>
  );
}

export default SquareButton;

const Button = styled.button<buttonOption>`
  height: ${props =>
    props.height !== undefined ? `${props.height}px` : `52px`};
  display: flex;
  justify-content: center;
  align-items: center;
  flex-shrink: 0;
  border-radius: 6px;
  width: ${props => calcWidth(props.size)}px;
  color: var(--${props => props.color});
  background-color: ${props =>
    props.bg !== undefined ? `var(--${props.bg})` : 'transparent'};
  ${props => props.border && `border: 1px solid var(--grey-600)`};
  cursor: pointer;
`;
