CREATE TABLE IF NOT EXISTS public.teacher_question
(
    id serial,
    figure character varying(100) COLLATE pg_catalog."default",
    content character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    explanation text COLLATE pg_catalog."default" NOT NULL,
    questionorderno integer NOT NULL,
    ismcq boolean NOT NULL,
    quizid_id integer NOT NULL,
    category_id integer,
	  is_active boolean NOT NULL,
	 created_by character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp without time zone NOT NULL,
	 modified_by character varying(255) COLLATE pg_catalog."default" NOT NULL,
    modified_on timestamp without time zone NOT NULL,
    CONSTRAINT "Teacher_question_pkey" PRIMARY KEY (id),
    CONSTRAINT "Teacher_question_QuizId_id_f3ba643e_fk_Teacher_quiz_QuizId" FOREIGN KEY (quizid_id)
        REFERENCES public."Teacher_quiz" ("QuizId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT "Teacher_question_category_id_52ec7234_fk_Teacher_category_id" FOREIGN KEY (category_id)
        REFERENCES public."Teacher_category" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT "Teacher_question_questionOrderNo_check" CHECK (questionorderno >= 0)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.teacher_question
    OWNER to postgres;
-- Index: Teacher_question_QuizId_id_f3ba643e

-- DROP INDEX IF EXISTS public."Teacher_question_QuizId_id_f3ba643e";

CREATE INDEX IF NOT EXISTS "Teacher_question_QuizId_id_f3ba643e"
    ON public.teacher_question USING btree
    (quizid_id ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: Teacher_question_category_id_52ec7234

-- DROP INDEX IF EXISTS public."Teacher_question_category_id_52ec7234";

CREATE INDEX IF NOT EXISTS "Teacher_question_category_id_52ec7234"
    ON public.teacher_question USING btree
    (category_id ASC NULLS LAST)
    TABLESPACE pg_default;