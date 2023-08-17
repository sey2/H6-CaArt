import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

const MakePdf = () => {
  const converToImg = async (): Promise<string> => {
    const paper = document.querySelector('body');

    const canvas = await html2canvas(paper as HTMLElement);
    const imageFile = canvas.toDataURL('image/png', 1.0);

    return imageFile;
  };

  const converToPdf = (imageFile: string): File => {
    const doc = new jsPDF('p', 'mm', 'a4');

    const pageWidth = doc.internal.pageSize.getWidth();
    const pageHeight = doc.internal.pageSize.getHeight();

    doc.addImage(imageFile, 'JPEG', 0, 0, pageWidth, pageHeight);

    const pdfBlob = doc.output('blob');
    const pdf = new File([pdfBlob], 'test.pdf', {
      type: 'application/pdf',
    });

    return pdf;
  };

  return {
    viewWithPdf: async (): Promise<void> => {
      const imageFile = await converToImg();

      const pdf = converToPdf(imageFile);
      window.open(URL.createObjectURL(pdf));
    },
  };
};

export default MakePdf;
