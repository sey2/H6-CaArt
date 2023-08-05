import React from 'react';
import styled from 'styled-components';
import { Header } from '../../components/common/Header';
import SquareButton from '../../components/common/SquareButton';
import EBWContainer from "../../components/vehicleEstimationPage/trimEstimationPage/EBWContainer";
import TrimContainer from "../../components/vehicleEstimationPage/trimEstimationPage/TrimContainer";

function TrimEstimationPage() {
  return (
    <>
      <Header size="default" page={0} />
      <Layout>
        <div style={{ backgroundColor: 'black', height: '100%' }}></div>
        <RightBox>
          <EBWContainer />
          <TrimContainer />
          <SquareButton size="xm" bg="primary-blue" color="grey-1000">
            색상 선택
          </SquareButton>
        </RightBox>
      </Layout>
    </>
  );
}

export default TrimEstimationPage;

const Layout = styled.div`
  display: grid;
  grid-template-columns: 2fr 1fr;
`;

const RightBox = styled.div`
  padding-left: 36px;
  padding-top: 51px;
`;

