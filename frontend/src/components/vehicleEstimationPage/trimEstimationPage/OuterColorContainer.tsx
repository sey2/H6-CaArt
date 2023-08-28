import React from 'react';
import { styled } from 'styled-components';
import { FlexBox } from '../../common/FlexBox';
import colorSet from '../../../static/data/ColorSet';

function OuterColorContainer({ carType }: { carType: string }) {
  function setColor() {
    const color = colorSet[carType as keyof typeof colorSet];
    return color.map(item => <Circle key={item} bgColor={item} />);
  }

  return <FlexBox $gap={8}>{setColor()}</FlexBox>;
}

export default OuterColorContainer;

const Circle = styled.div<{ bgColor: string }>`
  width: 16px;
  height: 16px;
  border-radius: 50%;
  background-color: ${props => props.bgColor};
`;
