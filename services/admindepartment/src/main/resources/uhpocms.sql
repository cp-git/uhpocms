CREATE TABLE IF NOT EXISTS public.admin_department
(
    isactive boolean,
    departmentid integer NOT NULL DEFAULT nextval('"Admin_department_DepartmentId_seq"'::regclass),
    name text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    createdby text COLLATE pg_catalog."default",
    createdon timestamp with time zone,
    modifiedby text COLLATE pg_catalog."default",
    modifiedon timestamp with time zone,
    institutionid_id integer,
    CONSTRAINT "Admin_department_pkey" PRIMARY KEY (departmentid),
    CONSTRAINT "Admin_department_InstitutionId_id_3ace7e32_fk_Admin_ins" FOREIGN KEY (institutionid_id)
        REFERENCES public."Admin_institution" ("InstitutionId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED
)