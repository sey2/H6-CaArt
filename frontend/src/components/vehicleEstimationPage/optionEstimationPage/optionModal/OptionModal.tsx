import React, { useState, useContext } from 'react';
import styled from 'styled-components';
import { TagList } from '../../../common/TagList';
import OptionModalDetail, { OptionSetProps } from './OptionModalDetail';
import OptionModalTitle from './OptionModalTitle';
import { EstimationContext } from '../../../../util/Context';
import useModal from '../../../../hooks/useModal';

export interface OptionModalProps {
  name: string;
  price: number;
  description: string;
  img: string;
  tagList: string[];
  setOptions: OptionSetProps[];
}

function OptionModal({
  data,
  setOpenedModalId,
}: {
  data: OptionModalProps;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}) {
  const { currentEstimation } = useContext(EstimationContext)!;
  const [optionNum, setOptionNum] = useState(0);
  useModal();

  const optionModalList = data.setOptions.map((item, index) => {
    return (
      <OptionModalBox key={item.name} selected={index === optionNum}>
        <OptionModalTagImgBox>
          <OptionModalImgBox src={item.img}></OptionModalImgBox>
          <OptionModalTagList>
            <TagList type="option" tagArr={data.tagList}></TagList>
          </OptionModalTagList>
        </OptionModalTagImgBox>
        <div>
          <OptionModalTitle
            data={data}
            optionNum={optionNum}
            selected={
              currentEstimation.options.findIndex(
                option => option.name === data.name,
              ) !== -1
            }
            setOpenedModalId={setOpenedModalId}
          ></OptionModalTitle>
          <OptionModalDetail
            options={data.setOptions}
            optionNum={optionNum}
            setOptionNum={setOptionNum}
          ></OptionModalDetail>
        </div>
      </OptionModalBox>
    );
  });

  const optionModalOne = (
    <OptionModalBox selected>
      <OptionModalTagImgBox>
        <OptionModalImgBox src={data.img}></OptionModalImgBox>
        <OptionModalTagList>
          <TagList type="option" tagArr={data.tagList}></TagList>
        </OptionModalTagList>
      </OptionModalTagImgBox>
      <div>
        <OptionModalTitle
          data={data}
          optionNum={optionNum}
          selected={
            currentEstimation.options.findIndex(
              option => option.name === data.name,
            ) !== -1
          }
          setOpenedModalId={setOpenedModalId}
        ></OptionModalTitle>
        <OptionModalDetail
          options={data.setOptions}
          optionNum={optionNum}
          setOptionNum={setOptionNum}
        ></OptionModalDetail>
      </div>
    </OptionModalBox>
  );

  const optionModalSetList = (
    <>
      <OptionModalListBox optionNum={optionNum}>
        {optionModalList}
      </OptionModalListBox>

      {data.setOptions.length !== 0 && optionNum !== 0 && (
        <OptionModalLeftBtn
          onClick={() => {
            setOptionNum(optionNum - 1);
          }}
        >
          <img src="/images/leftArrow_icon_basic.svg"></img>
        </OptionModalLeftBtn>
      )}
      {data.setOptions.length !== 0 &&
        optionNum !== data.setOptions.length - 1 && (
          <OptionModalRightBtn
            onClick={() => {
              setOptionNum(optionNum + 1);
            }}
          >
            <img src="/images/rightArrow_icon_basic.svg"></img>
          </OptionModalRightBtn>
        )}
    </>
  );

  return (
    <ModalBox>
      <OverlayBox
        onClick={() => {
          setOpenedModalId(0);
        }}
      ></OverlayBox>
      <WrapperBox>
        <>
          {data.setOptions.length === 0 && optionModalOne}
          {data.setOptions.length !== 0 && optionModalSetList}
        </>
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
  z-index: 3;
  overflow: scroll;
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
  z-index: 5;
`;

const WrapperBox = styled.div`
  width: 900px;
  height: 440px;
  border-radius: 12px;
  position: relative;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 10;
`;

const OptionModalBox = styled.div<{ selected: boolean }>`
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
