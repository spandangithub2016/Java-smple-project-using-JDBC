use BPIGTN_AGN_APP_DEV

create table student
(
	student_id varchar(20) primary key,
	student_name varchar(50)
)

create table student_marks
(
	student_id varchar(20),
	student_name varchar(100),
	Math int,
	English int,
	total_marks int,
	rank int
)
drop table student_marks
insert into student_marks(student_id, student_name, Math, English, total_marks) values('S103', 'SPANDAN', 98, 89, 98+89)

student
student_marks

delete from student where student_id not in ('s103')

delete from student_marks