alter table feedback
    add column category_id int not null, add foreign key (category_id) REFERENCES category(id);
