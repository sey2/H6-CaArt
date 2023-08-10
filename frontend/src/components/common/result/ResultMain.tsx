import React from 'react';
import styled from 'styled-components';
import { ResultCardList } from './ResultCardList';
import { ResultFooter } from './ResultFooter';
import { ResultHeader } from './ResultHeader';

function ResultMain() {
  return (
    <ResultMainBox>
      <ResultHeader></ResultHeader>
      <ResultCardList></ResultCardList>
      <ResultFooter></ResultFooter>
    </ResultMainBox>
  );
}

const ResultMainBox = styled.div`
  width: 608px;
`;

export { ResultMain };
