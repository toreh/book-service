drop table if exists book;
drop table if exists author;

create table book (
                      bookId bigint not null,
                      title varchar(50) not null,
                      isbn varchar(6) not null,
                      authorId bigint,
                      source varchar(20),
                      update_date datetime(6),
                      version integer,
                      primary key (bookId)
) engine=InnoDB;

create table author (
                        authorId bigint not null,
                        name varchar(50),
                        update_date datetime(6),
                        version integer,
                        primary key (authorId)
) engine=InnoDB;

INSERT INTO book (bookId, title, isbn, authorId, source) VALUES ('1', 'Meningen med livet', '123456', '1', 'db');
INSERT INTO book (bookId, title, isbn, authorId, source) VALUES ('2', 'Livet er for kjiipt', '123466', '2', 'db');