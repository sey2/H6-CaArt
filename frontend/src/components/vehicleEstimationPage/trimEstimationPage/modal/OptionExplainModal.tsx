import React, { useRef, useState, useEffect } from 'react';
import { styled } from 'styled-components';
import { useModalContext } from '../../../../store/ModalContext';
import replaceWonSymbol from "../../../../util/ReplaceWonSymbol";

function OptionExplainModal() {
  const { state, dispatch } = useModalContext();
  const componentRef = useRef<HTMLDivElement>(null);
  const [componentHeight, setComponentHeight] = useState<number>(0);

  useEffect(() => {
    if (componentRef.current) {
      const height = componentRef.current.getBoundingClientRect().height;
      setComponentHeight(height);
    }
  }, [state.optionModalPosition.y]);
  return (
    <Modal
      top={state.optionModalPosition.y}
      left={state.optionModalPosition.x}
      onClick={e => e.stopPropagation()}
      $isopen={state.optionModalOpen}
      ref={componentRef}
      height={componentHeight}
    >
      <X
        src="/images/icon/x_icon.svg"
        onClick={() => dispatch({ type: 'CLOSE_OPTION_MODAL' })}
      />
      <Title className="body-bold-18 text-grey-0">
        {state.optionModalData.optionName}
      </Title>
      <Image src={state.optionModalData.optionImage} />
      <Content className="body-regular-14 text-grey-200">
        {replaceWonSymbol(state.optionModalData.description)}
      </Content>
      <footer className="caption-regular-12 text-grey-400">
        * 사진과 설명은 참고용이며 실제 차량과는 상이할 수 있습니다.
      </footer>
    </Modal>
  );
}

export default OptionExplainModal;

const Modal = styled.div<{
  top: number;
  left: number;
  $isopen: boolean;
  height: number;
}>`
  position: absolute;
  top: ${props => {
    if (props.$isopen) {
      if (props.top + props.height > window.innerHeight) {
        return window.innerHeight - props.height - 10 + 'px';
      }

      return Math.max(130, props.top) + 'px';
    }
    return 0;
  }};
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
  transition: opacity 0.5s ease-out;
  visibility: hidden;
  opacity: 0;
  ${props => props.$isopen && `visibility:visible;opacity:1;`};
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
