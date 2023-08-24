-- 르블랑 구성 정보 데이터

-- 트림
INSERT INTO trim (trim_id, name, description, price, image)
VALUES (1, 'Le Blanc', '필수적인 옵션만 모은', 41980000,
        '르블랑.png'),
       (2, 'Exclusive', '합리적인 당신을 위한', 38960000,
        '익스클루시브.png');

-- 엔진
INSERT INTO car_engine (car_engine_id, name, summary, description, max_power, max_torque, price, image)
VALUES (1, '디젤 2.2', '디젤 요약 설명', '디젤 설명', '202/3,800PS/rpm', '45.0/1,750~2,750kgf-m/rpm',
        1480000, '디젤.jpg'),
       (2, '가솔린 3.8', '가솔린 요약 설명', '가솔린 설명',
        '295/6,000PS/rpm', '36.2/5,200kgf-m/rpm', 0,
        '가솔린.jpg');

-- 바디 타입
INSERT INTO body_type (body_type_id, name, summary, description, image)
VALUES (1, '7인승', '7인승 요약 설명', '7인승 설명', '7인승.jpg'),
       (2, '8인승', '8인승 요약 설명', '8인승 설명', '8인승.jpg');

-- 구동 방식
INSERT INTO wheel_drive (wd_id, name, summary, description, price, image)
VALUES (1, '2WD', '2wd 요약 설명', '2WD 설명', 0, '2wd.jpg'),
       (2, '4WD', '4wd 요약 설명', '4WD 설명', 2370000, '4wd.jpg');

-- 모델
INSERT INTO model (model_id, trim_id, car_engine_id, body_type_id, wd_id)
VALUES (1, 1, 1, 1, 1),
       (2, 2, 2, 2, 2);

-- 태그
INSERT INTO tag (tag_id, icon, icon_selected, image, name, priority)
VALUES (1, 'icon1.svg',
        'icon1_selected.svg',
        'bg1.png', '태그1', 1),
       (2, 'icon2.svg',
        'icon2_selected.svg',
        'bg2.png', '태그2', 0);

-- 색상
INSERT INTO color (color_id, name, price, image, is_exterior)
VALUES (1, '외장 색상1', 0, 'exterior_color.png', 1),
       (2, '외장 색상2', 0, 'interior_color.png', 1),
       (3, '내장 색상1', 0, 'interior_color.png', 0),
       (4, '내장 색상2', 0, 'interior_color.png', 0);

-- 트림 가능 색상
INSERT INTO rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (1, 1, 1),
       (2, 1, 2),
       (3, 2, 1),
       (4, 2, 2);

-- 옵션
INSERT INTO base_option_info (base_option_info_id, description, image, is_basic, name)
VALUES (1, null, '추가옵션(세트).jpg',
        false, '추가 옵션(세트)'),
       (2, '추가 옵션(단품) 상세 설명', '추가옵션(단품).jpg',
        false, '추가 옵션(단품)'),
       (3, '자식 옵션 상세 설명', '자식옵션.jpg', false, '자식 옵션'),
       (4, '기본 옵션 상세 설명', '기본옵션.jpg', true, '기본 옵션');
INSERT INTO additional_option_info (additional_option_info_id, badge, is_set_option, price, summary,
                                    base_option_info_id)
VALUES (1, 'NONE', true, 1090000, '추가 옵션(세트) 요약 설명', 1),
       (2, 'NONE', false, 690000, '추가 옵션(단품) 요약 설명', 2);
INSERT INTO rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (1, 1, 1),
       (2, 1, 2),
       (3, 2, 1),
       (4, 4, 2);

-- 트림 메인 옵션
INSERT INTO rel_trim_base_option_info (rel_trim_base_option_info_id, trim_id, base_option_info_id)
VALUES (1, 1, 4),
       (2, 2, 1);

-- 트림 포함 옵션 (하위 옵션 제외)
INSERT INTO rel_model_base_option_info (rel_model_base_option_info_id, model_id, base_option_info_id)
VALUES (1, 1, 1),
       (2, 1, 2),
       (4, 1, 4),
       (5, 2, 1),
       (7, 1, 4);

-- 추천 결과
INSERT INTO recommendation_result (recommendation_result_id, palisage_image, model_id, exterior_color_id,
                                   interior_color_id, recommended_option_id_1, recommended_option_id_2,
                                   recommendation_explanation_1, recommendation_explanation_2)
VALUES (1, 'palisade.png', 1, 1, 2, 1, 2,
        '좋아요.', '꼭 추가해야하는 옵션이에요.');
-- 페르소나
INSERT INTO persona (persona_id, profile_image, profile_name, profile_bio, profile_age, profile_message,
                     cover_letter, cover_image, interview_question_1, interview_answer_1, interview_question_2,
                     interview_answer_2, recommendation_message, recommendation_result_id, tag_id_1, tag_id_2)
VALUES (1, 'persona.png', '김현대',
        '두 아이의 엄마', 34, '우리 아이들과 함께 타는 차는 항상\\n안전해야 한다고 생각해요', '가족과 함께 타서\\n안전을 중시해요',
        'cover.png', '어떤 용도로 차를 사용하세요?',
        '저는 차를 타고 출퇴근도 하지만 주중에 아이들 픽업하거나 마트 갈 때도 자주 타곤 합니다.', '차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?',
        '저는 차를 살 때 안전을 중요하게 생각해요. 가족들이 같이 타는 차라 항상 사고에 경각심을 갖고 있죠. 펠리세이드는 그 점에서 뒷좌석 에어백도 터지는 모델이라 안심이 되는 편이에요.',
        '가족을 생각하는 당신', 1, 1, 2);

-- 구매 이력
create table purchase
(
    purchase_id       bigint primary key,
    age               int    not null,
    model_id          bigint not null,
    exterior_color_id bigint not null,
    interior_color_id bigint not null,
    foreign key (model_id) references model (model_id),
    foreign key (exterior_color_id) references color (color_id),
    foreign key (interior_color_id) references color (color_id)
);

INSERT INTO purchase (purchase_id, age, model_id, exterior_color_id, interior_color_id)
VALUES (1, 22, 1, 1, 3),
       (2, 28, 1, 1, 4),
       (3, 28, 1, 2, 4);



