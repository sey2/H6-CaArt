import React from 'react';
import { styled } from 'styled-components';

interface HrProps {
  width?: number;
  height?: number;
  color?: string;
  margin?: string;
}

function Hr({ width, height, color, margin }: HrProps) {
  return <SHr width={width} height={height} color={color} margin={margin} />;
}

export { Hr, SHr };

const SHr = styled.div<HrProps>`
  width: ${props => (props.width ? `${props.width}px` : 'auto')};
  height: ${props => (props.height ? `${props.height}px` : '1px')};
  background: ${props =>
    props.color ? `var(--${props.color})` : 'var(--primary-blue-10)'};
  margin: ${props => (props.margin ? props.margin : '0px 0px 0px 0px')};
  flex-shrink: 0;
`;
