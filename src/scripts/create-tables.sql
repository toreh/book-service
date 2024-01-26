drop table if exists book;
drop table if exists author;

create table book (
                      bookId bigint AUTO_INCREMENT PRIMARY KEY,
                      title varchar(50) not null,
                      isbn varchar(6) not null,
                      authorId bigint,
                      source varchar(20),
                      update_date datetime(6),
                      version integer
) engine=InnoDB;

create table author (
                        authorId bigint AUTO_INCREMENT PRIMARY KEY,
                        name varchar(50),
                        update_date datetime(6),
                        version integer
) engine=InnoDB;

INSERT INTO book (title, isbn, authorId, source) VALUES ('Meningen med livet', '123456', '1', 'db');
INSERT INTO book (title, isbn, authorId, source) VALUES ('Livet er for kjiipt', '123466', '1', 'db');
INSERT INTO book (title, isbn, authorId, source) VALUES ('Ting Tar Tid', '123467', '1', 'db');
INSERT INTO book (title, isbn, authorId, source) VALUES ('Kjappe matretter', '123468', '2', 'db');

INSERT INTO author (name) VALUES ('Per Persen');
INSERT INTO author (name) VALUES ('Ole Olsen');
