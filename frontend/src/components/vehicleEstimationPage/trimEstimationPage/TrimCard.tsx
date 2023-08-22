import React, { useContext } from 'react';
import styled from 'styled-components';
import { useFetch } from '../../../hooks/useFetch';
import { OptionType } from '../../../pages/vehicleEstimationPage/TrimEstimationPage';
import { useModalContext } from '../../../store/ModalContext';
import { EstimationContext } from '../../../util/Context';
import { priceToString } from '../../../util/PriceToString';
import { FlexBox } from '../../common/FlexBox';
import TrimData, { TrimDataProps } from '../../../static/data/TrimData';

interface Option {
  optionId: number;
  optionName: string;
  description: string;
  optionImage: string;
}

export interface Color {
  colorId: number;
  colorName: string;
  colorPrice: number;
  colorImage: string;
}

export interface Trim {
  trimName: string;
  description: string;
  trimImage: string;
  trimPrice: number;
  mainOptions: Option[];
  exteriorColors: Color[];
  interiorColors: Color[];
}

function TrimCard({
  trim,
}: {
  trim: 'Exclusive' | 'Le Blanc' | 'Prestige' | 'Calligraphy' | string;
}) {
  const { data } = useFetch<Trim[]>('/trims');
  const { currentEstimation, setTrimAndAllColor } =
    useContext(EstimationContext)!;
  const { dispatch } = useModalContext();
  console.log(data);

  function handleModal(e: React.MouseEvent, option: OptionType) {
    e.stopPropagation();
    dispatch({ type: 'CLOSE_OPTION_MODAL' });
    const offsetX = e.nativeEvent.offsetX;
    const clickedX = e.clientX;
    const clickedY = e.clientY;
    const x = Math.ceil(clickedX - offsetX - 150);
    const y = Math.ceil(clickedY / 2);
    dispatch({ type: 'SET_OPTION_POSITION', position: { x: x, y: y } });
    dispatch({ type: 'SET_OPTION_DATA', data: option });
    dispatch({ type: 'OPEN_OPTION_MODAL' });
  }

  function getOptionList(trim: string) {
    return data?.map(trimItem => {
      if (trimItem.trimName === trim) {
        return trimItem.mainOptions.map(option => (
          <>
            <li key={option.optionName} onClick={e => handleModal(e, option)}>
              {option.optionName}
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
    const trimPrice = data?.find(
      trimItem => trimItem.trimName === trim,
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
    dispatch({ type: 'SET_TOOLTIP_TYPE', tooltipType: '트림' });
    dispatch({ type: 'SET_TOOLTIP_POSITION', position: { x: x, y: y } });
    dispatch({ type: 'OPEN_TOOLTIP_MODAL' });
  }

  function trimAndColorSetter(item: Trim) {
    const colorData = TrimData[item.trimName as keyof TrimDataProps];
    setTrimAndAllColor({
      trim: {
        name: item.trimName,
        price: item.trimPrice,
        img: item.trimImage,
      },
      interiorColor: {
        name: colorData.interiorColorName,
        price: colorData.interiorColorPrice,
        img: colorData.interiorColorImage,
      },
      exteriorColor: {
        name: colorData.colorName,
        price: colorData.colorPrice,
        img: colorData.colorImage,
      },
      interiorImage: colorData.preview,
    });
  }

  return (
    <>
      <Wrapper>
        {data?.map(trimItem => {
          if (trimItem.trimName === trim)
            return (
              <>
                <Head>
                  <FlexBox align="center" gap={8}>
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
                  </FlexBox>
                  <CheckButton
                    src={
                      currentEstimation.trim.name === trimItem.trimName
                        ? '/images/check_circle_blue_bold.svg'
                        : '/images/check_circle_grey_bold.svg'
                    }
                    onClick={e => {
                      trimAndColorSetter(trimItem);
                      handleCheckBtnClick(e);
                    }}
                  />
                </Head>
                <TrimSummary className="text-grey-100 body-regular-16">
                  {trimItem.description}
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
