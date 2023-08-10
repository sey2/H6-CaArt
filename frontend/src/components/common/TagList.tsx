import React from 'react';
import styled from 'styled-components';
import { Tag } from './Tag';

function TagList({ tagArr, type, selected }: TagListProps) {
  const tagLists = tagArr.map(item => {
    return <Tag key={item} tag={item} type={type} selected={selected}></Tag>;
  });

  return <TagListBox type={type}>{tagLists}</TagListBox>;
}

interface TagListProps {
  tagArr: string[];
  type: 'lifeStyle' | 'result' | 'option' | 'lifeStylePeek';
  selected?: boolean;
}

const TagListBox = styled.ul<Pick<TagListProps, 'type'>>`
  display: flex;
  justify-content: center;
  align-items: center;
  ${props => cssHandler(props.type)};
`;

const cssHandler = (
  type: 'lifeStyle' | 'result' | 'option' | 'lifeStylePeek',
) => {
  switch (type) {
    case 'lifeStyle':
    case 'option':
    case 'lifeStylePeek':
      return `gap: 8px;`;
    case 'result':
      return `gap: 6px;`;
  }
};

export { TagList };
