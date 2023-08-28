import React, { createContext, useState } from 'react';

interface Props {
  children: JSX.Element | JSX.Element[];
}

interface DarkInterface {
  isDark: boolean;
  darkModeToggle: () => void;
}

const DarkContext = createContext<DarkInterface | null>(null);

const DarkContextProvider = ({ children }: Props): JSX.Element => {
  const [isDark, setIsDark] = useState(false);

  const darkModeToggle = () => {
    const body = document.querySelector('body')!;
    body.className = body.className ? '' : 'dark';

    setIsDark(!isDark);
  };

  return (
    <DarkContext.Provider
      value={{
        isDark,
        darkModeToggle,
      }}
    >
      {children}
    </DarkContext.Provider>
  );
};

export { DarkContext, DarkContextProvider };
