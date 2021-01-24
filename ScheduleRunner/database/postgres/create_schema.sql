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

