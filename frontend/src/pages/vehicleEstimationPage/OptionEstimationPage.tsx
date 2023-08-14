import React, { useEffect, useState } from 'react';
import { styled } from 'styled-components';
import { Header } from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import OptionNavBar from '../../components/vehicleEstimationPage/optionEstimationPage/navBar/NavBar';
import OptionCardList from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardList';
import OptionCardListAdditionalTag from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardListAdditionalTag';
import OptionModal from '../../components/vehicleEstimationPage/optionEstimationPage/optionModal/OptionModal';

function OptionEstimationPage() {
  const [isBasicOptionPage, setIsBasicOptionPage] = useState(false);
  const [optionCategory, setOptionCategory] = useState('전체');
  const [openedModalId, setOpenedModalId] = useState(0);

  useEffect(() => {
    window.scrollTo({ left: 0, top: 0, behavior: 'smooth' });
  }, [isBasicOptionPage, optionCategory]);

  return (
    <OptionEstimationPageBox>
      <Header size="default" page={2}></Header>

      <OptionNavBar
        isBasicOptionPage={isBasicOptionPage}
        setIsBasicOptionPage={setIsBasicOptionPage}
        optionCategory={optionCategory}
        setOptionCategory={setOptionCategory}
      ></OptionNavBar>

      {!isBasicOptionPage && optionCategory === '전체' && (
        <OptionCardList
          options={data}
          type={'additionalAll'}
          setOpenedModalId={setOpenedModalId}
        ></OptionCardList>
      )}
      {!isBasicOptionPage && optionCategory !== '전체' && (
        <OptionCardListAdditionalTag
          optionCategory={optionCategory}
          setOpenedModalId={setOpenedModalId}
        ></OptionCardListAdditionalTag>
      )}
      {isBasicOptionPage && (
        <OptionCardList
          options={data}
          type={'basic'}
          setOpenedModalId={setOpenedModalId}
        ></OptionCardList>
      )}

      <OptionEstimationPageBtn>
        <SquareButton size="m" color="grey-50" bg="grey-1000" border>
          색상 선택
        </SquareButton>
        <SquareButton size="m" color="grey-1000" bg="primary-blue">
          견적 내기
        </SquareButton>
      </OptionEstimationPageBtn>

      {openedModalId !== 0 && (
        <OptionModal
          openedModalId={openedModalId}
          setOpenedModalId={setOpenedModalId}
        ></OptionModal>
      )}
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

const data = [
  {
    id: 1,
    name: '컴포트2',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: 'N Performance',
    percent: 80,
  },
  {
    id: 2,
    name: '컴포트3',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: 'H Genuine Accessories',
    percent: 35,
  },
  {
    id: 3,
    name: '컴포트4',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 65,
  },
  {
    id: 4,
    name: '컴포트5',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 5,
    name: '컴포트6',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 6,
    name: '컴포트7',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 7,
    name: '컴포트8',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 8,
    name: '컴포트9',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 9,
    name: '컴포트10',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 10,
    name: '컴포트11',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 11,
    name: '컴포트12',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 12,
    name: '컴포트13',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 13,
    name: '컴포트14',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 14,
    name: '컴포트15',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
  {
    id: 15,
    name: '컴포트16',
    description: '편의성을 위해 구성된 세트 옵션',
    imgSrc: 'https://picsum.photos/200/300',
    price: 1090000,
    badge: '',
    percent: 35,
  },
];
