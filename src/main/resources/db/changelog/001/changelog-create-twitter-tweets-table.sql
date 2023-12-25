--liquibase formatted sql

--changeset SergeyBug:create-twitter-tweets-table
--comment create new table twitter.tweets
create table twitter.tweets
(
    id                serial primary key,
    message           varchar(251) not null,
    user_profile_id   integer      not null,
    created_timestamp timestamp    not null
);
--rollback drop table twitter.tweets;

--changeset SergeyBug:add-twitter-user_profiles-table-constrains
--comment add constrains to twitter.tweets table
alter table twitter.tweets
    add constraint tweets__user_profile__fk
        foreign key (user_profile_id) references twitter.user_profiles (id);

--rollback alter table twitter.tweets drop constraint tweets__user_profile__fk;