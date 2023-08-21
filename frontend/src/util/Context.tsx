import React, { createContext, useEffect, useState } from 'react';
import { LifeStyleResultProps } from '../pages/recommendPage/RecommendLifeStyleResultPage';

export interface NameAndPrice {
  name: string;
  price: number;
}

export interface NameAndPriceAndImg extends NameAndPrice {
  img: string;
  msg?: string;
}

export interface MyVechicle {
  currentEstimation: currentEstimationProps;
  totalPrice: number;
  setAgeCode: (age: string) => void;
  setEngine: (engine: NameAndPrice) => void;
  setBody: (body: NameAndPrice) => void;
  setWd: (wd: NameAndPrice) => void;
  setTrim: (trim: NameAndPriceAndImg) => void;
  setOuterColor: (outerColor: NameAndPriceAndImg) => void;
  setInteriorColor: (interiorColor: NameAndPriceAndImg) => void;
  addOption: (option: NameAndPriceAndImg) => void;
  deleteOption: (option: string) => void;
  setResult: (data: LifeStyleResultProps) => void;
}

interface currentEstimationProps {
  age: string;
  engine: NameAndPrice;
  body: NameAndPrice;
  wd: NameAndPrice;
  trim: NameAndPriceAndImg;
  outerColor: NameAndPriceAndImg;
  interiorColor: NameAndPriceAndImg;
  options: NameAndPriceAndImg[];
}

interface Props {
  children: JSX.Element | JSX.Element[];
}

const EstimationContext = createContext<MyVechicle | null>(null);

const EstimationProvider = ({ children }: Props): JSX.Element => {
  const [totalPrice, setNewTotalPrice] = useState(43000000);
  const [currentEstimation, setCurrentEstimation] =
    useState<currentEstimationProps>({
      age: '',
      engine: { name: '디젤 2.2', price: 0 },
      body: { name: '7인승', price: 0 },
      wd: { name: '2WD', price: 0 },
      trim: { name: 'Exclusive', price: 38960000, img: '/images/car.png' },
      outerColor: {
        name: '크리미 화이트 펄',
        price: 100000,
        img: '',
      },
      interiorColor: {
        name: '쿨그레이',
        price: 0,
        img: '',
      },
      options: [] as NameAndPriceAndImg[],
    });

  useEffect(() => {
    updateTotalPrice();
  }, [currentEstimation]);

  const setAgeCode = (age: string): void => {
    setCurrentEstimation({ ...currentEstimation, age: age });
  };

  const setEngine = (engine: NameAndPrice): void => {
    setCurrentEstimation({ ...currentEstimation, engine: engine });
  };

  const setBody = (body: NameAndPrice): void => {
    setCurrentEstimation({ ...currentEstimation, body: body });
  };

  const setWd = (wd: NameAndPrice): void => {
    setCurrentEstimation({ ...currentEstimation, wd: wd });
  };

  const setTrim = (trim: NameAndPriceAndImg): void => {
    setCurrentEstimation({ ...currentEstimation, trim: trim });
  };

  const setOuterColor = (outerColor: NameAndPriceAndImg): void => {
    setCurrentEstimation({ ...currentEstimation, outerColor: outerColor });
  };

  const setInteriorColor = (interiorColor: NameAndPriceAndImg): void => {
    setCurrentEstimation({
      ...currentEstimation,
      interiorColor: interiorColor,
    });
  };

  const addOption = (option: NameAndPriceAndImg): void => {
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

  const setResult = (data: LifeStyleResultProps): void => {
    setCurrentEstimation({
      age: currentEstimation.age,
      engine: {
        name: data.model.engine.engineName,
        price: data.model.engine.enginePrice,
      },
      body: {
        name: data.model.bodyType.bodyTypeName,
        price: data.model.bodyType.bodyTypePrice,
      },
      wd: {
        name: data.model.wheelDrive.wheelDriveName,
        price: data.model.wheelDrive.wheelDrivePrice,
      },
      trim: {
        name: data.model.trim.trimName,
        price: data.model.trim.trimPrice,
        img: '',
      },
      outerColor: {
        name: data.colors[0].colorName,
        price: data.colors[0].colorPrice,
        img: data.colors[0].colorImage,
        msg: data.colors[1].recommendationMessage,
      },
      interiorColor: {
        name: data.colors[1].colorName,
        price: data.colors[1].colorPrice,
        img: data.colors[1].colorImage,
        msg: data.colors[1].recommendationMessage,
      },
      options: [
        {
          name: data.options[0].optionName,
          price: data.options[0].optionPrice,
          img: data.options[0].optionImage,
          msg: data.options[0].recommendationMessage,
        },
        {
          name: data.options[1].optionName,
          price: data.options[1].optionPrice,
          img: data.options[1].optionImage,
          msg: data.options[1].recommendationMessage,
        },
      ],
    });
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
        setAgeCode,
        setEngine,
        setBody,
        setWd,
        setTrim,
        setOuterColor,
        setInteriorColor,
        addOption,
        deleteOption,
        setResult,
        totalPrice,
      }}
    >
      {children}
    </EstimationContext.Provider>
  );
};

export { EstimationContext, EstimationProvider };
