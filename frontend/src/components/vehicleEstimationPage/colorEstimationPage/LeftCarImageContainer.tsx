import React, { useContext } from 'react';
import styled from 'styled-components';
import OptionButton from './button/OptionButton';
import CarRotator from './CarRotator';
import RerecommendButton from '../trimEstimationPage/RerecommendButton';
import RerecommendModal from '../trimEstimationPage/RerecommendModal';
import { EstimationContext } from '../../../util/Context';
import { ExteriorColor } from "../../../pages/vehicleEstimationPage/ColorEstimationPage";

type ViewOptionType = 'ex' | 'in' | '360' | string;

interface CarContainerType {
  type: ViewOptionType;
  state: ViewOptionType;
  setter: React.Dispatch<React.SetStateAction<ViewOptionType>>;
  data: ExteriorColor[];
}

function LeftCarImageContainer({ type, setter, state,data }: CarContainerType) {
  const { currentEstimation } = useContext(EstimationContext)!;
  function drawView(type: ViewOptionType) {
    switch (type) {
      case 'ex':
        return exView();
      case 'in':
        return inView();
      case '360':
        return rotateView();
      default:
    }
  }

  function exView() {
    return (
      <>
        <BgTop />
        <BgBottom />
        <Image src={currentEstimation.trim.img} width={646} height={366} />
      </>
    );
  }

  function inView() {
    return (
      <>
        <Image
          src={currentEstimation.trimInteriorImage}
          width="100%"
          height="100%"
        />
      </>
    );
  }

  function rotateView() {
    return <CarRotator data={data}/>;
  }

  return (
    <Wrapper>
      <RerecommendButton />
      {<RerecommendModal />}
      <TypeBox>
        <OptionButton type="ex" state={state} setter={setter} />
        <OptionButton type="in" state={state} setter={setter} />
        {state !== 'in' && (
          <OptionButton type="360" state={state} setter={setter} />
        )}
      </TypeBox>
      {drawView(type)}
    </Wrapper>
  );
}

export default LeftCarImageContainer;

const Wrapper = styled.div`
  height: calc(100vh - 120px);
  overflow: hidden;
  position: relative;
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
