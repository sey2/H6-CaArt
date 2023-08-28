import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import styled from 'styled-components';

function HeaderProgressBar() {
  const [isAgePage, setIsAgePage] = useState(false);
  const url = useLocation().pathname;
  const step: number = (() => {
    switch (url) {
      case '/':
      case '/recommend/age':
        return 0;
      case '/recommend/lifeStyle':
        return 2;
      default:
        return 3;
    }
  })();

  useEffect(() => {
    if (url === '/recommend/age') {
      setIsAgePage(true);
    } else {
      setIsAgePage(false);
    }
  }, [step]);

  return <ProgressBox step={isAgePage ? 1 : step}></ProgressBox>;
}

const ProgressBox = styled.div<{ step: number }>`
  height: 4px;
  background: #2197c9;
  position: absolute;
  left: 0px;
  bottom: 0px;
  transition: width 1s;
  ${props => getProgressWidth(props.step)};
`;

const getProgressWidth = (step: number) => {
  switch (step) {
    case 0:
      return `width: 0vw; visibility: hidden`;
      break;
    case 1:
      return `width: 50vw`;
      break;
    case 2:
      return `width: 100vw`;
      break;
    case 3:
      return 'width: 100vw; visibility: hidden';
      break;
  }
};

export default HeaderProgressBar;
