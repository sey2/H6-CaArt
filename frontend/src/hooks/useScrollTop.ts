import { useEffect } from 'react';

const useScrollTop = () => {
  useEffect(() => {
    window.scroll(0, 0);
  }, []);
};

export default useScrollTop;
