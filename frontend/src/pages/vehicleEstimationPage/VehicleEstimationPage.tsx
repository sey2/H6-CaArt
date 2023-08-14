import React, { useState } from 'react';
import TrimEstimationPage from './TrimEstimationPage';
import ColorEstimationPage from './ColorEstimationPage';
import OptionEstimationPage from './OptionEstimationPage';

function VehicleEstimationPage() {
  const [estimationPageName] = useState<'trim' | 'color' | 'option'>('trim');

  const estimationPage = (function () {
    switch (estimationPageName) {
      case 'trim':
        return <TrimEstimationPage></TrimEstimationPage>;
      case 'color':
        return <ColorEstimationPage></ColorEstimationPage>;
      case 'option':
        return <OptionEstimationPage></OptionEstimationPage>;
      default:
        return <div>ERROR</div>;
    }
  })();

  return <>{estimationPage}</>;
}

export default VehicleEstimationPage;
