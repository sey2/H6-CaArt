import React, { useEffect, useState } from 'react';
import TopContainer from '../../components/resultPage/TopContainer';
import { ResultMain } from '../../components/common/result/ResultMain';
import { styled } from 'styled-components';
import SquareButton from '../../components/common/SquareButton';
import BuyCarContainer from '../../components/resultPage/BuyCarContainer';
import { Link } from 'react-router-dom';
import ShareModal from '../../components/resultPage/modal/ShareModal';
import MailModal from '../../components/resultPage/modal/MailModal';
import MakePdf from '../../util/MakePdf';

function ResultPage() {
  const [shareModal, setShareModal] = useState<boolean>(false);
  const [mailModal, setMailModal] = useState<boolean>(false);
  const pdf = MakePdf();
  const getPdf = async (e: React.MouseEvent) => {
    e.preventDefault();
    await pdf.viewWithPdf();
  };
  useEffect(() => {
    window.scroll(0, 0);
  }, []);
  return (
    <Wrapper share={shareModal} mail={mailModal}>
      {shareModal && <ShareModal setter={setShareModal} isOpen={shareModal} />}
      {mailModal && <MailModal setter={setMailModal} isOpen={mailModal} />}
      <div className="pdf">
      <TopContainer setter={setShareModal} />
      <MainContainer>
        <ResultMain />
        <ButtonContainer>
          <SquareButton size="s" color="grey-200" border>
            내 계정에 저장
          </SquareButton>
          <div onClick={getPdf}>
            <SquareButton size="s" color="grey-200" border>
              PDF로 저장
            </SquareButton>
          </div>
          <SquareButton
            size="s"
            color="grey-200"
            border
            onClick={() => setMailModal(true)}
          >
            내 메일로 발송
          </SquareButton>
        </ButtonContainer>
      </MainContainer>
      </div>
      <Hr />
      <BuyCarContainer />
      <ButtonContainer className="last">
        <Link to="/estimate/option">
          <SquareButton size="m" color="grey-50" border>
            수정
          </SquareButton>
        </Link>
        <SquareButton size="m" color="grey-1000" bg="primary-blue">
          구매/상담
        </SquareButton>
      </ButtonContainer>
    </Wrapper>
  );
}

export default ResultPage;

const MainContainer = styled.div`
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  margin-top: 36px;
`;

const ButtonContainer = styled.div`
  display: flex;
  height: 52px;
  justify-content: center;
  align-items: center;
  gap: 8px;
  margin-top: 33px;
  margin-bottom: 52px;
  .last {
    gap: 18px;
    margin-top: 66px;
    margin-bottom: 36px;
  }
`;

const Hr = styled.div`
  margin: 0 auto;
  width: 608px;
  height: 1px;
  background: var(--grey-700);
`;

const Wrapper = styled.div<{ share: boolean; mail: boolean }>`
  overflow-x: hidden;
  ${props =>
    props.share || props.mail ? `position:fixed;` : `position:static;`}
`;
