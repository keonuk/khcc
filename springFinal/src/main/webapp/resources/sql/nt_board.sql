--nt_board
drop table nt_board;
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

select countnt_num) as �Ѱ��� from nt_board;
drop sequence nt_board_num_seq
create sequence nt_board_num_seq
                increment by 1 start with 1 nocache;
                
select * from nt_board;