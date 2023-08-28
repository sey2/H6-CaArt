import React from 'react';
import styled from 'styled-components';
import replaceWonSymbol from '../../../util/ReplaceWonSymbol';
import TagList from '../../common/TagList';
import { LifeStyleModalProps } from './LifeStylePeekModal';

function LifeStylePeekHeader({
  profile,
  tags,
  cover,
}: Pick<LifeStyleModalProps, 'profile' | 'tags' | 'cover'>) {
  return (
    <LifeStylePeekHeaderBox>
      <LifeStyleImgBox src={cover.image}></LifeStyleImgBox>
      <LogoBox src="/images/logo/hyundai_logo_home.svg"></LogoBox>
      <LifeStylePeekTitleBox>
        <TagList tagArr={tags} type={'lifeStylePeek'}></TagList>
        <LifeStylePeekTitle className="head-medium-32">
          {replaceWonSymbol(cover.letter)}
        </LifeStylePeekTitle>
        <LifeStylePeekText className="body-regular-16">{`${profile.name}씨의 라이프스타일 엿보기`}</LifeStylePeekText>
      </LifeStylePeekTitleBox>
    </LifeStylePeekHeaderBox>
  );
}

const LifeStylePeekHeaderBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 63px;
  padding-left: 40px;
  padding-top: 36px;
  width: 688px;
  height: 256px;
  border-radius: 12px 12px 0px 0px;
  overflow: hidden;
  position: relative;
`;

const LifeStyleImgBox = styled.img`
  position: absolute;
  left: -40px;
  top: -400px;
  width: 120%;
  object-fit: cover;
`;

const LogoBox = styled.img`
  width: 129px;
  z-index: 1;
`;

const LifeStylePeekTitleBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 8px;
  z-index: 1;
  color: #fbfbfb;
`;

const LifeStylePeekTitle = styled.div``;

const LifeStylePeekText = styled.div`
  color: rgba(255, 255, 255, 0.7);
`;

export default LifeStylePeekHeader;
