import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { Header } from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import { PageNum } from '../../components/recommendPage/ageAndLifeStyle/PageNum';
import { RecommendPageButton } from '../../components/recommendPage/ageAndLifeStyle/RecommendPageButton';
import { RecommendPageProps } from './RecommendPage';

function RecommendAgePage({ choice, setChoice }: RecommendPageProps) {
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
          <RecommendPageButton
            size="small"
            selected={choice.age === 0}
            onClick={() => {
              setChoice({ ...choice, age: 0 });
            }}
          >
            20대
          </RecommendPageButton>
          <RecommendPageButton
            size="small"
            selected={choice.age === 1}
            onClick={() => {
              setChoice({ ...choice, age: 1 });
            }}
          >
            30대
          </RecommendPageButton>
          <RecommendPageButton
            size="small"
            selected={choice.age === 2}
            onClick={() => {
              setChoice({ ...choice, age: 2 });
            }}
          >
            40대
          </RecommendPageButton>
          <RecommendPageButton
            size="small"
            selected={choice.age === 3}
            onClick={() => {
              setChoice({ ...choice, age: 3 });
            }}
          >
            50대 이상
          </RecommendPageButton>
        </ReccomendAgePageABox>

        <Link to="/recommend/lifeStyle">
          <SquareButton size="xl" color="grey-1000" bg="primary-blue">
            다음
          </SquareButton>
        </Link>
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

export { RecommendAgePage };
