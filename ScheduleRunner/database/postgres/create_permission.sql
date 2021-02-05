grant select, insert, update, delete on schedule_ownership to schedrunner_user;

grant select, insert, update, delete on process_type to schedrunner_user;

grant select, insert, update, delete on process to schedrunner_user;

grant select, insert, update, delete on process_parameter to schedrunner_user;

grant select, insert, update, delete on day_of_week to schedrunner_user;

grant select, insert, update, delete on schedule to schedrunner_user;

grant select, insert, update, delete on activity to schedrunner_user;

grant select, insert, update, delete on configured_parameter to schedrunner_user;

grant select, insert, update, delete on activity_day to schedrunner_user;

grant select, insert, update, delete on activity_dependency to schedrunner_user;



grant usage, select on process_seq to schedrunner_user;

grant usage, select on process_parameter_seq to schedrunner_user;

grant usage, select on schedule_seq to schedrunner_user;

grant usage, select on activity_seq to schedrunner_user;

grant usage, select on configured_parameter_seq to schedrunner_user;
