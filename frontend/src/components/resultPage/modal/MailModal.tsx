import React, { useState } from 'react';
import styled from 'styled-components';
import { FlexBox } from '../../common/FlexBox';
import SquareButton from '../../common/SquareButton';

export interface ModalProps {
  setter: React.Dispatch<React.SetStateAction<boolean>>;
  isOpen: boolean;
}

function MailModal({ setter, isOpen }: ModalProps) {
  const [mailInput, setMailInput] = useState<string>('');
  return (
    <ModalBox className={isOpen ? 'active' : ''} >
      <OverlayBox onClick={() => setter(false)}>
        <Container onClick={e => e.stopPropagation()}>
          <FlexBox justify="space-between" margin="0 0 8px 0">
            <span className="head-medium-22 text-grey-50">
              메일 주소를 알려주세요
            </span>
            <img src="/images/x_icon.svg" onClick={() => setter(false)} />
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
            복사하기
          </SquareButton>
        </Container>
      </OverlayBox>
    </ModalBox>
  );
}

export default MailModal;

const ModalBox = styled.div`
  position: fixed;
  width: 100vw;
  height: 100vh;
  top: 0;
  left: 0;
  z-index: 3;
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.5s ease-out;
  &.active {
    opacity: 1;
    visibility: visible;
  }
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
