import React, { useState, useEffect, useContext } from 'react';
import { styled } from 'styled-components';
import { ExteriorColor } from '../../../pages/vehicleEstimationPage/ColorEstimationPage';
import { EstimationContext } from '../../../util/Context';

function CarRotator({ data }: { data: ExteriorColor[] }) {
  const { currentEstimation } = useContext(EstimationContext)!;
  const [image, setImage] = useState(1);
  const [prevX, setPrevX] = useState(0);
  const [start, setStart] = useState(false);
  const [baseUrl, setBaseUrl] = useState('');
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

  useEffect(() => {
    if (data) {
      const nowItem = data.find(
        item => item.colorName === currentEstimation.outerColor.name,
      );
      setBaseUrl(nowItem?.previews[0] as string);
    }
  }, [currentEstimation.outerColor.name, data]);

  return (
    <ImageContainer
      onMouseDown={() => setStart(true)}
      onMouseUp={() => setStart(false)}
      onMouseMove={e => e.preventDefault()}
    >
      <BgTop />
      <BgBottom />

      <Image
        src={`${baseUrl.slice(0, -8)}${String(image).padStart(3, '0')}.webp`}
        onMouseMove={startSwipe}
      />
      <RotateCircle src="/images/rotate_circle.png" />
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
  width: 656px;
  height: 366px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
`;

const RotateCircle = styled.img`
  z-index: 1;
  position: absolute;
  top: 63%;
  left: 50%;
  transform: translate(-50%, -50%);
`;
