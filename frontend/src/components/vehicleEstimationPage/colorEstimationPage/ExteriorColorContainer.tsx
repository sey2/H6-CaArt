import React, { useContext, useState, useEffect, useCallback } from 'react';
import styled from 'styled-components';
import {
  ExteriorColor,
  SelectedType,
} from '../../../pages/vehicleEstimationPage/ColorEstimationPage';
import { EstimationContext } from '../../../store/Context';
import ColorButton from './button/ColorButton';
import RankBanner from './RankBanner';

interface ExteriorColorContainerProps {
  data: ExteriorColor[];
  setter: React.Dispatch<React.SetStateAction<SelectedType>>;
}

function ExteriorColorContainer({ data, setter }: ExteriorColorContainerProps) {
  const { currentEstimation, setColorAndTrim, setTrim } =
    useContext(EstimationContext)!;
  function getAdoptionRate() {
    const nowData = data.find(
      item => item.colorName === currentEstimation.outerColor.name,
    );
    return nowData?.adoptionRate as number;
  }
  const [adoptionRate, setAdoptionRate] = useState(0);
  const [selectedColorName, setSelectedName] = useState(
    currentEstimation.outerColor.name,
  );

  const setRankBanner = useCallback((id: number) => {
    switch (id) {
      case 1:
        return <RankBanner text="Top 1" />;
      case 2:
        return <RankBanner text="Top 2" />;
      case 3:
        return <RankBanner text="Top 3" />;
    }
  }, []);

  const setExteriorColor = useCallback(
    (item: ExteriorColor) => {
      const colorItem = {
        name: item.colorName,
        price: item.colorPrice,
        img: item.colorImage,
      };
      setColorAndTrim({
        trim: {
          name: currentEstimation.trim.name,
          price: currentEstimation.trim.price,
          img: item.previews[11],
        },
        color: colorItem,
        type: 'exterior',
      });
    },
    [setColorAndTrim],
  );

  useEffect(() => {
    if (data) {
      setTrim({
        name: currentEstimation.trim.name,
        price: currentEstimation.trim.price,
        img: data[5].previews[11],
      });
      setAdoptionRate(getAdoptionRate());
    }
  }, []);
  return (
    <>
      <Info>
        <span className="text-grey-100 body-medium-14">
          {currentEstimation.outerColor.name}
        </span>
        <span className="caption-medium-12 text-grey-300">
          <span className="text-secondary-active-blue">{adoptionRate}%</span>의
          구매자가 선택한
        </span>
      </Info>
      <Container className="text-grey-100 caption-regular-12">
        {data.map((item, index) => {
          return (
            <ColorItem
              key={item.colorId}
              onClick={() => {
                setExteriorColor(item);
                setAdoptionRate(item.adoptionRate);
                setSelectedName(item.colorName);
                setter('ex');
              }}
              className="selected"
            >
              <ColorButton src={item.colorImage} />
              <span>{item.colorName}</span>
              {setRankBanner(index + 1)}
              {selectedColorName === item.colorName && (
                <SelectedBox>
                  <img
                    src="/images/white-lg-check-icon.svg"
                    width={24}
                    height={24}
                  />
                </SelectedBox>
              )}
            </ColorItem>
          );
        })}
      </Container>
    </>
  );
}

export default React.memo(ExteriorColorContainer);

const Container = styled.div`
  display: flex;
  gap: 12px;
  width: 308px;
  flex-wrap: wrap;
  margin-bottom: 20px;
`;

const ColorItem = styled.div`
  display: flex;
  flex-direction: column;
  gap: 8px;
  width: 68px;
  height: 112px;
  position: relative;
  cursor: pointer;
`;

const Info = styled.div`
  display: flex;
  justify-content: space-between;
  width: 308px;
  margin-bottom: 12px;
  margin-top: 12px;
`;

export const SelectedBox = styled.div`
  z-index: 5;
  background-color: rgba(0, 66, 142, 0.4);
  width: 68px;
  height: 68px;
  border-radius: 4px;
  position: absolute;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;
`;
