use spring_security_demo_plaintext;
alter table users modify password varchar(68);

UPDATE users set password='{bcrypt}$2a$10$nh8HT/TvHL0XR4XBwptLiuWDGBSKgiGZjnTE664cfcWhZwv4GRCDO' where username is not null