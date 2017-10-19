package com.khcc.myweb.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khcc.myweb.dao.MemberService;
import com.khcc.myweb.model.CardBean;
import com.khcc.myweb.model.MemberBean;

@Controller // Action ��üȭ ��
			// ���ο��� 1. ��Ʈ�ѷ� �ֳ����̼� Ȯ�� 2. ���� �ּ� Ȯ��
public class MemberAction {

	@Autowired
	private MemberService memberService;

	// Ȩ ȭ��
	@RequestMapping(value = "/khcc_home.nhn")
	public String khcc_home() throws Exception {
		return "member/khcc_home";
	}

	/* �α��� �� �� */
	@RequestMapping(value = "/khcc_login.nhn")
	public String khcc_login() throws Exception {
		return "member/khcc_login";
		// member ������ khcc_login.jsp �� ������ ����
	}

	/* �α׾ƿ� �� */
	@RequestMapping(value = "/khcc_logout.nhn")
	public void member_logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('�α׾ƿ� �Ǿ����ϴ�.')");
			out.println("location='khcc_home.nhn'");
			out.println("</script>");

			session.invalidate();// ���Ǹ���

		}
	}

	/* ȸ������ �� */
	@RequestMapping(value = "/khcc_join.nhn")
	public String khcc_join() {
		return "member/khcc_join";
		// member ������ khcc_join.jsp �� ������ ����
	}

	/* �����ȣ, �ּ� ��� */
	@RequestMapping(value = "/addr_reg_ok.nhn", method = RequestMethod.POST)
	public ModelAndView addr_reg_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// ���̵� Ű���� ���Ǿ��̵� ����
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// ���� ���̵� ���� ���� ���
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {

			String sample3_postcode = request.getParameter("sample3_postcode");
			String sample3_address = request.getParameter("sample3_address");
			String sample3_address2 = request.getParameter("sample3_address2");

			Map<String, String> ua = new HashMap<String, String>();
			ua.put("login_email", login_email);
			ua.put("sample3_postcode", sample3_postcode);
			ua.put("sample3_address", sample3_address);
			ua.put("sample3_address2", sample3_address2);

			this.memberService.addrUpdate(ua);

			MemberBean update_address = this.memberService.userCheck(login_email);

			ModelAndView mv = new ModelAndView("member/khcc_mypage");
			mv.addObject("info", update_address);

			return mv;
		}
		return null;
	}

	/* �����ȣ, �ּ� ���� */
	@RequestMapping(value = "/addr_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView addr_edit_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// ���̵� Ű���� ���Ǿ��̵� ����
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// ���� ���̵� ���� ���� ���
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {

			String sample3_postcode = request.getParameter("sample3_postcode");
			String sample3_address = request.getParameter("sample3_address");
			String sample3_address2 = request.getParameter("sample3_address2");

			Map<String, String> ua = new HashMap<String, String>();
			ua.put("login_email", login_email);
			ua.put("sample3_postcode", sample3_postcode);
			ua.put("sample3_address", sample3_address);
			ua.put("sample3_address2", sample3_address2);

			this.memberService.addrUpdate(ua);

			MemberBean update_address = this.memberService.userCheck(login_email);

			ModelAndView mv = new ModelAndView("member/khcc_mypage");
			mv.addObject("info", update_address);

			return mv;
		}
		return null;
	}

	// ID�ߺ��˻� ajax�Լ��� ó���κ�
	@RequestMapping(value = "/member_idcheck.nhn", method = RequestMethod.POST)
	public void member_idcheck(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();
		String id = request.getParameter("memid");

		Map<String, String> jm = new HashMap<String, String>();
		jm.put("check_id", id);

		int re = memberService.checkMemberId(id);
		out.print(re);

	}

	/* ���ã�� �Ϸ� */
	@RequestMapping(value = "/pwd_find_ok.nhn", method = RequestMethod.POST)
	public ModelAndView pwd_find_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		String name = request.getParameter("name").trim();

		Map<String, String> pm = new HashMap<String, String>();
		// �÷��� Map�� Ű�� �� �����մϴ�.
		pm.put("id", id);
		pm.put("name", name);

		MemberBean member = this.memberService.findpwd(pm);

		if (member == null) {// ȸ�� ���̵�� �̸��� ���� �ʴ� ���
			out.println("<script>");
			out.println("alert('ȸ�����̵�� �̸��� ���� �ʽ��ϴ�!')");
			out.println("history.go(-1)");
			out.println("</script>");
		} else {
			ModelAndView pwdM = new ModelAndView("member/pwd_find");
			pwdM.addObject("pwdok", member.getM_password());
			return pwdM;
		}
		return null;
	}

	/* ȸ�� ���� ���� */
	// ��� name �Ӽ� �� = �ڹٴ� Bean �ʵ� �� = ���̹�Ƽ�� �÷���
	@RequestMapping(value = "/member_join_ok.nhn", method = RequestMethod.POST)
	public void member_join_ok(MemberBean m, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String m_phone = m.getM_phone1() + "-" + m.getM_phone2() + "-" + m.getM_phone3();

		// ���� ���̵� : m.getM_email()
		// ���� ������ : m.getM_maildomain()
		String m_email = m.getM_email() + "@" + m.getM_maildomain();// ���� �ּ�
		m.setM_phone(m_phone);
		m.setM_email(m_email);

		this.memberService.insertMember(m);

		// �α��� �������� �̵�
		response.sendRedirect("khcc_login.nhn");
	}

	/* �α��� ���� */
	@RequestMapping(value = "/khcc_login_ok.nhn", method = RequestMethod.POST)
	public ModelAndView khcc_login_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// HttpSession Ŭ������ ���ǰ�ü�� �����ؼ� �α��� ���� ó���� �ϱ� ���ؼ��Դϴ�.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();// ��½�Ʈ�� ��ü ����
		HttpSession session = request.getSession();// ���� ��ü ����

		String login_email = request.getParameter("login_email").trim();
		String login_password = request.getParameter("login_password").trim();

		MemberBean m = this.memberService.userCheck(login_email);

		if (m == null) {// ��ϵ��� ���� ȸ���϶�
			out.println("<script>");
			out.println("alert('��ϵ��� ���� ȸ���Դϴ�!')");
			out.println("history.back()");
			out.println("</script>");
		} else {// ��ϵ� ȸ���϶�
			if (m.getM_password().equals(login_password)) {// ����� ������
				session.setAttribute("login_email", login_email);

				String m_name = m.getM_name();
				session.setAttribute("m_name", m_name);

				ModelAndView loginM = new ModelAndView("member/khcc_home");
				return loginM;
			} else {// ����� �ٸ���
				out.println("<script>");
				out.println("alert('��й�ȣ�� �ٸ��ϴ�!')");
				out.println("history.go(-1)");
				out.println("</script>");
			}
		}
		return null;
	}

	// ������������ : ȸ�������ҷ�����
	@RequestMapping(value = "/khcc_adminpage.nhn")
	public ModelAndView khcc_adminpage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String login_email = (String) session.getAttribute("login_email");

		MemberBean mypage = this.memberService.userCheck(login_email);

		String drivercode = (String) mypage.getM_drivercode();
		// java.util ��Ű���� StringTokenizer Ŭ������ ù��° �������ڸ�
		// �ι�° -�� �������� ���ڿ��� �Ľ��� �ݴϴ�.c1

		ModelAndView mm = new ModelAndView("member/khcc_adminpage");
		// ���� ��ȣ ����
		if (drivercode != null) {
			StringTokenizer st01 = new StringTokenizer(drivercode, "-");
			mm.addObject("d1", st01.nextToken());
			mm.addObject("d2", st01.nextToken());
			mm.addObject("d3", st01.nextToken());
			mm.addObject("d4", st01.nextToken());
		}
		mm.addObject("login_email", login_email);
		mm.addObject("info", mypage);

		MemberBean mycard = this.memberService.selectCard(login_email);

		if (mycard != null) {
			String cardNum = (String) mycard.getC_num();
			// java.util ��Ű���� StringTokenizer Ŭ������ ù��° �������ڸ�
			// �ι�° -�� �������� ���ڿ��� �Ľ��� �ݴϴ�.

			// ī�� ���� ����
			StringTokenizer st1 = new StringTokenizer(cardNum, "-");

			mm.addObject("c1", st1.nextToken());
			mm.addObject("c2", st1.nextToken());
			mm.addObject("c3", st1.nextToken());
			mm.addObject("c4", st1.nextToken());
			mm.addObject("c_name", mycard.getC_name());
			mm.addObject("c_expdate", mycard.getC_expdate());
		}
		mm.addObject("login_email", login_email);

		// ȸ������Ʈ
		List<MemberBean> memlist = this.memberService.getMemList();
		if (memlist != null) {
			mm.addObject("memlist", memlist);
		}

		return mm;
	}

	// ���������� : �� ���� �ҷ�����
	@RequestMapping(value = "/khcc_mypage.nhn")
	public ModelAndView khcc_mypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('�α��� ���ּ���!')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {

			MemberBean mypage = this.memberService.userCheck(login_email);

			String drivercode = (String) mypage.getM_drivercode();
			// java.util ��Ű���� StringTokenizer Ŭ������ ù��° �������ڸ�
			// �ι�° -�� �������� ���ڿ��� �Ľ��� �ݴϴ�.c1

			ModelAndView mm = new ModelAndView("member/khcc_mypage");
			// ���� ��ȣ ����
			if (drivercode != null) {
				StringTokenizer st01 = new StringTokenizer(drivercode, "-");
				mm.addObject("d1", st01.nextToken());
				mm.addObject("d2", st01.nextToken());
				mm.addObject("d3", st01.nextToken());
				mm.addObject("d4", st01.nextToken());
			}
			mm.addObject("login_email", login_email);
			mm.addObject("info", mypage);

			MemberBean mycard = this.memberService.selectCard(login_email);

			if (mycard != null) {
				String cardNum = (String) mycard.getC_num();
				// java.util ��Ű���� StringTokenizer Ŭ������ ù��° �������ڸ�
				// �ι�° -�� �������� ���ڿ��� �Ľ��� �ݴϴ�.

				// ī�� ���� ����
				StringTokenizer st1 = new StringTokenizer(cardNum, "-");

				mm.addObject("c1", st1.nextToken());
				mm.addObject("c2", st1.nextToken());
				mm.addObject("c3", st1.nextToken());
				mm.addObject("c4", st1.nextToken());
				mm.addObject("c_name", mycard.getC_name());
				mm.addObject("c_expdate", mycard.getC_expdate());
			}
			mm.addObject("login_email", login_email);

			// ���� ���� ����
			List<MemberBean> paylist = this.memberService.selectPay(login_email);
			MemberBean cardinfo = this.memberService.selectCard(login_email);

			if (paylist != null) {
				// ������, ����(�� ��ġ), ī�� �̸�, �ݾ�
				mm.addObject("pay", paylist);
				mm.addObject("card", cardinfo);
			}

			return mm;
		}
		return null;
	}

	/* ��й�ȣ ���� �� */
	@RequestMapping(value = "/pass_edit_ok.nhn")
	public ModelAndView pass_edit(MemberBean m, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// ���̵� Ű���� ���Ǿ��̵� ����
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// ���� ���̵� ���� ���� ���
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			// ���� â���� �Է��� �� ��й�ȣ
			String new_pass = request.getParameter("new_pass1");

			Map<String, String> up = new HashMap<String, String>();
			// �÷��� Map�� Ű�� �� �����մϴ�.
			up.put("new_pass", new_pass);
			up.put("login_email", login_email);

			// ��й�ȣ ������Ʈ
			this.memberService.updatePass(up);

			MemberBean update_info = this.memberService.userCheck(login_email);

			ModelAndView mv = new ModelAndView("member/khcc_mypage");
			mv.addObject("info", update_info);

			return mv;
		}
		return null;
	}

	/* �޴��� ��ȣ ���� �� */
	@RequestMapping(value = "/phone_edit_ok.nhn")
	public ModelAndView phone_edit_ok(MemberBean m, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// ���̵� Ű���� ���Ǿ��̵� ����
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// ���� ���̵� ���� ���� ���
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			String new_phone1 = request.getParameter("new_phone1");
			String new_phone2 = request.getParameter("new_phone2");
			String new_phone3 = request.getParameter("new_phone3");

			String new_phone = new_phone1 + "-" + new_phone2 + "-" + new_phone3;

			Map<String, String> up = new HashMap<String, String>();
			// �÷��� Map�� Ű�� �� �����մϴ�.
			up.put("new_phone", new_phone);
			up.put("login_email", login_email);

			// ��й�ȣ ������Ʈ
			this.memberService.updatePhone(up);

			MemberBean update_info = this.memberService.userCheck(login_email);

			ModelAndView mv = new ModelAndView("member/khcc_mypage");
			mv.addObject("info", update_info);

			return mv;
		}
		return null;
	}

	/* ī���ȣ ��� */
	@RequestMapping(value = "/card_reg_ok.nhn")
	public void card_reg_ok(MemberBean C, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// ���̵� Ű���� ���Ǿ��̵� ����
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// ���� ���̵� ���� ���� ���
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			// ī���ȣ
			String cardNum1 = request.getParameter("cardNum1");
			String cardNum2 = request.getParameter("cardNum2");
			String cardNum3 = request.getParameter("cardNum3");
			String cardNum4 = request.getParameter("cardNum4");

			String c_num = cardNum1 + "-" + cardNum2 + "-" + cardNum3 + "-" + cardNum4;

			// ī�� �̸�
			String c_name = request.getParameter("cardName");

			// ī�� ��ȿ�Ⱓ
			String expiryMonth = request.getParameter("expiryMonth");
			String expiryYear = request.getParameter("expiryYear");

			String c_expdate = expiryMonth + expiryYear;

			// ī�� �������
			String c_birth = request.getParameter("cardbirth");

			// ī�� ��й�ȣ �� 2�ڸ�
			String c_pass = request.getParameter("cardpass");

			// ����� ī�� ���� set
			C.setOwner(login_email);
			C.setC_name(c_name);
			C.setC_num(c_num);
			C.setC_expdate(c_expdate);
			C.setC_birth(c_birth);
			C.setC_pass(c_pass);

			this.memberService.insertCard(C);

			response.sendRedirect("khcc_mypage.nhn");

		}
	}

	/* ī�� ���� */
	@RequestMapping(value = "/card_delete.nhn")
	public void card_delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();// ��� ��Ʈ�� ��ü ����
		HttpSession session = request.getSession();// ���� ��ü ����

		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			String c1 = (String) request.getParameter("c1");
			String c2 = (String) request.getParameter("c2");
			String c3 = (String) request.getParameter("c3");
			String c4 = (String) request.getParameter("c4");

			String c_num = c1 + "-" + c2 + "-" + c3 + "-" + c4;

			String c_expdate = (String) request.getParameter("c_expdate");

			Map<String, String> dc = new HashMap<String, String>();
			dc.put("c_num", c_num);
			dc.put("c_expdate", c_expdate);

			this.memberService.deleteCard(dc);// ���� �޼��� ȣ��

			out.println("<script>");
			out.println("alert('�����Ͻ� ī�尡 �����Ǿ����ϴ�.')");
			out.println("</script>");
			response.sendRedirect("khcc_mypage.nhn");
		}
	}

	/* �������� ��� */
	@RequestMapping(value = "/drivercode.nhn")
	public void drivercode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");

		String m_drivercode1 = request.getParameter("m_drivercode1");
		String m_drivercode2 = request.getParameter("m_drivercode2");
		String m_drivercode3 = request.getParameter("m_drivercode3");
		String m_drivercode4 = request.getParameter("m_drivercode4");

		String m_drivercode = m_drivercode1 + "-" + m_drivercode2 + "-" + m_drivercode3 + "-" + m_drivercode4;

		Map<String, String> up = new HashMap<String, String>();
		// �÷��� Map�� Ű�� �� �����մϴ�.
		up.put("m_drivercode", m_drivercode);
		up.put("login_email", login_email);

		// ���� ���� ������Ʈ
		this.memberService.updateDcode(up);
		response.sendRedirect("khcc_mypage.nhn");
	}

	/* ȸ������ ���� �� */
	@RequestMapping(value = "/member_delete.nhn")
	public ModelAndView member_del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();// ��� ��Ʈ�� ��ü ����
		HttpSession session = request.getSession();// ���� ��ü ����

		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			MemberBean deleteM = this.memberService.userCheck(login_email);

			ModelAndView dm = new ModelAndView("member/member_del");
			dm.addObject("login_email", login_email);
			dm.addObject("m_name", deleteM.getM_name());
			return dm;
		}
		return null;
	}

	@RequestMapping(value = "/admin_delete.nhn")
	public String admin_del(HttpServletResponse response, @RequestParam("del_id") String del_id) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		MemberBean delm = new MemberBean();
		delm.setM_email(del_id);
		int del_ok = this.memberService.deleteMember(delm);

		if (del_ok != 0) {
			out.println("<script>");
			out.println("alert('Ż��Ϸ�');");
			out.println("location.href='khcc_adminpage.nhn';");
			out.println("</script>");
		}
		
		return null;
	}

	/* ȸ������ ���� �Ϸ� */
	@RequestMapping(value = "/member_del_ok.nhn", method = RequestMethod.POST)
	public void member_del_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			String pass = request.getParameter("del_password").trim();

			MemberBean member = this.memberService.userCheck(login_email);

			if (!member.getM_password().equals(pass)) {
				out.println("<script>");
				out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				MemberBean delm = new MemberBean();
				delm.setM_email(login_email);

				this.memberService.deleteMember(delm);// ���� �޼��� ȣ��

				session.invalidate();// ���Ǹ���

				response.sendRedirect("khcc_home.nhn");
			}
		}
	}
}
