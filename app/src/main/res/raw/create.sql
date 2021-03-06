
-- ------- TABLES CREATION --------

CREATE TABLE Task
(
    ID varchar(255) NOT NULL PRIMARY KEY,
    NAME varchar(255) NOT NULL,
    STATE integer(2) NOT NULL,
    LIMIT_DATE integer(64),
    DURATION integer(128),
    PRIORITY varchar(255),
    LOCATION varchar(255),
);

CREATE TABLE Template
(
    ID varchar(255) NOT NULL PRIMARY KEY,
    NAME varchar(255) NOT NULL,
    DURATION integer(128),
    PRIORITY varchar(255),
    LOCATION varchar(255),
);

CREATE TABLE Location
(
    ID varchar(255) NOT NULL PRIMARY KEY,
    NAME varchar(255) NOT NULL,
);

CREATE TABLE PRIORITY
(
    ID varchar(255) NOT NULL PRIMARY KEY,
    PRIORITY integer(64) NOT NULL,
);


-- ------- CONSTRAINTS --------

ALTER TABLE Task ADD CONSTRAINT fk_task_priority
FOREIGN KEY (ID) REFERENCES PRIORITY(ID);

ALTER TABLE Task ADD CONSTRAINT fk_task_location
FOREIGN KEY (ID) REFERENCES LOCATION(ID);

ALTER TABLE Template ADD CONSTRAINT fk_template_priority
FOREIGN KEY (ID) REFERENCES PRIORITY(ID);

ALTER TABLE Template ADD CONSTRAINT fk_template_location
FOREIGN KEY (ID) REFERENCES LOCATION(ID);

