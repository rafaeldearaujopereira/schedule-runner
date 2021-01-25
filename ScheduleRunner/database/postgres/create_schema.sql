create table schedule_ownership (
id smallint not null,
description varchar(20) not null
);

alter table schedule_ownership add constraint schedule_ownership_pk primary key (id);

alter table schedule_ownership add constraint schedule_ownership_uk_desc unique (description);


create table process_type (
id smallint not null,
description varchar(20) not null
);

alter table process_type add constraint process_type_pk primary key (id);

alter table process_type add constraint process_type_uk_desc unique (description);


create table process (
id bigint not null, 
name varchar(60) not null, 
description varchar(200) not null,
process_type_id smallint not null, 
parent_id bigint null
);

alter table process add constraint process_pk primary key (id);

alter table process add constraint process_uk_name unique (name);

alter table process add constraint process_fk_type foreign key (process_type_id) references process_type (id);

alter table process add constraint process_fk_parent foreign key (parent_id) references process (id);










create sequence process_seq;

