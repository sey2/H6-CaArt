import React, { useContext } from 'react';
import styled from 'styled-components';
import { EstimationContext } from '../../../util/Context';

interface EBWButtonProps {
  value: string;
  price: number;
  onClick: (value: string, price: number) => void;
}

function EBWButton({ value, price, onClick }: EBWButtonProps) {
  const { currentEstimation } = useContext(EstimationContext)!;
  function checkVehicleStatus(value: string, target: string) {
    if (value === '디젤 2.2' || value === '가솔린 3.8') {
      if (value === target) return true;
    } else if (value === '7인승' || value === '8인승') {
      if (value === target) return true;
    } else if (value === '2WD' || value === '4WD') {
      if (value === target) return true;
    }
    return false;
  }

  function ButtonSelector(value: string) {
    switch (value) {
      case '디젤 2.2':
        if (checkVehicleStatus(value, currentEstimation.engine.name)) {
          return <SelectedButton>{value}</SelectedButton>;
        }
        return <Button>{value}</Button>;
      case '가솔린 3.8':
        if (checkVehicleStatus(value, currentEstimation.engine.name)) {
          return <SelectedButton>{value}</SelectedButton>;
        }
        return <Button>{value}</Button>;
      case '7인승':
        if (checkVehicleStatus(value, currentEstimation.body.name)) {
          return <SelectedButton>{value}</SelectedButton>;
        }
        return <Button>{value}</Button>;
      case '8인승':
        if (checkVehicleStatus(value, currentEstimation.body.name)) {
          return <SelectedButton>{value}</SelectedButton>;
        }
        return <Button>{value}</Button>;
      case '2WD':
        if (checkVehicleStatus(value, currentEstimation.wd.name)) {
          return <SelectedButton>{value}</SelectedButton>;
        }
        return <Button>{value}</Button>;
      case '4WD':
        if (checkVehicleStatus(value, currentEstimation.wd.name)) {
          return <SelectedButton>{value}</SelectedButton>;
        }
        return <Button>{value}</Button>;
      default:
        return null;
    }
  }

  const handleClick = () => {
    onClick(value, price);
  };

  return <div onClick={handleClick}>{ButtonSelector(value)}</div>;
}

export default EBWButton;

const Button = styled.div`
  font-family: HyundaiTextRegular;
  font-size: 14px;
  font-style: normal;
  font-weight: 400;
  line-height: 22px; /* 157.143% */
  letter-spacing: -0.2px;
  color: var(--grey-500);
  display: flex;
  width: 63px;
  padding: 9px 37px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  border-radius: 6px;
  background: var(--grey-scale-grey-800, #f0f0f0);
  cursor: pointer;
`;

const SelectedButton = styled(Button)`
  border: 1.5px solid var(--blue-blue-500-primary, #00428e);
  background: var(--grey-scale-grey-1000, #fff);
  font-family: HyundaiTextMedium;
  font-size: 14px;
  font-style: normal;
  font-weight: 500;
  line-height: 22px; /* 157.143% */
  letter-spacing: -0.2px;
  color: var(--primary-blue);
`;
