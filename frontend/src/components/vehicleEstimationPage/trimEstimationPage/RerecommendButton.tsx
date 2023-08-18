import React from 'react';
import { styled } from 'styled-components';

function RerecommendButton({
  setter,
}: {
  setter: React.Dispatch<React.SetStateAction<boolean>>;
}) {
  return (
    <Button top={24} left={128} onClick={() => setter(true)}>
      <img src="/images/re_recommend_icon.svg" />
      <span className="text-secondary-active-blue body-medium-14">
        다시 추천받기
      </span>
    </Button>
  );
}

export default RerecommendButton;

const Button = styled.div<{ top: number; left: number }>`
  cursor: pointer;
  width: 124px;
  height: 36px;
  flex-shrink: 0;
  border-radius: 20px;
  border: 1px solid var(--grey-scale-grey-1000, #fff);
  backdrop-filter: blur(2px);
  background: rgba(255, 255, 255, 0.8);
  display: flex;
  gap: 4px;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: ${props => props.top}px;
  left: ${props => props.left}px;
  z-index: 1;
`;
