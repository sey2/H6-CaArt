import React from 'react';
import styled from 'styled-components';

function OptionCardGuide({ percentage }: { percentage: number }) {
  return (
    <>
      <OptionCardGuideBox>
        <span className="body-regular-12 text-grey-1000">
          {`${percentage}%의 사용자가 선택했습니다.`}
        </span>
      </OptionCardGuideBox>
    </>
  );
}

const OptionCardGuideBox = styled.div`
  display: flex;
  align-items: center;
  width: 244px;
  height: 34px;
  padding: 8px 12px;
  border-radius: 0px 0px 4px 4px;
  background: rgba(33, 151, 201, 0.64);
  backdrop-filter: blur(4px);
`;

export default OptionCardGuide;
