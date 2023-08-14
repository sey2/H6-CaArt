import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { TagList } from '../../../common/TagList';
import { OptionModalDetail, OptionSetProps } from './OptionModalDetail';
import { OptionModalTitle } from './OptionModalTitle';

function OptionModal({
  data,
  setOpenedModalId,
}: {
  data: OptionModalProps;
  setOpenedModalId: React.Dispatch<React.SetStateAction<number>>;
}) {
  const [optionNum, setOptionNum] = useState(0);

  useEffect(() => {
    document.body.style.cssText = `
      position: fixed; 
      top: -${window.scrollY}px;
      overflow-y: scroll;
      width: 100%;`;
    return () => {
      const scrollY = document.body.style.top;
      document.body.style.cssText = '';
      window.scrollTo(0, parseInt(scrollY || '0', 10) * -1);
    };
  }, []);

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

  return (
    <ModalBox>
      <OverlayBox
        onClick={() => {
          setOpenedModalId(0);
        }}
      ></OverlayBox>
      <WrapperBox>
        <>
          {data.setOptions.length === 0 && (
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
                  setOpenedModalId={setOpenedModalId}
                ></OptionModalTitle>
                <OptionModalDetail
                  options={data.setOptions}
                  optionNum={optionNum}
                  setOptionNum={setOptionNum}
                ></OptionModalDetail>
              </div>
            </OptionModalBox>
          )}

          {data.setOptions.length !== 0 && (
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
          )}
        </>
      </WrapperBox>
    </ModalBox>
  );
}

const ModalBox = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  z-index: 3;
`;

const OverlayBox = styled.div`
  width: 100vw;
  height: 100vh;
  background: rgba(15, 17, 20, 0.55);
  position: relative;
  z-index: 5;
`;

const WrapperBox = styled.div`
  width: 900px;
  height: 440px;
  border-radius: 12px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 10;
`;

export interface OptionModalProps {
  name: string;
  price: number;
  description: string;
  img: string;
  tagList: string[];
  setOptions: OptionSetProps[];
}

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

const OptionModalLeftBtn = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  top: 195px;
  left: -102px;
  width: 50px;
  height: 50px;
  border-radius: 4px;
  background: rgba(0, 0, 0, 0.1);
  z-index: 20;
`;

const OptionModalRightBtn = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  top: 195px;
  right: -102px;
  width: 50px;
  height: 50px;
  border-radius: 4px;
  background: rgba(255, 255, 255, 0.4);
  z-index: 20;
`;

export { OptionModal };
