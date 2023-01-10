-- Table: public.teacher_course

-- DROP TABLE IF EXISTS public.teacher_course;

CREATE TABLE IF NOT EXISTS public.teacher_course
(
    isactive boolean,
    courseid serial,
    coursecode text COLLATE pg_catalog."default",
    name text COLLATE pg_catalog."default",
    description character varying(100) COLLATE pg_catalog."default",
    coursetype character varying(50) COLLATE pg_catalog."default",
    passingscore text COLLATE pg_catalog."default",
    instid integer,
    createdby text COLLATE pg_catalog."default",
    createddate timestamp with time zone,
    updatedby text COLLATE pg_catalog."default",
    updateddate timestamp with time zone,
    CONSTRAINT "Teacher_course_pkey" PRIMARY KEY (courseid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.teacher_course
    OWNER to postgres;