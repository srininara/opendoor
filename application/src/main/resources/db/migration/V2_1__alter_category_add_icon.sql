alter TABLE category
    add column
    icon varchar(50) default 'lightbulb_outline';

update category set icon = 'lightbulb_outline' where id = 1;
update category set icon = 'thumb_up' where id = 2;
update category set icon = 'thumb_down' where id = 3;
