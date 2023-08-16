import React from 'react';
import { styled } from 'styled-components';
import { OptionType } from '../../../pages/vehicleEstimationPage/TrimEstimationPage';

function OptionExplainModal({
  x,
  y,
  setter,
  data,
  isOpen,
}: {
  setter: React.Dispatch<React.SetStateAction<boolean>>;
  data: OptionType | undefined;
  x: number;
  y: number;
  isOpen: boolean;
}) {
  console.log('x:', x, 'y:', y);
  return (
    <Modal
      top={y}
      left={x}
      onClick={e => e.stopPropagation()}
      className={isOpen ? 'active' : ''}
    >
      <X src="/images/x_icon.svg" onClick={() => setter(false)} />
      <Title className="body-bold-18 text-grey-0">{data?.optionName}</Title>
      <Image src={data?.optionImage} />
      <Content className="body-regular-14 text-grey-200">
        {data?.description}
      </Content>
      <footer className="caption-regular-12 text-grey-400">
        *사진과 설명은 참고용이며 실제 차량과는 상이할 수 있습니다.
      </footer>
    </Modal>
  );
}

export default OptionExplainModal;

const Modal = styled.div<{ top: number; left: number }>`
  position: absolute;
  top: ${props => props.top}px;
  left: ${props => props.left - 160}px;
  display: flex;
  flex-direction: column;
  width: 300px;
  flex-shrink: 0;
  border-radius: 12px;
  padding: 21px 24px 23px 25px;
  background: var(--grey-1000);
  box-shadow: 0px 4px 30px 0px rgba(142, 152, 168, 0.4);
  z-index: 10;
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.5s ease-out;
  &.active {
    opacity: 1;
    visibility: visible;
  }
`;
const Title = styled.span`
  width: 206px;
`;
const Image = styled.img`
  width: 251px;
  height: 168px;
  border-radius: 4px;
  margin: 16px 0px 12px 0px;
`;
const Content = styled.div`
  margin-bottom: 5px;
`;

const X = styled.img`
  position: absolute;
  right: 24px;
  top: 21px;
  width: 24px;
  height: 24px;
  cursor: pointer;
`;
