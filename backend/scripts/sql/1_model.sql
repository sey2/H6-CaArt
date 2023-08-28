-- 르블랑 구성 정보 데이터

-- 트림
INSERT INTO ca_art.trim (trim_id, description, image, name, price) VALUES (1, '필수적인 옵션만 모은', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-1.png', 'Le Blanc', 41980000);
INSERT INTO ca_art.trim (trim_id, description, image, name, price) VALUES (2, '합리적인 당신을 위한', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-2.png', 'Exclusive', 38960000);
INSERT INTO ca_art.trim (trim_id, description, image, name, price) VALUES (3, '가치있는 드라이빙 경험을 주는', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-3.png', 'Prestige', 46240000);
INSERT INTO ca_art.trim (trim_id, description, image, name, price) VALUES (4, '남들과 차별화된 경험', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/trim/1-4.png', 'Calligraphy', 51060000);

-- 엔진
INSERT INTO ca_art.car_engine (car_engine_id, name, summary, description, max_power, max_torque, image, price) VALUES (1, '디젤 2.2', '강한 성능과 높은 연비 효율', '높은 토크로 파워풀한 드라이빙이 가능하며, 차급대비 연비 효율이 우수합니다.', '202/3,800PS/rpm', '45.0/1,750~2,750kgf-m/rpm', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/engine/5.jpg', 1480000);
INSERT INTO ca_art.car_engine (car_engine_id, name, summary, description, max_power, max_torque, image, price) VALUES (2, '가솔린 3.8', '부드럽고 안정적인 주행', '고마력의 우수한 가속 성능을 확보하여, 넉넉하고 안정감 있는 주행이 가능합니다. 엔진의 진동이 적어 편안하고 조용한 드라이빙 감성을 제공합니다.', '295/6,000PS/rpm', '36.2/5,200kgf-m/rpm', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/engine/6.jpg', 0);

-- 바디 타입
INSERT INTO ca_art.body_type (body_type_id, name, summary, description, image) VALUES (1, '7인승', '넓은 좌석으로 편안함을 더하는 7인승 차량', '기존 8인승 시트(1열 2명, 2열 3명, 3열 3명)에서 2열 가운데 시트를 없애 2열 탑승객의 편의는 물론, 3열 탑승객의 승하차가 편리합니다.', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/bodytype/7.jpg');
INSERT INTO ca_art.body_type (body_type_id, name, summary, description, image) VALUES (2, '8인승', '다수의 좌석으로 많은 인원을 수용하는 실용적인 8인승 차량', '1열 2명, 2열 3명, 3열 3명이 탑승할 수 있는 구조로, 많은 인원이 탑승할 수 있도록 배려하였습니다.', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/bodytype/8.jpg');

-- 구동 방식
INSERT INTO ca_art.wheel_drive (wd_id, name, summary, description, price, image) VALUES (1, '2WD', '높은 연료 효율로 경제적인 주행', '엔진에서 전달되는 동력이 전/후륜 바퀴 중 한쪽으로만 전달되어 차량을 움직이는 방식입니다. 차체가 가벼워 연료 효율이 높습니다.', 0, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/wd/9.jpg');
INSERT INTO ca_art.wheel_drive (wd_id, name, summary, description, price, image) VALUES (2, '4WD', '다양한 상황에 대응하는 안정적인 주행', '전자식 상시 4륜 구동 시스템입니다. 도로의 상황이나 주행 환경에 맞춰 전후륜 구동력을 자동배분하여 주행 안전성을 높여줍니다.', 2370000, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/wd/10.jpg');

-- 모델
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (1, 1, 1, 1, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (2, 1, 1, 1, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (3, 1, 1, 2, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (4, 1, 1, 2, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (5, 1, 2, 1, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (6, 1, 2, 1, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (7, 1, 2, 2, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (8, 1, 2, 2, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (9, 2, 1, 1, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (10, 2, 1, 1, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (11, 2, 1, 2, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (12, 2, 1, 2, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (13, 2, 2, 1, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (14, 2, 2, 1, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (15, 2, 2, 2, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (16, 2, 2, 2, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (17, 3, 1, 1, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (18, 3, 1, 1, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (19, 3, 1, 2, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (20, 3, 1, 2, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (21, 3, 2, 1, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (22, 3, 2, 1, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (23, 3, 2, 2, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (24, 3, 2, 2, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (25, 4, 1, 1, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (26, 4, 1, 1, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (27, 4, 1, 2, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (28, 4, 1, 2, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (29, 4, 2, 1, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (30, 4, 2, 1, 2);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (31, 4, 2, 2, 1);
INSERT INTO ca_art.model (model_id, trim_id, car_engine_id, body_type_id, wd_id) VALUES (32, 4, 2, 2, 2);
