import React, { useContext, useState, useEffect, useCallback } from 'react';
import styled from 'styled-components';
import {
  InteriorColor,
  SelectedType,
} from '../../../pages/vehicleEstimationPage/ColorEstimationPage';
import { EstimationContext } from '../../../util/Context';
import ColorButton from './button/ColorButton';
import { SelectedBox } from './ExteriorColorContainer';
import RankBanner from './RankBanner';

function InteriorColorContainer({
  data,
  setter,
}: {
  data: InteriorColor[];
  setter: React.Dispatch<React.SetStateAction<SelectedType>>;
}) {
  const { currentEstimation, setColorAndTrim, setTrimInteriorImage } =
    useContext(EstimationContext)!;
  function getAdoptionRate() {
    const nowData = data.find(
      item => item.colorName === currentEstimation.interiorColor.name,
    );
    return nowData?.adoptionRate as number;
  }
  const [adoptionRate, setAdoptionRate] = useState(getAdoptionRate());
  const [selectedColorName, setSelectedColorName] = useState(
    currentEstimation.interiorColor.name,
  );

  const setInterColor = useCallback(
    (item: InteriorColor) => {
      const colorItem = {
        name: item.colorName,
        price: item.colorPrice,
        img: item.colorImage,
        adoptionRate: item.adoptionRate,
      };
      setColorAndTrim({
        trim: {
          img: item.preview,
          name: currentEstimation.trim.name,
          price: currentEstimation.trim.price,
        },
        color: colorItem,
        type: 'interior',
      });
    },
    [setColorAndTrim, currentEstimation.trim],
  );

  useEffect(() => {
    if (data) {
      setTrimInteriorImage(currentEstimation.trimInteriorImage);
    }
  }, []);

  return (
    <>
      <Info>
        <span className="text-grey-100 body-medium-14">
          {currentEstimation.interiorColor.name}
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
                setInterColor(item);
                setAdoptionRate(item.adoptionRate);
                setSelectedColorName(item.colorName);
                setter('in');
              }}
            >
              <ColorButton src={item.colorImage} />
              <span>{item.colorName}</span>
              {index === 0 && <RankBanner text="Best" />}
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

export default InteriorColorContainer;

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
