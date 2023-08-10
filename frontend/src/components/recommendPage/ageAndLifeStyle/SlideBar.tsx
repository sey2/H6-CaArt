import React, { useState } from 'react';
import styled from 'styled-components';

function SlideBar() {
  const [budget, setBudget] = useState(5400);

  function rangeHandler(event: React.ChangeEvent<HTMLInputElement>) {
    setBudget(parseInt(event.target.value));
  }

  return (
    <SlideBarBox>
      <SlideBarText className="body-medium-18 text-grey-100">
        최대 예산을 알려주세요.
      </SlideBarText>

      <SlidePriceResult htmlFor="budget">
        <PriceBox>
          <span className="head-medium-24 text-grey-50">4,200</span>
          <span className="head-regular-24 text-grey-50">만원</span>
        </PriceBox>
        <span className="head-regular-22 text-grey-50">~</span>
        <PriceBox>
          <span className="head-medium-24 text-grey-50">
            {budget.toLocaleString()}
          </span>
          <span className="head-regular-24 text-grey-50">만원</span>
        </PriceBox>
      </SlidePriceResult>

      <SlideInputLeftCircle
        budget={budget}
        onClick={() => {
          setBudget(4200);
        }}
      ></SlideInputLeftCircle>
      <SlideInput
        type="range"
        min="4200"
        max="6900"
        step="300"
        id="budget"
        name="budget"
        value={budget}
        budget={budget}
        onChange={rangeHandler}
      ></SlideInput>

      <SlideBottom>
        <span className="body-regular-14 text-grey-400">4200 만원</span>
        <span className="body-regular-14 text-grey-400">6900 만원</span>
      </SlideBottom>
    </SlideBarBox>
  );
}

const SlideBarBox = styled.div`
  display: flex;
  flex-direction: column;
  width: 608px;
  height: 144px;
  position: relative;
`;

const SlideBarText = styled.div`
  margin-bottom: 38px;
`;

const SlidePriceResult = styled.label`
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 34px;
`;

const PriceBox = styled.div``;

const SlideInputLeftCircle = styled.div<{ budget: number }>`
  position: absolute;
  top: 120px;
  left: 2px;
  width: 24px;
  height: 24px;
  border-radius: 50%;
  border: 1px solid var(--grey-500);
  background: var(--grey-1000);
  cursor: pointer;
  z-index: ${props => (props.budget === 4200 ? '-1' : 0)};
`;

const SlideInput = styled.input<{ budget: number }>`
  margin-bottom: 14px;
  -webkit-appearance: none;
  width: 100%;
  height: 8px;
  background: ${props =>
    `linear-gradient(to right, var(--secondary-active-blue) 0%, var(--secondary-active-blue) ${
      (props.budget - 4200) / 27
    }%, var(--grey-700) ${(props.budget - 4200) / 27}%, var(--grey-700) 100%)`};
  border-radius: 16px;
  cursor: pointer;

  &::-webkit-slider-thumb {
    -webkit-appearance: none;
    background: var(--grey-1000);
    width: 24px;
    height: 24px;
    border-radius: 50%;
    border: 1px solid var(--grey-500);
    cursor: pointer;
  }
`;

const SlideBottom = styled.div`
  display: flex;
  justify-content: space-between;
`;

export { SlideBar };
