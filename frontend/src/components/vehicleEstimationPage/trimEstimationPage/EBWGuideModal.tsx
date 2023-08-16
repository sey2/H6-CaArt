import React, { useState, useEffect } from 'react';
import { styled } from 'styled-components';
import { useFetch } from '../../../hooks/useFetch';
import { priceToString } from '../../../util/PriceToString';

interface Engine {
  engineName: string;
  description: string;
  enginePrice: number;
  maxPower: string;
  maxTorque: string;
  engineImage: string;
}

interface BodyType {
  bodyTypeName: string;
  description: string;
  bodyTypeImage: string;
}

interface WheelDrive {
  wheelDriveName: string;
  description: string;
  wheelDrivePrice: number;
  wheelDriveImage: string;
}

interface CompositionsData {
  carEngines: Engine[];
  bodyTypes: BodyType[];
  wheelDrives: WheelDrive[];
}

type NavType = 'carEngines' | 'bodyTypes' | 'wheelDrives' | string;

function EBWGuideModal({
  setter,
  isOpen,
}: {
  setter: React.Dispatch<React.SetStateAction<boolean>>;
  isOpen: boolean;
}) {
  const [selectedNav, setSelectedNav] = useState<NavType>('carEngines');
  const [compositionData, setCompositionData] = useState<CompositionsData>();
  const { data } = useFetch<CompositionsData>('/compositions');

  useEffect(() => {
    setCompositionData(data as CompositionsData);
  }, [data]);

  function getEngineInfo() {
    const data = compositionData?.['carEngines'];
    return data?.map(item => (
      <>
        <Item key={item.engineName}>
          <img src={item.engineImage} />
          <div>
            <InfoTop>
              <span className="head-medium-22 text-grey-100">
                {item.engineName}
              </span>
              <span className="body-regular-14 text-grey-100">
                {item.description}
              </span>
            </InfoTop>
            <Hr />
            <InfoBottom>
              <SpanDiv>
                <span className="head-regular-14 text-grey-400">최고출력</span>
                <span className="head-medium-14 text-grey-200">
                  {item.maxPower} PS/rpm
                </span>
              </SpanDiv>
              <SpanDiv>
                <span className="head-regular-14 text-grey-400">최고토크</span>
                <span className="head-medium-14 text-grey-200">
                  {item.maxTorque} kfg-m/rpm
                </span>
              </SpanDiv>
            </InfoBottom>
          </div>
        </Item>
      </>
    ));
  }

  function getBodyInfo() {
    const data = compositionData?.['bodyTypes'];
    return data?.map(item => (
      <>
        <Item key={item.bodyTypeName}>
          <img src={item.bodyTypeImage} />
          <div>
            <InfoTop>
              <span className="head-medium-22 text-grey-100">
                {item.bodyTypeName}
              </span>
              <span className="body-regular-14 text-grey-100">
                {item.description}
              </span>
            </InfoTop>
            <Hr />
            <InfoBottom>
              <SpanDiv>
                <span className="head-regular-14 text-grey-400"></span>
                <span className="head-medium-14 text-grey-200"></span>
              </SpanDiv>
              <SpanDiv>
                <span className="head-regular-14 text-grey-400"></span>
                <span className="head-medium-14 text-grey-200"></span>
              </SpanDiv>
            </InfoBottom>
          </div>
        </Item>
      </>
    ));
  }

  function getWdInfo() {
    const data = compositionData?.['wheelDrives'];
    return data?.map(item => (
      <>
        <Item key={item.description}>
          <img src={item.wheelDriveImage} />
          <div>
            <InfoTop>
              <span className="head-medium-22 text-grey-100">
                {item.wheelDriveName}
              </span>
              <span className="body-regular-14 text-grey-100">
                {item.description}
              </span>
            </InfoTop>
            <Hr />
            <InfoBottom>
              <SpanDiv>
                <span className="head-regular-14 text-grey-400">가격</span>
                <span className="head-medium-14 text-grey-200">
                  {priceToString(item.wheelDrivePrice)}
                </span>
              </SpanDiv>
              <SpanDiv>
                <span className="head-regular-14 text-grey-400"></span>
                <span className="head-medium-14 text-grey-200"></span>
              </SpanDiv>
            </InfoBottom>
          </div>
        </Item>
      </>
    ));
  }

  function contentHandler(selected: NavType) {
    switch (selected) {
      case 'carEngines':
        return getEngineInfo();
      case 'bodyTypes':
        return getBodyInfo();
      case 'wheelDrives':
        return getWdInfo();
    }
  }

  function handleNavItem(e: React.MouseEvent) {
    const eventTarget = e.target as HTMLElement;
    const selectedValue = eventTarget.getAttribute('value');
    if (selectedValue !== null) {
      setSelectedNav(selectedValue);
    }
  }

  function translator(value: string) {
    switch (value) {
      case 'carEngines':
        return '엔진';
      case 'bodyTypes':
        return '바디타입';
      case 'wheelDrives':
        return '구동방식';
      case 'maxTorque':
        return '최대토크';
      case 'maxPower':
        return '최대출력';
      default:
        return '';
    }
  }

  function setNavItem(value: string) {
    if (value === selectedNav) {
      return (
        <SNItem
          key={value}
          value={value}
          className="body-bold-18 text-primary-blue"
        >
          {translator(value)}
        </SNItem>
      );
    }
    return (
      <NItem key={value} value={value} onClick={handleNavItem}>
        {translator(value)}
      </NItem>
    );
  }

  return (
    <Modal className={isOpen ? 'active' : ''}>
      <Overlay
        onClick={() => {
          setter(false);
        }}
      />
      <Wrapper onClick={e => e.stopPropagation()}>
        <NavBar className="body-medium-18 text-grey-500">
          <NavItem>
            {compositionData &&
              Object.keys(compositionData as object).map(navName =>
                setNavItem(navName),
              )}
          </NavItem>
          <X src="/images/x_icon.svg" onClick={() => setter(false)} />
        </NavBar>
        <Hhr />
        <Content>{contentHandler(selectedNav)}</Content>
      </Wrapper>
    </Modal>
  );
}

export default EBWGuideModal;

const Overlay = styled.div`
  width: 100vw;
  height: 100vh;
  background: rgba(15, 17, 20, 0.55);
  position: relative;
  z-index: 3;
`;

const Wrapper = styled.div`
  width: 800px;
  height: 535px;
  flex-shrink: 0;
  border-radius: 12px;
  background: var(--grey-1000);
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 10;
`;
const NavBar = styled.div`
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  gap: 40px;
  margin: 20px 24px 0px 40px;
  position: relative;
`;

const NavItem = styled.div`
  display: flex;
`;

const Content = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;
  margin: 31px 78px 43px 40px;
`;
const Item = styled.div`
  display: flex;
  height: 185px;
  gap: 32px;
`;

const InfoTop = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;
`;

const InfoBottom = styled.div`
  display: findByLabelText;
  gap: 7px;
`;

const X = styled.img`
  cursor: pointer;
`;

const Hr = styled.hr`
  margin: 16px 0;
  flex-shrink: 0;
  border-width: 1px 0 0 0;
  border-color: var(--primary-blue-10);
`;

const Hhr = styled.hr`
  border-color: var(--primary-blue-10);
  flex-shrink: 0;
  margin-top: 0;
`;

const SpanDiv = styled.div`
  display: flex;
  gap: 16px;
`;

const NItem = styled.span<{ value: string }>`
  padding: 0px 20px 9px 20px;
  cursor: pointer;
`;

const SNItem = styled.span<{ value: string }>`
  padding: 0px 20px 9px 20px;
  border-bottom: 2px solid var(--primary-blue);
  cursor: pointer;
`;

const Modal = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  z-index: 3;
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.5s ease-out;
  &.active {
    opacity: 1;
    visibility: visible;
  }
`;
