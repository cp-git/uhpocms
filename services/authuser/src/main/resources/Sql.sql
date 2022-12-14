-- Table: public.auth_user

-- DROP TABLE IF EXISTS public.auth_user;

CREATE TABLE IF NOT EXISTS public.auth_user
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    created_by character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp without time zone NOT NULL,
    date_joined timestamp without time zone NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    is_active boolean NOT NULL,
    is_staff boolean NOT NULL,
    is_superuser boolean NOT NULL,
    last_login timestamp without time zone,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    modified_by character varying(255) COLLATE pg_catalog."default" NOT NULL,
    modified_on timestamp without time zone NOT NULL,
    username character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT auth_user_pkey PRIMARY KEY (id),
    CONSTRAINT uk_t1iph3dfc25ukwcl9xemtnojn UNIQUE (username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.auth_user
    OWNER to postgres;