-- Table: public.instituteadmin_profile

-- DROP TABLE IF EXISTS public.instituteadmin_profile;

CREATE TABLE IF NOT EXISTS public.instituteadmin_profile
(
    isactive boolean,
    id integer NOT NULL DEFAULT nextval('"InstituteAdmin_profile_id_seq"'::regclass),
    userrole text COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(100) COLLATE pg_catalog."default",
    last_name character varying(100) COLLATE pg_catalog."default",
    email character varying(100) COLLATE pg_catalog."default",
    dob character varying(100) COLLATE pg_catalog."default",
    mobileno text COLLATE pg_catalog."default",
    gender text COLLATE pg_catalog."default",
    department integer,
    address1 text COLLATE pg_catalog."default",
    address2 text COLLATE pg_catalog."default",
    city text COLLATE pg_catalog."default",
    state text COLLATE pg_catalog."default",
    zip text COLLATE pg_catalog."default",
    profile_pics character varying(100) COLLATE pg_catalog."default",
    createdby text COLLATE pg_catalog."default",
    createddate timestamp with time zone,
    updatedby text COLLATE pg_catalog."default",
    updateddate timestamp with time zone,
    institutionid_id integer,
    user_id integer NOT NULL,
    CONSTRAINT "InstituteAdmin_profile_pkey" PRIMARY KEY (id),
    CONSTRAINT "InstituteAdmin_profile_user_id_key" UNIQUE (user_id),
    CONSTRAINT "InstituteAdmin_profi_InstitutionId_id_32474369_fk_Admin_ins" FOREIGN KEY (institutionid_id)
        REFERENCES public."Admin_institution" ("InstitutionId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT "InstituteAdmin_profile_user_id_14381fb1_fk_auth_user_id" FOREIGN KEY (user_id)
        REFERENCES public.auth_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.instituteadmin_profile
    OWNER to postgres;
-- Index: InstituteAdmin_profile_InstitutionId_id_32474369

-- DROP INDEX IF EXISTS public."InstituteAdmin_profile_InstitutionId_id_32474369";

CREATE INDEX IF NOT EXISTS "InstituteAdmin_profile_InstitutionId_id_32474369"
    ON public.instituteadmin_profile USING btree
    (institutionid_id ASC NULLS LAST)
    TABLESPACE pg_default;