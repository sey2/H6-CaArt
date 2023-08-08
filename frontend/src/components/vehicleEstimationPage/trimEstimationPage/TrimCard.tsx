import React, { useContext } from 'react';
import styled from 'styled-components';
import { EstimationContext } from '../../../util/Context';
import { priceToString } from '../../../util/PriceToString';

function TrimCard({
  trim,
  modalSetter,
  positionSetter,
  tooltipOpenSetter,
  tooltipTypeSetter,
  tooltipPositionSetter,
}: {
  trim: 'Exclusive' | 'Le Blanc' | 'Prestige' | 'Caligraphy' | string;
  modalSetter: React.Dispatch<React.SetStateAction<boolean>>;
  positionSetter: React.Dispatch<
    React.SetStateAction<{ x: number; y: number }>
  >;
  tooltipOpenSetter: React.Dispatch<React.SetStateAction<boolean>>;
  tooltipTypeSetter: React.Dispatch<React.SetStateAction<string | undefined>>;
  tooltipPositionSetter: React.Dispatch<
    React.SetStateAction<{ x: number; y: number }>
  >;
}) {
  const { currentEstimation, setTrim } = useContext(EstimationContext)!;
  const data = {
    trimList: [
      {
        trimName: 'Exclusive',
        trimInfo: '합리적인 당신을 위한',
        trimPrice: 10000000,
        trimOption: [
          {
            id: 0,
            name: '12인치 네비게이션',
            info: '11',
            image: '11',
          },
          {
            id: 1,
            name: '내비 기반 크루즈 컨트롤',
            info: '11',
            image: '11',
          },
          {
            id: 2,
            name: '세이프티 파워 윈도우',
            info: '11',
            image: '11',
          },
        ],
      },
      {
        trimName: 'Le Blanc',
        trimInfo: '필수적인 옵션만 모은',
        trimPrice: 20000000,
        trimOption: [
          {
            id: 0,
            name: '20인치 알로이 휠',
            info: '11',
            image: '11',
          },
          {
            id: 1,
            name: '12인치 클러스터',
            info: '11',
            image: '11',
          },
          {
            id: 2,
            name: '서라운드 뷰 모니터',
            info: '11',
            image: '11',
          },
        ],
      },
      {
        trimName: 'Prestige',
        trimInfo: '가치있는 드라이빙 경험을 주는',
        trimPrice: 30000000,
        trimOption: [
          {
            id: 0,
            name: '2열 통풍시트',
            info: '11',
            image: '11',
          },
          {
            id: 1,
            name: '스마트 자세제어',
            info: '11',
            image: '11',
          },
          {
            id: 2,
            name: '2열 수동식 도어 커튼',
            info: '11',
            image: '11',
          },
        ],
      },
      {
        trimName: 'Caligraphy',
        trimInfo: '남들과 차별화된 경험',
        trimPrice: 40000000,
        trimOption: [
          {
            id: 0,
            name: '20인치 캘리그라피 전용 휠',
            info: '11',
            image: '11',
          },
          {
            id: 1,
            name: 'KRELL 프리미엄 사운드',
            info: '11',
            image: '11',
          },
          {
            id: 2,
            name: '블랙 에디션',
            info: '11',
            image: '11',
          },
        ],
      },
    ],
  };
  function handleModal(e: React.MouseEvent) {
    e.stopPropagation();
    const offsetX = e.nativeEvent.offsetX;
    const offsetY = e.nativeEvent.offsetY;
    const clickedX = e.clientX;
    const clickedY = e.clientY;
    const x = clickedX - offsetX - 150;
    const y = clickedY - offsetY - 421;
    positionSetter({ x, y });
    modalSetter(true);
  }

  function getOptionList(trim: string) {
    return data.trimList.map(trimItem => {
      if (trimItem.trimName === trim) {
        return trimItem.trimOption.map(option => (
          <>
            <li key={option.name} onClick={e => handleModal(e)}>
              {option.name}
            </li>
          </>
        ));
      }
    });
  }

  function getTotalTrimPrice(trim: string) {
    const enginePrice = currentEstimation.engine.price;
    const bodyPrice = currentEstimation.body.price;
    const wdPrice = currentEstimation.wd.price;
    const trimPrice = data.trimList.find(
      trimItem => trimItem.trimName == trim,
    )?.trimPrice;
    return enginePrice + bodyPrice + wdPrice + trimPrice!;
  }

  function handleCheckBtnClick(e: React.MouseEvent) {
    e.stopPropagation();
    const checkBtn = e.target as HTMLElement;
    const targetElement =
      checkBtn.parentElement?.parentElement?.parentElement?.firstElementChild;
    const rect = targetElement?.getBoundingClientRect() as DOMRect;
    const y = rect.x - 20;
    const x = rect.y - 100;
    tooltipTypeSetter('트림');
    tooltipPositionSetter({ x: x, y: y });
    tooltipOpenSetter(true);
  }

  return (
    <>
      <Wrapper>
        {data.trimList.map(trimItem => {
          if (trimItem.trimName === trim)
            return (
              <>
                <Head>
                  <CarInfo>
                    <span className="text-grey-300 body-medium-14">
                      {trimItem.trimName}
                    </span>
                    <span className="text-grey-500 caption-regular-12 ">
                      <>
                        {currentEstimation.engine.name} ･&nbsp;
                        {currentEstimation.body.name}
                        &nbsp; ･&nbsp;
                        {currentEstimation.wd.name}
                      </>
                    </span>
                  </CarInfo>
                  <CheckButton
                    src={
                      currentEstimation.trim.name === trimItem.trimName
                        ? '/images/check_circle_blue_bold.svg'
                        : '/images/check_circle_grey_bold.svg'
                    }
                    onClick={e => {
                      setTrim({
                        name: trimItem.trimName,
                        price: trimItem.trimPrice,
                      });
                      handleCheckBtnClick(e);
                    }}
                  />
                </Head>
                <TrimSummary className="text-grey-100 body-regular-16">
                  {trimItem.trimInfo}
                </TrimSummary>
                <TrimPrice className="text-grey-0 head-medium-20">
                  {priceToString(getTotalTrimPrice(trim))}
                </TrimPrice>
                <OptionBox>
                  <span className="text-grey-300 body-medium-14">
                    기본 옵션
                  </span>
                  <OptionList className="text-secondary-active-blue body-regular-14">
                    {getOptionList(trim)}
                  </OptionList>
                </OptionBox>
              </>
            );
        })}
      </Wrapper>
    </>
  );
}

export default TrimCard;

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
`;

const Head = styled.div`
  display: flex;
  gap: 8px;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 6px;
  position: relative;
`;

const OptionBox = styled.div`
  display: inline-flex;
  gap: 12px;
`;

const OptionList = styled.ul`
  display: flex;
  width: 242px;
  align-items: flex-start;
  align-content: flex-start;
  gap: 6px 12px;
  flex-wrap: wrap;
  text-underline-offset: 3px;
  text-decoration: underline;
  li {
    cursor: pointer;
    position: relative;
  }
`;

const CarInfo = styled.div`
  display: flex;
  gap: 8px;
  align-items: center;
`;

const TrimSummary = styled.div`
  margin-bottom: 8px;
`;

const TrimPrice = styled.div`
  margin-bottom: 14px;
`;

const CheckButton = styled.img`
  position: absolute;
  right: 30px;
  top: 5px;
  cursor: pointer;
`;
