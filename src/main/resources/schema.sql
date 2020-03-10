CREATE TABLE if not exists topic(
    id serial not null
        constraint topic_pk
            primary key,
    title varchar(255) not null,
    description varchar(255),
    complete boolean not null,
    creationdate   timestamp,
    completiondate timestamp
);

alter table topic
    owner to postgres;