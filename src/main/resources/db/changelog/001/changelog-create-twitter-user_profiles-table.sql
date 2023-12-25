--liquibase formatted sql

--changeset SergeyBug:create-twitter-user_profiles-table
--comment create new table twitter.user_profiles
create table twitter.user_profiles
(
    id         integer primary key,
    nickname   varchar(32)  not null,
    image_link varchar(128) not null
);
--rollback drop table twitter.user_profiles;

--changeset SergeyBug:add-twitter-user_profiles-table-constrains
--comment add constrains to twitter.user_profiles table
alter table twitter.user_profiles
    add constraint user_profiles__user_accounts__fk
        foreign key (id) references identity.user_accounts (id);

alter table twitter.user_profiles
    add constraint user_profiles__nickname__unique
        unique (nickname);
--rollback alter table twitter.user_profiles drop constraint user_profiles__user_accounts__fk;
--rollback alter table twitter.user_profiles drop constraint user_profiles__nickname__unique;

