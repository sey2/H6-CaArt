import React from 'react';
import styled from 'styled-components';

function OptionInfoPopup({ top, left }: { top: number; left: number }) {
  return (
    <OptionInfoPopupBox top={top} left={left}>
      <OptionInfoPopupImg src="https://picsum.photos/200/300"></OptionInfoPopupImg>
      <OptionInfoPopupText>
        <div>
          <div className="caption-regular-12 text-grey-400">주행안전</div>
          <div className="body-medium-16 text-grey-50">현대 스마트 센스 I</div>
        </div>
        <div className="head-medium-16">790,000원</div>
      </OptionInfoPopupText>
      <OptionInfoPopupIcon src="/images/rightArrow_icon_basic.svg"></OptionInfoPopupIcon>
    </OptionInfoPopupBox>
  );
}

const OptionInfoPopupBox = styled.div<{ top: number; left: number }>`
  position: absolute;
  top: ${props => `${props.top - 105}px`};
  left: ${props => `${props.left - 126}px`};
  display: flex;
  align-items: center;
  width: 270px;
  height: 96px;
  border-radius: 8px;
  background: var(--grey-1000);
  box-shadow: 1px 1px 4px 1px rgba(0, 0, 0, 0.1);
  z-index: 1;

  ::after {
    content: '';
    position: absolute;
    bottom: 0;
    left: 128px;
    width: 0;
    height: 0;
    border: 13px solid transparent;
    border-top-color: rgba(255, 255, 255, 1);
    border-bottom: 0;
    border-radius: 1px;
    margin-bottom: -6px;
  }
`;

const OptionInfoPopupImg = styled.img`
  width: 72px;
  height: 72px;
  margin-left: 12px;
  margin-right: 8px;
`;

const OptionInfoPopupText = styled.div`
  display: flex;
  flex-direction: column;

  .head-medium-16 {
    color: #2c2c35;
    margin-top: 8px;
  }
`;

const OptionInfoPopupIcon = styled.img`
  width: 24px;
  height: 24px;
  position: absolute;
  top: 36px;
  right: 8px;
`;

export { OptionInfoPopup };
