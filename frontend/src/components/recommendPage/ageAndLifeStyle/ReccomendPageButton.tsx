import React from 'react';
import styled from 'styled-components';

interface ReccomendPageButtonProps {
  size: 'small' | 'large';
  selected?: boolean;
  children: string;
  onClick: () => void;
}

function ReccomendPageButton({
  size,
  selected,
  children,
  onClick,
}: ReccomendPageButtonProps) {
  return (
    <ReccomendPageButtonBox size={size} selected={selected} onClick={onClick}>
      <div>{children}</div>
      <img src="images/check_circle_blue_bold.svg" hidden={!selected}></img>
    </ReccomendPageButtonBox>
  );
}

const ReccomendPageButtonBox = styled.div<
  Pick<ReccomendPageButtonProps, 'size' | 'selected'>
>`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: ${props => (props.size === 'small' ? `298px` : `608px`)};
  height: 56px;
  padding: 20px 12px;
  border-radius: 6px;
  background: ${props =>
    props.selected ? `var(--grey-1000)` : `var(--grey-800)`};
  border: ${props => (props.selected ? `1.5px solid var(--primary-blue)` : ``)};
  cursor: pointer;

  img {
    width: 24px;
    height: 24px;
  }
`;

export { ReccomendPageButton };
