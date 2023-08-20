import React from 'react';
import styled from 'styled-components';
import { priceToString } from '../../../../util/PriceToString';
import { infoPopupBtnProps, infoPopupProps } from './OptionInfoPopupBtn';

function OptionInfoPopup({
  top,
  left,
  setOpenedModalId,
  id,
  name,
  img,
  category,
  price,
}: Pick<infoPopupBtnProps, 'top' | 'left' | 'setOpenedModalId'> &
  infoPopupProps) {
  return (
    <OptionInfoPopupBox top={top} left={left}>
      <OptionInfoPopupImg src={img}></OptionInfoPopupImg>
      <OptionInfoPopupText>
        <div>
          <div className="caption-regular-12 text-grey-400">{category}</div>
          <div className="body-medium-16 text-grey-50">{name}</div>
        </div>
        <div className="head-medium-16">{priceToString(price)}</div>
      </OptionInfoPopupText>
      <OptionInfoPopupIcon
        src="/images/rightArrow_icon_basic.svg"
        onClick={() => {
          setOpenedModalId(id);
        }}
      ></OptionInfoPopupIcon>
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
  z-index: 0;

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
  cursor: pointer;
`;

export default OptionInfoPopup;
