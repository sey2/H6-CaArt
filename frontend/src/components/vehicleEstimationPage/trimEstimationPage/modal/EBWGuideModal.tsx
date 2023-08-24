import React, { useState, useEffect, useRef } from 'react';
import { styled } from 'styled-components';
import { useFetch } from '../../../../hooks/useFetch';
import { useModalContext } from '../../../../store/ModalContext';
import { priceToString } from '../../../../util/PriceToString';
import { Hr } from '../../../common/Hr';

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

function EBWGuideModal() {
  const [selectedNav, setSelectedNav] = useState<NavType>('carEngines');
  const [compositionData, setCompositionData] = useState<CompositionsData>();
  const [widthValue, setWidthValue] = useState(0);
  const { data } = useFetch<CompositionsData>('/compositions');
  const { state, dispatch } = useModalContext();
  const lineRef = useRef<HTMLDivElement>(null);

  function getValueByNavName(name: string) {
    switch (name) {
      case 'carEngines':
        return 0;
      case 'bodyTypes':
        return 1;
      case 'wheelDrives':
        return 2;
      default:
        return 0;
    }
  }

  function widthHandler(e: React.MouseEvent<HTMLElement>) {
    const value = e.currentTarget.getAttribute('value') as string;
    setWidthValue(
      prevValue =>
        prevValue +
        (getValueByNavName(selectedNav) - getValueByNavName(value)) * 800,
    );
  }

  function lineHandler(e: React.MouseEvent<HTMLSpanElement>): void {
    if (lineRef.current) {
      lineRef.current.style.width = `${e.currentTarget.offsetWidth}px`;
      lineRef.current.style.left = `${e.currentTarget.offsetLeft}px`;
      lineRef.current.style.top = `${
        e.currentTarget.offsetTop + e.currentTarget.offsetHeight - 0.5
      }px`;
    }
  }

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
            <Hr margin="12px 0px 12px 0px" />
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
            <Hr margin="12px 0px 12px 0px" />
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
            <Hr margin="12px 0px 12px 0px" />
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
    return (
      <NItem
        key={`${value}nav`}
        value={value}
        onClick={e => {
          widthHandler(e);
          handleNavItem(e);
          lineHandler(e);
        }}
        className={
          value === selectedNav
            ? `body-bold-18 text-primary-blue carEngines`
            : ''
        }
      >
        {translator(value)}
      </NItem>
    );
  }

  useEffect(() => {
    setCompositionData(data as CompositionsData);
    if (data && lineRef.current) {
      const targetDom: HTMLElement = document.querySelector('.carEngines')!;
      if (targetDom) {
        lineRef.current.style.width = `${targetDom.offsetWidth}px`;
        lineRef.current.style.left = `${targetDom.offsetLeft}px`;
        lineRef.current.style.top = `${
          targetDom.offsetTop + targetDom.offsetHeight - 0.5
        }px`;
      }
    }
  }, [data, state.infoModalOpen]);

  return (
    <Modal $isopen={state.infoModalOpen}>
      <Overlay
        onClick={() => {
          dispatch({ type: 'CLOSE_INFO_MODAL' });
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
          <X
            src="/images/x_icon.svg"
            onClick={() => dispatch({ type: 'CLOSE_INFO_MODAL' })}
          />
          <BottomLine ref={lineRef} />
        </NavBar>
        <Hr />
        <ContentWrapper widthvalue={widthValue}>
          <Content key="engine">{getEngineInfo()}</Content>
          <Content key="body">{getBodyInfo()}</Content>
          <Content key="wd">{getWdInfo()}</Content>
        </ContentWrapper>
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
  z-index: 21;
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
  z-index: 51;
  overflow: hidden;
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
  width: 100%;
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
  gap: 7px;
`;

const X = styled.img`
  cursor: pointer;
`;

const SpanDiv = styled.div`
  display: flex;
  gap: 16px;
`;

const NItem = styled.span<{ value: string }>`
  padding: 0px 20px 9px 20px;
  cursor: pointer;
  transition: color 0.5s;
`;

const Modal = styled.div<{ $isopen: boolean }>`
  position: fixed;
  top: 0;
  left: 0;
  z-index: 22;
  transition: all 0.5s ease-out;
  visibility: hidden;
  opacity: 0;
  ${props => props.$isopen && `visibility:visible;opacity:1;`};
`;

const BottomLine = styled.div`
  position: absolute;
  height: 2px;
  background: var(--primary-blue);
  transition: all 0.5s;
`;

const ContentWrapper = styled.div<{ widthvalue: number }>`
  display: flex;
  width: 2400px;
  overflow: hidden;
  transition: transform 0.5s;
  ${props => `transform: translateX(${props.widthvalue}px);`}
`;
