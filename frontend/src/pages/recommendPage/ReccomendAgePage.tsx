import React from 'react';
import styled from 'styled-components';
import { Header } from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import { PageNum } from '../../components/recommendPage/ageAndLifeStyle/PageNum';
import { ReccomendPageButton } from '../../components/recommendPage/ageAndLifeStyle/ReccomendPageButton';

function ReccomendAgePage() {
  return (
    <ReccomendAgePageBox>
      <Header size={'minimal'} page={0}></Header>
      <ReccomendAgePageMain>
        <ReccomendAgePageQBox>
          <div className="text-grey-0">
            <span className="head-medium-22 ">나이</span>
            <span className="head-regular-22">를 알려주세요</span>
          </div>
          <PageNum>1/2</PageNum>
        </ReccomendAgePageQBox>
        <ReccomendAgePageABox>
          <ReccomendPageButton size="small" selected onClick={() => {}}>
            20대
          </ReccomendPageButton>
          <ReccomendPageButton size="small" onClick={() => {}}>
            30대
          </ReccomendPageButton>
          <ReccomendPageButton size="small" onClick={() => {}}>
            40대
          </ReccomendPageButton>
          <ReccomendPageButton size="small" onClick={() => {}}>
            50대 이상
          </ReccomendPageButton>
        </ReccomendAgePageABox>
        <SquareButton
          size="xl"
          color="grey-1000"
          bg="primary-blue"
          onClick={() => {}}
        >
          다음
        </SquareButton>
      </ReccomendAgePageMain>
    </ReccomendAgePageBox>
  );
}

const ReccomendAgePageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const ReccomendAgePageMain = styled.div`
  width: 608px;
  height: 740px;
  margin-top: 48px;
`;

const ReccomendAgePageQBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 24px;
`;

const ReccomendAgePageABox = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
  margin-bottom: 424px;
`;

export { ReccomendAgePage };
