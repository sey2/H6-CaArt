import React from 'react';
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
}: LifeStylePeekProps) {
  return (
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
  );
}

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
