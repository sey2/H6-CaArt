DROP DATABASE ca_art;
CREATE DATABASE ca_art;

USE ca_art;

DROP TABLE IF EXISTS trim;

CREATE TABLE trim
(
    trim_id     BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30)  NOT NULL,
    description VARCHAR(255) NOT NULL,
    price       INT          NOT NULL DEFAULT 0,
    image       VARCHAR(255) NOT NULL,
    PRIMARY KEY (trim_id)
);

DROP TABLE IF EXISTS car_engine;

CREATE TABLE car_engine
(
    car_engine_id BIGINT       NOT NULL AUTO_INCREMENT,
    name          VARCHAR(30)  NOT NULL,
    description   VARCHAR(255) NOT NULL,
    max_power     VARCHAR(30)  NOT NULL,
    max_torque    VARCHAR(30)  NOT NULL,
    price         INT          NOT NULL DEFAULT 0,
    image         VARCHAR(255) NOT NULL,
    PRIMARY KEY (car_engine_id)
);

DROP TABLE IF EXISTS body_type;

CREATE TABLE body_type
(
    body_type_id BIGINT       NOT NULL AUTO_INCREMENT,
    name         VARCHAR(30)  NOT NULL,
    description  VARCHAR(255) NOT NULL,
    image        VARCHAR(255) NOT NULL,
    PRIMARY KEY (body_type_id)
);

DROP TABLE IF EXISTS wheel_drive;

CREATE TABLE wheel_drive
(
    wd_id       BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30)  NOT NULL,
    description VARCHAR(255) NOT NULL,
    price       INT          NOT NULL DEFAULT 0,
    image       VARCHAR(255) NOT NULL,
    PRIMARY KEY (wd_id)
);

DROP TABLE IF EXISTS base_option_info;

CREATE TABLE base_option_info
(
    base_option_info_id BIGINT       NOT NULL AUTO_INCREMENT,
    name                VARCHAR(50)  NOT NULL,
    description         VARCHAR(255) NOT NULL,
    image               VARCHAR(255) NOT NULL,
    PRIMARY KEY (base_option_info_id)
);

DROP TABLE IF EXISTS additional_option_info;

CREATE TABLE additional_option_info
(
    additional_option_info_id BIGINT        NOT NULL AUTO_INCREMENT,
    base_option_info_id       BIGINT        NOT NULL,
    price                     INT           NOT NULL,
    badge                     VARCHAR(20)   NULL COMMENT 'H Genuine Accessories / N Performance',
    summary                   VARCHAR(255)  NOT NULL,
    is_set_option             BOOLEAN       NOT NULL DEFAULT false,
    mobile_x                  DECIMAL(5, 2) NULL,
    mobile_y                  DECIMAL(5, 2) NULL,
    web_x                     DECIMAL(5, 2) NULL,
    web_y                     DECIMAL(5, 2) NULL,
    PRIMARY KEY (additional_option_info_id),
    FOREIGN KEY (base_option_info_id) REFERENCES base_option_info (base_option_info_id)
);

DROP TABLE IF EXISTS sub_option_info;

CREATE TABLE sub_option_info
(
    sub_option_info_id        BIGINT NOT NULL AUTO_INCREMENT,
    base_option_info_id       BIGINT NOT NULL,
    additional_option_info_id BIGINT NOT NULL,
    PRIMARY KEY (sub_option_info_id),
    FOREIGN KEY (base_option_info_id) REFERENCES base_option_info (base_option_info_id),
    FOREIGN KEY (additional_option_info_id) REFERENCES additional_option_info (additional_option_info_id)
);

DROP TABLE IF EXISTS model;

CREATE TABLE model
(
    model_id      BIGINT NOT NULL AUTO_INCREMENT,
    trim_id       BIGINT NOT NULL,
    car_engine_id BIGINT NOT NULL,
    body_type_id  BIGINT NOT NULL,
    wd_id         BIGINT NOT NULL,
    PRIMARY KEY (model_id),
    FOREIGN KEY (trim_id) REFERENCES trim (trim_id),
    FOREIGN KEY (car_engine_id) REFERENCES car_engine (car_engine_id),
    FOREIGN KEY (body_type_id) REFERENCES body_type (body_type_id),
    FOREIGN KEY (wd_id) REFERENCES wheel_drive (wd_id)
);

DROP TABLE IF EXISTS rel_model_base_option_info;

CREATE TABLE rel_model_base_option_info
(
    rel_model_base_option_info_id BIGINT NOT NULL AUTO_INCREMENT,
    model_id                      BIGINT NOT NULL,
    base_option_info_id           BIGINT NOT NULL,
    PRIMARY KEY (rel_model_base_option_info_id),
    FOREIGN KEY (model_id) REFERENCES model (model_id),
    FOREIGN KEY (base_option_info_id) REFERENCES base_option_info (base_option_info_id)
);

DROP TABLE IF EXISTS color;

CREATE TABLE color
(
    color_id    BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30)  NOT NULL,
    price       INT          NOT NULL,
    image       VARCHAR(255) NOT NULL,
    is_exterior BOOLEAN      NOT NULL DEFAULT false COMMENT '외장 색상(true) / 내장 색상(false)',
    PRIMARY KEY (color_id)
);

DROP TABLE IF EXISTS rel_trim_color;

DROP TABLE IF EXISTS color_preview;

CREATE TABLE color_preview
(
    color_preview_id BIGINT       NOT NULL AUTO_INCREMENT,
    color_id         BIGINT       NOT NULL,
    image            VARCHAR(255) NOT NULL,
    PRIMARY KEY (color_preview_id),
    FOREIGN KEY (color_id) REFERENCES color (color_id)
);

DROP TABLE IF EXISTS rel_trim_color;

CREATE TABLE rel_trim_color
(
    rel_trim_color_id BIGINT NOT NULL AUTO_INCREMENT,
    trim_id           BIGINT NOT NULL,
    color_id          BIGINT NOT NULL,
    PRIMARY KEY (rel_trim_color_id),
    FOREIGN KEY (trim_id) REFERENCES trim (trim_id),
    FOREIGN KEY (color_id) REFERENCES color (color_id)
);

DROP TABLE IF EXISTS tag;

CREATE TABLE tag
(
    tag_id BIGINT      NOT NULL AUTO_INCREMENT,
    name   VARCHAR(20) NOT NULL,
    PRIMARY KEY (tag_id)
);

DROP TABLE IF EXISTS rel_tag_base_option_info;

CREATE TABLE rel_tag_base_option_info
(
    rel_tag_base_option_info_id BIGINT NOT NULL AUTO_INCREMENT,
    base_option_info_id         BIGINT NOT NULL,
    tag_id                      BIGINT NOT NULL,
    PRIMARY KEY (rel_tag_base_option_info_id),
    FOREIGN KEY (base_option_info_id) REFERENCES base_option_info (base_option_info_id),
    FOREIGN KEY (tag_id) REFERENCES tag (tag_id)
);

DROP TABLE IF EXISTS rel_trim_base_option_info;

CREATE TABLE rel_trim_base_option_info
(
    rel_trim_base_option_info_id BIGINT NOT NULL AUTO_INCREMENT,
    trim_id                      BIGINT NOT NULL,
    base_option_info_id          BIGINT NOT NULL,
    PRIMARY KEY (rel_trim_base_option_info_id),
    FOREIGN KEY (trim_id) REFERENCES trim (trim_id),
    FOREIGN KEY (base_option_info_id) REFERENCES base_option_info (base_option_info_id)
);
