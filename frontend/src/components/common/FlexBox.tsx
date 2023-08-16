import React from 'react';
import { styled } from 'styled-components';

interface FlexProps {
  display?: string;
  wrap?: 'wrap';
  direction?: string;
  gap?: number;
  width?: number;
  height?: number;
  justify?: string;
  align?: string;
  children: React.ReactNode;
  className?: string;
  margin?: string;
  onClick?: () => void;
}

function FlexBox({
  display,
  wrap,
  direction,
  gap,
  width,
  height,
  justify,
  align,
  className,
  margin,
  onClick,
  children,
}: FlexProps) {
  return (
    <SFlex
      display={display}
      wrap={wrap}
      direction={direction}
      gap={gap}
      width={width}
      height={height}
      justify={justify}
      align={align}
      className={className}
      margin={margin}
      onClick={onClick}
    >
      {children}
    </SFlex>
  );
}

export { FlexBox, SFlex };

const SFlex = styled.div<FlexProps>`
  display: ${props => props.display || 'flex'};
  flex-direction: ${props => props.direction || 'row'};
  gap: ${props => (props.gap ? `${props.gap}px` : '0')};
  width: ${props => (props.width ? `${props.width}px` : 'auto')};
  height: ${props => (props.height ? `${props.height}px` : 'auto')};
  justify-content: ${props => props.justify || 'flex-start'};
  align-items: ${props => props.align || 'stretch'};
  flex-wrap: ${props => props.wrap || 'nowrap'};
  margin: ${props => (props.margin ? props.margin : '0px 0px 0px 0px')};
`;
