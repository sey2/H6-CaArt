import React, { useContext } from 'react';
import { styled } from 'styled-components';
import { priceToString } from '../../../util/PriceToString';
import SquareButton from '../../common/SquareButton';
import { FlexBox } from '../../common/FlexBox';
import { Hr } from '../../common/Hr';
import { EstimationContext } from '../../../util/Context';
import { TrimDataProps } from '../../../static/data/TrimData';
import TrimData from '../../../static/data/TrimData';
import { Link } from 'react-router-dom';

export interface Trim {
  name: string;
  price: number;
  img: string;
}

export interface State {
  isopen: boolean;
  nowTrim: Trim;
  changeTrim: Trim;
  color: Trim;
  type: string;
}

interface ModalProps {
  setter: React.Dispatch<React.SetStateAction<State>>;
  data: State;
}

function ColorChangePopup({ setter, data }: ModalProps) {
  const { setTrimAndAllColor } = useContext(EstimationContext)!;
  function formatNumberWithSign(prev: number, next: number) {
    const answer = next - prev;
    if (answer > 0) {
      return '+ ' + priceToString(answer);
    } else {
      return '- ' + priceToString(Math.abs(answer));
    }
  }
  function trimAndColorSetter(item: State) {
    const colorData = TrimData[item.changeTrim.name as keyof TrimDataProps];

    const trimImg =
      item.type === 'exterior' ? item.changeTrim.img : colorData.trimImage;
    const interColor =
      item.type === 'exterior'
        ? {
            name: colorData.interiorColorName,
            price: colorData.interiorColorPrice,
            img: colorData.interiorColorImage,
          }
        : {
            name: item.color.name,
            price: item.color.price,
            img: item.color.img,
          };
    const outerColor =
      item.type === 'exterior'
        ? {
            name: item.color.name,
            price: item.color.price,
            img: item.color.img,
          }
        : {
            name: colorData.colorName,
            price: colorData.colorPrice,
            img: colorData.colorImage,
          };
    const interImage =
      item.type === 'exterior' ? colorData.preview : item.changeTrim.img;
    setTrimAndAllColor({
      trim: {
        name: item.changeTrim.name,
        price: item.changeTrim.price,
        img: trimImg,
      },
      interiorColor: interColor,
      exteriorColor: outerColor,
      interiorImage: interImage,
      type: 'color',
    });
  }
  return (
    <Overlay
      onClick={() => setter({ ...data, isopen: false })}
      className={data.isopen ? 'active' : ''}
    >
      <Wrapper onClick={e => e.stopPropagation()}>
        <X
          src="/images/x_icon.svg"
          onClick={() => setter({ ...data, isopen: false })}
        />
        <FlexBox direction="column">
          <Title className="text-grey-50 head-medium-22">
            {data.changeTrim.name} 트림으로
            <br />
            변경하시겠어요?
          </Title>
          <span className="text-grey-400 body-regular-14">
            {data.color.name} 색상은 트림 변경 후 선택할 수 있어요.
          </span>
          <SubTitle className="text-secondary-active-blue body-medium-16">
            현재 트림
          </SubTitle>
          <Hr margin="7px 0px 0px 0px" />
          <FlexBox justify="space-between">
            <TrimName className="text-grey-100 body-regular-16">
              {data.nowTrim.name}
            </TrimName>
            <TrimPrice className="text-grey-100 body-medium-16">
              {priceToString(data.nowTrim.price)}
            </TrimPrice>
          </FlexBox>
          <SubTitle className="text-secondary-active-blue body-medium-16">
            변경 트림
          </SubTitle>
          <Hr margin="7px 0px 0px 0px" />
          <FlexBox justify="space-between">
            <TrimName className="text-grey-100 body-regular-16">
              {data.changeTrim.name}
            </TrimName>
            <TrimPrice className="text-grey-100 body-medium-16">
              {priceToString(data.changeTrim.price)}
            </TrimPrice>
          </FlexBox>
          <Hr margin="68px 0px 13px 0px" color="grey-500" />
          <FlexBox justify="space-between">
            <span className="text-secondary-active-blue body-medium-16">
              변경 금액
            </span>
            <span className="text-grey-0 head-medium-18">
              {formatNumberWithSign(data.nowTrim.price, data.changeTrim.price)}
            </span>
          </FlexBox>
        </FlexBox>
        <FlexBox
          justify="flex-end"
          gap={10}
          align="center"
          margin="33px 0px 0px 0px"
        >
          <div onClick={() => setter({ ...data, isopen: false })}>
            <SquareButton size="xxs" height={40} color="grey-400" $border>
              아니요
            </SquareButton>
          </div>
          <Link to="/estimate/trim">
            <SquareButton
              size="xxs"
              height={40}
              color="grey-900"
              bg="primary-blue"
              onClick={() => {
                trimAndColorSetter(data);
                setter({ ...data, isopen: false });
              }}
            >
              변경하기
            </SquareButton>
          </Link>
        </FlexBox>
      </Wrapper>
    </Overlay>
  );
}

export default ColorChangePopup;

const Overlay = styled.div`
  width: 100vw;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 21;
  background: rgba(15, 17, 20, 0.55);
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.5s ease-out;
  &.active {
    opacity: 1;
    visibility: visible;
  }
`;

const Wrapper = styled.div`
  width: 582px;
  height: 530px;
  border-radius: 12px;
  background: #fff;
  padding: 24px 24px 33px 24px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
`;

const Title = styled.span`
  width: 200px;
  margin-bottom: 8px;
  justify-content: space-between;
`;

const TrimName = styled.span`
  margin-top: 8px;
`;

const TrimPrice = styled.span`
  margin-top: 8px;
`;

const SubTitle = styled.span`
  margin-top: 36px;
`;

const X = styled.img`
  cursor: pointer;
  position: absolute;
  right: 24px;
  top: 24px;
`;
