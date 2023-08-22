import React from 'react';
import { styled } from 'styled-components';

interface OptionCardListButtonProps {
  page: number;
  maxPage: number;
  pageMoveHandler: (page: 'right' | 'left' | number) => void;
}

function OptionCardListButton({
  page,
  maxPage,
  pageMoveHandler,
}: OptionCardListButtonProps) {
  const OptionMoveBtnList = () => {
    const buttons = [];
    const btnStartIndex = Math.floor(page / 5) * 5;
    const btnEndIndex = Math.min(btnStartIndex + 5, maxPage);
    for (let i = btnStartIndex; i < btnEndIndex; i++) {
      buttons.push(
        <OptionCardPageMoveBtn
          key={i * 111}
          $current={i === page}
          onClick={() => {
            pageMoveHandler(i);
          }}
        >
          {i + 1}
        </OptionCardPageMoveBtn>,
      );
    }
    return buttons;
  };

  return (
    <OptionCardPageMoveBtnBox>
      <img
        src="/images/leftArrow_icon_basic.svg"
        onClick={() => {
          pageMoveHandler('left');
        }}
      ></img>
      <div className="btn_list">{OptionMoveBtnList()}</div>
      <img
        src="/images/rightArrow_icon_basic.svg"
        onClick={() => {
          pageMoveHandler('right');
        }}
      ></img>
    </OptionCardPageMoveBtnBox>
  );
}

const OptionCardPageMoveBtnBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  margin-top: 20px;

  .btn_list {
    display: flex;
  }

  img {
    cursor: pointer;
  }
`;

const OptionCardPageMoveBtn = styled.div<{ $current: boolean }>`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 36px;
  height: 36px;
  border-radius: 50%;
  background: ${props =>
    props.$current ? `var(--grey-700)` : ` var(--grey-1000)`};
  cursor: pointer;
`;

export default OptionCardListButton;
