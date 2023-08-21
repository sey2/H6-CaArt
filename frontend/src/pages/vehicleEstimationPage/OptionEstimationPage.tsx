import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { styled } from 'styled-components';
import Header from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import OptionNavBar from '../../components/vehicleEstimationPage/optionEstimationPage/navBar/NavBar';
import OptionCardList from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardList';
import OptionCardListAdditionalTag from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardListAdditionalTag';
import OptionCardListBasic from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardListBasic';
import OptionModal from '../../components/vehicleEstimationPage/optionEstimationPage/optionModal/OptionModal';

function OptionEstimationPage() {
  const [isBasicOptionPage, setIsBasicOptionPage] = useState(false);
  const [optionCategory, setOptionCategory] = useState({
    name: '전체',
    img: '',
    id: 0,
  });
  const [openedModalId, setOpenedModalId] = useState(0);
  const [page, setPage] = useState(0);

  useEffect(() => {
    window.scrollTo({ left: 0, top: 0, behavior: 'smooth' });
    setPage(0);
  }, [isBasicOptionPage, optionCategory]);

  return (
    <OptionEstimationPageBox>
      <Header size="large" page={2}></Header>

      <OptionNavBar
        isBasicOptionPage={isBasicOptionPage}
        setIsBasicOptionPage={setIsBasicOptionPage}
        optionCategory={optionCategory}
        setOptionCategory={setOptionCategory}
      ></OptionNavBar>

      {!isBasicOptionPage && optionCategory.name === '전체' && (
        <OptionCardList
          page={page}
          setPage={setPage}
          type={'additionalAll'}
          setOpenedModalId={setOpenedModalId}
        ></OptionCardList>
      )}
      {!isBasicOptionPage && optionCategory.name !== '전체' && (
        <OptionCardListAdditionalTag
          optionCategory={optionCategory}
          setOpenedModalId={setOpenedModalId}
        ></OptionCardListAdditionalTag>
      )}
      {isBasicOptionPage && (
        <OptionCardListBasic
          optionCategory={optionCategory}
          page={page}
          setPage={setPage}
          type={'basic'}
          setOpenedModalId={setOpenedModalId}
        ></OptionCardListBasic>
      )}

      <OptionEstimationPageBtn>
        <Link to="/estimate/color">
          <SquareButton size="m" color="grey-50" bg="grey-1000" border>
            색상 선택
          </SquareButton>
        </Link>
        <Link to="/result">
          <SquareButton size="m" color="grey-1000" bg="primary-blue">
            견적 내기
          </SquareButton>
        </Link>
      </OptionEstimationPageBtn>

      {openedModalId !== 0 && (
        <OptionModal
          isBasicOptionPage={isBasicOptionPage}
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

const OptionEstimationPageBtn = styled.div`
  display: flex;
  gap: 8px;
  margin-top: 48px;
  margin-bottom: 79px;
`;

export default OptionEstimationPage;
