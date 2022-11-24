PGDMP     4                
    z            uhpocms    13.8    13.8 �   i           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            j           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            k           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            l           1262    27597    uhpocms    DATABASE     k   CREATE DATABASE uhpocms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE uhpocms;
                postgres    false            �            1259    27598    Admin_department    TABLE     3  CREATE TABLE public."Admin_department" (
    "isActive" boolean,
    "DepartmentId" integer NOT NULL,
    "Name" text,
    "Description" text,
    "CreatedBy" text,
    "CreatedOn" timestamp with time zone,
    "ModifiedBy" text,
    "ModifiedOn" timestamp with time zone,
    "InstitutionId_id" integer
);
 &   DROP TABLE public."Admin_department";
       public         heap    postgres    false            �            1259    27604 !   Admin_department_DepartmentId_seq    SEQUENCE     �   CREATE SEQUENCE public."Admin_department_DepartmentId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public."Admin_department_DepartmentId_seq";
       public          postgres    false    200            m           0    0 !   Admin_department_DepartmentId_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public."Admin_department_DepartmentId_seq" OWNED BY public."Admin_department"."DepartmentId";
          public          postgres    false    201            �            1259    27606    Admin_institution    TABLE     9  CREATE TABLE public."Admin_institution" (
    "isActive" boolean,
    "InstitutionId" integer NOT NULL,
    "Name" text,
    "Description" text,
    "CreatedBy" text,
    "CreatedOn" timestamp with time zone,
    "ModifiedBy" text,
    "ModifiedOn" timestamp with time zone,
    picture character varying(100)
);
 '   DROP TABLE public."Admin_institution";
       public         heap    postgres    false            �            1259    27612 #   Admin_institution_InstitutionId_seq    SEQUENCE     �   CREATE SEQUENCE public."Admin_institution_InstitutionId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public."Admin_institution_InstitutionId_seq";
       public          postgres    false    202            n           0    0 #   Admin_institution_InstitutionId_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public."Admin_institution_InstitutionId_seq" OWNED BY public."Admin_institution"."InstitutionId";
          public          postgres    false    203            �            1259    27614 
   Admin_role    TABLE     E  CREATE TABLE public."Admin_role" (
    "isActive" boolean,
    "RoleId" integer NOT NULL,
    "RoleName" text NOT NULL,
    "RoleDescription" text NOT NULL,
    "CreatedBy" text NOT NULL,
    "CreatedOn" timestamp with time zone NOT NULL,
    "ModifiedBy" text NOT NULL,
    "ModifiedOn" timestamp with time zone NOT NULL
);
     DROP TABLE public."Admin_role";
       public         heap    postgres    false            �            1259    27620    Admin_role_RoleId_seq    SEQUENCE     �   CREATE SEQUENCE public."Admin_role_RoleId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public."Admin_role_RoleId_seq";
       public          postgres    false    204            o           0    0    Admin_role_RoleId_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public."Admin_role_RoleId_seq" OWNED BY public."Admin_role"."RoleId";
          public          postgres    false    205            �            1259    27622    Admin_userinstitutionmap    TABLE     5  CREATE TABLE public."Admin_userinstitutionmap" (
    "isActive" boolean,
    "Id" integer NOT NULL,
    "CreatedBy" text NOT NULL,
    "CreatedOn" timestamp with time zone NOT NULL,
    "ModifiedBy" text NOT NULL,
    "ModifiedOn" timestamp with time zone NOT NULL,
    "InstitutionId_id" integer NOT NULL
);
 .   DROP TABLE public."Admin_userinstitutionmap";
       public         heap    postgres    false            �            1259    27628    Admin_userinstitutionmap_Id_seq    SEQUENCE     �   CREATE SEQUENCE public."Admin_userinstitutionmap_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public."Admin_userinstitutionmap_Id_seq";
       public          postgres    false    206            p           0    0    Admin_userinstitutionmap_Id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public."Admin_userinstitutionmap_Id_seq" OWNED BY public."Admin_userinstitutionmap"."Id";
          public          postgres    false    207            �            1259    27630    instituteadmin_profile    TABLE     y  CREATE TABLE public.instituteadmin_profile (
    isactive boolean,
    id integer NOT NULL,
    userrole text NOT NULL,
    first_name character varying(100),
    last_name character varying(100),
    email character varying(100),
    dob character varying(100),
    mobileno text,
    gender text,
    department integer,
    address1 text,
    address2 text,
    city text,
    state text,
    zip text,
    profile_pics character varying(100),
    createdby text,
    createddate timestamp with time zone,
    updatedby text,
    updateddate timestamp with time zone,
    institutionid_id integer,
    user_id integer NOT NULL
);
 *   DROP TABLE public.instituteadmin_profile;
       public         heap    postgres    false            �            1259    27636    InstituteAdmin_profile_id_seq    SEQUENCE     �   CREATE SEQUENCE public."InstituteAdmin_profile_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public."InstituteAdmin_profile_id_seq";
       public          postgres    false    208            q           0    0    InstituteAdmin_profile_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public."InstituteAdmin_profile_id_seq" OWNED BY public.instituteadmin_profile.id;
          public          postgres    false    209            �            1259    27638    Teacher_announcements    TABLE        CREATE TABLE public."Teacher_announcements" (
    id integer NOT NULL,
    "Announcement_title" character varying(100),
    "Announcement_message" text,
    "To" character varying(50),
    "ReadBy" character varying(50),
    "CreatedBy" text,
    "Created_On" timestamp with time zone
);
 +   DROP TABLE public."Teacher_announcements";
       public         heap    postgres    false            �            1259    27644    Teacher_announcements_To_List    TABLE     �   CREATE TABLE public."Teacher_announcements_To_List" (
    id integer NOT NULL,
    announcements_id integer NOT NULL,
    profile_id integer NOT NULL
);
 3   DROP TABLE public."Teacher_announcements_To_List";
       public         heap    postgres    false            �            1259    27647 $   Teacher_announcements_To_List_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_announcements_To_List_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public."Teacher_announcements_To_List_id_seq";
       public          postgres    false    211            r           0    0 $   Teacher_announcements_To_List_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public."Teacher_announcements_To_List_id_seq" OWNED BY public."Teacher_announcements_To_List".id;
          public          postgres    false    212            �            1259    27649    Teacher_announcements_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_announcements_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public."Teacher_announcements_id_seq";
       public          postgres    false    210            s           0    0    Teacher_announcements_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public."Teacher_announcements_id_seq" OWNED BY public."Teacher_announcements".id;
          public          postgres    false    213            �            1259    27651    Teacher_answer    TABLE     0  CREATE TABLE public."Teacher_answer" (
    id integer NOT NULL,
    content character varying(1000) NOT NULL,
    correct boolean NOT NULL,
    "questionOrderNo" integer NOT NULL,
    "QuizId_id" integer NOT NULL,
    CONSTRAINT "Teacher_answer_questionOrderNo_check" CHECK (("questionOrderNo" >= 0))
);
 $   DROP TABLE public."Teacher_answer";
       public         heap    postgres    false            �            1259    27658    Teacher_answer_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_answer_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public."Teacher_answer_id_seq";
       public          postgres    false    214            t           0    0    Teacher_answer_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public."Teacher_answer_id_seq" OWNED BY public."Teacher_answer".id;
          public          postgres    false    215            �            1259    27660    Teacher_assignment    TABLE       CREATE TABLE public."Teacher_assignment" (
    "CourseId" integer,
    "Assignment_id" integer NOT NULL,
    "Assignment_Name" character varying(200),
    "File" character varying(100),
    "Created_on" timestamp with time zone NOT NULL,
    "ModuleId_id" integer
);
 (   DROP TABLE public."Teacher_assignment";
       public         heap    postgres    false            �            1259    27663 $   Teacher_assignment_Assignment_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_assignment_Assignment_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public."Teacher_assignment_Assignment_id_seq";
       public          postgres    false    216            u           0    0 $   Teacher_assignment_Assignment_id_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public."Teacher_assignment_Assignment_id_seq" OWNED BY public."Teacher_assignment"."Assignment_id";
          public          postgres    false    217            �            1259    27665    Teacher_assignmentupload    TABLE     �  CREATE TABLE public."Teacher_assignmentupload" (
    "AssignmentUpload_id" integer NOT NULL,
    "Assignment_Name" character varying(100),
    "CourseId" character varying(100),
    "InstitutionId" character varying(100),
    "DepartmentId" character varying(100),
    "ModuleId" character varying(100),
    "Upload_Assignment" character varying(100),
    "AssignmentId_id" integer
);
 .   DROP TABLE public."Teacher_assignmentupload";
       public         heap    postgres    false            �            1259    27671 0   Teacher_assignmentupload_AssignmentUpload_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_assignmentupload_AssignmentUpload_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 I   DROP SEQUENCE public."Teacher_assignmentupload_AssignmentUpload_id_seq";
       public          postgres    false    218            v           0    0 0   Teacher_assignmentupload_AssignmentUpload_id_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public."Teacher_assignmentupload_AssignmentUpload_id_seq" OWNED BY public."Teacher_assignmentupload"."AssignmentUpload_id";
          public          postgres    false    219            �            1259    27673    Teacher_category    TABLE     i   CREATE TABLE public."Teacher_category" (
    id integer NOT NULL,
    category character varying(250)
);
 &   DROP TABLE public."Teacher_category";
       public         heap    postgres    false            �            1259    27676    Teacher_category_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_category_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Teacher_category_id_seq";
       public          postgres    false    220            w           0    0    Teacher_category_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Teacher_category_id_seq" OWNED BY public."Teacher_category".id;
          public          postgres    false    221            �            1259    27678    Teacher_course    TABLE     �  CREATE TABLE public."Teacher_course" (
    "isActive" boolean,
    "CourseId" integer NOT NULL,
    "CourseCode" text,
    "Name" text,
    "Description" character varying(100),
    "CourseType" character varying(50),
    "PassingScore" text,
    instid integer,
    "CreatedBy" text,
    "CreatedDate" timestamp with time zone,
    "UpdatedBy" text,
    "UpdatedDate" timestamp with time zone
);
 $   DROP TABLE public."Teacher_course";
       public         heap    postgres    false            �            1259    27684    Teacher_course_AssignToTeacher    TABLE     �   CREATE TABLE public."Teacher_course_AssignToTeacher" (
    id integer NOT NULL,
    course_id integer NOT NULL,
    profile_id integer NOT NULL
);
 4   DROP TABLE public."Teacher_course_AssignToTeacher";
       public         heap    postgres    false            �            1259    27687 %   Teacher_course_AssignToTeacher_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_course_AssignToTeacher_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE public."Teacher_course_AssignToTeacher_id_seq";
       public          postgres    false    223            x           0    0 %   Teacher_course_AssignToTeacher_id_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public."Teacher_course_AssignToTeacher_id_seq" OWNED BY public."Teacher_course_AssignToTeacher".id;
          public          postgres    false    224            �            1259    27689    Teacher_course_CourseId_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_course_CourseId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public."Teacher_course_CourseId_seq";
       public          postgres    false    222            y           0    0    Teacher_course_CourseId_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public."Teacher_course_CourseId_seq" OWNED BY public."Teacher_course"."CourseId";
          public          postgres    false    225            �            1259    27691    Teacher_course_DepartmentId    TABLE     �   CREATE TABLE public."Teacher_course_DepartmentId" (
    id integer NOT NULL,
    course_id integer NOT NULL,
    department_id integer NOT NULL
);
 1   DROP TABLE public."Teacher_course_DepartmentId";
       public         heap    postgres    false            �            1259    27694 "   Teacher_course_DepartmentId_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_course_DepartmentId_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public."Teacher_course_DepartmentId_id_seq";
       public          postgres    false    226            z           0    0 "   Teacher_course_DepartmentId_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public."Teacher_course_DepartmentId_id_seq" OWNED BY public."Teacher_course_DepartmentId".id;
          public          postgres    false    227            �            1259    27696    Teacher_course_EnrollToStudent    TABLE     �   CREATE TABLE public."Teacher_course_EnrollToStudent" (
    id integer NOT NULL,
    course_id integer NOT NULL,
    profile_id integer NOT NULL
);
 4   DROP TABLE public."Teacher_course_EnrollToStudent";
       public         heap    postgres    false            �            1259    27699 %   Teacher_course_EnrollToStudent_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_course_EnrollToStudent_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE public."Teacher_course_EnrollToStudent_id_seq";
       public          postgres    false    228            {           0    0 %   Teacher_course_EnrollToStudent_id_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public."Teacher_course_EnrollToStudent_id_seq" OWNED BY public."Teacher_course_EnrollToStudent".id;
          public          postgres    false    229            �            1259    27701    Teacher_course_InstitutionId    TABLE     �   CREATE TABLE public."Teacher_course_InstitutionId" (
    id integer NOT NULL,
    course_id integer NOT NULL,
    institution_id integer NOT NULL
);
 2   DROP TABLE public."Teacher_course_InstitutionId";
       public         heap    postgres    false            �            1259    27704 #   Teacher_course_InstitutionId_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_course_InstitutionId_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public."Teacher_course_InstitutionId_id_seq";
       public          postgres    false    230            |           0    0 #   Teacher_course_InstitutionId_id_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public."Teacher_course_InstitutionId_id_seq" OWNED BY public."Teacher_course_InstitutionId".id;
          public          postgres    false    231            �            1259    27706    Teacher_courseassessment    TABLE     `  CREATE TABLE public."Teacher_courseassessment" (
    "isActive" boolean,
    "CourseAssessmentId" integer NOT NULL,
    "Score" integer NOT NULL,
    "CreatedBy" text NOT NULL,
    "CreatedDate" timestamp with time zone NOT NULL,
    "UpdatedBy" text NOT NULL,
    "UpdatedDate" timestamp with time zone NOT NULL,
    "CourseId_id" integer NOT NULL
);
 .   DROP TABLE public."Teacher_courseassessment";
       public         heap    postgres    false            �            1259    27712    Teacher_courseregistration    TABLE     �  CREATE TABLE public."Teacher_courseregistration" (
    "isActive" boolean,
    "Student_Name" character varying(100),
    "Instructor_Name" character varying(100),
    "CourseRegistrationId" integer NOT NULL,
    "EnrollmentStatus" text,
    "CreatedBy" text NOT NULL,
    "CreatedDate" timestamp with time zone NOT NULL,
    "UpdatedBy" text NOT NULL,
    "UpdatedDate" timestamp with time zone NOT NULL,
    "CourseId_id" integer NOT NULL,
    "Name_id" integer
);
 0   DROP TABLE public."Teacher_courseregistration";
       public         heap    postgres    false            �            1259    27718    Teacher_coursesyllabus    TABLE     �   CREATE TABLE public."Teacher_coursesyllabus" (
    "Id" integer NOT NULL,
    "syllabusFile" character varying(100),
    "courseId_id" integer NOT NULL
);
 ,   DROP TABLE public."Teacher_coursesyllabus";
       public         heap    postgres    false            �            1259    27721    Teacher_coursesyllabus_Id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_coursesyllabus_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public."Teacher_coursesyllabus_Id_seq";
       public          postgres    false    234            }           0    0    Teacher_coursesyllabus_Id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public."Teacher_coursesyllabus_Id_seq" OWNED BY public."Teacher_coursesyllabus"."Id";
          public          postgres    false    235            �            1259    27723    Teacher_csvupload    TABLE     �   CREATE TABLE public."Teacher_csvupload" (
    id integer NOT NULL,
    title character varying(100) NOT NULL,
    file character varying(100) NOT NULL,
    completed boolean NOT NULL,
    user_id integer NOT NULL
);
 '   DROP TABLE public."Teacher_csvupload";
       public         heap    postgres    false            �            1259    27726    Teacher_csvupload_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_csvupload_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public."Teacher_csvupload_id_seq";
       public          postgres    false    236            ~           0    0    Teacher_csvupload_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public."Teacher_csvupload_id_seq" OWNED BY public."Teacher_csvupload".id;
          public          postgres    false    237            �            1259    27728    Teacher_email    TABLE     �  CREATE TABLE public."Teacher_email" (
    "EmailId" integer NOT NULL,
    "Title" text NOT NULL,
    "Subject" text NOT NULL,
    "Content" character varying(500) NOT NULL,
    "CreatedOn" timestamp with time zone NOT NULL,
    "CreatedBy" text NOT NULL,
    "ModifiedOn" timestamp with time zone NOT NULL,
    "ModifiedBy" text NOT NULL,
    status boolean NOT NULL,
    "readStatus" boolean NOT NULL,
    "AttachFile" character varying(100) NOT NULL,
    "Email_From_id" integer
);
 #   DROP TABLE public."Teacher_email";
       public         heap    postgres    false            �            1259    27734    Teacher_email_BCC    TABLE     �   CREATE TABLE public."Teacher_email_BCC" (
    id integer NOT NULL,
    email_id integer NOT NULL,
    profile_id integer NOT NULL
);
 '   DROP TABLE public."Teacher_email_BCC";
       public         heap    postgres    false            �            1259    27737    Teacher_email_BCC_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_email_BCC_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public."Teacher_email_BCC_id_seq";
       public          postgres    false    239                       0    0    Teacher_email_BCC_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public."Teacher_email_BCC_id_seq" OWNED BY public."Teacher_email_BCC".id;
          public          postgres    false    240            �            1259    27739    Teacher_email_CC    TABLE     �   CREATE TABLE public."Teacher_email_CC" (
    id integer NOT NULL,
    email_id integer NOT NULL,
    profile_id integer NOT NULL
);
 &   DROP TABLE public."Teacher_email_CC";
       public         heap    postgres    false            �            1259    27742    Teacher_email_CC_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_email_CC_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Teacher_email_CC_id_seq";
       public          postgres    false    241            �           0    0    Teacher_email_CC_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Teacher_email_CC_id_seq" OWNED BY public."Teacher_email_CC".id;
          public          postgres    false    242            �            1259    27744    Teacher_email_EmailId_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_email_EmailId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public."Teacher_email_EmailId_seq";
       public          postgres    false    238            �           0    0    Teacher_email_EmailId_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public."Teacher_email_EmailId_seq" OWNED BY public."Teacher_email"."EmailId";
          public          postgres    false    243            �            1259    27746    Teacher_email_Email_To    TABLE     �   CREATE TABLE public."Teacher_email_Email_To" (
    id integer NOT NULL,
    email_id integer NOT NULL,
    profile_id integer NOT NULL
);
 ,   DROP TABLE public."Teacher_email_Email_To";
       public         heap    postgres    false            �            1259    27749    Teacher_email_Email_To_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_email_Email_To_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public."Teacher_email_Email_To_id_seq";
       public          postgres    false    244            �           0    0    Teacher_email_Email_To_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public."Teacher_email_Email_To_id_seq" OWNED BY public."Teacher_email_Email_To".id;
          public          postgres    false    245            �            1259    27751    Teacher_folder    TABLE     }   CREATE TABLE public."Teacher_folder" (
    "FolderId" integer NOT NULL,
    "Name" text NOT NULL,
    "UserId_id" integer
);
 $   DROP TABLE public."Teacher_folder";
       public         heap    postgres    false            �            1259    27757    Teacher_folder_FolderId_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_folder_FolderId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public."Teacher_folder_FolderId_seq";
       public          postgres    false    246            �           0    0    Teacher_folder_FolderId_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public."Teacher_folder_FolderId_seq" OWNED BY public."Teacher_folder"."FolderId";
          public          postgres    false    247            �            1259    27759    Teacher_module    TABLE     �  CREATE TABLE public."Teacher_module" (
    "isActive" boolean,
    "ModuleId" integer NOT NULL,
    "Name" text NOT NULL,
    "Description" character varying(100) NOT NULL,
    "StartDate" date,
    "EndDate" date,
    course integer,
    "ModuleOrderNo" integer,
    "CreatedBy" text,
    "CreatedDate" timestamp with time zone NOT NULL,
    "UpdatedBy" text,
    "UpdatedDate" timestamp with time zone NOT NULL,
    "CourseId_id" integer
);
 $   DROP TABLE public."Teacher_module";
       public         heap    postgres    false            �            1259    27765    Teacher_module_ModuleId_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_module_ModuleId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public."Teacher_module_ModuleId_seq";
       public          postgres    false    248            �           0    0    Teacher_module_ModuleId_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public."Teacher_module_ModuleId_seq" OWNED BY public."Teacher_module"."ModuleId";
          public          postgres    false    249            �            1259    27767    Teacher_modulefile    TABLE     M  CREATE TABLE public."Teacher_modulefile" (
    "isActive" boolean,
    id integer NOT NULL,
    "File" text,
    "FileOrderNo" integer,
    "CreatedBy" text NOT NULL,
    "CreatedDate" timestamp with time zone NOT NULL,
    "UpdatedBy" text NOT NULL,
    "UpdatedDate" timestamp with time zone NOT NULL,
    "ModuleId_id" integer
);
 (   DROP TABLE public."Teacher_modulefile";
       public         heap    postgres    false            �            1259    27773    Teacher_modulefile_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_modulefile_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public."Teacher_modulefile_id_seq";
       public          postgres    false    250            �           0    0    Teacher_modulefile_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public."Teacher_modulefile_id_seq" OWNED BY public."Teacher_modulefile".id;
          public          postgres    false    251            �            1259    27775    Teacher_modulefilecontent    TABLE       CREATE TABLE public."Teacher_modulefilecontent" (
    "isActive" boolean,
    id integer NOT NULL,
    "Slide" text,
    "SlideOrderNo" integer,
    "TextContent" text,
    "SlideText" character varying(100),
    "SlideImage" character varying(100),
    "SlideVideos" character varying(100),
    "SlideAudio" character varying(100),
    "CreatedBy" text NOT NULL,
    "CreatedDate" timestamp with time zone NOT NULL,
    "UpdatedBy" text NOT NULL,
    "UpdatedDate" timestamp with time zone NOT NULL,
    "ModuleFileId_id" integer
);
 /   DROP TABLE public."Teacher_modulefilecontent";
       public         heap    postgres    false            �            1259    27781     Teacher_modulefilecontent_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_modulefilecontent_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public."Teacher_modulefilecontent_id_seq";
       public          postgres    false    252            �           0    0     Teacher_modulefilecontent_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public."Teacher_modulefilecontent_id_seq" OWNED BY public."Teacher_modulefilecontent".id;
          public          postgres    false    253            �            1259    27783    Teacher_modulesyllabus    TABLE     7  CREATE TABLE public."Teacher_modulesyllabus" (
    "Id" integer NOT NULL,
    "oneDriveLink" character varying(1000),
    "syllabusFile" character varying(100),
    "imgFilePath" character varying(1000),
    "imgCount" integer NOT NULL,
    "fileOrderNo" integer NOT NULL,
    "courseId_id" integer NOT NULL
);
 ,   DROP TABLE public."Teacher_modulesyllabus";
       public         heap    postgres    false            �            1259    27789    Teacher_modulesyllabus_Id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_modulesyllabus_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public."Teacher_modulesyllabus_Id_seq";
       public          postgres    false    254            �           0    0    Teacher_modulesyllabus_Id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public."Teacher_modulesyllabus_Id_seq" OWNED BY public."Teacher_modulesyllabus"."Id";
          public          postgres    false    255                        1259    27791    Teacher_progress    TABLE     �   CREATE TABLE public."Teacher_progress" (
    id integer NOT NULL,
    score character varying(1024) NOT NULL,
    correct_answer character varying(10) NOT NULL,
    wrong_answer character varying(10) NOT NULL,
    user_id integer NOT NULL
);
 &   DROP TABLE public."Teacher_progress";
       public         heap    postgres    false                       1259    27797    Teacher_progress_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_progress_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Teacher_progress_id_seq";
       public          postgres    false    256            �           0    0    Teacher_progress_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Teacher_progress_id_seq" OWNED BY public."Teacher_progress".id;
          public          postgres    false    257                       1259    27799    Teacher_question    TABLE     �  CREATE TABLE public."Teacher_question" (
    id integer NOT NULL,
    figure character varying(100),
    content character varying(1000) NOT NULL,
    explanation text NOT NULL,
    "questionOrderNo" integer NOT NULL,
    "isMCQ" boolean NOT NULL,
    "QuizId_id" integer NOT NULL,
    category_id integer,
    CONSTRAINT "Teacher_question_questionOrderNo_check" CHECK (("questionOrderNo" >= 0))
);
 &   DROP TABLE public."Teacher_question";
       public         heap    postgres    false                       1259    27806    Teacher_question_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_question_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Teacher_question_id_seq";
       public          postgres    false    258            �           0    0    Teacher_question_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Teacher_question_id_seq" OWNED BY public."Teacher_question".id;
          public          postgres    false    259                       1259    27808    Teacher_quiz    TABLE     �  CREATE TABLE public."Teacher_quiz" (
    "QuizId" integer NOT NULL,
    title character varying(60) NOT NULL,
    description text NOT NULL,
    url character varying(60) NOT NULL,
    random_order boolean NOT NULL,
    max_questions integer,
    answers_at_end boolean NOT NULL,
    exam_paper boolean NOT NULL,
    single_attempt boolean NOT NULL,
    pass_mark smallint NOT NULL,
    success_text text NOT NULL,
    fail_text text NOT NULL,
    draft boolean NOT NULL,
    "quizOrderNo" integer NOT NULL,
    "CourseId_id" integer NOT NULL,
    "Module_id" integer,
    category_id integer,
    CONSTRAINT "Teacher_quiz_max_questions_check" CHECK ((max_questions >= 0)),
    CONSTRAINT "Teacher_quiz_quizOrderNo_check" CHECK (("quizOrderNo" >= 0))
);
 "   DROP TABLE public."Teacher_quiz";
       public         heap    postgres    false                       1259    27816    Teacher_quiz_QuizId_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_quiz_QuizId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Teacher_quiz_QuizId_seq";
       public          postgres    false    260            �           0    0    Teacher_quiz_QuizId_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public."Teacher_quiz_QuizId_seq" OWNED BY public."Teacher_quiz"."QuizId";
          public          postgres    false    261                       1259    27818    Teacher_sitting    TABLE     �  CREATE TABLE public."Teacher_sitting" (
    id integer NOT NULL,
    question_order character varying(1024) NOT NULL,
    question_list character varying(1024) NOT NULL,
    incorrect_questions character varying(1024) NOT NULL,
    current_score integer NOT NULL,
    complete boolean NOT NULL,
    user_answers text NOT NULL,
    start timestamp with time zone NOT NULL,
    "end" timestamp with time zone,
    quiz_id integer NOT NULL,
    user_id integer NOT NULL
);
 %   DROP TABLE public."Teacher_sitting";
       public         heap    postgres    false                       1259    27824    Teacher_sitting_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_sitting_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public."Teacher_sitting_id_seq";
       public          postgres    false    262            �           0    0    Teacher_sitting_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public."Teacher_sitting_id_seq" OWNED BY public."Teacher_sitting".id;
          public          postgres    false    263                       1259    27826    Teacher_studentcourseprogress    TABLE     3  CREATE TABLE public."Teacher_studentcourseprogress" (
    id integer NOT NULL,
    "Grade" numeric(5,2) NOT NULL,
    "CurrentModuleNo" integer NOT NULL,
    "CurrentUnitNo" integer NOT NULL,
    "CurrentAssignNo" integer NOT NULL,
    "CourseId_id" integer NOT NULL,
    "StudentId_id" integer NOT NULL
);
 3   DROP TABLE public."Teacher_studentcourseprogress";
       public         heap    postgres    false            	           1259    27829 $   Teacher_studentcourseprogress_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_studentcourseprogress_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public."Teacher_studentcourseprogress_id_seq";
       public          postgres    false    264            �           0    0 $   Teacher_studentcourseprogress_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public."Teacher_studentcourseprogress_id_seq" OWNED BY public."Teacher_studentcourseprogress".id;
          public          postgres    false    265            
           1259    27831 !   Teacher_studentmodulefileprogress    TABLE       CREATE TABLE public."Teacher_studentmodulefileprogress" (
    id integer NOT NULL,
    "fileCompleted" boolean NOT NULL,
    "CurrentFilePageNo" integer NOT NULL,
    "FileId_id" integer NOT NULL,
    "ModuleId_id" integer NOT NULL,
    "StudentId_id" integer NOT NULL
);
 7   DROP TABLE public."Teacher_studentmodulefileprogress";
       public         heap    postgres    false                       1259    27834 (   Teacher_studentmodulefileprogress_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_studentmodulefileprogress_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 A   DROP SEQUENCE public."Teacher_studentmodulefileprogress_id_seq";
       public          postgres    false    266            �           0    0 (   Teacher_studentmodulefileprogress_id_seq    SEQUENCE OWNED BY     y   ALTER SEQUENCE public."Teacher_studentmodulefileprogress_id_seq" OWNED BY public."Teacher_studentmodulefileprogress".id;
          public          postgres    false    267                       1259    27836    Teacher_studentmoduleprogress    TABLE     �   CREATE TABLE public."Teacher_studentmoduleprogress" (
    id integer NOT NULL,
    "CurrentFileNo" integer NOT NULL,
    "CurrentQuizNo" integer NOT NULL,
    "ModuleId_id" integer NOT NULL,
    "StudentId_id" integer NOT NULL
);
 3   DROP TABLE public."Teacher_studentmoduleprogress";
       public         heap    postgres    false                       1259    27839 $   Teacher_studentmoduleprogress_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_studentmoduleprogress_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public."Teacher_studentmoduleprogress_id_seq";
       public          postgres    false    268            �           0    0 $   Teacher_studentmoduleprogress_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public."Teacher_studentmoduleprogress_id_seq" OWNED BY public."Teacher_studentmoduleprogress".id;
          public          postgres    false    269                       1259    27841    Teacher_studentquizprogress    TABLE     W  CREATE TABLE public."Teacher_studentquizprogress" (
    id integer NOT NULL,
    score numeric(5,2) NOT NULL,
    completed boolean NOT NULL,
    num_attempts integer NOT NULL,
    "QuizId_id" integer NOT NULL,
    "StudentId_id" integer NOT NULL,
    CONSTRAINT "Teacher_studentquizprogress_num_attempts_check" CHECK ((num_attempts >= 0))
);
 1   DROP TABLE public."Teacher_studentquizprogress";
       public         heap    postgres    false                       1259    27845 "   Teacher_studentquizprogress_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_studentquizprogress_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public."Teacher_studentquizprogress_id_seq";
       public          postgres    false    270            �           0    0 "   Teacher_studentquizprogress_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public."Teacher_studentquizprogress_id_seq" OWNED BY public."Teacher_studentquizprogress".id;
          public          postgres    false    271                       1259    27847    Teacher_units    TABLE     �  CREATE TABLE public."Teacher_units" (
    "isActive" boolean,
    "UnitId" integer NOT NULL,
    "Name" text NOT NULL,
    "Description" character varying(100) NOT NULL,
    "StartDate" date,
    "EndDate" date,
    "File" character varying(100) NOT NULL,
    "CreatedBy" text,
    "CreatedDate" timestamp with time zone NOT NULL,
    "UpdatedBy" text,
    "UpdatedDate" timestamp with time zone NOT NULL,
    "CourseId_id" integer,
    "ModuleId_id" integer
);
 #   DROP TABLE public."Teacher_units";
       public         heap    postgres    false                       1259    27853    Teacher_units_UnitId_seq    SEQUENCE     �   CREATE SEQUENCE public."Teacher_units_UnitId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public."Teacher_units_UnitId_seq";
       public          postgres    false    272            �           0    0    Teacher_units_UnitId_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public."Teacher_units_UnitId_seq" OWNED BY public."Teacher_units"."UnitId";
          public          postgres    false    273                       1259    27855 
   auth_group    TABLE     f   CREATE TABLE public.auth_group (
    id integer NOT NULL,
    name character varying(150) NOT NULL
);
    DROP TABLE public.auth_group;
       public         heap    postgres    false                       1259    27858    auth_group_id_seq    SEQUENCE     z   CREATE SEQUENCE public.auth_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.auth_group_id_seq;
       public          postgres    false    274            �           0    0    auth_group_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.auth_group_id_seq OWNED BY public.auth_group.id;
          public          postgres    false    275                       1259    27860    auth_group_permissions    TABLE     �   CREATE TABLE public.auth_group_permissions (
    id integer NOT NULL,
    group_id integer NOT NULL,
    permission_id integer NOT NULL
);
 *   DROP TABLE public.auth_group_permissions;
       public         heap    postgres    false                       1259    27863    auth_group_permissions_id_seq    SEQUENCE     �   CREATE SEQUENCE public.auth_group_permissions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.auth_group_permissions_id_seq;
       public          postgres    false    276            �           0    0    auth_group_permissions_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.auth_group_permissions_id_seq OWNED BY public.auth_group_permissions.id;
          public          postgres    false    277                       1259    27865    auth_permission    TABLE     �   CREATE TABLE public.auth_permission (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    content_type_id integer NOT NULL,
    codename character varying(100) NOT NULL
);
 #   DROP TABLE public.auth_permission;
       public         heap    postgres    false                       1259    27868    auth_permission_id_seq    SEQUENCE        CREATE SEQUENCE public.auth_permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.auth_permission_id_seq;
       public          postgres    false    278            �           0    0    auth_permission_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.auth_permission_id_seq OWNED BY public.auth_permission.id;
          public          postgres    false    279                       1259    27870 	   auth_user    TABLE     �  CREATE TABLE public.auth_user (
    id integer NOT NULL,
    password character varying(128) NOT NULL,
    last_login timestamp with time zone,
    is_superuser boolean NOT NULL,
    username character varying(150) NOT NULL,
    first_name character varying(150) NOT NULL,
    last_name character varying(150) NOT NULL,
    email character varying(254) NOT NULL,
    is_staff boolean NOT NULL,
    is_active boolean NOT NULL,
    date_joined timestamp with time zone NOT NULL
);
    DROP TABLE public.auth_user;
       public         heap    postgres    false                       1259    27876    auth_user_groups    TABLE        CREATE TABLE public.auth_user_groups (
    id integer NOT NULL,
    user_id integer NOT NULL,
    group_id integer NOT NULL
);
 $   DROP TABLE public.auth_user_groups;
       public         heap    postgres    false                       1259    27879    auth_user_groups_id_seq    SEQUENCE     �   CREATE SEQUENCE public.auth_user_groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.auth_user_groups_id_seq;
       public          postgres    false    281            �           0    0    auth_user_groups_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.auth_user_groups_id_seq OWNED BY public.auth_user_groups.id;
          public          postgres    false    282                       1259    27881    auth_user_id_seq    SEQUENCE     y   CREATE SEQUENCE public.auth_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.auth_user_id_seq;
       public          postgres    false    280            �           0    0    auth_user_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.auth_user_id_seq OWNED BY public.auth_user.id;
          public          postgres    false    283                       1259    27883    auth_user_user_permissions    TABLE     �   CREATE TABLE public.auth_user_user_permissions (
    id integer NOT NULL,
    user_id integer NOT NULL,
    permission_id integer NOT NULL
);
 .   DROP TABLE public.auth_user_user_permissions;
       public         heap    postgres    false                       1259    27886 !   auth_user_user_permissions_id_seq    SEQUENCE     �   CREATE SEQUENCE public.auth_user_user_permissions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.auth_user_user_permissions_id_seq;
       public          postgres    false    284            �           0    0 !   auth_user_user_permissions_id_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.auth_user_user_permissions_id_seq OWNED BY public.auth_user_user_permissions.id;
          public          postgres    false    285                       1259    27888    django_admin_log    TABLE     �  CREATE TABLE public.django_admin_log (
    id integer NOT NULL,
    action_time timestamp with time zone NOT NULL,
    object_id text,
    object_repr character varying(200) NOT NULL,
    action_flag smallint NOT NULL,
    change_message text NOT NULL,
    content_type_id integer,
    user_id integer NOT NULL,
    CONSTRAINT django_admin_log_action_flag_check CHECK ((action_flag >= 0))
);
 $   DROP TABLE public.django_admin_log;
       public         heap    postgres    false                       1259    27895    django_admin_log_id_seq    SEQUENCE     �   CREATE SEQUENCE public.django_admin_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.django_admin_log_id_seq;
       public          postgres    false    286            �           0    0    django_admin_log_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.django_admin_log_id_seq OWNED BY public.django_admin_log.id;
          public          postgres    false    287                        1259    27897    django_content_type    TABLE     �   CREATE TABLE public.django_content_type (
    id integer NOT NULL,
    app_label character varying(100) NOT NULL,
    model character varying(100) NOT NULL
);
 '   DROP TABLE public.django_content_type;
       public         heap    postgres    false            !           1259    27900    django_content_type_id_seq    SEQUENCE     �   CREATE SEQUENCE public.django_content_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.django_content_type_id_seq;
       public          postgres    false    288            �           0    0    django_content_type_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.django_content_type_id_seq OWNED BY public.django_content_type.id;
          public          postgres    false    289            "           1259    27902    django_migrations    TABLE     �   CREATE TABLE public.django_migrations (
    id integer NOT NULL,
    app character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    applied timestamp with time zone NOT NULL
);
 %   DROP TABLE public.django_migrations;
       public         heap    postgres    false            #           1259    27908    django_migrations_id_seq    SEQUENCE     �   CREATE SEQUENCE public.django_migrations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.django_migrations_id_seq;
       public          postgres    false    290            �           0    0    django_migrations_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.django_migrations_id_seq OWNED BY public.django_migrations.id;
          public          postgres    false    291            $           1259    27910    django_session    TABLE     �   CREATE TABLE public.django_session (
    session_key character varying(40) NOT NULL,
    session_data text NOT NULL,
    expire_date timestamp with time zone NOT NULL
);
 "   DROP TABLE public.django_session;
       public         heap    postgres    false            P           2604    27916    Admin_department DepartmentId    DEFAULT     �   ALTER TABLE ONLY public."Admin_department" ALTER COLUMN "DepartmentId" SET DEFAULT nextval('public."Admin_department_DepartmentId_seq"'::regclass);
 P   ALTER TABLE public."Admin_department" ALTER COLUMN "DepartmentId" DROP DEFAULT;
       public          postgres    false    201    200            Q           2604    27917    Admin_institution InstitutionId    DEFAULT     �   ALTER TABLE ONLY public."Admin_institution" ALTER COLUMN "InstitutionId" SET DEFAULT nextval('public."Admin_institution_InstitutionId_seq"'::regclass);
 R   ALTER TABLE public."Admin_institution" ALTER COLUMN "InstitutionId" DROP DEFAULT;
       public          postgres    false    203    202            R           2604    27918    Admin_role RoleId    DEFAULT     |   ALTER TABLE ONLY public."Admin_role" ALTER COLUMN "RoleId" SET DEFAULT nextval('public."Admin_role_RoleId_seq"'::regclass);
 D   ALTER TABLE public."Admin_role" ALTER COLUMN "RoleId" DROP DEFAULT;
       public          postgres    false    205    204            S           2604    27919    Admin_userinstitutionmap Id    DEFAULT     �   ALTER TABLE ONLY public."Admin_userinstitutionmap" ALTER COLUMN "Id" SET DEFAULT nextval('public."Admin_userinstitutionmap_Id_seq"'::regclass);
 N   ALTER TABLE public."Admin_userinstitutionmap" ALTER COLUMN "Id" DROP DEFAULT;
       public          postgres    false    207    206            U           2604    27921    Teacher_announcements id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_announcements" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_announcements_id_seq"'::regclass);
 I   ALTER TABLE public."Teacher_announcements" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    210            V           2604    27922     Teacher_announcements_To_List id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_announcements_To_List" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_announcements_To_List_id_seq"'::regclass);
 Q   ALTER TABLE public."Teacher_announcements_To_List" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211            W           2604    27923    Teacher_answer id    DEFAULT     z   ALTER TABLE ONLY public."Teacher_answer" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_answer_id_seq"'::regclass);
 B   ALTER TABLE public."Teacher_answer" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214            Y           2604    27924     Teacher_assignment Assignment_id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_assignment" ALTER COLUMN "Assignment_id" SET DEFAULT nextval('public."Teacher_assignment_Assignment_id_seq"'::regclass);
 S   ALTER TABLE public."Teacher_assignment" ALTER COLUMN "Assignment_id" DROP DEFAULT;
       public          postgres    false    217    216            Z           2604    27925 ,   Teacher_assignmentupload AssignmentUpload_id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_assignmentupload" ALTER COLUMN "AssignmentUpload_id" SET DEFAULT nextval('public."Teacher_assignmentupload_AssignmentUpload_id_seq"'::regclass);
 _   ALTER TABLE public."Teacher_assignmentupload" ALTER COLUMN "AssignmentUpload_id" DROP DEFAULT;
       public          postgres    false    219    218            [           2604    27926    Teacher_category id    DEFAULT     ~   ALTER TABLE ONLY public."Teacher_category" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_category_id_seq"'::regclass);
 D   ALTER TABLE public."Teacher_category" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220            \           2604    27927    Teacher_course CourseId    DEFAULT     �   ALTER TABLE ONLY public."Teacher_course" ALTER COLUMN "CourseId" SET DEFAULT nextval('public."Teacher_course_CourseId_seq"'::regclass);
 J   ALTER TABLE public."Teacher_course" ALTER COLUMN "CourseId" DROP DEFAULT;
       public          postgres    false    225    222            ]           2604    27928 !   Teacher_course_AssignToTeacher id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_course_AssignToTeacher_id_seq"'::regclass);
 R   ALTER TABLE public."Teacher_course_AssignToTeacher" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223            ^           2604    27929    Teacher_course_DepartmentId id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_course_DepartmentId" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_course_DepartmentId_id_seq"'::regclass);
 O   ALTER TABLE public."Teacher_course_DepartmentId" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    227    226            _           2604    27930 !   Teacher_course_EnrollToStudent id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_course_EnrollToStudent_id_seq"'::regclass);
 R   ALTER TABLE public."Teacher_course_EnrollToStudent" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    229    228            `           2604    27931    Teacher_course_InstitutionId id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_course_InstitutionId" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_course_InstitutionId_id_seq"'::regclass);
 P   ALTER TABLE public."Teacher_course_InstitutionId" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    231    230            a           2604    27932    Teacher_coursesyllabus Id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_coursesyllabus" ALTER COLUMN "Id" SET DEFAULT nextval('public."Teacher_coursesyllabus_Id_seq"'::regclass);
 L   ALTER TABLE public."Teacher_coursesyllabus" ALTER COLUMN "Id" DROP DEFAULT;
       public          postgres    false    235    234            b           2604    27933    Teacher_csvupload id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_csvupload" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_csvupload_id_seq"'::regclass);
 E   ALTER TABLE public."Teacher_csvupload" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    237    236            c           2604    27934    Teacher_email EmailId    DEFAULT     �   ALTER TABLE ONLY public."Teacher_email" ALTER COLUMN "EmailId" SET DEFAULT nextval('public."Teacher_email_EmailId_seq"'::regclass);
 H   ALTER TABLE public."Teacher_email" ALTER COLUMN "EmailId" DROP DEFAULT;
       public          postgres    false    243    238            d           2604    27935    Teacher_email_BCC id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_email_BCC" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_email_BCC_id_seq"'::regclass);
 E   ALTER TABLE public."Teacher_email_BCC" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    240    239            e           2604    27936    Teacher_email_CC id    DEFAULT     ~   ALTER TABLE ONLY public."Teacher_email_CC" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_email_CC_id_seq"'::regclass);
 D   ALTER TABLE public."Teacher_email_CC" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    242    241            f           2604    27937    Teacher_email_Email_To id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_email_Email_To" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_email_Email_To_id_seq"'::regclass);
 J   ALTER TABLE public."Teacher_email_Email_To" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    245    244            g           2604    27938    Teacher_folder FolderId    DEFAULT     �   ALTER TABLE ONLY public."Teacher_folder" ALTER COLUMN "FolderId" SET DEFAULT nextval('public."Teacher_folder_FolderId_seq"'::regclass);
 J   ALTER TABLE public."Teacher_folder" ALTER COLUMN "FolderId" DROP DEFAULT;
       public          postgres    false    247    246            h           2604    27939    Teacher_module ModuleId    DEFAULT     �   ALTER TABLE ONLY public."Teacher_module" ALTER COLUMN "ModuleId" SET DEFAULT nextval('public."Teacher_module_ModuleId_seq"'::regclass);
 J   ALTER TABLE public."Teacher_module" ALTER COLUMN "ModuleId" DROP DEFAULT;
       public          postgres    false    249    248            i           2604    27940    Teacher_modulefile id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_modulefile" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_modulefile_id_seq"'::regclass);
 F   ALTER TABLE public."Teacher_modulefile" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    251    250            j           2604    27941    Teacher_modulefilecontent id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_modulefilecontent" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_modulefilecontent_id_seq"'::regclass);
 M   ALTER TABLE public."Teacher_modulefilecontent" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    253    252            k           2604    27942    Teacher_modulesyllabus Id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_modulesyllabus" ALTER COLUMN "Id" SET DEFAULT nextval('public."Teacher_modulesyllabus_Id_seq"'::regclass);
 L   ALTER TABLE public."Teacher_modulesyllabus" ALTER COLUMN "Id" DROP DEFAULT;
       public          postgres    false    255    254            l           2604    27943    Teacher_progress id    DEFAULT     ~   ALTER TABLE ONLY public."Teacher_progress" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_progress_id_seq"'::regclass);
 D   ALTER TABLE public."Teacher_progress" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    257    256            m           2604    27944    Teacher_question id    DEFAULT     ~   ALTER TABLE ONLY public."Teacher_question" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_question_id_seq"'::regclass);
 D   ALTER TABLE public."Teacher_question" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    259    258            o           2604    27945    Teacher_quiz QuizId    DEFAULT     �   ALTER TABLE ONLY public."Teacher_quiz" ALTER COLUMN "QuizId" SET DEFAULT nextval('public."Teacher_quiz_QuizId_seq"'::regclass);
 F   ALTER TABLE public."Teacher_quiz" ALTER COLUMN "QuizId" DROP DEFAULT;
       public          postgres    false    261    260            r           2604    27946    Teacher_sitting id    DEFAULT     |   ALTER TABLE ONLY public."Teacher_sitting" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_sitting_id_seq"'::regclass);
 C   ALTER TABLE public."Teacher_sitting" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    263    262            s           2604    27947     Teacher_studentcourseprogress id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_studentcourseprogress" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_studentcourseprogress_id_seq"'::regclass);
 Q   ALTER TABLE public."Teacher_studentcourseprogress" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    265    264            t           2604    27948 $   Teacher_studentmodulefileprogress id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_studentmodulefileprogress_id_seq"'::regclass);
 U   ALTER TABLE public."Teacher_studentmodulefileprogress" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    267    266            u           2604    27949     Teacher_studentmoduleprogress id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_studentmoduleprogress" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_studentmoduleprogress_id_seq"'::regclass);
 Q   ALTER TABLE public."Teacher_studentmoduleprogress" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    269    268            v           2604    27950    Teacher_studentquizprogress id    DEFAULT     �   ALTER TABLE ONLY public."Teacher_studentquizprogress" ALTER COLUMN id SET DEFAULT nextval('public."Teacher_studentquizprogress_id_seq"'::regclass);
 O   ALTER TABLE public."Teacher_studentquizprogress" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    271    270            x           2604    27951    Teacher_units UnitId    DEFAULT     �   ALTER TABLE ONLY public."Teacher_units" ALTER COLUMN "UnitId" SET DEFAULT nextval('public."Teacher_units_UnitId_seq"'::regclass);
 G   ALTER TABLE public."Teacher_units" ALTER COLUMN "UnitId" DROP DEFAULT;
       public          postgres    false    273    272            y           2604    27952    auth_group id    DEFAULT     n   ALTER TABLE ONLY public.auth_group ALTER COLUMN id SET DEFAULT nextval('public.auth_group_id_seq'::regclass);
 <   ALTER TABLE public.auth_group ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    275    274            z           2604    27953    auth_group_permissions id    DEFAULT     �   ALTER TABLE ONLY public.auth_group_permissions ALTER COLUMN id SET DEFAULT nextval('public.auth_group_permissions_id_seq'::regclass);
 H   ALTER TABLE public.auth_group_permissions ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    277    276            {           2604    27954    auth_permission id    DEFAULT     x   ALTER TABLE ONLY public.auth_permission ALTER COLUMN id SET DEFAULT nextval('public.auth_permission_id_seq'::regclass);
 A   ALTER TABLE public.auth_permission ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    279    278            |           2604    27955    auth_user id    DEFAULT     l   ALTER TABLE ONLY public.auth_user ALTER COLUMN id SET DEFAULT nextval('public.auth_user_id_seq'::regclass);
 ;   ALTER TABLE public.auth_user ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    283    280            }           2604    27956    auth_user_groups id    DEFAULT     z   ALTER TABLE ONLY public.auth_user_groups ALTER COLUMN id SET DEFAULT nextval('public.auth_user_groups_id_seq'::regclass);
 B   ALTER TABLE public.auth_user_groups ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    282    281            ~           2604    27957    auth_user_user_permissions id    DEFAULT     �   ALTER TABLE ONLY public.auth_user_user_permissions ALTER COLUMN id SET DEFAULT nextval('public.auth_user_user_permissions_id_seq'::regclass);
 L   ALTER TABLE public.auth_user_user_permissions ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    285    284                       2604    27958    django_admin_log id    DEFAULT     z   ALTER TABLE ONLY public.django_admin_log ALTER COLUMN id SET DEFAULT nextval('public.django_admin_log_id_seq'::regclass);
 B   ALTER TABLE public.django_admin_log ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    287    286            �           2604    27959    django_content_type id    DEFAULT     �   ALTER TABLE ONLY public.django_content_type ALTER COLUMN id SET DEFAULT nextval('public.django_content_type_id_seq'::regclass);
 E   ALTER TABLE public.django_content_type ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    289    288            �           2604    27960    django_migrations id    DEFAULT     |   ALTER TABLE ONLY public.django_migrations ALTER COLUMN id SET DEFAULT nextval('public.django_migrations_id_seq'::regclass);
 C   ALTER TABLE public.django_migrations ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    291    290            T           2604    27920    instituteadmin_profile id    DEFAULT     �   ALTER TABLE ONLY public.instituteadmin_profile ALTER COLUMN id SET DEFAULT nextval('public."InstituteAdmin_profile_id_seq"'::regclass);
 H   ALTER TABLE public.instituteadmin_profile ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208            
          0    27598    Admin_department 
   TABLE DATA           �   COPY public."Admin_department" ("isActive", "DepartmentId", "Name", "Description", "CreatedBy", "CreatedOn", "ModifiedBy", "ModifiedOn", "InstitutionId_id") FROM stdin;
    public          postgres    false    200   r�                0    27606    Admin_institution 
   TABLE DATA           �   COPY public."Admin_institution" ("isActive", "InstitutionId", "Name", "Description", "CreatedBy", "CreatedOn", "ModifiedBy", "ModifiedOn", picture) FROM stdin;
    public          postgres    false    202   Թ                0    27614 
   Admin_role 
   TABLE DATA           �   COPY public."Admin_role" ("isActive", "RoleId", "RoleName", "RoleDescription", "CreatedBy", "CreatedOn", "ModifiedBy", "ModifiedOn") FROM stdin;
    public          postgres    false    204   T�                0    27622    Admin_userinstitutionmap 
   TABLE DATA           �   COPY public."Admin_userinstitutionmap" ("isActive", "Id", "CreatedBy", "CreatedOn", "ModifiedBy", "ModifiedOn", "InstitutionId_id") FROM stdin;
    public          postgres    false    206   q�                0    27638    Teacher_announcements 
   TABLE DATA           �   COPY public."Teacher_announcements" (id, "Announcement_title", "Announcement_message", "To", "ReadBy", "CreatedBy", "Created_On") FROM stdin;
    public          postgres    false    210   ��                0    27644    Teacher_announcements_To_List 
   TABLE DATA           [   COPY public."Teacher_announcements_To_List" (id, announcements_id, profile_id) FROM stdin;
    public          postgres    false    211   �                0    27651    Teacher_answer 
   TABLE DATA           `   COPY public."Teacher_answer" (id, content, correct, "questionOrderNo", "QuizId_id") FROM stdin;
    public          postgres    false    214   �                0    27660    Teacher_assignment 
   TABLE DATA           �   COPY public."Teacher_assignment" ("CourseId", "Assignment_id", "Assignment_Name", "File", "Created_on", "ModuleId_id") FROM stdin;
    public          postgres    false    216   ͻ                0    27665    Teacher_assignmentupload 
   TABLE DATA           �   COPY public."Teacher_assignmentupload" ("AssignmentUpload_id", "Assignment_Name", "CourseId", "InstitutionId", "DepartmentId", "ModuleId", "Upload_Assignment", "AssignmentId_id") FROM stdin;
    public          postgres    false    218   �                0    27673    Teacher_category 
   TABLE DATA           :   COPY public."Teacher_category" (id, category) FROM stdin;
    public          postgres    false    220   �                 0    27678    Teacher_course 
   TABLE DATA           �   COPY public."Teacher_course" ("isActive", "CourseId", "CourseCode", "Name", "Description", "CourseType", "PassingScore", instid, "CreatedBy", "CreatedDate", "UpdatedBy", "UpdatedDate") FROM stdin;
    public          postgres    false    222   *�      !          0    27684    Teacher_course_AssignToTeacher 
   TABLE DATA           U   COPY public."Teacher_course_AssignToTeacher" (id, course_id, profile_id) FROM stdin;
    public          postgres    false    223   ��      $          0    27691    Teacher_course_DepartmentId 
   TABLE DATA           U   COPY public."Teacher_course_DepartmentId" (id, course_id, department_id) FROM stdin;
    public          postgres    false    226   ��      &          0    27696    Teacher_course_EnrollToStudent 
   TABLE DATA           U   COPY public."Teacher_course_EnrollToStudent" (id, course_id, profile_id) FROM stdin;
    public          postgres    false    228   ¼      (          0    27701    Teacher_course_InstitutionId 
   TABLE DATA           W   COPY public."Teacher_course_InstitutionId" (id, course_id, institution_id) FROM stdin;
    public          postgres    false    230   ߼      *          0    27706    Teacher_courseassessment 
   TABLE DATA           �   COPY public."Teacher_courseassessment" ("isActive", "CourseAssessmentId", "Score", "CreatedBy", "CreatedDate", "UpdatedBy", "UpdatedDate", "CourseId_id") FROM stdin;
    public          postgres    false    232   �      +          0    27712    Teacher_courseregistration 
   TABLE DATA           �   COPY public."Teacher_courseregistration" ("isActive", "Student_Name", "Instructor_Name", "CourseRegistrationId", "EnrollmentStatus", "CreatedBy", "CreatedDate", "UpdatedBy", "UpdatedDate", "CourseId_id", "Name_id") FROM stdin;
    public          postgres    false    233   �      ,          0    27718    Teacher_coursesyllabus 
   TABLE DATA           W   COPY public."Teacher_coursesyllabus" ("Id", "syllabusFile", "courseId_id") FROM stdin;
    public          postgres    false    234   <�      .          0    27723    Teacher_csvupload 
   TABLE DATA           R   COPY public."Teacher_csvupload" (id, title, file, completed, user_id) FROM stdin;
    public          postgres    false    236   ��      0          0    27728    Teacher_email 
   TABLE DATA           �   COPY public."Teacher_email" ("EmailId", "Title", "Subject", "Content", "CreatedOn", "CreatedBy", "ModifiedOn", "ModifiedBy", status, "readStatus", "AttachFile", "Email_From_id") FROM stdin;
    public          postgres    false    238   ��      1          0    27734    Teacher_email_BCC 
   TABLE DATA           G   COPY public."Teacher_email_BCC" (id, email_id, profile_id) FROM stdin;
    public          postgres    false    239   ͽ      3          0    27739    Teacher_email_CC 
   TABLE DATA           F   COPY public."Teacher_email_CC" (id, email_id, profile_id) FROM stdin;
    public          postgres    false    241   �      6          0    27746    Teacher_email_Email_To 
   TABLE DATA           L   COPY public."Teacher_email_Email_To" (id, email_id, profile_id) FROM stdin;
    public          postgres    false    244   �      8          0    27751    Teacher_folder 
   TABLE DATA           K   COPY public."Teacher_folder" ("FolderId", "Name", "UserId_id") FROM stdin;
    public          postgres    false    246   $�      :          0    27759    Teacher_module 
   TABLE DATA           �   COPY public."Teacher_module" ("isActive", "ModuleId", "Name", "Description", "StartDate", "EndDate", course, "ModuleOrderNo", "CreatedBy", "CreatedDate", "UpdatedBy", "UpdatedDate", "CourseId_id") FROM stdin;
    public          postgres    false    248   A�      <          0    27767    Teacher_modulefile 
   TABLE DATA           �   COPY public."Teacher_modulefile" ("isActive", id, "File", "FileOrderNo", "CreatedBy", "CreatedDate", "UpdatedBy", "UpdatedDate", "ModuleId_id") FROM stdin;
    public          postgres    false    250   ��      >          0    27775    Teacher_modulefilecontent 
   TABLE DATA           �   COPY public."Teacher_modulefilecontent" ("isActive", id, "Slide", "SlideOrderNo", "TextContent", "SlideText", "SlideImage", "SlideVideos", "SlideAudio", "CreatedBy", "CreatedDate", "UpdatedBy", "UpdatedDate", "ModuleFileId_id") FROM stdin;
    public          postgres    false    252   �      @          0    27783    Teacher_modulesyllabus 
   TABLE DATA           �   COPY public."Teacher_modulesyllabus" ("Id", "oneDriveLink", "syllabusFile", "imgFilePath", "imgCount", "fileOrderNo", "courseId_id") FROM stdin;
    public          postgres    false    254   C�      B          0    27791    Teacher_progress 
   TABLE DATA           ^   COPY public."Teacher_progress" (id, score, correct_answer, wrong_answer, user_id) FROM stdin;
    public          postgres    false    256   `�      D          0    27799    Teacher_question 
   TABLE DATA           �   COPY public."Teacher_question" (id, figure, content, explanation, "questionOrderNo", "isMCQ", "QuizId_id", category_id) FROM stdin;
    public          postgres    false    258   }�      F          0    27808    Teacher_quiz 
   TABLE DATA           �   COPY public."Teacher_quiz" ("QuizId", title, description, url, random_order, max_questions, answers_at_end, exam_paper, single_attempt, pass_mark, success_text, fail_text, draft, "quizOrderNo", "CourseId_id", "Module_id", category_id) FROM stdin;
    public          postgres    false    260   U�      H          0    27818    Teacher_sitting 
   TABLE DATA           �   COPY public."Teacher_sitting" (id, question_order, question_list, incorrect_questions, current_score, complete, user_answers, start, "end", quiz_id, user_id) FROM stdin;
    public          postgres    false    262   ��      J          0    27826    Teacher_studentcourseprogress 
   TABLE DATA           �   COPY public."Teacher_studentcourseprogress" (id, "Grade", "CurrentModuleNo", "CurrentUnitNo", "CurrentAssignNo", "CourseId_id", "StudentId_id") FROM stdin;
    public          postgres    false    264   ��      L          0    27831 !   Teacher_studentmodulefileprogress 
   TABLE DATA           �   COPY public."Teacher_studentmodulefileprogress" (id, "fileCompleted", "CurrentFilePageNo", "FileId_id", "ModuleId_id", "StudentId_id") FROM stdin;
    public          postgres    false    266   ��      N          0    27836    Teacher_studentmoduleprogress 
   TABLE DATA           ~   COPY public."Teacher_studentmoduleprogress" (id, "CurrentFileNo", "CurrentQuizNo", "ModuleId_id", "StudentId_id") FROM stdin;
    public          postgres    false    268   ��      P          0    27841    Teacher_studentquizprogress 
   TABLE DATA           x   COPY public."Teacher_studentquizprogress" (id, score, completed, num_attempts, "QuizId_id", "StudentId_id") FROM stdin;
    public          postgres    false    270   �      R          0    27847    Teacher_units 
   TABLE DATA           �   COPY public."Teacher_units" ("isActive", "UnitId", "Name", "Description", "StartDate", "EndDate", "File", "CreatedBy", "CreatedDate", "UpdatedBy", "UpdatedDate", "CourseId_id", "ModuleId_id") FROM stdin;
    public          postgres    false    272   )�      T          0    27855 
   auth_group 
   TABLE DATA           .   COPY public.auth_group (id, name) FROM stdin;
    public          postgres    false    274   F�      V          0    27860    auth_group_permissions 
   TABLE DATA           M   COPY public.auth_group_permissions (id, group_id, permission_id) FROM stdin;
    public          postgres    false    276   c�      X          0    27865    auth_permission 
   TABLE DATA           N   COPY public.auth_permission (id, name, content_type_id, codename) FROM stdin;
    public          postgres    false    278   ��      Z          0    27870 	   auth_user 
   TABLE DATA           �   COPY public.auth_user (id, password, last_login, is_superuser, username, first_name, last_name, email, is_staff, is_active, date_joined) FROM stdin;
    public          postgres    false    280   @�      [          0    27876    auth_user_groups 
   TABLE DATA           A   COPY public.auth_user_groups (id, user_id, group_id) FROM stdin;
    public          postgres    false    281   �      ^          0    27883    auth_user_user_permissions 
   TABLE DATA           P   COPY public.auth_user_user_permissions (id, user_id, permission_id) FROM stdin;
    public          postgres    false    284   "�      `          0    27888    django_admin_log 
   TABLE DATA           �   COPY public.django_admin_log (id, action_time, object_id, object_repr, action_flag, change_message, content_type_id, user_id) FROM stdin;
    public          postgres    false    286   ?�      b          0    27897    django_content_type 
   TABLE DATA           C   COPY public.django_content_type (id, app_label, model) FROM stdin;
    public          postgres    false    288   ��      d          0    27902    django_migrations 
   TABLE DATA           C   COPY public.django_migrations (id, app, name, applied) FROM stdin;
    public          postgres    false    290   \�      f          0    27910    django_session 
   TABLE DATA           P   COPY public.django_session (session_key, session_data, expire_date) FROM stdin;
    public          postgres    false    292   I�                0    27630    instituteadmin_profile 
   TABLE DATA             COPY public.instituteadmin_profile (isactive, id, userrole, first_name, last_name, email, dob, mobileno, gender, department, address1, address2, city, state, zip, profile_pics, createdby, createddate, updatedby, updateddate, institutionid_id, user_id) FROM stdin;
    public          postgres    false    208   ��      �           0    0 !   Admin_department_DepartmentId_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public."Admin_department_DepartmentId_seq"', 1, true);
          public          postgres    false    201            �           0    0 #   Admin_institution_InstitutionId_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public."Admin_institution_InstitutionId_seq"', 1, true);
          public          postgres    false    203            �           0    0    Admin_role_RoleId_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."Admin_role_RoleId_seq"', 1, false);
          public          postgres    false    205            �           0    0    Admin_userinstitutionmap_Id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public."Admin_userinstitutionmap_Id_seq"', 1, false);
          public          postgres    false    207            �           0    0    InstituteAdmin_profile_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public."InstituteAdmin_profile_id_seq"', 5, true);
          public          postgres    false    209            �           0    0 $   Teacher_announcements_To_List_id_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public."Teacher_announcements_To_List_id_seq"', 1, true);
          public          postgres    false    212            �           0    0    Teacher_announcements_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public."Teacher_announcements_id_seq"', 1, true);
          public          postgres    false    213            �           0    0    Teacher_answer_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."Teacher_answer_id_seq"', 10, true);
          public          postgres    false    215            �           0    0 $   Teacher_assignment_Assignment_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public."Teacher_assignment_Assignment_id_seq"', 1, false);
          public          postgres    false    217            �           0    0 0   Teacher_assignmentupload_AssignmentUpload_id_seq    SEQUENCE SET     a   SELECT pg_catalog.setval('public."Teacher_assignmentupload_AssignmentUpload_id_seq"', 1, false);
          public          postgres    false    219            �           0    0    Teacher_category_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Teacher_category_id_seq"', 1, true);
          public          postgres    false    221            �           0    0 %   Teacher_course_AssignToTeacher_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public."Teacher_course_AssignToTeacher_id_seq"', 1, true);
          public          postgres    false    224            �           0    0    Teacher_course_CourseId_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public."Teacher_course_CourseId_seq"', 1, true);
          public          postgres    false    225            �           0    0 "   Teacher_course_DepartmentId_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public."Teacher_course_DepartmentId_id_seq"', 1, true);
          public          postgres    false    227            �           0    0 %   Teacher_course_EnrollToStudent_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public."Teacher_course_EnrollToStudent_id_seq"', 1, true);
          public          postgres    false    229            �           0    0 #   Teacher_course_InstitutionId_id_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public."Teacher_course_InstitutionId_id_seq"', 1, true);
          public          postgres    false    231            �           0    0    Teacher_coursesyllabus_Id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public."Teacher_coursesyllabus_Id_seq"', 1, true);
          public          postgres    false    235            �           0    0    Teacher_csvupload_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."Teacher_csvupload_id_seq"', 1, false);
          public          postgres    false    237            �           0    0    Teacher_email_BCC_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."Teacher_email_BCC_id_seq"', 1, false);
          public          postgres    false    240            �           0    0    Teacher_email_CC_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public."Teacher_email_CC_id_seq"', 1, false);
          public          postgres    false    242            �           0    0    Teacher_email_EmailId_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public."Teacher_email_EmailId_seq"', 1, false);
          public          postgres    false    243            �           0    0    Teacher_email_Email_To_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public."Teacher_email_Email_To_id_seq"', 1, false);
          public          postgres    false    245            �           0    0    Teacher_folder_FolderId_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public."Teacher_folder_FolderId_seq"', 1, false);
          public          postgres    false    247            �           0    0    Teacher_module_ModuleId_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public."Teacher_module_ModuleId_seq"', 1, true);
          public          postgres    false    249            �           0    0    Teacher_modulefile_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."Teacher_modulefile_id_seq"', 1, true);
          public          postgres    false    251            �           0    0     Teacher_modulefilecontent_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public."Teacher_modulefilecontent_id_seq"', 1, true);
          public          postgres    false    253            �           0    0    Teacher_modulesyllabus_Id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public."Teacher_modulesyllabus_Id_seq"', 1, false);
          public          postgres    false    255            �           0    0    Teacher_progress_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public."Teacher_progress_id_seq"', 1, false);
          public          postgres    false    257            �           0    0    Teacher_question_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Teacher_question_id_seq"', 5, true);
          public          postgres    false    259            �           0    0    Teacher_quiz_QuizId_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Teacher_quiz_QuizId_seq"', 1, true);
          public          postgres    false    261            �           0    0    Teacher_sitting_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Teacher_sitting_id_seq"', 1, false);
          public          postgres    false    263            �           0    0 $   Teacher_studentcourseprogress_id_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public."Teacher_studentcourseprogress_id_seq"', 1, true);
          public          postgres    false    265            �           0    0 (   Teacher_studentmodulefileprogress_id_seq    SEQUENCE SET     Y   SELECT pg_catalog.setval('public."Teacher_studentmodulefileprogress_id_seq"', 1, false);
          public          postgres    false    267            �           0    0 $   Teacher_studentmoduleprogress_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public."Teacher_studentmoduleprogress_id_seq"', 1, false);
          public          postgres    false    269            �           0    0 "   Teacher_studentquizprogress_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public."Teacher_studentquizprogress_id_seq"', 1, true);
          public          postgres    false    271            �           0    0    Teacher_units_UnitId_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."Teacher_units_UnitId_seq"', 1, false);
          public          postgres    false    273            �           0    0    auth_group_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.auth_group_id_seq', 1, false);
          public          postgres    false    275            �           0    0    auth_group_permissions_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.auth_group_permissions_id_seq', 1, false);
          public          postgres    false    277            �           0    0    auth_permission_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.auth_permission_id_seq', 145, true);
          public          postgres    false    279            �           0    0    auth_user_groups_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.auth_user_groups_id_seq', 1, false);
          public          postgres    false    282            �           0    0    auth_user_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.auth_user_id_seq', 4, true);
          public          postgres    false    283            �           0    0 !   auth_user_user_permissions_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.auth_user_user_permissions_id_seq', 1, false);
          public          postgres    false    285            �           0    0    django_admin_log_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.django_admin_log_id_seq', 10, true);
          public          postgres    false    287            �           0    0    django_content_type_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.django_content_type_id_seq', 36, true);
          public          postgres    false    289            �           0    0    django_migrations_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.django_migrations_id_seq', 21, true);
          public          postgres    false    291            �           2606    27962 &   Admin_department Admin_department_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public."Admin_department"
    ADD CONSTRAINT "Admin_department_pkey" PRIMARY KEY ("DepartmentId");
 T   ALTER TABLE ONLY public."Admin_department" DROP CONSTRAINT "Admin_department_pkey";
       public            postgres    false    200            �           2606    27964 (   Admin_institution Admin_institution_pkey 
   CONSTRAINT     w   ALTER TABLE ONLY public."Admin_institution"
    ADD CONSTRAINT "Admin_institution_pkey" PRIMARY KEY ("InstitutionId");
 V   ALTER TABLE ONLY public."Admin_institution" DROP CONSTRAINT "Admin_institution_pkey";
       public            postgres    false    202            �           2606    27966    Admin_role Admin_role_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."Admin_role"
    ADD CONSTRAINT "Admin_role_pkey" PRIMARY KEY ("RoleId");
 H   ALTER TABLE ONLY public."Admin_role" DROP CONSTRAINT "Admin_role_pkey";
       public            postgres    false    204            �           2606    27968 6   Admin_userinstitutionmap Admin_userinstitutionmap_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public."Admin_userinstitutionmap"
    ADD CONSTRAINT "Admin_userinstitutionmap_pkey" PRIMARY KEY ("Id");
 d   ALTER TABLE ONLY public."Admin_userinstitutionmap" DROP CONSTRAINT "Admin_userinstitutionmap_pkey";
       public            postgres    false    206            �           2606    27970 2   instituteadmin_profile InstituteAdmin_profile_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.instituteadmin_profile
    ADD CONSTRAINT "InstituteAdmin_profile_pkey" PRIMARY KEY (id);
 ^   ALTER TABLE ONLY public.instituteadmin_profile DROP CONSTRAINT "InstituteAdmin_profile_pkey";
       public            postgres    false    208            �           2606    27972 9   instituteadmin_profile InstituteAdmin_profile_user_id_key 
   CONSTRAINT     y   ALTER TABLE ONLY public.instituteadmin_profile
    ADD CONSTRAINT "InstituteAdmin_profile_user_id_key" UNIQUE (user_id);
 e   ALTER TABLE ONLY public.instituteadmin_profile DROP CONSTRAINT "InstituteAdmin_profile_user_id_key";
       public            postgres    false    208            �           2606    27974 @   Teacher_announcements_To_List Teacher_announcements_To_List_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_announcements_To_List"
    ADD CONSTRAINT "Teacher_announcements_To_List_pkey" PRIMARY KEY (id);
 n   ALTER TABLE ONLY public."Teacher_announcements_To_List" DROP CONSTRAINT "Teacher_announcements_To_List_pkey";
       public            postgres    false    211            �           2606    27976 ]   Teacher_announcements_To_List Teacher_announcements_To_announcements_id_profile_99b8bc84_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_announcements_To_List"
    ADD CONSTRAINT "Teacher_announcements_To_announcements_id_profile_99b8bc84_uniq" UNIQUE (announcements_id, profile_id);
 �   ALTER TABLE ONLY public."Teacher_announcements_To_List" DROP CONSTRAINT "Teacher_announcements_To_announcements_id_profile_99b8bc84_uniq";
       public            postgres    false    211    211            �           2606    27978 0   Teacher_announcements Teacher_announcements_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public."Teacher_announcements"
    ADD CONSTRAINT "Teacher_announcements_pkey" PRIMARY KEY (id);
 ^   ALTER TABLE ONLY public."Teacher_announcements" DROP CONSTRAINT "Teacher_announcements_pkey";
       public            postgres    false    210            �           2606    27980 "   Teacher_answer Teacher_answer_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public."Teacher_answer"
    ADD CONSTRAINT "Teacher_answer_pkey" PRIMARY KEY (id);
 P   ALTER TABLE ONLY public."Teacher_answer" DROP CONSTRAINT "Teacher_answer_pkey";
       public            postgres    false    214            �           2606    27982 *   Teacher_assignment Teacher_assignment_pkey 
   CONSTRAINT     y   ALTER TABLE ONLY public."Teacher_assignment"
    ADD CONSTRAINT "Teacher_assignment_pkey" PRIMARY KEY ("Assignment_id");
 X   ALTER TABLE ONLY public."Teacher_assignment" DROP CONSTRAINT "Teacher_assignment_pkey";
       public            postgres    false    216            �           2606    27984 6   Teacher_assignmentupload Teacher_assignmentupload_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_assignmentupload"
    ADD CONSTRAINT "Teacher_assignmentupload_pkey" PRIMARY KEY ("AssignmentUpload_id");
 d   ALTER TABLE ONLY public."Teacher_assignmentupload" DROP CONSTRAINT "Teacher_assignmentupload_pkey";
       public            postgres    false    218            �           2606    27986 .   Teacher_category Teacher_category_category_key 
   CONSTRAINT     q   ALTER TABLE ONLY public."Teacher_category"
    ADD CONSTRAINT "Teacher_category_category_key" UNIQUE (category);
 \   ALTER TABLE ONLY public."Teacher_category" DROP CONSTRAINT "Teacher_category_category_key";
       public            postgres    false    220            �           2606    27988 &   Teacher_category Teacher_category_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public."Teacher_category"
    ADD CONSTRAINT "Teacher_category_pkey" PRIMARY KEY (id);
 T   ALTER TABLE ONLY public."Teacher_category" DROP CONSTRAINT "Teacher_category_pkey";
       public            postgres    false    220            �           2606    27990 Z   Teacher_course_AssignToTeacher Teacher_course_AssignToT_course_id_profile_id_116eb528_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher"
    ADD CONSTRAINT "Teacher_course_AssignToT_course_id_profile_id_116eb528_uniq" UNIQUE (course_id, profile_id);
 �   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher" DROP CONSTRAINT "Teacher_course_AssignToT_course_id_profile_id_116eb528_uniq";
       public            postgres    false    223    223            �           2606    27992 B   Teacher_course_AssignToTeacher Teacher_course_AssignToTeacher_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher"
    ADD CONSTRAINT "Teacher_course_AssignToTeacher_pkey" PRIMARY KEY (id);
 p   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher" DROP CONSTRAINT "Teacher_course_AssignToTeacher_pkey";
       public            postgres    false    223            �           2606    27994 Z   Teacher_course_DepartmentId Teacher_course_Departmen_course_id_department_id_1d652380_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_DepartmentId"
    ADD CONSTRAINT "Teacher_course_Departmen_course_id_department_id_1d652380_uniq" UNIQUE (course_id, department_id);
 �   ALTER TABLE ONLY public."Teacher_course_DepartmentId" DROP CONSTRAINT "Teacher_course_Departmen_course_id_department_id_1d652380_uniq";
       public            postgres    false    226    226            �           2606    27996 <   Teacher_course_DepartmentId Teacher_course_DepartmentId_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public."Teacher_course_DepartmentId"
    ADD CONSTRAINT "Teacher_course_DepartmentId_pkey" PRIMARY KEY (id);
 j   ALTER TABLE ONLY public."Teacher_course_DepartmentId" DROP CONSTRAINT "Teacher_course_DepartmentId_pkey";
       public            postgres    false    226            �           2606    27998 Z   Teacher_course_EnrollToStudent Teacher_course_EnrollToS_course_id_profile_id_47f52ce9_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent"
    ADD CONSTRAINT "Teacher_course_EnrollToS_course_id_profile_id_47f52ce9_uniq" UNIQUE (course_id, profile_id);
 �   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent" DROP CONSTRAINT "Teacher_course_EnrollToS_course_id_profile_id_47f52ce9_uniq";
       public            postgres    false    228    228            �           2606    28000 B   Teacher_course_EnrollToStudent Teacher_course_EnrollToStudent_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent"
    ADD CONSTRAINT "Teacher_course_EnrollToStudent_pkey" PRIMARY KEY (id);
 p   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent" DROP CONSTRAINT "Teacher_course_EnrollToStudent_pkey";
       public            postgres    false    228            �           2606    28002 \   Teacher_course_InstitutionId Teacher_course_Instituti_course_id_institution_id_d4150f5c_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_InstitutionId"
    ADD CONSTRAINT "Teacher_course_Instituti_course_id_institution_id_d4150f5c_uniq" UNIQUE (course_id, institution_id);
 �   ALTER TABLE ONLY public."Teacher_course_InstitutionId" DROP CONSTRAINT "Teacher_course_Instituti_course_id_institution_id_d4150f5c_uniq";
       public            postgres    false    230    230            �           2606    28004 >   Teacher_course_InstitutionId Teacher_course_InstitutionId_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_InstitutionId"
    ADD CONSTRAINT "Teacher_course_InstitutionId_pkey" PRIMARY KEY (id);
 l   ALTER TABLE ONLY public."Teacher_course_InstitutionId" DROP CONSTRAINT "Teacher_course_InstitutionId_pkey";
       public            postgres    false    230            �           2606    28006 "   Teacher_course Teacher_course_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public."Teacher_course"
    ADD CONSTRAINT "Teacher_course_pkey" PRIMARY KEY ("CourseId");
 P   ALTER TABLE ONLY public."Teacher_course" DROP CONSTRAINT "Teacher_course_pkey";
       public            postgres    false    222            �           2606    28008 6   Teacher_courseassessment Teacher_courseassessment_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_courseassessment"
    ADD CONSTRAINT "Teacher_courseassessment_pkey" PRIMARY KEY ("CourseAssessmentId");
 d   ALTER TABLE ONLY public."Teacher_courseassessment" DROP CONSTRAINT "Teacher_courseassessment_pkey";
       public            postgres    false    232            �           2606    28010 :   Teacher_courseregistration Teacher_courseregistration_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_courseregistration"
    ADD CONSTRAINT "Teacher_courseregistration_pkey" PRIMARY KEY ("CourseRegistrationId");
 h   ALTER TABLE ONLY public."Teacher_courseregistration" DROP CONSTRAINT "Teacher_courseregistration_pkey";
       public            postgres    false    233            �           2606    28012 2   Teacher_coursesyllabus Teacher_coursesyllabus_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public."Teacher_coursesyllabus"
    ADD CONSTRAINT "Teacher_coursesyllabus_pkey" PRIMARY KEY ("Id");
 `   ALTER TABLE ONLY public."Teacher_coursesyllabus" DROP CONSTRAINT "Teacher_coursesyllabus_pkey";
       public            postgres    false    234            �           2606    28014 (   Teacher_csvupload Teacher_csvupload_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public."Teacher_csvupload"
    ADD CONSTRAINT "Teacher_csvupload_pkey" PRIMARY KEY (id);
 V   ALTER TABLE ONLY public."Teacher_csvupload" DROP CONSTRAINT "Teacher_csvupload_pkey";
       public            postgres    false    236            �           2606    28016 E   Teacher_email_BCC Teacher_email_BCC_email_id_profile_id_79a54781_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_BCC"
    ADD CONSTRAINT "Teacher_email_BCC_email_id_profile_id_79a54781_uniq" UNIQUE (email_id, profile_id);
 s   ALTER TABLE ONLY public."Teacher_email_BCC" DROP CONSTRAINT "Teacher_email_BCC_email_id_profile_id_79a54781_uniq";
       public            postgres    false    239    239            �           2606    28018 (   Teacher_email_BCC Teacher_email_BCC_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public."Teacher_email_BCC"
    ADD CONSTRAINT "Teacher_email_BCC_pkey" PRIMARY KEY (id);
 V   ALTER TABLE ONLY public."Teacher_email_BCC" DROP CONSTRAINT "Teacher_email_BCC_pkey";
       public            postgres    false    239            �           2606    28020 C   Teacher_email_CC Teacher_email_CC_email_id_profile_id_09f8a5d9_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_CC"
    ADD CONSTRAINT "Teacher_email_CC_email_id_profile_id_09f8a5d9_uniq" UNIQUE (email_id, profile_id);
 q   ALTER TABLE ONLY public."Teacher_email_CC" DROP CONSTRAINT "Teacher_email_CC_email_id_profile_id_09f8a5d9_uniq";
       public            postgres    false    241    241            �           2606    28022 &   Teacher_email_CC Teacher_email_CC_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public."Teacher_email_CC"
    ADD CONSTRAINT "Teacher_email_CC_pkey" PRIMARY KEY (id);
 T   ALTER TABLE ONLY public."Teacher_email_CC" DROP CONSTRAINT "Teacher_email_CC_pkey";
       public            postgres    false    241            �           2606    28024 O   Teacher_email_Email_To Teacher_email_Email_To_email_id_profile_id_37e0ea1b_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_Email_To"
    ADD CONSTRAINT "Teacher_email_Email_To_email_id_profile_id_37e0ea1b_uniq" UNIQUE (email_id, profile_id);
 }   ALTER TABLE ONLY public."Teacher_email_Email_To" DROP CONSTRAINT "Teacher_email_Email_To_email_id_profile_id_37e0ea1b_uniq";
       public            postgres    false    244    244            �           2606    28026 2   Teacher_email_Email_To Teacher_email_Email_To_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public."Teacher_email_Email_To"
    ADD CONSTRAINT "Teacher_email_Email_To_pkey" PRIMARY KEY (id);
 `   ALTER TABLE ONLY public."Teacher_email_Email_To" DROP CONSTRAINT "Teacher_email_Email_To_pkey";
       public            postgres    false    244            �           2606    28028     Teacher_email Teacher_email_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public."Teacher_email"
    ADD CONSTRAINT "Teacher_email_pkey" PRIMARY KEY ("EmailId");
 N   ALTER TABLE ONLY public."Teacher_email" DROP CONSTRAINT "Teacher_email_pkey";
       public            postgres    false    238            �           2606    28030 "   Teacher_folder Teacher_folder_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public."Teacher_folder"
    ADD CONSTRAINT "Teacher_folder_pkey" PRIMARY KEY ("FolderId");
 P   ALTER TABLE ONLY public."Teacher_folder" DROP CONSTRAINT "Teacher_folder_pkey";
       public            postgres    false    246            �           2606    28032 "   Teacher_module Teacher_module_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public."Teacher_module"
    ADD CONSTRAINT "Teacher_module_pkey" PRIMARY KEY ("ModuleId");
 P   ALTER TABLE ONLY public."Teacher_module" DROP CONSTRAINT "Teacher_module_pkey";
       public            postgres    false    248            �           2606    28034 *   Teacher_modulefile Teacher_modulefile_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public."Teacher_modulefile"
    ADD CONSTRAINT "Teacher_modulefile_pkey" PRIMARY KEY (id);
 X   ALTER TABLE ONLY public."Teacher_modulefile" DROP CONSTRAINT "Teacher_modulefile_pkey";
       public            postgres    false    250            �           2606    28036 8   Teacher_modulefilecontent Teacher_modulefilecontent_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public."Teacher_modulefilecontent"
    ADD CONSTRAINT "Teacher_modulefilecontent_pkey" PRIMARY KEY (id);
 f   ALTER TABLE ONLY public."Teacher_modulefilecontent" DROP CONSTRAINT "Teacher_modulefilecontent_pkey";
       public            postgres    false    252            �           2606    28038 2   Teacher_modulesyllabus Teacher_modulesyllabus_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public."Teacher_modulesyllabus"
    ADD CONSTRAINT "Teacher_modulesyllabus_pkey" PRIMARY KEY ("Id");
 `   ALTER TABLE ONLY public."Teacher_modulesyllabus" DROP CONSTRAINT "Teacher_modulesyllabus_pkey";
       public            postgres    false    254            �           2606    28040 &   Teacher_progress Teacher_progress_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public."Teacher_progress"
    ADD CONSTRAINT "Teacher_progress_pkey" PRIMARY KEY (id);
 T   ALTER TABLE ONLY public."Teacher_progress" DROP CONSTRAINT "Teacher_progress_pkey";
       public            postgres    false    256            �           2606    28042 -   Teacher_progress Teacher_progress_user_id_key 
   CONSTRAINT     o   ALTER TABLE ONLY public."Teacher_progress"
    ADD CONSTRAINT "Teacher_progress_user_id_key" UNIQUE (user_id);
 [   ALTER TABLE ONLY public."Teacher_progress" DROP CONSTRAINT "Teacher_progress_user_id_key";
       public            postgres    false    256            �           2606    28044 &   Teacher_question Teacher_question_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public."Teacher_question"
    ADD CONSTRAINT "Teacher_question_pkey" PRIMARY KEY (id);
 T   ALTER TABLE ONLY public."Teacher_question" DROP CONSTRAINT "Teacher_question_pkey";
       public            postgres    false    258            �           2606    28046    Teacher_quiz Teacher_quiz_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."Teacher_quiz"
    ADD CONSTRAINT "Teacher_quiz_pkey" PRIMARY KEY ("QuizId");
 L   ALTER TABLE ONLY public."Teacher_quiz" DROP CONSTRAINT "Teacher_quiz_pkey";
       public            postgres    false    260                       2606    28048 $   Teacher_sitting Teacher_sitting_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."Teacher_sitting"
    ADD CONSTRAINT "Teacher_sitting_pkey" PRIMARY KEY (id);
 R   ALTER TABLE ONLY public."Teacher_sitting" DROP CONSTRAINT "Teacher_sitting_pkey";
       public            postgres    false    262            	           2606    28050 @   Teacher_studentcourseprogress Teacher_studentcourseprogress_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentcourseprogress"
    ADD CONSTRAINT "Teacher_studentcourseprogress_pkey" PRIMARY KEY (id);
 n   ALTER TABLE ONLY public."Teacher_studentcourseprogress" DROP CONSTRAINT "Teacher_studentcourseprogress_pkey";
       public            postgres    false    264                       2606    28052 H   Teacher_studentmodulefileprogress Teacher_studentmodulefileprogress_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress"
    ADD CONSTRAINT "Teacher_studentmodulefileprogress_pkey" PRIMARY KEY (id);
 v   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress" DROP CONSTRAINT "Teacher_studentmodulefileprogress_pkey";
       public            postgres    false    266                       2606    28054 @   Teacher_studentmoduleprogress Teacher_studentmoduleprogress_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentmoduleprogress"
    ADD CONSTRAINT "Teacher_studentmoduleprogress_pkey" PRIMARY KEY (id);
 n   ALTER TABLE ONLY public."Teacher_studentmoduleprogress" DROP CONSTRAINT "Teacher_studentmoduleprogress_pkey";
       public            postgres    false    268                       2606    28056 <   Teacher_studentquizprogress Teacher_studentquizprogress_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public."Teacher_studentquizprogress"
    ADD CONSTRAINT "Teacher_studentquizprogress_pkey" PRIMARY KEY (id);
 j   ALTER TABLE ONLY public."Teacher_studentquizprogress" DROP CONSTRAINT "Teacher_studentquizprogress_pkey";
       public            postgres    false    270                       2606    28058     Teacher_units Teacher_units_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public."Teacher_units"
    ADD CONSTRAINT "Teacher_units_pkey" PRIMARY KEY ("UnitId");
 N   ALTER TABLE ONLY public."Teacher_units" DROP CONSTRAINT "Teacher_units_pkey";
       public            postgres    false    272                       2606    28060    auth_group auth_group_name_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.auth_group
    ADD CONSTRAINT auth_group_name_key UNIQUE (name);
 H   ALTER TABLE ONLY public.auth_group DROP CONSTRAINT auth_group_name_key;
       public            postgres    false    274            "           2606    28062 R   auth_group_permissions auth_group_permissions_group_id_permission_id_0cd325b0_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public.auth_group_permissions
    ADD CONSTRAINT auth_group_permissions_group_id_permission_id_0cd325b0_uniq UNIQUE (group_id, permission_id);
 |   ALTER TABLE ONLY public.auth_group_permissions DROP CONSTRAINT auth_group_permissions_group_id_permission_id_0cd325b0_uniq;
       public            postgres    false    276    276            %           2606    28064 2   auth_group_permissions auth_group_permissions_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.auth_group_permissions
    ADD CONSTRAINT auth_group_permissions_pkey PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.auth_group_permissions DROP CONSTRAINT auth_group_permissions_pkey;
       public            postgres    false    276                       2606    28066    auth_group auth_group_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.auth_group
    ADD CONSTRAINT auth_group_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.auth_group DROP CONSTRAINT auth_group_pkey;
       public            postgres    false    274            (           2606    28068 F   auth_permission auth_permission_content_type_id_codename_01ab375a_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public.auth_permission
    ADD CONSTRAINT auth_permission_content_type_id_codename_01ab375a_uniq UNIQUE (content_type_id, codename);
 p   ALTER TABLE ONLY public.auth_permission DROP CONSTRAINT auth_permission_content_type_id_codename_01ab375a_uniq;
       public            postgres    false    278    278            *           2606    28070 $   auth_permission auth_permission_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.auth_permission
    ADD CONSTRAINT auth_permission_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.auth_permission DROP CONSTRAINT auth_permission_pkey;
       public            postgres    false    278            2           2606    28072 &   auth_user_groups auth_user_groups_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.auth_user_groups
    ADD CONSTRAINT auth_user_groups_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.auth_user_groups DROP CONSTRAINT auth_user_groups_pkey;
       public            postgres    false    281            5           2606    28074 @   auth_user_groups auth_user_groups_user_id_group_id_94350c0c_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public.auth_user_groups
    ADD CONSTRAINT auth_user_groups_user_id_group_id_94350c0c_uniq UNIQUE (user_id, group_id);
 j   ALTER TABLE ONLY public.auth_user_groups DROP CONSTRAINT auth_user_groups_user_id_group_id_94350c0c_uniq;
       public            postgres    false    281    281            ,           2606    28076    auth_user auth_user_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.auth_user
    ADD CONSTRAINT auth_user_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.auth_user DROP CONSTRAINT auth_user_pkey;
       public            postgres    false    280            8           2606    28078 :   auth_user_user_permissions auth_user_user_permissions_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.auth_user_user_permissions
    ADD CONSTRAINT auth_user_user_permissions_pkey PRIMARY KEY (id);
 d   ALTER TABLE ONLY public.auth_user_user_permissions DROP CONSTRAINT auth_user_user_permissions_pkey;
       public            postgres    false    284            ;           2606    28080 Y   auth_user_user_permissions auth_user_user_permissions_user_id_permission_id_14a6b632_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public.auth_user_user_permissions
    ADD CONSTRAINT auth_user_user_permissions_user_id_permission_id_14a6b632_uniq UNIQUE (user_id, permission_id);
 �   ALTER TABLE ONLY public.auth_user_user_permissions DROP CONSTRAINT auth_user_user_permissions_user_id_permission_id_14a6b632_uniq;
       public            postgres    false    284    284            /           2606    28082     auth_user auth_user_username_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.auth_user
    ADD CONSTRAINT auth_user_username_key UNIQUE (username);
 J   ALTER TABLE ONLY public.auth_user DROP CONSTRAINT auth_user_username_key;
       public            postgres    false    280            >           2606    28084 &   django_admin_log django_admin_log_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.django_admin_log
    ADD CONSTRAINT django_admin_log_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.django_admin_log DROP CONSTRAINT django_admin_log_pkey;
       public            postgres    false    286            A           2606    28086 E   django_content_type django_content_type_app_label_model_76bd3d3b_uniq 
   CONSTRAINT     �   ALTER TABLE ONLY public.django_content_type
    ADD CONSTRAINT django_content_type_app_label_model_76bd3d3b_uniq UNIQUE (app_label, model);
 o   ALTER TABLE ONLY public.django_content_type DROP CONSTRAINT django_content_type_app_label_model_76bd3d3b_uniq;
       public            postgres    false    288    288            C           2606    28088 ,   django_content_type django_content_type_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.django_content_type
    ADD CONSTRAINT django_content_type_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.django_content_type DROP CONSTRAINT django_content_type_pkey;
       public            postgres    false    288            E           2606    28090 (   django_migrations django_migrations_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.django_migrations
    ADD CONSTRAINT django_migrations_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.django_migrations DROP CONSTRAINT django_migrations_pkey;
       public            postgres    false    290            H           2606    28092 "   django_session django_session_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.django_session
    ADD CONSTRAINT django_session_pkey PRIMARY KEY (session_key);
 L   ALTER TABLE ONLY public.django_session DROP CONSTRAINT django_session_pkey;
       public            postgres    false    292            �           1259    28093 *   Admin_department_InstitutionId_id_3ace7e32    INDEX     y   CREATE INDEX "Admin_department_InstitutionId_id_3ace7e32" ON public."Admin_department" USING btree ("InstitutionId_id");
 @   DROP INDEX public."Admin_department_InstitutionId_id_3ace7e32";
       public            postgres    false    200            �           1259    28094 2   Admin_userinstitutionmap_InstitutionId_id_8c9feb65    INDEX     �   CREATE INDEX "Admin_userinstitutionmap_InstitutionId_id_8c9feb65" ON public."Admin_userinstitutionmap" USING btree ("InstitutionId_id");
 H   DROP INDEX public."Admin_userinstitutionmap_InstitutionId_id_8c9feb65";
       public            postgres    false    206            �           1259    28095 0   InstituteAdmin_profile_InstitutionId_id_32474369    INDEX     �   CREATE INDEX "InstituteAdmin_profile_InstitutionId_id_32474369" ON public.instituteadmin_profile USING btree (institutionid_id);
 F   DROP INDEX public."InstituteAdmin_profile_InstitutionId_id_32474369";
       public            postgres    false    208            �           1259    28096 7   Teacher_announcements_To_List_announcements_id_cc6864cc    INDEX     �   CREATE INDEX "Teacher_announcements_To_List_announcements_id_cc6864cc" ON public."Teacher_announcements_To_List" USING btree (announcements_id);
 M   DROP INDEX public."Teacher_announcements_To_List_announcements_id_cc6864cc";
       public            postgres    false    211            �           1259    28097 1   Teacher_announcements_To_List_profile_id_f1306085    INDEX     �   CREATE INDEX "Teacher_announcements_To_List_profile_id_f1306085" ON public."Teacher_announcements_To_List" USING btree (profile_id);
 G   DROP INDEX public."Teacher_announcements_To_List_profile_id_f1306085";
       public            postgres    false    211            �           1259    28098 !   Teacher_answer_QuizId_id_8a8f554b    INDEX     g   CREATE INDEX "Teacher_answer_QuizId_id_8a8f554b" ON public."Teacher_answer" USING btree ("QuizId_id");
 7   DROP INDEX public."Teacher_answer_QuizId_id_8a8f554b";
       public            postgres    false    214            �           1259    28099 '   Teacher_assignment_ModuleId_id_10a5fe63    INDEX     s   CREATE INDEX "Teacher_assignment_ModuleId_id_10a5fe63" ON public."Teacher_assignment" USING btree ("ModuleId_id");
 =   DROP INDEX public."Teacher_assignment_ModuleId_id_10a5fe63";
       public            postgres    false    216            �           1259    28100 1   Teacher_assignmentupload_AssignmentId_id_a4c12c1c    INDEX     �   CREATE INDEX "Teacher_assignmentupload_AssignmentId_id_a4c12c1c" ON public."Teacher_assignmentupload" USING btree ("AssignmentId_id");
 G   DROP INDEX public."Teacher_assignmentupload_AssignmentId_id_a4c12c1c";
       public            postgres    false    218            �           1259    28101 '   Teacher_category_category_2d59e72d_like    INDEX     �   CREATE INDEX "Teacher_category_category_2d59e72d_like" ON public."Teacher_category" USING btree (category varchar_pattern_ops);
 =   DROP INDEX public."Teacher_category_category_2d59e72d_like";
       public            postgres    false    220            �           1259    28102 1   Teacher_course_AssignToTeacher_course_id_6e23d5c6    INDEX     �   CREATE INDEX "Teacher_course_AssignToTeacher_course_id_6e23d5c6" ON public."Teacher_course_AssignToTeacher" USING btree (course_id);
 G   DROP INDEX public."Teacher_course_AssignToTeacher_course_id_6e23d5c6";
       public            postgres    false    223            �           1259    28103 2   Teacher_course_AssignToTeacher_profile_id_c7bc3de8    INDEX     �   CREATE INDEX "Teacher_course_AssignToTeacher_profile_id_c7bc3de8" ON public."Teacher_course_AssignToTeacher" USING btree (profile_id);
 H   DROP INDEX public."Teacher_course_AssignToTeacher_profile_id_c7bc3de8";
       public            postgres    false    223            �           1259    28104 .   Teacher_course_DepartmentId_course_id_e2919890    INDEX        CREATE INDEX "Teacher_course_DepartmentId_course_id_e2919890" ON public."Teacher_course_DepartmentId" USING btree (course_id);
 D   DROP INDEX public."Teacher_course_DepartmentId_course_id_e2919890";
       public            postgres    false    226            �           1259    28105 2   Teacher_course_DepartmentId_department_id_dcd4b073    INDEX     �   CREATE INDEX "Teacher_course_DepartmentId_department_id_dcd4b073" ON public."Teacher_course_DepartmentId" USING btree (department_id);
 H   DROP INDEX public."Teacher_course_DepartmentId_department_id_dcd4b073";
       public            postgres    false    226            �           1259    28106 1   Teacher_course_EnrollToStudent_course_id_7b22b175    INDEX     �   CREATE INDEX "Teacher_course_EnrollToStudent_course_id_7b22b175" ON public."Teacher_course_EnrollToStudent" USING btree (course_id);
 G   DROP INDEX public."Teacher_course_EnrollToStudent_course_id_7b22b175";
       public            postgres    false    228            �           1259    28107 2   Teacher_course_EnrollToStudent_profile_id_65e9bc96    INDEX     �   CREATE INDEX "Teacher_course_EnrollToStudent_profile_id_65e9bc96" ON public."Teacher_course_EnrollToStudent" USING btree (profile_id);
 H   DROP INDEX public."Teacher_course_EnrollToStudent_profile_id_65e9bc96";
       public            postgres    false    228            �           1259    28108 /   Teacher_course_InstitutionId_course_id_3244cce7    INDEX     �   CREATE INDEX "Teacher_course_InstitutionId_course_id_3244cce7" ON public."Teacher_course_InstitutionId" USING btree (course_id);
 E   DROP INDEX public."Teacher_course_InstitutionId_course_id_3244cce7";
       public            postgres    false    230            �           1259    28109 4   Teacher_course_InstitutionId_institution_id_b4bf5de3    INDEX     �   CREATE INDEX "Teacher_course_InstitutionId_institution_id_b4bf5de3" ON public."Teacher_course_InstitutionId" USING btree (institution_id);
 J   DROP INDEX public."Teacher_course_InstitutionId_institution_id_b4bf5de3";
       public            postgres    false    230            �           1259    28110 -   Teacher_courseassessment_CourseId_id_893c01bd    INDEX        CREATE INDEX "Teacher_courseassessment_CourseId_id_893c01bd" ON public."Teacher_courseassessment" USING btree ("CourseId_id");
 C   DROP INDEX public."Teacher_courseassessment_CourseId_id_893c01bd";
       public            postgres    false    232            �           1259    28111 /   Teacher_courseregistration_CourseId_id_9e1bb196    INDEX     �   CREATE INDEX "Teacher_courseregistration_CourseId_id_9e1bb196" ON public."Teacher_courseregistration" USING btree ("CourseId_id");
 E   DROP INDEX public."Teacher_courseregistration_CourseId_id_9e1bb196";
       public            postgres    false    233            �           1259    28112 +   Teacher_courseregistration_Name_id_92c9d933    INDEX     {   CREATE INDEX "Teacher_courseregistration_Name_id_92c9d933" ON public."Teacher_courseregistration" USING btree ("Name_id");
 A   DROP INDEX public."Teacher_courseregistration_Name_id_92c9d933";
       public            postgres    false    233            �           1259    28113 +   Teacher_coursesyllabus_courseId_id_6d1f2a8b    INDEX     {   CREATE INDEX "Teacher_coursesyllabus_courseId_id_6d1f2a8b" ON public."Teacher_coursesyllabus" USING btree ("courseId_id");
 A   DROP INDEX public."Teacher_coursesyllabus_courseId_id_6d1f2a8b";
       public            postgres    false    234            �           1259    28114 "   Teacher_csvupload_user_id_42769c97    INDEX     g   CREATE INDEX "Teacher_csvupload_user_id_42769c97" ON public."Teacher_csvupload" USING btree (user_id);
 8   DROP INDEX public."Teacher_csvupload_user_id_42769c97";
       public            postgres    false    236            �           1259    28115 #   Teacher_email_BCC_email_id_5ed1e5b8    INDEX     i   CREATE INDEX "Teacher_email_BCC_email_id_5ed1e5b8" ON public."Teacher_email_BCC" USING btree (email_id);
 9   DROP INDEX public."Teacher_email_BCC_email_id_5ed1e5b8";
       public            postgres    false    239            �           1259    28116 %   Teacher_email_BCC_profile_id_bde0e3ff    INDEX     m   CREATE INDEX "Teacher_email_BCC_profile_id_bde0e3ff" ON public."Teacher_email_BCC" USING btree (profile_id);
 ;   DROP INDEX public."Teacher_email_BCC_profile_id_bde0e3ff";
       public            postgres    false    239            �           1259    28117 "   Teacher_email_CC_email_id_a52b181b    INDEX     g   CREATE INDEX "Teacher_email_CC_email_id_a52b181b" ON public."Teacher_email_CC" USING btree (email_id);
 8   DROP INDEX public."Teacher_email_CC_email_id_a52b181b";
       public            postgres    false    241            �           1259    28118 $   Teacher_email_CC_profile_id_8a708682    INDEX     k   CREATE INDEX "Teacher_email_CC_profile_id_8a708682" ON public."Teacher_email_CC" USING btree (profile_id);
 :   DROP INDEX public."Teacher_email_CC_profile_id_8a708682";
       public            postgres    false    241            �           1259    28119 $   Teacher_email_Email_From_id_acc54e41    INDEX     m   CREATE INDEX "Teacher_email_Email_From_id_acc54e41" ON public."Teacher_email" USING btree ("Email_From_id");
 :   DROP INDEX public."Teacher_email_Email_From_id_acc54e41";
       public            postgres    false    238            �           1259    28120 (   Teacher_email_Email_To_email_id_789297dd    INDEX     s   CREATE INDEX "Teacher_email_Email_To_email_id_789297dd" ON public."Teacher_email_Email_To" USING btree (email_id);
 >   DROP INDEX public."Teacher_email_Email_To_email_id_789297dd";
       public            postgres    false    244            �           1259    28121 *   Teacher_email_Email_To_profile_id_4ade4937    INDEX     w   CREATE INDEX "Teacher_email_Email_To_profile_id_4ade4937" ON public."Teacher_email_Email_To" USING btree (profile_id);
 @   DROP INDEX public."Teacher_email_Email_To_profile_id_4ade4937";
       public            postgres    false    244            �           1259    28122 !   Teacher_folder_UserId_id_25ea40b7    INDEX     g   CREATE INDEX "Teacher_folder_UserId_id_25ea40b7" ON public."Teacher_folder" USING btree ("UserId_id");
 7   DROP INDEX public."Teacher_folder_UserId_id_25ea40b7";
       public            postgres    false    246            �           1259    28123 #   Teacher_module_CourseId_id_50aa9262    INDEX     k   CREATE INDEX "Teacher_module_CourseId_id_50aa9262" ON public."Teacher_module" USING btree ("CourseId_id");
 9   DROP INDEX public."Teacher_module_CourseId_id_50aa9262";
       public            postgres    false    248            �           1259    28124 '   Teacher_modulefile_ModuleId_id_9e8dce7d    INDEX     s   CREATE INDEX "Teacher_modulefile_ModuleId_id_9e8dce7d" ON public."Teacher_modulefile" USING btree ("ModuleId_id");
 =   DROP INDEX public."Teacher_modulefile_ModuleId_id_9e8dce7d";
       public            postgres    false    250            �           1259    28125 2   Teacher_modulefilecontent_ModuleFileId_id_72056622    INDEX     �   CREATE INDEX "Teacher_modulefilecontent_ModuleFileId_id_72056622" ON public."Teacher_modulefilecontent" USING btree ("ModuleFileId_id");
 H   DROP INDEX public."Teacher_modulefilecontent_ModuleFileId_id_72056622";
       public            postgres    false    252            �           1259    28126 +   Teacher_modulesyllabus_courseId_id_05c97e90    INDEX     {   CREATE INDEX "Teacher_modulesyllabus_courseId_id_05c97e90" ON public."Teacher_modulesyllabus" USING btree ("courseId_id");
 A   DROP INDEX public."Teacher_modulesyllabus_courseId_id_05c97e90";
       public            postgres    false    254            �           1259    28127 #   Teacher_question_QuizId_id_f3ba643e    INDEX     k   CREATE INDEX "Teacher_question_QuizId_id_f3ba643e" ON public."Teacher_question" USING btree ("QuizId_id");
 9   DROP INDEX public."Teacher_question_QuizId_id_f3ba643e";
       public            postgres    false    258            �           1259    28128 %   Teacher_question_category_id_52ec7234    INDEX     m   CREATE INDEX "Teacher_question_category_id_52ec7234" ON public."Teacher_question" USING btree (category_id);
 ;   DROP INDEX public."Teacher_question_category_id_52ec7234";
       public            postgres    false    258            �           1259    28129 !   Teacher_quiz_CourseId_id_7da107e9    INDEX     g   CREATE INDEX "Teacher_quiz_CourseId_id_7da107e9" ON public."Teacher_quiz" USING btree ("CourseId_id");
 7   DROP INDEX public."Teacher_quiz_CourseId_id_7da107e9";
       public            postgres    false    260            �           1259    28130    Teacher_quiz_Module_id_3b34f714    INDEX     c   CREATE INDEX "Teacher_quiz_Module_id_3b34f714" ON public."Teacher_quiz" USING btree ("Module_id");
 5   DROP INDEX public."Teacher_quiz_Module_id_3b34f714";
       public            postgres    false    260            �           1259    28131 !   Teacher_quiz_category_id_5d444d9d    INDEX     e   CREATE INDEX "Teacher_quiz_category_id_5d444d9d" ON public."Teacher_quiz" USING btree (category_id);
 7   DROP INDEX public."Teacher_quiz_category_id_5d444d9d";
       public            postgres    false    260                        1259    28132    Teacher_quiz_url_fda39535    INDEX     U   CREATE INDEX "Teacher_quiz_url_fda39535" ON public."Teacher_quiz" USING btree (url);
 /   DROP INDEX public."Teacher_quiz_url_fda39535";
       public            postgres    false    260                       1259    28133    Teacher_quiz_url_fda39535_like    INDEX     n   CREATE INDEX "Teacher_quiz_url_fda39535_like" ON public."Teacher_quiz" USING btree (url varchar_pattern_ops);
 4   DROP INDEX public."Teacher_quiz_url_fda39535_like";
       public            postgres    false    260                       1259    28134     Teacher_sitting_quiz_id_280a1446    INDEX     c   CREATE INDEX "Teacher_sitting_quiz_id_280a1446" ON public."Teacher_sitting" USING btree (quiz_id);
 6   DROP INDEX public."Teacher_sitting_quiz_id_280a1446";
       public            postgres    false    262                       1259    28135     Teacher_sitting_user_id_a53fd1db    INDEX     c   CREATE INDEX "Teacher_sitting_user_id_a53fd1db" ON public."Teacher_sitting" USING btree (user_id);
 6   DROP INDEX public."Teacher_sitting_user_id_a53fd1db";
       public            postgres    false    262                       1259    28136 2   Teacher_studentcourseprogress_CourseId_id_fe404be7    INDEX     �   CREATE INDEX "Teacher_studentcourseprogress_CourseId_id_fe404be7" ON public."Teacher_studentcourseprogress" USING btree ("CourseId_id");
 H   DROP INDEX public."Teacher_studentcourseprogress_CourseId_id_fe404be7";
       public            postgres    false    264                       1259    28137 3   Teacher_studentcourseprogress_StudentId_id_838739dd    INDEX     �   CREATE INDEX "Teacher_studentcourseprogress_StudentId_id_838739dd" ON public."Teacher_studentcourseprogress" USING btree ("StudentId_id");
 I   DROP INDEX public."Teacher_studentcourseprogress_StudentId_id_838739dd";
       public            postgres    false    264            
           1259    28138 4   Teacher_studentmodulefileprogress_FileId_id_e2bc8595    INDEX     �   CREATE INDEX "Teacher_studentmodulefileprogress_FileId_id_e2bc8595" ON public."Teacher_studentmodulefileprogress" USING btree ("FileId_id");
 J   DROP INDEX public."Teacher_studentmodulefileprogress_FileId_id_e2bc8595";
       public            postgres    false    266                       1259    28139 6   Teacher_studentmodulefileprogress_ModuleId_id_41c42264    INDEX     �   CREATE INDEX "Teacher_studentmodulefileprogress_ModuleId_id_41c42264" ON public."Teacher_studentmodulefileprogress" USING btree ("ModuleId_id");
 L   DROP INDEX public."Teacher_studentmodulefileprogress_ModuleId_id_41c42264";
       public            postgres    false    266                       1259    28140 7   Teacher_studentmodulefileprogress_StudentId_id_12135e51    INDEX     �   CREATE INDEX "Teacher_studentmodulefileprogress_StudentId_id_12135e51" ON public."Teacher_studentmodulefileprogress" USING btree ("StudentId_id");
 M   DROP INDEX public."Teacher_studentmodulefileprogress_StudentId_id_12135e51";
       public            postgres    false    266                       1259    28141 2   Teacher_studentmoduleprogress_ModuleId_id_c9fdad01    INDEX     �   CREATE INDEX "Teacher_studentmoduleprogress_ModuleId_id_c9fdad01" ON public."Teacher_studentmoduleprogress" USING btree ("ModuleId_id");
 H   DROP INDEX public."Teacher_studentmoduleprogress_ModuleId_id_c9fdad01";
       public            postgres    false    268                       1259    28142 3   Teacher_studentmoduleprogress_StudentId_id_5cbeb3ae    INDEX     �   CREATE INDEX "Teacher_studentmoduleprogress_StudentId_id_5cbeb3ae" ON public."Teacher_studentmoduleprogress" USING btree ("StudentId_id");
 I   DROP INDEX public."Teacher_studentmoduleprogress_StudentId_id_5cbeb3ae";
       public            postgres    false    268                       1259    28143 .   Teacher_studentquizprogress_QuizId_id_a04a2235    INDEX     �   CREATE INDEX "Teacher_studentquizprogress_QuizId_id_a04a2235" ON public."Teacher_studentquizprogress" USING btree ("QuizId_id");
 D   DROP INDEX public."Teacher_studentquizprogress_QuizId_id_a04a2235";
       public            postgres    false    270                       1259    28144 1   Teacher_studentquizprogress_StudentId_id_4e5596d2    INDEX     �   CREATE INDEX "Teacher_studentquizprogress_StudentId_id_4e5596d2" ON public."Teacher_studentquizprogress" USING btree ("StudentId_id");
 G   DROP INDEX public."Teacher_studentquizprogress_StudentId_id_4e5596d2";
       public            postgres    false    270                       1259    28145 "   Teacher_units_CourseId_id_f67d8790    INDEX     i   CREATE INDEX "Teacher_units_CourseId_id_f67d8790" ON public."Teacher_units" USING btree ("CourseId_id");
 8   DROP INDEX public."Teacher_units_CourseId_id_f67d8790";
       public            postgres    false    272                       1259    28146 "   Teacher_units_ModuleId_id_14dc3af9    INDEX     i   CREATE INDEX "Teacher_units_ModuleId_id_14dc3af9" ON public."Teacher_units" USING btree ("ModuleId_id");
 8   DROP INDEX public."Teacher_units_ModuleId_id_14dc3af9";
       public            postgres    false    272                       1259    28147    auth_group_name_a6ea08ec_like    INDEX     h   CREATE INDEX auth_group_name_a6ea08ec_like ON public.auth_group USING btree (name varchar_pattern_ops);
 1   DROP INDEX public.auth_group_name_a6ea08ec_like;
       public            postgres    false    274                        1259    28148 (   auth_group_permissions_group_id_b120cbf9    INDEX     o   CREATE INDEX auth_group_permissions_group_id_b120cbf9 ON public.auth_group_permissions USING btree (group_id);
 <   DROP INDEX public.auth_group_permissions_group_id_b120cbf9;
       public            postgres    false    276            #           1259    28149 -   auth_group_permissions_permission_id_84c5c92e    INDEX     y   CREATE INDEX auth_group_permissions_permission_id_84c5c92e ON public.auth_group_permissions USING btree (permission_id);
 A   DROP INDEX public.auth_group_permissions_permission_id_84c5c92e;
       public            postgres    false    276            &           1259    28150 (   auth_permission_content_type_id_2f476e4b    INDEX     o   CREATE INDEX auth_permission_content_type_id_2f476e4b ON public.auth_permission USING btree (content_type_id);
 <   DROP INDEX public.auth_permission_content_type_id_2f476e4b;
       public            postgres    false    278            0           1259    28151 "   auth_user_groups_group_id_97559544    INDEX     c   CREATE INDEX auth_user_groups_group_id_97559544 ON public.auth_user_groups USING btree (group_id);
 6   DROP INDEX public.auth_user_groups_group_id_97559544;
       public            postgres    false    281            3           1259    28152 !   auth_user_groups_user_id_6a12ed8b    INDEX     a   CREATE INDEX auth_user_groups_user_id_6a12ed8b ON public.auth_user_groups USING btree (user_id);
 5   DROP INDEX public.auth_user_groups_user_id_6a12ed8b;
       public            postgres    false    281            6           1259    28153 1   auth_user_user_permissions_permission_id_1fbb5f2c    INDEX     �   CREATE INDEX auth_user_user_permissions_permission_id_1fbb5f2c ON public.auth_user_user_permissions USING btree (permission_id);
 E   DROP INDEX public.auth_user_user_permissions_permission_id_1fbb5f2c;
       public            postgres    false    284            9           1259    28154 +   auth_user_user_permissions_user_id_a95ead1b    INDEX     u   CREATE INDEX auth_user_user_permissions_user_id_a95ead1b ON public.auth_user_user_permissions USING btree (user_id);
 ?   DROP INDEX public.auth_user_user_permissions_user_id_a95ead1b;
       public            postgres    false    284            -           1259    28155     auth_user_username_6821ab7c_like    INDEX     n   CREATE INDEX auth_user_username_6821ab7c_like ON public.auth_user USING btree (username varchar_pattern_ops);
 4   DROP INDEX public.auth_user_username_6821ab7c_like;
       public            postgres    false    280            <           1259    28156 )   django_admin_log_content_type_id_c4bce8eb    INDEX     q   CREATE INDEX django_admin_log_content_type_id_c4bce8eb ON public.django_admin_log USING btree (content_type_id);
 =   DROP INDEX public.django_admin_log_content_type_id_c4bce8eb;
       public            postgres    false    286            ?           1259    28157 !   django_admin_log_user_id_c564eba6    INDEX     a   CREATE INDEX django_admin_log_user_id_c564eba6 ON public.django_admin_log USING btree (user_id);
 5   DROP INDEX public.django_admin_log_user_id_c564eba6;
       public            postgres    false    286            F           1259    28158 #   django_session_expire_date_a5c62663    INDEX     e   CREATE INDEX django_session_expire_date_a5c62663 ON public.django_session USING btree (expire_date);
 7   DROP INDEX public.django_session_expire_date_a5c62663;
       public            postgres    false    292            I           1259    28159 (   django_session_session_key_c0390e0f_like    INDEX     ~   CREATE INDEX django_session_session_key_c0390e0f_like ON public.django_session USING btree (session_key varchar_pattern_ops);
 <   DROP INDEX public.django_session_session_key_c0390e0f_like;
       public            postgres    false    292            J           2606    28160 H   Admin_department Admin_department_InstitutionId_id_3ace7e32_fk_Admin_ins    FK CONSTRAINT     �   ALTER TABLE ONLY public."Admin_department"
    ADD CONSTRAINT "Admin_department_InstitutionId_id_3ace7e32_fk_Admin_ins" FOREIGN KEY ("InstitutionId_id") REFERENCES public."Admin_institution"("InstitutionId") DEFERRABLE INITIALLY DEFERRED;
 v   ALTER TABLE ONLY public."Admin_department" DROP CONSTRAINT "Admin_department_InstitutionId_id_3ace7e32_fk_Admin_ins";
       public          postgres    false    202    3207    200            K           2606    28165 T   Admin_userinstitutionmap Admin_userinstitutio_InstitutionId_id_8c9feb65_fk_Admin_ins    FK CONSTRAINT     �   ALTER TABLE ONLY public."Admin_userinstitutionmap"
    ADD CONSTRAINT "Admin_userinstitutio_InstitutionId_id_8c9feb65_fk_Admin_ins" FOREIGN KEY ("InstitutionId_id") REFERENCES public."Admin_institution"("InstitutionId") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Admin_userinstitutionmap" DROP CONSTRAINT "Admin_userinstitutio_InstitutionId_id_8c9feb65_fk_Admin_ins";
       public          postgres    false    202    206    3207            L           2606    28170 R   instituteadmin_profile InstituteAdmin_profi_InstitutionId_id_32474369_fk_Admin_ins    FK CONSTRAINT     �   ALTER TABLE ONLY public.instituteadmin_profile
    ADD CONSTRAINT "InstituteAdmin_profi_InstitutionId_id_32474369_fk_Admin_ins" FOREIGN KEY (institutionid_id) REFERENCES public."Admin_institution"("InstitutionId") DEFERRABLE INITIALLY DEFERRED;
 ~   ALTER TABLE ONLY public.instituteadmin_profile DROP CONSTRAINT "InstituteAdmin_profi_InstitutionId_id_32474369_fk_Admin_ins";
       public          postgres    false    208    202    3207            M           2606    28175 N   instituteadmin_profile InstituteAdmin_profile_user_id_14381fb1_fk_auth_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.instituteadmin_profile
    ADD CONSTRAINT "InstituteAdmin_profile_user_id_14381fb1_fk_auth_user_id" FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
 z   ALTER TABLE ONLY public.instituteadmin_profile DROP CONSTRAINT "InstituteAdmin_profile_user_id_14381fb1_fk_auth_user_id";
       public          postgres    false    208    280    3372            N           2606    28180 Y   Teacher_announcements_To_List Teacher_announcement_announcements_id_cc6864cc_fk_Teacher_a    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_announcements_To_List"
    ADD CONSTRAINT "Teacher_announcement_announcements_id_cc6864cc_fk_Teacher_a" FOREIGN KEY (announcements_id) REFERENCES public."Teacher_announcements"(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_announcements_To_List" DROP CONSTRAINT "Teacher_announcement_announcements_id_cc6864cc_fk_Teacher_a";
       public          postgres    false    211    3219    210            O           2606    28185 S   Teacher_announcements_To_List Teacher_announcement_profile_id_f1306085_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_announcements_To_List"
    ADD CONSTRAINT "Teacher_announcement_profile_id_f1306085_fk_Institute" FOREIGN KEY (profile_id) REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_announcements_To_List" DROP CONSTRAINT "Teacher_announcement_profile_id_f1306085_fk_Institute";
       public          postgres    false    3215    208    211            P           2606    28190 G   Teacher_answer Teacher_answer_QuizId_id_8a8f554b_fk_Teacher_quiz_QuizId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_answer"
    ADD CONSTRAINT "Teacher_answer_QuizId_id_8a8f554b_fk_Teacher_quiz_QuizId" FOREIGN KEY ("QuizId_id") REFERENCES public."Teacher_quiz"("QuizId") DEFERRABLE INITIALLY DEFERRED;
 u   ALTER TABLE ONLY public."Teacher_answer" DROP CONSTRAINT "Teacher_answer_QuizId_id_8a8f554b_fk_Teacher_quiz_QuizId";
       public          postgres    false    260    214    3327            Q           2606    28195 G   Teacher_assignment Teacher_assignment_ModuleId_id_10a5fe63_fk_Teacher_m    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_assignment"
    ADD CONSTRAINT "Teacher_assignment_ModuleId_id_10a5fe63_fk_Teacher_m" FOREIGN KEY ("ModuleId_id") REFERENCES public."Teacher_module"("ModuleId") DEFERRABLE INITIALLY DEFERRED;
 u   ALTER TABLE ONLY public."Teacher_assignment" DROP CONSTRAINT "Teacher_assignment_ModuleId_id_10a5fe63_fk_Teacher_m";
       public          postgres    false    3305    216    248            R           2606    28200 S   Teacher_assignmentupload Teacher_assignmentup_AssignmentId_id_a4c12c1c_fk_Teacher_a    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_assignmentupload"
    ADD CONSTRAINT "Teacher_assignmentup_AssignmentId_id_a4c12c1c_fk_Teacher_a" FOREIGN KEY ("AssignmentId_id") REFERENCES public."Teacher_assignment"("Assignment_id") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_assignmentupload" DROP CONSTRAINT "Teacher_assignmentup_AssignmentId_id_a4c12c1c_fk_Teacher_a";
       public          postgres    false    3231    216    218            S           2606    28205 S   Teacher_course_AssignToTeacher Teacher_course_Assig_course_id_6e23d5c6_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher"
    ADD CONSTRAINT "Teacher_course_Assig_course_id_6e23d5c6_fk_Teacher_c" FOREIGN KEY (course_id) REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher" DROP CONSTRAINT "Teacher_course_Assig_course_id_6e23d5c6_fk_Teacher_c";
       public          postgres    false    3241    223    222            T           2606    28210 T   Teacher_course_AssignToTeacher Teacher_course_Assig_profile_id_c7bc3de8_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher"
    ADD CONSTRAINT "Teacher_course_Assig_profile_id_c7bc3de8_fk_Institute" FOREIGN KEY (profile_id) REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_course_AssignToTeacher" DROP CONSTRAINT "Teacher_course_Assig_profile_id_c7bc3de8_fk_Institute";
       public          postgres    false    223    208    3215            U           2606    28215 P   Teacher_course_DepartmentId Teacher_course_Depar_course_id_e2919890_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_DepartmentId"
    ADD CONSTRAINT "Teacher_course_Depar_course_id_e2919890_fk_Teacher_c" FOREIGN KEY (course_id) REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 ~   ALTER TABLE ONLY public."Teacher_course_DepartmentId" DROP CONSTRAINT "Teacher_course_Depar_course_id_e2919890_fk_Teacher_c";
       public          postgres    false    222    3241    226            V           2606    28220 T   Teacher_course_DepartmentId Teacher_course_Depar_department_id_dcd4b073_fk_Admin_dep    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_DepartmentId"
    ADD CONSTRAINT "Teacher_course_Depar_department_id_dcd4b073_fk_Admin_dep" FOREIGN KEY (department_id) REFERENCES public."Admin_department"("DepartmentId") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_course_DepartmentId" DROP CONSTRAINT "Teacher_course_Depar_department_id_dcd4b073_fk_Admin_dep";
       public          postgres    false    200    3205    226            W           2606    28225 S   Teacher_course_EnrollToStudent Teacher_course_Enrol_course_id_7b22b175_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent"
    ADD CONSTRAINT "Teacher_course_Enrol_course_id_7b22b175_fk_Teacher_c" FOREIGN KEY (course_id) REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent" DROP CONSTRAINT "Teacher_course_Enrol_course_id_7b22b175_fk_Teacher_c";
       public          postgres    false    228    222    3241            X           2606    28230 T   Teacher_course_EnrollToStudent Teacher_course_Enrol_profile_id_65e9bc96_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent"
    ADD CONSTRAINT "Teacher_course_Enrol_profile_id_65e9bc96_fk_Institute" FOREIGN KEY (profile_id) REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_course_EnrollToStudent" DROP CONSTRAINT "Teacher_course_Enrol_profile_id_65e9bc96_fk_Institute";
       public          postgres    false    3215    228    208            Y           2606    28235 Q   Teacher_course_InstitutionId Teacher_course_Insti_course_id_3244cce7_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_InstitutionId"
    ADD CONSTRAINT "Teacher_course_Insti_course_id_3244cce7_fk_Teacher_c" FOREIGN KEY (course_id) REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
    ALTER TABLE ONLY public."Teacher_course_InstitutionId" DROP CONSTRAINT "Teacher_course_Insti_course_id_3244cce7_fk_Teacher_c";
       public          postgres    false    222    230    3241            Z           2606    28240 V   Teacher_course_InstitutionId Teacher_course_Insti_institution_id_b4bf5de3_fk_Admin_ins    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_course_InstitutionId"
    ADD CONSTRAINT "Teacher_course_Insti_institution_id_b4bf5de3_fk_Admin_ins" FOREIGN KEY (institution_id) REFERENCES public."Admin_institution"("InstitutionId") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_course_InstitutionId" DROP CONSTRAINT "Teacher_course_Insti_institution_id_b4bf5de3_fk_Admin_ins";
       public          postgres    false    202    230    3207            [           2606    28245 O   Teacher_courseassessment Teacher_courseassess_CourseId_id_893c01bd_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_courseassessment"
    ADD CONSTRAINT "Teacher_courseassess_CourseId_id_893c01bd_fk_Teacher_c" FOREIGN KEY ("CourseId_id") REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 }   ALTER TABLE ONLY public."Teacher_courseassessment" DROP CONSTRAINT "Teacher_courseassess_CourseId_id_893c01bd_fk_Teacher_c";
       public          postgres    false    3241    232    222            \           2606    28250 Q   Teacher_courseregistration Teacher_courseregist_CourseId_id_9e1bb196_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_courseregistration"
    ADD CONSTRAINT "Teacher_courseregist_CourseId_id_9e1bb196_fk_Teacher_c" FOREIGN KEY ("CourseId_id") REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
    ALTER TABLE ONLY public."Teacher_courseregistration" DROP CONSTRAINT "Teacher_courseregist_CourseId_id_9e1bb196_fk_Teacher_c";
       public          postgres    false    3241    222    233            ]           2606    28255 M   Teacher_courseregistration Teacher_courseregist_Name_id_92c9d933_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_courseregistration"
    ADD CONSTRAINT "Teacher_courseregist_Name_id_92c9d933_fk_Teacher_c" FOREIGN KEY ("Name_id") REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 {   ALTER TABLE ONLY public."Teacher_courseregistration" DROP CONSTRAINT "Teacher_courseregist_Name_id_92c9d933_fk_Teacher_c";
       public          postgres    false    233    3241    222            ^           2606    28260 M   Teacher_coursesyllabus Teacher_coursesyllab_courseId_id_6d1f2a8b_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_coursesyllabus"
    ADD CONSTRAINT "Teacher_coursesyllab_courseId_id_6d1f2a8b_fk_Teacher_c" FOREIGN KEY ("courseId_id") REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 {   ALTER TABLE ONLY public."Teacher_coursesyllabus" DROP CONSTRAINT "Teacher_coursesyllab_courseId_id_6d1f2a8b_fk_Teacher_c";
       public          postgres    false    234    222    3241            _           2606    28265 D   Teacher_csvupload Teacher_csvupload_user_id_42769c97_fk_auth_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_csvupload"
    ADD CONSTRAINT "Teacher_csvupload_user_id_42769c97_fk_auth_user_id" FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
 r   ALTER TABLE ONLY public."Teacher_csvupload" DROP CONSTRAINT "Teacher_csvupload_user_id_42769c97_fk_auth_user_id";
       public          postgres    false    236    280    3372            a           2606    28270 N   Teacher_email_BCC Teacher_email_BCC_email_id_5ed1e5b8_fk_Teacher_email_EmailId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_BCC"
    ADD CONSTRAINT "Teacher_email_BCC_email_id_5ed1e5b8_fk_Teacher_email_EmailId" FOREIGN KEY (email_id) REFERENCES public."Teacher_email"("EmailId") DEFERRABLE INITIALLY DEFERRED;
 |   ALTER TABLE ONLY public."Teacher_email_BCC" DROP CONSTRAINT "Teacher_email_BCC_email_id_5ed1e5b8_fk_Teacher_email_EmailId";
       public          postgres    false    239    238    3281            b           2606    28275 D   Teacher_email_BCC Teacher_email_BCC_profile_id_bde0e3ff_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_BCC"
    ADD CONSTRAINT "Teacher_email_BCC_profile_id_bde0e3ff_fk_Institute" FOREIGN KEY (profile_id) REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 r   ALTER TABLE ONLY public."Teacher_email_BCC" DROP CONSTRAINT "Teacher_email_BCC_profile_id_bde0e3ff_fk_Institute";
       public          postgres    false    3215    208    239            c           2606    28280 L   Teacher_email_CC Teacher_email_CC_email_id_a52b181b_fk_Teacher_email_EmailId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_CC"
    ADD CONSTRAINT "Teacher_email_CC_email_id_a52b181b_fk_Teacher_email_EmailId" FOREIGN KEY (email_id) REFERENCES public."Teacher_email"("EmailId") DEFERRABLE INITIALLY DEFERRED;
 z   ALTER TABLE ONLY public."Teacher_email_CC" DROP CONSTRAINT "Teacher_email_CC_email_id_a52b181b_fk_Teacher_email_EmailId";
       public          postgres    false    238    241    3281            d           2606    28285 B   Teacher_email_CC Teacher_email_CC_profile_id_8a708682_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_CC"
    ADD CONSTRAINT "Teacher_email_CC_profile_id_8a708682_fk_Institute" FOREIGN KEY (profile_id) REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 p   ALTER TABLE ONLY public."Teacher_email_CC" DROP CONSTRAINT "Teacher_email_CC_profile_id_8a708682_fk_Institute";
       public          postgres    false    208    3215    241            `           2606    28290 ?   Teacher_email Teacher_email_Email_From_id_acc54e41_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email"
    ADD CONSTRAINT "Teacher_email_Email_From_id_acc54e41_fk_Institute" FOREIGN KEY ("Email_From_id") REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 m   ALTER TABLE ONLY public."Teacher_email" DROP CONSTRAINT "Teacher_email_Email_From_id_acc54e41_fk_Institute";
       public          postgres    false    238    208    3215            e           2606    28295 J   Teacher_email_Email_To Teacher_email_Email__email_id_789297dd_fk_Teacher_e    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_Email_To"
    ADD CONSTRAINT "Teacher_email_Email__email_id_789297dd_fk_Teacher_e" FOREIGN KEY (email_id) REFERENCES public."Teacher_email"("EmailId") DEFERRABLE INITIALLY DEFERRED;
 x   ALTER TABLE ONLY public."Teacher_email_Email_To" DROP CONSTRAINT "Teacher_email_Email__email_id_789297dd_fk_Teacher_e";
       public          postgres    false    3281    244    238            f           2606    28300 L   Teacher_email_Email_To Teacher_email_Email__profile_id_4ade4937_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_email_Email_To"
    ADD CONSTRAINT "Teacher_email_Email__profile_id_4ade4937_fk_Institute" FOREIGN KEY (profile_id) REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 z   ALTER TABLE ONLY public."Teacher_email_Email_To" DROP CONSTRAINT "Teacher_email_Email__profile_id_4ade4937_fk_Institute";
       public          postgres    false    244    208    3215            g           2606    28305 M   Teacher_folder Teacher_folder_UserId_id_25ea40b7_fk_InstituteAdmin_profile_id    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_folder"
    ADD CONSTRAINT "Teacher_folder_UserId_id_25ea40b7_fk_InstituteAdmin_profile_id" FOREIGN KEY ("UserId_id") REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 {   ALTER TABLE ONLY public."Teacher_folder" DROP CONSTRAINT "Teacher_folder_UserId_id_25ea40b7_fk_InstituteAdmin_profile_id";
       public          postgres    false    208    246    3215            h           2606    28310 M   Teacher_module Teacher_module_CourseId_id_50aa9262_fk_Teacher_course_CourseId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_module"
    ADD CONSTRAINT "Teacher_module_CourseId_id_50aa9262_fk_Teacher_course_CourseId" FOREIGN KEY ("CourseId_id") REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 {   ALTER TABLE ONLY public."Teacher_module" DROP CONSTRAINT "Teacher_module_CourseId_id_50aa9262_fk_Teacher_course_CourseId";
       public          postgres    false    3241    222    248            i           2606    28315 G   Teacher_modulefile Teacher_modulefile_ModuleId_id_9e8dce7d_fk_Teacher_m    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_modulefile"
    ADD CONSTRAINT "Teacher_modulefile_ModuleId_id_9e8dce7d_fk_Teacher_m" FOREIGN KEY ("ModuleId_id") REFERENCES public."Teacher_module"("ModuleId") DEFERRABLE INITIALLY DEFERRED;
 u   ALTER TABLE ONLY public."Teacher_modulefile" DROP CONSTRAINT "Teacher_modulefile_ModuleId_id_9e8dce7d_fk_Teacher_m";
       public          postgres    false    3305    250    248            j           2606    28320 T   Teacher_modulefilecontent Teacher_modulefileco_ModuleFileId_id_72056622_fk_Teacher_m    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_modulefilecontent"
    ADD CONSTRAINT "Teacher_modulefileco_ModuleFileId_id_72056622_fk_Teacher_m" FOREIGN KEY ("ModuleFileId_id") REFERENCES public."Teacher_modulefile"(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_modulefilecontent" DROP CONSTRAINT "Teacher_modulefileco_ModuleFileId_id_72056622_fk_Teacher_m";
       public          postgres    false    250    3308    252            k           2606    28325 M   Teacher_modulesyllabus Teacher_modulesyllab_courseId_id_05c97e90_fk_Teacher_m    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_modulesyllabus"
    ADD CONSTRAINT "Teacher_modulesyllab_courseId_id_05c97e90_fk_Teacher_m" FOREIGN KEY ("courseId_id") REFERENCES public."Teacher_module"("ModuleId") DEFERRABLE INITIALLY DEFERRED;
 {   ALTER TABLE ONLY public."Teacher_modulesyllabus" DROP CONSTRAINT "Teacher_modulesyllab_courseId_id_05c97e90_fk_Teacher_m";
       public          postgres    false    3305    254    248            l           2606    28330 B   Teacher_progress Teacher_progress_user_id_dd1966fc_fk_auth_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_progress"
    ADD CONSTRAINT "Teacher_progress_user_id_dd1966fc_fk_auth_user_id" FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
 p   ALTER TABLE ONLY public."Teacher_progress" DROP CONSTRAINT "Teacher_progress_user_id_dd1966fc_fk_auth_user_id";
       public          postgres    false    280    3372    256            m           2606    28335 K   Teacher_question Teacher_question_QuizId_id_f3ba643e_fk_Teacher_quiz_QuizId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_question"
    ADD CONSTRAINT "Teacher_question_QuizId_id_f3ba643e_fk_Teacher_quiz_QuizId" FOREIGN KEY ("QuizId_id") REFERENCES public."Teacher_quiz"("QuizId") DEFERRABLE INITIALLY DEFERRED;
 y   ALTER TABLE ONLY public."Teacher_question" DROP CONSTRAINT "Teacher_question_QuizId_id_f3ba643e_fk_Teacher_quiz_QuizId";
       public          postgres    false    258    260    3327            n           2606    28340 M   Teacher_question Teacher_question_category_id_52ec7234_fk_Teacher_category_id    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_question"
    ADD CONSTRAINT "Teacher_question_category_id_52ec7234_fk_Teacher_category_id" FOREIGN KEY (category_id) REFERENCES public."Teacher_category"(id) DEFERRABLE INITIALLY DEFERRED;
 {   ALTER TABLE ONLY public."Teacher_question" DROP CONSTRAINT "Teacher_question_category_id_52ec7234_fk_Teacher_category_id";
       public          postgres    false    258    220    3239            o           2606    28345 I   Teacher_quiz Teacher_quiz_CourseId_id_7da107e9_fk_Teacher_course_CourseId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_quiz"
    ADD CONSTRAINT "Teacher_quiz_CourseId_id_7da107e9_fk_Teacher_course_CourseId" FOREIGN KEY ("CourseId_id") REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 w   ALTER TABLE ONLY public."Teacher_quiz" DROP CONSTRAINT "Teacher_quiz_CourseId_id_7da107e9_fk_Teacher_course_CourseId";
       public          postgres    false    260    3241    222            p           2606    28350 G   Teacher_quiz Teacher_quiz_Module_id_3b34f714_fk_Teacher_module_ModuleId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_quiz"
    ADD CONSTRAINT "Teacher_quiz_Module_id_3b34f714_fk_Teacher_module_ModuleId" FOREIGN KEY ("Module_id") REFERENCES public."Teacher_module"("ModuleId") DEFERRABLE INITIALLY DEFERRED;
 u   ALTER TABLE ONLY public."Teacher_quiz" DROP CONSTRAINT "Teacher_quiz_Module_id_3b34f714_fk_Teacher_module_ModuleId";
       public          postgres    false    260    248    3305            q           2606    28355 E   Teacher_quiz Teacher_quiz_category_id_5d444d9d_fk_Teacher_category_id    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_quiz"
    ADD CONSTRAINT "Teacher_quiz_category_id_5d444d9d_fk_Teacher_category_id" FOREIGN KEY (category_id) REFERENCES public."Teacher_category"(id) DEFERRABLE INITIALLY DEFERRED;
 s   ALTER TABLE ONLY public."Teacher_quiz" DROP CONSTRAINT "Teacher_quiz_category_id_5d444d9d_fk_Teacher_category_id";
       public          postgres    false    220    3239    260            r           2606    28360 G   Teacher_sitting Teacher_sitting_quiz_id_280a1446_fk_Teacher_quiz_QuizId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_sitting"
    ADD CONSTRAINT "Teacher_sitting_quiz_id_280a1446_fk_Teacher_quiz_QuizId" FOREIGN KEY (quiz_id) REFERENCES public."Teacher_quiz"("QuizId") DEFERRABLE INITIALLY DEFERRED;
 u   ALTER TABLE ONLY public."Teacher_sitting" DROP CONSTRAINT "Teacher_sitting_quiz_id_280a1446_fk_Teacher_quiz_QuizId";
       public          postgres    false    3327    260    262            s           2606    28365 @   Teacher_sitting Teacher_sitting_user_id_a53fd1db_fk_auth_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_sitting"
    ADD CONSTRAINT "Teacher_sitting_user_id_a53fd1db_fk_auth_user_id" FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
 n   ALTER TABLE ONLY public."Teacher_sitting" DROP CONSTRAINT "Teacher_sitting_user_id_a53fd1db_fk_auth_user_id";
       public          postgres    false    262    280    3372            t           2606    28370 T   Teacher_studentcourseprogress Teacher_studentcours_CourseId_id_fe404be7_fk_Teacher_c    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentcourseprogress"
    ADD CONSTRAINT "Teacher_studentcours_CourseId_id_fe404be7_fk_Teacher_c" FOREIGN KEY ("CourseId_id") REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_studentcourseprogress" DROP CONSTRAINT "Teacher_studentcours_CourseId_id_fe404be7_fk_Teacher_c";
       public          postgres    false    3241    264    222            u           2606    28375 U   Teacher_studentcourseprogress Teacher_studentcours_StudentId_id_838739dd_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentcourseprogress"
    ADD CONSTRAINT "Teacher_studentcours_StudentId_id_838739dd_fk_Institute" FOREIGN KEY ("StudentId_id") REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_studentcourseprogress" DROP CONSTRAINT "Teacher_studentcours_StudentId_id_838739dd_fk_Institute";
       public          postgres    false    3215    208    264            v           2606    28380 V   Teacher_studentmodulefileprogress Teacher_studentmodul_FileId_id_e2bc8595_fk_Teacher_m    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress"
    ADD CONSTRAINT "Teacher_studentmodul_FileId_id_e2bc8595_fk_Teacher_m" FOREIGN KEY ("FileId_id") REFERENCES public."Teacher_modulefile"(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress" DROP CONSTRAINT "Teacher_studentmodul_FileId_id_e2bc8595_fk_Teacher_m";
       public          postgres    false    3308    250    266            w           2606    28385 X   Teacher_studentmodulefileprogress Teacher_studentmodul_ModuleId_id_41c42264_fk_Teacher_m    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress"
    ADD CONSTRAINT "Teacher_studentmodul_ModuleId_id_41c42264_fk_Teacher_m" FOREIGN KEY ("ModuleId_id") REFERENCES public."Teacher_module"("ModuleId") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress" DROP CONSTRAINT "Teacher_studentmodul_ModuleId_id_41c42264_fk_Teacher_m";
       public          postgres    false    3305    248    266            y           2606    28390 T   Teacher_studentmoduleprogress Teacher_studentmodul_ModuleId_id_c9fdad01_fk_Teacher_m    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentmoduleprogress"
    ADD CONSTRAINT "Teacher_studentmodul_ModuleId_id_c9fdad01_fk_Teacher_m" FOREIGN KEY ("ModuleId_id") REFERENCES public."Teacher_module"("ModuleId") DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_studentmoduleprogress" DROP CONSTRAINT "Teacher_studentmodul_ModuleId_id_c9fdad01_fk_Teacher_m";
       public          postgres    false    3305    268    248            x           2606    28395 Y   Teacher_studentmodulefileprogress Teacher_studentmodul_StudentId_id_12135e51_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress"
    ADD CONSTRAINT "Teacher_studentmodul_StudentId_id_12135e51_fk_Institute" FOREIGN KEY ("StudentId_id") REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_studentmodulefileprogress" DROP CONSTRAINT "Teacher_studentmodul_StudentId_id_12135e51_fk_Institute";
       public          postgres    false    3215    208    266            z           2606    28400 U   Teacher_studentmoduleprogress Teacher_studentmodul_StudentId_id_5cbeb3ae_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentmoduleprogress"
    ADD CONSTRAINT "Teacher_studentmodul_StudentId_id_5cbeb3ae_fk_Institute" FOREIGN KEY ("StudentId_id") REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_studentmoduleprogress" DROP CONSTRAINT "Teacher_studentmodul_StudentId_id_5cbeb3ae_fk_Institute";
       public          postgres    false    208    268    3215            {           2606    28405 P   Teacher_studentquizprogress Teacher_studentquizp_QuizId_id_a04a2235_fk_Teacher_q    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentquizprogress"
    ADD CONSTRAINT "Teacher_studentquizp_QuizId_id_a04a2235_fk_Teacher_q" FOREIGN KEY ("QuizId_id") REFERENCES public."Teacher_quiz"("QuizId") DEFERRABLE INITIALLY DEFERRED;
 ~   ALTER TABLE ONLY public."Teacher_studentquizprogress" DROP CONSTRAINT "Teacher_studentquizp_QuizId_id_a04a2235_fk_Teacher_q";
       public          postgres    false    270    3327    260            |           2606    28410 S   Teacher_studentquizprogress Teacher_studentquizp_StudentId_id_4e5596d2_fk_Institute    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_studentquizprogress"
    ADD CONSTRAINT "Teacher_studentquizp_StudentId_id_4e5596d2_fk_Institute" FOREIGN KEY ("StudentId_id") REFERENCES public.instituteadmin_profile(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public."Teacher_studentquizprogress" DROP CONSTRAINT "Teacher_studentquizp_StudentId_id_4e5596d2_fk_Institute";
       public          postgres    false    270    208    3215            }           2606    28415 K   Teacher_units Teacher_units_CourseId_id_f67d8790_fk_Teacher_course_CourseId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_units"
    ADD CONSTRAINT "Teacher_units_CourseId_id_f67d8790_fk_Teacher_course_CourseId" FOREIGN KEY ("CourseId_id") REFERENCES public."Teacher_course"("CourseId") DEFERRABLE INITIALLY DEFERRED;
 y   ALTER TABLE ONLY public."Teacher_units" DROP CONSTRAINT "Teacher_units_CourseId_id_f67d8790_fk_Teacher_course_CourseId";
       public          postgres    false    272    3241    222            ~           2606    28420 K   Teacher_units Teacher_units_ModuleId_id_14dc3af9_fk_Teacher_module_ModuleId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Teacher_units"
    ADD CONSTRAINT "Teacher_units_ModuleId_id_14dc3af9_fk_Teacher_module_ModuleId" FOREIGN KEY ("ModuleId_id") REFERENCES public."Teacher_module"("ModuleId") DEFERRABLE INITIALLY DEFERRED;
 y   ALTER TABLE ONLY public."Teacher_units" DROP CONSTRAINT "Teacher_units_ModuleId_id_14dc3af9_fk_Teacher_module_ModuleId";
       public          postgres    false    272    3305    248                       2606    28425 O   auth_group_permissions auth_group_permissio_permission_id_84c5c92e_fk_auth_perm    FK CONSTRAINT     �   ALTER TABLE ONLY public.auth_group_permissions
    ADD CONSTRAINT auth_group_permissio_permission_id_84c5c92e_fk_auth_perm FOREIGN KEY (permission_id) REFERENCES public.auth_permission(id) DEFERRABLE INITIALLY DEFERRED;
 y   ALTER TABLE ONLY public.auth_group_permissions DROP CONSTRAINT auth_group_permissio_permission_id_84c5c92e_fk_auth_perm;
       public          postgres    false    276    278    3370            �           2606    28430 P   auth_group_permissions auth_group_permissions_group_id_b120cbf9_fk_auth_group_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.auth_group_permissions
    ADD CONSTRAINT auth_group_permissions_group_id_b120cbf9_fk_auth_group_id FOREIGN KEY (group_id) REFERENCES public.auth_group(id) DEFERRABLE INITIALLY DEFERRED;
 z   ALTER TABLE ONLY public.auth_group_permissions DROP CONSTRAINT auth_group_permissions_group_id_b120cbf9_fk_auth_group_id;
       public          postgres    false    276    274    3359            �           2606    28435 E   auth_permission auth_permission_content_type_id_2f476e4b_fk_django_co    FK CONSTRAINT     �   ALTER TABLE ONLY public.auth_permission
    ADD CONSTRAINT auth_permission_content_type_id_2f476e4b_fk_django_co FOREIGN KEY (content_type_id) REFERENCES public.django_content_type(id) DEFERRABLE INITIALLY DEFERRED;
 o   ALTER TABLE ONLY public.auth_permission DROP CONSTRAINT auth_permission_content_type_id_2f476e4b_fk_django_co;
       public          postgres    false    288    278    3395            �           2606    28440 D   auth_user_groups auth_user_groups_group_id_97559544_fk_auth_group_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.auth_user_groups
    ADD CONSTRAINT auth_user_groups_group_id_97559544_fk_auth_group_id FOREIGN KEY (group_id) REFERENCES public.auth_group(id) DEFERRABLE INITIALLY DEFERRED;
 n   ALTER TABLE ONLY public.auth_user_groups DROP CONSTRAINT auth_user_groups_group_id_97559544_fk_auth_group_id;
       public          postgres    false    274    281    3359            �           2606    28445 B   auth_user_groups auth_user_groups_user_id_6a12ed8b_fk_auth_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.auth_user_groups
    ADD CONSTRAINT auth_user_groups_user_id_6a12ed8b_fk_auth_user_id FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
 l   ALTER TABLE ONLY public.auth_user_groups DROP CONSTRAINT auth_user_groups_user_id_6a12ed8b_fk_auth_user_id;
       public          postgres    false    280    281    3372            �           2606    28450 S   auth_user_user_permissions auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm    FK CONSTRAINT     �   ALTER TABLE ONLY public.auth_user_user_permissions
    ADD CONSTRAINT auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm FOREIGN KEY (permission_id) REFERENCES public.auth_permission(id) DEFERRABLE INITIALLY DEFERRED;
 }   ALTER TABLE ONLY public.auth_user_user_permissions DROP CONSTRAINT auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm;
       public          postgres    false    278    284    3370            �           2606    28455 V   auth_user_user_permissions auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.auth_user_user_permissions
    ADD CONSTRAINT auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
 �   ALTER TABLE ONLY public.auth_user_user_permissions DROP CONSTRAINT auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id;
       public          postgres    false    3372    284    280            �           2606    28460 G   django_admin_log django_admin_log_content_type_id_c4bce8eb_fk_django_co    FK CONSTRAINT     �   ALTER TABLE ONLY public.django_admin_log
    ADD CONSTRAINT django_admin_log_content_type_id_c4bce8eb_fk_django_co FOREIGN KEY (content_type_id) REFERENCES public.django_content_type(id) DEFERRABLE INITIALLY DEFERRED;
 q   ALTER TABLE ONLY public.django_admin_log DROP CONSTRAINT django_admin_log_content_type_id_c4bce8eb_fk_django_co;
       public          postgres    false    288    286    3395            �           2606    28465 B   django_admin_log django_admin_log_user_id_c564eba6_fk_auth_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.django_admin_log
    ADD CONSTRAINT django_admin_log_user_id_c564eba6_fk_auth_user_id FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
 l   ALTER TABLE ONLY public.django_admin_log DROP CONSTRAINT django_admin_log_user_id_c564eba6_fk_auth_user_id;
       public          postgres    false    280    3372    286            
   R   x�+�4�t��/IM�����O��L��RRJ8Sr3�8���t�t���-�M�-̍�L���Uf����� m$\         p   x�+�4�(��KN-��SN�����,�P�)��y�FFF�f�F
FV��V�FzƆ�&���V��*��+.�,)-I�(�O��I�N.JM�+��/�7�+�K����� |N(0            x������ � �            x������ � �         R   x�3�N����)V(.I,*IM���R�b�)��y��:Ə����H��L��@��������L������L����؀+F��� �d2            x������ � �         �   x�5�K�0D��)|D�����X�b��n��&(M%z{&H��f��5����TS]m���a��K�4��;j�{��|��)6����E� ��t6���I�ɨa��4zhv�
�Ar�^j�P�DW�g��6��a{М�R�����.�I��s��n�ϒ�{1��,�������C�            x������ � �            x������ � �            x�3��u����� ��          H   x�+�4�t6�t��/IM����!S�(�6202�50�52P02�20�24�34004��60�26 FW� pE      !      x������ � �      $      x�3�4�4����� �X      &      x������ � �      (      x�3�4�4����� �X      *      x������ � �      +      x������ � �      ,   G   x�3�t�/-*N����IL*-�70�w
qu�7462���+)�O)M.��ϋw+4��H�+HI�4����� ���      .      x������ � �      0      x������ � �      1      x������ � �      3      x������ � �      6      x������ � �      8      x������ � �      :   N   x�+�4���O)�I5��ӜFFF�f@gY �r&��f�!���L�����L̍�L���Te����� s�z      <   B   x�+�4�t��I5҉)��y�FFF�f�F
F�VFfV&fzffF�&��V��*3����� (�S      >   B  x����N�0E��W�D�(E�v]�BB�=�-O�#i��Y��!ْ5g��	�zq0Z`��reɐ�@{`�����c :��R�	<�J��9(��#9�M�;�(�C��Qi��c?�cV=h+��dV�΃�����K؇<45�a��������K��4ٕ;��8fE�IV4��|RvI�43��:f���]<r1Z��1���9�b��~��)�� �ј�߬(㑜@�r�����!�G���쭜Ѿc�-l��3]���+|�B��ٖ�N�ES5ͪڬ�
�z���^���}�^vm�߶��*���9�/      @      x������ � �      B      x������ � �      D   �   x������@�k�)�秾2mפ٬�Y�Z��b�{�[C�W$�43L�#�Y�b-�X�`;�o�w{��M�$�#9G{����� W2��U��w�p�J8�E��6�}�;l�G��Lx�2���#�*�/k�&����%=\J����l���a,*,�(�Vä�>kBo�IK�yE*Si���iw�u]�ᴈ�      F   3   x�3�,ͬ2�L��/IM�P(�89K8M���3��Ԁ�HB W� s��      H      x������ � �      J      x������ � �      L      x������ � �      N      x������ � �      P      x������ � �      R      x������ � �      T      x������ � �      V      x������ � �      X   �  x�}�ͮ�6���S�	�e;�h�(�Oj �S�����+��HJ��b�;ʡBRr��k?�������aږϢ,����?��#��}P1h=xæAb����q���c��&8{�s\�q���[��Js
Dw��H�E����EEz�����2��z���)��ͣ/DJ���H�V�.p��:,E�MY���Y�z ������w��j���o�����j���5�w�Cǈ)��H�!�w�Wģ?�Wg��ޮb��z�Wm�a|2��wf�g�T�3��&r�!�* ���n�ou�Ĉ�T�k�)\��ѥ�E�kػU(g�2?����U9��h ��� D��7 �:ۥ�ӳ]�~1�&�Mj!��˓J��E���2�PW����6��e{�L.\k9�cU�i㒴�0Mc��E}iֻ�$WW��>'
��Z�Fѭ�U�i�JZ��f�[Ir�}���>�1�ljUt��HUo���HQj��f�N��}Y����Z�'ӜuW%$4T�J�K�
m�JvPb�y����o����x2�*0F�Q���B7D�raƻ!��9}����\S[�U� �RW&=ޞc�n���m�+J8u�q�M�������@C@���y�f9��i�֢���?�V�x ���;0��yhl0��n��8�w��2�w%�$8y�є��l+�S:�����+��[AT�[=��9�M�ǜay'�Y�׹�,�� ^���Bf��*m��5�^�+\���Q.�JuN�� x��O�%Y+�7z��'��,��$����v������K�ɎAo��r�`��Un�2K�=�W���ɬ��&^�N�%��ܑx�h�m�t/*8���\UW�G��l����MP��Ȟu8������Nÿ�s������HVۮ,�l�R����JL�c�H+�
�� ��~?��������Kt������V�Lpz���&0���_
��ǣ�kw��Ш���@j�!���9sK�:uS�2�.H��2M����knQ�э'�о��Hmrby��&$�ɍ��M�f$����m�����KQ�e�p��1���*#`M�c�ys��\�óE���U����3@h� Q��V��X����c�oE�7�S5�Qz?�*IM�{��EEj����=��=�W��RUdF�^nXW������Љ�̨���TqT�p�m�}#���L�8��D�U����D�U���I���"�H��Q�i�u����D�<�T�L�Z��U�k&Z�U�*m�D��"N��\��?e������V5��0�S#hU_�j��8�V���2��#踋�2�?\ǳp�����}0CQ��cd�0�0o�p��iާ��0슰Acb��M$�`S�j�#Q0�E�A$A�;����7��ta����j�����ȗ$Ea��G��1��*�      Z   �  x�}�[o�0���+v����gK��B��H�&�D!	9�,�~�J+�C�|a�^?z���a�~VO
Q�#�  :}h8���~.��C��ERf6�8��v��E��Zd�鋭R�4���쫆 B���"�R	�$���b�n �h��<�
�I�iZ��w��JR#ȏݬ��$���b�Ѓ�ɶI�\M�Q:�MAj���//�	�4����ͽ�B��sx9g$l���d&1�C&L ��k�j��|3w�L,����Ʌ��3w���"�/�G��e��U�7}�[�U�E�I��y�#��E��W�g&�>�E ��b��U�k�yjTwA�7a�'Y�M�$PW[&�RI�0"�_��:?���ʩs����l��TCƽ1羘Z����6�W^<�<o�O�?|*1��w�^Tv��/�� �c̠x�0z��o�r�U      [      x������ � �      ^      x������ � �      `   �  x���Mo�0�s�+��@����G�[?�SQ�҃7v�l%Y�U��^{���hU��o��#�g ���J0ͤ.)� ���d�]���:tU7!�����0�:[h���t��r:����ry`��0���B�6h��Æ�_^�pN5'X*A���'v�;�֍I�����cq\� ����j���3u�����-�7+7��֍��^��ֻ֎1^�VƷ�GT��e:.�ҷ�kH���R:�vp���|�M:�&3�~�>�C���}=n����{ow7����9��bA�j�ܶ�j;�Ǉ0��EY�e���`J�y�2�̓�~�Q�39�8.9���,[7u؎��x5�9ӥ��I��~y.�]�W�{WO��?��ISsMh5��V3����ȣ7��T�H�)��g��\7�.Ӵ
?q���?z      b   O  x�mR�r� <���H���c�=�Bm�0��E�N��ŏ����V�Vgj�c�kt1�A0��MFCd��":�4�qa�뽋�,�'�} #\���3{[���hb�3vٰ�-����H����܀�
q�2�9�@��00��[QQ�^E�>[�b>B�ǂ�~HY���jf�+�w2��%N�D~) �4�f���6��6�~^��0�WoI��J����h�!w�#-��u-m}��Z��r�{2�m� � ���D���X�{O?i�^ �*���M&�6�ZZ��������K��zղr������|r=���@�޷�����+�|���       d   �  x���Oo�0���S�}U4c��m�{ﱒe�X�S5�~M����6�p���g�<�_��� �v����B^�����H���5p�Bs�p U��h�/���0B�&��Y���HՀ��D��=���%ڧ
V�d�0��T�ִg�Չ#4�`�r��xe�&�5Q\p���MEt�dT��`�auj�ks:�b8(TE�(�FIJm�����{����]�f�K#L���23�K��z�G3�]�T@Y6�L�h�G�d���y�le��|�ގ]�j��@UpXpt�-sz����!�!������=i}\��S�w�_�-��=�7s\��R�K���%9y�
�'��,.ï�Ы�Op��[A�w'}����!��;Ϧ�O �d�r ���u�[۱�5]9�(
L}��)���)��LC�h]���)�<o*T��z��]VO�^���U�H���W�侽w��/-&s�	V���~�Z�f�G����p8�(�A      f   X  x��ɒ�0  �s�s���@��hA�f���0(�� �|}����u5|>W$7""��j�8�H8g���ky�O����㬘n$�d;�u�&�'��y~K
��M��������D)w؍!Y<1s`��ɖj�Y'۱���$O���� ���2����7��񮏍Ӭ����K�n_j����ɑ�T;�l�-�����Eb+���ln;���M;�ﭹ���*>�7ң��*�M{��d�ig�K^�{�o��ҷ�O�<U/E����5��J��'6�p��@0 ��oY�wTz��
�蟭0Ӷ�����h�}!��@�G��D\c������_����\,?1F{�         �   x�m���0Dg�+��D����/`)B�,�Z�(�!�W��t7�{��2��M��-�-�ed��C<B/��,M�7��Yjw�I\?��yeU��t��:�L���y����_�1sr��蹹;c��Q'�     