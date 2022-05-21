-- public.assembly definition
-- Drop table
-- DROP TABLE public.assembly;
CREATE TABLE public.assembly (
	id int8 NOT NULL,
	description varchar(255) NOT NULL,
	registered_date timestamp NOT NULL,
	assembly_status varchar(10) NOT NULL,
	ending_date date NOT NULL,
	starting_date date NOT NULL,
	id_closed_assembly int8 NOT NULL,
	CONSTRAINT assembly_pkey PRIMARY KEY (id)
);
