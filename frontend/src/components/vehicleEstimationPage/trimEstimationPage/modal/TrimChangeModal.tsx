import React, { useContext } from 'react';
import styled from 'styled-components';
import { useModalContext } from '../../../../store/ModalContext';
import { EstimationContext } from '../../../../util/Context';
import { FlexBox } from '../../../common/FlexBox';
import { Hr } from '../../../common/Hr';
import SquareButton from '../../../common/SquareButton';
import { TrimDataProps } from '../../../../static/data/TrimData';
import TrimData from '../../../../static/data/TrimData';

interface TrimChangeModalProps {
  name: string;
  price: number;
  img: string;
}

function TrimChangeModal() {
  const { currentEstimation, setTrimAndAllColor } =
    useContext(EstimationContext)!;
  const { state, dispatch } = useModalContext();
  function trimAndColorSetter(item: TrimChangeModalProps) {
    const colorData = TrimData[item.name as keyof TrimDataProps];
    setTrimAndAllColor({
      trim: {
        name: item.name,
        price: item.price,
        img: item.img,
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
      type: 'color',
    });
  }

  return (
    <Overlay
      onClick={() => dispatch({ type: 'CLOSE_TRIM_CHANGE_MODAL' })}
      isopen={state.trimChangeModal.isopen}
    >
      <Box onClick={e => e.stopPropagation()}>
        <FlexBox $justify="space-between" $margin="0px 0px 48px 0px">
          <p className="head-medium-22 text-grey-50">
            트림 변경 시, 선택하신 색상과 옵션이 해제돼요
          </p>
          <X
            src="/images/x_icon.svg"
            onClick={() => dispatch({ type: 'CLOSE_TRIM_CHANGE_MODAL' })}
          />
        </FlexBox>
        <p className="body-medium-16 text-primary-blue">해제 색상</p>
        <Hr margin="7px 0px 12px 0px" />
        <Container className="color">
          <FlexBox $gap={12}>
            <ItemImg src={currentEstimation.outerColor.img} />
            <span className="body-regular-16 text-grey-100">
              외장 - {currentEstimation.outerColor.name}
            </span>
          </FlexBox>
          <FlexBox $gap={12}>
            <ItemImg src={currentEstimation.interiorColor.img} />
            <span className="body-regular-16 text-grey-100">
              내장 - {currentEstimation.interiorColor.name}
            </span>
          </FlexBox>
        </Container>
        <p className="body-medium-16 text-primary-blue">해제 옵션</p>
        <Hr margin="7px 0px 12px 0px" />
        <Container className="option">
          {currentEstimation.options.map(option => {
            return (
              <>
                <FlexBox key={option.name} $gap={12}>
                  <ItemImg src={option.img} />
                  <span className="body-regular-16 text-grey-100">
                    {option.name}
                  </span>
                </FlexBox>
              </>
            );
          })}
        </Container>
        <ButtonContainer>
          <SquareButton
            size="xxs"
            $border
            color="grey-50"
            onClick={() => dispatch({ type: 'CLOSE_TRIM_CHANGE_MODAL' })}
          >
            취소하기
          </SquareButton>
          <SquareButton
            size="xxs"
            $bg="primary-blue"
            color="grey-1000"
            onClick={() => {
              trimAndColorSetter(state.trimChangeModal.trim);
              dispatch({ type: 'CLOSE_TRIM_CHANGE_MODAL' });
            }}
          >
            변경하기
          </SquareButton>
        </ButtonContainer>
      </Box>
    </Overlay>
  );
}

export default TrimChangeModal;

const Overlay = styled.div<{ isopen: boolean }>`
  width: 100vw;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 21;
  background: rgba(15, 17, 20, 0.55);
  transition: all 0.5s ease-out;
  visibility: hidden;
  opacity: 0;
  ${props => props.isopen && `visibility:visible;opacity:1;`};
`;

const Box = styled.div`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 582px;
  border-radius: 12px;
  background: var(--grey-1000);
  display: flex;
  justify-content: center;
  flex-direction: column;
  padding: 24px 24px 24px 33px;
`;

const X = styled.img`
  cursor: pointer;
`;

const Container = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 12px;
  &.color {
    margin-bottom: 26px;
  }
  &.option {
    margin-bottom: 48px;
  }
`;

const ItemImg = styled.img`
  width: 60px;
  height: 60px;
  flex-shrink: 0;
  border-radius: 3.248px;
`;

const ButtonContainer = styled.div`
  display: flex;
  gap: 10px;
  justify-content: flex-end;
`;
