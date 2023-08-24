import React from 'react';
import styled from 'styled-components';
import useModal from '../../../../hooks/useModal';
import { FlexBox, SFlex } from '../../../common/FlexBox';
import { commonOption } from '../../../../static/data/CompareModalData';
import { Hr } from '../../../common/Hr';
import { useModalContext } from '../../../../store/ModalContext';
import { Trim } from '../../../../pages/vehicleEstimationPage/TrimEstimationPage';
import { Color } from '../../../../pages/vehicleEstimationPage/TrimEstimationPage';

function CompareModal({ data }: { data: Trim[] }) {
  useModal();
  const { state, dispatch } = useModalContext();

  function setExteriorColor(colorSet: Color[]) {
    return colorSet.map(color => (
      <>
        <Circle key={`${color.colorName}`} src={color.colorImage} />
      </>
    ));
  }

  function setInnerColor(colorSet: Color[]) {
    return colorSet.map(color => (
      <>
        <p key={color.colorName} className="body-regular-14 text-grey-300">
          {color.colorName}
        </p>
      </>
    ));
  }

  return (
    <Modal $isopen={state.compareModalOpen}>
      <Overlay onClick={() => dispatch({ type: 'CLOSE_COMPARE_MODAL' })} />
      <Wrapper onClick={e => e.stopPropagation()}>
        <Wrapperbox>
          <Header className="head-medium-22 text-grey-50">
            비교하기
            <X
              src="/images/x_icon.svg"
              onClick={() => dispatch({ type: 'CLOSE_COMPARE_MODAL' })}
            />
          </Header>
          <Grid>
            {data?.map(trim => (
              <>
                <FlexBox key={trim.trimName} direction="column" align="center">
                  <CarImage src={trim.trimImage} />
                  <FlexBox direction="column" justify="center" gap={8}>
                    <p className="body-regular-14 text-grey-300">
                      {trim.trimName}
                    </p>
                    <p className="head-medium-20 text-grey-0">
                      {trim.trimName}
                    </p>
                    <p
                      className="body-medium-16 text-grey-200"
                      style={{ marginBottom: 26 }}
                    >
                      &#8361;&nbsp;
                      {trim.trimPrice.toLocaleString()}
                      &nbsp;
                      <span className="body-regular-16 ">부터</span>
                    </p>
                    <p className="body-medium-14 text-grey-200">외장 색상</p>
                    <FlexBox justify="center" gap={8} margin="0 0 16px 0">
                      {setExteriorColor(trim.exteriorColors)}
                    </FlexBox>
                    <p className="body-medium-14 text-grey-200">내장 색상</p>
                    <FlexBox
                      display="inline"
                      justify="center"
                      align="center"
                      wrap="wrap"
                      gap={8}
                      height={52}
                    >
                      {setInnerColor(trim.interiorColors)}
                    </FlexBox>
                    <Hr width={160} margin="33px 0px 33px 0px" />
                    <FlexBox gap={51} direction="column">
                      {Object.entries(commonOption).map(item => {
                        if (item[0] === trim.trimName) {
                          return item[1].map(option => (
                            <>
                              <Option
                                key={option.name}
                                direction="column"
                                gap={8}
                                align="center"
                              >
                                <img src={option.imgSrc} />
                                <InchSpan>{option.inch}</InchSpan>
                                <NameSpan>{option.name}</NameSpan>
                              </Option>
                            </>
                          ));
                        }
                      })}
                    </FlexBox>
                    <Hr width={160} margin="33px 0px 33px 0px" />
                    <span className="body-medium-14 text-grey-300">
                      기본 옵션
                    </span>
                    <FlexBox
                      gap={8}
                      direction="column"
                      className="text-secondary-active-blue body-regular-14"
                    >
                      {trim.mainOptions.map(option => (
                        <>
                          <span key={option.optionName}>
                            {option.optionName}
                          </span>
                        </>
                      ))}
                    </FlexBox>
                  </FlexBox>
                </FlexBox>
              </>
            ))}
          </Grid>
        </Wrapperbox>
      </Wrapper>
    </Modal>
  );
}

export default CompareModal;

const Modal = styled.div<{ $isopen: boolean }>`
  position: fixed;
  width: 100vw;
  height: 100vh;
  top: 0;
  left: 0;
  z-index: 21;
  overflow: scroll;
  transition: all 0.5s ease-out;
  visibility: hidden;
  opacity: 0;
  ${props => props.$isopen && `visibility:visible;opacity:1;`};

  -ms-overflow-style: none;
  scrollbar-width: none;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const Wrapperbox = styled.div`
  border-radius: 12px;
  padding: 24px 38px 48px 38px;
  margin-top: 70px;
  margin-bottom: 148px;
  width: 900px;
  height: 1500px;
  background-color: var(--grey-1000);
`;

const Grid = styled.div`
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 28px;
  text-align: center;
`;

const Overlay = styled.div`
  width: 100%;
  height: 1650px;
  background: rgba(15, 17, 20, 0.55);
  position: absolute;
  z-index: 5;
`;

const Header = styled.div`
  position: relative;
  text-align: center;
  margin-bottom: 50px;
`;

const Wrapper = styled.div`
  position: relative;
  width: 900px;
  height: 100vh;
  left: 50%;
  transform: translateX(-50%);
  border-radius: 12px;
  z-index: 10;
`;

const X = styled.img`
  position: absolute;
  right: 0;
  cursor: pointer;
`;

const CarImage = styled.img`
  width: 185px;
  /* height: 100px; */
  flex-shrink: 0;
  margin-bottom: 25px;
`;

const Option = styled(SFlex)`
  img {
    width: 54.4px;
    height: 54.4px;
  }
`;

const InchSpan = styled.span`
  color: var(--secondary-active-blue);
  font-family: HyundaiTextBold;
  font-size: 22px;
  font-style: normal;
  font-weight: 700;
  line-height: 28px;
  letter-spacing: -0.2px;
`;
const NameSpan = styled.span`
  color: var(--grey-300);
  font-family: HyundaiTextRegular;
  font-size: 16px;
  font-style: normal;
  font-weight: 400;
  line-height: 100%;
  letter-spacing: -0.3px;
  width: 160px;
  height: 32px;
`;

const Circle = styled.img`
  width: 16px;
  height: 16px;
  border-radius: 50%;
`;
