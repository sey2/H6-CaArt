import React, { useState } from 'react';
import styled from 'styled-components';
import { OptionCard, OptionCardProps } from '../optionCard/OptionCard';

function OptionCardListAdditionalAll({ options }: OptionCardListProps) {
  const [page, setPage] = useState(0);
  const maxPageNum = Math.ceil(options.length / 8);
  const startIndex = page * 8;
  const endIndex =
    page * 8 + 8 <= options.length ? page * 8 + 8 : options.length;
  const targetArr = options.slice(startIndex, endIndex);

  const optionCardList = targetArr.map(item => {
    return <OptionCard key={item.id} data={item}></OptionCard>;
  });

  const OptionMoveBtnList = () => {
    const buttons = [];
    for (let i = 0; i < maxPageNum; i++) {
      buttons.push(
        <OptionCardPageMoveBtn
          key={i}
          index={i}
          page={page}
          onClick={() => setPage(i)}
        >
          {i + 1}
        </OptionCardPageMoveBtn>,
      );
    }
    return buttons;
  };

  return (
    <OptionCardListAdditionalAllBox>
      <TotalOptionNumber>
        <span className="body-medium-16 text-grey-300">전체</span>
        <span className="body-medium-16 text-secondary-active-blue">
          {options.length}
        </span>
      </TotalOptionNumber>
      <OptionCardListBox>{optionCardList}</OptionCardListBox>
      <OptionCardPageMoveBtnBox>
        <img
          src="/images/leftArrow_icon_basic.svg"
          onClick={() => {
            setPage(page === 0 ? 0 : page - 1);
          }}
        ></img>
        <div className="btn_list">{OptionMoveBtnList()}</div>
        <img
          src="/images/rightArrow_icon_basic.svg"
          onClick={() => {
            setPage(page === maxPageNum - 1 ? maxPageNum - 1 : page + 1);
          }}
        ></img>
      </OptionCardPageMoveBtnBox>
    </OptionCardListAdditionalAllBox>
  );
}

interface OptionCardListProps {
  options: OptionCardProps[];
}

const OptionCardListAdditionalAllBox = styled.div`
  display: flex;
  width: 100%;
  flex-direction: column;
`;

const OptionCardListBox = styled.div`
  display: inline-flex;
  align-items: flex-start;
  gap: 16px;
  flex-wrap: wrap;
  margin-left: 128px;

  > div {
    margin-bottom: 44px;
  }
`;

const TotalOptionNumber = styled.div`
  display: flex;
  margin-top: 19px;
  margin-bottom: 16px;
  margin-left: 128px;
  gap: 5px;
`;

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

const OptionCardPageMoveBtn = styled.div<{ index: number; page: number }>`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 36px;
  height: 36px;
  border-radius: 50%;
  background: ${props =>
    props.page == props.index ? `var(--grey-700)` : ` var(--grey-1000)`};
  cursor: pointer;
`;

export { OptionCardListAdditionalAll };
