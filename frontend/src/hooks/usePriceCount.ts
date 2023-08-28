import { useState, useContext } from 'react';
import { EstimationContext } from '../store/Context';

interface AnimationProps {
  prevPrice: number;
  nextPrice: number;
}

const DURATION = 500;

export function usePriceCount(): {
  count: number;
  startAnimation: (props: AnimationProps) => void;
} {
  const { totalPrice } = useContext(EstimationContext)!;
  const [count, setCount] = useState(totalPrice);

  const startAnimation = ({
    prevPrice,
    nextPrice,
  }: AnimationProps): (() => void) => {
    if (prevPrice === nextPrice) {
      return () => {};
    }

    const isIncreasing = prevPrice < nextPrice;
    const isAnimationContinuing = isIncreasing
      ? count < nextPrice
      : count > nextPrice;
    const increment = ((nextPrice - prevPrice) / (DURATION / 1000)) * (1 / 80);

    let requestId: number | null = null;
    let startTime = 0;
    let currentCount = prevPrice;

    function animate(timestamp: number): void {
      if (!startTime) startTime = timestamp;
      const elapsedTime = timestamp - startTime;

      if (elapsedTime < DURATION && isAnimationContinuing) {
        currentCount += increment;
        setCount(currentCount);
        requestId = requestAnimationFrame(animate);
      } else {
        setCount(nextPrice);
      }
    }

    requestId = requestAnimationFrame(animate);

    return () => {
      if (requestId) {
        cancelAnimationFrame(requestId);
        requestId = null;
      }
    };
  };

  return { count, startAnimation };
}
