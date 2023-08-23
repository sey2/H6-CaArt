import React from 'react';
import styled from 'styled-components';
import { truncateString } from '../../../../util/TruncateString';
import { SubOptionProps } from '../optionCardList/OptionCardList';

interface OptionModalDetailProps {
  options: SubOptionProps[];
  optionNum: number;
  setOptionNum: React.Dispatch<React.SetStateAction<number>>;
}

function OptionModalDetail({
  options,
  optionNum,
  setOptionNum,
}: OptionModalDetailProps) {
  const selectedClassName = 'body-medium-14 text-secondary-active-blue';
  const basicClassName = 'body-regular-14 text-grey-400';

  const detailNameList = options.map((item, index) => {
    return (
      <span
        key={index * 101}
        className={index === optionNum ? selectedClassName : basicClassName}
        onClick={() => {
          setOptionNum(index);
        }}
      >
        {truncateString(item.optionName, 12)}
      </span>
    );
  });

  const detailBtnList = options.map((item, index) => {
    return (
      <OptionModalDetailBtn
        key={index * 102}
        selected={index === optionNum}
        onClick={() => {
          setOptionNum(index);
        }}
      ></OptionModalDetailBtn>
    );
  });

  return (
    <OptionModalDetailBox>
      <OptionModalDetailListBox>{detailNameList}</OptionModalDetailListBox>
      <OptionModalDetailBtnBox>{detailBtnList}</OptionModalDetailBtnBox>
    </OptionModalDetailBox>
  );
}

const OptionModalDetailBox = styled.div`
  padding-top: 15px;
  padding-left: 28px;
  width: 344px;
  height: 190px;
`;

const OptionModalDetailListBox = styled.div`
  display: flex;
  flex-wrap: wrap;
  width: 314px;
  gap: 10px;

  span {
    width: 45%;
    cursor: pointer;
  }

  span:hover {
    color: var(--secondary-active-blue);
  }
`;

const OptionModalDetailBtnBox = styled.div`
  position: absolute;
  bottom: -30px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  gap: 8px;
  padding-top: 15px;
`;

const OptionModalDetailBtn = styled.div<{ selected: boolean }>`
  width: 16px;
  height: 16px;
  border-radius: 50%;
  cursor: pointer;
  background: ${props =>
    props.selected ? `var(--secondary-active-blue)` : `var(--grey-700)`};

  &:hover {
    background: var(--secondary-active-blue);
    opacity: 0.6;
  }
`;

export default OptionModalDetail;
