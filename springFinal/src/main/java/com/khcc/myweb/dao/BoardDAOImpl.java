package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khcc.myweb.model.QaBean;
import com.khcc.myweb.model.QnaBean;
import com.khcc.myweb.model.FaqBean;
import com.khcc.myweb.model.NtBean;
/*
@Component�� �̿��ؼ� ������ �����̳ʰ� �ش� Ŭ���� ��ü�� �����ϵ��� ������ �� ������   
 ��� Ŭ������ @Component�� �Ҵ��ϸ� � Ŭ������ � ������ �����ϴ��� �ľ��ϱ� ��ƽ��ϴ�
 ������ �����ӿ�ũ������ �̷� Ŭ�������� �з��ϱ� ���ؼ� @Component�� ����Ͽ� ������ ���� �� ���� �ֳ����̼��� �����մϴ�.

1. @Controller - ������� ��û�� �����ϴ� Controller Ŭ����
2. @Repository - ������ ���̽� ������ ó���ϴ� DAOŬ����
3. @Service - ����Ͻ� ������ ó���ϴ� Service Ŭ���� 

*/
@Repository
public class BoardDAOImpl {

	@Autowired
	private SqlSessionTemplate sqlSession, ntsqlSession, faqsqlSession, qnasqlSession;

	/*qa�ڷ�� ����*/
	public void insertQa(QaBean qabean) throws Exception{
		sqlSession.insert("qa_insert",qabean);		
	}
	/*nt�ڷ�� ����*/
	public void insertNt(NtBean ntbean) throws Exception{
		ntsqlSession.insert("nt_insert",ntbean);		
	}
	/*faq�ڷ�� ����*/
	public void insertFaq(FaqBean faqbean) throws Exception{
		faqsqlSession.insert("faq_insert",faqbean);		
	}

	/* qa�ڷ�� �� �Խù� ��*/
	public int getListCount() throws Exception{
		int count=
	((Integer)sqlSession.selectOne("qa_count")).intValue();
		return count;
	}
	/* nt�ڷ�� �� �Խù� ��*/
	public int getntListCount() throws Exception{
		int ntcount=
	((Integer)ntsqlSession.selectOne("nt_count")).intValue();
		return ntcount;
	}
	/* faq�ڷ�� �� �Խù� ��*/
	public int getfaqListCount() throws Exception{
		int faqcount=
	((Integer)faqsqlSession.selectOne("faq_count")).intValue();
		return faqcount;
	}
	
	/* qa�ڷ�� ��ϰ� ����¡ */
	public List<QaBean> getQaList(int page) throws Exception {
		List<QaBean>  list = 
				sqlSession.selectList("qa_list", page);
	    return list;
	}
	/* nt�ڷ�� ��ϰ� ����¡ */
	public List<NtBean> getNtList(int ntpage) throws Exception {
		List<NtBean>  ntlist = 
				ntsqlSession.selectList("nt_list", ntpage);
	    return ntlist;
	}
	/* faq�ڷ�� ��ϰ� ����¡ */
	public List<FaqBean> getFaqList(int faqpage) throws Exception {
		List<FaqBean>  faqlist = 
				faqsqlSession.selectList("faq_list", faqpage);
	    return faqlist;
	}

	/*qa��ȣ�� �������� �ڷ�� ���� �������� */
	public QaBean getQaCont(int num) throws Exception{
		return (QaBean)sqlSession.selectOne("qa_cont", num);
	}
	/*nt��ȣ�� �������� �ڷ�� ���� �������� */
	public NtBean getNtCont(int ntnum) throws Exception{
		return (NtBean)ntsqlSession.selectOne("nt_cont", ntnum);
	}
	/*faq��ȣ�� �������� �ڷ�� ���� �������� */
	public FaqBean getFaqCont(int faqnum) throws Exception{
		return (FaqBean)faqsqlSession.selectOne("faq_cont", faqnum);
	}

	/*qa���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void qaHit(int num) throws Exception{
		sqlSession.update("qa_hit",num);		
	}
	/*nt���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void ntHit(int ntnum) throws Exception{
		ntsqlSession.update("nt_hit",ntnum);		
	}
	/*faq���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void faqHit(int faqnum) throws Exception{
		faqsqlSession.update("faq_hit",faqnum);		
	}

	/*qa�ڷ�� ����*/
	public void editQa(QaBean qabean) throws Exception{
		sqlSession.update("qa_edit",qabean);		
	}
	/*nt�ڷ�� ����*/
	public void editNt(NtBean ntbean) throws Exception{
		ntsqlSession.update("nt_edit",ntbean);		
	}
	/*faq�ڷ�� ����*/
	public void editFaq(FaqBean faqbean) throws Exception{
		faqsqlSession.update("faq_edit",faqbean);		
	}

	/*qa�ڷ�� ����*/
	public void deleteQa(int qa_num) throws Exception{
		sqlSession.delete("qa_delete",qa_num);		
	}
	/*nt�ڷ�� ����*/
	public void deleteNt(int nt_num) throws Exception{
		ntsqlSession.delete("nt_delete",nt_num);		
	}
	/*faq�ڷ�� ����*/
	public void deleteFaq(int faq_num) throws Exception{
		faqsqlSession.delete("faq_delete",faq_num);		
	}

	/*qa�˻� ��� �Խù� ��*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getListCount3(Map m) throws Exception{
		int count=0;
		count=((Integer)sqlSession.selectOne("qafind_cnt", m)).intValue();
		return count;
	}
	/*nt�˻� ��� �Խù� ��*/
	public int getntListCount3(Map ntm) throws Exception{
		int ntcount=0;
		ntcount=((Integer)ntsqlSession.selectOne("ntfind_cnt", ntm)).intValue();
		return ntcount;
	}
	/*faq�˻� ��� �Խù� ��*/
	public int getfaqListCount3(Map faqm) throws Exception{
		int faqcount=0;
		faqcount=((Integer)faqsqlSession.selectOne("faqfind_cnt", faqm)).intValue();
		return faqcount;
	}

	/*qa�˻� ��� ����¡ ���*/
	public List<QaBean> getQaList3(Map m) throws Exception {
		List<QaBean>  list = sqlSession.selectList("qa_find", m);
	    return list;
	}
	/*nt�˻� ��� ����¡ ���*/
	public List<NtBean> getNtList3(Map ntm) throws Exception {
		List<NtBean>  ntlist = ntsqlSession.selectList("nt_find", ntm);
	    return ntlist;
	}
	/*faq�˻� ��� ����¡ ���*/
	public List<FaqBean> getFaqList3(Map faqm) throws Exception {
		List<FaqBean>  faqlist = faqsqlSession.selectList("faq_find", faqm);
	    return faqlist;
	}

	/*qa�亯�� ���� ����*/
	public void refEdit(QaBean qabean) throws Exception{
		sqlSession.update("qa_Level",qabean); 		
	}
	/*nt�亯�� ���� ����*/
	public void refntEdit(NtBean ntbean) throws Exception{
		ntsqlSession.update("nt_Level",ntbean); 		
	}
	/*faq�亯�� ���� ����*/
	public void reffaqEdit(FaqBean faqbean) throws Exception{
		faqsqlSession.update("faq_Level",faqbean); 		
	}

	/*��ȸ�� ��ũ1*/
	public QaBean qaReadFirst() throws Exception {
		return sqlSession.selectOne("qa_readfirst");
	}
	
	/*��ȸ�� ��ũ2*/
	public QaBean qaReadSecond() throws Exception {
		return sqlSession.selectOne("qa_readsecond");
	}
	
	/*��ȸ�� ��ũ3*/
	public QaBean qaReadThird() throws Exception {
		return sqlSession.selectOne("qa_readthird");
	}
	
	/*�̹��� ����1*/
	public QaBean qaImageFirst() throws Exception {
		return sqlSession.selectOne("qa_imagefirst");
	}
	
	/*�̹��� ����2*/
	public QaBean qaImageSecond() throws Exception {
		return sqlSession.selectOne("qa_imagesecond");
	}
	
	/*�̹��� ����3*/
	public QaBean qaImageThird() throws Exception {
		return sqlSession.selectOne("qa_imagethird");
	}
	
	/*qa�亯�� ����*/
	public void qaReplyOk(QaBean qabean) throws Exception{
		sqlSession.insert("qa_reply",qabean);
	}
	/*nt�亯�� ����*/
	public void ntReplyOk(NtBean ntbean) throws Exception{
		ntsqlSession.insert("nt_reply",ntbean);
	}
	/*faq�亯�� ����*/
	public void faqReplyOk(FaqBean faqbean) throws Exception{
		faqsqlSession.insert("faq_reply",faqbean);
	}
	
	/*qna�ڷ�� ����*/
	public void insertQna(QnaBean qnabean) throws Exception{
		qnasqlSession.insert("qna_insert",qnabean);		
	}

	/* qna�ڷ�� �� �Խù� ��*/
	public int getqnaListCount() throws Exception{
		int count=
	((Integer)qnasqlSession.selectOne("qna_count")).intValue();
		return count;
	}
	
	/* qna�ڷ�� ��ϰ� ����¡ */
	public List<QnaBean> getQnaList(int qnapage) throws Exception {
		List<QnaBean>  list = 
				qnasqlSession.selectList("qna_list", qnapage);
	    return list;
	}

	/*qna��ȣ�� �������� �ڷ�� ���� �������� */
	public QnaBean getQnaCont(int num) throws Exception{
		return (QnaBean)qnasqlSession.selectOne("qna_cont", num);
	}

	/*qna���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void qnaHit(int num) throws Exception{
		qnasqlSession.update("qna_hit",num);		
	}

	/*qna�ڷ�� ����*/
	public void editQna(QnaBean qnabean) throws Exception{
		qnasqlSession.update("qna_edit",qnabean);		
	}

	/*qna�ڷ�� ����*/
	public void deleteQna(int qna_num) throws Exception{
		qnasqlSession.delete("qna_delete",qna_num);		
	}

	/*qna�˻� ��� �Խù� ��*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getqnaListCount3(Map qnam) throws Exception{
		int count=0;
		count=((Integer)qnasqlSession.selectOne("qnafind_cnt", qnam)).intValue();
		return count;
	}

	/*qna�˻� ��� ����¡ ���*/
	public List<QnaBean> getQnaList3(Map qnam) throws Exception {
		List<QnaBean>  list = qnasqlSession.selectList("qna_find", qnam);
	    return list;
	}

	/*qna�亯�� ���� ����*/
	public void refqnaEdit(QnaBean qnabean) throws Exception{
		qnasqlSession.update("qna_Level",qnabean); 		
	}
	
	/*qna�亯�� ����*/
	public void qnaReplyOk(QnaBean qnabean) throws Exception{
		qnasqlSession.insert("qna_reply",qnabean);
	}
	
	
}











