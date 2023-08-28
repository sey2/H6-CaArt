import React, { useEffect, useState } from 'react';
import { styled } from 'styled-components';
import Header from '../../components/common/header/Header';
import OptionNavBar from '../../components/vehicleEstimationPage/optionEstimationPage/navBar/NavBar';
import OptionCardList from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardList';
import OptionEstimationPageButton from '../../components/vehicleEstimationPage/optionEstimationPage/button/OptionPageButton';
import OptionModal from '../../components/vehicleEstimationPage/optionEstimationPage/optionModal/OptionModal';
import useScrollTop from '../../hooks/useScrollTop';

export interface OptionCategoryProps {
  isBasic: boolean;
  name: string;
  img: string;
  id: number;
  page: number;
}

export interface OptionComponentProps {
  optionCategory: OptionCategoryProps;
  setOptionCategory: React.Dispatch<React.SetStateAction<OptionCategoryProps>>;
}

function OptionEstimationPage() {
  const [optionCategory, setOptionCategory] = useState({
    isBasic: false,
    name: '전체',
    img: '',
    id: 0,
    page: 0,
  });
  const [openedModalId, setOpenedModalId] = useState(0);

  useScrollTop();

  useEffect(() => {
    window.scrollTo({ left: 0, top: 0, behavior: 'smooth' });
  }, [optionCategory]);

  return (
    <OptionEstimationPageBox>
      <Header size="large" page={2}></Header>
      <OptionNavBar
        optionCategory={optionCategory}
        setOptionCategory={setOptionCategory}
      ></OptionNavBar>

      <OptionCardList
        optionCategory={optionCategory}
        setOptionCategory={setOptionCategory}
        setOpenedModalId={setOpenedModalId}
      ></OptionCardList>

      <OptionEstimationPageButton></OptionEstimationPageButton>

      {openedModalId !== 0 && (
        <OptionModal
          isBasicOptionPage={optionCategory.isBasic}
          openedModalId={openedModalId}
          setOpenedModalId={setOpenedModalId}
        ></OptionModal>
      )}
    </OptionEstimationPageBox>
  );
}

const OptionEstimationPageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export default OptionEstimationPage;
