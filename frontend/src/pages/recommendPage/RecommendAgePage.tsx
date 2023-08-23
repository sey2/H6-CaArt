import React, { useContext } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useFetch } from '../../hooks/useFetch';
import { EstimationContext } from '../../util/Context';
import ErrorPopup from '../../components/common/ErrorPopup';
import SquareButton from '../../components/common/SquareButton';
import PageNum from '../../components/recommendPage/ageAndLifeStyle/PageNum';
import RecommendPageButton from '../../components/recommendPage/ageAndLifeStyle/RecommendPageButton';
import { questionProps, RecommendPageProps } from './RecommendPage';

interface basicQuestionProps {
  age: questionProps;
}

function RecommendAgePage({ choice, setChoice }: RecommendPageProps) {
  const { setAgeCode } = useContext(EstimationContext)!;
  const { data, status, error } = useFetch<basicQuestionProps>(
    '/lifestyles/questions',
  );
  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  const questionList = data.age.answers.map((item, index) => {
    return (
      <RecommendPageButton
        key={item.code}
        size={
          data.age.answers.length % 2 === 1 &&
          data.age.answers.length === index + 1
            ? 'large'
            : 'small'
        }
        selected={choice.age.id === index}
        onClick={() => {
          setChoice({ ...choice, age: { id: index, code: item.code } });
          setAgeCode(item.code);
        }}
      >
        {item.answer}
      </RecommendPageButton>
    );
  });

  return (
    <ReccomendAgePageBox>
      <ReccomendAgePageMain>
        <ReccomendAgePageQBox>
          <div className="text-grey-0">
            <span className="head-medium-22 ">{data.age.keyword}</span>
            <span className="head-regular-22">
              {data.age.question.replace(data.age.keyword, '')}
            </span>
          </div>
          <PageNum>1/2</PageNum>
        </ReccomendAgePageQBox>
        <ReccomendAgePageABox>{questionList}</ReccomendAgePageABox>
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
  margin-top: 48px;
  margin-bottom: 36px;
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

export default RecommendAgePage;
