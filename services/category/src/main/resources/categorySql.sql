-- Table: public.teacher_category

-- DROP TABLE IF EXISTS public.teacher_category;

CREATE TABLE IF NOT EXISTS public.teacher_category
(
    id integer NOT NULL DEFAULT nextval('"Teacher_category_id_seq"'::regclass),
    category character varying(250) COLLATE pg_catalog."default",
    createdby character varying(255) COLLATE pg_catalog."default",
    createdon timestamp without time zone,
    isactive boolean,
    modifiedby character varying(255) COLLATE pg_catalog."default",
    modifiedon timestamp without time zone,
    CONSTRAINT "Teacher_category_pkey" PRIMARY KEY (id),
    CONSTRAINT "Teacher_category_category_key" UNIQUE (category)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.teacher_category
    OWNER to postgres;
-- Index: Teacher_category_category_2d59e72d_like

-- DROP INDEX IF EXISTS public."Teacher_category_category_2d59e72d_like";

CREATE INDEX IF NOT EXISTS "Teacher_category_category_2d59e72d_like"
    ON public.teacher_category USING btree
    (category COLLATE pg_catalog."default" varchar_pattern_ops ASC NULLS LAST)
    TABLESPACE pg_default;