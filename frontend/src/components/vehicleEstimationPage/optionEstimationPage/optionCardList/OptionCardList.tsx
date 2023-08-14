import React, { useContext, useState } from 'react';
import styled from 'styled-components';
import OptionCard, {
  OptionCardProps,
  OptionCardType,
} from '../optionCard/OptionCard';
import { EstimationContext } from '../../../../util/Context';

interface OptionCardListProps {
  options: OptionCardProps[];
  type: OptionCardType;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}

function OptionCardList({
  options,
  type,
  setOpenedModalId,
}: OptionCardListProps) {
  const { currentEstimation } = useContext(EstimationContext)!;
  const [page, setPage] = useState(0);
  const cardPerPage = type === 'basic' ? 12 : 8;
  const maxPageNum = Math.ceil(options.length / cardPerPage);
  const startIndex = page * cardPerPage;
  const endIndex =
    startIndex + cardPerPage <= options.length
      ? startIndex + cardPerPage
      : options.length;
  const targetArr = options.slice(startIndex, endIndex);

  const optionCardListShow = targetArr.map(item => {
    return (
      <OptionCard
        key={item.id}
        data={item}
        type={type}
        selected={
          currentEstimation.options.findIndex(
            option => option.name === item.name,
          ) !== -1
        }
        setOpenedModalId={setOpenedModalId}
      ></OptionCard>
    );
  });

  const OptionMoveBtnList = () => {
    const buttons = [];
    const btnStartIndex = Math.floor(page / 5) * 5;
    const btnEndIndex = Math.min(btnStartIndex + 4, maxPageNum);
    for (let i = btnStartIndex; i < btnEndIndex; i++) {
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

  const OptionMoveBtn = (
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
  );

  return (
    <OptionCardListAdditionalAllBox>
      <TotalOptionNumber>
        <span className="body-medium-16 text-grey-300">전체</span>
        <span className="body-medium-16 text-secondary-active-blue">
          {options.length}
        </span>
      </TotalOptionNumber>
      <OptionCardListBox>{optionCardListShow}</OptionCardListBox>
      {maxPageNum > 1 && OptionMoveBtn}
    </OptionCardListAdditionalAllBox>
  );
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

export default OptionCardList;
