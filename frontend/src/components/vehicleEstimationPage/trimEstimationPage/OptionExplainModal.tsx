import React from 'react';
import { styled } from 'styled-components';

function OptionExplainModal({
  x,
  y,
  setter,
}: {
  setter: React.Dispatch<React.SetStateAction<boolean>>;
  x: number;
  y: number;
}) {
  return (
    <Modal top={y} left={x}>
      <X src="/images/x_icon.svg" onClick={() => setter(false)} />
      <Title className="body-bold-18 text-grey-0">
        네비게이션 기반 스마트 크루즈 컨트롤(진출입로)
      </Title>
      <Image src="/images/temp.svg" />
      <Content className="body-regular-14 text-grey-200">
        스마트 크루즈 중 고속도로/도시고속도로/ 자동차전용 도로 내 고속도로
        진출입로 주행 시 차로를 판단하여 사전감속 또 최적 속도에 맞추어 감속을
        진행합니다.
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
  top: ${props => props.top - 8}px;
  left: ${props => props.left}px;
  display: flex;
  flex-direction: column;
  width: 300px;
  flex-shrink: 0;
  border-radius: 12px;
  padding: 21px 24px 23px 25px;
  background: var(--grey-1000);
  box-shadow: 0px 4px 30px 0px rgba(142, 152, 168, 0.4);
  z-index: 10;
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
