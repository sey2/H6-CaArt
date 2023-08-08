import React from 'react';
import styled from 'styled-components';
import { priceToString } from '../../../../util/PriceToString';
import CircularButton from '../../../common/CircularButton';
import { OptionModalProps } from './OptionModal';

function OptionModalTitle({
  data,
  optionNum,
}: {
  data: OptionModalProps;
  optionNum: number;
}) {
  return (
    <OptionModalTitleBox>
      <OptionModalTitleUpperBox>
        <OptionModalTitleTextBox>
          <span className="body-medium-12 text-grey-400">
            {data.setOptions.length !== 0 ? data.name : ''}
          </span>
          <OptionModalMainTitle className="head-medium-20 text-grey-0">
            {data.setOptions.length !== 0
              ? data.setOptions[optionNum].name
              : data.name}
          </OptionModalMainTitle>
          <span className="body-medium-16 text-grey-200">
            {priceToString(data.price)}
          </span>
        </OptionModalTitleTextBox>
        <SelectBtnBox>
          <CircularButton></CircularButton>
        </SelectBtnBox>
      </OptionModalTitleUpperBox>

      <OptionModalDescriptionBox className="body-regular-14 text-grey-200">
        {data.setOptions.length !== 0
          ? data.setOptions[optionNum].description
          : data.description}
      </OptionModalDescriptionBox>

      <IconBox src="/images/x_icon_basic.svg"></IconBox>
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
`;

export { OptionModalTitle };
