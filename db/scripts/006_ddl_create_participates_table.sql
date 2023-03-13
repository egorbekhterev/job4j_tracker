CREATE TABLE participates (
    id serial primary key,
    item_id int NOT NULL REFERENCES items(id),
    user_id int NOT NULL REFERENCES j_user(id)
);
