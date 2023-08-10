import React from 'react';
import styled from 'styled-components';

function LifeStylePeekInterview() {
  return (
    <LifeStylePeekInterviewBox>
      <div className="head-medium-24 text-grey-0">Interview</div>
      <LifeStylePeekQNABox>
        <LifeStylePeekQNA>
          <LifeStylePeekQ>
            <div className="head-meidum-16 text-primary-blue">Q.</div>
            <div className="body-medium-16 text-grey-50">
              어떤 용도로 차를 사용하세요?
            </div>
          </LifeStylePeekQ>
          <LifeStylePeekA className="body-regular-14 text-secondary-active-blue">
            저는 차를 타고 출퇴근도 하지만 주중에 아이들 픽업하거나 마트 갈 때도
            자주 타곤 합니다.
          </LifeStylePeekA>
        </LifeStylePeekQNA>
        <LifeStylePeekQNA>
          <LifeStylePeekQ>
            <div className="head-meidum-16 text-primary-blue">Q.</div>
            <div className="body-medium-16 text-grey-50">
              차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?
            </div>
          </LifeStylePeekQ>
          <LifeStylePeekA className="body-regular-14 text-secondary-active-blue">
            저는 차를 살 때 안전을 중요하게 생각해요. 가족들이 같이 타는 차라
            항상 사고에 경각심을 갖고 있죠. 펠리세이드는 그 점에서 뒷자석
            에어백도 터지는 모델이라 안심이 되는 편이에요.
          </LifeStylePeekA>
        </LifeStylePeekQNA>
      </LifeStylePeekQNABox>
    </LifeStylePeekInterviewBox>
  );
}

const LifeStylePeekInterviewBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 16px;
`;

const LifeStylePeekQNABox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 32px;
`;

const LifeStylePeekQNA = styled.div`
  display: flex;
  flex-direction: column;
  gap: 8px;
`;

const LifeStylePeekQ = styled.div`
  display: flex;
  gap: 8px;
  align-items: center;
`;

const LifeStylePeekA = styled.div`
  display: flex;
  align-items: center;
  width: 608px;
  padding: 12px;
  border-radius: 8px;
  background: rgba(33, 151, 201, 0.1);
`;

export { LifeStylePeekInterview };
