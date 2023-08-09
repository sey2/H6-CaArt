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
      <img src={`/images/A2B/${image}.png`} onMouseMove={startSwipe} />
    </ImageContainer>
  );
}

export default CarRotator;

const ImageContainer = styled.div``;
