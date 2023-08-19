import React, { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import { styled } from 'styled-components';
import { ErrorPopup } from '../../components/common/ErrorPopup';
import Header from '../../components/common/header/Header';
import { RecommendAgePage } from './RecommendAgePage';
import { RecommendDetailPage } from './RecommendDetailPage';
import { RecommendDetailResultPage } from './RecommendDetailResultPage';
import { RecomendLifeStylePage } from './RecommendLifeStylePage';
import { RecommendLifeStyleResultPage } from './RecommendLifeStyleResultPage';

export interface RecommendPageChoiceProps {
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
    lifeStyle: 0,
    experience: 0,
    family: 0,
    purpose: -1,
    value: -1,
    budget: 5400,
  });

  return (
    <RecommendPageBox>
      <Header size="medium" page={0}></Header>
      <Routes>
        <Route
          path="age"
          element={
            <RecommendAgePage
              choice={choice}
              setChoice={setChoice}
            ></RecommendAgePage>
          }
        />
        <Route
          path="lifeStyle"
          element={
            <RecomendLifeStylePage
              choice={choice}
              setChoice={setChoice}
            ></RecomendLifeStylePage>
          }
        />
        <Route
          path="result"
          element={
            <RecommendLifeStyleResultPage
              choice={choice}
            ></RecommendLifeStyleResultPage>
          }
        />
        <Route
          path="custom"
          element={
            <RecommendDetailPage
              choice={choice}
              setChoice={setChoice}
            ></RecommendDetailPage>
          }
        />
        <Route
          path="customResult"
          element={
            <RecommendDetailResultPage
              choice={choice}
            ></RecommendDetailResultPage>
          }
        />
        <Route path="*" element={<ErrorPopup></ErrorPopup>} />
      </Routes>
    </RecommendPageBox>
  );
}

const RecommendPageBox = styled.div``;

export default RecommendPage;
