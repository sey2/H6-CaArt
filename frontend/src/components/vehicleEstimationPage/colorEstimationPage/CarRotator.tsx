import React, { useState } from 'react';
import { styled } from 'styled-components';

function CarRotator() {
  const [image, setImage] = useState(1);
  const [prevX, setPrevX] = useState(0);
  const [start, setStart] = useState(false);
  const startSwipe = (event: React.MouseEvent) => {
    if (start) {
      setPrevX(event.clientX);
      if (prevX < event.clientX) {
        if (1 >= image) setImage(60);
        else setImage(prevImage => prevImage - 1);
      }
      if (prevX > event.clientX) {
        if (60 <= image) setImage(1);
        else setImage(prevImage => prevImage + 1);
      }
    }
  };

  return (
    <ImageContainer
      onMouseDown={() => setStart(true)}
      onMouseUp={() => setStart(false)}
      onMouseMove={e => e.preventDefault()}
    >
      <BgTop />
      <BgBottom />
      <Image
        src={`/images/A2B/${String(image).padStart(3, '0')}.png`}
        onMouseMove={startSwipe}
      />
    </ImageContainer>
  );
}

export default CarRotator;

const ImageContainer = styled.div`
  width: 100%;
  height: 100%;
  position: relative;
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

const Image = styled.img`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
`;
