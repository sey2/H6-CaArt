import React from 'react';
import styled from 'styled-components';

export type tagType = 'lifeStyle' | 'result' | 'option' | 'lifeStylePeek';

export interface TagProps {
  tag: string;
  type: tagType;
  selected?: boolean;
}

function Tag({ tag, type, selected }: TagProps) {
  return (
    <TagBox
      className={type === 'option' ? 'body-regular-12' : 'caption-medium-12'}
      type={type}
      selected={selected}
    >
      {`${type !== 'result' ? '#' : ''}${tag}`}
    </TagBox>
  );
}

const TagBox = styled.li<Pick<TagProps, 'type' | 'selected'>>`
  display: flex;
  padding: 6px 10px;
  align-items: center;
  justify-content: center;
  box-sizing: border-box;

  ${props => cssHandler(props.type, props.selected)};
`;

const cssHandler = (type: tagType, selected: boolean | undefined) => {
  switch (type) {
    case 'lifeStyle':
      if (selected) {
        return `background: rgba(33, 151, 201, 0.10); color: var(--secondary-active-blue); border-radius: 100px`;
      } else {
        return `background: var(--grey-1000); color: var(--secondary-active-blue); border-radius: 100px`;
      }
    case 'result':
      return `background: transparent; color: var(--grey-300); border-radius: 30px; border: 1px solid var(--grey-600);`;
    case 'option':
      return `background: var(--grey-200); color:var(--grey-800); border-radius: 100px`;
    case 'lifeStylePeek':
      return `background: var(--grey-50); color: var(--grey-900); border-radius: 100px; backdrop-filter: blur(4px);`;
  }
};

export default Tag;
