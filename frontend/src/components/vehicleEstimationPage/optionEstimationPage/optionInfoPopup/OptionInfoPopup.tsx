import React from 'react';
import styled from 'styled-components';
import { priceToString } from '../../../../util/PriceToString';
import { truncateString } from '../../../../util/TruncateString';

export interface InfoPopupProps {
  option: {
    top: number;
    left: number;
    id: number;
    name: string;
    img: string;
    category: string;
    price: number;
  };
  clickedPlusBtn: number;
  setClickecPlusBtn: React.Dispatch<React.SetStateAction<number>>;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}

function OptionInfoPopup({
  option,
  setOpenedModalId,
}: Pick<InfoPopupProps, 'option' | 'setOpenedModalId'>) {
  return (
    <OptionInfoPopupBox top={option.top} left={option.left}>
      <OptionInfoPopupImg src={option.img}></OptionInfoPopupImg>
      <OptionInfoPopupText>
        <div>
          <div className="caption-regular-12 text-grey-400">
            {option.category}
          </div>
          <div className="body-medium-16 text-grey-50">
            {truncateString(option.name, 12)}
          </div>
        </div>
        <div className="head-medium-16 text-grey-100">
          {priceToString(option.price)}
        </div>
      </OptionInfoPopupText>
      <OptionInfoPopupIcon
        src="/images/rightArrow_icon_basic.svg"
        onClick={() => {
          setOpenedModalId(option.id);
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
  z-index: 1;

  ::after {
    content: '';
    position: absolute;
    bottom: 0;
    left: 128px;
    width: 0;
    height: 0;
    border: 13px solid transparent;
    border-top-color: var(--grey-1000);
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
