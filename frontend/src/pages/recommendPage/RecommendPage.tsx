import React, { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import ErrorPopup from '../../components/common/ErrorPopup';
import Header from '../../components/common/header/Header';
import RecommendAgePage from './RecommendAgePage';
import RecommendDetailPage from './RecommendDetailPage';
import RecommendDetailResultPage from './RecommendDetailResultPage';
import RecomendLifeStylePage from './RecommendLifeStylePage';
import RecommendLifeStyleResultPage from './RecommendLifeStyleResultPage';

export interface RecommendPageChoiceProps {
  age: idAndCode;
  lifeStyle: number;
  experience: idAndCode;
  family: idAndCode;
  purpose: idAndCode;
  value: idAndCode;
  budget: number;
}

export interface idAndCode {
  id: number;
  code: string;
}

export interface RecommendPageProps {
  choice: RecommendPageChoiceProps;
  setChoice: React.Dispatch<React.SetStateAction<RecommendPageChoiceProps>>;
}

export interface questionProps {
  question: string;
  keyword: string;
  answers: {
    code: string;
    answer: string;
  }[];
}

function RecommendPage() {
  const [choice, setChoice] = useState({
    age: {
      id: 0,
      code: 'TWENTY',
    },
    lifeStyle: 0,
    experience: {
      id: 0,
      code: 'ONE_YEAR',
    },
    family: {
      id: 0,
      code: 'SINGLE',
    },
    purpose: {
      id: -1,
      code: '',
    },
    value: {
      id: -1,
      code: '',
    },
    budget: 5400,
  });

  return (
    <>
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
    </>
  );
}

export default RecommendPage;
