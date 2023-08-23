import React, { useContext, useEffect, useMemo } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useFetch } from '../../hooks/useFetch';
import { EstimationContext } from '../../util/Context';
import { ErrorPopup } from '../../components/common/ErrorPopup';
import { ResultMain } from '../../components/common/result/ResultMain';
import SquareButton from '../../components/common/SquareButton';
import { TagList } from '../../components/common/TagList';
import { question } from './RecommendDetailPage';
import { LifeStyleResultProps } from './RecommendLifeStyleResultPage';
import { RecommendPageProps } from './RecommendPage';

function RecommendDetailResultPage({
  choice,
}: Pick<RecommendPageProps, 'choice'>) {
  const { setResult } = useContext(EstimationContext)!;

  const { data, status, error } = useFetch<LifeStyleResultProps>(
    `/lifestyles/recommendation?age=${choice.age.code}&experience=${choice.experience.code}&family=${choice.family.code}&purpose=${choice.purpose.code}&value=${choice.value.code}&budget=${choice.budget}`,
  );

  useEffect(() => {
    if (data) {
      setResult(data);
    }
  }, [data]);

  const tagList = useMemo(() => {
    return [
      `${question[0][choice.experience.id]}`,
      `${question[1][choice.family.id]}`,
      `${question[2][choice.purpose.id]}`,
      `${question[3][choice.value.id]}`,
      `${choice.budget}만원`,
    ];
  }, [choice]);

  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  return (
    <RecommendDetailResultPageBox>
      <RecommendDetailResultPageCarImgBox>
        <FlexBox>
          <TagList tagArr={tagList} type="result"></TagList>
          <RecommendDetailResultPageCarTextBox>
            <span className="head-medium-26 text-grey-0">
              질문에 기반한 추천 차량이에요.
            </span>
            <span className="body-regular-14 text-grey-200">
              전국의 카마스터분들이 엄선하여 추천했어요.
            </span>
          </RecommendDetailResultPageCarTextBox>
        </FlexBox>
      </RecommendDetailResultPageCarImgBox>
      <RecommendDetailResultPageBottomBox>
        <RecommendDetailResultPageCarImg
          src={data.palisadeImage}
        ></RecommendDetailResultPageCarImg>
      </RecommendDetailResultPageBottomBox>

      <ResultMain></ResultMain>
      <RecommendDetailResultPageBtnBox>
        <Link to="/estimate/trim">
          <SquareButton size="m" color="grey-50" bg="grey-1000" $border>
            커스텀하기
          </SquareButton>
        </Link>
        <Link to="/result">
          <SquareButton size="m" color="grey-1000" bg="primary-blue">
            빠른 견적내기
          </SquareButton>
        </Link>
      </RecommendDetailResultPageBtnBox>
    </RecommendDetailResultPageBox>
  );
}

const RecommendDetailResultPageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const RecommendDetailResultPageCarImgBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 16px;
  width: 100%;
  height: 218px;
  background: linear-gradient(180deg, #e6eaef 0%, #f1f4f7 100%);
`;

const FlexBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 16px;
  align-items: flex-start;
  width: 608px;
  padding-top: 64px;
`;

const RecommendDetailResultPageCarTextBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 8px;
`;

const RecommendDetailResultPageBottomBox = styled.div`
  width: 100%;
  height: 116px;
  background: var(--grey-300);
  margin-bottom: 56px;
  position: relative;
`;

const RecommendDetailResultPageCarImg = styled.img`
  position: absolute;
  top: -180px;
  right: 10%;
  width: 538px;
`;

const RecommendDetailResultPageBtnBox = styled.div`
  display: flex;
  gap: 12px;
  margin-top: 60px;
  margin-bottom: 36px;
`;

export default RecommendDetailResultPage;
