--qna_board
drop table qna_board
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

select countqna_num) as �Ѱ��� from qna_board;

drop sequence qna_board_num_seq
create sequence qna_board_num_seq
                increment by 1 start with 1 nocache;
                
select * from qna_board;