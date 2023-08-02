import React, { useState } from 'react';
import styled from 'styled-components';

const TOOLTIP_MESSAGE = {
  engine: '디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요.',
  body: '7인승의 경우 2열의 가운데에 시트가 없어 통행이 편하고 8인승의 경우 2열 가운데에 시트가 존재해요.',
  method:
    '2WD는 두개의 모터로 구성되어 가볍고 효율이 좋고 4WD는 네개의 모터로 구성되어 주행 안정성이 높아요.',
};

function getToolTipMessage(type: string) {
  switch (type) {
    case 'engine':
      return TOOLTIP_MESSAGE.engine;
    case 'body':
      return TOOLTIP_MESSAGE.body;
    case 'method':
      return TOOLTIP_MESSAGE.method;
    default:
      return TOOLTIP_MESSAGE.engine;
  }
}

function ToolTip() {
  const [tooltipType, setTooltipType] = useState<string>('engine');
  const text = getToolTipMessage(tooltipType);

  return (
    <>
    <button onClick={()=>setTooltipType('body')}>바디</button>
      <BubbleBox>
        <img src="/images/tooltip_icon.svg" />
        <p className="body-regular-14 text-grey-900">{text}</p>
      </BubbleBox>
    </>
  );
}

export default ToolTip;

const BubbleBox = styled.div`
  position: relative;
  display: flex;
  padding: 12px 14px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  border-radius: 8px;
  width: 281px;
  background-color: #2e3d51;
  color: var(--gray-900);
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
