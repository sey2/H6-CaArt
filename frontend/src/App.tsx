import React from 'react';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import HomePage from './pages/homePage/HomePage';
import RecommendPage from './pages/recommendPage/RecommendPage';
import ResultPage from './pages/resultPage/ResultPage';
import VehicleEstimationPage from './pages/vehicleEstimationPage/VehicleEstimationPage';
import { EstimationProvider } from './util/Context';

function App() {
  return (
    <EstimationProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" Component={HomePage} />
          <Route path="/recommend/*" Component={RecommendPage} />
          <Route path="/estimate" Component={VehicleEstimationPage} />
          <Route path="/result" Component={ResultPage} />
        </Routes>
      </BrowserRouter>
    </EstimationProvider>
  );
}

export default App;
