package com.khcc.myweb.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.khcc.myweb.dao.ReportService;
import com.khcc.myweb.model.ReportBean;

@Controller
public class ReportAction {

	@Resource(name = "reportService")
	private ReportService reportService;

	// private String saveFolder =
	// "C:/Users/Jisoo/springworkspace/springFinal_all/src/main/webapp/resources/upload";

	/* �Ű��ϱ� �ۼ�(ȸ��) */
	@RequestMapping(value = "/khcc_reportwrite.nhn")
	public String report_write() throws Exception {
		return "report/report_write";
	}

	/* ����(ȸ��) */
	@RequestMapping(value = "/khcc_reportdel.nhn")
	public ModelAndView report_del(@RequestParam("num") int num, @RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {
		// ReportBean reportbean=this.reportService.getReportCont(num);
		ModelAndView model = new ModelAndView("report/report_del");
		// model.addObject("reportbean", reportbean);
		model.addObject("num", num);
		model.addObject("state", state);
		model.addObject("page", page);
		return model;
	}

	/* �Խ��� ���� */
	@RequestMapping(value = "/khcc_reportwrite_ok.nhn", method = RequestMethod.POST)
	public String khcc_reportwrite_ok(ReportBean report, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// ����
		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		MultipartFile uploadfile = report.getUploadfile();
		//
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(report.getR_SENDER());
		if (!uploadfile.isEmpty()) {
			// ���� ���ϸ� ���ؿ���
			String fileName = uploadfile.getOriginalFilename();

			// ���� ���ϸ� ����
			report.setR_ORGIMG(fileName);

			// ������ ���� �̸� : ���� ��+��+��
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR); // ���� �⵵ ���մϴ�.
			int month = c.get(Calendar.MONTH) + 1; // ���� �� ���մϴ�.
			int date = c.get(Calendar.DATE); // ���� �� ���մϴ�.
			String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
			System.out.println("homedir = " + homedir);
			File path1 = new File(homedir);

			if (!(path1.exists())) {
				path1.mkdir();// ���ο� ������ ����
			}

			// ������ ���մϴ�.
			Random r = new Random();
			int random = r.nextInt(100000000);

			/**** Ȯ���� ���ϱ� ���� ****/
			int index = fileName.lastIndexOf(".");
			// ���ڿ����� Ư�� ���ڿ��� ��ġ ��(index)�� ��ȯ�Ѵ�.
			// indexOf�� ó�� �߰ߵǴ� ���ڿ��� ���� index�� ��ȯ�ϴ� �ݸ�,
			// lastIndexOf�� ���������� �߰ߵǴ� ���ڿ��� index�� ��ȯ�մϴ�.
			// (���ϸ� ���� ������ ���� ��� �� �������� �߰ߵǴ� ���ڿ��� ��ġ�� �����մϴ�.)
			String fileExtension = fileName.substring(index + 1);
			/**** Ȯ���� ���ϱ� �� ***/

			// ���ο� ���ϸ��� ����
			String refileName = "report" + year + month + date + random + "." + fileExtension;

			// ����Ŭ ��� ����� ���ڵ� ��
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;

			// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile.transferTo(new File(saveFolder + fileDBName));
			// �ٲ� ���ϸ����� ����
			report.setR_IMG(fileDBName);
			report.setR_RECEIVER("admin");
		}

		this.reportService.insertreport(report);// ���� �޼ҵ� ȣ��

		out.println("<script>");
		out.println("window.close();");
		out.println("</script>");
		return null;
	}

	/* �Ű��ϱ� ����Ʈ(������) */
	@RequestMapping(value = "/khcc_reportlist.nhn")
	public ModelAndView report_list(@RequestParam(value = "page", defaultValue = "1", required = false) int page)
			throws Exception {

		// value="page" : ��û �Ķ���� page
		// defaultValue="1" ; ��û �Ķ���Ͱ� �������� ���� �� 1�� ���� ����
		// required=false : ��û �Ķ���Ͱ� �ʼ��� �ƴ� ���

		int limit = 5; // �� ȭ�鿡 ����� ���ڵ� ����

		int listcount = reportService.getListCount(); // �� ����Ʈ ���� �޾ƿ�

		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� �������� ������ ������ ������ ��(10, 20, 30 ��...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		if (endpage < page)
			page = endpage;

		List<ReportBean> reportlist = reportService.getReportList(page);

		ModelAndView model = new ModelAndView("report/report_list");
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("reportlist", reportlist);
		return model;
	}

	/* ���� �ȳ� �� */
	@RequestMapping(value = "/khcc_servicesview.nhn")
	public String services_view() throws Exception {
		return "servicesView/services_view";
	}

	/* �ڷ�� ���뺸��, ������, �亯����, ������ */
	@RequestMapping(value = "/khcc_reportcont.nhn")
	public ModelAndView report_cont(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {

		// ��ȣ�� �������� DB ������ �����ɴϴ�.
		ReportBean reportbean = this.reportService.getReportCont(num);

		ModelAndView contM = new ModelAndView();

		if (state.equals("cont")) {// ���뺸��
			contM.setViewName("report/report_cont");

			// �۳��� �� ����Ű ģ�κ��� �����ٷ� ���� ó��
			String report_cont = reportbean.getR_CONTENT().replace("\n", "<br/>");

			contM.addObject("report_cont", report_cont);
		} else if (state.equals("del")) {// �����϶�
			contM.setViewName("report/report_del");
		}
		contM.addObject("reportbean", reportbean);
		contM.addObject("page", page);
		return contM;
	}

	@RequestMapping(value = "/submit_report.nhn")
	public String submit_report(HttpServletResponse response, @RequestParam("illegal") String illegal) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		this.reportService.submitReport(illegal);
		int check = this.reportService.checkPenalty(illegal);
		
		out.println("<script>");
		if(check == 3) {
			out.println("alert('��� ���� 3ȸ ȸ��! Ż��ó�����ּ���.');");
			out.println("self.close();");
			out.println("opener.location.href='./khcc_adminpage.nhn';");
		} else {
			out.println("alert('��� ���� �Ϸ�.');");
			out.println("location.href='./khcc_reportlist.nhn';");
		}
		out.println("</script>");
			
		return null;
	}

	/* �ڷ�� ���� */
	@RequestMapping(value = "/khcc_reportdelete_ok.nhn", method = RequestMethod.POST)
	public ModelAndView report_delete_ok(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("r_NUM") int r_NUM, @RequestParam("page") int page, @RequestParam("state") String state)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// �۹�ȣ�� �ش��ϴ� ��� ������ �����ɴϴ�.
		ReportBean reportbean = this.reportService.getReportCont(r_NUM);

		// ���� ���ϸ� �����ɴϴ�.
		String fname = reportbean.getR_ORGIMG();

		// �̹��� ��� ��� ����
		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");
		if (fname != null) {// ���� ���������� �����Ѵٸ�
			File file = new File(saveFolder + fname);
			file.delete();// ���� ������ ���� ���� �������� �����մϴ�.
		}
		// �̹��� ��� ��� ����

		this.reportService.deleteReport(r_NUM);// ���� ���� ���ڵ� �����մϴ�.
		out.println("<script>");
		out.println("self.close();");
		if (state.equals("list"))
			out.println("opener.document.location.reload();");
		else if (state.equals("con"))
			out.println("opener.document.location.href='./khcc_reportlist.nhn';");
		out.println("</script>");
		return null;
	}
}
