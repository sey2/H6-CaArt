import React, { useState } from 'react';
import styled from 'styled-components';
import { OptionCard } from '../optionCard/OptionCard';
import { OptionInfoPopupBtn } from '../optionInfoPopup/OptionInfoPopupBtn';

function OptionCardListAdditionalTag({
  optionCategory,
}: {
  optionCategory: string;
}) {
  const [clickedPlusBtn, setClickecPlusBtn] = useState(-1);

  const tagOptionCardList = data.opsinos.map(item => {
    return (
      <>
        <OptionCard key={item.id} data={item} type={'additional'}></OptionCard>
        <OptionInfoPopupBtn
          top={item.positionX}
          left={item.positionY}
          id={item.id}
          clickedPlusBtn={clickedPlusBtn}
          setClickecPlusBtn={setClickecPlusBtn}
        ></OptionInfoPopupBtn>
      </>
    );
  });
  optionCategory; //api요청

  return (
    <OptionCardListAdditionalTagBox>
      <OptionCardListAdditionalTagImg
        src={data.optionTagImg}
      ></OptionCardListAdditionalTagImg>
      <OptionCardListBox>{tagOptionCardList}</OptionCardListBox>
      <OptionCardListAdditionalTagCaption className="caption-regular-12 text-grey-500">
        *상기 이미지는 이해를 돕기 위한 이미지로 실제 옵션 사진은 상세보기에서
        확인해주세요.
      </OptionCardListAdditionalTagCaption>
    </OptionCardListAdditionalTagBox>
  );
}

const OptionCardListAdditionalTagBox = styled.div`
  position: relative;
  display: inline-flex;
  flex-direction: column;
`;

const OptionCardListAdditionalTagImg = styled.img`
  width: 1024px;
  height: 490px;
  padding-top: 24px;
  padding-bottom: 40px;
`;

const OptionCardListBox = styled.div`
  display: inline-flex;
  align-items: flex-start;
  gap: 16px;
`;

const OptionCardListAdditionalTagCaption = styled.div`
  display: flex;
  margin-top: 36px;
`;

export { OptionCardListAdditionalTag };

const data = {
  //임시 데이터
  optionNum: 4,
  optionTagImg: 'https://picsum.photos/200/300',
  opsinos: [
    {
      id: 1,
      optionName: '컴포트2',
      optionText: '편의성을 위해 구성된 세트 옵션',
      optionImgSrc: 'https://picsum.photos/200/300',
      optionPrice: 1090000,
      optionBadge: '',
      optionPercent: 30,
      positionX: 100,
      positionY: 100,
    },
    {
      id: 2,
      optionName: '컴포트2',
      optionText: '편의성을 위해 구성된 세트 옵션',
      optionImgSrc: 'https://picsum.photos/200/300',
      optionPrice: 1090000,
      optionBadge: '',
      optionPercent: 30,
      positionX: 200,
      positionY: 200,
    },
    {
      id: 3,
      optionName: '컴포트2',
      optionText: '편의성을 위해 구성된 세트 옵션',
      optionImgSrc: 'https://picsum.photos/200/300',
      optionPrice: 1090000,
      optionBadge: '',
      optionPercent: 30,
      positionX: 300,
      positionY: 300,
    },
  ],
};
