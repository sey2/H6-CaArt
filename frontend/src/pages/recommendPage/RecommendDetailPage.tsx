import React from 'react';
import styled from 'styled-components';
import { Header } from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import { RecommendPageButton } from '../../components/recommendPage/ageAndLifeStyle/RecommendPageButton';
import { SlideBar } from '../../components/recommendPage/ageAndLifeStyle/SlideBar';

function RecommendDetailPage() {
  return (
    <RecommendDetailPageBox>
      <Header size={'minimal'} page={2}></Header>
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
            <RecommendPageButton size="small" selected onClick={() => {}}>
              1년 이하
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              1년 이상 ~ 5년 미만
            </RecommendPageButton>
            <RecommendPageButton size="large" onClick={() => {}}>
              5년 이상
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
            <RecommendPageButton size="small" selected onClick={() => {}}>
              1인
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              2인
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              3~4인
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              5인 이상
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
            <RecommendPageButton size="small" onClick={() => {}}>
              출퇴근용
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              레저용
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              가정용
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              업무용
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
            <RecommendPageButton size="small" onClick={() => {}}>
              디자인
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              성능
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              안전
            </RecommendPageButton>
            <RecommendPageButton size="small" onClick={() => {}}>
              편의성
            </RecommendPageButton>
          </ReccomendDetailPageABox>
        </RecommendDetailPageQABox>

        <SlideBarBox>
          <SlideBar></SlideBar>
        </SlideBarBox>

        <SquareButton
          size="xl"
          color="grey-1000"
          bg="primary-blue"
          onClick={() => {}}
        >
          완료
        </SquareButton>
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
