select * from user_sequences;
select * from carpool;
select * from MEMBER;
update CARPOOL 
set cp_valid = 0 
where cp_valid = 1;
select * from reservation_pay;

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('cc', 'bmw520d.png', '����', 'BMW520d', 12370, 170, '�︪���� ���ڰ�', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('aa', 'bmw520d.png', '����', 'BMW520d', 12370, 170, '�︪���� ��', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('bb', 'merC.jpg', '������', 'C', 11111, 150, '������ȸ��', null, null, 0);

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

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('aa', 'bmw520d.png', '����', 'BMW520d', 12370, 170, '�︪���� ��', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('bb', 'merC.jpg', '������', 'C', 11111, 150, '������ȸ��', null, null, 0);

select * from car;
insert into carpool values(cp_num_seq.nextval, '3', '���￪', '�λ꿪', '2017/09/10', sysdate, 100000, 300, 0);

insert into carpool values(cp_num_seq.nextval, '4', '������', '�ų�����', '2017/09/12', sysdate-1, 80000, 1, 0);

insert into carpool values(cp_num_seq.nextval, '2', '��꿪', '���ǵ���', '2017/09/12', sysdate-3, 6000, 5, 0);

insert into carpool values(cp_num_seq.nextval, '1', '��濪', '�뷮����', '2017/09/12', sysdate-2, 8000, 3, 0);

insert into carpool values(cp_num_seq.nextval, '0', '���￪', '���̿�', '2017/09/12', sysdate-10, 80000, 10, 0);

insert into carpool values(cp_num_seq.nextval, '9', '���̿�', '�̴뿪', '2017/09/12', sysdate, 1000, 4, 0);

insert into carpool values(cp_num_seq.nextval, '5', '��濪', '�뷮����', '2017/09/12', sysdate-4, 8000, 3, 0);

insert into carpool values(cp_num_seq.nextval, '6', '��濪', '�뷮����', '2017/09/12', sysdate, 8000, 3, 0);

insert into carpool values(cp_num_seq.nextval, '11', '������', '�ų�����', '2017/09/12', sysdate-10, 4, 1, 0);

insert into carpool values(cp_num_seq.nextval, '13', '���￪', '�λ꿪', '2017/09/12', sysdate, 100000, 300, 0);

insert into carpool values(cp_num_seq.nextval, '4', '������', '�ų�����', '2017/09/12', sysdate-1, 80000, 1, 0);

insert into carpool values(cp_num_seq.nextval, '2', '��꿪', '���ǵ���', '2017/09/12', sysdate-3, 6000, 5, 0);

insert into carpool values(cp_num_seq.nextval, '1', '��濪', '�뷮����', '2017/09/12', sysdate-2, 8000, 3, 0);

insert into carpool values(cp_num_seq.nextval, '0', '���￪', '���̿�', '2017/09/12', sysdate-10, 80000, 10, 0);

insert into carpool values(cp_num_seq.nextval, '9', '���̿�', '�̴뿪', '2017/09/12', sysdate, 1000, 4, 0);

insert into carpool values(cp_num_seq.nextval, '5', '��濪', '�뷮����', '2017/09/12', sysdate-4, 8000, 3, 0);

commit

update carpool set cp_valid = 1 where cp_num = 1;

select count(*) from carpool where cp_depart like '���￪' and cp_valid = 0;

select * 
		from 
		  (select rownum rnum, cp_num, cp_id, cp_depart, 
		   cp_arrive, cp_time,  cp_regdate, cp_sum, cp_distance  
		   from  
	  	      (select * from carpool 
	  	       where cp_valid = 0 
	  	       order by cp_regdate desc)
	  	   );