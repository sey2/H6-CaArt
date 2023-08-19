const data = {
  trimList: [
    {
      trimName: 'Exclusive',
      trimInfo: '합리적인 당신을 위한',
      trimPrice: 10000000,
      trimImage: '/images/car/exclusive.svg',
      trimOuterColor: [
        '#121212',
        '#979999',
        '#171D2F',
        '#292622',
        '#313433',
        '#F2F4F3',
      ],
      trimInnerColor: ['인조가죽(블랙)'],
      trimOption: [
        {
          id: 0,
          name: '12인치 네비게이션',
          info: '11',
          image: '11',
        },
        {
          id: 1,
          name: '내비 기반 크루즈 컨트롤',
          info: '11',
          image: '11',
        },
        {
          id: 2,
          name: '세이프티 파워 윈도우',
          info: '11',
          image: '11',
        },
      ],
    },
    {
      trimName: 'Le Blanc',
      trimInfo: '필수적인 옵션만 모은',
      trimPrice: 20000000,
      trimImage: '/images/car/leBlanc.svg',
      trimOuterColor: [
        '#121212',
        '#979999',
        '#171D2F',
        '#292622',
        '#313433',
        '#F2F4F3',
      ],
      trimInnerColor: ['쿨그레이', '퀄팅천연(블랙)'],
      trimOption: [
        {
          id: 0,
          name: '20인치 알로이 휠',
          info: '11',
          image: '11',
        },
        {
          id: 1,
          name: '12인치 클러스터',
          info: '11',
          image: '11',
        },
        {
          id: 2,
          name: '서라운드 뷰 모니터',
          info: '11',
          image: '11',
        },
      ],
    },
    {
      trimName: 'Prestige',
      trimInfo: '가치있는 드라이빙 경험을 주는',
      trimPrice: 30000000,
      trimImage: '/images/car/prestige.svg',
      trimOuterColor: [
        '#121212',
        '#979999',
        '#171D2F',
        '#292622',
        '#313433',
        '#F2F4F3',
      ],
      trimInnerColor: ['네이비', '블랙', '버건디'],
      trimOption: [
        {
          id: 0,
          name: '2열 통풍시트',
          info: '11',
          image: '11',
        },
        {
          id: 1,
          name: '스마트 자세제어',
          info: '11',
          image: '11',
        },
        {
          id: 2,
          name: '2열 수동식 도어 커튼',
          info: '11',
          image: '11',
        },
      ],
    },
    {
      trimName: 'Caligraphy',
      trimInfo: '남들과 차별화된 경험',
      trimPrice: 40000000,
      trimImage: '/images/car/calligraphy.svg',
      trimOuterColor: [
        '#121212',
        '#A1A3A2',
        '#142419',
        '#181F30',
        '#2C2925',
        '#3C3F3E',
        '#F1F2F3',
      ],
      trimInnerColor: ['블랙(고급)', '브라운', '블랙 원톤(블랙에디션 전용)'],
      trimOption: [
        {
          id: 0,
          name: '20인치 캘리그라피 전용 휠',
          info: '11',
          image: '11',
        },
        {
          id: 1,
          name: 'KRELL 프리미엄 사운드',
          info: '11',
          image: '11',
        },
        {
          id: 2,
          name: '블랙 에디션',
          info: '11',
          image: '11',
        },
      ],
    },
  ],
};

const commonOption = {
  Exclusive: [
    {
      option: 'wheel',
      imgSrc: '/images/carComponent/18_wheel.svg',
      name: '기본 휠',
      inch: '18 inch',
    },
    {
      option: 'sit',
      imgSrc: '/images/carComponent/sit.svg',
      name: '인조/천연가죽 시트',
    },
    {
      option: 'navigation',
      imgSrc: '/images/carComponent/navigation.svg',
      name: '네비게이션',
      inch: '12.3 inch',
    },
    {
      option: 'cluster',
      imgSrc: '/images/carComponent/cluster.svg',
      name: '클러스터',
      inch: '4.2 inch',
    },
  ],
  'Le Blanc': [
    {
      option: 'wheel',
      imgSrc: '/images/carComponent/wheel.svg',
      name: '알로이 휠',
      inch: '20 inch',
    },
    {
      option: 'sit',
      imgSrc: '/images/carComponent/sit.svg',
      name: '퀄팅 천연가죽 시트',
    },
    {
      option: 'navigation',
      imgSrc: '/images/carComponent/navigation.svg',
      name: '네비게이션',
      inch: '12.3 inch',
    },
    {
      option: 'cluster',
      imgSrc: '/images/carComponent/cluster.svg',
      name: '클러스터',
      inch: '12.3 inch',
    },
  ],
  Prestige: [
    {
      option: 'wheel',
      imgSrc: '/images/carComponent/wheel.svg',
      name: '알로이 휠',
      inch: '20 inch',
    },
    {
      option: 'sit',
      imgSrc: '/images/carComponent/sit.svg',
      name: '퀄팅 나파가죽 시트',
    },
    {
      option: 'navigation',
      imgSrc: '/images/carComponent/navigation.svg',
      name: '네비게이션',
      inch: '12.3 inch',
    },
    {
      option: 'cluster',
      imgSrc: '/images/carComponent/cluster.svg',
      name: '클러스터',
      inch: '12.3 inch',
    },
  ],
  Calligraphy: [
    {
      option: 'wheel',
      imgSrc: '/images/carComponent/wheel.svg',
      name: '캘리그라피 전용 휠',
      inch: '20 inch',
    },
    {
      option: 'sit',
      imgSrc: '/images/carComponent/sit.svg',
      name: '퀄팅 나파가죽 시트 (캘리그라피 전용)',
    },
    {
      option: 'navigation',
      imgSrc: '/images/carComponent/navigation.svg',
      name: '네비게이션',
      inch: '12.3 inch',
    },
    {
      option: 'cluster',
      imgSrc: '/images/carComponent/cluster.svg',
      name: '클러스터',
      inch: '12.3 inch',
    },
  ],
};

export { commonOption, data };
