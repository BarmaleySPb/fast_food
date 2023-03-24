ALTER TABLE dish ADD COLUMN created timestamp;

COMMENT ON COLUMN dish.created IS 'Date of creation';