import React from 'react';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import { EstimationProvider } from './util/Context';
import HomePage from './pages/homePage/HomePage';
import RecommendPage from './pages/recommendPage/RecommendPage';
import VehicleEstimationPage from './pages/vehicleEstimationPage/VehicleEstimationPage';
import ResultPage from './pages/resultPage/ResultPage';
import { ErrorPopup } from './components/common/ErrorPopup';

function App() {
  return (
    <EstimationProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" Component={HomePage} />
          <Route path="/recommend/*" Component={RecommendPage} />
          <Route path="/estimate/*" Component={VehicleEstimationPage} />
          <Route path="/result" Component={ResultPage} />
          <Route path="*" Component={ErrorPopup} />
        </Routes>
      </BrowserRouter>
    </EstimationProvider>
  );
}

export default App;
