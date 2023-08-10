import React, { useEffect } from 'react';
import styled from 'styled-components';
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
  useEffect(() => {
    document.body.style.cssText = `
      position: fixed;
      top: -${window.scrollY}px;
      overflow-y: scroll;
      width: 100%;`;
    return () => {
      const scrollY = document.body.style.top;
      document.body.style.cssText = '';
      window.scrollTo(0, parseInt(scrollY || '0', 10) * -1);
    };
  }, []);

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
  position: absolute;
  height: 100vh;
  top: 0;
  left: 0;
  z-index: 3;
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
  background: rgba(15, 17, 20, 0.55);
  position: relative;
  z-index: 5;
`;

const WrapperBox = styled.div<{ scrollPosition?: number }>`
  width: 688px;
  height: 100vh;
  border-radius: 20px;
  position: absolute;
  top: 90px;
  left: 50%;
  transform: translate(-50%, 0px);
  z-index: 10;
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
