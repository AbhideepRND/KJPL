CREATE SCHEMA PAYROLL;
create table PAYROLL.DEPT (DEPT_ID INT, DEPT_CODE VARCHAR(10), DESCRIPTION VARCHAR(20), UNIT VARCHAR(5), CATEGORY VARCHAR(5));
create table PAYROLL.RATE (rate_id int, curr_date date, permanent double, special_badly double, badly double, learner double, semi_skilled double, new_entrance double,
       outsider double, other_mill double, voucher double, status varchar(6), created_by varchar(20), created_date timestamp, updated_by varchar(20), update_date timestamp );
drop table PAYROLL.RATE;
drop table PAYROLL.DEPT;
 select * from PAYROLL.RATE