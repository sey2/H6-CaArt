import React, { useState } from 'react';
import styled from 'styled-components';
import { TagList } from '../../../common/TagList';
import { OptionModalDetail, OptionSetProps } from './OptionModalDetail';
import { OptionModalTitle } from './OptionModalTitle';

function OptionModal({ data }: { data: OptionModalProps }) {
  const [optionNum, setOptionNum] = useState(0);

  return (
    <OptionModalBox>
      <div>
        <OptionModalImgBox
          src={
            data.setOptions.length !== 0
              ? data.setOptions[optionNum].img
              : data.img
          }
        ></OptionModalImgBox>
        <OptionModalTagList>
          <TagList type="option" tagArr={data.tagList}></TagList>
        </OptionModalTagList>
      </div>
      <div>
        <OptionModalTitle data={data} optionNum={optionNum}></OptionModalTitle>
        <OptionModalDetail
          options={data.setOptions}
          optionNum={optionNum}
          setOptionNum={setOptionNum}
        ></OptionModalDetail>
      </div>
    </OptionModalBox>
  );
}

export interface OptionModalProps {
  name: string;
  price: number;
  description: string;
  img: string;
  tagList: string[];
  setOptions: OptionSetProps[];
}

const OptionModalBox = styled.div`
  display: flex;
  width: 900px;
  height: 440px;
  border-radius: 12px;
  background: var(--grey-1000);
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

export { OptionModal };
