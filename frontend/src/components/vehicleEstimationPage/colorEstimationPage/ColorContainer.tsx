import React from 'react';
import styled from 'styled-components';
import ColorButton from './button/ColorButton';

function ColorContainer() {
  return (
    <>
      <Info>
        <span className="text-grey-100 body-medium-14">
          그래파이트 그레이 메탈릭
        </span>
        <span className="caption-medium-12 text-grey-300">
          <span className="text-secondary-active-blue">75%</span>의 구매자가
          선택한
        </span>
      </Info>
      <Container>
        <ColorItem className="text-grey-100 caption-regular-12">
          <ColorButton src="/images/temp_color.svg" />
          <span>가이아 브라운 펄</span>
        </ColorItem>
      </Container>
    </>
  );
}

export default ColorContainer;

const Container = styled.div`
  display: flex;
  gap: 12px;
  width: 308px;
  flex-wrap: wrap;
  margin-bottom: 20px;
`;

const ColorItem = styled.div`
  display: flex;
  flex-direction: column;
  gap: 8px;
  width: 68px;
  height: 112px;
`;

const Info = styled.div`
  display: flex;
  justify-content: space-between;
  width: 308px;
  margin-bottom: 12px;
  margin-top: 12px;
`;
