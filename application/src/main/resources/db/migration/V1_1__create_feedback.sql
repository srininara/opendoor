create table feedback(
    ID UUID not null ,
    message varchar(4000) not null,
    bliss int not null,
    respondent varchar(60),
    PRIMARY KEY (ID)
);
