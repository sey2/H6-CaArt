import React, { useEffect, useRef } from 'react';
import styled from 'styled-components';
import { OptionNavBarProps } from '../../../../pages/vehicleEstimationPage/OptionEstimationPage';

function OptionNavBarUpper({
  isBasicOptionPage,
  setIsBasicOptionPage,
  setOptionCategory,
}: Pick<
  OptionNavBarProps,
  'isBasicOptionPage' | 'setIsBasicOptionPage' | 'setOptionCategory'
>) {
  const selectedClassName = `head-medium-20 text-grey-200`;
  const unSelectedClassName = `head-medium-20 text-grey-600`;
  const lineRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    if (lineRef.current) {
      const targetDom: HTMLElement = document.querySelector('.head-medium-20')!;
      lineRef.current.style.width = `${targetDom.offsetWidth}px`;
      lineRef.current.style.left = `${targetDom.offsetLeft}px`;
      lineRef.current.style.top = `${
        targetDom.offsetTop + targetDom.offsetHeight - 0.5
      }px`;
    }
  }, []);

  function lineHandler(e: React.MouseEvent<HTMLSpanElement>): void {
    if (lineRef.current) {
      lineRef.current.style.width = `${e.currentTarget.offsetWidth}px`;
      lineRef.current.style.left = `${e.currentTarget.offsetLeft}px`;
      lineRef.current.style.top = `${
        e.currentTarget.offsetTop + e.currentTarget.offsetHeight - 0.5
      }px`;
    }
  }

  function clickHandler(
    e: React.MouseEvent<HTMLSpanElement>,
    type: 'additional' | 'basic',
  ) {
    lineHandler(e);
    setIsBasicOptionPage(type === 'basic');
    setOptionCategory(type === 'basic' ? '대표' : '전체');
  }

  return (
    <OptionNavBarUpperBox>
      <span
        className={!isBasicOptionPage ? selectedClassName : unSelectedClassName}
        onClick={e => {
          clickHandler(e, 'additional');
        }}
      >
        추가 옵션
      </span>
      <span
        className={isBasicOptionPage ? selectedClassName : unSelectedClassName}
        onClick={e => {
          clickHandler(e, 'basic');
        }}
      >
        기본 포함 옵션
      </span>
      <NavBottomLine ref={lineRef}></NavBottomLine>
    </OptionNavBarUpperBox>
  );
}

const OptionNavBarUpperBox = styled.div`
  display: flex;
  gap: 40px;
  padding-left: 132px;
  border-bottom: 1px solid var(--grey-700);

  span {
    padding-bottom: 8px;
    cursor: pointer;
    transition: color 0.5s;
  }

  span.text-grey-600:hover {
    color: var(--grey-200);
  }
`;

const NavBottomLine = styled.div`
  position: absolute;
  height: 2px;
  background: var(--grey-200);
  transition: all 0.5s;
`;

export default OptionNavBarUpper;
