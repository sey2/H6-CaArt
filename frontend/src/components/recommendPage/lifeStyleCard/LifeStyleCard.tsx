import React from 'react';
import styled from 'styled-components';
import CheckButton from '../../common/CheckButton';
import { TagList } from '../../common/TagList';

function LifeStyleCard({
  id,
  tag,
  text,
  imgSrc,
  selected,
  setOpenedModalNum,
  setLifeStyle,
}: LifeStyleCardProps &
  LifeStyleSelectedProps & {
    setOpenedModalNum: React.Dispatch<React.SetStateAction<number>>;
  } & { setLifeStyle: (id: number) => void }) {
  return (
    <LifeStyleCardBox selected={selected}>
      <LifeStyleImgBox src={imgSrc} selected={selected}></LifeStyleImgBox>
      <LifeStyleInnerBox>
        <TagList tagArr={tag} type={'lifeStyle'} selected={selected}></TagList>
        <LifeStyleTextBox selected={selected}>
          <div className="body-medium-18 text-primary-blue">{text}</div>
          <ClickDivBox
            onClick={() => {
              setLifeStyle(id);
            }}
          >
            <CheckButton selected={selected}></CheckButton>
          </ClickDivBox>
        </LifeStyleTextBox>
        <LifeStylePeekBox>
          <ClickDivBox
            className="body-medium-14 text-grey-200"
            onClick={() => {
              setOpenedModalNum(id);
            }}
          >
            라이프스타일 엿보기
          </ClickDivBox>
        </LifeStylePeekBox>
      </LifeStyleInnerBox>
    </LifeStyleCardBox>
  );
}

interface LifeStyleCardProps {
  id: number;
  tag: string[];
  text: string;
  imgSrc: string;
}

interface LifeStyleSelectedProps {
  selected?: boolean;
}

const LifeStyleCardBox = styled.div<LifeStyleSelectedProps>`
  display: flex;
  align-items: flex-start;
  position: relative;
  width: 296px;
  height: 180px;
  border-radius: 8px;
  background: ${props =>
    props.selected ? `var(--grey-1000)` : `var(--primary-blue-10)`};
  border: ${props => (props.selected ? `1.5px solid var(--primary-blue)` : ``)};
`;

const LifeStyleImgBox = styled.img<LifeStyleSelectedProps>`
  position: absolute;
  top: -40px;
  left: 188px;
  width: 88px;
  height: 88px;
  border-radius: 50%;
  border: ${props =>
    props.selected
      ? `1.5px solid var(--primary-blue)`
      : `1.5px solid var(--primary-blue-10)`};
`;

const LifeStyleInnerBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin: 20px 20px 16px 20px;
`;

const LifeStyleTextBox = styled.div<LifeStyleSelectedProps>`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 256px;
  padding-top: 10px;
  padding-bottom: 20px;
  margin-bottom: 10px;
  border-bottom: ${props =>
    props.selected ? `1px solid var(--grey-700)` : `1px solid var(--grey-900)`};

  div {
    white-space: pre-wrap;
  }
`;

const ClickDivBox = styled.div`
  cursor: pointer;
`;

const LifeStylePeekBox = styled.div`
  padding-left: 73px;
`;

export { LifeStyleCard };
