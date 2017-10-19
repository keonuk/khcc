package com.khcc.myweb.dao;
import java.util.List;
import java.util.Map;

import com.khcc.myweb.model.QaBean;
import com.khcc.myweb.model.QnaBean;
import com.khcc.myweb.model.FaqBean;
import com.khcc.myweb.model.NtBean;
public interface BoardService {
	
	/*------------------REVIEW----------------------*/
	/*�ڷ�� ����*/
	public void insertQa(QaBean qabean) throws Exception;

	/* �ڷ�� �� �Խù� ��*/
	public int getListCount() throws Exception;
	
	/* �ڷ�� ��ϰ� ����¡ */
	public List<QaBean> getQaList(int page) throws Exception ;

	/*��ȣ�� �������� �ڷ�� ���� �������� */
	public QaBean getQaCont(int num) throws Exception;

	/*���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void qaHit(int num) throws Exception;

	/*��ȸ�� ��ŷ1*/
	public QaBean qaReadFirst() throws Exception;
	
	/*��ȸ�� ��ŷ2*/
	public QaBean qaReadSecond() throws Exception;
	
	/*��ȸ�� ��ŷ3*/
	public QaBean qaReadThird() throws Exception;
	
	/*�̹�������1*/
	public QaBean qaImageFirst() throws Exception;
	
	/*�̹�������2*/
	public QaBean qaImageSecond() throws Exception;
	
	/*�̹�������3*/
	public QaBean qaImageThird() throws Exception;
	
	/*�ڷ�� ����*/
	public void editQa(QaBean qabean) throws Exception;

	/*�ڷ�� ����*/
	public void deleteQa(int qa_num) throws Exception;

	/*�˻� ��� �Խù� ��*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getListCount3(Map m) throws Exception;

	/*�˻� ��� ����¡ ���*/
	public List<QaBean> getQaList3(Map m) throws Exception ;

	/*�亯�� ���� ����*/
	public void refEdit(QaBean qabean) throws Exception;

	/*�亯�� ����*/
	public void qaReplyOk(QaBean qabean) throws Exception;
	
	/*------------------NT----------------------*/
	
	/*�ڷ�� ����*/
	public void insertNt(NtBean ntbean) throws Exception;

	/* �ڷ�� �� �Խù� ��*/
	public int getntListCount() throws Exception;
	
	/* �ڷ�� ��ϰ� ����¡ */
	public List<NtBean> getNtList(int ntpage) throws Exception ;

	/*��ȣ�� �������� �ڷ�� ���� �������� */
	public NtBean getNtCont(int ntnum) throws Exception;

	/*���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void ntHit(int ntnum) throws Exception;
	
	/*�ڷ�� ����*/
	public void editNt(NtBean ntbean) throws Exception;

	/*�ڷ�� ����*/
	public void deleteNt(int nt_num) throws Exception;

	/*�˻� ��� �Խù� ��*/
	public int getntListCount3(Map ntm) throws Exception;

	/*�˻� ��� ����¡ ���*/
	public List<NtBean> getNtList3(Map ntm) throws Exception ;

	/*�亯�� ���� ����*/
	public void refntEdit(NtBean ntbean) throws Exception;

	/*�亯�� ����*/
	public void ntReplyOk(NtBean ntbean) throws Exception;
	
/*------------------FAQ----------------------*/
	
	/*�ڷ�� ����*/
	public void insertFaq(FaqBean faqbean) throws Exception;

	/* �ڷ�� �� �Խù� ��*/
	public int getfaqListCount() throws Exception;
	
	/* �ڷ�� ��ϰ� ����¡ */
	public List<FaqBean> getFaqList(int faqpage) throws Exception ;

	/*��ȣ�� �������� �ڷ�� ���� �������� */
	public FaqBean getFaqCont(int faqnum) throws Exception;

	/*���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void faqHit(int faqnum) throws Exception;
	
	/*�ڷ�� ����*/
	public void editFaq(FaqBean faqbean) throws Exception;

	/*�ڷ�� ����*/
	public void deleteFaq(int faq_num) throws Exception;

	/*�˻� ��� �Խù� ��*/
	public int getfaqListCount3(Map faqm) throws Exception;

	/*�˻� ��� ����¡ ���*/
	public List<FaqBean> getFaqList3(Map faqm) throws Exception ;

	/*�亯�� ���� ����*/
	public void reffaqEdit(FaqBean faqbean) throws Exception;

	/*�亯�� ����*/
	public void faqReplyOk(FaqBean faqbean) throws Exception;
	
	/*------------------QNA----------------------*/
	/*�ڷ�� ����*/
	public void insertQna(QnaBean qnabean) throws Exception;

	/* �ڷ�� �� �Խù� ��*/
	public int getqnaListCount() throws Exception;
	
	/* �ڷ�� ��ϰ� ����¡ */
	public List<QnaBean> getQnaList(int qnapage) throws Exception ;

	/*��ȣ�� �������� �ڷ�� ���� �������� */
	public QnaBean getQnaCont(int qnanum) throws Exception;

	/*���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void qnaHit(int qnanum) throws Exception;

	/*�ڷ�� ����*/
	public void editQna(QnaBean qnabean) throws Exception;

	/*�ڷ�� ����*/
	public void deleteQna(int qna_num) throws Exception;

	/*�˻� ��� �Խù� ��*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getqnaListCount3(Map qnam) throws Exception;

	/*�˻� ��� ����¡ ���*/
	public List<QnaBean> getQnaList3(Map qnam) throws Exception ;

	/*�亯�� ���� ����*/
	public void refqnaEdit(QnaBean qnabean) throws Exception;

	/*�亯�� ����*/
	public void qnaReplyOk(QnaBean qnabean) throws Exception;

}
