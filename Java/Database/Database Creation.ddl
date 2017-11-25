-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2017-11-24 23:41:28 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Bill
  (
    id       INTEGER NOT NULL ,
    title    VARCHAR2 (100 CHAR) NOT NULL ,
    cost     INTEGER NOT NULL ,
    location VARCHAR2 (100 CHAR) ,
    type     VARCHAR2 (100 CHAR) ,
    note     VARCHAR2 (100 CHAR) ,
    grp      INTEGER NOT NULL
  ) ;
ALTER TABLE Bill ADD CONSTRAINT Bill_PK PRIMARY KEY ( id ) ;


CREATE TABLE BillsxUsers
  (
    bill INTEGER NOT NULL ,
    id   INTEGER NOT NULL ,
    usr  INTEGER NOT NULL
  ) ;
ALTER TABLE BillsxUsers ADD CONSTRAINT BillsxUsers_PK PRIMARY KEY ( id ) ;


CREATE TABLE Debt
  (
    id        INTEGER NOT NULL ,
    grp       INTEGER NOT NULL ,
    recipient INTEGER NOT NULL ,
    debtor    INTEGER NOT NULL ,
    value     INTEGER NOT NULL
  ) ;
ALTER TABLE Debt ADD CONSTRAINT Debt_PK PRIMARY KEY ( id ) ;


CREATE TABLE DebtPayroll
  (
    id        INTEGER NOT NULL ,
    grp       INTEGER NOT NULL ,
    recipient INTEGER NOT NULL ,
    debtor    INTEGER NOT NULL ,
    value     INTEGER NOT NULL
  ) ;
ALTER TABLE DebtPayroll ADD CONSTRAINT DebtPayroll_PK PRIMARY KEY ( id ) ;


CREATE TABLE Grp
  (
    id     INTEGER NOT NULL ,
    leader INTEGER NOT NULL ,
    name   VARCHAR2 (100 CHAR) NOT NULL ,
    status VARCHAR2 (100 CHAR) NOT NULL
  ) ;
ALTER TABLE Grp ADD CONSTRAINT Group_PK PRIMARY KEY ( id ) ;


CREATE TABLE UsersxGroups
  (
    id  INTEGER NOT NULL ,
    grp INTEGER NOT NULL ,
    usr INTEGER NOT NULL
  ) ;
ALTER TABLE UsersxGroups ADD CONSTRAINT UsersxGroups_PK PRIMARY KEY ( id ) ;


ALTER TABLE BillsxUsers ADD CONSTRAINT Bill_FK FOREIGN KEY ( bill ) REFERENCES Bill ( id ) ;

ALTER TABLE Debt ADD CONSTRAINT Debt_Group_FK FOREIGN KEY ( grp ) REFERENCES Grp ( id ) ;

ALTER TABLE Bill ADD CONSTRAINT Group_FK FOREIGN KEY ( grp ) REFERENCES Grp ( id ) ;

ALTER TABLE UsersxGroups ADD CONSTRAINT Group_FKv1 FOREIGN KEY ( grp ) REFERENCES Grp ( id ) ;

CREATE SEQUENCE Bill_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER Bill_id_TRG BEFORE
  INSERT ON Bill FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := Bill_id_SEQ.NEXTVAL;
END;
/

CREATE SEQUENCE BillsxUsers_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER BillsxUsers_id_TRG BEFORE
  INSERT ON BillsxUsers FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := BillsxUsers_id_SEQ.NEXTVAL;
END;
/

CREATE SEQUENCE Grp_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER Grp_id_TRG BEFORE
  INSERT ON Grp FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := Grp_id_SEQ.NEXTVAL;
END;
/


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
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
