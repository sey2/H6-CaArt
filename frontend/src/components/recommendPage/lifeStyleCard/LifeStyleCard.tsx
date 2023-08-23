import React from 'react';
import styled from 'styled-components';
import replaceWonSymbol from '../../../util/ReplaceWonSymbol';
import CheckButton from '../../common/CheckButton';
import TagList from '../../common/TagList';

interface LifeStyleCardProps {
  id: number;
  tag: string[];
  text: string;
  imgSrc: string;
  selected?: boolean;
  setOpenedModalNum: React.Dispatch<React.SetStateAction<number>>;
  setLifeStyle: (id: number) => void;
}

function LifeStyleCard({
  id,
  tag,
  text,
  imgSrc,
  selected,
  setOpenedModalNum,
  setLifeStyle,
}: LifeStyleCardProps) {
  return (
    <LifeStyleCardBox selected={selected}>
      <LifeStyleInnerBox>
        <UpperBox
          onClick={() => {
            setLifeStyle(id);
          }}
        >
          <LifeStyleImgBox src={imgSrc} selected={selected}></LifeStyleImgBox>
          <TagList
            tagArr={tag}
            type={'lifeStyle'}
            selected={selected}
          ></TagList>
          <LifeStyleTextBox
            selected={selected}
            className="body-medium-18 text-primary-blue"
          >
            {replaceWonSymbol(text)}
            <CheckButton selected={selected}></CheckButton>
          </LifeStyleTextBox>
        </UpperBox>
        <LowerBox
          onClick={() => {
            setOpenedModalNum(id);
          }}
        >
          <LifeStylePeekBox className="body-medium-14 text-grey-200">
            라이프스타일 엿보기
          </LifeStylePeekBox>
        </LowerBox>
      </LifeStyleInnerBox>
    </LifeStyleCardBox>
  );
}

const LifeStyleCardBox = styled.div<Pick<LifeStyleCardProps, 'selected'>>`
  display: flex;
  align-items: flex-start;
  position: relative;
  width: 296px;
  height: 180px;
  border-radius: 8px;
  background: ${props =>
    props.selected ? `var(--grey-1000)` : `var(--primary-blue-10)`};
  border: ${props =>
    props.selected
      ? `1.5px solid var(--primary-blue)`
      : `1.5px solid transparent`};

  &:hover {
    border: 1.5px solid var(--primary-blue);
  }
`;

const LifeStyleImgBox = styled.img<Pick<LifeStyleCardProps, 'selected'>>`
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
  cursor: pointer;
`;

const LifeStyleInnerBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
`;

const UpperBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 20px 20px 0px 20px;
  cursor: pointer;
`;

const LowerBox = styled.div`
  width: 296px;
  padding: 10px 20px 16px 20px;
  cursor: pointer;
`;

const LifeStyleTextBox = styled.div<Pick<LifeStyleCardProps, 'selected'>>`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 256px;
  padding-top: 10px;
  padding-bottom: 20px;
  border-bottom: ${props =>
    props.selected ? `1px solid var(--grey-700)` : `1px solid var(--grey-900)`};
  white-space: pre-wrap;
`;

const LifeStylePeekBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`;

export default LifeStyleCard;
