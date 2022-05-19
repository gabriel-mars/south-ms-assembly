-- public.assembly definition
-- Drop table
-- DROP TABLE public.assembly;
CREATE TABLE public.assembly (
	id int8 NOT NULL,
	available bool NOT NULL,
	created_date timestamp NOT NULL,
	description varchar(255) NOT NULL,
	ending_date date NOT NULL,
	starting_date date NOT NULL,
	assembly_status varchar(10) NOT NULL,
	CONSTRAINT assembly_pkey PRIMARY KEY (id)
);
