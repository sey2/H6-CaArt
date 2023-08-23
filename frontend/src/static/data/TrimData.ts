export interface TrimProps {
  colorName: string;
  colorImage: string;
  colorPrice: number;
  interiorColorName: string;
  interiorColorImage: string;
  interiorColorPrice: number;
  preview: string;
  trimImage: string;
}

export interface TrimDataProps {
  Exclusive: TrimProps;
  'Le Blanc': TrimProps;
  Prestige: TrimProps;
  Calligraphy: TrimProps;
}

const TrimData:TrimDataProps = {
  Exclusive: {
    colorName: '그라파이트 그레이 메탈릭',
    colorImage:
      'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/15.png',
    colorPrice: 0,
    interiorColorName: '인조가죽(블랙)',
    interiorColorImage:
      'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/interior/7.png',
    interiorColorPrice: 0,
    preview: "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/inside/9.png",
    trimImage: "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-2.png",
  },
  'Le Blanc': {
    colorName: '크리미 화이트 펄',
    colorImage:
      'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/16.png',
    colorPrice: 100000,
    interiorColorName: '퀄팅 천연(블랙)',
    interiorColorImage:
      'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/interior/17.png',
    interiorColorPrice: 0,
    preview:"https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/inside/17-preview.png",
    trimImage: "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-1.png",

  },
  Prestige: {
    colorName: '문라이프 블루 펄',
    colorImage:
      'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/13.png',
    colorPrice: 0,
    interiorColorName: '네이비',
    interiorColorImage:
      'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/interior/3.png',
    interiorColorPrice: 0,
    preview:"https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/inside/10.png",
    trimImage: "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-3.png",

  },
  Calligraphy: {
    colorName: '가이아 브라운 펄',
    colorImage:
      'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/14.png',
    colorPrice: 0,
    interiorColorName: '블랙(고급)',
    interiorColorImage:
      'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/interior/6.png',
    interiorColorPrice: 0,
    preview:"https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/inside/14.png",
    trimImage: "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-4.png",

  },
};

export default TrimData;
