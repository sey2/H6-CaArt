import React, { useContext } from 'react';
import styled from 'styled-components';
import { useFetch } from '../../../hooks/useFetch';
import { OptionType } from '../../../pages/vehicleEstimationPage/TrimEstimationPage';
import { EstimationContext } from '../../../util/Context';
import { priceToString } from '../../../util/PriceToString';

interface Option {
  optionId: number;
  optionName: string;
  description: string;
  optionImage: string;
}

interface Color {
  colorId: number;
  colorName: string;
  colorPrice: number;
  colorImage: string;
}

interface Trim {
  trimName: string;
  description: string;
  trimImage: string;
  trimPrice: number;
  mainOptions: Option[];
  exteriorColors: Color[];
  interiorColors: Color[];
}

interface TrimCardType {
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
  optionSetter: React.Dispatch<React.SetStateAction<OptionType | undefined>>;
}

function TrimCard({
  trim,
  modalSetter,
  positionSetter,
  tooltipOpenSetter,
  tooltipTypeSetter,
  tooltipPositionSetter,
  optionSetter,
}: TrimCardType) {
  const { data } = useFetch<Trim[]>('/trims');
  const { currentEstimation, setTrim } = useContext(EstimationContext)!;

  function handleModal(e: React.MouseEvent, option: OptionType) {
    e.stopPropagation();
    const offsetX = e.nativeEvent.offsetX;
    // const offsetY = e.nativeEvent.offsetY;
    const clickedX = e.clientX;
    const clickedY = e.clientY;
    const x = clickedX - offsetX - 150;
    const y = clickedY / 2;
    positionSetter({ x, y });
    optionSetter(option);
    modalSetter(true);
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
    tooltipTypeSetter('트림');
    tooltipPositionSetter({ x: x, y: y });
    tooltipOpenSetter(true);
  }

  return (
    <>
      <Wrapper>
        {data?.map(trimItem => {
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
