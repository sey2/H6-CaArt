import React from 'react';
import styled from 'styled-components';

function Tag({ tag, type, selected }: TagProps) {
  return (
    <TagBox
      className={type === 'option' ? 'body-regular-12' : 'caption-medium-12'}
      type={type}
      selected={selected}
    >
      {tag}
    </TagBox>
  );
}

export interface TagProps {
  tag: string;
  type: 'lifeStyle' | 'result' | 'option' | 'lifeStylePeek';
  selected?: boolean;
}

const TagBox = styled.li<Pick<TagProps, 'type' | 'selected'>>`
  display: flex;
  padding: 6px 10px;
  align-items: center;
  justify-content: center;
  box-sizing: border-box;

  ${props => cssHandler(props.type, props.selected)};
`;

const cssHandler = (
  type: 'lifeStyle' | 'result' | 'option' | 'lifeStylePeek',
  selected: boolean | undefined,
) => {
  switch (type) {
    case 'lifeStyle':
      if (selected) {
        return `background: rgba(33, 151, 201, 0.10); color: #2197c9; border-radius: 100px`;
      } else {
        return `background: #fff; color: #2197c9; border-radius: 100px`;
      }
    case 'result':
      return `background: transparent; color: #696969; border-radius: 30px; border: 1px solid #BEBEBE;`;
    case 'option':
      return `background: #404040; color:#f0f0f0; border-radius: 100px`;
    case 'lifeStylePeek':
      return `background: rgba(15,17,20,0.8); color: #fff; border-radius: 100px; backdrop-filter: blur(4px);`;
  }
};

export { Tag };
