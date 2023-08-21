import React from 'react';
import styled from 'styled-components';
import { useFetch } from '../../../hooks/useFetch';
import useModal from '../../../hooks/useModal';
import { ErrorPopup } from '../../common/ErrorPopup';
import { LifeStylePeekForYou } from './LifeStylePeekForYou';
import { LifeStylePeekInterview } from './LifeStylePeekInterview';
import { LifeStylePeekProfile } from './LifeStylePeekProfile';
import { LifeStylePeekHeader } from './LifeStylePeekTitle';

export interface LifeStyleModalProps {
  personaId: number;
  tags: string[];
  cover: {
    letter: string;
    image: string;
  };
  profile: {
    image: string;
    name: string;
    bio: string;
    message: string;
  };
  recommendation: {
    model: {
      trimImage: string;
      trimName: string;
      compositions: string;
    };
    options: {
      optionImage: string;
      optionName: string;
    }[];
  };
  interviews: {
    question: string;
    answer: string;
  }[];
}

function LifeStylePeekModal({
  openedModalNum,
  setOpenedModalNum,
}: {
  openedModalNum: number;
  setOpenedModalNum: React.Dispatch<React.SetStateAction<number>>;
}) {
  useModal();
  const { data, status, error } = useFetch<LifeStyleModalProps>(
    `/personas/${openedModalNum}`,
  );
  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

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
            profile={data.profile}
            tags={data.tags}
            cover={data.cover}
          ></LifeStylePeekHeader>
          <LifeStylePeekProfile profile={data.profile}></LifeStylePeekProfile>
          <LifeStylePeekForYou
            recommendation={data.recommendation}
          ></LifeStylePeekForYou>
          <LifeStylePeekInterview
            interviews={data.interviews}
          ></LifeStylePeekInterview>
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
