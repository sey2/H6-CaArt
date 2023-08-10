import React, { useState } from 'react';
import { styled } from 'styled-components';
import ColorButton from './button/ColorButton';
import ColorChangePopup from './ColorChangePopup';

interface Dropdown {
  type: 'inner' | 'outer';
  innerColorDDState: boolean;
  innerColorDDSetter: React.Dispatch<React.SetStateAction<boolean>>;
  outerColorDDState: boolean;
  outerColorDDSetter: React.Dispatch<React.SetStateAction<boolean>>;
}

function Dropdown(props: Dropdown) {
  const [modal, setModal] = useState<boolean>(false);

  function getDropdown(type: string) {
    if (type === 'outer') {
      return (
        <>
          {modal && <ColorChangePopup setter={setModal} />}
          <DropdownBox state={props.outerColorDDState}>
            <Header
              onClick={() => props.outerColorDDSetter(!props.outerColorDDState)}
            >
              <span className="text-primary-blue body-medium-14">
                다른 외장 색상을 찾고 있나요?
              </span>
              <DropIcon
                src="/images/dropdown_icon.svg"
                outerOpen={props.outerColorDDState}
              />
            </Header>
            <ColorListContainer state={props.outerColorDDState}>
              <ColorListItem onClick={() => setModal(true)}>
                <span className="text-secondary-active-blue body-bold-11">
                  Caligraphy
                </span>
                <ColorButton src="/images/temp_color.svg" />
                <span className="text-grey-100 caption-regular-12">
                  로버스트 에메랄드 펄
                </span>
              </ColorListItem>
            </ColorListContainer>
          </DropdownBox>
        </>
      );
    }
    return (
      <>
        {modal && <ColorChangePopup setter={setModal} />}
        <DropdownBox state={props.innerColorDDState}>
          <Header
            onClick={() => props.innerColorDDSetter(!props.innerColorDDState)}
          >
            <span className="text-primary-blue body-medium-14">
              다른 내장 색상을 찾고 있나요?
            </span>
            <DropIcon
              src="/images/dropdown_icon.svg"
              innerOpen={props.innerColorDDState}
            />
          </Header>
          <ColorListContainer state={props.innerColorDDState}>
            <ColorListItem>
              <span className="text-secondary-active-blue body-bold-11">
                Caligraphy
              </span>
              <ColorButton src="/images/temp_color.svg" />
              <span className="text-grey-100 caption-regular-12">
                로버스트 에메랄드 펄
              </span>
            </ColorListItem>
          </ColorListContainer>
        </DropdownBox>
      </>
    );
  }

  return getDropdown(props.type);
}

export default Dropdown;

const DropdownBox = styled.div<{ state?: boolean }>`
  width: 308px;
  padding: 11px 16px 11px 16px;
  height: ${props => (props.state ? 'auto' : '44px')};
  transition: height 0.4s linear;
  border-radius: 4px;
  border: 1px solid var(--primary-blue);
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  cursor: pointer;
`;

const DropIcon = styled.img<{ innerOpen?: boolean; outerOpen?: boolean }>`
  cursor: pointer;
  transition: transform 0.2s linear;
  ${props =>
    (props.innerOpen || props.outerOpen) && `transform: rotate(-180deg)`}
`;

const ColorListContainer = styled.div<{ state?: boolean }>`
  margin-top: 12px;
  flex-wrap: wrap;
  gap: 12px;
  display: ${props => (props.state ? 'flex' : 'none')};
`;

const ColorListItem = styled.div`
  width: 68px;
  display: inline-flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 4px;
  cursor: pointer;
`;
