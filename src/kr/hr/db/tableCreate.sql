drop sequence num_seq;
create sequence num_seq;

drop table information cascade constraint;
create table information
(name varchar2(20) not null,
mil_id VARCHAR2(10) not null,
pw number(10) not null,
job varchar2(20) not null,
rank varchar2(20) not null,
s_date date not null,
manager_id VARCHAR2(10) not null,
constraint information_mil_id_pk primary key (mil_id)
);

drop table manager cascade constraint;
create table manager
(dept VARCHAR2(10) not null,
position VARCHAR2(10) not null,
manager_id VARCHAR2(10) not null,
manager_name VARCHAR2(20) not null,
manager_pw number(10) not null,
constraint manager_id_pk primary key (manager_id)
);

drop table submit cascade constraint;
create table submit(
sub_date number(5) not null,
END_DATE number(5) NOT NULL,
reason varchar2(100),
vac_type varchar2(50) not null,
sub_number number(10) not null,
mil_id VARCHAR2(10) not null,
constraint submit_sub_number_pk primary key (sub_number)
);

drop table allow cascade constraint;
create table allow(
manager_id VARCHAR2(10) not null,
sub_number number(10) not null,
yn varchar2(5) not null,
note varchar2(100),
constraint allow_sub_number_pk primary key (sub_number)
);

alter table information
add constraint
information_manager_id_fk foreign key (manager_id)
references manager (manager_id);

alter table submit
add constraint
submit_mil_id_fk foreign key (mil_id)
references information (mil_id);

alter table allow
add constraint
allow_manager_id_fk foreign key (manager_id)
references manager (manager_id);

alter table allow
add constraint
allow_sub_number_fk foreign key (sub_number)
references submit (sub_number);


insert into manager
values('SMART', 'KING', '13-345698', 'UNBI', 1234567);

create or replace view submitTable
as select i.mil_id, i.rank, i.name, i.job, s.vac_type, s.sub_date, s.end_date, s.reason, s.sub_number, a.yn
from information i, submit s, allow a
where i.mil_id = s.mil_id and a.sub_number(+) = s.sub_number;

select * from SUBMITTABLE;
select * from result;
select * from allow;
select * from submit;

create or replace view result
as select i.manager_id, i.name, s.sub_date, s.vac_type, s.reason, a.yn, a.note, i.mil_id
from information i, submit s, allow a
where i.mil_id = s.mil_id and s.sub_number(+) = a.sub_number;

select * from INFORMATION;