create schema mediaplace;

create table mediaplace.last_position (
	last_position_id bigint,
	file_name varchar(32672),
	last_position_time time
);