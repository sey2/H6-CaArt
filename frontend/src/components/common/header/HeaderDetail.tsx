import React, { useContext } from 'react';
import styled from 'styled-components';
import { EstimationContext } from '../../../util/Context';
import { priceToString } from '../../../util/PriceToString';
import { truncateString } from '../../../util/TruncateString';

function HeaderDetail({
  setShowDetail,
}: {
  setShowDetail: React.Dispatch<React.SetStateAction<boolean>>;
}) {
  const { currentEstimation, totalPrice } = useContext(EstimationContext)!;
  const trimTotalPrice =
    currentEstimation.trim.price +
    currentEstimation.engine.price +
    currentEstimation.body.price +
    currentEstimation.wd.price;

  const optionList = currentEstimation.options.map(item => {
    return (
      <OptionList key={item.name}>
        <div className="body-regular-14 text-grey-300">{item.name}</div>
        <div className="body-medium-14 text-grey-100">{item.price}</div>
      </OptionList>
    );
  });

  return (
    <HeaderDetailBox>
      <HeaderMiddleLine />
      <OptionListBox>
        <OptionBox>
          <OptionList>
            <div className="body-regular-14 text-grey-300">
              {currentEstimation.engine.name}
            </div>
            <div className="body-medium-14 text-grey-100">
              {priceToString(trimTotalPrice)}
            </div>
          </OptionList>
          <OptionList>
            <div className="body-regular-14 text-grey-300">
              {currentEstimation.body.name}
            </div>
          </OptionList>
          <OptionList>
            <div className="body-regular-14 text-grey-300">
              {currentEstimation.wd.name}
            </div>
          </OptionList>
        </OptionBox>
        <OptionBox2>
          <OptionList>
            <div className="body-regular-14 text-grey-300">
              {truncateString(currentEstimation.outerColor.name, 6)}
            </div>
            <div className="body-medium-14 text-grey-100">
              {priceToString(currentEstimation.outerColor.price)}
            </div>
          </OptionList>
          <OptionList>
            <div className="body-regular-14 text-grey-300">
              {truncateString(currentEstimation.interiorColor.name, 6)}
            </div>
            <div className="body-medium-14 text-grey-100">
              {priceToString(currentEstimation.interiorColor.price)}
            </div>
          </OptionList>
        </OptionBox2>
        <OptionBox3>{optionList}</OptionBox3>
        {currentEstimation.options.length >= 6 && (
          <ScrollIconBox src="/images/scroll_icon_black.svg"></ScrollIconBox>
        )}
      </OptionListBox>
      <HeaderBottomLine />
      <TotalPriceBox>
        <img
          src="/images/dropup_icon_default.svg"
          onClick={() => {
            setShowDetail(false);
          }}
        ></img>
        <span className="head-medium-24 text-grey-50">
          {priceToString(totalPrice)}
        </span>
      </TotalPriceBox>
    </HeaderDetailBox>
  );
}

const HeaderDetailBox = styled.div`
  background: var(--grey-1000);
  width: 100%;
  min-height: 202px;
  position: absolute;
  left: 0px;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-bottom: 24px;
  box-shadow: 0px 4px 6px 0px rgba(0, 0, 0, 0.08);
`;

const HeaderMiddleLine = styled.div`
  border-bottom: 1px solid #ebebeb;
  width: 100%;
  height: 1px;
`;

const HeaderBottomLine = styled.div`
  border-bottom: 1px solid #ebebeb;
  height: 1px;
  width: 1024px;
  margin-bottom: 16px;
`;

const OptionBox = styled.div`
  display: flex;
  flex-direction: column;
  width: 147px;
  height: 98px;
  margin: 20px 0px 20px 0px;
  gap: 7px;
  border-right: 1px solid #ebebeb;
  position: relative;

  div {
    height: 22px;
  }
`;

const OptionBox2 = styled.div`
  display: flex;
  flex-direction: column;
  width: 147px;
  height: 98px;
  margin: 20px 0px 20px 13px;
  gap: 7px;

  .body-regular-14 {
    height: 22px;
  }
`;

const OptionBox3 = styled.div`
  display: flex;
  flex-direction: column;
  gap: 7px;
  width: 400px;
  min-height: 98px;
  max-height: 140px;
  margin: 20px 0px 20px 0px;
  padding-left: 13px;
  border-left: 1px solid #ebebeb;
  overflow: scroll;
  &::-webkit-scrollbar {
    display: none;
  }

  div {
    height: 22px;
  }
`;

const ScrollIconBox = styled.img`
  width: 24px;
  height: 24px;
  transform: translateY(75px);
`;

const OptionListBox = styled.div`
  display: flex;
  width: 1024px;
  margin: auto;
`;

const OptionList = styled.div`
  display: flex;
  justify-content: space-between;

  .text-grey-100 {
    padding-right: 14px;
  }
`;

const TotalPriceBox = styled.div`
  display: flex;
  justify-content: flex-end;
  gap: 4px;
  width: 1024px;
  margin: auto;

  img {
    cursor: pointer;
  }
`;

export default HeaderDetail;
