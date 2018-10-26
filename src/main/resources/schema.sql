CREATE TABLE events(id SERIAL, name VARCHAR(255), date DATE, venue_id INTEGER, primary key(id));
CREATE TABLE venue(id SERIAL, name VARCHAR(255), city VARCHAR(255), state VARCHAR(255), primary key(id));
