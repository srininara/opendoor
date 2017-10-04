create table feedback(
    id UUID,
    message varchar(4000) not null,
    bliss int not null,
    created_at timestamp not null,
    respondent varchar(60),
    location_id int not null,
    PRIMARY KEY (id),
    foreign key (location_id) REFERENCES location(id)
);
