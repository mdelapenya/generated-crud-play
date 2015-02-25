# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table foo (
  id                        bigint not null,
  f2                        varchar(255),
  constraint pk_foo primary key (id))
;

create sequence foo_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists foo;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists foo_seq;

