import React from 'react';
import { useLottie } from 'lottie-react';
import { styled } from 'styled-components';
import loadingAnimation from '../../static/data/loading.json';

function Loading() {
  const options = {
    animationData: loadingAnimation,
    loop: true,
  };

  const { View } = useLottie(options);
  return <LoadingBox>{View}</LoadingBox>;
}

const LoadingBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
`;

export default Loading;
