import React from 'react';
import styled from 'styled-components';
import { useModalContext } from '../../../store/ModalContext';
import { FlexBox } from '../../common/FlexBox';
import SquareButton from '../../common/SquareButton';

function ShareModal() {
  const { state, dispatch } = useModalContext();
  return (
    <ModalBox $isopen={state.shareModalOpen}>
      <OverlayBox onClick={() => dispatch({ type: 'CLOSE_SHARE_MODAL' })}>
        <Container onClick={e => e.stopPropagation()}>
          <FlexBox $justify="space-between" $margin="0 0 8px 0">
            <span className="head-medium-22 text-grey-50">공유하기</span>
            <img
              src="/images/icon/x_icon.svg"
              onClick={() => dispatch({ type: 'CLOSE_SHARE_MODAL' })}
            />
          </FlexBox>
          <div className="body-regular-14 text-grey-400">
            구성하신 견적이 URL로 생성되었어요.
            <br />
            아래 URL을 공유하시면 견적을 다시 확인하실 수 있어요.
            <br />
            (30일간 유효)
          </div>
          <UrlBox className="body-regular-14 text-grey-600">
            <p>https://www.hyundai.com/kr/ko/e/vehicles/estimation/</p>
          </UrlBox>
          <SquareButton size="l" color="grey-1000" $bg="primary-blue">
            복사하기
          </SquareButton>
        </Container>
      </OverlayBox>
    </ModalBox>
  );
}

export default ShareModal;

const ModalBox = styled.div<{ $isopen: boolean }>`
  position: fixed;
  width: 100vw;
  height: 100vh;
  top: 0;
  left: 0;
  z-index: 3;
  opacity: 0;
  visibility: hidden;
  transition: all 0.5s ease-out;
  ${props => props.$isopen && `visibility:visible; opacity:1;`};
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
  height: 312px;
  flex-shrink: 0;
  border-radius: 12px;
  background: #fff;
  padding: 24px 32px 32px 32px;
  text-align: left;
  img {
    cursor: pointer;
  }
`;

const UrlBox = styled.div`
  width: 363px;
  height: 40px;
  flex-shrink: 0;
  border-radius: 8px;
  border: 1px solid var(--primary-blue);
  background: var(--grey-1000);
  margin: 36px 0 32px 0;
  padding: 9px 12px 9px 12px;
`;
