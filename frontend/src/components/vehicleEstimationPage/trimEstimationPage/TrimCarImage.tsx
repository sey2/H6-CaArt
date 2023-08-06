import React from 'react';
import { styled } from 'styled-components';

function TrimCarImage() {
  return (
    <Wrapper>
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

const Image = styled.img`
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
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
