import React from 'react';
import styled from 'styled-components';

function CompareModal({
  setter,
}: {
  setter: React.Dispatch<React.SetStateAction<boolean>>;
}) {
  const data = {
    trimList: [
      {
        trimName: 'Exclusive',
        trimInfo: '합리적인 당신을 위한',
        trimPrice: 10000000,
        trimImage: '/images/car/exclusive.svg',
        trimOuterColor: [
          '#121212',
          '#979999',
          '#171D2F',
          '#292622',
          '#313433',
          '#F2F4F3',
        ],
        trimInnerColor: ['인조가죽(블랙)'],
        trimOption: [
          {
            id: 0,
            name: '12인치 네비게이션',
            info: '11',
            image: '11',
          },
          {
            id: 1,
            name: '내비 기반 크루즈 컨트롤',
            info: '11',
            image: '11',
          },
          {
            id: 2,
            name: '세이프티 파워 윈도우',
            info: '11',
            image: '11',
          },
        ],
      },
      {
        trimName: 'Le Blanc',
        trimInfo: '필수적인 옵션만 모은',
        trimPrice: 20000000,
        trimImage: '/images/car/leBlanc.svg',
        trimOuterColor: [
          '#121212',
          '#979999',
          '#171D2F',
          '#292622',
          '#313433',
          '#F2F4F3',
        ],
        trimInnerColor: ['쿨그레이', '퀄팅천연(블랙)'],
        trimOption: [
          {
            id: 0,
            name: '20인치 알로이 휠',
            info: '11',
            image: '11',
          },
          {
            id: 1,
            name: '12인치 클러스터',
            info: '11',
            image: '11',
          },
          {
            id: 2,
            name: '서라운드 뷰 모니터',
            info: '11',
            image: '11',
          },
        ],
      },
      {
        trimName: 'Prestige',
        trimInfo: '가치있는 드라이빙 경험을 주는',
        trimPrice: 30000000,
        trimImage: '/images/car/prestige.svg',
        trimOuterColor: [
          '#121212',
          '#979999',
          '#171D2F',
          '#292622',
          '#313433',
          '#F2F4F3',
        ],
        trimInnerColor: ['네이비', '블랙', '버건디'],
        trimOption: [
          {
            id: 0,
            name: '2열 통풍시트',
            info: '11',
            image: '11',
          },
          {
            id: 1,
            name: '스마트 자세제어',
            info: '11',
            image: '11',
          },
          {
            id: 2,
            name: '2열 수동식 도어 커튼',
            info: '11',
            image: '11',
          },
        ],
      },
      {
        trimName: 'Caligraphy',
        trimInfo: '남들과 차별화된 경험',
        trimPrice: 40000000,
        trimImage: '/images/car/calligraphy.svg',
        trimOuterColor: [
          '#121212',
          '#A1A3A2',
          '#142419',
          '#181F30',
          '#2C2925',
          '#3C3F3E',
          '#F1F2F3',
        ],
        trimInnerColor: ['블랙(고급)', '브라운', '블랙 원톤(블랙에디션 전용)'],
        trimOption: [
          {
            id: 0,
            name: '20인치 캘리그라피 전용 휠',
            info: '11',
            image: '11',
          },
          {
            id: 1,
            name: 'KRELL 프리미엄 사운드',
            info: '11',
            image: '11',
          },
          {
            id: 2,
            name: '블랙 에디션',
            info: '11',
            image: '11',
          },
        ],
      },
    ],
  };

  const commonOption = {
    Exclusive: [
      {
        option: 'wheel',
        imgSrc: '/images/carComponent/wheel.svg',
        name: '기본 휠',
        inch: '18 inch',
      },
      {
        option: 'sit',
        imgSrc: '/images/carComponent/sit.svg',
        name: '인조/천연가죽 시트',
      },
      {
        option: 'navigation',
        imgSrc: '/images/carComponent/navigation.svg',
        name: '네비게이션',
        inch: '12.3 inch',
      },
      {
        option: 'cluster',
        imgSrc: '/images/carComponent/cluster.svg',
        name: '클러스터',
        inch: '4.2 inch',
      },
    ],
    'Le Blanc': [
      {
        option: 'wheel',
        imgSrc: '/images/carComponent/wheel.svg',
        name: '알로이 휠',
        inch: '20 inch',
      },
      {
        option: 'sit',
        imgSrc: '/images/carComponent/sit.svg',
        name: '퀄팅 천연가죽 시트',
      },
      {
        option: 'navigation',
        imgSrc: '/images/carComponent/navigation.svg',
        name: '네비게이션',
        inch: '12.3 inch',
      },
      {
        option: 'cluster',
        imgSrc: '/images/carComponent/cluster.svg',
        name: '클러스터',
        inch: '12.3 inch',
      },
    ],
    Prestige: [
      {
        option: 'wheel',
        imgSrc: '/images/carComponent/wheel.svg',
        name: '알로이 휠',
        inch: '20 inch',
      },
      {
        option: 'sit',
        imgSrc: '/images/carComponent/sit.svg',
        name: '퀄팅 나파가죽 시트',
      },
      {
        option: 'navigation',
        imgSrc: '/images/carComponent/navigation.svg',
        name: '네비게이션',
        inch: '12.3 inch',
      },
      {
        option: 'cluster',
        imgSrc: '/images/carComponent/cluster.svg',
        name: '클러스터',
        inch: '12.3 inch',
      },
    ],
    Caligraphy: [
      {
        option: 'wheel',
        imgSrc: '/images/carComponent/wheel.svg',
        name: '캘리그라피 전용 휠',
        inch: '20 inch',
      },
      {
        option: 'sit',
        imgSrc: '/images/carComponent/sit.svg',
        name: '퀄팅 나파가죽 시트 (캘리그라피 전용)',
      },
      {
        option: 'navigation',
        imgSrc: '/images/carComponent/navigation.svg',
        name: '네비게이션',
        inch: '12.3 inch',
      },
      {
        option: 'cluster',
        imgSrc: '/images/carComponent/cluster.svg',
        name: '클러스터',
        inch: '12.3 inch',
      },
    ],
  };

  function setColor(colorSet: string[]) {
    return colorSet.map(color => (
      <>
        <Circle bgColor={color} />
      </>
    ));
  }

  function setInnerColor(colorSet: string[]) {
    return colorSet.map(color => (
      <>
        <p className="body-regular-14 text-grey-300">{color}</p>
      </>
    ));
  }

  return (
    <Overlay onClick={() => setter(false)}>
      <Wrapper onClick={e => e.stopPropagation()}>
        <Header className="head-medium-22 text-grey-50">
          비교하기
          <X src="/images/x_icon.svg" onClick={() => setter(false)} />
        </Header>
        <Grid>
          {data.trimList.map(trim => (
            <>
              <Item key={trim.trimName}>
                <CarImage src={trim.trimImage} />
                <Box>
                  <p className="body-regular-14 text-grey-300">
                    {trim.trimInfo}
                  </p>
                  <p className="head-medium-20 text-grey-0">{trim.trimName}</p>
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
                  <OuterColorContainer>
                    {setColor(trim.trimOuterColor)}
                  </OuterColorContainer>
                  <p className="body-medium-14 text-grey-200">내장 색상</p>
                  <InnerColorContainer>
                    {setInnerColor(trim.trimInnerColor)}
                  </InnerColorContainer>
                  <Hr />
                  <OptionBox gap={51}>
                    {Object.entries(commonOption).map(item => {
                      if (item[0] === trim.trimName) {
                        return item[1].map(option => (
                          <>
                            <Option key={option.name}>
                              <img src={option.imgSrc} />
                              <InchSpan>{option.inch}</InchSpan>
                              <NameSpan>{option.name}</NameSpan>
                            </Option>
                          </>
                        ));
                      }
                    })}
                  </OptionBox>
                  <Hr />
                  <span className="body-medium-14 text-grey-300">
                    기본 옵션
                  </span>
                  <OptionBox
                    gap={8}
                    className="text-secondary-active-blue body-regular-14"
                  >
                    {trim.trimOption.map(option => (
                      <>
                        <span key={option.name}>{option.name}</span>
                      </>
                    ))}
                  </OptionBox>
                </Box>
              </Item>
            </>
          ))}
        </Grid>
      </Wrapper>
    </Overlay>
  );
}

export default CompareModal;

const Grid = styled.div`
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 28px;
  text-align: center;
`;

const Item = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const Overlay = styled.div`
  width: 100vw;
  height: 1550px;
  background: rgba(15, 17, 20, 0.55);
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  left: 0;
  z-index: 5;
`;

const Header = styled.div`
  position: relative;
  text-align: center;
  margin-bottom: 50px;
`;

const Wrapper = styled.div`
  width: 900px;
  height: 1400px;
  border-radius: 12px;
  flex-shrink: 0;
  background: #fff;
  padding: 24px 38px 48px 38px;
  margin-top: 148px;
  margin-bottom: 148px;
`;

const X = styled.img`
  position: absolute;
  right: 0;
  cursor: pointer;
`;

const CarImage = styled.img`
  width: 185px;
  height: 83px;
  flex-shrink: 0;
  margin-bottom: 25px;
`;

const Box = styled.div`
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
  gap: 8px;
`;

const Hr = styled.hr`
  width: 140px;
  margin-top: 33px;
  margin-bottom: 33px;
  border-color: var(--primary-blue-10);
`;

const OptionBox = styled.div<{ gap: number }>`
  display: flex;
  gap: ${props => props.gap}px;
  flex-direction: column;
`;

const Option = styled.div`
  display: flex;
  gap: 8px;
  flex-direction: column;
  align-items: center;
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

const Circle = styled.div<{ bgColor: string }>`
  width: 16px;
  height: 16px;
  border-radius: 50%;
  background-color: ${props => props.bgColor};
`;

const OuterColorContainer = styled.div`
  display: flex;
  gap: 8px;
  justify-content: center;
  margin-bottom: 16px;
`;

const InnerColorContainer = styled.div`
  display: inline-flex;
  gap: 8px;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  height: 52px;
`;
