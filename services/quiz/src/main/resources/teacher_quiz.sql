CREATE TABLE IF NOT EXISTS public.teacher_quiz
(
    quizid integer NOT NULL DEFAULT nextval('"Teacher_quiz_QuizId_seq"'::regclass),
    title character varying(60) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    url character varying(60) COLLATE pg_catalog."default" NOT NULL,
    random_order boolean NOT NULL,
    max_questions integer,
    answers_at_end boolean NOT NULL,
    exam_paper boolean NOT NULL,
    single_attempt boolean NOT NULL,
    pass_mark smallint NOT NULL,
    success_text text COLLATE pg_catalog."default" NOT NULL,
    fail_text text COLLATE pg_catalog."default" NOT NULL,
    draft boolean NOT NULL,
    quizorderno integer NOT NULL,
    courseid_id integer NOT NULL,
    module_id integer,
    category_id integer,
    isactive boolean,
    modifiedby character varying(255) COLLATE pg_catalog."default",
    createdby character varying(255) COLLATE pg_catalog."default",
    createdon timestamp without time zone,
    modifiedon timestamp without time zone,
    CONSTRAINT "Teacher_quiz_pkey" PRIMARY KEY (quizid),
    CONSTRAINT teacher_quiz_title_key UNIQUE (title),
    CONSTRAINT "Teacher_quiz_CourseId_id_7da107e9_fk_Teacher_course_CourseId" FOREIGN KEY (courseid_id)
        REFERENCES public."Teacher_course" ("CourseId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT "Teacher_quiz_Module_id_3b34f714_fk_Teacher_module_ModuleId" FOREIGN KEY (module_id)
        REFERENCES public."Teacher_module" ("ModuleId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT "Teacher_quiz_category_id_5d444d9d_fk_Teacher_category_id" FOREIGN KEY (category_id)
        REFERENCES public."Teacher_category" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT "Teacher_quiz_max_questions_check" CHECK (max_questions >= 0),
    CONSTRAINT "Teacher_quiz_quizorderno_check" CHECK (quizorderno >= 0)
)
WITH (
    OIDS = FALSE
)