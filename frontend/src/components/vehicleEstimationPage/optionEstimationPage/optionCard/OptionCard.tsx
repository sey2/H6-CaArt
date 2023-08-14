import React, { useContext } from 'react';
import styled from 'styled-components';
import CircularButton from '../../../common/CircularButton';
import OptionCardTag from './OptionCardTag';
import OptionCardGuide from './OptionCardGuide';
import { priceToString } from '../../../../util/PriceToString';
import { truncateString } from '../../../../util/TruncateString';
import { EstimationContext } from '../../../../util/Context';

export type OptionCardType = 'additionalAll' | 'additionalTag' | 'basic';

export interface OptionCardProps {
  id: number;
  name: string;
  description: string;
  imgSrc: string;
  price: number;
  badge: string;
  percent: number;
}

function OptionCard({
  data,
  selected,
  type,
  setOpenedModalId,
}: {
  data: OptionCardProps;
  selected?: boolean;
  type: OptionCardType;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}) {
  const { addOption, deleteOption } = useContext(EstimationContext)!;

  const optionCardBasicInfo = (
    <OptionCardDetailTitleBox>
      <span className="head-medium-16 text-grey-0">
        {truncateString(data.name, 11)}
      </span>
      <OptionCardDetailTextBox className="body-regular-14 text-secondary-active-blue">
        <span
          onClick={() => {
            setOpenedModalId(data.id);
          }}
        >
          더 알아보기
        </span>
        <img src="/images/rightArrow_icon_blue.svg"></img>
      </OptionCardDetailTextBox>
    </OptionCardDetailTitleBox>
  );

  const optionCardAdditionalInfo = (
    <>
      <OptionCardDetailText className="body-regular-14 text-grey-300">
        {data.description}
      </OptionCardDetailText>
      <OptionCardDetailPrice className="body-medium-16 text-grey-100">
        {priceToString(data.price)}
      </OptionCardDetailPrice>
      <CircularButton
        selected={selected}
        onClick={() => {
          if (selected) {
            deleteOption(data.name);
          } else {
            addOption({ name: data.name, price: data.price });
          }
        }}
      ></CircularButton>
    </>
  );

  const optionCardBadge = (
    <OptionCardTagBox>
      <OptionCardTag
        type={data.badge === 'N Performance' ? 'red' : 'blue'}
        tag={data.badge}
      ></OptionCardTag>
    </OptionCardTagBox>
  );

  const optionCardGuide = (
    <OptionCardGuideBox>
      <OptionCardGuide percentage={data.percent}></OptionCardGuide>
    </OptionCardGuideBox>
  );

  return (
    <OptionCardBox>
      <OptionCardImg src={data.imgSrc}></OptionCardImg>
      <OptionCardDetailBox>
        <>
          {optionCardBasicInfo}
          {type !== 'basic' && optionCardAdditionalInfo}
        </>
      </OptionCardDetailBox>
      {data.badge && optionCardBadge}
      {data.percent >= 60 && type === 'additionalAll' && optionCardGuide}
    </OptionCardBox>
  );
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

  button {
    cursor: pointer;
  }
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

  span {
    cursor: pointer;
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

export default OptionCard;
