import React from 'react';
import TrimEstimationPage from './TrimEstimationPage';
import ColorEstimationPage from './ColorEstimationPage';
import OptionEstimationPage from './OptionEstimationPage';
import { Route, Routes } from 'react-router-dom';
import { ErrorPopup } from '../../components/common/ErrorPopup';

function VehicleEstimationPage() {
  return (
    <div>
      <Routes>
        <Route
          path="trim"
          element={<TrimEstimationPage></TrimEstimationPage>}
        />
        <Route
          path="color"
          element={<ColorEstimationPage></ColorEstimationPage>}
        />
        <Route
          path="option"
          element={<OptionEstimationPage></OptionEstimationPage>}
        />
        <Route path="*" element={<ErrorPopup></ErrorPopup>} />
      </Routes>
    </div>
  );
}

export default VehicleEstimationPage;
