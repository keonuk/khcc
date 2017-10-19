package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import com.khcc.myweb.model.CardBean;
import com.khcc.myweb.model.MemberBean;

public interface MemberService {
	/* ���̵� �ߺ� üũ */
	public int checkMemberId(String id) throws Exception;

	/* ��� �˻� */
	public MemberBean findpwd(Map pm) throws Exception;

	/* ȸ������ */
	public void insertMember(MemberBean m) throws Exception;

	/* �α��� ���� üũ */
	public MemberBean userCheck(String email) throws Exception;

	/* ȸ�� Ż�� */
	public int deleteMember(MemberBean delm) throws Exception;

	/* ��й�ȣ ���� */
	public void updatePass(Map up) throws Exception;

	/* �޴��� ��ȣ ���� */
	public void updatePhone(Map up) throws Exception;

	/* �������� ��� */
	public void updateDcode(Map up) throws Exception;

	/* �ּ� ��� */
	public void addrUpdate(Map ua) throws Exception;

	/* ī�� ��� */
	public void insertCard(MemberBean c);
	
	/* ī�� ���� ��ȸ */
	public MemberBean selectCard(String login_email) throws Exception;

	/* ī�� ���� */
	public void deleteCard(Map<String, String> dc) throws Exception;

	/* ���� ���� ��ȸ */
	public List<MemberBean> selectPay(String login_email) throws Exception;
	
	public List<MemberBean> getMemList() throws Exception;
}
