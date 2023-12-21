create database construction;

use construction;

create table builders (
    -> id bigint auto_increment primary key,
    -> name varchar(45),
    -> speciality varchar(45),
    -> age int
    -> );
 create table teams (
    -> id bigint auto_increment primary key,
    -> name varchar(45)
    -> );

create table buid_team (
    -> team_id bigint not null,
    -> build_id bigint not null,
    ->  primary key (team_id, build_id),
    -> foreign key (team_id) references teams(id),
    -> foreign key (build_id) references builders(id)
    -> );