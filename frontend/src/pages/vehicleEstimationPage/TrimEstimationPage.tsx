import React, { useState } from 'react';
import styled from 'styled-components';
import { Header } from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import CompareModal from '../../components/vehicleEstimationPage/trimEstimationPage/CompareModal';
import EBWContainer from '../../components/vehicleEstimationPage/trimEstimationPage/EBWContainer';
import EBWGuideModal from '../../components/vehicleEstimationPage/trimEstimationPage/EBWGuideModal';
import TrimCarImage from '../../components/vehicleEstimationPage/trimEstimationPage/TrimCarImage';
import TrimContainer from '../../components/vehicleEstimationPage/trimEstimationPage/TrimContainer';

function TrimEstimationPage() {
  const [infoModalOpen, setInfoModalOpen] = useState<boolean>(false);
  const [compareModalOpen, setComapreModalOpen] = useState<boolean>(false);

  return (
    <>
      {infoModalOpen && <EBWGuideModal setter={setInfoModalOpen} />}
      {compareModalOpen && <CompareModal setter={setComapreModalOpen} />}
      <Wrapper modalStatus={compareModalOpen}>
        <Header size="default" page={0} />
        <Layout>
          <TrimCarImage />
          <RightBox>
            <InfoText onClick={() => setInfoModalOpen(true)}>
              <img src="/images/question_icon.svg" />
              <span className="text-secondary-active-blue body-medium-14">
                고르기 어렵다면?
              </span>
            </InfoText>
            <EBWContainer />
            <TrimContainer setter={setComapreModalOpen} />
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

const Wrapper = styled.div<{ modalStatus: boolean }>`
  z-index: 4;
  /* overflow: ${props => (props.modalStatus ? 'hidden' : 'unset')}; */
  ${props => props.modalStatus && `position:fixed`}
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
  display: flex;
  gap: 4px;
  align-items: center;
  text-decoration: underline;
  text-underline-offset: 3px;
  margin-bottom: 14px;
  cursor: pointer;
`;
