import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import SquareButton from '../../components/common/SquareButton';
import { RecommendPageButton } from '../../components/recommendPage/ageAndLifeStyle/RecommendPageButton';
import { SlideBar } from '../../components/recommendPage/ageAndLifeStyle/SlideBar';
import { RecommendPageProps } from './RecommendPage';

export const question = [
  ['1년 이하', '1년 이상 ~ 5년 미만', '5년 이상'],
  ['1인', '2인', '3~4인', '5인 이상'],
  ['출퇴근용', '레저용', '가정용', '업무용'],
  ['디자인', '성능', '안전', '편의성'],
];

function RecommendDetailPage({ choice, setChoice }: RecommendPageProps) {
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

        <RecommendDetailPageQABox>
          <RecommendDetailPageQBox>
            <span className="body-medium-18 text-grey-100">
              운전 경력이 어떻게 되시나요?
            </span>
          </RecommendDetailPageQBox>
          <ReccomendDetailPageABox>
            <RecommendPageButton
              size="small"
              selected={choice.experience == 0}
              onClick={() => {
                setChoice({ ...choice, experience: 0 });
              }}
            >
              {question[0][0]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.experience == 1}
              onClick={() => {
                setChoice({ ...choice, experience: 1 });
              }}
            >
              {question[0][1]}
            </RecommendPageButton>
            <RecommendPageButton
              size="large"
              selected={choice.experience == 2}
              onClick={() => {
                setChoice({ ...choice, experience: 2 });
              }}
            >
              {question[0][2]}
            </RecommendPageButton>
          </ReccomendDetailPageABox>
        </RecommendDetailPageQABox>

        <RecommendDetailPageQABox>
          <RecommendDetailPageQBox>
            <span className="body-medium-18 text-grey-100">
              가족 구성원이 몇 명인가요?
            </span>
          </RecommendDetailPageQBox>
          <ReccomendDetailPageABox>
            <RecommendPageButton
              size="small"
              selected={choice.family === 0}
              onClick={() => {
                setChoice({ ...choice, family: 0 });
              }}
            >
              {question[1][0]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.family === 1}
              onClick={() => {
                setChoice({ ...choice, family: 1 });
              }}
            >
              {question[1][1]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.family === 2}
              onClick={() => {
                setChoice({ ...choice, family: 2 });
              }}
            >
              {question[1][2]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.family === 3}
              onClick={() => {
                setChoice({ ...choice, family: 3 });
              }}
            >
              {question[1][3]}
            </RecommendPageButton>
          </ReccomendDetailPageABox>
        </RecommendDetailPageQABox>

        <RecommendDetailPageQABox>
          <RecommendDetailPageQBox>
            <span className="body-medium-18 text-grey-100">
              어떤 목적으로 주로 차를 타시나요?
            </span>
          </RecommendDetailPageQBox>
          <ReccomendDetailPageABox>
            <RecommendPageButton
              size="small"
              selected={choice.purpose === 0}
              onClick={() => {
                setChoice({ ...choice, purpose: 0 });
              }}
            >
              {question[2][0]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.purpose === 1}
              onClick={() => {
                setChoice({ ...choice, purpose: 1 });
              }}
            >
              {question[2][1]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.purpose === 2}
              onClick={() => {
                setChoice({ ...choice, purpose: 2 });
              }}
            >
              {question[2][2]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.purpose === 3}
              onClick={() => {
                setChoice({ ...choice, purpose: 3 });
              }}
            >
              {question[2][3]}
            </RecommendPageButton>
          </ReccomendDetailPageABox>
        </RecommendDetailPageQABox>

        <RecommendDetailPageQABox>
          <RecommendDetailPageQBox>
            <span className="body-medium-18 text-grey-100">
              자동차를 살 때 어떤 가치가 가장 중요한가요?
            </span>
          </RecommendDetailPageQBox>
          <ReccomendDetailPageABox>
            <RecommendPageButton
              size="small"
              selected={choice.value === 0}
              onClick={() => {
                setChoice({ ...choice, value: 0 });
              }}
            >
              {question[3][0]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.value === 1}
              onClick={() => {
                setChoice({ ...choice, value: 1 });
              }}
            >
              {question[3][1]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.value === 2}
              onClick={() => {
                setChoice({ ...choice, value: 2 });
              }}
            >
              {question[3][2]}
            </RecommendPageButton>
            <RecommendPageButton
              size="small"
              selected={choice.value === 3}
              onClick={() => {
                setChoice({ ...choice, value: 3 });
              }}
            >
              {question[3][3]}
            </RecommendPageButton>
          </ReccomendDetailPageABox>
        </RecommendDetailPageQABox>

        <SlideBarBox>
          <SlideBar
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
