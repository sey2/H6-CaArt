import React, { useContext } from 'react';
import styled from 'styled-components';
import { priceToString } from '../../../../util/PriceToString';
import CircularButton from '../../../common/CircularButton';
import { EstimationContext } from '../../../../util/Context';
import { OptionProps } from '../optionCardList/OptionCardList';

interface OptionModalTitleProps {
  option: OptionProps;
  optionNum: number;
  selected?: boolean;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}

function OptionModalTitle({
  option,
  optionNum,
  selected,
  setOpenedModalId,
}: OptionModalTitleProps) {
  const { addOption, deleteOption } = useContext(EstimationContext)!;
  const isSetOption = option.subOptions && option.subOptions.length !== 0;

  return (
    <OptionModalTitleBox>
      <OptionModalTitleUpperBox>
        <OptionModalTitleTextBox>
          {isSetOption && (
            <span className="body-medium-12 text-grey-400">
              {option.optionName}
            </span>
          )}
          <OptionModalMainTitle className="head-medium-20 text-grey-0">
            {isSetOption
              ? option.subOptions![optionNum].optionName
              : option.optionName}
          </OptionModalMainTitle>
          <span className="body-medium-16 text-grey-200">
            {option.optionPrice && priceToString(option.optionPrice)}
          </span>
        </OptionModalTitleTextBox>
        {option.optionPrice && (
          <SelectBtnBox>
            <CircularButton
              selected={selected}
              onClick={() => {
                if (selected) {
                  deleteOption(option.optionName);
                } else {
                  addOption({
                    name: option.optionName,
                    price: option.optionPrice!,
                    img: option.optionImage,
                  });
                }
              }}
            ></CircularButton>
          </SelectBtnBox>
        )}
      </OptionModalTitleUpperBox>

      <OptionModalDescriptionBox className="body-regular-14 text-grey-200">
        {isSetOption
          ? option.subOptions![optionNum].description
          : option.description}
      </OptionModalDescriptionBox>

      <IconBox
        src="/images/x_icon_basic.svg"
        onClick={() => {
          setOpenedModalId(0);
        }}
      ></IconBox>
    </OptionModalTitleBox>
  );
}

const OptionModalTitleBox = styled.div`
  position: relative;
  width: 344px;
  min-height: 250px;
`;

const OptionModalTitleUpperBox = styled.div`
  display: flex;
  align-items: flex-end;
  justify-content: space-between;
  width: 344px;
`;

const OptionModalTitleTextBox = styled.div`
  display: inline-flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 4px;
  padding-top: 50px;
  padding-left: 28px;
`;

const SelectBtnBox = styled.div`
  display: flex;
  position: absolute;
  right: 24px;

  button {
    cursor: pointer;
  }
`;

const OptionModalMainTitle = styled.div`
  width: 314px;
`;

const OptionModalDescriptionBox = styled.div`
  width: 314px;
  padding-left: 28px;
  padding-top: 20px;
`;

const IconBox = styled.img`
  position: absolute;
  top: 24px;
  right: 24px;
  cursor: pointer;

  &:hover {
    background: var(--grey-700);
  }
`;

export default OptionModalTitle;
