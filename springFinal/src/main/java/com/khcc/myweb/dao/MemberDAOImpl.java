package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khcc.myweb.model.CardBean;
import com.khcc.myweb.model.MemberBean;

@Repository
public class MemberDAOImpl {

	@Autowired
	private SqlSessionTemplate sqlsession;

	/***** ���̵� �ߺ� üũ *****/
	public int checkMemberId(String id) throws Exception {
		int re = -1;
		try {
			MemberBean mb = (MemberBean) sqlsession.selectOne("id_check", id);
			if (mb != null)
				re = 1;
		} catch (Exception e) {
			System.out.println("���̵� �ߺ� üũ ����");
		}
		return re;
	}

	/***** ���̵� �ߺ� üũ �� *****/

	/* ��� �˻� */
	public MemberBean findpwd(Map pm) throws Exception {
		return (MemberBean) sqlsession.selectOne("pwd_find", pm);
	}

	/* ȸ������ */
	public void insertMember(MemberBean m) throws Exception {
		sqlsession.insert("member_join", m);
	}

	/* �α��� ���� üũ */
	public MemberBean userCheck(String email) throws Exception {
		MemberBean m = (MemberBean) sqlsession.selectOne("login_check", email);
		return m;
	}

	/* ȸ������ */
	public int deleteMember(MemberBean delm) throws Exception {
		return sqlsession.update("member_delete", delm);
	}

	/* ȸ������ */
	public void updateMember(MemberBean member) throws Exception {
		sqlsession.update("member_edit", member);
	}

	/* ��й�ȣ ���� */
	public void updatePass(Map up) throws Exception {
		sqlsession.update("pass_edit", up);
	}

	/* �޴��� ��ȣ ���� */
	public void updatePhone(Map up) throws Exception {
		sqlsession.update("phone_edit", up);
	}

	/* �������� ���� ��� */
	public void updateDcode(Map ud) {
		sqlsession.update("drivercode_edit", ud);
	}

	/* �ּ� ��� */
	public void addrUpdate(Map ua) {
		sqlsession.update("addr_update", ua);
	}
	
	/* ī�� ��� */
	public void insertCard(MemberBean c) {
		sqlsession.insert("reg_card",c);
	}
	
	/* ī�� ������ȸ */
	public MemberBean selectCard(String login_email) throws Exception {
		return (MemberBean)sqlsession.selectOne("Card_select", login_email);
	}
	
	/* ī�� ���� */
	public void deleteCard(Map dc) {
		sqlsession.delete("delete_card", dc);
	}

	/* ���� ���� ��ȸ */
	public List<MemberBean> selectPay(String login_email) {
		return sqlsession.selectList("select_pay", login_email);
	}

	public List<MemberBean> getMemList() {
		return sqlsession.selectList("memlist");
	}
}
