import React, { useState } from 'react';
import TrimEstimationPage from './TrimEstimationPage';
import ColorEstimationPage from './ColorEstimationPage';
import OptionEstimationPage from './OptionEstimationPage';
import { Route, Routes } from 'react-router-dom';
import ErrorPopup from '../../components/common/ErrorPopup';
import { preloadContext } from '../../store/PreloadContext';
import { preloadImage } from '../../util/PreLoader';

export interface PreloadProps {
  preLoadData: string[][];
  setPreLoadData: React.Dispatch<React.SetStateAction<string[][]>>;
  loaderIdx: number;
  setLoaderIdx: React.Dispatch<React.SetStateAction<number>>;
  preloadImages: () => void;
}

function VehicleEstimationPage() {
  const [preLoadData, setPreLoadData] = useState<string[][]>([]);
  const [loaderIdx, setLoaderIdx] = useState(0);
  function preloadImages() {
    if (loaderIdx < preLoadData.length) {
      preLoadData[loaderIdx].map(item => {
        preloadImage(item);
      });
      setLoaderIdx(prev => prev + 1);
    }
  }
  return (
    <preloadContext.Provider
      value={{
        preLoadData,
        setPreLoadData,
        loaderIdx,
        setLoaderIdx,
        preloadImages,
      }}
    >
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
    </preloadContext.Provider>
  );
}

export default VehicleEstimationPage;
