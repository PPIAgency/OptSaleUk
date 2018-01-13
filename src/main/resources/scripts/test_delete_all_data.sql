# Script for delete all data of db_example

delete from db_example.feedback;
delete from db_example.delivery;
delete from db_example.comment;
delete from db_example.proposal;
delete from db_example.user;
delete from db_example.city;
delete from db_example.region;
delete from db_example.country;

commit;