import React from 'react';
import styled from 'styled-components';

function OptionModalDetail({
  options,
  optionNum,
  setOptionNum,
}: {
  options: OptionSetProps[];
  optionNum: number;
  setOptionNum: React.Dispatch<React.SetStateAction<number>>;
}) {
  const selectedClassName = 'body-medium-14 text-secondary-active-blue';
  const basicClassName = 'body-regular-14 text-grey-400';

  const detailNameList = options.map((item, index) => {
    return (
      <span
        key={index}
        className={index === optionNum ? selectedClassName : basicClassName}
        onClick={() => {
          setOptionNum(index);
        }}
      >
        {item.name}
      </span>
    );
  });

  const detailBtnList = options.map((item, index) => {
    return (
      <OptionModalDetailBtn
        key={index}
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

export interface OptionSetProps {
  name: string;
  description: string;
  img: string;
}

const OptionModalDetailBox = styled.div`
  padding-top: 28px;
  padding-left: 28px;
  width: 344px;
  height: 190px;
`;

const OptionModalDetailListBox = styled.div`
  display: flex;
  flex-wrap: wrap;
  width: 260px;
  gap: 14px;

  span {
    width: 45%;
    cursor: pointer;
  }
`;

const OptionModalDetailBtnBox = styled.div`
  display: flex;
  gap: 8px;
  padding-top: 28px;
`;

const OptionModalDetailBtn = styled.div<{ selected: boolean }>`
  width: 8px;
  height: 8px;
  border-radius: 50%;
  cursor: pointer;
  background: ${props =>
    props.selected ? `var(--secondary-active-blue)` : `var(--grey-700)`};
`;

export { OptionModalDetail };
