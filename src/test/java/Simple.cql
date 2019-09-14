CREATE  KEYSPACE IF NOT EXISTS ks7 WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor' : 1 } AND DURABLE_WRITES = true;

CREATE TABLE ks7.testdb ( id int , name text , city text, Primary Key (id));

INSERT INTO ks7.testdb (id , name , city) values (1, 'A','AGRA') USING TTL 5000;

INSERT INTO ks7.testdb (id , name , city) values (2, 'B','BANGALORE') USING TTL 5000;