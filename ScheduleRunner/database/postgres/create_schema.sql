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



create table process_parameter (
id bigint not null,
name varchar(60) not null,
description varchar(200) null,
default_value varchar(4000) null,
process_id bigint not null,
required boolean not null default false,
editable boolean not null default true,
multiple boolean not null default false
);

alter table process_parameter add constraint process_parameter_pk primary key (id);

alter table process_parameter add constraint process_parameter_fk_process foreign key (process_id) references process (id);




create table day_of_week (
id smallint not null,
description varchar(20) not null
);

alter table day_of_week add constraint day_of_week_pk primary key (id);

alter table day_of_week add constraint day_of_week_uk_desc unique (description);



create table schedule (
id bigint not null,
schedule_ownership_id smallint not null,
owner_id bigint null,
role_id bigint null,
name varchar(60) not null,
description varchar(200) not null
);

alter table schedule add constraint schedule_pk primary key (id);

alter table schedule add constraint schedule_uk_name unique (name);

alter table schedule add constraint schedule_fk_ownership foreign key (schedule_ownership_id) references schedule_ownership (id);





create table activity (
id bigint not null,
process_id bigint not null,
schedule_id bigint not null,
name varchar(60) not null,
description varchar(200) null,
start_time varchar(8) not null,
end_time varchar(8) null,
repeat_interval bigint null
);

alter table activity add constraint activity_pk primary key (id);

alter table activity add constraint activity_uk_name unique (schedule_id, name);

alter table activity add constraint activity_fk_schedule foreign key (schedule_id) references schedule (id);

alter table activity add constraint activity_fk_process foreign key (process_id) references process (id);



create table configured_parameter (
id bigint not null, 
process_parameter_id bigint not null, 
activity_id bigint not null,
parameter_value varchar(4000) not null
);

alter table configured_parameter add constraint configured_parameter_pk primary key (id);

alter table configured_parameter add constraint configured_parameter_uk_logic unique (process_parameter_id, activity_id, parameter_value);

alter table configured_parameter add constraint configured_parameter_fk_param foreign key (process_parameter_id) references process_parameter (id);

alter table configured_parameter add constraint configured_parameter_fk_activity foreign key (activity_id) references activity (id);





create sequence process_seq;

create sequence process_parameter_seq;

create sequence schedule_seq;

create sequence activity_seq;

create sequence configured_parameter_seq;