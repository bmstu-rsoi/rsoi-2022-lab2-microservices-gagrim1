SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE airport RESTART IDENTITY;
TRUNCATE TABLE flight RESTART IDENTITY;
SET REFERENTIAL_INTEGRITY TRUE;