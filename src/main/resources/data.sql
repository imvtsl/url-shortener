create table shortener(id number(8) primary key AUTO_INCREMENT, long_link varchar(65535) unique not null, short_link varchar(65535) unique not null);