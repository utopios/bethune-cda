CREATE TABLE public.contrat (
                                id_contrat serial NOT NULL,
                                type_contrat character varying(100),
                                prix_mensualite double precision,
                                formule character varying(100)
);
CREATE TABLE public.client (
                               id_client serial NOT NULL,

                               nom_client character varying(100),
                               prenom_client character varying(100),

                               telephone_client character varying(100)
);

CREATE TABLE user(
                     id serial not null,
                     username character varying(100),
                     password character varying(100),
                     email character varying(100),
                     phone character varying(100),
                     name character varying(100),
                     businesstitle character varying(100)
)

CREATE TABLE role(
                     id serial not null,
                     name character varying(100)
);

CREATE TABLE user_roles(
                           id serial not null,
                           user_id integer not null,
                           role_id integer not null
);
