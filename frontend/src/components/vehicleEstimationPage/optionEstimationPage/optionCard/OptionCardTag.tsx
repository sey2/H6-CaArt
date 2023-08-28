import React from 'react';
import styled from 'styled-components';

interface OptionCardTagProps {
  type: 'red' | 'blue';
  tag: string;
}

function OptionCardTag({ type, tag }: OptionCardTagProps) {
  return (
    <OptionCardTagBox type={type}>
      <span className="body-medium-12 text-grey-1000">{tag}</span>
    </OptionCardTagBox>
  );
}

const OptionCardTagBox = styled.div<Pick<OptionCardTagProps, 'type'>>`
  display: inline-flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
  padding: 6px;
  border-radius: 4px 0px;
  background: ${props => (props.type === 'red' ? '#AE4747' : '#558ac7')};
`;

export default OptionCardTag;
