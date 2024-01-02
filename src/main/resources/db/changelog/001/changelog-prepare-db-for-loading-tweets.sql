--liquibase formatted sql

--changeset SergeyBug:create-public-famous_quotes-table
--comment create new table public.famous_quotes
CREATE TABLE public.famous_quotes
(
    quote   varchar(255) NOT NULL
);
--rollback drop table public.famous_quotes;