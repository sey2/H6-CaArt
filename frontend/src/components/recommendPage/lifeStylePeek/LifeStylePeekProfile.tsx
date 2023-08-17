import React from 'react';
import styled from 'styled-components';
import replaceWonSymbol from '../../../util/ReplaceWonSymbol';
import { LifeStyleModalProps } from './LifeStylePeekModal';

function LifeStylePeekProfile({
  profile,
}: Pick<LifeStyleModalProps, 'profile'>) {
  return (
    <LifeStylePeekProfileBox>
      <LifeStylePeekProfileNameBox>
        <LifeStylePeekProfileImgBox
          src={profile.image}
        ></LifeStylePeekProfileImgBox>
        <LifeStylePeekProfileTextBox>
          <div className="body-medium-16 text-grey-50">{profile.name}</div>
          <div className="body-regular-12 text-grey-400">{profile.bio}</div>
        </LifeStylePeekProfileTextBox>
      </LifeStylePeekProfileNameBox>

      <LifeStylePeekProfileSpeekingBox className="body-medium-18 text-secondary-active-blue">
        {replaceWonSymbol(profile.message)}
      </LifeStylePeekProfileSpeekingBox>
    </LifeStylePeekProfileBox>
  );
}

const LifeStylePeekProfileBox = styled.div`
  display: flex;
  flex-direction: column;
`;

const LifeStylePeekProfileNameBox = styled.div`
  display: flex;
  align-items: center;
`;

const LifeStylePeekProfileImgBox = styled.img`
  width: 48px;
  height: 48px;
  margin-right: 17px;
  border-radius: 50%;
`;

const LifeStylePeekProfileTextBox = styled.div`
  display: flex;
  flex-direction: column;
`;

const LifeStylePeekProfileSpeekingBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  white-space: pre;
  text-align: center;
  width: 607px;
  height: 88px;
  border-radius: 4px;
  margin-top: 16px;
  background: rgba(33, 151, 201, 0.1);
`;

export { LifeStylePeekProfile };
