import React from 'react';
import styled from 'styled-components';

function HeaderProgressBar({ step }: { step: number }) {
  return <ProgressBox step={step}></ProgressBox>;
}

const ProgressBox = styled.div<{ step: number }>`
  height: 4px;
  background: #2197c9;
  position: absolute;
  bottom: 0px;
  transition: width 2s;
  ${props => getProgressWidth(props.step)};
`;

const getProgressWidth = (serveyStep: number) => {
  switch (serveyStep) {
    case 0:
      return `width: 50%`;
    case 1:
      return `width: 100%`;
    default:
      return `width: 0px`;
  }
};

export { HeaderProgressBar };
