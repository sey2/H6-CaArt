import { useCallback, useEffect, useRef } from 'react';

const useUnderLine = (targetClassName: string) => {
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
      const target: HTMLElement = document.querySelector(targetClassName)!;
      if (target) {
        updateLine(target);
      }
    }
  }, [updateLine, lineRef.current]);

  const lineHandler = useCallback(
    (e: React.MouseEvent<HTMLSpanElement>) => {
      if (lineRef.current) {
        const target = e.currentTarget;
        updateLine(target);
      }
    },
    [updateLine],
  );

  return { lineRef, lineHandler };
};

export default useUnderLine;
