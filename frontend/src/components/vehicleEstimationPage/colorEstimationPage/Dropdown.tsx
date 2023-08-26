import React, { useCallback, useContext } from 'react';
import { styled } from 'styled-components';
import ColorButton from './button/ColorButton';
import ColorChangePopup, { State } from './ColorChangePopup';
import useDetectClose from '../../../hooks/useDetectClose';
import { Trim } from '../../../pages/vehicleEstimationPage/ColorEstimationPage';
import { EstimationContext } from '../../../util/Context';

interface Dropdown {
  type: 'interior' | 'exterior';
  data: Trim[];
  setter: React.Dispatch<React.SetStateAction<State>>;
  modaldata: State;
}

function Dropdown({ type, data, setter, modaldata }: Dropdown) {
  const { currentEstimation } = useContext(EstimationContext)!;
  const [dropdownOpen, dropdownRef, dropdownHandler] = useDetectClose(false);

  const setModalData = useCallback(
    (item: Trim) => {
      const nowModalData = {
        isopen: true,
        nowTrim: {
          name: currentEstimation.trim.name,
          price: currentEstimation.trim.price,
          img: currentEstimation.trim.img,
        },
        changeTrim: {
          name: item.trimName,
          price: item.trimPrice,
          img: item.preview,
        },
        color: {
          name: item.colorName,
          price: 0,
          img: item.colorImage,
        },
        type: type,
      };
      setter(nowModalData);
    },
    [setter],
  );

  function getDropdown(type: string) {
    const colorText = type === 'exterior' ? '외장' : '내장';
    return (
      <>
        {<ColorChangePopup setter={setter} data={modaldata} />}
        <DropdownBox $isDown={dropdownOpen}>
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
            $isActive={dropdownOpen}
            onClick={e => e.stopPropagation()}
          >
            {data.map(item => {
              return (
                <>
                  <ColorListItem onClick={() => setModalData(item)}>
                    <span className="text-secondary-active-blue body-bold-11">
                      {item.trimName}
                    </span>
                    <ColorButton src={item.colorImage} />
                    <span className="text-grey-100 caption-regular-12">
                      {item.colorName}
                    </span>
                  </ColorListItem>
                </>
              );
            })}
          </ColorListContainer>
        </DropdownBox>
      </>
    );
  }

  return getDropdown(type);
}

export default React.memo(Dropdown);

const DropdownBox = styled.div<{ $isDown: boolean }>`
  width: 308px;
  padding: 11px 16px 32px 16px;
  transition: max-height 0.5s linear;
  max-height: ${props => (props.$isDown ? '500px' : '30px')};
  border-radius: 4px;
  border: 1px solid var(--primary-blue);
  ${props => !props.$isDown && `overflow:hidden;`}
`;

const ColorListContainer = styled.div<{ $isActive: boolean }>`
  margin-top: 12px;
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
  transition: opacity 1s;
  visibility: ${props => (props.$isActive ? 'visible' : 'hidden')};
  opacity: ${props => (props.$isActive ? 1 : 0)};
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
