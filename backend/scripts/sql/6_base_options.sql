-- 르블랑 기본 옵션 데이터

-- 기본 옵션
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (31, '강력한 토크와 탁월한 효율로 여유있는 파워와 높은 연비를 제공하는 디젤엔진입니다.
최고출력 : 202마력
최대토크 : 45.0kgf·m', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/engine/5.jpg', true,
        '디젤 2.2 엔진');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (32, '고효율의 3.8 가솔린 엔진으로 다이내믹한 주행 성능은 물론, 정속성까지 선사합니다.
최고출력 : 295마력
최대토크 : 36.2kgf·m', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/engine/6.jpg', true,
        '가솔린 3.8 엔진');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (33, '전달 효율 증대로 전 엔진 동급 최고의 연비를 구현함은 물론, 최적의 변속 성능으로 드라이빙 감성까지 향상시켜줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/19.jpg', true, '8단 자동변속기');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (34, '신호 대기 상황이거나 정차 중일 때 차의 엔진을 일시 정지하여 연비를 향상시키고, 배출가스 발생을 억제하는 시스템입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/20.jpg', true, 'ISG 시스템');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (35,
        'COMFORT, ECO, SPORT, SMART 4가지 드라이브 모드를 지원하여 운전자의 니즈에 따른 다양한 주행 모드를 선택할 수 있습니다. 각 주행모드의 상태는 클러스터와 AVN을 통해 확인 가능합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/21.jpg', true, '통합주행모드');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (36, '조향 시 운전자의 힘을 유압대신 모터가 바퀴로 전달하는 기술로 모터가 차량 하체에 장착되어 타이어를 제어합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/22.jpg', true,
        '랙구동형 전동식 파워스티어링(R-MDPS)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (37, '전자식 변속버튼', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/23.jpg', true,
        '전자식 변속버튼');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (38, '마주오는 차량 또는 앞 차량의 램프 및 주변 밝기 상태를 감지하여 전조등을 자동으로 상향 또는 하향으로 전환합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/24.jpg', true, '하이빔 보조');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (39, '전방 차량과의 충돌/차량의 차선 이탈/후측방 충돌 위험 시, 운전자 주의 경고 시 스티어링에 진동을 주어 경고합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/25.jpg', true,
        '진동 경고 스티어링 휠');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (40, '전방의 차량을 감지하여 스스로 가속과 감속을 하며 차량의 속도를 일정하게 유지 시켜주고, 차량 정체로 앞차 정차 시 정지하고 전방 차량 출발 시 다시 거리를 유지하며 주행하는 기능입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/26.jpg', true,
        '스마트 크루즈 컨트롤(스탑앤고 기능 포함)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (41,
        '스마트 크루즈 작동 중 고속도로/도시고속도로/자동차전용 도로 내 안전구간 진입 시, 감속 제어를 통해 주행 편의 제공합니다. 또한 곡선 구간 진입 시, 감속 제어를 통해 주행 편의를 제공합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/27.jpg', true,
        '내비게이션 기반 스마트 크루즈 컨트롤 (안전구간, 곡선로)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (42, '고속도로 본선 주행 시 전방 차량과의 거리, 차선 정보, 내비게이션 정보를 이용하여 차량 속도를 제어는 물론 차로 유지를 보조해줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/28.jpg', true, '고속도로 주행보조');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (43, '전방 카메라를 이용하여 차선을 인식하고 차로의 중앙으로 주행할 수 있도록 조향을 보조합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/29.jpg', true, '차로 유지 보조');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (44, '전방 카메라와 전방 레이더의 신호를 종합적으로 판단하여 전방 차량, 보행자, 자전거 탑승자와 충돌 위험 상황이 감지될 경우 운전자에게 이를 경고하고, 필요 시 브레이크 작동을 도와줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/30.jpg', true,
        '전방 충돌방지 보조(차량/보행자/자전거 탑승자/교차로 대향차)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (45, '전방 카메라로 주행 차로를 실시간으로 감지하여 차량이 차로를 이탈하려 할 경우, 클러스터에 경고하고 스티어링 휠을 제어하여 안전하게 주행 차로를 유지하도록 보조합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/31.jpg', true, '차로 이찰방지 보조');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (46, '차량이 스스로 운전자의 주행 패턴과 차로 내 차량 위치 등을 종합적으로 분석하여 주의 운전이 필요하다고 판단되면, 팝업메시지와 경고음을 통해 운전자 휴식을 유도합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/32.jpg', true, '운전자 주의 경고');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (47, '차로 변경을 위하여 방향지시등 스위치 조작 시, 후측방 충돌 위험이 감지되면 경고를 해줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/33.jpg', true,
        '후측방 충돌 경고(주행)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (48, '평행 주차상태에서 전진 출차 중, 후측방 차량과 충돌 위험이 감지되면 자동으로 제동을 도와줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/34.jpg', true,
        '후측방 충돌방지 보조(전진 출차)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (49, '정차 후 탑승자가 차에서 내리려고 도어를 열 때, 후측방에서 접근하는 차량이 감지되면 경고를 해줍니다. 또한 전자식 차일드 락이 작동하여 문이 열리지 않도록 도와줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/35.jpg', true, '안전 하차 보조');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (50, '후진 출차 시 후방 교차 차량을 감지하여 운전자에게 경고하고 필요 시에는 브레이크 제어를 통해 후방 교차 충돌방지를 보조합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/36.jpg', true,
        '후방 교차 충돌방지 보조');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (51, '1열 어드밴스드/센터 사이드, 운전석 무릎,1/2열 사이드, 전복 대응 커튼 에어백으로 탑승자를 보호합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/37.jpg', true,
        '10에어백 시스템(1열 어드밴스드/센터사이드, 1/2열 사이드, 운전석 무릎, 전복대응커튼');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (52, '영·유아용 시트를 간편하고 안전하게 장착할 수 있는 ISO 규격의 카시트를 고정할 수 있는 장치를 2열에 2개, 3열에 1개 총 3개를 적용하여 사고 시 카시트에 탑승한 유아를 보호합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/38.jpg', true,
        '유아용 시트 고정장치(2열 2개/3열 1개)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (53, '커브구간에서 선회 가속시 구동력과 제동력을 제어해 언더스티어 현상을 억제하고 차량의 주행 민첩성과 주행 안정성을 향상시키는 토크벡터링 (Torque Vectoring) 시스템입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/39.jpg', true, '구동선회 제어기능');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (54, '차량의 정면 또는 측면 충돌사고로 에어백 전개 시 차량에 적절한 자동 긴급 제동을 통해 2차 사고 및 다중 충돌을 경감시켜줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/40.jpg', true,
        '다중 충돌방지 자동 제동 시스템');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (55, '-', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/41.jpg', true,
        '다크 크롬 라디에이터 그릴');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (56,
        '주간주행등(DRL)은 낮시간에도 자동으로 켜져 다른 사람들이 차량을 쉽게 볼 수 있도록 합니다. 특히 해질 무렵이나 해뜨기 직전에 차량의 접근을 쉽게 인식하도록 합니다. 차량 시동 후에 자동으로 켜집니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/42.jpg', true, 'LED 주간주행등');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (57, '안개, 야간과 같이 시야확보가 어려울 경우, 차의 존재 및 차폭을 인지할 수 있도록 하는 역할을 합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/43.jpg', true, 'LED 포지셔닝 램프');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (58, '차량의 진행 방향을 주변 주행 차량 및 보행자에게 알리는 등화장치입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/44.jpg', true, 'LED 방향지시등');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (59, '야간 운전시 전방에 빛을 비춰 운전자의 시야를 확보할 수 있도록 돕습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/45.jpg', true,
        'Full LED 헤드램프(프로젝션 타입)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (60, '주행 중 후측방을 확인할 수 있도록 차량 좌우측에 부착된 거울입니다.
방향지시등 : 차량의 진행방향을 주변 주행 차량 및 보행자에게 알리는 램프를 아웃사이드 미러에 적용했습니다.
열선 기능 : 아웃사이드 미러에 낀 습기를 제거하기 위한 기능입니다.
전동 접이 기능 : 버튼 조작으로 아웃사이드 미러를 접고 펼 수 있는 기능입니다. 리모컨 키로 도어를 여닫을 때 자동으로 접고 펼 수도 있습니다.
전동 조절 기능 : 버튼 조작으로 아웃사이드 미러의 화각을 조',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/46.jpg', true,
        '아웃사이드 미러(열선, 전동접이, 전동조절, LED 방향 지시등)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (61, '두 겹의 유리로 이루어진 전방 유리의 사이에 소음을 흡수하는 전용 차음필름을 삽입하여 엔진 투과음 및 외부 소음이 실내에 유입되는 것을 감소시켜 탑승자의 운전 쾌적성을 향상시킵니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/47.jpg', true,
        '이중접합 차음유리(윈드실드, 1/2열 도어)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (62, '스마트 키를 소지하고 차량에 접근하거나 리모컨 키를 이용하여 차량 도어를 오픈 할 때 아웃사이드 도어핸들 안쪽에 불빛을 비춰 야간에 차량의 문을 쉽게 열 수 있도록 배려한 편의 기능입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/48.jpg', true,
        '도어 포켓 라이팅(1열)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (63, '차량 후면부 하단에 부착되는 배기장치로 차량 후면부와 조화감 있는 이미지로 디자인의 완성도를 높여줍니다. 머플러 부착방식에 따라 명칭이 상이합니다.
싱글 타입 : 1개의 머플러로 구성
트윈 타입 : 한쪽에 2개의 머플러로 구성
듀얼 타입 : 차량 후면부 좌우에 2개의 머플러가 장착됨',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/49.jpg', true, '싱글 트윈팁 머플러');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (64, '헤드램프와 통일감 있는 콤비램프 디자인을 적용하였으며 보석 느낌의 인너렌즈를 적용하여 고급스러운 감성품질을 제공합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/50.jpg', true, 'LED 리어콤비램프');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (65, '기본으로 제공하는 제동등과 별도로 장착되어 브레이크 작동 시 후방 주행 차량에게 제동을 알려 후방 추돌 상황을 방지하는 등화장치입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/51.jpg', true, 'LED 보조제동등');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (66, '후진 시 점선 패턴의 가이드 조명 구현을 통해 주변 차량 및 보행자에게 후진 의도를 효과적으로 전달하여 사고를 예방합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/52.jpg', true, '후진가이드램프');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (67, '주행 시 차량 후면에 발생하는 공기의 와류 현상을 없애주는 장치로 차량의 공력 성능을 향상시킵니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/53.jpg', true, '리어 스포일러');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (68, '차량 도어의 몰딩 부분 소재를 크롬으로 적용하여 고급스러운 감성을 전달합니다.차량마다 적용부위의 차이가 있습니다',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/54.jpg', true, '크롬 DLO 몰딩');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (69, '차량 위에 짐을 실을 수 있도록 돕는 장치로 화물적재를 위한 보조기구 장착 시 차량 상태 및 안전을 고려하여 장착해야합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/55.jpg', true, '루프랙');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (70, '-', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/56.jpg', true,
        '메탈페인트 스키드 플레이트');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (71, '-', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/57.jpg', true,
        '20인치 알로이 휠&타이어');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (72, '빗물 맺힘이나 서리, 성에 등을 막아주는 발수 적용 유리를 앞도어에 장착하여 운전자의 시계를 확보합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/58.jpg', true, '발수 도어(1열)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (73, '-', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/59.jpg', true,
        '베젤리스 인사이드 미러');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (74, '차량 실내 전체를 비춰주는 룸램프를 LED로 적용하여 어두운 곳에서의 시인성을 향상시킵니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/60.jpg', true,
        'LED 실내등(맵램프, 룸램프, 선바이저램프, 러기지램프)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (75,
        '시동 스위치가 「ON」 또는 엔진이 작동 중일때 스티어링 휠 히터 버튼을 누르면 표시등이 켜지면서 스티어링 휠이 따뜻해집니다. 스티어링 휠 히터 버튼을 누른 후 작동 조건에서 약 30분이 지나면 자동으로 작동을 멈춥니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/61.jpg', true,
        '가죽 스티어링 휠(열선 포함)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (76, '컬러 LCD 클러스터(1,920x720)는 시인성이 높고 정보 파악이 용이하며, 주행모드별 차별화된 그래픽으로 즐거운 드라이빙 환경을 제공합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/62.jpg', true,
        '클러스터(12.3인치 컬러 LCD)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (77, '-', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/63.jpg', true,
        '인조가죽 감싸기');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (78, '-', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/64.jpg', true,
        '도어 암레스트 리얼 스티치');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (79,
        '시동이 걸린 상태에서 해당 좌석 히터 스위치를 누르면 강약조절 표시등이 켜져 사용 중임을 나타내고 해당 좌석이 따뜻해지는 열선기능과 시동이 걸린 상태에서 해당 좌석의 통풍 스위치를 누르면 표시등이 켜지면서 해당 좌석에 바람이 나오는 통풍기능이 적용되었습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/65.jpg', true, '1열 열선/통풍 시트');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (80, '3단계로 온도 조절이 가능한 열선시트를 적용하여 쾌적한 승차감을 제공합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/66.jpg', true, '2열 열선시트');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (81, '평면형태의 2열 공간을 제공하는 풀플랫 폴딩 2열시트로 차원이 다른 공간/거주성을 확보해 넉넉한 러기지 공간은 물론 프라이빗 스페이스로 활용할 수 있습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/67.jpg', true,
        '2열 폴드 & 다이브/슬라이딩 & 리클라이닝 시트');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (82,
        '3열 시트 및 러기지 사이드에 적용된 전자식 스위치로 시트를 폴딩 및 리클라이닝하여 화물 적재 시 편리합니다. 또한 좌석 등받이 부분을 후방으로 눕힐 수 있는 리클라이닝 기능을 적용하여 성인 탑승 및 장거리 이동 시 거주 편의성을 높였습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/68.jpg', true,
        '3열 6:4분할 폴딩/리클라이닝 시트');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (83, '팰리세이드는 옵션에 따라 인조가죽, 가죽, 나파가죽, 퀼팅 나파가죽 시트를 선택할 수 있습니다.
- 인조가죽 시트 : 합성섬유를 이용하여 가죽의 질감을 구현한 인조가죽으로 제작된 시트입니다.
- 가죽 시트 : 실제 가죽으로 제작되어 편안하며 고급스러운 착좌감을 제공합니다.
- 나파가죽 시트 : 가죽 표면을 코팅처리하여 가죽의 내구성은 높이면서도 부드러운 감촉을 선사하는 시트입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/69.jpg', true,
        '퀼팅 천연가죽 시트(블랙/쿨그레이)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (84, '운전석의 시트 포지션을 조정하여 운전자의 체형에 맞는 편안한 자세를 유지할 수 있도록 돕는 기능입니다.
- 10way 전동시트 : 운전석 좌하단에 위치한 조작부로 8방향으로 조절 기능(시트백 기울기, 시트 앞/뒤 이동, 쿠션부 앞/뒤 높이 조절)과 허리 지지대 조절 기능을 전동 방식으로 조절합니다.
- 4way 럼버서포트 : 허리 지지대 조절 기능을 4 방향으로 조절합니다.
- 쿠션 익스텐션 : 운전자의 허벅지 길이에 맞게 시트 하단부를 조절하는 쿠션 ',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/70.jpg', true,
        '운전석 전동시트(10way, 4way럼버서포트, 쿠션 익스텐션, 자세 메모리 시스템)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (85,
        '동승석의 시트 포지션을 조정하여 동승자의 체형에 맞는 편안한 자세를 유지할 수 있도록 돕는 기능입니다. 8방향(시트백 기울기, 시트 앞/뒤 이동, 쿠션부 앞/뒤 높이 조절)으로 조절이 기능하고 운전자 및 뒷좌석(2열) 승객이 동승석 시트 위치를 조절할 수 있는 워크인 디바이스를 적용하여 실내 공간 활용 편의성을 높였습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/71.jpg', true,
        '동승석 전동시트(8way, 워크인 디바이스)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (86, '일반 키와는 달리 휴대만으로 도어(트렁크 포함)를 잠그거나 열고, 엔진 시동을 걸 수 있는 장치입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/72.jpg', true, '버튼시동 & 스마트키');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (87, '버튼 조작만으로 파킹 브레이크 작동 또는 해제가 가능하며, 정차 시 자동으로 제동상태를 유지하는 오토 홀드 기능 적용으로 편의성을 높였습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/73.jpg', true,
        '전동식 파킹 브레이크(오토홀드 포함)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (88, '운전 중 간단한 조작만으로도 스포티한 수동 변속모드를 지원합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/74.jpg', true, '패들 쉬프트');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (89, '원하는 온도를 설정하면 자동으로 설정된 온도로 풍량을 조절하여 쾌적한 실내를 완성합니다.
공기 청정 모드 : 일정 시간 동안 외부 공기를 차단하고 내부 순환모드를 가동하여 실내에서 순환하는 공기를 반복적으로 필터링하여 공기질을 개선시키는 기능입니다.
3존 독립제어 : 운전석이나 동승석 뿐만 아니라 후석에서도 개별 제어가 가능한 에어컨입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/75.jpg', true,
        '3존 독립제어 풀오토 에어컨 (공기청정모드 포함)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (90, '실내 공기질을 실시간으로 확인할 수 있어 공기 청정 모드 사용이나 환기를 유도합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/76.jpg', true, '공기질 센서');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (91, '미세먼지의 실내 유입의 방지하기 위한 에어필터입니다. 글로브 박스 뒤쪽에 장착되어 바깥에서 공기 조화 장치를 통하여 차 안으로 들어오는 먼지나 꽃가루 등을 걸러줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/77.jpg', true, '마이크로 에어 필터');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (92, '차량 전방 유리에 자외선을 차단 기능을 적용하여 탑승객은 물론 차량 실내 내장재를 보호합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/78.jpg', true,
        '자외선 차단 유리(윈드실드)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (93, '전면유리의 김서림을 감지해 스스로 전면 유리 및 앞좌석 유리의 김서림을 없애 운전시야를 확보합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/79.jpg', true, '오토 디포그');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (94, '스티어링 휠 우측 레버의 와이퍼 조절장치 스위치를 AUTO로 위치하였을 때 주행 중 우천상황을 자동으로 감지하여 와이퍼가 작동 및 조작단계를 자동으로 조절하는 기능입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/80.jpg', true, '레인센서');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (95, '시동 후 공조 설정 온도와 실제 온도의 차이가 많이 나는 경우, 공조기 외 스티어링 휠 열선, 시트 열선/통풍을 자동으로 감지하여 통합 제어하는 기능입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/81.jpg', true,
        '운전석 공조 연동 자동 제어');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (96, '차량용 충전기로서 USB 포트를 통해 각종 스마트폰 및 태블릿 기기 충전이 가능합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/82.jpg', true,
        'USB 충전기(1열 1개, 2열 2개, 3열 2개)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (97, '시동이 걸린 상태에서 실내에서 전기 제품(예 : 진공청소기, 소형냉장고, 게임기 등)을 사용할 수 있도록 돕습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/83.jpg', true,
        '파워 아웃렛(1열 1개, 2열 1개, 3열 1개)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (98, '유리창이 원터치 자동 닫힘 기능이 작동하여 닫히는 중에 일정한 힘에 의해 막히면 자동으로 닫힘을 멈추고, 일정한 높이만큼 다시 열리는 기능입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/84.jpg', true,
        '세이프티 파워 윈도우(1/2열)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (99,
        '후진 주차 시 디스플레이 오디오 또는 내비게이션 화면에 후방 상황을 표시하여 편의성을 높였습니다.조향연동 기능 : 스티어링 휠 조정 시 그에 따른 예상 주행 궤적도 같이 표시하여 편의성을 높였습니다.DRM(Driving Rear Monitor) 기능 : 주행 중 후방 영상을 실시간으로 확인하여 룸미러 시야 확보가 불가능 할 때, 후방 상황을 인지할 수 있습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/85.jpg', true, '후방 모니터');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (100, '벤트 테두리에 홀(HOLE)을 적용하여 바람이 직접 분사가 아닌 간접(확산) 분사될 수 있도록 구현하여 조금 더 쾌적한 환경을 제공합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/86.jpg', true,
        '확산형 루프 에어 밴트');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (101,
        '대시보드 중앙에 위치한 조도센서를 이용하여 외부 밝기에 따라 헤드램프를 자동으로 조절하는 장치입니다. 스티어링 휠 좌측에 위치한 조명 스위치를 「AUTO」 위치에 두면 작동합니다.- 대시보드 : 운전석과 조수석 정면에 있으며, 계기판과 센터페시아를 포함합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/87.jpg', true, '오토 라이트 컨트롤');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (102, '차량 탑승 전 스마트키를 이용하여 원격으로 시동을 걸 수 있으며, 냉/난방 장치는 시동을 끄기 전 설정된 상태로 작동이 가능합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/88.jpg', true, '스마트키 원격시동');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (103, '범퍼에 내장된 초음파 센서로 장애물과의 거리를 감지하여 거리별로 차별화된 경고음을 울려 주차 편의성 및 안전성을 제공합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/89.jpg', true,
        '전방/후방 주차 거리 경고');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (104, '조절 스위치를 이용하여 스티어링 휠의 높낮이와 전/후 위치를 조절할 수 있습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/90.jpg', true,
        '전동식 틸트 & 텔레스코픽 스티어링 휠');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (105,
        '중앙 콘솔에 휴대폰 무선 충전을 위한 시스템이 적용되어 있습니다. 또한 엔진에 시동을 끈 후 충전 패드에 휴대폰이 놓여있는 상태에서 운전석 또는 동승석 도어를 열면 게시판에 \'휴대폰이 무선 충전기에 있습니다\'라는 경고문 및 경고음(음성안내 적용 차량)으로 알려줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/91.jpg', true, '스마트폰 무선충전');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (106, '스위치 및 스마트키 버튼으로 테일게이트 개방이 가능하며, 설정을 통해 개폐 속도 조절 및 열림 높이 조절이 가능합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/92.jpg', true,
        '스마트 파워 테일게이트');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (107, '차량 앞/뒤/좌/우 360도 모든 상황을 AVN화면을 통해 볼 수 있는 장치로 고화질 카메라 및 디지털 영상 전송 방식을 적용하여 영상 경계선 없이 선명하고 깨끗한 화질을 제공합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/93.jpg', true, '서라운드 뷰 모니터');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (108, '방향지시등 스위치 조작과 연동해 차로 변경 시 기존 아웃사이드 미러 대비 더 넓은 후측방 영역을 클러스터에 표시하여 안전한 주행을 도와줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/94.jpg', true, '후측방 모니터');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (109, '와이드하고 품격 있는 실내공간을 연출하고 고해상도 대화면으로 뛰어난 시인성과 최첨단 인포테인먼트 기능을 제공합니다.
주요기능 : 대화면 HD급 고해상도(1,920x720) 모니터, 내비게이션 자동 무선 업데이트, 개인화 프로필, 서버형 음성인식 시스템, 블루링크',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/95.jpg', true,
        '12.3인치 내비게이션(블루링크, 폰 프로젝션, 현대 카페이)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (110, '유료 도로로 진출입시 통행료가 자동결제 되는 장치입니다. 하이패스 시스템은 시동이 걸려있는 상태에서만 작동합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/96.jpg', true, '하이패스');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (111, '운전자의 음성을 운전석 마이크를 통하여 뒷좌석 동승자와의 대화 편의성을 높였습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/97.jpg', true, '후석 대화모드');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (112, '뒷좌석 동승자가 취침 시, 뒷좌석 스피커가 모두 음소거가 되고 운전석 스피커로만 음원이 출력되어, 뒷좌석을 조용한 공간으로 활용할 수 있습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/98.jpg', true, '후석 취침모드');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (113, '차량 내부 공간의 음향 특성에 맞게 세심하게 조정된 8개의 스피커를 통하여 기본에 충실한 사운드를 감상할 수 있습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/99.jpg', true,
        '일반 오디오 시스템(8스피커, 블루투스 핸즈프리)');
INSERT INTO ca_art.base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (114,
        'MP3, USB 저장 장치 또는 iPod 등 외부 음향 기기(또는 음악/동영상 등 미디어 파일 저장 장치)를 차량에 연결하여 차량 스피커를 통하여 음악을 듣거나 차량 오디오 또는 인포테인먼트 시스템으로 재생할 수 있는 편의 장치 입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/default/100.jpg', true,
        '멀티미디어용 USB단자(1열 1개)');


-- 기본 옵션 : 태그 정보
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (20, 31, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (21, 32, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (22, 33, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (23, 34, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (24, 35, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (25, 36, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (26, 37, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (27, 38, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (28, 39, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (29, 40, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (30, 41, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (31, 41, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (32, 42, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (33, 43, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (34, 43, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (35, 44, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (36, 44, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (37, 45, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (38, 45, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (39, 46, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (40, 47, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (41, 48, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (42, 49, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (43, 49, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (44, 50, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (45, 50, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (46, 51, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (47, 52, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (48, 53, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (49, 54, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (50, 55, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (51, 56, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (52, 57, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (53, 58, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (54, 59, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (55, 60, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (56, 60, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (57, 61, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (58, 62, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (59, 63, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (60, 64, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (61, 65, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (62, 65, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (63, 66, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (64, 66, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (65, 67, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (66, 67, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (67, 68, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (68, 69, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (69, 69, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (70, 70, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (71, 71, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (72, 71, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (73, 72, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (74, 73, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (75, 74, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (76, 75, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (77, 76, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (78, 77, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (79, 78, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (80, 79, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (81, 80, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (82, 81, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (83, 82, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (84, 83, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (85, 84, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (86, 85, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (87, 86, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (88, 87, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (89, 88, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (90, 88, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (91, 89, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (92, 90, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (93, 91, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (94, 92, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (95, 93, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (96, 94, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (97, 94, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (98, 95, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (99, 96, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (100, 97, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (101, 98, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (102, 99, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (103, 100, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (104, 101, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (105, 102, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (106, 102, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (107, 103, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (108, 104, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (109, 105, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (110, 106, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (111, 107, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (112, 108, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (113, 109, 1);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (114, 110, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (115, 111, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (116, 112, 1);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (117, 113, 1);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (118, 114, 1);

-- 트림 메인 옵션
INSERT INTO ca_art.rel_trim_base_option_info (rel_trim_base_option_info_id, trim_id, base_option_info_id)
VALUES (1, 1, 71);
INSERT INTO ca_art.rel_trim_base_option_info (rel_trim_base_option_info_id, trim_id, base_option_info_id)
VALUES (2, 1, 76);
INSERT INTO ca_art.rel_trim_base_option_info (rel_trim_base_option_info_id, trim_id, base_option_info_id)
VALUES (3, 1, 107);
