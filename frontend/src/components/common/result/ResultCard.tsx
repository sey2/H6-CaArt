import React from 'react';
import styled from 'styled-components';
import { useLocation } from 'react-router-dom';
import { priceToString } from '../../../util/PriceToString';

export interface ResultCardProps {
  type: 'exterior' | 'interior' | 'option';
  title: string;
  price: number;
  imgSrc: string;
  text: string;
}

function ResultCard({ type, title, price, imgSrc, text }: ResultCardProps) {
  const url = useLocation().pathname;

  return (
    <ResultCardBox>
      <ResultCardUpper>
        <ResultCardImg src={imgSrc}></ResultCardImg>
        <ResultCardText>
          <span className="body-regular-14 text-grey-200">
            {type === 'exterior'
              ? `외장 - ${title}`
              : type === 'interior'
              ? `내장 - ${title}`
              : `${title}`}
          </span>
          <span className="head-medium-16 text-grey-100">
            {priceToString(price)}
          </span>
        </ResultCardText>
      </ResultCardUpper>
      {url !== '/result' && (
        <ResultCardLower>
          <span className="body-regular-14 text-secondary-active-blue">
            {text}
          </span>
        </ResultCardLower>
      )}
    </ResultCardBox>
  );
}

const ResultCardBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;
`;

const ResultCardUpper = styled.div`
  display: flex;
  gap: 16px;
  width: 296px;
`;

const ResultCardImg = styled.img`
  width: 60px;
  height: 60px;
  border-radius: 4px;
`;

const ResultCardText = styled.div`
  display: flex;
  flex-direction: column;
`;

const ResultCardLower = styled.div`
  display: inline-flex;
  justify-content: flex-start;
  align-items: center;
  width: 296px;
  padding: 12px;
  margin-bottom: 14px;
  border-radius: 8px;
  background: rgba(33, 151, 201, 0.1);
`;

export default ResultCard;
