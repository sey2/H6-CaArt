-- 르블랑 하위 옵션 데이터

-- 하위 옵션 : 기본 정보
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (16, '후석 승객 알림', '초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/101-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (17, '메탈 리어범퍼스텝', '러기지 룸 앞쪽 하단부를 메탈로 만들어 물건을 싣고 내릴 때나 사람이 올라갈 때 차체를 보호해줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/101-2.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (18, '메탈 도어스커프', '자동차를 타고 내리는 도어의 문틈 하부를 보호하는 도어스커프 부분을 메탈로 만들어 차체를 보호하고 메탈 디자인으로 고급스러운 감성을 전달합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/101-3.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (19, '3열 파워폴딩시트', '러기지 사이드에 있는 버튼으로 3열 시트를 접었다 펼 수 있으며, 2열 시트도 조작할 수 있어 화물 적재시나 3열 이용시 사용자의 편의성을 높였습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/101-4.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (20, '3열 열선시트', '시동이 걸린 상태에서 해당 좌석 히터 스위치를 누르면 강약조절 표시등이 켜져 사용 중임을 나타내고 해당 좌석이 따뜻해집니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/101-5.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (21, '헤드업 디스플레이', '주요 주행 정보를 전면 윈드실드에 표시하며, 밝기가 최적화되어 주간에도 시인성이 뛰어납니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/101-6.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (22, '후방 주차 충돌방지 보조',
        '주차 또는 출차 시 저속 후진 중 후방카메라와 센서로 정후면에 위치한 보행자 및 장애물과의 충돌이 예상되면 운전자에게 경고하고 차량의 제동을 제어하여 충돌방지를 보조합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/102-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (23, '원격 스마트 주차 보조',
        '주차 보조 기능을 활성화 한 후 주차공간을 발견하게 되면 차량 내 안내에 따라 하차한 다음, 스마트키의 작동 버튼을 누르고만 있으면 차가 스스로 주차합니다. 직각주차 및 평행주차 모두 가능하며, 운전자 탑승 시에도 차량 내부의 작동 버튼을 누르고 있으면 자동 주차 보조를 지원합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/102-2.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (24, '전방 충돌방지 보조(교차 차량/추월시 대향차/측방 접근차)',
        '선행 차량이 갑자기 속도를 줄이거나, 앞에 정지 차량 혹은 보행자가 나타나는 등 전방 충돌 위험이 감지되면 경고를 해줍니다. 경고 후에도 충돌 위험이 높아지면 자동으로 제동을 도와줍니다. 주행 중 전방의 자전거 탑승자 및 교차로에서 좌회전 시 맞은편에서 다가오는 차량과 충돌 위험이 있다면 자동으로 제동을 도와줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/106-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (25, '내비게이션 기반 스마트 크루즈 컨트롤(진출입로)',
        '스마트 크루즈 작동 중 고속도로/도시고속도로/자동차전용 도로 내 고속도로 진출입로 주행 시 차로를 판단하여 사전감속 또는 최적 속도에 맞추어 감속을 진행합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/106-2.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (26, '고속도로 주행 보조 2',
        '고속도로 / 자동차 전용도로에서 앞차와의 거리와 설정 속도를 유지하며 주행할 뿐 아니라, 곡선로에서도 차로의 중앙을 유지하며 주행할 수 있도록 도와줍니다. 일정 속도 이상으로 주행 시, 스티어링 휠을 잡은 상태에서 방향지시등 스위치를 변경하고자 하는 차로 방향으로 움직이면 자동으로 차로를 변경해 줍니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/106-3.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (27, '러기지 프로텍션 매트', '※ 프로텍션 매트 패키지는 사용자의 신발 재질에 따라 일부 미끄러짐이 발생할 수 있습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/112-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (28, '플로어매트1, 2열', '※ 프로텍션 매트 패키지는 사용자의 신발 재질에 따라 일부 미끄러짐이 발생할 수 있습니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/112-2.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (29, '알콘(alcon) 단조 브레이크', '-',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/115-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (30, '20인치 블랙톤 전면 가공 휠', '-',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/115-2.jpg');

-- 하위 옵션 : 상위 옵션 - 하위 옵션 관계 정보
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (1, 16, 1);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (2, 17, 1);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (3, 18, 1);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (4, 19, 1);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (5, 20, 1);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (6, 21, 1);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (7, 22, 2);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (8, 23, 2);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (9, 24, 6);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (10, 25, 6);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (11, 26, 6);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (12, 27, 12);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (13, 28, 12);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (14, 29, 15);
INSERT INTO ca_art.sub_option_info (sub_option_info_id, base_option_info_id, additional_option_info_id)
VALUES (15, 30, 15);
