import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { ErrorPopup } from '../../components/common/ErrorPopup';
import SquareButton from '../../components/common/SquareButton';
import { RecommendPageButton } from '../../components/recommendPage/ageAndLifeStyle/RecommendPageButton';
import { SlideBar } from '../../components/recommendPage/ageAndLifeStyle/SlideBar';
import { useFetch } from '../../hooks/useFetch';
import { questionProps } from './RecommendAgePage';
import { RecommendPageChoiceProps, RecommendPageProps } from './RecommendPage';

interface additionalQuestionProps {
  experience: questionProps;
  family: questionProps;
  purpose: questionProps;
  value: questionProps;
  budget: budgetProps;
}

export interface budgetProps {
  question: string;
  keyword: string;
  minBudget: number;
  maxBudget: number;
  budgetUnit: number;
}

export const question: string[][] = [[], [], [], []];

function RecommendDetailPage({ choice, setChoice }: RecommendPageProps) {
  const { data, status, error } = useFetch<additionalQuestionProps>(
    '/lifestyles/questions/additional',
  );
  useEffect(() => {
    if (data) {
      Object.keys(data).forEach((key, index) => {
        if ('choices' in data[key as keyof additionalQuestionProps]) {
          (
            data[key as keyof additionalQuestionProps] as questionProps
          ).choices.forEach((item, index2) => {
            question[index][index2] = item.content;
          });
        }
      });
    }
  }, [data]);
  if (status === 'loading') {
    return <div>loading</div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  const QAList = Object.keys(data).map(key => {
    if ('choices' in data[key as keyof additionalQuestionProps]) {
      const question = data[
        key as keyof additionalQuestionProps
      ] as questionProps;
      return (
        <RecommendDetailPageQABox key={question.keyword}>
          <RecommendDetailPageQBox>
            <span className="body-medium-18 text-grey-100">
              {question.question}
            </span>
          </RecommendDetailPageQBox>
          <ReccomendDetailPageABox>
            {question.choices.map((item, index) => {
              return (
                <RecommendPageButton
                  key={item.id}
                  size={
                    question.choices.length % 2 === 1 &&
                    question.choices.length === index + 1
                      ? 'large'
                      : 'small'
                  }
                  selected={
                    choice[key as keyof RecommendPageChoiceProps] == item.id
                  }
                  onClick={() => {
                    const copy = { ...choice };
                    copy[key as keyof RecommendPageChoiceProps] = item.id;
                    setChoice(copy);
                  }}
                >
                  {item.content}
                </RecommendPageButton>
              );
            })}
          </ReccomendDetailPageABox>
        </RecommendDetailPageQABox>
      );
    }
  });

  return (
    <RecommendDetailPageBox>
      <RecommendDetailPageMain>
        <RecommendDetailPageTopQBox>
          <div className="text-grey-0">
            <span className="head-regular-24">당신의 </span>
            <span className="head-medium-24">라이프스타일</span>
            <span className="head-regular-24">을 알려주세요.</span>
          </div>
          <div className="body-regular-14 text-grey-300">
            당신의 라이프스타일을 반영한 차를 추천해 드릴게요.
          </div>
        </RecommendDetailPageTopQBox>
        {QAList}
        <SlideBarBox>
          <SlideBar
            data={data.budget}
            budget={choice.budget}
            setBudget={(budget: number) => {
              setChoice({ ...choice, budget: budget });
            }}
          ></SlideBar>
        </SlideBarBox>

        <Link
          to="/recommend/customResult"
          onClick={e => {
            (choice.purpose === -1 || choice.value === -1) &&
              e.preventDefault();
          }}
        >
          <SquareButton size="xl" color="grey-1000" bg="primary-blue">
            완료
          </SquareButton>
        </Link>
      </RecommendDetailPageMain>
    </RecommendDetailPageBox>
  );
}

const RecommendDetailPageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const RecommendDetailPageMain = styled.div`
  width: 608px;
  height: 740px;
  margin-top: 48px;
`;

const RecommendDetailPageTopQBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 8px;
  margin-bottom: 24px;
`;

const RecommendDetailPageQABox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 18px;
`;

const RecommendDetailPageQBox = styled.div``;

const ReccomendDetailPageABox = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
  margin-bottom: 52px;
`;

const SlideBarBox = styled.div`
  margin-bottom: 88px;
`;

export { RecommendDetailPage };
