import React from 'react';
import styled from 'styled-components';

function OptionCardTag({ type, tag }: OptionCardTagProps) {
  return (
    <>
      <OptionCardTagBox type={type}>
        <span>{tag}</span>
      </OptionCardTagBox>
    </>
  );
}

interface OptionCardTagProps {
  type: 'red' | 'blue';
  tag: string;
}

const OptionCardTagBox = styled.div<Pick<OptionCardTagProps, 'type'>>`
  display: inline-flex;
  padding: 6px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  border-radius: 4px 0px;
  background: ${props => (props.type === 'red' ? '#AE4747' : '#558ac7')};

  color: var(--grey-1000);
  text-align: center;
  font-family: 'HyundaiTextMedium';
  font-size: 12px;
  font-style: normal;
  font-weight: 500;
  line-height: 100%;
  letter-spacing: -0.487px;
`;

export { OptionCardTag };
