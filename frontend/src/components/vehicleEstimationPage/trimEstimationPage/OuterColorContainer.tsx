import React from 'react';
import { styled } from 'styled-components';
import { FlexBox } from "../../common/FlexBox";

function OuterColorContainer({ carType }: { carType: string }) {
  const colorSet = {
    Exclusive: [
      '#121212',
      '#979999',
      '#171D2F',
      '#292622',
      '#313433',
      '#F2F4F3',
    ],
    'Le Blanc': [
      '#121212',
      '#979999',
      '#171D2F',
      '#292622',
      '#313433',
      '#F2F4F3',
    ],
    Prestige: [
      '#121212',
      '#979999',
      '#171D2F',
      '#292622',
      '#313433',
      '#F2F4F3',
    ],
    Calligraphy: [
      '#121212',
      '#A1A3A2',
      '#142419',
      '#181F30',
      '#2C2925',
      '#3C3F3E',
      '#F1F2F3',
    ],
  };

  function setColor() {
    const color = colorSet[carType as keyof typeof colorSet];
    return color.map(item => <Circle key={item} bgColor={item} />);
  }

  return <FlexBox gap={8}>{setColor()}</FlexBox>;
}

export default OuterColorContainer;

const Circle = styled.div<{ bgColor: string }>`
  width: 16px;
  height: 16px;
  border-radius: 50%;
  background-color: ${props=> props.bgColor};
`;
