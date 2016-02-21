--MySQLとは異なりuserが予約後のためダブルクオーテーションが必要。またtinyintではなくsmallintとなる。
drop table "users";
create table "users" (
    username              varchar(32)     not null
    , password      varchar(128)    not null
    , enabled       smallint         not null default 1
    , constraint pk_user primary key (username)
);

drop table authorities;
create table authorities (
    username              varchar(32)         not null
    , authority         varchar(32)         not null
    , constraint pk_authorities primary key (username)
);

insert into "users" values('test', 'ptest', 1);
insert into authorities values('test', 'USER');
commit;