import React from 'react';
import { Link } from 'react-router-dom';
import { styled } from 'styled-components';
import SquareButton from '../../../common/SquareButton';

function OptionEstimationPageButton() {
  return (
    <OptionEstimationPageBtn>
      <Link to="/estimate/color">
        <SquareButton size="m" color="grey-50" bg="grey-1000" $border>
          색상 선택
        </SquareButton>
      </Link>
      <Link to="/result">
        <SquareButton size="m" color="grey-1000" bg="primary-blue">
          견적 내기
        </SquareButton>
      </Link>
    </OptionEstimationPageBtn>
  );
}

const OptionEstimationPageBtn = styled.div`
  display: flex;
  gap: 8px;
  margin-top: 48px;
  margin-bottom: 36px;
`;

export default React.memo(OptionEstimationPageButton);
