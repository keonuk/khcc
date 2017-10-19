package com.khcc.myweb.model;

import org.springframework.web.multipart.MultipartFile;

public class FaqBean {

	private int faq_num;
	private String faq_name;
	private String login_email;
	
	private String faq_pass;
	private String faq_subject;//������
	private String faq_content;//�۳���
	
	private MultipartFile uploadfile; //����
	
	private int faq_re_ref; //�۱׷��ȣ
	private int faq_re_lev; //ȭ�鿡 ���̴� �亯�� ��ġ��ȣ
	private int faq_re_seq; //�亯�� ���� ����
	private int faq_readcount; //��ȸ��
	private String faq_date; //�� ��ϳ�¥
	
	private String faq_file; //DB��Ͻ� ���ϸ�
	private String faq_original; //���� ÷�ν� �������ϸ�
	private String M_ID;	//���̵�����
	
	public int getFaq_num() {
		return faq_num;
	}
	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
	}
	public String getFaq_name() {
		return faq_name;
	}
	public void setFaq_name(String faq_name) {
		this.faq_name = faq_name;
	}
	public String getLogin_email() {
		return login_email;
	}
	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}
	public String getFaq_pass() {
		return faq_pass;
	}
	public void setFaq_pass(String faq_pass) {
		this.faq_pass = faq_pass;
	}
	public String getFaq_subject() {
		return faq_subject;
	}
	public void setFaq_subject(String faq_subject) {
		this.faq_subject = faq_subject;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public int getFaq_re_ref() {
		return faq_re_ref;
	}
	public void setFaq_re_ref(int faq_re_ref) {
		this.faq_re_ref = faq_re_ref;
	}
	public int getFaq_re_lev() {
		return faq_re_lev;
	}
	public void setFaq_re_lev(int faq_re_lev) {
		this.faq_re_lev = faq_re_lev;
	}
	public int getFaq_re_seq() {
		return faq_re_seq;
	}
	public void setFaq_re_seq(int faq_re_seq) {
		this.faq_re_seq = faq_re_seq;
	}
	public int getFaq_readcount() {
		return faq_readcount;
	}
	public void setFaq_readcount(int faq_readcount) {
		this.faq_readcount = faq_readcount;
	}
	public String getFaq_date() {
		return faq_date;
	}
	public void setFaq_date(String faq_date) {
		this.faq_date = faq_date;
	}
	public String getFaq_file() {
		return faq_file;
	}
	public void setFaq_file(String faq_file) {
		this.faq_file = faq_file;
	}
	public String getFaq_original() {
		return faq_original;
	}
	public void setFaq_original(String faq_original) {
		this.faq_original = faq_original;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	
}
