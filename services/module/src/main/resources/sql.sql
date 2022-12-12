-- Table: public.teacher_module

-- DROP TABLE IF EXISTS public.teacher_module;

CREATE TABLE IF NOT EXISTS public.teacher_module
(
    isactive boolean,
    moduleid integer NOT NULL DEFAULT nextval('"Teacher_module_ModuleId_seq"'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    description character varying(100) COLLATE pg_catalog."default" NOT NULL,
    startdate date,
    enddate date,
    course integer,
    moduleorderno integer,
    createdby text COLLATE pg_catalog."default",
    createddate timestamp with time zone NOT NULL,
    updatedby text COLLATE pg_catalog."default",
    updateddate timestamp with time zone NOT NULL,
    courseid_id integer,
    CONSTRAINT "Teacher_module_pkey" PRIMARY KEY (moduleid),
    CONSTRAINT teacher_module_name_key UNIQUE (name),
    CONSTRAINT "Teacher_module_CourseId_id_50aa9262_fk_Teacher_course_CourseId" FOREIGN KEY (courseid_id)
        REFERENCES public."Teacher_course" ("CourseId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.teacher_module
    OWNER to postgres;
-- Index: Teacher_module_CourseId_id_50aa9262

-- DROP INDEX IF EXISTS public."Teacher_module_CourseId_id_50aa9262";

CREATE INDEX IF NOT EXISTS "Teacher_module_CourseId_id_50aa9262"
    ON public.teacher_module USING btree
    (courseid_id ASC NULLS LAST)
    TABLESPACE pg_default;