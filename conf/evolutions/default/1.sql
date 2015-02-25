# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table foo (
  id                        bigint not null,
  f2                        varchar(255),
  constraint pk_foo primary key (id))
;

create table task (
  id                        bigint not null,
  name                      varchar(255),
  street                    varchar(255),
  done                      boolean,
  due_date                  timestamp,
  constraint pk_task primary key (id))
;

create sequence foo_seq;

create sequence task_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists foo;

drop table if exists task;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists foo_seq;

drop sequence if exists task_seq;

