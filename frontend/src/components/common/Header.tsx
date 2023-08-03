import React, { useState } from 'react';
import styled from 'styled-components';
import { Logo } from './Logo';
import SquareButton from './SquareButton';

function Header({ size, page, currentEstimateObj }: HeaderProps) {
  const [step, setStep] = useState(page);

  console.log(currentEstimateObj);
  console.log(setStep);

  return (
    <HeaderBox size={size}>
      <LogoBox>
        <Logo type={'default'}></Logo>
      </LogoBox>
      {size === 'minimal' && <ProgressBox step={step}></ProgressBox>}
      {size !== 'minimal' && (
        <>
          <TextListBox>
            <TextBox>
              <span className="head-medium-14 text-primary-blue">1 트림</span>
              <span className="body-regular-14 text-grey-400">
                Le Blanc(르블랑)
              </span>
            </TextBox>
            <TextBox>
              <span className="head-regular-14 text-grey-600">2 색상</span>
              <span className="body-regular-14 text-grey-400">
                어비스 블랙펄 / 퀼팅천연 (블랙)
              </span>
            </TextBox>
            <TextBox>
              <span className="head-regular-14 text-grey-600">3 옵션</span>
              <span className="body-regular-14 text-grey-400">
                컴포트 II, 현대 스마트 센스 I, 주차 보조 시스템
              </span>
            </TextBox>
          </TextListBox>
          <ButtonBox>
            <SquareButton
              size={'xxs'}
              color={'primary-blue'}
              bg={'grey-1000'}
              height={40}
            >
              요금 상세
            </SquareButton>
            <SquareButton
              size={'xs'}
              color={'grey-1000'}
              bg={'primary-blue'}
              height={40}
            >
              4,000,000원 견적내기
            </SquareButton>
          </ButtonBox>
        </>
      )}
      {size === 'full' && (
        <>
          <HeaderMiddleLine></HeaderMiddleLine>
          <OptionListBox>
            <OptionBox>
              <OptionList>
                <div className="body-regular-14 text-grey-300">가솔린</div>
                <div className="body-medium-14 text-grey-100">43,460,000원</div>
              </OptionList>
              <OptionList>
                <div className="body-regular-14 text-grey-300">7인승</div>
                <div className="body-medium-14 text-grey-100"></div>
              </OptionList>
              <OptionList>
                <div className="body-regular-14 text-grey-300">2WD</div>
                <div className="body-medium-14 text-grey-100"></div>
              </OptionList>
            </OptionBox>
            <OptionBox2>
              <OptionList>
                <div className="body-regular-14 text-grey-300">
                  크리미 화이트 펄
                </div>
                <div className="body-medium-14 text-grey-100">0원</div>
              </OptionList>{' '}
              <OptionList>
                <div className="body-regular-14 text-grey-300">
                  인조가죽(블랙)
                </div>
                <div className="body-medium-14 text-grey-100">0원</div>
              </OptionList>
            </OptionBox2>
            <OptionBox3>
              <OptionList>
                <div className="body-regular-14 text-grey-300">컴포트2</div>
                <div className="body-medium-14 text-grey-100">500,000원</div>
              </OptionList>{' '}
              <OptionList>
                <div className="body-regular-14 text-grey-300">
                  현대 스마트센스
                </div>
                <div className="body-medium-14 text-grey-100">300,000원</div>
              </OptionList>
            </OptionBox3>
          </OptionListBox>
          <HeaderBottomLine></HeaderBottomLine>
          <TotalPriceBox>
            <img src="/images/dropup_icon_default.svg"></img>
            <span className="head-medium-24 text-grey-50">51,460,000원</span>
          </TotalPriceBox>
        </>
      )}
    </HeaderBox>
  );
}

const HeaderBox = styled.div<{ size: 'minimal' | 'default' | 'full' }>`
  width: 1280px;
  position: sticky;
  top: 0px;
  background: #fff;
  box-shadow: 0px 4px 6px 0px rgba(0, 0, 0, 0.08);

  ${props => getHeaderHeight(props.size)};
`;

const getHeaderHeight = (size: 'minimal' | 'default' | 'full') => {
  switch (size) {
    case 'minimal':
      return `height: 92px`;
    case 'default':
      return `height: 120px`;
    case 'full':
      return `height: 322px`;
  }
};

const LogoBox = styled.div`
  padding-left: 128px;
  padding-top: 32px;
`;

const ProgressBox = styled.div<{ step: number }>`
  height: 4px;
  background: #2197c9;
  position: absolute;
  bottom: 0px;
  width: 640px;
  transition: width 2s;
  ${props => getProgressWidth(props.step)};
`;

const getProgressWidth = (serveyStep: number) => {
  switch (serveyStep) {
    case 1:
      return `width: 640px`;
    case 2:
      return `width: 1280px`;
    default:
      return `width: 0px`;
  }
};

const TextBox = styled.div`
  display: inline-flex;
  align-items: center;
  gap: 12px;

  span {
    max-width: 240px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
`;

const TextListBox = styled.div`
  display: flex;
  gap: 22px;
  padding-left: 128px;
  padding-top: 29px;
`;

const ButtonBox = styled.div`
  display: flex;
  gap: 8px;
  position: absolute;
  top: 64px;
  left: 887px;
`;

const HeaderMiddleLine = styled.div`
  border-bottom: 1px solid #ebebeb;
  height: 1px;
  padding-top: 16px;
  box-sizing: border-box;
`;

const HeaderBottomLine = styled.div`
  border-bottom: 1px solid #ebebeb;
  height: 1px;
  box-sizing: border-box;
  width: 1021px;
  margin-left: 128px;
`;

const OptionBox = styled.div`
  display: flex;
  flex-direction: column;
  width: 147px;
  height: 98px;
  margin-left: 128px;
  margin-top: 20px;
  margin-bottom: 20px;
  gap: 7px;
  border-right: 1px solid #ebebeb;

  div {
    height: 22px;
  }
`;

const OptionBox2 = styled.div`
  display: flex;
  flex-direction: column;
  width: 147px;
  height: 98px;
  margin-left: 13px;
  margin-top: 20px;
  margin-bottom: 20px;
  gap: 7px;
  border-right: 1px solid #ebebeb;

  .body-regular-14 {
    height: 22px;
    max-width: 85px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
`;

const OptionBox3 = styled.div`
  display: flex;
  flex-direction: column;
  width: 363px;
  height: 98px;
  margin-left: 13px;
  margin-top: 20px;
  margin-bottom: 20px;
  gap: 7px;

  div {
    height: 22px;
  }
`;

const OptionListBox = styled.div`
  display: flex;
`;

const OptionList = styled.div`
  display: flex;
  justify-content: space-between;

  .text-grey-100 {
    padding-right: 14px;
  }
`;

const TotalPriceBox = styled.div`
  display: flex;
  gap: 4px;
  position: absolute;
  bottom: 24px;
  right: 131px;

  img {
    cursor: pointer;
  }
`;

export interface HeaderProps {
  size: 'minimal' | 'default' | 'full';
  page: number;
  currentEstimateObj?: currentEstimateObjProps;
}

export interface currentEstimateObjProps {
  trim: string;
  color: string;
  option: string[];
}

export { Header };
