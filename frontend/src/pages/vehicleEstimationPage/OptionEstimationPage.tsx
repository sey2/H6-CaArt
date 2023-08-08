import React, { useEffect, useRef, useState } from 'react';
import { styled } from 'styled-components';
import { Header } from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import { OptionNavBar } from '../../components/vehicleEstimationPage/optionEstimationPage/navBar/NavBar';
import { OptionCardListAdditionalAll } from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardListAdditionalAll';

function OptionEstimationPage() {
  const [isBasicOptionPage, setIsBasicOptionPage] = useState(false);
  const [optionCategory, setOptionCategory] = useState('전체');
  const topDom = useRef<null | HTMLDivElement>(null);

  useEffect(() => {
    if (topDom.current) {
      topDom.current.scrollIntoView({ behavior: 'smooth' });
    }
  }, [isBasicOptionPage, optionCategory]);

  return (
    <OptionEstimationPageBox>
      <div ref={topDom} style={{ width: '100%' }}>
        <Header size="default" page={2}></Header>
      </div>
      <OptionNavBar
        isBasicOptionPage={isBasicOptionPage}
        setIsBasicOptionPage={setIsBasicOptionPage}
        optionCategory={optionCategory}
        setOptionCategory={setOptionCategory}
      ></OptionNavBar>
      <OptionCardListAdditionalAll options={data}></OptionCardListAdditionalAll>
      <OptionEstimationPageBtn>
        <SquareButton size="m" color="grey-50" bg="grey-1000" border>
          색상 선택
        </SquareButton>
        <SquareButton size="m" color="grey-1000" bg="primary-blue">
          견적 내기
        </SquareButton>
      </OptionEstimationPageBtn>
    </OptionEstimationPageBox>
  );
}

export interface OptionNavBarProps {
  isBasicOptionPage: boolean;
  setIsBasicOptionPage: React.Dispatch<React.SetStateAction<boolean>>;
  optionCategory: string;
  setOptionCategory: React.Dispatch<React.SetStateAction<string>>;
}

const OptionEstimationPageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const OptionEstimationPageBtn = styled.div`
  display: flex;
  gap: 8px;
  margin-top: 48px;
  margin-bottom: 79px;
`;

export default OptionEstimationPage;
