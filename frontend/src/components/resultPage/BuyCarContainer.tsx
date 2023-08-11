import React from 'react';
import { styled } from 'styled-components';
import { priceToString } from '../../util/PriceToString';

function BuyCarContainer() {
  const option = ['탁송', '할인/포인트', '결제방법', '면제 구분 및 등록비'];
  return (
    <Wrapper>
      <Title className="text-grey-100 head-medium-18">차량 구매</Title>
      {option.map(item => (
        <>
          <Header className="text-grey-300 body-regular-14">
            <span>{item}</span>
            <img src="/images/dropdown_icon_silver.svg" />
          </Header>
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
`;

const Title = styled.p`
  margin-bottom: 5px;
`;

// const DropIcon = styled.img`

// `

const Flex = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 34px;
`;
