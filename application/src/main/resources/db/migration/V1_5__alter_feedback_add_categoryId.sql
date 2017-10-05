alter table feedback
    add column category_id int, add foreign key (category_id) REFERENCES category(id);
