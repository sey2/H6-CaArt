import React, { createContext, useEffect, useState } from 'react';

interface NameAndPrice {
  name: string;
  price: number;
}

export interface MyVechicle {
  currentEstimation: {
    engine: NameAndPrice;
    body: NameAndPrice;
    wd: NameAndPrice;
    trim: NameAndPrice;
    outerColor: NameAndPrice;
    interiorColor: NameAndPrice;
    options: NameAndPrice[];
  };
  totalPrice: number;
  setEngine: (engine: NameAndPrice) => void;
  setBody: (body: NameAndPrice) => void;
  setWd: (wd: NameAndPrice) => void;
  setTrim: (trim: NameAndPrice) => void;
  setOuterColor: (outerColor: NameAndPrice) => void;
  setInteriorColor: (interiorColor: NameAndPrice) => void;
  addOption: (option: NameAndPrice) => void;
  deleteOption: (option: string) => void;
}

interface Props {
  children: JSX.Element | JSX.Element[];
}

const EstimationContext = createContext<MyVechicle | null>(null);

const EstimationProvider = ({ children }: Props): JSX.Element => {
  const [totalPrice, setNewTotalPrice] = useState(43000000);
  const [currentEstimation, setCurrentEstimation] = useState({
    engine: { name: '디젤 2.2', price: 0 },
    body: { name: '7인승', price: 0 },
    wd: { name: '2WD', price: 0 },
    trim: { name: '르블랑', price: 0 },
    outerColor: { name: '빨강', price: 0 },
    interiorColor: { name: '파랑', price: 0 },
    options: [{ name: '컴포트2', price: 15000 }] as NameAndPrice[],
  });

  useEffect(() => {
    updateTotalPrice();
  }, [currentEstimation]);

  const setEngine = (engine: NameAndPrice): void => {
    setCurrentEstimation({ ...currentEstimation, engine: engine });
  };

  const setBody = (body: NameAndPrice): void => {
    setCurrentEstimation({ ...currentEstimation, body: body });
  };

  const setWd = (wd: NameAndPrice): void => {
    setCurrentEstimation({ ...currentEstimation, wd: wd });
  };

  const setTrim = (trim: NameAndPrice): void => {
    setCurrentEstimation({ ...currentEstimation, trim: trim });
  };

  const setOuterColor = (outerColor: NameAndPrice): void => {
    setCurrentEstimation({ ...currentEstimation, outerColor: outerColor });
  };

  const setInteriorColor = (interiorColor: NameAndPrice): void => {
    setCurrentEstimation({
      ...currentEstimation,
      interiorColor: interiorColor,
    });
  };

  const addOption = (option: NameAndPrice): void => {
    if (
      currentEstimation.options.some(item => {
        return item.name === option.name;
      }) === true
    ) {
      return;
    }

    const copyOptions = [...currentEstimation.options, option];

    setCurrentEstimation({ ...currentEstimation, options: copyOptions });
  };

  const deleteOption = (option: string): void => {
    const copyOptions = currentEstimation.options.filter(item => {
      return item.name !== option;
    });
    setCurrentEstimation({ ...currentEstimation, options: copyOptions });
  };

  const updateTotalPrice = () => {
    const optionPrice = currentEstimation.options.reduce(
      (acc, cur) => acc + cur.price,
      0,
    );
    const tempPrice =
      currentEstimation.engine.price +
      currentEstimation.body.price +
      currentEstimation.wd.price +
      currentEstimation.trim.price +
      currentEstimation.outerColor.price +
      currentEstimation.interiorColor.price +
      optionPrice;
    if (totalPrice === tempPrice) return;
    setNewTotalPrice(tempPrice);
  };

  return (
    <EstimationContext.Provider
      value={{
        currentEstimation,
        setEngine,
        setBody,
        setWd,
        setTrim,
        setOuterColor,
        setInteriorColor,
        addOption,
        deleteOption,
        totalPrice,
      }}
    >
      {children}
    </EstimationContext.Provider>
  );
};

export { EstimationContext, EstimationProvider };
