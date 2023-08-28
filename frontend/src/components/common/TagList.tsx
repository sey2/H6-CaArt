import React from 'react';
import styled from 'styled-components';
import Tag, { tagType } from './Tag';

interface TagListProps {
  tagArr: string[];
  type: tagType;
  selected?: boolean;
}

function TagList({ tagArr, type, selected }: TagListProps) {
  const tagLists = tagArr.map(item => {
    return <Tag key={item} tag={item} type={type} selected={selected}></Tag>;
  });

  return <TagListBox type={type}>{tagLists}</TagListBox>;
}

const TagListBox = styled.ul<Pick<TagListProps, 'type'>>`
  display: flex;
  justify-content: center;
  align-items: center;
  ${props => cssHandler(props.type)};
`;

const cssHandler = (type: tagType) => {
  switch (type) {
    case 'result':
      return `gap: 6px;`;
    default:
      return `gap: 8px;`;
  }
};

export default TagList;
