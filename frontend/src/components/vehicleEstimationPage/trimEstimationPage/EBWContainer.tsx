import React, { useContext, useEffect } from 'react';
import styled from 'styled-components';
import EBWButton from './EBWButton';
import { EstimationContext } from '../../../store/Context';
import { FlexBox } from '../../common/FlexBox';
import { useModalContext } from '../../../store/ModalContext';
import { preloadContext } from '../../../store/PreloadContext';
import { PreloadProps } from '../../../pages/vehicleEstimationPage/VehicleEstimationPage';

function EBWContainer() {
  const { setEngine, setBody, setWd } = useContext(EstimationContext)!;
  const { dispatch } = useModalContext();
  const { preloadImages } = useContext<PreloadProps | null>(preloadContext)!;

  function handleButtonClick(value: string, price: number) {
    switch (value) {
      case '디젤 2.2':
      case '가솔린 3.8':
        setEngine({ name: value, price: price });
        break;

      case '7인승':
      case '8인승':
        setBody({ name: value, price: price });
        break;

      case '2WD':
      case '4WD':
        setWd({ name: value, price: price });
        break;
      default:
        break;
    }
  }

  function calcPosition(target: Element | null | undefined) {
    const rect = target?.getBoundingClientRect() as DOMRect;
    const y = rect.left - 20;
    let x;
    if (target?.innerHTML !== '엔진') {
      x = rect.top - 88;
    } else {
      x = rect.top - 78;
    }
    return { x, y };
  }

  function findSpan(e: React.MouseEvent) {
    e.stopPropagation();
    const target = e.target as HTMLElement;
    const spanElement =
      target.parentElement?.parentElement?.previousElementSibling;
    dispatch({
      type: 'SET_TOOLTIP_TYPE',
      tooltipType: spanElement?.innerHTML as string,
    });
    const { x, y } = calcPosition(spanElement);
    dispatch({ type: 'SET_TOOLTIP_POSITION', position: { x: x, y: y } });
    dispatch({ type: 'OPEN_TOOLTIP_MODAL' });
  }

  useEffect(() => {
    const spanElement = document.querySelector('.engine');
    const { x, y } = calcPosition(spanElement);
    dispatch({ type: 'SET_TOOLTIP_POSITION', position: { x: x, y: y } });
    dispatch({ type: 'OPEN_TOOLTIP_MODAL' });
  }, []);

  return (
    <>
      <Box className="body-medium-14 text-grey-200">
        <FlexBox $direction="column">
          <Title className="engine">엔진</Title>
          <ButtonBox
            onClick={e => {
              findSpan(e);
            }}
            onMouseOver={preloadImages}
          >
            <EBWButton
              value="디젤 2.2"
              price={1480000}
              onClick={handleButtonClick}
            />
            <EBWButton
              value="가솔린 3.8"
              price={0}
              onClick={handleButtonClick}
            />
          </ButtonBox>
        </FlexBox>
        <FlexBox $direction="column">
          <Title>바디</Title>
          <ButtonBox
            onClick={e => {
              findSpan(e);
            }}
            onMouseOver={preloadImages}
          >
            <EBWButton value="7인승" price={0} onClick={handleButtonClick} />
            <EBWButton value="8인승" price={0} onClick={handleButtonClick} />
          </ButtonBox>
        </FlexBox>
        <FlexBox $direction="column">
          <Title>구동방식</Title>
          <ButtonBox
            onClick={e => {
              findSpan(e);
            }}
            onMouseOver={preloadImages}
          >
            <EBWButton value="2WD" price={0} onClick={handleButtonClick} />
            <EBWButton
              value="4WD"
              price={2370000}
              onClick={handleButtonClick}
            />
          </ButtonBox>
        </FlexBox>
      </Box>
    </>
  );
}

export default EBWContainer;

const Box = styled.div`
  position: relative;
  width: 309px;
  flex-shrink: 0;
  border-radius: 8px;
  border: 1px solid var(--grey-700);
  padding: 12px;
  display: flex;
  flex-direction: column;
  gap: 12px;
`;

const ButtonBox = styled.div`
  display: flex;
`;

const Title = styled.span`
  margin-bottom: 4px;
`;
