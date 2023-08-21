import React, { useContext, useEffect } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { ErrorPopup } from '../../components/common/ErrorPopup';
import { ResultMain } from '../../components/common/result/ResultMain';
import SquareButton from '../../components/common/SquareButton';
import { RecommendResultCard } from '../../components/recommendPage/ageAndLifeStyle/RecommendResultCard';
import { useFetch } from '../../hooks/useFetch';
import { EstimationContext } from '../../util/Context';
import { RecommendPageProps } from './RecommendPage';

export interface LifeStyleResultProps {
  palisadeImage: string;
  recommendationCard: {
    slogan: string;
    message: string;
  };
  model: {
    modelName: string;
    trim: {
      trimName: string;
      trimPrice: number;
    };
    engine: {
      engineName: string;
      enginePrice: number;
    };
    wheelDrive: {
      wheelDriveName: string;
      wheelDrivePrice: number;
    };
    bodyType: {
      bodyTypeName: string;
      bodyTypePrice: number;
    };
    modelPrice: number;
  };
  colors: {
    colorImage: string;
    isExterior: boolean;
    colorName: string;
    colorPrice: number;
    recommendationMessage: string;
  }[];
  options: {
    optionImage: string;
    optionName: string;
    optionPrice: number;
    recommendationMessage: string;
  }[];
  totalPrice: number;
}

function RecommendLifeStyleResultPage({
  choice,
}: Pick<RecommendPageProps, 'choice'>) {
  const { setResult } = useContext(EstimationContext)!;

  const { data, status, error } = useFetch<LifeStyleResultProps>(
    `/personas/${choice.lifeStyle}/recommendation?ageId=${choice.age.id}`,
  );

  useEffect(() => {
    if (data) {
      setResult(data);
    }
  }, [data]);

  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  return (
    <RecommendLifeStyleResultPageBox>
      <RecommendLifeStyleResultPageCarImgBox>
        <RecommendResultCard
          palisadeImage={data.palisadeImage}
          model={data.model}
          recommendationCard={data.recommendationCard}
        ></RecommendResultCard>
      </RecommendLifeStyleResultPageCarImgBox>
      <ResultMain></ResultMain>
      <RecommendLifeStyleResultPageBtnBox>
        <Link to="/estimate/trim">
          <SquareButton size="m" color="grey-50" bg="grey-1000" border>
            커스텀하기
          </SquareButton>
        </Link>
        <Link to="/result">
          <SquareButton size="m" color="grey-1000" bg="primary-blue">
            빠른 견적내기
          </SquareButton>
        </Link>
      </RecommendLifeStyleResultPageBtnBox>
    </RecommendLifeStyleResultPageBox>
  );
}

const RecommendLifeStyleResultPageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const RecommendLifeStyleResultPageCarImgBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 485px;
  margin-bottom: 56px;
  background: linear-gradient(180deg, #a2b1d3 0%, #edf2fe 100%);
`;

const RecommendLifeStyleResultPageBtnBox = styled.div`
  display: flex;
  gap: 12px;
  margin-top: 60px;
  margin-bottom: 36px;
`;

export { RecommendLifeStyleResultPage };
