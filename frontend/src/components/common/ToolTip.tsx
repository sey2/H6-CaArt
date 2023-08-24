import React from 'react';
import styled from 'styled-components';
import { useModalContext } from '../../store/ModalContext';

const TOOLTIP_MESSAGE = {
  엔진: '디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요.',
  바디: '7인승의 경우 2열의 가운데에 시트가 없어 통행이 편하고 8인승의 경우 2열 가운데에 시트가 존재해요.',
  구동방식:
    '2WD는 두개의 모터로 구성되어 가볍고 효율이 좋고 4WD는 네개의 모터로 구성되어 주행 안정성이 높아요.',
  트림: '트림은 등급이에요. 등급이 올라갈수록 기본 포함 옵션들이 점점 추가되고 내부 시트의 퀄리티가 높아져요.',
};

function getToolTipMessage(type: string | undefined) {
  return TOOLTIP_MESSAGE[type as keyof typeof TOOLTIP_MESSAGE];
}

function ToolTip() {
  const { state } = useModalContext();
  const text = getToolTipMessage(state.tooltipType);
  return (
    <>
      <BubbleBox
        top={state.tooltipPosition.x}
        left={state.tooltipPosition.y}
        onClick={e => e.stopPropagation()}
        $isopen={state.tooltipOpen}
      >
        <img src="/images/tooltip_icon.svg" />
        <p className="body-regular-14">{text}</p>
      </BubbleBox>
    </>
  );
}

export default ToolTip;

const BubbleBox = styled.div<{ top: number; left: number; $isopen: boolean }>`
  position: absolute;
  display: flex;
  top: ${props => props.top + 55}px;
  left: ${props => props.left - 281}px;
  padding: 12px 14px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  border-radius: 8px;
  width: 281px;
  background-color: #2e3d51;
  color: #fbfbfb;
  z-index: 10;
  transition: all 0.3s;
  visibility: hidden;
  opacity: 0;
  ${props => props.$isopen && `visibility:visible;opacity:1;`};
  ::after {
    content: '';
    position: absolute;
    bottom: 50%;
    right: -18px;
    width: 0;
    height: 0;
    border: 13px solid transparent;
    border-top-color: #2e3d51;
    border-bottom: 0;
    border-radius: 1px;
    margin-bottom: -6px;
    transform: rotate(-90deg);
  }
`;
