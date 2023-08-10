import React from 'react';
import { styled } from 'styled-components';

function RankBanner({ rank }: { rank: number }) {
  return (
    <Box>
      <span className="text-grey-1000 body-medium-12">Top {rank}</span>
    </Box>
  );
}

export default RankBanner;

const Box = styled.div`
  width: 40px;
  height: 20px;
  border-radius: 4px 0px 4px 0px;
  background-color: var(--grey-300);
  text-align: center;
  position: absolute;
  top:0;
  left:0;
`;
