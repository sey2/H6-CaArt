import React from 'react';
import { styled } from 'styled-components';
import SquareButton from '../../common/SquareButton';
import { Link } from 'react-router-dom';
import { FlexBox } from "../../common/FlexBox";

function RerecommendModal({
  setter,
  isOpen,
}: {
  setter: React.Dispatch<React.SetStateAction<boolean>>;
  isOpen: boolean;
}) {
  function closeModal() {
    setter(false);
  }

  return (
    <Overlay onClick={closeModal} className={isOpen ? 'active' : ''}>
      <Box onClick={e => e.stopPropagation()}>
        <FlexBox justify="space-between" margin="0px 0px 8px 0px">
          <span className="head-medium-22 text-grey-50">
            추천 페이지로 돌아가시겠어요?
          </span>
          <X src="/images/x_icon.svg" onClick={closeModal} />
        </FlexBox>
        <span className="body-regular-14 text-grey-400">
          선택한 옵션들은 모두 초기화돼요.
        </span>
        <FlexBox align="center" justify="center" gap={8} margin="32px 0px 0px 0px">
          <div onClick={closeModal}>
            <SquareButton
              size={'ms'}
              bg={'grey-1000'}
              color={'grey-50'}
              height={46}
              border
            >
              아니요
            </SquareButton>
          </div>
          <Link to="/recommend/age">
            <SquareButton
              size="ms"
              bg="primary-blue"
              color="grey-1000"
              height={46}
            >
              추천받기
            </SquareButton>
          </Link>
        </FlexBox>
      </Box>
    </Overlay>
  );
}

export default RerecommendModal;

const Overlay = styled.div`
  width: 100vw;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 10;
  background: rgba(15, 17, 20, 0.55);
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.5s ease-out;
  &.active {
    opacity: 1;
    visibility: visible;
  }
`;

const Box = styled.div`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 427px;
  height: 192px;
  border-radius: 12px;
  background: var(--grey-1000);
  display: flex;
  justify-content: center;
  flex-direction: column;
  padding: 24px;
`;

const X = styled.img`
  cursor: pointer;
`;
