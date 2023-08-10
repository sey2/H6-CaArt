import React from 'react';
import styled from 'styled-components';

function PageNum({ children }: { children: string }) {
  return (
    <PageNumBox className="head-medium-16 text-grey-400">{children}</PageNumBox>
  );
}

const PageNumBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 64px;
  height: 36px;
  border-radius: 22px;
  background: var(--grey-900);
`;

export { PageNum };
