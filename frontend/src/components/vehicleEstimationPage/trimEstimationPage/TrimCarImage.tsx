import React, { useState } from 'react';
import { keyframes, styled } from 'styled-components';
import RerecommendButton from './RerecommendButton';
import RerecommendModal from './RerecommendModal';

function TrimCarImage() {
  const [reRecommendModal, setReRecommendModal] = useState(false);

  return (
    <Wrapper>
      <RerecommendButton setter={setReRecommendModal} />
      {<RerecommendModal setter={setReRecommendModal} isOpen={reRecommendModal} />}
      <BgTop />
      <BgBottom />
      <Image src="images/car.png" width={646} height={366} />
    </Wrapper>
  );
}

export default TrimCarImage;

const Wrapper = styled.div`
  height: calc(100vh - 120px);
  overflow: hidden;
  position: relative;
  
`;

const move = keyframes`
  0%{
    left:70%;
    opacity:0.2;
  }
  100%{
    left:50%;
    opacity:1;
  }
`;

const Image = styled.img`
  position: absolute;
  transform: translate(-50%, -50%);
  animation: ${move} 1s;
  transition: ${move} 1s ease-in;
  left: 50%;
  top: 50%;
`;

const BgTop = styled.div`
  background: rgba(0, 66, 142, 0.1);
  height: 370px;
`;
const BgBottom = styled.div`
  background: linear-gradient(
    180deg,
    rgba(0, 66, 142, 0.3) 0%,
    rgba(255, 255, 255, 0) 100%
  );
  height: 316px;
`;
