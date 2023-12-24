--liquibase formatted sql

--changeset SergeyBug:create-twitter-schema
--comment create new schema
create schema twitter;
--rollback drop schema twitter;
