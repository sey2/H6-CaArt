import React, { useCallback, useEffect, useRef } from 'react';
import styled from 'styled-components';
import { OptionComponentProps } from '../../../../pages/vehicleEstimationPage/OptionEstimationPage';

function OptionNavBarUpper({
  optionCategory,
  setOptionCategory,
}: OptionComponentProps) {
  const selectedClassName = `head-medium-20 text-grey-200`;
  const unSelectedClassName = `head-medium-20 text-grey-600`;

  const lineRef = useRef<HTMLDivElement>(null);

  const updateLine = useCallback((target: HTMLElement) => {
    if (lineRef.current) {
      lineRef.current.style.width = `${target.offsetWidth}px`;
      lineRef.current.style.left = `${target.offsetLeft}px`;
      lineRef.current.style.top = `${
        target.offsetTop + target.offsetHeight - 0.5
      }px`;
    }
  }, []);

  useEffect(() => {
    if (lineRef.current) {
      const target: HTMLElement = document.querySelector('.head-medium-20')!;
      updateLine(target);
    }
  }, [updateLine]);

  const lineHandler = useCallback(
    (e: React.MouseEvent<HTMLSpanElement>) => {
      if (lineRef.current) {
        const target = e.currentTarget;
        updateLine(target);
      }
    },
    [updateLine],
  );

  const clickHandler = useCallback(
    (e: React.MouseEvent<HTMLSpanElement>, type: 'additional' | 'basic') => {
      lineHandler(e);
      setOptionCategory({
        isBasic: type === 'basic',
        name: type === 'additional' ? '전체' : '대표',
        img: '',
        id: type === 'additional' ? 0 : 9,
        page: 0,
      });
    },
    [lineHandler, setOptionCategory],
  );

  return (
    <Container>
      <OptionNavBarUpperBox>
        <span
          className={
            optionCategory.isBasic ? unSelectedClassName : selectedClassName
          }
          onClick={e => {
            clickHandler(e, 'additional');
          }}
        >
          추가 옵션
        </span>
        <span
          className={
            optionCategory.isBasic ? selectedClassName : unSelectedClassName
          }
          onClick={e => {
            clickHandler(e, 'basic');
          }}
        >
          기본 포함 옵션
        </span>
        <NavBottomLine ref={lineRef}></NavBottomLine>
      </OptionNavBarUpperBox>
    </Container>
  );
}

const Container = styled.div`
  border-bottom: 1px solid var(--grey-700);
`;

const OptionNavBarUpperBox = styled.div`
  display: flex;
  gap: 40px;
  width: 1024px;
  margin: auto;

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

export default React.memo(OptionNavBarUpper);
