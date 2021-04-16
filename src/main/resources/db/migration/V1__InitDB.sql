create table telegram_user
(
    id       int auto_increment,
    name     varchar(255) not null,
    surname  varchar(255) not null,
    username varchar(255) not null,
    bot      boolean      not null,
    constraint telegram_user_pk
        primary key (id)
);

create table team_member
(
    id        int auto_increment
        primary key,
    name      varchar(255)  not null,
    surname   varchar(255)  not null,
    position  varchar(255)  not null,
    auth_code varchar(255)  not null,
    role      enum ('ADMIN', 'MEMBER') default 'MEMBER' not null
);

create table good_job
(
    id       int auto_increment,
    count    int default 10 not null,
    comment  varchar(255)   not null,
    value_id int            not null,
    constraint good_job_pk
        primary key (id)
);

create table `values`
(
    id   int auto_increment,
    name varchar(255) not null,
    constraint values_pk
        primary key (id)
);

create table team_member_good_job
(
    team_member_id int not null,
    good_job_id    int not null,
    constraint team_member_good_job_good_job_id_fk
        foreign key (good_job_id) references good_job (id)
            on update cascade on delete cascade,
    constraint team_member_good_job_team_member_id_fk
        foreign key (team_member_id) references team_member (id)
            on update cascade on delete cascade
);

alter table telegram_user
    add constraint telegram_user_team_member_id_fk
        foreign key (id) references team_member (id)
            on update cascade on delete cascade;

alter table team_member
    add constraint team_member_telegram_user_id_fk
        foreign key (id) references telegram_user (id)
            on update cascade on delete cascade;

alter table good_job
    add constraint good_job_values_id_fk
        foreign key (value_id) references `values` (id)
            on update cascade on delete cascade;