import React, { useEffect, useMemo, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import ErrorPopup from '../../components/common/ErrorPopup';
import SquareButton from '../../components/common/SquareButton';
import { useFetch } from '../../hooks/useFetch';
import { priceToString } from '../../util/PriceToString';

interface CodeAndAnswer {
  code: string;
  answer: string;
}

interface TrimInfo {
  trimId: number;
  trimName: string;
  trimPrice: number;
}

interface EngineInfo {
  engineId: number;
  engineName: string;
  enginePrice: number;
}

interface BodyInfo {
  bodyTypeId: number;
  bodyTypeName: string;
}

interface WDInfo {
  wdId: number;
  wdName: string;
  wdPrice: number;
}

interface SurveyProfileProps {
  experience: CodeAndAnswer;
  family: CodeAndAnswer;
  purpose: CodeAndAnswer;
  value: CodeAndAnswer;
  budgetRange: number;
  trims: TrimInfo[];
  compositions: {
    carEngines: EngineInfo[];
    bodyTypes: BodyInfo[];
    wheelDrives: WDInfo[];
  };
}

interface SurveyAnswer {
  experience: string;
  family: string;
  purpose: string;
  value: string;
  trimId: number;
  engineId: number;
  bodyTypeId: number;
  wdId: number;
  additionalOptionId1: number;
  reason1: string;
  additionalOptionId2: number;
  reason2: string;
  totalSum: number;
}

interface Option {
  optionId: number;
  optionName: string;
  optionPrice: number;
}

function SurveyPage() {
  const [answer, setAnswer] = useState<SurveyAnswer>({
    experience: '',
    family: '',
    purpose: '',
    value: '',
    trimId: 0,
    engineId: 0,
    bodyTypeId: 0,
    wdId: 0,
    additionalOptionId1: 0,
    reason1: '',
    additionalOptionId2: 0,
    reason2: '',
    totalSum: 0,
  });

  const [optionSelectActive, setOptionSelectActive] = useState(false);
  const [dropDownNum, setDropDownNum] = useState(0);
  const [optionList, setOptionList] = useState<Option[] | null>(null);
  const navigate = useNavigate();

  const { data, status, error } = useFetch<SurveyProfileProps>(
    '/carmasters/surveys',
  );

  useEffect(() => {
    if (!data) return;
    setAnswer({
      ...answer,
      experience: data.experience.code,
      family: data.family.code,
      purpose: data.purpose.code,
      value: data.value.code,
    });
  }, [data]);

  useEffect(() => {
    if (!data) return;

    const sumPrice =
      (answer.trimId
        ? data.trims[
            data.trims.findIndex(trim => trim.trimId === answer.trimId)
          ].trimPrice
        : 0) +
      (answer.engineId
        ? data.compositions.carEngines[answer.engineId - 1].enginePrice
        : 0) +
      (answer.wdId
        ? data.compositions.wheelDrives[answer.wdId - 1].wdPrice
        : 0) +
      (answer.additionalOptionId1 && optionList
        ? optionList[
            optionList.findIndex(
              option => option.optionId === answer.additionalOptionId1,
            )
          ].optionPrice
        : 0) +
      (answer.additionalOptionId2 && optionList
        ? optionList[
            optionList.findIndex(
              option => option.optionId === answer.additionalOptionId2,
            )
          ].optionPrice
        : 0);
    setAnswer({ ...answer, totalSum: sumPrice });
    if (answer.trimId && answer.engineId && answer.bodyTypeId && answer.wdId) {
      setOptionSelectActive(true);
      getOptions();
    }
  }, [answer.trimId, answer.engineId, answer.bodyTypeId, answer.wdId]);

  const OptionList1 = useMemo(() => {
    if (!optionList) return null;

    return optionList
      .map(item => {
        if (item.optionId === answer.additionalOptionId2) return null;
        return (
          <div key={item.optionName} id={item.optionId.toString()}>
            {item.optionName}
          </div>
        );
      })
      .filter(item => item !== null);
  }, [optionList, answer.additionalOptionId2]);

  const OptionList2 = useMemo(() => {
    if (!optionList) return null;

    return optionList
      .map(item => {
        if (item.optionId === answer.additionalOptionId1) return null;
        return (
          <div key={item.optionName} id={item.optionId.toString()}>
            {item.optionName}
          </div>
        );
      })
      .filter(item => item !== null);
  }, [optionList, answer.additionalOptionId1]);

  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  const headers = {
    accept: 'application/json',
    'Content-Type': 'application/json',
  };

  const requestOptions = {
    method: 'POST',
    headers: headers,
    body: JSON.stringify(answer),
  };

  function usePost() {
    fetch('https://api.ca-art.store/carmasters/surveys', requestOptions)
      .then(() => {
        navigate('/survey');
      })
      .catch(() => {
        navigate('/error');
      });
  }

  const getOptions = async () => {
    try {
      const response = await fetch(
        `https://api.ca-art.store/options/additional/summary/list?trimId=${answer.trimId}&engineId=${answer.engineId}&bodyTypeId=${answer.bodyTypeId}&wdId=${answer.wdId}`,
      );
      const jsonData = await response.json();
      setOptionList(jsonData.data);
    } catch (e) {
      navigate('/error');
    }
  };

  return (
    <>
      <Container>
        <Logo>
          <img src={'/images/hyundai_logo_default.svg'} />
        </Logo>

        <Title>
          전국 카마스터님께 묻습니다.
          <br />
          이런 고객들에겐 어떤 옵션을 추천하나요?
        </Title>

        <ProfileCard>
          <ProfileImg src="https://thispersondoesnotexist.com"></ProfileImg>
          <ProfileTextContainer>
            <ProfileText>
              <span className="head-medium-20">운전경력</span>
              <span className="body-medium-20">{data.experience.answer}</span>
            </ProfileText>
            <ProfileText>
              <span className="head-medium-20">가족</span>
              <span className="body-medium-20">{`${data.family.answer} 가구`}</span>
            </ProfileText>
            <ProfileText>
              <span className="head-medium-20">뮥적</span>
              <span className="body-medium-20">{data.purpose.answer}</span>
            </ProfileText>
            <ProfileText>
              <span className="head-medium-20">가치관</span>
              <span className="body-medium-20">{`${data.value.answer} 중시`}</span>
            </ProfileText>
            <ProfileText>
              <span className="head-medium-20">예산 범위</span>
              <span className="body-medium-20">{`${data.budgetRange} 만원`}</span>
            </ProfileText>
          </ProfileTextContainer>
        </ProfileCard>

        <QuestionContainer>
          <Question>어떤 트림을 가장 추천할 것인가요?</Question>
          <Answer>
            <TrimButton
              $selected={answer.trimId === 2}
              onClick={() => {
                setAnswer({ ...answer, trimId: 2 });
              }}
            >
              Exclusive
            </TrimButton>
            <TrimButton
              $selected={answer.trimId === 1}
              onClick={() => {
                setAnswer({ ...answer, trimId: 1 });
              }}
            >
              Le Blanc
            </TrimButton>
            <TrimButton
              $selected={answer.trimId === 3}
              onClick={() => {
                setAnswer({ ...answer, trimId: 3 });
              }}
            >
              Prestige
            </TrimButton>
            <TrimButton
              $selected={answer.trimId === 4}
              onClick={() => {
                setAnswer({ ...answer, trimId: 4 });
              }}
            >
              Calligraphy
            </TrimButton>
          </Answer>
        </QuestionContainer>

        <QuestionContainer>
          <Question>어떤 엔진을 가장 추천할 것인가요?</Question>
          <Answer>
            <TrimButton
              $selected={answer.engineId === 1}
              onClick={() => {
                setAnswer({ ...answer, engineId: 1 });
              }}
            >
              디젤
            </TrimButton>
            <TrimButton
              $selected={answer.engineId === 2}
              onClick={() => {
                setAnswer({ ...answer, engineId: 2 });
              }}
            >
              가솔린
            </TrimButton>
          </Answer>
        </QuestionContainer>

        <QuestionContainer>
          <Question>어떤 바디를 가장 추천할 것인가요?</Question>
          <Answer>
            <TrimButton
              $selected={answer.bodyTypeId === 1}
              onClick={() => {
                setAnswer({ ...answer, bodyTypeId: 1 });
              }}
            >
              7인승
            </TrimButton>
            <TrimButton
              $selected={answer.bodyTypeId === 2}
              onClick={() => {
                setAnswer({ ...answer, bodyTypeId: 2 });
              }}
            >
              8인승
            </TrimButton>
          </Answer>
        </QuestionContainer>

        <QuestionContainer>
          <Question>어떤 구동 방식을 가장 추천할 것인가요?</Question>
          <Answer>
            <TrimButton
              $selected={answer.wdId === 1}
              onClick={() => {
                setAnswer({ ...answer, wdId: 1 });
              }}
            >
              2WD
            </TrimButton>
            <TrimButton
              $selected={answer.wdId === 2}
              onClick={() => {
                setAnswer({ ...answer, wdId: 2 });
              }}
            >
              4WD
            </TrimButton>
          </Answer>
        </QuestionContainer>

        <QuestionContainer>
          <Question>첫번째로 어떤 옵션을 추천할 것인가요?</Question>
          <Answer>
            <DropDown
              onClick={() => {
                if (!optionSelectActive) return;
                if (dropDownNum === 1) {
                  setDropDownNum(0);
                } else {
                  setDropDownNum(1);
                }
              }}
              $optionSelectActive={optionSelectActive}
              $optionSelected={answer.additionalOptionId1 !== 0}
            >
              {optionSelectActive && (
                <DropDownIcon src="/images/dropdown_icon_default.svg"></DropDownIcon>
              )}
              <span>
                {answer.additionalOptionId1 && optionList
                  ? optionList[
                      optionList.findIndex(
                        option =>
                          option.optionId === answer.additionalOptionId1,
                      )
                    ].optionName
                  : '첫번째 옵션'}
              </span>
              {dropDownNum === 1 && (
                <DropDownList
                  onClick={e => {
                    setAnswer({
                      ...answer,
                      additionalOptionId1: parseInt(
                        (e.target as HTMLElement).id,
                      ),
                    });
                  }}
                >
                  {optionList && OptionList1}
                </DropDownList>
              )}
            </DropDown>
          </Answer>
        </QuestionContainer>

        <QuestionContainer>
          <Question>이유는 무엇인가요?</Question>
          <Answer>
            <TextAnswer
              disabled={answer.additionalOptionId1 === 0}
              type={'text'}
              placeholder="30자 이내로 짧게 적어주세요"
              value={answer.reason1}
              maxLength={30}
              onChange={e => {
                setAnswer({ ...answer, reason1: e.target.value });
              }}
            ></TextAnswer>
          </Answer>
        </QuestionContainer>

        <QuestionContainer>
          <Question>두번째로 어떤 옵션을 추천할 것인가요?</Question>
          <Answer>
            <DropDown
              onClick={() => {
                if (!optionSelectActive) return;
                if (dropDownNum === 2) {
                  setDropDownNum(0);
                } else {
                  setDropDownNum(2);
                }
              }}
              $optionSelectActive={optionSelectActive}
              $optionSelected={answer.additionalOptionId2 !== 0}
            >
              {optionSelectActive && (
                <DropDownIcon src="/images/dropdown_icon_default.svg"></DropDownIcon>
              )}
              <span>
                {answer.additionalOptionId2 && optionList
                  ? optionList[
                      optionList.findIndex(
                        option =>
                          option.optionId === answer.additionalOptionId2,
                      )
                    ].optionName
                  : '두번째 옵션'}
              </span>
              {dropDownNum === 2 && (
                <DropDownList
                  onClick={e => {
                    setAnswer({
                      ...answer,
                      additionalOptionId2: parseInt(
                        (e.target as HTMLElement).id,
                      ),
                    });
                  }}
                >
                  {optionList && OptionList2}
                </DropDownList>
              )}
            </DropDown>
          </Answer>
        </QuestionContainer>

        <QuestionContainer>
          <Question>이유는 무엇인가요?</Question>
          <Answer>
            <TextAnswer
              disabled={answer.additionalOptionId2 === 0}
              type={'text'}
              placeholder="30자 이내로 짧게 적어주세요"
              value={answer.reason2}
              maxLength={30}
              onChange={e => {
                setAnswer({ ...answer, reason2: e.target.value });
              }}
            ></TextAnswer>
          </Answer>
        </QuestionContainer>
      </Container>

      <TotalPrice>
        <span>총 견적</span>
        <span>{priceToString(answer.totalSum)}</span>
        {answer.totalSum > data.budgetRange * 10000 && (
          <PriceAlert>예산 범위를 초과했습니다!</PriceAlert>
        )}
      </TotalPrice>

      <NextButton>
        <SquareButton
          size="xl"
          color="grey-1000"
          bg="primary-blue"
          onClick={usePost}
          $disabled={
            !optionSelectActive ||
            answer.additionalOptionId1 === 0 ||
            answer.additionalOptionId2 === 0 ||
            answer.reason1 === '' ||
            answer.reason2 === ''
          }
        >
          다음 설문
        </SquareButton>
      </NextButton>
    </>
  );
}

const Container = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;
  width: 1024px;
  margin: 80px auto 80px auto;
`;

const Logo = styled.div`
  position: absolute;
  top: -40px;
  left: 0px;
`;

const Title = styled.div`
  font-family: 'HyundaiHeadBold';
  font-size: 40px;
  letter-spacing: -0.3px;
  line-height: 140%;
  font-weight: 700;
  font-style: normal;
  white-space: pre-wrap;
`;

const ProfileCard = styled.div`
  width: 1024px;
  height: 315px;
  margin-top: 26px;
  border-radius: 20px;
  background: #d9d9d9;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
`;

const ProfileImg = styled.img`
  width: 250px;
  height: 250px;
  border-radius: 50%;
`;

const ProfileTextContainer = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;
  width: 400px;
`;

const ProfileText = styled.div`
  display: flex;
  gap: 40px;

  & > :first-child {
    width: 100px;
  }
`;

const QuestionContainer = styled.div`
  display: flex;
  gap: 40px;
  align-items: center;
  margin-top: 60px;
`;

const Question = styled.div`
  width: 400px;
  font-family: 'HyundaiHeadBold';
  font-size: 20px;
  letter-spacing: -0.4px;
  line-height: 140%;
  font-weight: 700;
  font-style: normal;
`;

const Answer = styled.div`
  display: flex;
  gap: 20px;
`;

const TrimButton = styled.div<{ $selected?: boolean }>`
  width: 120px;
  padding: 15px;
  text-align: center;
  background: ${props => (props.$selected ? '#fff' : '#f0f0f0;')};
  border: ${props =>
    props.$selected ? '1.5px solid #00428E' : '1.5px solid transparent'};
  border-radius: 12px;
  cursor: pointer;

  font-family: 'HyundaiHeadBold';
  font-size: 16px;
  letter-spacing: -0.3px;
  line-height: 140%;
  font-weight: 500;
  font-style: normal;

  &:hover {
    background: #fff;
    border: 1.5px solid #00428e;
  }
`;

const DropDown = styled.div<{
  $optionSelectActive: boolean;
  $optionSelected: boolean;
}>`
  position: relative;
  display: flex;
  flex-direction: column;
  gap: 15px;
  width: 260px;
  padding: 15px;
  text-align: center;
  border: ${props =>
    props.$optionSelected ? '1.5px solid #00428e' : '1.5px solid transparent'};
  border-radius: 12px;
  cursor: ${props => (props.$optionSelectActive ? 'pointer' : 'not-allowed')};
  background: ${props => (props.$optionSelected ? '#fff' : '#f0f0f0')};

  font-family: 'HyundaiHeadBold';
  font-size: 16px;
  letter-spacing: -0.3px;
  line-height: 140%;
  font-weight: 500;
  font-style: normal;

  &:hover {
    background: #fff;
    border: 1.5px solid #00428e;
  }
`;

const DropDownIcon = styled.img`
  position: absolute;
  top: 19px;
  right: 10px;
  width: 16px;
  height: 16px;
`;

const DropDownList = styled.div`
  width: 260px;
  height: 157px;
  position: absolute;
  display: flex;
  flex-direction: column;
  left: 50%;
  top: 60px;
  transform: translateX(-50%);
  overflow: scroll;
  background: #fff;
  border: 1.5px solid #00428e;
  border-radius: 12px;

  > div {
    padding: 15px;
  }

  > div:hover {
    background: #f0f0f0;
  }
`;

const TextAnswer = styled.input`
  width: 540px;
  height: 50px;
  padding-left: 20px;
  border-radius: 20px;
  border: ${props =>
    props.value ? '1.5px solid #00428e' : '1.5px solid transparent'};
  background: ${props => (props.value ? '#fff' : '#f0f0f0')};
  cursor: ${props => (props.disabled ? 'not-allowed' : 'pointer')};

  &:active {
    border: 1.5px solid #00428e;
  }
`;

const TotalPrice = styled.div`
  width: 1024px;
  margin: 0px auto 60px auto;
  display: flex;
  justify-content: flex-end;
  gap: 38px;
  position: relative;

  font-family: 'HyundaiHeadMedium';
  font-size: 40px;
  font-style: normal;
  font-weight: 700;
  line-height: 140%;
  letter-spacing: -0.3px;
`;

const PriceAlert = styled.div`
  position: absolute;
  top: 55px;
  right: 0px;

  color: #ff2e00;
  font-family: HyundaiHeadMedium;
  font-size: 20px;
  font-style: normal;
  font-weight: 500;
  line-height: 140%;
  letter-spacing: -0.3px;
`;

const NextButton = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 40px;
`;

export default SurveyPage;
