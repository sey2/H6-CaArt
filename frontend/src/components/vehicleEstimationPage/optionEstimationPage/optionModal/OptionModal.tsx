import React, { useState, useContext } from 'react';
import styled from 'styled-components';
import { useFetch } from '../../../../hooks/useFetch';
import useModal from '../../../../hooks/useModal';
import { EstimationContext } from '../../../../store/Context';
import ErrorPopup from '../../../common/ErrorPopup';
import TagList from '../../../common/TagList';
import { OptionProps, SubOptionProps } from '../optionCardList/OptionCardList';
import OptionModalDetail from './OptionModalDetail';
import OptionModalTitle from './OptionModalTitle';

function OptionModal({
  isBasicOptionPage,
  openedModalId,
  setOpenedModalId,
}: {
  isBasicOptionPage: boolean;
  openedModalId: number;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}) {
  const { currentEstimation } = useContext(EstimationContext)!;
  const [optionNum, setOptionNum] = useState(0);
  useModal();

  const apiURL = `/options/${
    isBasicOptionPage ? 'basic' : 'additional'
  }?optionId=${openedModalId}`;
  const { data, status, error } = useFetch<OptionProps>(apiURL);
  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  function generateOptionModal(
    item: SubOptionProps | OptionProps,
    index: number,
    selected: boolean,
  ) {
    if (data !== null) {
      return (
        <OptionModalBox key={`${index}${item.optionName} `} selected={selected}>
          <OptionModalTagImgBox>
            <OptionModalImgBox src={item.optionImage}></OptionModalImgBox>
            <OptionModalTagList>
              <TagList type="option" tagArr={data.tags}></TagList>
            </OptionModalTagList>
          </OptionModalTagImgBox>
          <div>
            <OptionModalTitle
              option={data}
              optionNum={index}
              selected={
                currentEstimation.options.findIndex(
                  option => option.name === data.optionName,
                ) !== -1
              }
              setOpenedModalId={setOpenedModalId}
            ></OptionModalTitle>
            {data.subOptions && (
              <OptionModalDetail
                options={data.subOptions}
                optionNum={index}
                setOptionNum={setOptionNum}
              ></OptionModalDetail>
            )}
          </div>
        </OptionModalBox>
      );
    }
  }

  const optionModalSetList = (
    <>
      <OptionModalListBox optionNum={optionNum}>
        {data.subOptions &&
          data.subOptions.map((item, index) => {
            return generateOptionModal(item, index, index === optionNum);
          })}
      </OptionModalListBox>

      {optionNum !== 0 && (
        <OptionModalLeftBtn
          onClick={() => {
            setOptionNum(optionNum - 1);
          }}
        >
          <img src="/images/icon/leftArrow_icon_basic.svg"></img>
        </OptionModalLeftBtn>
      )}
      {data.subOptions && optionNum !== data.subOptions.length - 1 && (
        <OptionModalRightBtn
          onClick={() => {
            setOptionNum(optionNum + 1);
          }}
        >
          <img src="/images/icon/rightArrow_icon_basic.svg"></img>
        </OptionModalRightBtn>
      )}
    </>
  );

  const optionModalOne = generateOptionModal(data, optionNum, true);

  return (
    <ModalBox>
      <OverlayBox
        onClick={() => {
          setOpenedModalId(0);
        }}
      ></OverlayBox>
      <WrapperBox>
        {(data.subOptions == null || data.subOptions.length === 0) &&
          optionModalOne}
        {data.subOptions && data.subOptions.length !== 0 && optionModalSetList}
      </WrapperBox>
    </ModalBox>
  );
}

const ModalBox = styled.div`
  position: fixed;
  width: 100vw;
  height: 100vh;
  top: 0;
  left: 0;
  z-index: 23;
  -ms-overflow-style: none;
  scrollbar-width: none;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const OverlayBox = styled.div`
  width: 100vw;
  height: 100vh;
  position: absolute;
  background: rgba(15, 17, 20, 0.55);
  z-index: 25;
`;

const WrapperBox = styled.div`
  width: 900px;
  height: 440px;
  border-radius: 12px;
  position: relative;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 30;
`;

const OptionModalBox = styled.div<{ selected: boolean }>`
  position: relative;
  display: flex;
  width: 900px;
  height: 440px;
  border-radius: 12px;
  background: var(--grey-1000);
  filter: ${props => (props.selected ? `` : `brightness(0.55)`)};
  transition: all 1s;
`;

const OptionModalTagImgBox = styled.div`
  position: relative;
`;

const OptionModalImgBox = styled.img`
  position: relative;
  width: 556px;
  height: 440px;
  border-radius: 12px 0px 0px 12px;
`;

const OptionModalTagList = styled.div`
  position: absolute;
  top: 24px;
  left: 24px;
`;

const OptionModalListBox = styled.div<{ optionNum: number }>`
  display: flex;
  position: absolute;
  gap: 24px;
  left: ${props => `-${props.optionNum * 924}px`};

  transition: all 1s;
`;

const OptionModalBtn = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  top: 195px;
  width: 50px;
  height: 50px;
  border-radius: 4px;
  background: rgba(0, 0, 0, 0.1);
  z-index: 20;

  &:hover {
    background: rgba(0, 0, 0, 0.3);
  }
`;

const OptionModalLeftBtn = styled(OptionModalBtn)`
  left: -102px;
`;

const OptionModalRightBtn = styled(OptionModalBtn)`
  right: -102px;
`;

export default OptionModal;
