import React, { useState } from 'react';
import styled from 'styled-components';
import { useModalContext } from '../../../store/ModalContext';
import { FlexBox } from '../../common/FlexBox';
import SquareButton from '../../common/SquareButton';

function MailModal() {
  const { state, dispatch } = useModalContext();
  const [mailInput, setMailInput] = useState<string>('');
  return (
    <ModalBox isopen={state.mailModalOpen}>
      <OverlayBox onClick={() => dispatch({ type: 'CLOSE_MAIL_MODAL' })}>
        <Container onClick={e => e.stopPropagation()}>
          <FlexBox justify="space-between" margin="0 0 8px 0">
            <span className="head-medium-22 text-grey-50">
              메일 주소를 알려주세요
            </span>
            <img
              src="/images/x_icon.svg"
              onClick={() => dispatch({ type: 'CLOSE_MAIL_MODAL' })}
            />
          </FlexBox>
          <div className="body-regular-14 text-grey-400">
            해당 주소로 만들어진 내 차를 보내드려요.
          </div>
          <InputBox
            className="body-regular-14 text-grey-0"
            placeholder="example@mail.com"
            value={mailInput}
            onChange={e => setMailInput(e.target.value)}
          />
          <SquareButton size="l" color="grey-1000" bg="primary-blue">
            메일 전송하기
          </SquareButton>
        </Container>
      </OverlayBox>
    </ModalBox>
  );
}

export default MailModal;

const ModalBox = styled.div<{ isopen: boolean }>`
  position: fixed;
  top: 0;
  left: 0;
  z-index: 3;
  transition: all 0.5s ease-out;
  visibility: hidden;
  opacity: 0;
  ${props => props.isopen && `visibility:visible; opacity:1;`};
  -ms-overflow-style: none;
  scrollbar-width: none;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const OverlayBox = styled.div`
  width: 100vw;
  height: 100vh;
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
  height: 264px;
  flex-shrink: 0;
  border-radius: 12px;
  background: #fff;
  padding: 24px 32px 32px 32px;
  text-align: left;
  img {
    cursor: pointer;
  }
`;

const InputBox = styled.input`
  width: 363px;
  height: 40px;
  flex-shrink: 0;
  border-radius: 8px;
  border: 1px solid var(--primary-blue);
  background: var(--grey-1000);
  margin: 36px 0 32px 0;
  padding: 9px 12px 9px 12px;
`;
