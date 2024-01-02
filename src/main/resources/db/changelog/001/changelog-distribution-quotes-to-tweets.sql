--liquibase formatted sql

--changeset SergeyBug:fill-twitter-tweets-table
--comment create fill table twitter.tweets
ANALYZE public.famous_quotes;

INSERT INTO twitter.tweets
    (message, user_profile_id, created_timestamp, modified_timestamp)
WITH cte_row_number_user_profiles AS (
    SELECT  row_number() over () AS row_number,
            count(1) OVER ()     AS max_row_number,
            up.id
    FROM twitter.user_profiles up
    ),

    cte_row_number_famous_quotes AS (
    SELECT  row_number() over () AS row_number,
            fq.*
    FROM public.famous_quotes fq
    )
select fq.quote,
       up.id,
       now() - (fq.row_number || 'min')::interval,
       now() - (fq.row_number || 'min')::interval

from cte_row_number_user_profiles up
         JOIN cte_row_number_famous_quotes fq
              ON mod(up.row_number, up.max_row_number) = mod(fq.row_number, up.max_row_number);

ANALYZE twitter.tweets;
--rollback truncate table tweeter.tweets;
--rollback drop table public.famous_quotes;
