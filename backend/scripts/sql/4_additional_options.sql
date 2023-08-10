-- 르블랑 추가 선택 가능 옵션 데이터

-- 추가 옵션 : 기본 정보
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (1, '컴포트 II', 'null',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/101-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (2, '주차보조 시스템 II', 'null',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/102-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (3, '2열 통풍 시트', '시동이 걸린 상태에서 해당 좌석의 통풍 스위치를 누르면 표시등이 켜지면서 해당 좌석에 바람이 나오는 편의장치입니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/103.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (4, '듀얼 와이드 선루프', '후석에 고정 글라스를 적용한 듀얼 파노라믹 선루프로 2/3열의 탑승객에게도 넓은 개방감을 선사합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/104.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (5, '빌트인 캠(보조배터리 포함)', '빌트인 적용된 영상기록장치로, 내비게이션 화면을 통해 영상 확인 및 앱 연동을 통해 영상 확인 및 SNS 공유가 가능합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/105.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (6, '현대스마트센스 I', 'null',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/106-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (7, '듀얼 머플러 패키지', '-',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/107.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (8, '빌트인 공기청정기',
        '※ 빌트인 공기청정기 전용 에어필터의 권장 사용기간은 6개월이며(하루 2시간 사용 기준), 에어필터는 현대 Shop(Shop.Hyundai.com) 현대브랜드관을 통해 개별 품목 단위로 구매 가능합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/108.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (9, '사이드스텝', '-', 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/109.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (10, '적외선 무릎워머', '※ 적외선 무릎 워머 상품은 사용자의 자세와 체형에 따라 효과가 상이할 수 있습니다.
※ 적외선 무릎 워머 상품의 발열부는 고온으로 신체 접촉 시 화상 위험이 있으므로 닿지 않도록 주의바랍니다.
※ 적외선 무릎 워머 상품은 실내온도에 따라 발열 온도가 조절되며, 30분 연속 작동 됩니다.
※ 적외선 무릎 워머는 전동식 틸트 & 텔레스코픽 스티어링 휠 적용 시 선택이 가능합니다.',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/110.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (11, '차량 보호 필름', '-',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/111.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (12, '프로텍션 매트 패키지 I', 'null',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/112-1.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (13, '20인치 다크 스퍼터링 휠', '-',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/113.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (14, '20인치 블랙톤 전면 가공 휠', '-',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/114.jpg');
INSERT INTO ca_art.base_option_info (base_option_info_id, name, description, image)
VALUES (15, '알콘(alcon) 단조 브레이크 & 20인치 블랙톤 전면 가공 휠 패키지', 'null',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/option/additional/115-1.jpg');

-- 추가 옵션 : 추가 정보
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (1, 1, 1090000, 'null', '편의성을 위해 구성된 세트 옵션', 1, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (2, 2, 690000, 'null', '주차 시 보행자 및 장애물과의 충돌을 예방하고 원격 주차가 가능', 1, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (3, 3, 400000, 'null', '2열 시트에 바람이 나와 여름에 시원한 통풍이 가능', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (4, 4, 890000, 'null', '넓은 개방감을 선사하는 선루프', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (5, 5, 690000, 'null', '차량 내부에 카메라를 설치하여 녹화가 가능한 블랙박스', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (6, 6, 790000, 'null', '전방 충돌 감지 / 크루즈 컨트롤 / 차로 유지 등의 ADAS 세트 옵션', 1, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (7, 7, 840000, 'H Genuine Accessorie', '외관 스타일링을 위한 두개의 머플러', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (8, 8, 400000, 'H Genuine Accessorie', '차량 내부 맑은 공기를 위한 공기 청정기', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (9, 9, 350000, 'H Genuine Accessorie', '높은 차고를 내려오거나 올라갈 때 도움을 주는 발판', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (10, 10, 300000, 'H Genuine Accessorie', '추운 겨울철 따뜻하게 무릎을 덥혀주는 워머', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (11, 11, 490000, 'H Genuine Accessorie', '문콕 등으로부터 차량 기스를 방지해주는 필름', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (12, 12, 250000, 'H Genuine Accessorie', '차량 트렁크와 좌석 발판을 외부 충격으로부터 보호해주는 세트 옵션', 1, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (13, 13, 840000, 'N Performance', '20인치의 올블랙으로 도색된 휠', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (14, 14, 840000, 'N Performance', '20인치 블랙계열의 고급스러운 전면 가공된 휠', 0, 0.00, 0.00, 0.00, 0.00);
INSERT INTO ca_art.additional_option_info (additional_option_info_id, base_option_info_id, price, badge, summary,
                                           is_set_option, mobile_x, mobile_y, web_x, web_y)
VALUES (15, 15, 3660000, 'N Performance', 'N 퍼포먼스의 기술력으로 만들어진 브레이크와 블랙톤 휠 세트 옵션', 1, 0.00, 0.00, 0.00, 0.00);

-- 추가 옵션 : 태그 정보
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (1, 1, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (2, 1, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (3, 1, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (4, 2, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (5, 3, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (6, 4, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (7, 4, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (8, 5, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (9, 6, 2);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (10, 6, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (11, 7, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (12, 8, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (13, 9, 7);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (14, 10, 3);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (15, 11, 6);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (16, 12, 5);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (17, 13, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (18, 14, 4);
INSERT INTO ca_art.rel_tag_base_option_info (rel_tag_base_option_info_id, base_option_info_id, tag_id)
VALUES (19, 15, 4);
