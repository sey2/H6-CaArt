import React, { useState } from 'react';
import styled from 'styled-components';
import { Header } from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import ToolTip from '../../components/common/ToolTip';
import CompareModal from '../../components/vehicleEstimationPage/trimEstimationPage/CompareModal';
import EBWContainer from '../../components/vehicleEstimationPage/trimEstimationPage/EBWContainer';
import EBWGuideModal from '../../components/vehicleEstimationPage/trimEstimationPage/EBWGuideModal';
import TrimCarImage from '../../components/vehicleEstimationPage/trimEstimationPage/TrimCarImage';
import TrimContainer from '../../components/vehicleEstimationPage/trimEstimationPage/TrimContainer';
import OptionExplainModal from '../../components/vehicleEstimationPage/trimEstimationPage/OptionExplainModal';

export interface OptionType {
  optionId: number;
  optionName: string;
  description: string;
  optionImage: string;
}

function TrimEstimationPage() {
  const [infoModalOpen, setInfoModalOpen] = useState<boolean>(false);
  const [compareModalOpen, setComapreModalOpen] = useState<boolean>(false);
  const [tooltipOpen, setTooltipOpen] = useState<boolean>(false);
  const [tooltipType, setTooltipType] = useState<string | undefined>('엔진');
  const [tooltipPosition, setTooltipPosition] = useState({ x: 0, y: 0 });
  const [optionModalOpen, setOptionModalOpen] = useState(false);
  const [modalOptionPosition, setModalOptionPosition] = useState({
    x: 0,
    y: 0,
  });
  const [optionModalData, setOptionModalData] = useState<OptionType>();

  function closeModalHandler() {
    setTooltipOpen(false);
    setOptionModalOpen(false);
  }

  return (
    <>
      {infoModalOpen && <EBWGuideModal setter={setInfoModalOpen} />}
      {compareModalOpen && <CompareModal setter={setComapreModalOpen} />}
      {tooltipOpen && (
        <ToolTip
          x={tooltipPosition.x}
          y={tooltipPosition.y}
          tooltipType={tooltipType}
        />
      )}
      {optionModalOpen && (
        <OptionExplainModal
          x={modalOptionPosition.x}
          y={modalOptionPosition.y}
          setter={setOptionModalOpen}
          data={optionModalData}
        />
      )}

      <Wrapper onClick={closeModalHandler}>
        <Header size="default" page={0} />
        <Layout>
          <TrimCarImage />
          <RightBox onScroll={closeModalHandler}>
            <InfoText onClick={() => setInfoModalOpen(true)}>
              <img src="/images/question_icon.svg" />
              <span className="text-secondary-active-blue body-medium-14">
                고르기 어렵다면?
              </span>
            </InfoText>
            <EBWContainer
              openSetter={setTooltipOpen}
              typeSetter={setTooltipType}
              positionSetter={setTooltipPosition}
            />
            <TrimContainer
              setter={setComapreModalOpen}
              optionModalPositionSetter={setModalOptionPosition}
              optionModalOpenSetter={setOptionModalOpen}
              tooltipOpenSetter={setTooltipOpen}
              tooltipTypeSetter={setTooltipType}
              tooltipPositionSetter={setTooltipPosition}
              optionSetter={setOptionModalData}
            />
            <SquareButton size="xm" bg="primary-blue" color="grey-1000">
              색상 선택
            </SquareButton>
          </RightBox>
        </Layout>
      </Wrapper>
    </>
  );
}

export default TrimEstimationPage;

const Wrapper = styled.div`
  z-index: 4;
  ::-webkit-scrollbar {
    display: none;
  }
`;

const Layout = styled.div`
  display: grid;
  height: calc(100vh - 120px);
  grid-template-columns: 2fr 1fr;
`;

const RightBox = styled.div`
  padding: 51px 0px 36px 51px;
  overflow-y: scroll;
  ::-webkit-scrollbar {
    display: none;
  }
`;

const InfoText = styled.div`
  color: var(--secondary-active-blue);
  display: inline-flex;
  gap: 4px;
  align-items: center;
  text-decoration: underline;
  text-underline-offset: 3px;
  margin-bottom: 14px;
  cursor: pointer;
`;
