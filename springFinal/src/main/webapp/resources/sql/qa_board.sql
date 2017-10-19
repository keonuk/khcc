--qa_board
drop table qa_board
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
  , qa_original varchar2(100)
  , FOREIGN KEY(qa_name) REFERENCES member(m_email)
);

select countqa_num) as �Ѱ��� from qa_board;

drop sequence qa_board_num_seq
create sequence qa_board_num_seq
                increment by 1 start with 1 nocache;
                
select * from qa_board;