DROP DATABASE ca_art;
CREATE DATABASE ca_art;

USE ca_art;

DROP TABLE IF EXISTS trim;

create table trim
(
    trim_id     bigint auto_increment primary key,
    description varchar(255) not null,
    image       varchar(255) not null,
    name        varchar(30)  not null,
    price       int          not null
);

DROP TABLE IF EXISTS car_engine;
create table car_engine
(
    car_engine_id bigint auto_increment primary key,
    name          varchar(30)  not null,
    description   varchar(255) not null,
    max_power     varchar(30)  not null,
    max_torque    varchar(30)  not null,
    image         varchar(255) not null,
    price         int          not null
);

DROP TABLE IF EXISTS body_type;

create table body_type
(
    body_type_id bigint auto_increment primary key,
    name         varchar(30)  not null,
    description  varchar(255) not null,
    image        varchar(255) not null
);

DROP TABLE IF EXISTS wheel_drive;

create table wheel_drive
(
    wd_id       bigint auto_increment primary key,
    name        varchar(30)  not null,
    description varchar(255) not null,
    price       int          not null,
    image       varchar(255) not null
);

DROP TABLE IF EXISTS base_option_info;

create table base_option_info
(
    base_option_info_id bigint auto_increment primary key,
    name                varchar(50)  not null,
    description         varchar(255) not null,
    image               varchar(255) not null,
    is_basic            bit          not null
);

DROP TABLE IF EXISTS additional_option_info;

create table additional_option_info
(
    additional_option_info_id bigint auto_increment primary key,
    base_option_info_id       bigint       not null,
    badge                     varchar(20)  not null,
    summary                   varchar(255) null,
    price                     int          not null,
    is_set_option             bit          not null,
    mobile_x                  double       not null,
    mobile_y                  double       not null,
    web_x                     double       not null,
    web_y                     double       not null,
    foreign key (base_option_info_id) references base_option_info (base_option_info_id)
);

DROP TABLE IF EXISTS sub_option_info;

create table sub_option_info
(
    sub_option_info_id        bigint auto_increment primary key,
    base_option_info_id       bigint not null,
    additional_option_info_id bigint not null,
    foreign key (base_option_info_id) references base_option_info (base_option_info_id),
    foreign key (additional_option_info_id) references additional_option_info (additional_option_info_id)
);

DROP TABLE IF EXISTS model;

create table model
(
    model_id      bigint auto_increment primary key,
    trim_id       bigint not null,
    car_engine_id bigint not null,
    body_type_id  bigint not null,
    wd_id         bigint not null,
    foreign key (trim_id) references trim (trim_id),
    foreign key (body_type_id) references body_type (body_type_id),
    foreign key (car_engine_id) references car_engine (car_engine_id),
    foreign key (wd_id) references wheel_drive (wd_id)
);

DROP TABLE IF EXISTS rel_model_base_option_info;

create table rel_model_base_option_info
(
    rel_model_base_option_info_id bigint auto_increment primary key,
    model_id                      bigint not null,
    base_option_info_id           bigint not null,
    foreign key (model_id) references model (model_id),
    foreign key (base_option_info_id) references base_option_info (base_option_info_id)
);

DROP TABLE IF EXISTS color;

create table color
(
    color_id    bigint auto_increment primary key,
    name        varchar(30)  not null,
    price       int          not null,
    image       varchar(255) not null,
    is_exterior bit          not null
);

DROP TABLE IF EXISTS color_preview;

create table color_preview
(
    color_preview_id bigint auto_increment primary key,
    color_id         bigint       not null,
    image            varchar(255) not null,
    foreign key (color_id) references color (color_id)
);

DROP TABLE IF EXISTS rel_trim_color;

create table rel_trim_color
(
    rel_trim_color_id bigint auto_increment primary key,
    trim_id           bigint not null,
    color_id          bigint not null,
    foreign key (trim_id) references trim (trim_id),
    foreign key (color_id) references color (color_id)
);

DROP TABLE IF EXISTS tag;

create table tag
(
    tag_id        bigint auto_increment primary key,
    name          varchar(20)  not null,
    icon          varchar(255) not null,
    icon_selected varchar(255) not null,
    image         varchar(255) not null,
    priority      int          not null
);

DROP TABLE IF EXISTS rel_tag_base_option_info;

create table rel_tag_base_option_info
(
    rel_tag_base_option_info_id bigint auto_increment primary key,
    tag_id                      bigint not null,
    base_option_info_id         bigint not null,
    foreign key (tag_id) references tag (tag_id),
    foreign key (base_option_info_id) references base_option_info (base_option_info_id)
);

DROP TABLE IF EXISTS rel_trim_base_option_info;

create table rel_trim_base_option_info
(
    rel_trim_base_option_info_id bigint auto_increment primary key,
    trim_id                      bigint not null,
    base_option_info_id          bigint not null,
    foreign key (trim_id) references trim (trim_id),
    foreign key (base_option_info_id) references base_option_info (base_option_info_id)
);

DROP TABLE IF EXISTS recommendation_result;

create table recommendation_result
(
    recommendation_result_id     bigint auto_increment primary key,
    palisage_image               varchar(255) not null,
    model_id                     bigint       not null,
    exterior_color_id            bigint       not null,
    interior_color_id            bigint       not null,
    recommended_option_id_1      bigint       not null,
    recommendation_explanation_1 varchar(100) not null,
    recommended_option_id_2      bigint       not null,
    recommendation_explanation_2 varchar(100) not null,
    foreign key (model_id) references model (model_id),
    foreign key (exterior_color_id) references color (color_id),
    foreign key (recommended_option_id_1) references additional_option_info (additional_option_info_id),
    foreign key (interior_color_id) references color (color_id),
    foreign key (recommended_option_id_2) references additional_option_info (additional_option_info_id)
);

DROP TABLE IF EXISTS persona;

create table persona
(
    persona_id               bigint auto_increment primary key,
    profile_image            varchar(255) not null,
    profile_name             varchar(10)  not null,
    profile_bio              varchar(20)  not null,
    profile_age              int          not null,
    profile_message          varchar(255) not null,
    cover_letter             varchar(100) not null,
    cover_image              varchar(255) not null,
    interview_question_1     varchar(255) not null,
    interview_answer_1       varchar(255) not null,
    interview_question_2     varchar(255) not null,
    interview_answer_2       varchar(255) not null,
    recommendation_message   varchar(50)  not null,
    recommendation_result_id bigint       not null,
    tag_id_1                 bigint       not null,
    tag_id_2                 bigint       not null,
    foreign key (recommendation_result_id) references recommendation_result (recommendation_result_id),
    foreign key (tag_id_1) references tag (tag_id),
    foreign key (tag_id_2) references tag (tag_id)
);
