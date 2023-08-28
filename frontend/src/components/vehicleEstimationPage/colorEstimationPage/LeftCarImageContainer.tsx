import React, { useCallback, useContext, useEffect } from 'react';
import styled from 'styled-components';
import OptionButton from './button/OptionButton';
import CarRotator from './CarRotator';
import RerecommendButton from '../trimEstimationPage/RerecommendButton';
import RerecommendModal from '../trimEstimationPage/modal/RerecommendModal';
import { EstimationContext } from '../../../store/Context';
import { CarData } from '../../../pages/vehicleEstimationPage/ColorEstimationPage';

type ViewOptionType = 'ex' | 'in' | '360' | string;

interface CarContainerType {
  type: ViewOptionType;
  setter: React.Dispatch<React.SetStateAction<ViewOptionType>>;
  data: CarData;
}

function LeftCarImageContainer({ type, setter, data }: CarContainerType) {
  const { currentEstimation, setTrimInteriorImage } =
    useContext(EstimationContext)!;

  const exView = useCallback(() => {
    return (
      <>
        <BgTop />
        <BgBottom />
        <Image src={currentEstimation.trim.img} width={646} height={366} />
      </>
    );
  }, [currentEstimation.trim]);

  const inView = useCallback(() => {
    return (
      <>
        <Image
          src={currentEstimation.trimInteriorImage}
          width="100%"
          height="100%"
        />
      </>
    );
  }, [currentEstimation.trimInteriorImage]);

  const rotateView = useCallback(() => {
    return <CarRotator data={data.exteriorColors} />;
  }, [data]);

  const drawView = useCallback(
    (type: ViewOptionType) => {
      switch (type) {
        case 'ex':
          return exView();
        case 'in':
          return inView();
        case '360':
          return rotateView();
        default:
      }
    },
    [exView, inView, rotateView],
  );

  useEffect(() => {
    const interData = data.interiorColors.find(
      item => item.colorName === currentEstimation.interiorColor.name,
    );
    setTrimInteriorImage(interData?.preview as string);
    document.querySelector('.imageWrapper')?.classList.remove('imageWrapper');
  }, []);
  return (
    <Wrapper className="imageWrapper">
      <RerecommendButton />
      <RerecommendModal />
      <TypeBox>
        <OptionButton type="ex" state={type} setter={setter} />
        <OptionButton type="in" state={type} setter={setter} />
        {type !== 'in' && (
          <OptionButton type="360" state={type} setter={setter} />
        )}
      </TypeBox>
      {drawView(type)}
    </Wrapper>
  );
}

export default React.memo(LeftCarImageContainer);

const Wrapper = styled.div`
  height: calc(100vh - 120px);
  overflow: hidden;
  position: relative;
  transition: opacity 2s;
  &.imageWrapper {
    opacity: 0;
  }
`;

const TypeBox = styled.div`
  position: absolute;
  top: 96px;
  left: 128px;
  display: flex;
  flex-direction: column;
  gap: 8px;
  z-index: 5;
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
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
`;
