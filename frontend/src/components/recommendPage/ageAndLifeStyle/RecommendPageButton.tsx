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
      <img src="/images/checkIcon/check_circle_blue_bold.svg" hidden={!selected}></img>
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
  border: ${props =>
    props.selected
      ? `1.5px solid var(--primary-blue)`
      : `1.5px solid transparent`};
  cursor: pointer;

  &:hover {
    background: var(--grey-1000);
    border: 1.5px solid var(--primary-blue);
    div {
      color: var(--primary-blue);
      font-family: 'HyundaiTextBold';
      font-weight: 700;
    }
  }

  img {
    width: 24px;
    height: 24px;
  }
`;

export default RecommendPageButton;
