--faq_board
drop table faq_board;
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

select countfaq_num) as �Ѱ��� from faq_board;
drop sequence faq_board_num_seq
create sequence faq_board_num_seq
                increment by 1 start with 1 nocache;
                
select * from faq_board;