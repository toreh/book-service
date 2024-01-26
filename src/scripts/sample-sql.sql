select * from book;
select bookId, title, isbn, source from book where bookId = 1;

select * from author;

select author.authorId, author.name, book.title, book.source
from book, author
where author.authorId  = book.authorId ;

select author.authorId, author.name, book.title, book.source
from book, author
where author.authorId  = book.authorId and author.authorId  = 1;

select author.authorId, author.name, book.title, book.source
from author
         LEFT JOIN book ON book.authorId = author.authorId;

select author.authorId, author.name, book.title, book.source
from author
         LEFT JOIN book ON book.authorId = author.authorId
where author.authorId  = 1;