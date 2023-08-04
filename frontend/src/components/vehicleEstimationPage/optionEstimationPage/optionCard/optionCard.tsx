import React from 'react';
import styled from 'styled-components';
import CircularButton from '../../../common/CircularButton';
import { OptionCardTag } from './optionCardTag';
import { OptionCardGuide } from './optionCardGuide';
import { priceToString } from '../../../../util/priceToString';
import { truncateString } from '../../../../util/truncateString';

function OptionCard({
  data,
  selected,
}: {
  data: OptionCardProps;
  selected?: boolean;
}) {
  return (
    <>
      <OptionCardBox key={data.id}>
        <OptionCardImg src={data.optionImgSrc}></OptionCardImg>
        <OptionCardDetailBox>
          <OptionCardDetailTitleBox>
            <div className="head-medium-16 text-grey-0">
              {truncateString(data.optionName, 11)}
            </div>
            <OptionCardDetailTextBox className="body-regular-14 text-secondary-active-blue">
              <span>더 알아보기</span>
              <img src="/images/rightArrow_icon_blue.svg"></img>
            </OptionCardDetailTextBox>
          </OptionCardDetailTitleBox>
          <OptionCardDetailText className="body-regular-14 text-grey-300">
            {data.optionText}
          </OptionCardDetailText>
          <OptionCardDetailPrice className="body-medium-16 text-grey-100">
            {priceToString(data.optionPrice)}
          </OptionCardDetailPrice>
          <CircularButton selected={selected}></CircularButton>
        </OptionCardDetailBox>
        {data.optionBadge && (
          <OptionCardTagBox>
            <OptionCardTag
              type={data.optionBadge === 'N Performance' ? 'red' : 'blue'}
              tag={data.optionBadge}
            ></OptionCardTag>
          </OptionCardTagBox>
        )}
        {data.optionPercent >= 60 && (
          <OptionCardGuideBox>
            <OptionCardGuide percentage={data.optionPercent}></OptionCardGuide>
          </OptionCardGuideBox>
        )}
      </OptionCardBox>
    </>
  );
}

export interface OptionCardProps {
  id: number;
  optionName: string;
  optionText: string;
  optionImgSrc: string;
  optionPrice: number;
  optionBadge: string;
  optionPercent: number;
}

const OptionCardBox = styled.div`
  display: flex;
  flex-direction: column;
  position: relative;
  width: 244px;
  border-radius: 4px;
`;

const OptionCardImg = styled.img<{ src: string }>`
  width: 244px;
  height: 162px;
  flex-shrink: 0;
  border-radius: 4px;
  background: ${props => `url(${props.src}), lightgray 50% / cover no-repeat;`};
`;

const OptionCardDetailBox = styled.div`
  display: flex;
  flex-direction: column;
`;

const OptionCardDetailTitleBox = styled.div`
  display: flex;
  justify-content: space-between;
  padding-top: 12px;
`;

const OptionCardDetailTextBox = styled.div`
  display: flex;
  align-items: center;

  img {
    width: 16px;
    height: 16px;
  }
`;

const OptionCardDetailText = styled.div`
  padding-top: 6px;
  height: 44px;
`;

const OptionCardDetailPrice = styled.div`
  padding-top: 5px;
  padding-bottom: 12px;
`;

const OptionCardTagBox = styled.div`
  position: absolute;
  top: 0px;
  left: 0px;
`;

const OptionCardGuideBox = styled.div`
  position: absolute;
  height: 34px;
  bottom: 0px;
  top: 128px;
`;

export { OptionCard };
