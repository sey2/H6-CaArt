import React, { useState, useEffect, ReactNode } from 'react';
import styled, { keyframes } from 'styled-components';

function DropDown({
  children,
  visibility,
}: {
  children: ReactNode;
  visibility: boolean;
}) {
  const [visibilityAnimation, setVisibilityAnimation] = useState(false);
  const [repeat, setRepeat] = useState<NodeJS.Timeout | undefined>(undefined);

  useEffect(() => {
    if (visibility) {
      clearTimeout(repeat);
      setRepeat(undefined);
      setVisibilityAnimation(true);
    } else {
      setRepeat(
        setTimeout(() => {
          setVisibilityAnimation(false);
        }, 500),
      );
    }
  }, [visibility]);

  return (
    <Container className={visibility ? 'down' : 'up'}>
      {visibilityAnimation && children}
    </Container>
  );
}

const moveDown = keyframes`
  0% {
    transform: translateY(-100%);
  }

  100% {
    transform: translateY(0);
  }
`;

const moveUp = keyframes`
  0% {
    transform: translateY(0);
  }

  100% {
    transform: translateY(-100%);
  }
`;

const Container = styled.div`
  overflow: hidden;
  position: absolute;
  width: 100vw;
  left: 0px;
  height: 258px;

  &.down > div {
    animation: ${moveDown} 0.5s;
  }

  &.up > div {
    animation: ${moveUp} 0.5s;
    animation-fill-mode: forwards;
  }
`;

export default DropDown;
