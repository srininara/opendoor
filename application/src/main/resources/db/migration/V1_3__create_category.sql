create table category(
    id int,
    name varchar(50) not null,
    short_description varchar(1000) not null,
    full_description varchar(4000) not null,
    PRIMARY KEY (id)
);

insert into category VALUES
  (1, 'Idea', 'For when you have an idea to help improve the business, ways of working etc', 'For when you have an idea to help improve the business, ways of working etc'),
  (2, 'Applause', 'Positive feedback about the organisation, teams or individuals', 'Positive feedback about the organisation, teams or individuals'),
  (3, 'Rant', 'Feedback that addresses something that could be better', 'Feedback that addresses something that could be better');