import React, { useState } from 'react';
import { styled } from 'styled-components';
import { priceToString } from '../../util/PriceToString';
import { FlexBox } from '../common/FlexBox';

function BuyCarContainer() {
  const [dropState, setDropState] = useState({
    0: false,
    1: false,
    2: false,
    3: false,
  });
  const option = ['탁송', '할인/포인트', '결제방법', '면제 구분 및 등록비'];
  return (
    <Wrapper>
      <Title className="text-grey-100 head-medium-18">차량 구매</Title>
      {option.map((item, index) => (
        <>
          <Item $isOpen={dropState[index as keyof typeof dropState]}>
            <Header
              className="text-grey-300 body-regular-14"
              onClick={() =>
                setDropState({
                  ...dropState,
                  [index]: !dropState[index as keyof typeof dropState],
                })
              }
            >
              <span>{item}</span>
              <DropIcon
                src="/images/dropdown_icon_silver.svg"
                $isOpen={dropState[index as keyof typeof dropState]}
              />
            </Header>
            <FlexBox direction="column" margin="0px 0px 15px 0px" gap={8}>
              <span>탁송비 어저구 저쩌구</span>
              <span>탁송비 어저구 저쩌구</span>
              <span>탁송비 어저구 저쩌구</span>
              <span>탁송비 어저구 저쩌구</span>
            </FlexBox>
          </Item>
          <Hr />
        </>
      ))}
      <Flex>
        <span className="text-grey-100 head-regular-16">차량 견적 총 금액</span>
        <span className="text-secondary-active-blue head-medium-24">
          {priceToString(48120000)}
        </span>
      </Flex>
    </Wrapper>
  );
}

export default BuyCarContainer;

const Wrapper = styled.div`
  width: 608px;
  margin: 0 auto;
  margin-top: 32px;
`;
const Hr = styled.div`
  margin: 0 auto;
  width: 608px;
  height: 1px;
  background: var(--grey-700);
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 19px 0px;
  cursor: pointer;
`;

const Title = styled.p`
  margin-bottom: 5px;
`;

const DropIcon = styled.img<{ $isOpen: boolean }>`
  transition: all 0.3s linear;

  ${props => {
    if (props.$isOpen) {
      return `transform: rotate(-180deg);`;
    }
  }}
`;

const Item = styled.div<{ $isOpen: boolean }>`
  transition: all 0.5s ease;
  max-height: ${props => (props.$isOpen ? '200px' : '58px')};
  will-change: max-height;
  overflow: hidden;
`;

const Flex = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 34px;
`;
