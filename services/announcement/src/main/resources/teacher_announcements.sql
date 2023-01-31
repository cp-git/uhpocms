-- Table: public.teacher_announcements

-- DROP TABLE IF EXISTS public.teacher_announcements;

CREATE TABLE IF NOT EXISTS public.teacher_announcements
(
    id integer NOT NULL DEFAULT nextval('teacher_announcements_id_seq'::regclass),
    createdby character varying(255) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    announcement_message character varying(255) COLLATE pg_catalog."default",
    readby character varying(255) COLLATE pg_catalog."default",
    announcement_title character varying(255) COLLATE pg_catalog."default",
    "to" character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT teacher_announcements_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.teacher_announcements
    OWNER to postgres;