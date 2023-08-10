-- 르블랑 트림 색상 데이터

-- 색상
INSERT INTO ca_art.color (color_id, name, price, image, is_exterior)
VALUES (1, '어비스 블랙 펄', 0, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/11.png', 1);
INSERT INTO ca_art.color (color_id, name, price, image, is_exterior)
VALUES (2, '쉬머링 실버 메탈릭', 0, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/12.png',
        1);
INSERT INTO ca_art.color (color_id, name, price, image, is_exterior)
VALUES (3, '문라이프 블루 펄', 0, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/13.png',
        1);
INSERT INTO ca_art.color (color_id, name, price, image, is_exterior)
VALUES (4, '가이아 브라운 펄', 0, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/14.png',
        1);
INSERT INTO ca_art.color (color_id, name, price, image, is_exterior)
VALUES (5, '그라파이트 그레이 메탈릭', 0,
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/15.png', 1);
INSERT INTO ca_art.color (color_id, name, price, image, is_exterior)
VALUES (6, '크리미 화이트 펄', 100000,
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/16.png', 1);
INSERT INTO ca_art.color (color_id, name, price, image, is_exterior)
VALUES (7, '퀄팅 천연(블랙)', 0, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/interior/17.png',
        0);
INSERT INTO ca_art.color (color_id, name, price, image, is_exterior)
VALUES (8, '쿨그레이', 0, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/interior/18.png', 0);

-- 트림 가능 색상
INSERT INTO ca_art.rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (1, 1, 1);
INSERT INTO ca_art.rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (2, 1, 2);
INSERT INTO ca_art.rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (3, 1, 3);
INSERT INTO ca_art.rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (4, 1, 4);
INSERT INTO ca_art.rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (5, 1, 5);
INSERT INTO ca_art.rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (6, 1, 6);
INSERT INTO ca_art.rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (7, 1, 7);
INSERT INTO ca_art.rel_trim_color (rel_trim_color_id, trim_id, color_id)
VALUES (8, 1, 8);

-- 색상 프리뷰
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (1, 7, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/inside/17-preview.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (2, 8, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/inside/18-preview.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (3, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_001.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (4, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_002.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (5, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_003.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (6, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_004.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (7, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_005.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (8, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_006.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (9, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_007.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (10, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_008.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (11, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_009.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (12, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_010.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (13, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_011.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (14, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_012.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (15, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_013.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (16, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_014.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (17, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_015.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (18, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_016.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (19, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_017.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (20, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_018.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (21, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_019.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (22, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_020.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (23, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_021.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (24, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_022.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (25, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_023.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (26, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_024.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (27, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_025.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (28, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_026.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (29, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_027.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (30, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_028.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (31, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_029.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (32, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_030.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (33, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_031.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (34, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_032.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (35, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_033.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (36, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_034.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (37, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_035.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (38, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_036.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (39, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_037.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (40, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_038.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (41, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_039.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (42, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_040.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (43, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_041.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (44, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_042.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (45, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_043.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (46, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_044.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (47, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_045.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (48, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_046.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (49, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_047.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (50, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_048.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (51, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_049.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (52, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_050.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (53, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_051.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (54, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_052.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (55, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_053.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (56, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_054.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (57, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_055.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (58, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_056.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (59, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_057.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (60, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_058.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (61, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_059.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (62, 1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/abyss/image_060.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (63, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_001.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (64, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_002.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (65, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_003.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (66, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_004.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (67, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_005.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (68, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_006.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (69, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_007.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (70, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_008.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (71, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_009.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (72, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_010.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (73, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_011.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (74, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_012.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (75, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_013.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (76, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_014.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (77, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_015.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (78, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_016.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (79, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_017.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (80, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_018.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (81, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_019.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (82, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_020.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (83, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_021.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (84, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_022.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (85, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_023.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (86, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_024.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (87, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_025.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (88, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_026.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (89, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_027.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (90, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_028.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (91, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_029.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (92, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_030.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (93, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_031.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (94, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_032.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (95, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_033.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (96, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_034.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (97, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_035.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (98, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_036.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (99, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_037.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (100, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_038.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (101, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_039.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (102, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_040.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (103, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_041.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (104, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_042.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (105, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_043.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (106, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_044.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (107, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_045.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (108, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_046.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (109, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_047.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (110, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_048.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (111, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_049.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (112, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_050.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (113, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_051.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (114, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_052.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (115, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_053.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (116, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_054.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (117, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_055.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (118, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_056.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (119, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_057.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (120, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_058.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (121, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_059.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (122, 3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/blue/image_060.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (123, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_001.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (124, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_002.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (125, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_003.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (126, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_004.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (127, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_005.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (128, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_006.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (129, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_007.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (130, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_008.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (131, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_009.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (132, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_010.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (133, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_011.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (134, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_012.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (135, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_013.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (136, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_014.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (137, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_015.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (138, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_016.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (139, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_017.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (140, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_018.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (141, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_019.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (142, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_020.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (143, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_021.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (144, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_022.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (145, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_023.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (146, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_024.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (147, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_025.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (148, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_026.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (149, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_027.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (150, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_028.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (151, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_029.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (152, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_030.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (153, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_031.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (154, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_032.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (155, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_033.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (156, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_034.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (157, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_035.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (158, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_036.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (159, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_037.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (160, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_038.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (161, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_039.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (162, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_040.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (163, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_041.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (164, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_042.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (165, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_043.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (166, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_044.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (167, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_045.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (168, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_046.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (169, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_047.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (170, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_048.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (171, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_049.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (172, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_050.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (173, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_051.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (174, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_052.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (175, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_053.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (176, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_054.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (177, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_055.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (178, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_056.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (179, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_057.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (180, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_058.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (181, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_059.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (182, 5, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/gray/image_060.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (183, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_001.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (184, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_002.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (185, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_003.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (186, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_004.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (187, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_005.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (188, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_006.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (189, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_007.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (190, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_008.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (191, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_009.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (192, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_010.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (193, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_011.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (194, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_012.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (195, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_013.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (196, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_014.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (197, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_015.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (198, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_016.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (199, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_017.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (200, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_018.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (201, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_019.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (202, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_020.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (203, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_021.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (204, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_022.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (205, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_023.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (206, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_024.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (207, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_025.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (208, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_026.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (209, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_027.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (210, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_028.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (211, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_029.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (212, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_030.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (213, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_031.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (214, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_032.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (215, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_033.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (216, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_034.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (217, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_035.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (218, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_036.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (219, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_037.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (220, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_038.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (221, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_039.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (222, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_040.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (223, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_041.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (224, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_042.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (225, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_043.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (226, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_044.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (227, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_045.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (228, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_046.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (229, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_047.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (230, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_048.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (231, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_049.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (232, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_050.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (233, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_051.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (234, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_052.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (235, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_053.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (236, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_054.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (237, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_055.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (238, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_056.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (239, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_057.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (240, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_058.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (241, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_059.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (242, 2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/silver/image_060.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (243, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_001.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (244, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_002.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (245, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_003.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (246, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_004.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (247, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_005.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (248, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_006.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (249, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_007.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (250, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_008.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (251, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_009.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (252, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_010.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (253, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_011.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (254, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_012.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (255, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_013.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (256, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_014.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (257, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_015.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (258, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_016.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (259, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_017.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (260, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_018.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (261, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_019.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (262, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_020.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (263, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_021.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (264, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_022.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (265, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_023.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (266, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_024.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (267, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_025.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (268, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_026.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (269, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_027.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (270, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_028.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (271, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_029.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (272, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_030.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (273, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_031.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (274, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_032.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (275, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_033.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (276, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_034.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (277, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_035.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (278, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_036.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (279, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_037.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (280, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_038.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (281, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_039.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (282, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_040.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (283, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_041.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (284, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_042.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (285, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_043.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (286, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_044.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (287, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_045.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (288, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_046.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (289, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_047.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (290, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_048.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (291, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_049.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (292, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_050.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (293, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_051.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (294, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_052.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (295, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_053.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (296, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_054.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (297, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_055.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (298, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_056.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (299, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_057.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (300, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_058.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (301, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_059.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (302, 6, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/white/image_060.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (303, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_001.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (304, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_002.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (305, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_003.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (306, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_004.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (307, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_005.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (308, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_006.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (309, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_007.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (310, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_008.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (311, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_009.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (312, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_010.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (313, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_011.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (314, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_012.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (315, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_013.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (316, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_014.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (317, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_015.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (318, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_016.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (319, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_017.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (320, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_018.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (321, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_019.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (322, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_020.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (323, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_021.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (324, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_022.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (325, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_023.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (326, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_024.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (327, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_025.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (328, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_026.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (329, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_027.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (330, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_028.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (331, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_029.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (332, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_030.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (333, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_031.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (334, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_032.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (335, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_033.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (336, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_034.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (337, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_035.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (338, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_036.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (339, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_037.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (340, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_038.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (341, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_039.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (342, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_040.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (343, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_041.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (344, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_042.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (345, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_043.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (346, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_044.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (347, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_045.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (348, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_046.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (349, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_047.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (350, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_048.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (351, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_049.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (352, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_050.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (353, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_051.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (354, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_052.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (355, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_053.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (356, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_054.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (357, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_055.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (358, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_056.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (359, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_057.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (360, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_058.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (361, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_059.png');
INSERT INTO ca_art.color_preview (color_preview_id, color_id, image)
VALUES (362, 4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/preview/outside/brown/image_060.png');
