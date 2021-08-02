DROP TABLE ers_reimbursement IF EXISTS;
DROP TABLE ers_users IF EXISTS;
DROP TABLE ers_reimbursement_status IF EXISTS;
DROP TABLE ers_reimbursement_type IF EXISTS;
DROP TABLE  ers_user_roles IF EXISTS;
DROP PROCEDURE IF EXISTS addErsUsers;
DROP PROCEDURE IF EXISTS addLogin;

CREATE TABLE ers_reimbursement(
	reimb_id integer NOT NULL PRIMARY KEY,
	reimb_amount numeric(20,2) NOT NULL,
	reimb_submitted timestamp NOT NULL,
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_receipt bytea,
	reimb_author integer NOT NULL FOREIGN KEY,
	reimb_resolver integer FOREIGN KEY,
	reimb_status_id integer FOREIGN KEY REFERENCES ers_reimbursement_status(reimb_status_id), 
	reimb_type_id integer NOT NULL FOREIGN KEY REFERENCES ers_reimbursement_type(reimb_type_id)
);

CREATE TABLE ers_users(
	ers_user_id integer NOT NULL PRIMARY KEY,
	ers_username varchar(50) UNIQUE,
	ers_password varchar(50) NOT NULL,
	user_first_name varchar(100) NOT NULL,
	user_last_name varchar(100) NOT NULL,
	user_email varchar(150) UNIQUE NOT NULL,
	user_role_id integer NOT NULL FOREIGN KEY REFERENCES ers_user_role(ers_user_role_id)
);

CREATE PROCEDURE addErsUsers(
		integer NOT NULL, varchar(50) UNIQUE, varchar(50) NOT NULL, varchar(100) NOT NULL,
		varchar(100) NOT NULL,  varchar(150) UNIQUE NOT NULL, integer NOT NULL)
		{	LANGUAGE 'plpgsql' AS $$
			BEGIN
		
			INSERT INTO ers_users (ers_user_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
	    	VALUES ($1, $2, $3, $4, $5, $6, $7);
	    	COMMIT;
		
			END;
			$$;
		};


CREATE PROCEDURE addLogin(
			integer NOT NULL, varchar(50) UNIQUE, varchar(50) NOT NULL)
					{	LANGUAGE 'plpgsql' AS $$
						BEGIN
					
						INSERT INTO ers_users (ers_user_id, ers_username, ers_password)
				    	VALUES ($1, $2, $3);
				    	COMMIT;
					
						END;
						$$;
					};


CREATE TABLE ers_reimbursement_status(
	reimb_status_id integer NOT NULL PRIMARY KEY,
	reimb_status varchar(10) NOT NULL
);

CREATE TABLE ers_reimbursement_type(
	reimb_type_id integer NOT NULL PRIMARY KEY,
	reimb_type varchar(10) NOT NULL
);

CREATE TABLE ers_user_roles(
	ers_user_role_id integer NOT NULL PRIMARY KEY,
	user_role varchar(10)NOT NULL
);

INSERT INTO ers_reimbursement_status(reimb_status_id, reimb_status)
	VALUES (1, 'PENDING'),
	(2, 'APPROVED'),
	(3, 'DENIED');

INSERT INTO ers_reimbursement_type(reimb_type_id, reimb_type)
	VALUES (1, 'LODGING'),
	(2, 'TRAVEL'),
	(3, 'MEDICAL'),
	(4, 'BUSINESS'),
	(5, 'OTHER');

INSERT INTO ers_user_roles (ers_user_role_id, user_role)
	VALUES (1, 'MANAGER'),
	(2, 'EMPLOYEE');