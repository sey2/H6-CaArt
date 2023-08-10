import React from 'react';
import styled from 'styled-components';
import { TagList } from '../../common/TagList';
import { LifeStylePeekProps } from './LifeStylePeekModal';

function LifeStylePeekHeader({
  profile,
  tag,
  title,
  imgSrc,
}: LifeStylePeekProps) {
  return (
    <LifeStylePeekHeaderBox imgSrc={imgSrc}>
      <LogoBox src="/images/hyundai_logo_home.svg"></LogoBox>
      <LifeStylePeekTitleBox>
        <TagList tagArr={tag} type={'lifeStylePeek'}></TagList>
        <LifeStylePeekTitle className="head-medium-32 text-grey-1000">
          {title}
        </LifeStylePeekTitle>
        <LifeStylePeekText className="body-regular-16">{`${profile.name}씨의 라이프스타일 엿보기`}</LifeStylePeekText>
      </LifeStylePeekTitleBox>
    </LifeStylePeekHeaderBox>
  );
}

const LifeStylePeekHeaderBox = styled.div<Pick<LifeStylePeekProps, 'imgSrc'>>`
  display: flex;
  flex-direction: column;
  gap: 63px;
  padding-left: 40px;
  padding-top: 36px;
  width: 688px;
  height: 256px;
  border-radius: 12px 12px 0px 0px;

  background: ${props => `linear-gradient(
      180deg,
      rgba(15, 17, 20, 0) 0%,
      rgba(15, 17, 20, 0.7) 100%
    ),
    url(${props.imgSrc}),
    lightgray -2px -302.825px / 104.506% 280.243% no-repeat`};
`;

const LogoBox = styled.img`
  width: 129px;
  height: 14px;
`;

const LifeStylePeekTitleBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 8px;
`;

const LifeStylePeekTitle = styled.div``;

const LifeStylePeekText = styled.div`
  color: rgba(255, 255, 255, 0.7);
`;

export { LifeStylePeekHeader };
