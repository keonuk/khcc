SET TERMOUT On
SET ECHO On

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO khcc IDENTIFIED BY final ;
ALTER USER KHCC DEFAULT TABLESPACE USERS;
ALTER USER KHCC TEMPORARY TABLESPACE TEMP;
CONNECT khcc/final

DROP TABLE ZIPCODE;
DROP TABLE CP_RESERVATION;
DROP TABLE CARPOOL;
DROP TABLE REPORTS;
DROP TABLE COMMENTS;
drop table nt_board;
DROP TABLE QA_BOARD;
DROP TABLE REVIEW_BOARD;
drop table faq_board;
drop table qna_board
DROP TABLE RESERVATION;
DROP TABLE CAR;
DROP TABLE CARD;
drop table RESERVATION_pay;
DROP TABLE MEMBER;


CREATE TABLE MEMBER(
   M_EMAIL      VARCHAR2(100) PRIMARY KEY,
   M_PASSWORD   VARCHAR2(100) NOT NULL,
   M_NAME      VARCHAR2(100) NOT NULL,
   M_BIRTH      VARCHAR2(100) NOT NULL,
   m_phone      VARCHAR2(100) NOT NULL,
   M_ZIPCODE     VARCHAR2(100),
   M_ADDR1     VARCHAR2(100),
   M_ADDR2     VARCHAR2(100),
   M_DRIVERCODE   VARCHAR2(100),
   M_COUPON   VARCHAR2(100),
   M_POINT      NUMBER,
   M_DRIVER   NUMBER DEFAULT 0,
   M_STATE      NUMBER
);

create table card(
   owner varchar2(100) references member(m_email),
   c_name varchar2(100) not null,
   c_num varchar2(100) not null,
   c_expdate varchar2(100) not null,
   c_birth varchar2(100) not null,
   c_pass varchar2(100) not null
);

drop table reservation_pay
select * from reservation_pay

CREATE TABLE RESERVATION_pay(
   RES_ID      VARCHAR2(100) references member(m_email),
   c_kind varchar2(100) not null,
   c_model varchar2(100) not null,
   c_place varchar2(100) not null,
   startDate varchar2(100) not null,
   startTime varchar2(100) not null,
   endDate varchar2(100) not null,
   endTime varchar2(100) not null,
   tot_price NUMBER NOT NULL,
   settle_day DATE default sysdate
);

drop sequence RESERVATION_pay_seq;
create sequence RESERVATION_pay_seq
                increment by 1 start with 1 nocache;

create table zipcode (
   no number PRIMARY KEY,
   ZIPCODE varchar2(7),
   sido varchar2(10),
   gugun varchar2(20),
   dong varchar2(50),
   bunji varchar2(50)
);

CREATE TABLE CAR(
   C_ID      VARCHAR2(100) PRIMARY KEY,
   C_KIND      VARCHAR2(100) NOT NULL,
   C_MODEL      VARCHAR2(100) NOT NULL,
   C_RENTFEE   NUMBER NOT NULL,
   C_OILFEE   NUMBER NOT NULL,
   C_IMG      VARCHAR2(100) NOT NULL,
   C_PLACE      VARCHAR2(100) NOT NULL,
   C_START      DATE,
   C_END      DATE,
   C_STATE      NUMBER DEFAULT 0,
   FOREIGN KEY(C_PLACE) REFERENCES ZONE(Z_PLACE)
);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('cc', 'bmw520d.png', '����', 'BMW520d', 12370, 170, '�︪���� ���ڰ�', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('aa', 'bmw520d.png', '����', 'BMW520d', 12370, 170, '�︪���� ��', null, null, 0);




insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('bb', 'merC.jpg', '������', 'C', 11111, 150, '������ȸ��', null, null, 0);
insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('oo', 'bmw520d.png', '����', 'BMW520d', BMW520d, 12370, 170, '������ȸ��', null, null, 0);




insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('dd', 'merC.jpg', '������', 'C', 11111, 150, '����1���ֹμ���', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('ee', 'merC.jpg', '������', 'C', 11111, 150, '�����', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('ff', 'merC.jpg', '������', 'C', 11111, 150, '���＼����', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('gg', 'merC.jpg', '������', 'C', 11111, 150, '����1����ü��', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('hh', 'merC.jpg', '������', 'C', 11111, 150, '���ΰǰ�������� ����������', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('ii', 'merC.jpg', '������', 'C', 11111, 150, '�ѱ����б��ȸ�� �Ű�', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('jj', 'merC.jpg', '������', 'C', 11111, 150, '�ѱ��ڻ�������� ����������', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('kk', 'merC.jpg', '������', 'C', 11111, 150, '�ѱ������������� ���������', null, null, 0);


insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('ll', 'merC.jpg', '������', 'C', 11111, 150, '�ϳ��������� ����', null, null, 0);


insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('mm', 'merC.jpg', '������', 'C', 11111, 150, '�ѱ�������Ź', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('nn', 'merC.jpg', '������', 'C', 11111, 150, 'JTģ���������� ����', null, null, 0);



CREATE TABLE RESERVATION(
   RES_ID      VARCHAR2(100) NOT NULL,
   RES_CARID   VARCHAR2(100) NOT NULL,
   RES_TOTAL   NUMBER NOT NULL,
   FOREIGN KEY(RES_CARID) REFERENCES CAR(C_ID)
);

create table qa_board(
    qa_num number(38) primary key
  , qa_name varchar2(50) not null
  , qa_pass varchar2(30) not null
  , qa_subject varchar2(100) not null
  , qa_content varchar2(4000) not null
  , qa_file varchar2(100)
  , qa_re_ref number /*�� �׷��ȣ:�亯�� */
  , qa_re_lev number /*�亯�� ȭ�鿡 ���̴� ��ġ */
  , qa_re_seq number /*�亯�� ���� ���� */
  , qa_readcount number /*��ȸ��*/
  , qa_date date /*��ϳ�¥*/
  , qa_original varchar2(100),
  FOREIGN KEY(qa_name) REFERENCES member(m_email)
);

drop sequence qa_board_num_seq;

create sequence qa_board_num_seq
                increment by 1 start with 1 nocache;

create table nt_board(
    nt_num number(38) primary key
  , nt_name varchar2(50) not null
  , nt_pass varchar2(30) not null
  , nt_subject varchar2(100) not null
  , nt_content varchar2(4000) not null
  , nt_file varchar2(100)
  , nt_re_ref number /*�� �׷��ȣ:�亯�� */
  , nt_re_lev number /*�亯�� ȭ�鿡 ���̴� ��ġ */
  , nt_re_seq number /*�亯�� ���� ���� */
  , nt_readcount number /*��ȸ��*/
  , nt_date date /*��ϳ�¥*/
  , nt_original varchar2(100) 
  , FOREIGN KEY(nt_name) REFERENCES member(m_email)
);

drop sequence nt_board_num_seq;
create sequence nt_board_num_seq
                increment by 1 start with 1 nocache;

create table faq_board(
    faq_num number(38) primary key
  , faq_name varchar2(50) not null
  , faq_pass varchar2(30) not null
  , faq_subject varchar2(100) not null
  , faq_content varchar2(4000) not null
  , faq_file varchar2(100)
  , faq_re_ref number /*�� �׷��ȣ:�亯�� */
  , faq_re_lev number /*�亯�� ȭ�鿡 ���̴� ��ġ */
  , faq_re_seq number /*�亯�� ���� ���� */
  , faq_readcount number /*��ȸ��*/
  , faq_date date /*��ϳ�¥*/
  , faq_original varchar2(100) 
  , FOREIGN KEY(faq_name) REFERENCES member(m_email)
);

drop sequence faq_board_num_seq;
create sequence faq_board_num_seq
                increment by 1 start with 1 nocache;

create table qna_board(
    qna_num number(38) primary key
  , qna_name varchar2(50) not null
  , qna_pass varchar2(30) not null
  , qna_subject varchar2(100) not null
  , qna_content varchar2(4000) not null
  , qna_file varchar2(100)
  , qna_re_ref number /*�� �׷��ȣ:�亯�� */
  , qna_re_lev number /*�亯�� ȭ�鿡 ���̴� ��ġ */
  , qna_re_seq number /*�亯�� ���� ���� */
  , qna_readcount number /*��ȸ��*/
  , qna_date date /*��ϳ�¥*/
  , qna_original varchar2(100) 
  , FOREIGN KEY(qna_name) REFERENCES member(m_email)
);

drop sequence qna_board_num_seq
create sequence qna_board_num_seq
                increment by 1 start with 1 nocache;

CREATE TABLE REVIEW_BOARD(
   RB_NUM      NUMBER PRIMARY KEY,
   RB_ID      VARCHAR2(100) NOT NULL,
   RB_SUBJECT   VARCHAR2(300) NOT NULL,
   RB_CONTENT   VARCHAR2(4000) NOT NULL,
   RB_SCORE   NUMBER NOT NULL,
   RB_IMG      VARCHAR2(100),
   RB_DATE      DATE DEFAULT SYSDATE,
   RB_CATEGORY   VARCHAR2(100)
);

DROP SEQUENCE RB_NUM_SEQ;

CREATE SEQUENCE RB_NUM_SEQ
   INCREMENT BY 1
   START WITH 1 NOCACHE;

CREATE TABLE COMMENTS(
   C_NUM      NUMBER PRIMARY KEY,
   C_ID      VARCHAR2(50) NOT NULL,
   C_CONTENT   VARCHAR2(1000) NOT NULL,
   C_REF      NUMBER,
   C_DATE      DATE DEFAULT SYSDATE,
   FOREIGN KEY(C_REF) REFERENCES REVIEW_BOARD(RB_NUM)
);

DROP SEQUENCE COMM_NUM_SEQ;

CREATE SEQUENCE COMM_NUM_SEQ
   INCREMENT BY 1
   START WITH 1 NOCACHE;

CREATE TABLE REPORTS(
   R_NUM      NUMBER PRIMARY KEY,
   R_CATEGORY  VARCHAR2(100) NOT NULL,
   R_SENDER   VARCHAR2(100),
   R_RECEIVER   VARCHAR2(100) DEFAULT 'admin',
   R_CONTENT   VARCHAR2(4000) NOT NULL,
   R_DATE      DATE DEFAULT SYSDATE,
   R_ILLEGALID   VARCHAR2(100) NOT NULL,
   R_IMG      VARCHAR2(100),
   R_ORGIMG      VARCHAR2(100)
);

DROP SEQUENCE R_NUM_SEQ;

CREATE SEQUENCE R_NUM_SEQ
   INCREMENT BY 1
   START WITH 1 NOCACHE;

CREATE TABLE CARPOOL(
   CP_NUM      NUMBER PRIMARY KEY,
   CP_ID      VARCHAR2(100) NOT NULL,
   CP_DEPART   VARCHAR2(100) NOT NULL,
   CP_ARRIVE   VARCHAR2(100) NOT NULL,
   CP_TIME      DATE NOT NULL,
   CP_REGDATE   DATE DEFAULT SYSDATE,
   CP_SUM      NUMBER NOT NULL,
   CP_DISTANCE   NUMBER(6,2) NOT NULL,
   CP_VALID   NUMBER DEFAULT 0
);

DROP SEQUENCE CP_NUM_SEQ;

CREATE SEQUENCE CP_NUM_SEQ
   INCREMENT BY 1
   START WITH 1 NOCACHE;      

CREATE TABLE CP_RESERVATION(
   CR_DRIVER   VARCHAR2(100) NOT NULL,
   CR_RIDER   VARCHAR2(100) NOT NULL,
   CR_NUM      NUMBER NOT NULL,
   FOREIGN KEY(CR_NUM) REFERENCES CARPOOL(CP_NUM)
);

COMMIT;

SET TERMOUT ON
SET ECHO ON