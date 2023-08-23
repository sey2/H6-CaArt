import React from 'react';
import styled from 'styled-components';
import { useModalContext } from '../../../store/ModalContext';
import { FlexBox } from '../../common/FlexBox';
import SquareButton from '../../common/SquareButton';

function LoginModal() {
  const { state, dispatch } = useModalContext();
  return (
    <ModalBox isopen={state.saveModalOpen}>
      <OverlayBox onClick={() => dispatch({ type: 'CLOSE_SAVE_MODAL' })}>
        <Container>
          <FlexBox justify="space-between" align="flex-start">
            <FlexBox
              direction="column"
              margin="0px 0px 34px 0px"
              className="head-medium-22 text-grey-50"
            >
              <p>로그인이 필요한 서비스에요.</p>
              <p>로그인 화면으로 이동하시겠어요?</p>
            </FlexBox>
            <img
              src="/images/x_icon.svg"
              onClick={() => dispatch({ type: 'CLOSE_SAVE_MODAL' })}
            />
          </FlexBox>
          <FlexBox gap={7}>
            <SquareButton
              color="grey-50"
              className="body-medium-16"
              size="mms"
              $border
              onClick={() => dispatch({ type: 'CLOSE_SAVE_MODAL' })}
            >
              아니요
            </SquareButton>
            <a href="https://www.hyundai.com/kr/ko/login">
              <SquareButton
                color="grey-1000"
                bg="primary-blue"
                className="body-medium-16"
                size="mms"
              >
                네
              </SquareButton>
            </a>
          </FlexBox>
        </Container>
      </OverlayBox>
    </ModalBox>
  );
}

export default LoginModal;

const ModalBox = styled.div<{ isopen: boolean }>`
  position: fixed;
  width: 100vw;
  height: 100vh;
  top: 0;
  left: 0;
  z-index: 3;
  opacity: 0;
  visibility: hidden;
  transition: all 0.5s ease-out;
  ${props => props.isopen && `visibility:visible; opacity:1;`};
  -ms-overflow-style: none;
  scrollbar-width: none;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const OverlayBox = styled.div`
  width: 100%;
  height: 100%;
  position: absolute;
  background: rgba(15, 17, 20, 0.55);
  z-index: 5;
`;

const Container = styled.div`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 427px;
  height: 192px;
  flex-shrink: 0;
  border-radius: 12px;
  background: #fff;
  padding: 24px 32px 32px 32px;
  text-align: left;
  img {
    cursor: pointer;
  }
`;
