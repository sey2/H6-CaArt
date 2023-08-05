import React from 'react';
import styled from 'styled-components';
import TrimCard from './TrimCard';

function TrimContainer() {
  return (
    <Box>
      <TrimHeader>
        <span className="head-medium-20 text-grey-0">트림</span>
        <CompareButton className="body-regular-12 text-grey-0">
          비교하기
        </CompareButton>
      </TrimHeader>
      <TrimCard trim="Exclusive" />
      <Hr />
      <TrimCard trim="Le Blanc" />
      <Hr />
      <TrimCard trim="Prestige" />
      <Hr />
      <TrimCard trim="Caligraphy" />
    </Box>
  );
}

export default TrimContainer;

const Box = styled.div`
  width: 335px;
  flex-shrink: 0;
  display: flex;
  flex-direction: column;
  margin-top: 34px;
`;

const CompareButton = styled.div`
  display: inline-flex;
  padding: 4px 12px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  border-radius: 20px;
  border: 1px solid var(--grey-scale-grey-700, #ebebeb);
`;

const TrimHeader = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 26px;
`;

const Hr = styled.hr`
  width: 308px;
  margin: 16px 0;
  flex-shrink: 0;
  border-width: 1px 0 0 0;
  border-color: var(--primary-blue-10);
`;
