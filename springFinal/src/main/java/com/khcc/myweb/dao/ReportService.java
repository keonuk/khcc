package com.khcc.myweb.dao;

import java.util.List;

import com.khcc.myweb.model.ReportBean;



public interface ReportService {
	
     //�Խñ� ����
	public void insertreport(ReportBean rb) throws Exception;
	

	/* �ڷ�� �� �Խù� ��*/
	public int getListCount() throws Exception;

	
	//�Խñ� ���
    public  List<ReportBean> getReportList(int page)throws Exception;
    
    
    //��ȣ �������� �ڷ�� ���� ��������
    public ReportBean getReportCont(int num) throws Exception;


	public void deleteReport(int r_NUM) throws Exception;


	public void submitReport(String illegal);


	public int checkPenalty(String illegal);

}
