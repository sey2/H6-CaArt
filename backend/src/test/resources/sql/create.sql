create table if not exists trim
(
    trim_id     bigint auto_increment primary key,
    description varchar(255) not null,
    image       varchar(255) not null,
    name        varchar(30)  not null,
    price       int          not null
);

create table if not exists car_engine
(
    car_engine_id bigint auto_increment primary key,
    name          varchar(30)  not null,
    summary       varchar(255) not null,
    description   varchar(255) not null,
    max_power     varchar(30)  not null,
    max_torque    varchar(30)  not null,
    image         varchar(255) not null,
    price         int          not null
);

create table if not exists body_type
(
    body_type_id bigint auto_increment primary key,
    name         varchar(30)  not null,
    summary      varchar(255) not null,
    description  varchar(255) not null,
    image        varchar(255) not null
);

create table if not exists wheel_drive
(
    wd_id       bigint auto_increment primary key,
    name        varchar(30)  not null,
    summary     varchar(255) not null,
    description varchar(255) not null,
    price       int          not null,
    image       varchar(255) not null
);

create table if not exists model
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

create table if not exists color
(
    color_id    bigint auto_increment primary key,
    name        varchar(30)  not null,
    price       int          not null,
    is_exterior bit          not null,
    image       varchar(255) not null
);

create table if not exists color_preview
(
    color_preview_id bigint auto_increment primary key,
    color_id         bigint       not null,
    image            varchar(255) not null,
    foreign key (color_id) references color (color_id)
);

create table if not exists rel_trim_color
(
    rel_trim_color_id            bigint auto_increment primary key,
    trim_id                      bigint not null,
    color_id                     bigint not null,
    adoption_rate_twenty         double null default 0.0,
    adoption_rate_thirty         double null default 0.0,
    adoption_rate_forty          double null default 0.0,
    adoption_rate_fifty_or_above double null default 0.0,
    adoption_rate_all            double null default 0.0,
    foreign key (trim_id) references trim (trim_id),
    foreign key (color_id) references color (color_id)
);

create table if not exists base_option_info
(
    base_option_info_id bigint auto_increment primary key,
    name                varchar(50)  not null,
    description         varchar(255) null,
    image               varchar(255) not null,
    is_basic            bit          not null
);

create table if not exists additional_option_info
(
    additional_option_info_id bigint auto_increment primary key,
    base_option_info_id       bigint       not null,
    badge                     varchar(30)  not null,
    summary                   varchar(255) null,
    price                     int          not null,
    is_set_option             bit          not null,
    foreign key (base_option_info_id) references base_option_info (base_option_info_id)
);

create table if not exists position
(
    position_id               bigint not null primary key,
    additional_option_info_id bigint not null,
    is_mobile                 bit    not null,
    x                         double not null,
    y                         double not null,
    foreign key (additional_option_info_id) references additional_option_info (additional_option_info_id)
);

create table if not exists sub_option_info
(
    sub_option_info_id        bigint auto_increment primary key,
    base_option_info_id       bigint not null,
    additional_option_info_id bigint not null,
    foreign key (base_option_info_id) references base_option_info (base_option_info_id),
    foreign key (additional_option_info_id) references additional_option_info (additional_option_info_id)
);

create table if not exists rel_trim_base_option_info
(
    rel_trim_base_option_info_id bigint auto_increment primary key,
    trim_id                      bigint not null,
    base_option_info_id          bigint not null,
    foreign key (trim_id) references trim (trim_id),
    foreign key (base_option_info_id) references base_option_info (base_option_info_id)
);

create table if not exists rel_model_base_option_info
(
    rel_model_base_option_info_id bigint auto_increment primary key,
    model_id                      bigint not null,
    base_option_info_id           bigint not null,
    adoption_rate_all             double not null default 100.0,
    foreign key (model_id) references model (model_id),
    foreign key (base_option_info_id) references base_option_info (base_option_info_id)
);

create table if not exists tag
(
    tag_id        bigint auto_increment primary key,
    name          varchar(20)  not null,
    priority      int          not null,
    icon          varchar(255) not null,
    icon_selected varchar(255) not null,
    image         varchar(255) not null
);

create table if not exists rel_tag_base_option_info
(
    rel_tag_base_option_info_id bigint auto_increment primary key,
    tag_id                      bigint not null,
    base_option_info_id         bigint not null,
    foreign key (tag_id) references tag (tag_id),
    foreign key (base_option_info_id) references base_option_info (base_option_info_id)
);

create table if not exists recommendation_result
(
    recommendation_result_id     bigint auto_increment primary key,
    palisage_image               varchar(255) not null,
    model_id                     bigint       not null,
    recommended_option_id_1      bigint       not null,
    recommendation_explanation_1 varchar(100) not null,
    recommended_option_id_2      bigint       not null,
    recommendation_explanation_2 varchar(100) not null,
    foreign key (model_id) references model (model_id),
    foreign key (recommended_option_id_1) references additional_option_info (additional_option_info_id),
    foreign key (recommended_option_id_2) references additional_option_info (additional_option_info_id)
);

create table if not exists persona
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

create table if not exists purchase
(
    purchase_id       bigint not null primary key,
    age               int    not null,
    model_id          bigint not null,
    exterior_color_id bigint not null,
    interior_color_id bigint not null,
    foreign key (model_id) references model (model_id),
    foreign key (exterior_color_id) references color (color_id),
    foreign key (interior_color_id) references color (color_id)
);

create table if not exists rel_purchase_additional_option
(
    rel_purchase_additional_option_id bigint not null primary key,
    purchase_id                       bigint not null,
    additional_option_info_id         bigint not null,
    foreign key (purchase_id) references purchase (purchase_id),
    foreign key (additional_option_info_id) references additional_option_info (additional_option_info_id)
);

create table if not exists car_master_survey
(
    car_master_survey_id bigint auto_increment primary key,
    experience_code      varchar(255) not null,
    family_code          varchar(255) not null,
    purpose_code         varchar(255) not null,
    total_sum            int          not null,
    value_code           varchar(255) not null,
    model_id             bigint       not null,
    foreign key (model_id) references model (model_id)
);

create table if not exists recommended_option
(
    recommended_option_id     bigint auto_increment primary key,
    reason                    varchar(100) not null,
    additional_option_info_id bigint       not null,
    car_master_survey_id      bigint       not null,
    foreign key (additional_option_info_id) references additional_option_info (additional_option_info_id),
    foreign key (car_master_survey_id) references car_master_survey (car_master_survey_id)
);
