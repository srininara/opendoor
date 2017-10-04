alter table feedback add column location varchar(50),
add constraint FK_FEEDBACK_LOCATION foreign key (location) REFERENCES location(name);