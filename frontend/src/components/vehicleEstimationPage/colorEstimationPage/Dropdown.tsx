import React, { useState } from 'react';
import { styled } from 'styled-components';
import ColorButton from './button/ColorButton';
import ColorChangePopup from './ColorChangePopup';
import useDetectClose from '../../../hooks/useDetectClose';

interface Dropdown {
  type: 'inner' | 'outer';
}

function Dropdown(props: Dropdown) {
  const [modal, setModal] = useState<boolean>(false);
  const [dropdownOpen, dropdownRef, dropdownHandler] = useDetectClose(false);

  function getDropdown(type: string) {
    const colorText = type === 'outer' ? '외장' : '내장';
    return (
      <>
        {<ColorChangePopup setter={setModal} isOpen={modal} />}
        <DropdownBox isDown={dropdownOpen}>
          <Header onClick={dropdownHandler} ref={dropdownRef}>
            <span className="text-primary-blue body-medium-14">
              다른 {colorText} 색상을 찾고 있나요?
            </span>
            <DropIcon
              src="/images/dropdown_icon.svg"
              outerOpen={dropdownOpen}
            />
          </Header>
          <ColorListContainer
            isActive={dropdownOpen}
            onClick={e => e.stopPropagation()}
          >
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

  return getDropdown(props.type);
}

export default Dropdown;

const DropdownBox = styled.div<{ isDown: boolean }>`
  width: 308px;
  padding: 11px 16px 11px 16px;
  transition: height 0.3s linear;
  height: ${props => (props.isDown ? '300px' : '44px')};
  border-radius: 4px;
  border: 1px solid var(--primary-blue);
`;

const ColorListContainer = styled.div<{ isActive: boolean }>`
  margin-top: 12px;
  flex-wrap: wrap;
  gap: 12px;
  transition: opacity 0.5s linear, visibility 0.1s 0.1s; 
  visibility: ${props => (props.isActive ? 'visible' : 'hidden')};
  opacity: ${props => (props.isActive ? 1 : 0)};
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

const ColorListItem = styled.div`
  width: 68px;
  display: inline-flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 4px;
  cursor: pointer;
`;
