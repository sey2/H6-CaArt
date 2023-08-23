import React, { useContext, useMemo, useState } from 'react';
import styled from 'styled-components';
import SquareButton from '../SquareButton';
import HeaderDetail from './HeaderDetail';
import { EstimationContext, NameAndPrice } from '../../../util/Context';
import { truncateString } from '../../../util/TruncateString';
import { priceToString } from '../../../util/PriceToString';
import { Link, useLocation } from 'react-router-dom';
import DropDown from './DropDown';

function HeaderMain() {
  const { currentEstimation, totalPrice } = useContext(EstimationContext)!;
  const [showDetail, setShowDetail] = useState(false);
  const optionList = getOptionList(currentEstimation.options);
  const url = useLocation().pathname;
  const selectedClassName = 'head-medium-14 text-primary-blue';
  const unSelectedClassName = 'head-regular-14 text-grey-600';

  const estimateList = useMemo(
    () => [
      {
        name: '트림',
        link: '/estimate/trim',
      },
      {
        name: '색상',
        link: '/estimate/color',
      },
      {
        name: '옵션',
        link: '/estimate/option',
      },
    ],
    [],
  );

  const estimateNavList = estimateList.map((item, index) => {
    return (
      <TextBox key={index}>
        <Link to={item.link}>
          <span
            className={
              url === item.link ? selectedClassName : unSelectedClassName
            }
          >
            {index + 1} {item.name}
          </span>
        </Link>
        <span className="body-regular-14 text-grey-400">
          {item.name === '트림' && currentEstimation.trim.name}
          {item.name === '색상' &&
            `${currentEstimation.outerColor.name} / ${currentEstimation.interiorColor.name}`}
          {item.name === '옵션' && optionList}
        </span>
      </TextBox>
    );
  });

  return (
    <>
      <Container>
        <TextListBox>{estimateNavList}</TextListBox>
        <ButtonBox>
          <SquareButton
            size={'xxs'}
            color={'primary-blue'}
            bg={'grey-1000'}
            height={40}
            $border
            onClick={() => {
              setShowDetail(!showDetail);
            }}
          >
            요금 상세
          </SquareButton>
          <Link to="/result">
            <SquareButton
              size={'s'}
              color={'grey-1000'}
              bg={'primary-blue'}
              height={40}
            >
              {priceToString(totalPrice)} 견적내기
            </SquareButton>
          </Link>
        </ButtonBox>
      </Container>
      <DropDown visibility={showDetail}>
        {<HeaderDetail setShowDetail={setShowDetail}></HeaderDetail>}
      </DropDown>
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

const Container = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
  padding-bottom: 16px;
  width: 1024px;
  margin: auto;
`;

const TextBox = styled.div`
  display: inline-flex;
  align-items: center;
  gap: 8px;

  span:first-child {
    cursor: pointer;
  }
`;

const TextListBox = styled.div`
  display: flex;
  gap: 12px;
  padding-top: 25px;

  .head-regular-14:hover {
    color: var(--secondary-active-blue);
  }
`;

const ButtonBox = styled.div`
  display: flex;
  gap: 8px;
`;

export default HeaderMain;
