import React, { useContext } from 'react';
import styled from 'styled-components';
import { priceToString } from '../../../../util/PriceToString';
import CircularButton from '../../../common/CircularButton';
import { OptionModalProps } from './OptionModal';
import { EstimationContext } from '../../../../util/Context';

function OptionModalTitle({
  data,
  optionNum,
  selected,
  setOpenedModalId,
}: {
  data: OptionModalProps;
  optionNum: number;
  selected?: boolean;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}) {
  const { currentEstimation, addOption, deleteOption } =
    useContext(EstimationContext)!;
  const isSetOption = data.setOptions.length !== 0;
  return (
    <OptionModalTitleBox>
      <OptionModalTitleUpperBox>
        <OptionModalTitleTextBox>
          {isSetOption && (
            <span className="body-medium-12 text-grey-400">{data.name}</span>
          )}
          <OptionModalMainTitle className="head-medium-20 text-grey-0">
            {isSetOption ? data.setOptions[optionNum].name : data.name}
          </OptionModalMainTitle>
          <span className="body-medium-16 text-grey-200">
            {priceToString(data.price)}
          </span>
        </OptionModalTitleTextBox>
        <SelectBtnBox>
          <CircularButton
            selected={selected}
            onClick={() => {
              if (selected) {
                console.log('del', data.name);
                deleteOption(data.name);
              } else {
                console.log('add', data.name, data.price);
                addOption({ name: data.name, price: data.price });
                console.log(currentEstimation);
              }
            }}
          ></CircularButton>
        </SelectBtnBox>
      </OptionModalTitleUpperBox>

      <OptionModalDescriptionBox className="body-regular-14 text-grey-200">
        {isSetOption
          ? data.setOptions[optionNum].description
          : data.description}
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
  height: 250px;
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
  padding-right: 24px;

  button {
    cursor: pointer;
  }
`;

const OptionModalMainTitle = styled.div`
  width: 167px;
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
`;

export default OptionModalTitle;
