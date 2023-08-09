import React, { useEffect, useRef, useState } from 'react';
import { styled } from 'styled-components';
import { Header } from '../../components/common/header/Header';
import SquareButton from '../../components/common/SquareButton';
import { OptionNavBar } from '../../components/vehicleEstimationPage/optionEstimationPage/navBar/NavBar';
import { OptionCardList } from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardList';
import { OptionCardListAdditionalTag } from '../../components/vehicleEstimationPage/optionEstimationPage/optionCardList/OptionCardListAdditionalTag';
import { OptionModal } from '../../components/vehicleEstimationPage/optionEstimationPage/optionModal/OptionModal';

function OptionEstimationPage() {
  const [isBasicOptionPage, setIsBasicOptionPage] = useState(false);
  const [optionCategory, setOptionCategory] = useState('전체');
  const topDom = useRef<null | HTMLDivElement>(null);
  const [openedModalId, setOpenedModalId] = useState(0);

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

      {!isBasicOptionPage && optionCategory === '전체' && (
        <OptionCardList
          options={data}
          type={'additional'}
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
          data={modalData}
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

const modalData = {
  name: '컴포트2',
  price: 1090000,
  description: '테스트 컴포트2 설명',
  img: 'https://picsum.photos/200/300',
  tagList: ['안전', '스타일'],
  setOptions: [
    {
      name: '세트옵션1',
      description: '세트옵션 설명1',
      img: 'https://picsum.photos/200/300',
    },
    {
      name: '세트옵션2',
      description: '세트옵션 설명2',
      img: 'https://picsum.photos/200/300',
    },
    {
      name: '세트옵션3',
      description: '세트옵션 설명3',
      img: 'https://picsum.photos/200/300',
    },
    {
      name: '세트옵션4',
      description: '세트옵션 설명4',
      img: 'https://picsum.photos/200/300',
    },
    {
      name: '세트옵션5',
      description: '세트옵션 설명5',
      img: 'https://picsum.photos/200/300',
    },
    {
      name: '세트옵션6',
      description: '세트옵션 설명6',
      img: 'https://picsum.photos/200/300',
    },
  ],
};

const data = [
  {
    id: 1,
    optionName: '컴포트2',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 2,
    optionName: '컴포트3',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 3,
    optionName: '컴포트4',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 4,
    optionName: '컴포트5',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 5,
    optionName: '컴포트22',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 6,
    optionName: '컴포트33',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 7,
    optionName: '컴포트55',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 8,
    optionName: '컴포트3',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 9,
    optionName: '컴포트4',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 10,
    optionName: '컴포트5',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 11,
    optionName: '컴포트22',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 12,
    optionName: '컴포트33',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 13,
    optionName: '컴포트44',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 14,
    optionName: '컴포트55',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
  {
    id: 15,
    optionName: '컴포트44',
    optionText: '편의성을 위해 구성된 세트 옵션',
    optionImgSrc: 'https://picsum.photos/200/300',
    optionPrice: 1090000,
    optionBadge: '',
    optionPercent: 35,
  },
];
