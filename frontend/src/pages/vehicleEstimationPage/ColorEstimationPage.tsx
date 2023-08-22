import React, { useState, useContext } from 'react';
import styled from 'styled-components';
import Header from '../../components/common/header/Header';
import LeftCarImageContainer from '../../components/vehicleEstimationPage/colorEstimationPage/LeftCarImageContainer';
import Dropdown from '../../components/vehicleEstimationPage/colorEstimationPage/Dropdown';
import ExteriorColorContainer from '../../components/vehicleEstimationPage/colorEstimationPage/ExteriorColorContainer';
import InteriorColorContainer from '../../components/vehicleEstimationPage/colorEstimationPage/InteriorColorContainer';
import SquareButton from '../../components/common/SquareButton';
import { Link } from 'react-router-dom';
import { useFetch } from '../../hooks/useFetch';
import { ErrorPopup } from '../../components/common/ErrorPopup';
import { EstimationContext } from '../../util/Context';
import { Hr } from '../../components/common/Hr';

export interface ExteriorColor {
  colorId: number;
  colorName: string;
  colorImage: string;
  colorPrice: number;
  adoptionRate: number;
  previews: string[];
}

export interface InteriorColor {
  colorId: number;
  colorName: string;
  colorImage: string;
  colorPrice: number;
  adoptionRate: number;
  preview: string;
}

export interface Trim {
  trimId: number;
  trimName: string;
  trimPrice: number;
  colorId: number;
  colorName: string;
  colorImage: string;
  preview: string;
}

interface CarData {
  exteriorColors: ExteriorColor[];
  otherTrimExteriorColors: Trim[];
  interiorColors: InteriorColor[];
  otherTrimInteriorColors: Trim[];
}

export type SelectedType = 'ex' | 'in' | '360' | string;

function ColorEstimationPage() {
  function getTrimId(trimName: string) {
    switch (trimName) {
      case 'Exclusive':
        return 2;
      case 'Le Blanc':
        return 1;
      case 'Prestige':
        return 3;
      case 'Calligraphy':
        return 4;
    }
  }
  const { currentEstimation } = useContext(EstimationContext)!;
  const { data, status, error } = useFetch<CarData>(
    `/colors?trimId=${getTrimId(currentEstimation.trim.name)}`,
  );
  const [modal, setModal] = useState({
    isopen: false,
    nowTrim: {
      name: currentEstimation.trim.name,
      price: currentEstimation.trim.price,
      img: currentEstimation.trim.img,
    },
    changeTrim: {
      name: '',
      price: 0,
      img: '',
    },
    color: {
      name: '',
      price: 0,
      img: '',
    },
    type: 'exterior',
  });

  const [selectedType, setSelectedType] = useState<SelectedType>('ex');
  if (status === 'loading') {
    return <div>loading</div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;
  console.log(data);
  console.log(currentEstimation.trimInteriorImage);
  return (
    <>
      <Wrapper>
        <Header size="large" page={0} />
        <Layout>
          <LeftCarImageContainer
            type={selectedType}
            state={selectedType}
            setter={setSelectedType}
            data={data.exteriorColors}
          />
          <RightBox>
            <HeadTitle className="text-grey-0 head-medium-20">
              외장 색상
            </HeadTitle>
            <ExteriorColorContainer
              data={data.exteriorColors}
              setter={setSelectedType}
              type={selectedType}
            />
            <Dropdown
              type="exterior"
              data={data.otherTrimExteriorColors}
              setter={setModal}
              modaldata={modal}
            />
            <Hr margin="32px 0px 0px 0px" width={308} />
            <HeadTitle className="text-grey-0 head-medium-20">
              내장 색상
            </HeadTitle>
            <InteriorColorContainer
              data={data.interiorColors}
              setter={setSelectedType}
            />
            <Dropdown
              type="interior"
              data={data.otherTrimInteriorColors}
              setter={setModal}
              modaldata={modal}
            />
            <ButtonContainer className="body-medium-16">
              <Link to="/estimate/trim">
                <SquareButton size="xs" color="grey-50" border>
                  트림 선택
                </SquareButton>
              </Link>
              <Link to="/estimate/option">
                <SquareButton
                  size="xs"
                  color="grey-1000"
                  bg="primary-blue"
                  border
                >
                  옵션 선택
                </SquareButton>
              </Link>
            </ButtonContainer>
          </RightBox>
        </Layout>
      </Wrapper>
    </>
  );
}

export default ColorEstimationPage;

const Wrapper = styled.div`
  z-index: 4;
`;

const Layout = styled.div`
  display: grid;
  height: calc(100vh - 120px);
  grid-template-columns: 2fr 1fr;
`;

const RightBox = styled.div`
  padding: 0px 0px 36px 51px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  overflow-y: scroll;
  ::-webkit-scrollbar {
    display: none;
  }
`;

const HeadTitle = styled.p`
  margin-top: 48px;
  margin-bottom: 16px;
`;

const ButtonContainer = styled.div`
  display: flex;
  gap: 8px;
  margin-top: 32px;
`;
