import React, { useState, useContext } from 'react';
import { styled } from 'styled-components';
import { EstimationContext } from '../../util/Context';
import { priceToString } from '../../util/PriceToString';
import { FlexBox } from '../common/FlexBox';

function BuyCarContainer() {
  const [dropState, setDropState] = useState({
    0: false,
    1: false,
    2: false,
    3: false,
  });
  const dropdownMsg = {
    탁송: '탁송지역을 선택해주세요.',
    '할인/포인트': `할인 및 사용 가능한 포인트를 입력하고 차량의 할인 금액을 확인해 보세요.
개별소비세 감면 혜택도 할인/포인트를 선택하시면 적용됩니다.`,
    결제방법: '결제수단을 선택하고 지불조건 및 납입사항을 확인하세요.',
    '면제 구분 및 등록비': '할인/포인트 및 결제 방법 선택 후 확인 가능합니다.',
  };
  const option = ['탁송', '할인/포인트', '결제방법', '면제 구분 및 등록비'];
  const { totalPrice } = useContext(EstimationContext)!;
  return (
    <Wrapper>
      <Title className="text-grey-100 head-medium-18">차량 구매</Title>
      {option.map((item, index) => (
        <>
          <Item
            $isOpen={dropState[index as keyof typeof dropState]}
            key={index}
          >
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
              <pre className="body-regular-14">
                {dropdownMsg[item as keyof typeof dropdownMsg]}
              </pre>
            </FlexBox>
          </Item>
          <Hr />
        </>
      ))}
      <Flex>
        <span className="text-grey-100 head-regular-16">차량 견적 총 금액</span>
        <span className="text-secondary-active-blue head-medium-24">
          {priceToString(totalPrice)}
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
  &pre {
    line-height: 20px;
  }
`;

const Flex = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 34px;
`;
