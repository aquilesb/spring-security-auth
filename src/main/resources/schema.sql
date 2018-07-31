DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS properties_images;
DROP TABLE IF EXISTS properties;

create table users (
    id bigint(10) auto_increment not null primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    UNIQUE INDEX `users_email` (`email`),
    UNIQUE INDEX `users_username` (`username`)
);

create table roles(
    id bigint(10) auto_increment not null primary key,
    name varchar(50) not null
);

create table user_roles(
    user_id bigint(10) not null,
    role_id bigint(10) not null,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

create table properties (
    id bigint(10) auto_increment not null primary key,
    name varchar(255) not null,
    address varchar(255) not null,
    google_maps varchar(255) not null,
    encoded_url varchar(255) not null,
    description varchar(2255) not null,
    price decimal(15,2) not null,
    status varchar(30) not null,
    bathrooms int(2) not null,
    bedrooms int(2) not null,
    parking int(2) not null,
    kitchen int(2) not null,
    dt_deleted datetime default null
);

create table properties_images(
    id bigint(10) auto_increment not null primary key,
    property_id bigint(10) not null,
    path varchar(5225) not null,
    FOREIGN KEY (property_id) REFERENCES properties(id)
);
