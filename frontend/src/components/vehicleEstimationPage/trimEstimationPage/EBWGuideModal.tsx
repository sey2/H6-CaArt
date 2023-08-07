import React, { useState } from 'react';
import { styled } from 'styled-components';

function EBWGuideModal({
  setter,
}: {
  setter: React.Dispatch<React.SetStateAction<boolean>>;
}) {
  const tempData = {
    engine: [
      {
        name: '디젤',
        description: '디스크립션 1',
        maxPower: 100,
        maxTorque: 200,
        image: '/images/engine2_2.svg',
        price: 200000,
      },
      {
        name: '가솔린',
        description: '디스크립션 1',
        maxPower: 100,
        maxTorque: 200,
        image: '/images/engine2_2.svg',
        price: 200000,
      },
    ],
    bodyType: [
      {
        name: '7인승',
        description: '디스크립션 1',
        maxPower: 300,
        maxTorque: 400,
        image: '/images/engine2_2.svg',
        price: 200000,
      },
      {
        name: '8인승',
        description: '디스크립션 1',
        maxPower: 500,
        maxTorque: 600,
        image: '/images/engine2_2.svg',
        price: 200000,
      },
    ],
    wheelDrive: [
      {
        name: '2WD',
        description: '디스크립션 1',
        maxPower: 700,
        maxTorque: 800,
        image: '/images/engine2_2.svg',
        price: 200000,
      },
      {
        name: '4WD',
        description: '디스크립션 1',
        maxPower: 900,
        maxTorque: 1000,
        image: '/images/engine2_2.svg',
        price: 200000,
      },
    ],
  };

  const [selectedNav, setSelectedNav] = useState('engine');

  function handleNavItem(e: React.MouseEvent) {
    const eventTarget = e.target as HTMLElement;
    const selectedValue = eventTarget.getAttribute('value');
    if (selectedValue !== null) {
      setSelectedNav(selectedValue);
    }
  }

  function translator(value: string) {
    switch (value) {
      case 'engine':
        return '엔진';
      case 'bodyType':
        return '바디타입';
      case 'wheelDrive':
        return '구동방식';
      case 'maxTorque':
        return '최대토크';
      case 'maxPower':
        return '최대출력';
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

  const nowData = tempData[selectedNav as keyof typeof tempData];
  return (
    <Modal>
      <Overlay
        onClick={() => {
          setter(false);
        }}
      />
      <Wrapper onClick={e => e.stopPropagation()}>
        <NavBar className="body-medium-18 text-grey-500">
          <NavItem>
            {Object.keys(tempData).map(data => setNavItem(data))}
          </NavItem>
          <X src="/images/x_icon.svg" onClick={() => setter(false)} />
        </NavBar>
        <Hhr />
        <Content>
          {nowData.map(data => {
            return (
              <>
                <Item>
                  <img src={data.image} />
                  <div>
                    <InfoTop>
                      <span className="head-medium-22 text-grey-100">
                        {data.name}
                      </span>
                      <span className="body-regular-14 text-grey-100">
                        {data.description}
                      </span>
                    </InfoTop>
                    <Hr />
                    <InfoBottom>
                      <SpanDiv>
                        <span className="head-regular-14 text-grey-400">
                          최고출력
                        </span>
                        <span className="head-medium-14 text-grey-200">
                          {data.maxPower} PS/rpm
                        </span>
                      </SpanDiv>
                      <SpanDiv>
                        <span className="head-regular-14 text-grey-400">
                          최고토크
                        </span>
                        <span className="head-medium-14 text-grey-200">
                          {data.maxTorque} kfg-m/rpm
                        </span>
                      </SpanDiv>
                    </InfoBottom>
                  </div>
                </Item>
              </>
            );
          })}
        </Content>
      </Wrapper>
    </Modal>
  );
}

export default EBWGuideModal;

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
  gap: 24px;
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

const Overlay = styled.div`
  width: 100vw;
  height: 100vh;
  background: rgba(15, 17, 20, 0.55);
  position: relative;
  z-index: 3;
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
`;
