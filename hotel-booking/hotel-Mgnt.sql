CREATE DATABASE hotel_service
  WITH ENCODING='UTF8'
       OWNER=postgres
       CONNECTION LIMIT=-1;

---------------------------- create Tabels
---------------------------- room Tabels

CREATE TABLE public.room_def
(
   id bigint, 
   room_type character(1) NOT NULL, 
   rent integer NOT NULL, 
   CONSTRAINT pkey_room_id PRIMARY KEY (id) USING INDEX TABLESPACE pg_default
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.room_def
  OWNER TO postgres;

------------------ customer_tabel

CREATE TABLE public.customer
(
   id bigint, 
   first_name character varying(50), 
   last_name character varying(50), 
   dob date NOT NULL, 
   email character varying(50) NOT NULL, 
   password character varying(10) NOT NULL, 
   CONSTRAINT pkey_customer_id PRIMARY KEY (id) USING INDEX TABLESPACE pg_default
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.customer
  OWNER TO postgres;


-------------------------------------
CREATE TABLE public.booking_details
(
   id bigint, 
   customer_id bigint, 
   room_id bigint, 
   start_date timestamp with time zone, 
   end_date timestamp with time zone, 
   CONSTRAINT pkey_booking_id PRIMARY KEY (id) USING INDEX TABLESPACE pg_default, 
   CONSTRAINT "fkey_customerId" FOREIGN KEY (customer_id) REFERENCES customer (id) MATCH FULL ON UPDATE NO ACTION ON DELETE NO ACTION, 
   CONSTRAINT fkey_room_id FOREIGN KEY (room_id) REFERENCES room_def (id) MATCH FULL ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.booking_details
  OWNER TO postgres;


----------------------------------------


CREATE SEQUENCE public.room_id_seq
   INCREMENT 1
   START 50001;
ALTER SEQUENCE public.room_id_seq
  OWNER TO postgres;


------------------------------------------


CREATE SEQUENCE public.customer_seq
   INCREMENT 1
   START 70001;
ALTER SEQUENCE public.customer_seq
  OWNER TO postgres;

---------------------------------------

CREATE SEQUENCE public.booking_id_seq
   INCREMENT 1
   START 90001;
ALTER SEQUENCE public.booking_id_seq
  OWNER TO postgres;

----------------------------------------

INSERT INTO room_def(id, room_type, rent) VALUES (nextVal('room_id_seq'), 'K', 25000);
INSERT INTO room_def(id, room_type, rent) VALUES (nextVal('room_id_seq'), 'Q', 20000);
INSERT INTO room_def(id, room_type, rent) VALUES (nextVal('room_id_seq'), 'Q', 20000);
INSERT INTO room_def(id, room_type, rent) VALUES (nextVal('room_id_seq'), 'K', 25000);



