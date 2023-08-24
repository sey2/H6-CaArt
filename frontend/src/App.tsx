import React, { useContext } from 'react';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import { EstimationProvider } from './util/Context';
import HomePage from './pages/homePage/HomePage';
import RecommendPage from './pages/recommendPage/RecommendPage';
import VehicleEstimationPage from './pages/vehicleEstimationPage/VehicleEstimationPage';
import ResultPage from './pages/resultPage/ResultPage';
import SurveyPage from './pages/surveyPage/SurveyPage';
import ErrorPopup from './components/common/ErrorPopup';
import { ModalProvider } from './store/ModalContext';
import { DarkContext } from './hooks/useDark';
import { styled } from 'styled-components';

function App() {
  const { isDark, darkModeToggle } = useContext(DarkContext)!;

  return (
    <EstimationProvider>
      <ModalProvider>
        <BrowserRouter>
          <ModeBtnBox onClick={darkModeToggle}>
            <img
              src={isDark ? '/images/moon_icon.svg' : '/images/sun_icon.svg'}
            ></img>
          </ModeBtnBox>
          <Routes>
            <Route path="/" Component={HomePage} />
            <Route path="/recommend/*" Component={RecommendPage} />
            <Route path="/estimate/*" Component={VehicleEstimationPage} />
            <Route path="/result" Component={ResultPage} />
            <Route path="/survey" Component={SurveyPage} />
            <Route path="*" Component={ErrorPopup} />
          </Routes>
        </BrowserRouter>
      </ModalProvider>
    </EstimationProvider>
  );
}

const ModeBtnBox = styled.div`
  position: fixed;
  top: 20px;
  right: 20px;
  background: transparent;
  z-index: 50;

  img {
    width: 24px;
    height: 24px;
  }
`;

export default App;
