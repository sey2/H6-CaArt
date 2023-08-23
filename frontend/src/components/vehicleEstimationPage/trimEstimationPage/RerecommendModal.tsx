import React from 'react';
import { styled } from 'styled-components';
import SquareButton from '../../common/SquareButton';
import { useNavigate } from 'react-router-dom';
import { FlexBox } from '../../common/FlexBox';
import { useModalContext } from '../../../store/ModalContext';

function RerecommendModal() {
  const { state, dispatch } = useModalContext();
  const navigate = useNavigate();
  return (
    <Overlay
      onClick={() => dispatch({ type: 'CLOSE_RECOMMEND_MODAL' })}
      $isopen={state.recommendModalOpen}
    >
      <Box onClick={e => e.stopPropagation()}>
        <FlexBox justify="space-between" margin="0px 0px 8px 0px">
          <span className="head-medium-22 text-grey-50">
            추천 페이지로 돌아가시겠어요?
          </span>
          <X
            src="/images/x_icon.svg"
            onClick={() => dispatch({ type: 'CLOSE_RECOMMEND_MODAL' })}
          />
        </FlexBox>
        <span className="body-regular-14 text-grey-400">
          선택한 옵션들은 모두 초기화돼요.
        </span>
        <FlexBox
          align="center"
          justify="center"
          gap={8}
          margin="32px 0px 0px 0px"
        >
          <div onClick={() => dispatch({ type: 'CLOSE_RECOMMEND_MODAL' })}>
            <SquareButton
              size={'ms'}
              bg={'grey-1000'}
              color={'grey-50'}
              height={46}
              $border
            >
              아니요
            </SquareButton>
          </div>
          <SquareButton
            size="ms"
            bg="primary-blue"
            color="grey-1000"
            height={46}
            onClick={() => {
              dispatch({ type: 'CLOSE_RECOMMEND_MODAL' });
              navigate('/recommend/age');
            }}
          >
            추천받기
          </SquareButton>
        </FlexBox>
      </Box>
    </Overlay>
  );
}

export default RerecommendModal;

const Overlay = styled.div<{ $isopen: boolean }>`
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
  ${props => props.$isopen && `visibility:visible;opacity:1;`};
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
