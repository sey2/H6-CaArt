import React from 'react';
import styled from 'styled-components';

interface RecommendPageButtonProps {
  size: 'small' | 'large';
  selected?: boolean;
  children: string;
  onClick: () => void;
}

function RecommendPageButton({
  size,
  selected,
  children,
  onClick,
}: RecommendPageButtonProps) {
  const className = selected
    ? `body-bold-18 text-primary-blue`
    : `body-regular-18 text-grey-400`;

  return (
    <RecommendPageButtonBox size={size} selected={selected} onClick={onClick}>
      <div className={className}>{children}</div>
      <img src="/images/check_circle_blue_bold.svg" hidden={!selected}></img>
    </RecommendPageButtonBox>
  );
}

const RecommendPageButtonBox = styled.div<
  Pick<RecommendPageButtonProps, 'size' | 'selected'>
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

export { RecommendPageButton };
