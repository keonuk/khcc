package com.khcc.myweb.model;

import org.springframework.web.multipart.MultipartFile;

public class QaBean {

	private int qa_num;
	private String qa_name;
	private String login_email;
	
	private String qa_pass;
	private String qa_subject;//������
	private String qa_content;//�۳���
	
	private MultipartFile uploadfile; //����
	
	private int qa_re_ref; //�۱׷��ȣ
	private int qa_re_lev; //ȭ�鿡 ���̴� �亯�� ��ġ��ȣ
	private int qa_re_seq; //�亯�� ���� ����
	private int qa_readcount; //��ȸ��
	private String qa_date; //�� ��ϳ�¥
	
	private String qa_file; //DB��Ͻ� ���ϸ�
	private String qa_original; //���� ÷�ν� �������ϸ�
	
	public int getQa_num() {
		return qa_num;
	}
	public void setQa_num(int qa_num) {
		this.qa_num = qa_num;
	}
	public String getQa_name() {
		return qa_name;
	}
	public void setQa_name(String qa_name) {
		this.qa_name = qa_name;
	}
	public String getLogin_email() {
		return login_email;
	}
	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}
	public String getQa_pass() {
		return qa_pass;
	}
	public void setQa_pass(String qa_pass) {
		this.qa_pass = qa_pass;
	}
	public String getQa_subject() {
		return qa_subject;
	}
	public void setQa_subject(String qa_subject) {
		this.qa_subject = qa_subject;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public int getQa_re_ref() {
		return qa_re_ref;
	}
	public void setQa_re_ref(int qa_re_ref) {
		this.qa_re_ref = qa_re_ref;
	}
	public int getQa_re_lev() {
		return qa_re_lev;
	}
	public void setQa_re_lev(int qa_re_lev) {
		this.qa_re_lev = qa_re_lev;
	}
	public int getQa_re_seq() {
		return qa_re_seq;
	}
	public void setQa_re_seq(int qa_re_seq) {
		this.qa_re_seq = qa_re_seq;
	}
	public int getQa_readcount() {
		return qa_readcount;
	}
	public void setQa_readcount(int qa_readcount) {
		this.qa_readcount = qa_readcount;
	}
	public String getQa_date() {
		return qa_date;
	}
	public void setQa_date(String qa_date) {
		this.qa_date = qa_date;
	}
	public String getQa_file() {
		return qa_file;
	}
	public void setQa_file(String qa_file) {
		this.qa_file = qa_file;
	}
	public String getQa_original() {
		return qa_original;
	}
	public void setQa_original(String qa_original) {
		this.qa_original = qa_original;
	}
}
