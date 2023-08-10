import React, { useState } from 'react';
import styled from 'styled-components';
import ColorChangePopup from '../../components/vehicleEstimationPage/colorEstimationPage/ColorChangePopup';
import { Header } from '../../components/common/header/Header';
import LeftCarImageContainer from '../../components/vehicleEstimationPage/colorEstimationPage/LeftCarImageContainer';
import Dropdown from '../../components/vehicleEstimationPage/colorEstimationPage/Dropdown';
import ColorContainer from '../../components/vehicleEstimationPage/colorEstimationPage/ColorContainer';
import SquareButton from '../../components/common/SquareButton';

function ColorEstimationPage() {
  const [innerDDState, setInnerDDState] = useState(false);
  const [outerDDState, setOuterDDState] = useState(false);
  const [modal, setModal] = useState(false);
  const [selectedType, setSelectedType] = useState<
    'ex' | 'in' | '360' | string
  >('ex');
  return (
    <>
      {modal && <ColorChangePopup setter={setModal} />}
      <Wrapper>
        <Header size="default" page={0} />
        <Layout>
          <LeftCarImageContainer
            type={selectedType}
            state={selectedType}
            setter={setSelectedType}
          />
          <RightBox>
            <HeadTitle className="text-grey-0 head-medium-20">
              외장 색상
            </HeadTitle>
            <ColorContainer />
            <Dropdown
              type="outer"
              innerColorDDSetter={setInnerDDState}
              innerColorDDState={innerDDState}
              outerColorDDSetter={setOuterDDState}
              outerColorDDState={outerDDState}
            />
            <Hr />
            <HeadTitle className="text-grey-0 head-medium-20">
              내장 색상
            </HeadTitle>
            <ColorContainer />
            <Dropdown
              type="inner"
              innerColorDDSetter={setInnerDDState}
              innerColorDDState={innerDDState}
              outerColorDDSetter={setOuterDDState}
              outerColorDDState={outerDDState}
            />
            <ButtonContainer className="body-medium-16">
              <SquareButton size="xs" color="grey-50" border>
                트림 선택
              </SquareButton>
              <SquareButton
                size="xs"
                color="grey-1000"
                bg="primary-blue"
                border
              >
                옵션 선택
              </SquareButton>
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
  overflow-y: scroll;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  ::-webkit-scrollbar {
    display: none;
  }
`;

const HeadTitle = styled.p`
  margin-top: 48px;
  margin-bottom: 16px;
`;

const Hr = styled.hr`
  width: 308px;
  border-color: var(--primary-blue-10);
  margin: 32px 0px 0px 0px;
`;

const ButtonContainer = styled.div`
  display: flex;
  gap: 8px;
  margin-top: 32px;
`;
