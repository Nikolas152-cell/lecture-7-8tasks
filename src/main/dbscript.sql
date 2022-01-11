create table if not exists authors
(
    id int auto_increment
        primary key,
    name varchar(100) not null
);

create table if not exists books
(
    title varchar(100) not null,
    id int auto_increment
        primary key,
    author_id int not null,
    constraint books_ibfk_1
        foreign key (author_id) references authors (id)
);

create index author_id
    on books (author_id);

