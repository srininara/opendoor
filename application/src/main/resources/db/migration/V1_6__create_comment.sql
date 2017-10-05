create table comment(
    comment_id UUID,
    feedback_id UUID not null,
    comment varchar(4000) not null,
    PRIMARY KEY (comment_id),
    foreign key (feedback_id) REFERENCES feedback(id)
);
