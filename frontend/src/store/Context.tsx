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
  setTrimInteriorImage: (img: string) => void;
  setOuterColor: (outerColor: NameAndPriceAndImg) => void;
  setInteriorColor: (interiorColor: NameAndPriceAndImg) => void;
  addOption: (option: NameAndPriceAndImg) => void;
  deleteOption: (option: string) => void;
  setResult: (data: LifeStyleResultProps) => void;
  setColorAndTrim: ({
    trim,
    color,
    type,
  }: {
    trim: NameAndPriceAndImg;
    color: NameAndPriceAndImg;
    type: string;
  }) => void;
  setTrimAndAllColor: ({
    trim,
    interiorColor,
    exteriorColor,
    interiorImage,
    type,
  }: {
    trim: NameAndPriceAndImg;
    interiorColor: NameAndPriceAndImg;
    exteriorColor: NameAndPriceAndImg;
    interiorImage: string;
    type: string;
  }) => void;
}

interface currentEstimationProps {
  age: string;
  engine: NameAndPrice;
  body: NameAndPrice;
  wd: NameAndPrice;
  trim: NameAndPriceAndImg;
  trimInteriorImage: string;
  outerColor: NameAndPriceAndImg;
  interiorColor: NameAndPriceAndImg;
  options: NameAndPriceAndImg[];
}

interface Props {
  children: JSX.Element | JSX.Element[];
}

const EstimationContext = createContext<MyVechicle | null>(null);

const EstimationProvider = ({ children }: Props): JSX.Element => {
  const [totalPrice, setNewTotalPrice] = useState(38960000);
  const [currentEstimation, setCurrentEstimation] =
    useState<currentEstimationProps>({
      age: '',
      engine: { name: '디젤 2.2', price: 1480000 },
      body: { name: '7인승', price: 0 },
      wd: { name: '2WD', price: 0 },
      trim: {
        name: 'Exclusive',
        price: 38960000,
        img: 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-2.webp',
      },
      trimInteriorImage:
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/inside/9.webp',
      outerColor: {
        name: '어비스 블랙 펄',
        price: 0,
        img: 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/11.webp',
      },
      interiorColor: {
        name: '인조가죽(블랙)',
        price: 0,
        img: 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/interior/7.webp',
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
    if (currentEstimation.options.some(item => item.name === option.name)) {
      return;
    }
    const copyOptions = [...currentEstimation.options, option];
    setCurrentEstimation({ ...currentEstimation, options: copyOptions });
  };

  const deleteOption = (option: string): void => {
    const copyOptions = currentEstimation.options.filter(
      item => item.name !== option,
    );
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
        img: data.colors[0].colorPreview,
      },
      trimInteriorImage: data.colors[1].colorPreview,
      outerColor: {
        name: data.colors[0].colorName,
        price: data.colors[0].colorPrice,
        img: data.colors[0].colorImage,
        msg: data.colors[0].recommendationMessage,
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

  const setTrimInteriorImage = (img: string) => {
    setCurrentEstimation({ ...currentEstimation, trimInteriorImage: img });
  };

  const setColorAndTrim = ({
    trim,
    color,
    type,
  }: {
    trim: NameAndPriceAndImg;
    color: NameAndPriceAndImg;
    type: string;
  }) => {
    if (type === 'exterior') {
      setCurrentEstimation({
        ...currentEstimation,
        trim: trim,
        outerColor: color,
      });
    } else if (type === 'interior') {
      setCurrentEstimation({
        ...currentEstimation,
        trim: { ...currentEstimation.trim, name: trim.name, price: trim.price },
        trimInteriorImage: trim.img,
        interiorColor: color,
      });
    }
  };

  const setTrimAndAllColor = ({
    trim,
    interiorColor,
    exteriorColor,
    interiorImage,
    type,
  }: {
    trim: NameAndPriceAndImg;
    interiorColor: NameAndPriceAndImg;
    exteriorColor: NameAndPriceAndImg;
    interiorImage: string;
    type: string;
  }) => {
    const curOption = type === 'color' ? [] : [...currentEstimation.options];
    setCurrentEstimation({
      ...currentEstimation,
      trim: trim,
      interiorColor: interiorColor,
      outerColor: exteriorColor,
      trimInteriorImage: interiorImage,
      options: curOption,
    });
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
        setColorAndTrim,
        setTrimInteriorImage,
        setTrimAndAllColor,
      }}
    >
      {children}
    </EstimationContext.Provider>
  );
};

export { EstimationContext, EstimationProvider };
