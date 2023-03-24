CREATE TABLE dish (
                      dish_id SERIAL PRIMARY KEY NOT NULL,
                      name VARCHAR UNIQUE NOT NULL,
                      price INTEGER NOT NULL
);

COMMENT ON TABLE dish IS 'List dishes';
COMMENT ON COLUMN dish.dish_id IS 'Id dish';
COMMENT ON COLUMN dish.name IS 'Name of dish';
COMMENT ON COLUMN dish.price IS 'Price of dish';
