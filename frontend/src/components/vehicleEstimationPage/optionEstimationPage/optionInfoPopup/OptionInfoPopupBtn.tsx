import React, { useState } from 'react';
import styled from 'styled-components';
import OptionInfoPopup, { InfoPopupProps } from './OptionInfoPopup';

function OptionInfoPopupBtn({
  option,
  clickedPlusBtn,
  setClickecPlusBtn,
  setOpenedModalId,
}: InfoPopupProps) {
  const [isHover, setIsHover] = useState(false);

  return (
    <>
      <OptionInfoPopupBtnBox
        top={option.top}
        left={option.left}
        selected={clickedPlusBtn === option.id || isHover}
        onMouseEnter={() => {
          setIsHover(true);
        }}
        onMouseLeave={() => {
          setIsHover(false);
        }}
        onClick={() => {
          if (option.id !== clickedPlusBtn) {
            setClickecPlusBtn(option.id);
          } else {
            setClickecPlusBtn(-1);
          }
        }}
      >
        <img src="/images/plus_icon_white.svg"></img>
      </OptionInfoPopupBtnBox>
      {(clickedPlusBtn === option.id || isHover) && (
        <OptionInfoPopup
          option={option}
          setOpenedModalId={setOpenedModalId}
        ></OptionInfoPopup>
      )}
    </>
  );
}

const OptionInfoPopupBtnBox = styled.div<{
  top: number;
  left: number;
  selected?: boolean;
}>`
  position: absolute;
  top: ${props => `${props.top}px`};
  left: ${props => `${props.left}px`};
  width: 28px;
  height: 28px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: ${props =>
    props.selected ? 'rgba(33, 151, 201, 0.72)' : 'rgba(172, 184, 200, 0.72)'};

  img {
    width: 18.667px;
    height: 18.667px;
  }
`;

export default OptionInfoPopupBtn;
