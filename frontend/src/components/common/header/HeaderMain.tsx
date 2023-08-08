import React, { useContext, useState } from 'react';
import styled from 'styled-components';
import SquareButton from '../SquareButton';
import { HeaderDetail } from './HeaderDetail';
import { EstimationContext, NameAndPrice } from '../../../util/Context';
import { truncateString } from '../../../util/TruncateString';
import { priceToString } from '../../../util/PriceToString';

function HeaderMain({ step }: { step: number }) {
  const { currentEstimation, totalPrice } = useContext(EstimationContext)!;
  const [showDetail, setShowDetail] = useState(false);
  const optionList = getOptionList(currentEstimation.options);
  const selectedClassName = 'head-medium-14 text-primary-blue';
  const unSelectedClassName = 'head-regular-14 text-grey-600';

  return (
    <>
      <TextListBox>
        <TextBox>
          <span
            className={step === 0 ? selectedClassName : unSelectedClassName}
            onClick={() => {}}
          >
            1 트림
          </span>
          <span className="body-regular-14 text-grey-400">
            {currentEstimation.trim.name}
          </span>
        </TextBox>
        <TextBox>
          <span
            className={step === 1 ? selectedClassName : unSelectedClassName}
            onClick={() => {}}
          >
            2 색상
          </span>
          <span className="body-regular-14 text-grey-400">
            {currentEstimation.outerColor.name} /{' '}
            {currentEstimation.interiorColor.name}
          </span>
        </TextBox>
        <TextBox>
          <span
            className={step === 2 ? selectedClassName : unSelectedClassName}
            onClick={() => {}}
          >
            3 옵션
          </span>
          <span className="body-regular-14 text-grey-400">{optionList}</span>
        </TextBox>
      </TextListBox>

      <ButtonBox>
        <button
          onClick={() => {
            setShowDetail(true);
          }}
        >
          임시
        </button>
        <SquareButton
          size={'xxs'}
          color={'primary-blue'}
          bg={'grey-1000'}
          height={40}
          border
        >
          요금 상세
        </SquareButton>
        <SquareButton
          size={'s'}
          color={'grey-1000'}
          bg={'primary-blue'}
          height={40}
        >
          {priceToString(totalPrice)} 견적내기
        </SquareButton>
      </ButtonBox>

      {showDetail && (
        <HeaderDetail setShowDetail={setShowDetail}></HeaderDetail>
      )}
    </>
  );
}

function getOptionList(options: NameAndPrice[]) {
  let str = ``;

  for (const option of options) {
    if ('name' in option) {
      str += `${option.name}, `;
    }
  }

  return truncateString(str.slice(0, -2), 28);
}

const TextBox = styled.div`
  display: inline-flex;
  align-items: center;
  gap: 12px;

  span:first-child {
    cursor: pointer;
  }
`;

const TextListBox = styled.div`
  display: flex;
  gap: 22px;
  padding-left: 128px;
  padding-top: 25px;
`;

const ButtonBox = styled.div`
  display: flex;
  gap: 8px;
  position: absolute;
  top: 64px;
  right: 128px;
`;

export { HeaderMain };
