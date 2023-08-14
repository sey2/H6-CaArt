import React, { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import { styled } from 'styled-components';
// import { Header } from '../../components/common/header/Header';
import { RecommendAgePage } from './RecommendAgePage';
import { RecommendDetailPage } from './RecommendDetailPage';
import { RecommendDetailResultPage } from './RecommendDetailResultPage';
import { RecomendLifeStylePage } from './RecommendLifeStylePage';
import { RecommendLifeStyleResultPage } from './RecommendLifeStyleResultPage';

interface RecommendPageChoiceProps {
  age: number;
  lifeStyle: number;
  experience: number;
  family: number;
  purpose: number;
  value: number;
  budget: number;
}

export interface RecommendPageProps {
  choice: RecommendPageChoiceProps;
  setChoice: React.Dispatch<React.SetStateAction<RecommendPageChoiceProps>>;
}

function RecommendPage() {
  const [choice, setChoice] = useState({
    age: 0,
    lifeStyle: -1,
    experience: 0,
    family: 0,
    purpose: -1,
    value: -1,
    budget: 5400,
  });

  return (
    <RecommendPageBox>
      {/* 리팩토링시 Header를 라우터 밖으로 뺄 예정 */}
      {/* <Header size="minimal" page={0}></Header> */}
      <Routes>
        <Route
          path=""
          element={
            <RecommendAgePage
              choice={choice}
              setChoice={setChoice}
            ></RecommendAgePage>
          }
        ></Route>
        <Route
          path="lifeStyle"
          element={
            <RecomendLifeStylePage
              choice={choice}
              setChoice={setChoice}
            ></RecomendLifeStylePage>
          }
        ></Route>
        <Route
          path="result"
          element={
            <RecommendLifeStyleResultPage
              choice={choice}
            ></RecommendLifeStyleResultPage>
          }
        ></Route>
        <Route
          path="custom"
          element={
            <RecommendDetailPage
              choice={choice}
              setChoice={setChoice}
            ></RecommendDetailPage>
          }
        ></Route>
        <Route
          path="customResult"
          element={
            <RecommendDetailResultPage
              choice={choice}
            ></RecommendDetailResultPage>
          }
        ></Route>
      </Routes>
    </RecommendPageBox>
  );
}

const RecommendPageBox = styled.div``;

export default RecommendPage;
