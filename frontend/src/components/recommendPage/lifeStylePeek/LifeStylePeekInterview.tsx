import React from 'react';
import styled from 'styled-components';
import { LifeStyleModalProps } from './LifeStylePeekModal';

function LifeStylePeekInterview({
  interviews,
}: Pick<LifeStyleModalProps, 'interviews'>) {
  const QNAList = interviews.map((item, index) => {
    return (
      <LifeStylePeekQNA key={index}>
        <LifeStylePeekQ>
          <div className="head-meidum-16 text-primary-blue">Q.</div>
          <div className="body-medium-16 text-grey-50">{item.question}</div>
        </LifeStylePeekQ>
        <LifeStylePeekA className="body-regular-14 text-secondary-active-blue">
          {item.answer}
        </LifeStylePeekA>
      </LifeStylePeekQNA>
    );
  });

  return (
    <LifeStylePeekInterviewBox>
      <div className="head-medium-24 text-grey-0">Interview</div>
      <LifeStylePeekQNABox>{QNAList}</LifeStylePeekQNABox>
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
