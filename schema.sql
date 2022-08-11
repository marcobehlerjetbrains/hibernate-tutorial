create table users (
				   id identity primary key,
				   name varchar(255),
				   birth_date date
);

insert into users (name, birth_date) values ('marco', '1950-01-01');
insert into users (name, birth_date) values ('ocram', '1960-01-01');