# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bar (
  id                        bigint not null,
  campo2                    varchar(255),
  constraint pk_bar primary key (id))
;

create table foo (
  id                        bigint not null,
  f2                        varchar(255),
  constraint pk_foo primary key (id))
;

create sequence bar_seq;

create sequence foo_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists bar;

drop table if exists foo;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists bar_seq;

drop sequence if exists foo_seq;

