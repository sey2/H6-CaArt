import React from 'react';
import styled from 'styled-components';
import useModal from '../../../hooks/useModal';
import { LifeStylePeekForYou } from './LifeStylePeekForYou';
import { LifeStylePeekInterview } from './LifeStylePeekInterview';
import { LifeStylePeekProfile } from './LifeStylePeekProfile';
import { LifeStylePeekHeader } from './LifeStylePeekTitle';

export interface LifeStylePeekProps {
  profile: {
    imgSrc: string;
    name: string;
    text: string;
    talk: string;
  };
  tag: string[];
  title: string;
  imgSrc: string;
}

function LifeStylePeekModal({
  profile,
  tag,
  title,
  imgSrc,

  setOpenedModalNum,
}: LifeStylePeekProps & {
  setOpenedModalNum: React.Dispatch<React.SetStateAction<number>>;
}) {
  useModal();

  return (
    <ModalBox>
      <OverlayBox
        onClick={() => {
          setOpenedModalNum(0);
        }}
      ></OverlayBox>
      <WrapperBox>
        <LifeStylePeekModalBox>
          <LifeStylePeekHeader
            profile={profile}
            tag={tag}
            title={title}
            imgSrc={imgSrc}
          ></LifeStylePeekHeader>
          <LifeStylePeekProfile profile={profile}></LifeStylePeekProfile>
          <LifeStylePeekForYou></LifeStylePeekForYou>
          <LifeStylePeekInterview></LifeStylePeekInterview>
        </LifeStylePeekModalBox>
      </WrapperBox>
    </ModalBox>
  );
}

const ModalBox = styled.div`
  position: fixed;
  width: 100vw;
  height: 100vh;
  top: 0;
  left: 0;
  z-index: 30;
  overflow: scroll;
  -ms-overflow-style: none;
  scrollbar-width: none;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const OverlayBox = styled.div`
  width: 100vw;
  height: 1498px;
  position: absolute;
  background: rgba(15, 17, 20, 0.55);
  z-index: 50;
`;

const WrapperBox = styled.div<{ scrollPosition?: number }>`
  width: 688px;
  height: 100vh;
  border-radius: 20px;
  position: relative;
  top: 92px;
  left: 50%;
  transform: translate(-50%);
  z-index: 60;
`;

const LifeStylePeekModalBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 32px;
  align-items: center;
  width: 688px;
  height: 1318px;
  border-radius: 20px;
  background: var(--grey-1000);
`;

export { LifeStylePeekModal };
