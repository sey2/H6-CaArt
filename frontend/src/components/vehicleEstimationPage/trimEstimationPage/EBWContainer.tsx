import React, { useContext } from 'react';
import styled from 'styled-components';
import EBWButton from './EBWButton';
import { EstimationContext } from '../../../util/Context';

function EBWContainer() {
  const { setEngine, setBody, setWd } = useContext(EstimationContext)!;
  function handleButtonClick(value: string, price: number) {
    console.log(value);
    switch (value) {
      case '디젤 2.2':
      case '가솔린 3.8':
        setEngine({ name: value, price: price });
        break;

      case '7인승':
      case '8인승':
        setBody({ name: value, price: price });
        break;

      case '2WD':
      case '4WD':
        setWd({ name: value, price: price });
        break;
      default:
        break;
    }
  }

  return (
    <Box className="body-medium-14 text-grey-200">
      <p>엔진</p>
      <ButtonBox>
        <EBWButton value="디젤 2.2" price={0} onClick={handleButtonClick} />
        <EBWButton
          value="가솔린 3.8"
          price={1000}
          onClick={handleButtonClick}
        />
      </ButtonBox>
      <p>바디</p>
      <ButtonBox>
        <EBWButton value="7인승" price={0} onClick={handleButtonClick} />
        <EBWButton value="8인승" price={3000} onClick={handleButtonClick} />
      </ButtonBox>
      <p>구동방식</p>
      <ButtonBox>
        <EBWButton value="2WD" price={0} onClick={handleButtonClick} />
        <EBWButton value="4WD" price={5000} onClick={handleButtonClick} />
      </ButtonBox>
    </Box>
  );
}

export default EBWContainer;

const Box = styled.div`
  width: 309px;
  /* height: 246px; */
  flex-shrink: 0;
  border-radius: 8px;
  border: 1px solid var(--grey-700);
  padding: 12px;
  padding-bottom: 0;
`;

const ButtonBox = styled.div`
  display: flex;
  padding-bottom: 12px;
  margin-top: 4px;
`;
