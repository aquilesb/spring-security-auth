insert into users(name, email, username, password) VALUES ('Aquiles', 'aquiles@test.com', 'aquilesb', '$2a$10$RzGs105Mrre/l3ngo2/Ll.SIuS9iv09YGdYa/s2AXnpdCVEQ0a/32');
insert into users(name, email, username, password) VALUES ('Marco', 'marco@test.com', 'marco', '$2a$10$RzGs105Mrre/l3ngo2/Ll.SIuS9iv09YGdYa/s2AXnpdCVEQ0a/32');
insert into users(name, email, username, password) VALUES ('David', 'david@test.com', 'david', '$2a$10$RzGs105Mrre/l3ngo2/Ll.SIuS9iv09YGdYa/s2AXnpdCVEQ0a/32');
insert into users(name, email, username, password) VALUES ('John', 'john@test.com', 'john', '$2a$10$RzGs105Mrre/l3ngo2/Ll.SIuS9iv09YGdYa/s2AXnpdCVEQ0a/32');
insert into users(name, email, username, password) VALUES ('Lucca', 'lucca@test.com', 'lucca', '$2a$10$RzGs105Mrre/l3ngo2/Ll.SIuS9iv09YGdYa/s2AXnpdCVEQ0a/32');

insert into roles(name) VALUES ('ROLE_USER');
insert into roles(name) VALUES ('ROLE_ADMIN');
insert into roles(name) VALUES ('UPDATE');
insert into roles(name) VALUES ('INSERT');
insert into roles(name) VALUES ('DELETE');

insert into user_roles(user_id, role_id) VALUES (1,2);
insert into user_roles(user_id, role_id) VALUES (1,4);
insert into user_roles(user_id, role_id) VALUES (1,5);
insert into user_roles(user_id, role_id) VALUES (2,1);
insert into user_roles(user_id, role_id) VALUES (2,3);
insert into user_roles(user_id, role_id) VALUES (3,1);
insert into user_roles(user_id, role_id) VALUES (3,4);
insert into user_roles(user_id, role_id) VALUES (4,1);
insert into user_roles(user_id, role_id) VALUES (4,3);
insert into user_roles(user_id, role_id) VALUES (4,4);
insert into user_roles(user_id, role_id) VALUES (4,5);
insert into user_roles(user_id, role_id) VALUES (5,2);

insert into properties(name, address, google_maps, encoded_url, price, status, description, bedrooms, bathrooms, parking, kitchen) VALUES ('Luxury home', 'Brunswick,Victoria Street , 3056, Victoria, Australia', 'Brunswick,+Victoria+Street,+3056,+Victoria,+Australia', 'Brunswick+Victoria+street+vic+3056', 234900, 'sold', '<p>Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time chemas. Dramatically maintain clicks-and-mortar solutions without functional solutions.</p><br /><br /> <p>Completely synergize resource sucking relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas. Dynamically innovate resource-leveling customer service for state of the art customer service</p>', 3, 2, 1, 2);
insert into properties(name, address, google_maps, encoded_url, price, status, description, bedrooms, bathrooms, parking, kitchen) VALUES ('Simple home', 'Footscray,Victoria Street , 3056, Victoria, Australia', 'Footscray,+Victoria+Street,+3056,+Victoria,+Australia', 'Footscray+Victoria+street+vic+3056', 234900, 'sold', '<p>Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time chemas. Dramatically maintain clicks-and-mortar solutions without functional solutions.</p><br /><br /> <p>Completely synergize resource sucking relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas. Dynamically innovate resource-leveling customer service for state of the art customer service</p>', 3, 3, 1, 1);
insert into properties(name, address, google_maps, encoded_url, price, status, description, bedrooms, bathrooms, parking, kitchen) VALUES ('Rich home', 'Sunshine,Victoria Street , 3056, Victoria, Australia', 'Sunshine,+Victoria+Street,+3056,+Victoria,+Australia', 'Sunshine+Victoria+street+vic+3056', 234900, 'sold', '<p>Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time chemas. Dramatically maintain clicks-and-mortar solutions without functional solutions.</p><br /><br /> <p>Completely synergize resource sucking relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas. Dynamically innovate resource-leveling customer service for state of the art customer service</p>', 3, 1, 1, 2);
insert into properties(name, address, google_maps, encoded_url, price, status, description, bedrooms, bathrooms, parking, kitchen) VALUES ('Poor home', 'Melbourne,Victoria Street , 3056, Victoria, Australia', 'Melbourne,+Victoria+Street,+3056,+Victoria,+Australia', 'Melbourne+Victoria+street+vic+3056', 234900, 'sold', '<p>Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time chemas. Dramatically maintain clicks-and-mortar solutions without functional solutions.</p><br /><br /> <p>Completely synergize resource sucking relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas. Dynamically innovate resource-leveling customer service for state of the art customer service</p>', 3, 2, 3, 2);
insert into properties(name, address, google_maps, encoded_url, price, status, description, bedrooms, bathrooms, parking, kitchen) VALUES ('Unbelievable home', 'South Yarra,Victoria Street , 3056, Victoria, Australia', 'South+Yarra,+Victoria+Street,+3056,+Victoria,+Australia', 'South+Yarra+Victoria+street+vic+3056', 234900, 'sold', '<p>Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time chemas. Dramatically maintain clicks-and-mortar solutions without functional solutions.</p><br /><br /> <p>Completely synergize resource sucking relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas. Dynamically innovate resource-leveling customer service for state of the art customer service</p>', 1, 2, 2, 3);
insert into properties(name, address, google_maps, encoded_url, price, status, description, bedrooms, bathrooms, parking, kitchen) VALUES ('My home', 'North Melbourne,Victoria Street , 3056, Victoria, Australia', 'North Melbourne,+Victoria+Street,+3056,+Victoria,+Australia', 'North Melbourne+Victoria+street+vic+3056', 234900, 'sold', '<p>Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time chemas. Dramatically maintain clicks-and-mortar solutions without functional solutions.</p><br /><br /> <p>Completely synergize resource sucking relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas. Dynamically innovate resource-leveling customer service for state of the art customer service</p>', 2, 2, 3, 2);


insert into properties_images(property_id, path) VALUES (1, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (1, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (2, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (2, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (2, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (3, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (3, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (4, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (4, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (5, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (5, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (6, '/static/images/3.jpg' );
insert into properties_images(property_id, path) VALUES (6, '/static/images/3.jpg' );

