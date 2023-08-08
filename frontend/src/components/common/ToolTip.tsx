import React from 'react';
import styled from 'styled-components';

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

function ToolTip({
  tooltipType,
  x,
  y,
}: {
  tooltipType: string | undefined;
  x: number;
  y: number;
}) {
  const text = getToolTipMessage(tooltipType);

  return (
    <>
      <BubbleBox top={x} left={y} onClick={e => e.stopPropagation()}>
        <img src="/images/tooltip_icon.svg" />
        <p className="body-regular-14 text-grey-900">{text}</p>
      </BubbleBox>
    </>
  );
}

export default ToolTip;

const BubbleBox = styled.div<{ top: number; left: number }>`
  position: absolute;
  display: flex;
  top: ${props => props.top}px;
  left: ${props => props.left}px;
  padding: 12px 14px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  border-radius: 8px;
  width: 281px;
  background-color: #2e3d51;
  color: var(--gray-900);
  z-index: 10;
  ::after {
    content: '';
    position: absolute;
    bottom: 0;
    left: 20px;
    width: 0;
    height: 0;
    border: 13px solid transparent;
    border-top-color: #2e3d51;
    border-bottom: 0;
    border-radius: 1px;
    margin-bottom: -6px;
  }
`;
