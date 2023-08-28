import React from 'react';
import { useLottie } from 'lottie-react';
import { styled } from 'styled-components';
import loadingAnimation from '../../static/data/loading.json';

interface LoadingProps {
  $height: string;
  $width: string;
}

function Loading({ $height, $width }: LoadingProps) {
  const options = {
    animationData: loadingAnimation,
    loop: true,
  };

  const { View } = useLottie(options);
  return (
    <LoadingBox $height={$height} $width={$width}>
      {View}
    </LoadingBox>
  );
}

const LoadingBox = styled.div<LoadingProps>`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;

  div {
    width: ${props => props.$width};
    height: ${props => props.$height};
  }
`;

export default Loading;
