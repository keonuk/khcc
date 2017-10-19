package com.khcc.myweb.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.khcc.myweb.dao.MemberService;
import com.khcc.myweb.dao.ReservationService;
import com.khcc.myweb.model.CarBean;
import com.khcc.myweb.model.MemberBean;

@Controller // Action ��üȭ ��
			// ���ο��� 1. ��Ʈ�ѷ� �ֳ����̼� Ȯ�� 2. ���� �ּ� Ȯ��
public class ReservationAction {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private MemberService memberService;

	// �ǽð� ���� ȭ��
	@RequestMapping(value = "/khcc_reservation.nhn")
	public ModelAndView khcc_reservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ModelAndView mm = null;
		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('�α����� �ʿ��� �����Դϴ�.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			MemberBean mycard = this.memberService.selectCard(login_email);
			if (mycard != null) {
				String cardNum = (String) mycard.getC_num();
				String cardName = (String) mycard.getC_name();

				Map m = new HashMap();
				m.put("cardNum", cardNum);
				m.put("cardName", cardName);

				mm = new ModelAndView("reservation/khcc_reservation");
				mm.addObject("cardNum", cardNum);
				mm.addObject("cardName", cardName);
				return mm;
			} else {
				out.println("<script>");
				out.println("alert('����� ī�� ����� �ʿ��� �����Դϴ�.')");
				out.println("location.href='khcc_mypage.nhn'");
				out.println("</script>");
			}
			
		}
		return null;
	}

	// �ڵ��� ���� �ҷ�����
	@RequestMapping(value = "/khcc_ajax.nhn")
	@ResponseBody
	public Object khcc_ajax(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("title") String title) throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		List<CarBean> cb = reservationService.selectCar(title);

		return cb;
	}

	@RequestMapping(value = "/khcc_reservation_total.nhn")
	public void khcc_reservation_total(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String c_id = request.getParameter("c_id");
		String startDate = request.getParameter("startDate");
		String startTime = request.getParameter("startTime");
		String endDate = request.getParameter("endDate");
		String endTime = request.getParameter("endTime");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date startDate2 = sdf.parse(startDate + " " + startTime);
		Date endDate2 = sdf.parse(endDate + " " + endTime);

		// �ð����̸� �ð�,��,�ʸ� ���� ������ ������ �Ϸ� ������ ����
		long diffH = endDate2.getTime() - startDate2.getTime();
		long diffHours = diffH / (60 * 60 * 1000);

		CarBean cb = (CarBean) reservationService.payCar(c_id);

		int c_rentfee = cb.getC_rentfee();
		int total_price2 = ((int) diffHours * c_rentfee);

		out.print(total_price2);
	}

	// ����
	@RequestMapping(value = "/khcc_reservation_pay.nhn")
	public String khcc_reservation_pay(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

			String c_kind = (String) request.getParameter("c_kind");
			String c_model = (String) request.getParameter("c_model");
			String c_place = (String) request.getParameter("c_place");
			String startDate = (String) request.getParameter("startDate");
			String startTime = (String) request.getParameter("startTime");
			String endDate = (String) request.getParameter("endDate");
			String endTime = (String) request.getParameter("endTime");

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date startDate2 = sdf.parse(startDate + " " + startTime);
				Date endDate2 = sdf.parse(endDate + " " + endTime);

				// �ð����̸� �ð�,��,�ʸ� ���� ������ ������ �Ϸ� ������ ����
				long diffH = endDate2.getTime() - startDate2.getTime();
				long diffHours = diffH / (60 * 60 * 1000);

				CarBean cb = (CarBean) reservationService.payCar(c_model);

				int c_rentfee = cb.getC_rentfee();
				int tot_price = ((int) diffHours * c_rentfee);

				Map res = new HashMap();
				res.put("login_email", login_email);
				res.put("c_kind", c_kind);
				res.put("c_model", c_model);
				res.put("c_place", c_place);
				res.put("startDate", startDate);
				res.put("startTime", startTime);
				res.put("endDate", endDate);
				res.put("endTime", endTime);
				res.put("tot_price", tot_price);

				// ���� ���̺� ���� ���� ����
				reservationService.insertPay(res);
			} catch (Exception e) {
				e.getMessage();
			}
			out.println("<script>");
			out.println("alert('���� �Ǿ����ϴ�.')");
			out.println("location.href='./khcc_reservation.nhn';");
			out.println("</script>");
		}
		return null;
	}
}