-- Generated by Oracle SQL Developer Data Modeler 17.3.0.261.1541
--   at:        2017-11-16 21:13:33 COT
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



CREATE TABLE bill (
    id          INTEGER NOT NULL,
    title       VARCHAR2(100 CHAR) NOT NULL,
    cost        INTEGER NOT NULL,
    location    VARCHAR2(100 CHAR),
    type        VARCHAR2(100 CHAR),
    "comment"   VARCHAR2(100 CHAR),
    "group"     INTEGER NOT NULL
);

ALTER TABLE bill ADD CONSTRAINT bill_pk PRIMARY KEY ( id );

CREATE TABLE billsxusers (
    bill     INTEGER NOT NULL,
    id       INTEGER NOT NULL,
    "user"   INTEGER NOT NULL
);

ALTER TABLE billsxusers ADD CONSTRAINT billsxusers_pk PRIMARY KEY ( id );

CREATE TABLE debt (
    id          INTEGER NOT NULL,
    "group"     INTEGER NOT NULL,
    recipient   INTEGER NOT NULL,
    debtor      INTEGER NOT NULL,
    value       INTEGER NOT NULL
);

ALTER TABLE debt ADD CONSTRAINT debt_pk PRIMARY KEY ( id );

CREATE TABLE debtpayroll (
    id          INTEGER NOT NULL,
    "group"     INTEGER NOT NULL,
    recipient   INTEGER NOT NULL,
    debtor      INTEGER NOT NULL,
    value       INTEGER NOT NULL
);

ALTER TABLE debtpayroll ADD CONSTRAINT debtpayroll_pk PRIMARY KEY ( id );

CREATE TABLE "Group" (
    id       INTEGER NOT NULL,
    leader   INTEGER NOT NULL,
    name     VARCHAR2(100 CHAR) NOT NULL,
    status   VARCHAR2(100 CHAR) NOT NULL
);

ALTER TABLE "Group" ADD CONSTRAINT group_pk PRIMARY KEY ( id );

CREATE TABLE usersxgroups (
    id        INTEGER NOT NULL,
    "group"   INTEGER NOT NULL,
    "user"    INTEGER NOT NULL
);

ALTER TABLE usersxgroups ADD CONSTRAINT usersxgroups_pk PRIMARY KEY ( id );

ALTER TABLE billsxusers
    ADD CONSTRAINT bill_fk FOREIGN KEY ( bill )
        REFERENCES bill ( id );

ALTER TABLE debt
    ADD CONSTRAINT debt_group_fk FOREIGN KEY ( "group" )
        REFERENCES "Group" ( id );

ALTER TABLE bill
    ADD CONSTRAINT group_fk FOREIGN KEY ( "group" )
        REFERENCES "Group" ( id );

ALTER TABLE usersxgroups
    ADD CONSTRAINT group_fkv1 FOREIGN KEY ( "group" )
        REFERENCES "Group" ( id );

CREATE SEQUENCE bill_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER bill_id_trg BEFORE
    INSERT ON bill
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := bill_id_seq.nextval;
END;
/

CREATE SEQUENCE billsxusers_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER billsxusers_id_trg BEFORE
    INSERT ON billsxusers
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := billsxusers_id_seq.nextval;
END;
/

CREATE SEQUENCE group_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER group_id_trg BEFORE
    INSERT ON "Group"
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := group_id_seq.nextval;
END;
/



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             6
-- CREATE INDEX                             0
-- ALTER TABLE                             10
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           3
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          3
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
