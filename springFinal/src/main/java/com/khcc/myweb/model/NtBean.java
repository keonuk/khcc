package com.khcc.myweb.model;

import org.springframework.web.multipart.MultipartFile;

public class NtBean {

	private int nt_num;
	private String nt_name;
	private String login_email;
	
	private String nt_pass;
	private String nt_subject;//������
	private String nt_content;//�۳���
	
	private MultipartFile uploadfile; //����
	
	private int nt_re_ref; //�۱׷��ȣ
	private int nt_re_lev; //ȭ�鿡 ���̴� �亯�� ��ġ��ȣ
	private int nt_re_seq; //�亯�� ���� ����
	private int nt_readcount; //��ȸ��
	private String nt_date; //�� ��ϳ�¥
	
	private String nt_file; //DB��Ͻ� ���ϸ�
	private String nt_original; //���� ÷�ν� �������ϸ�
	private String M_ID;	//���̵�����
	
	public int getNt_num() {
		return nt_num;
	}
	public void setNt_num(int nt_num) {
		this.nt_num = nt_num;
	}
	public String getNt_name() {
		return nt_name;
	}
	public void setNt_name(String nt_name) {
		this.nt_name = nt_name;
	}
	public String getLogin_email() {
		return login_email;
	}
	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}
	public String getNt_pass() {
		return nt_pass;
	}
	public void setNt_pass(String nt_pass) {
		this.nt_pass = nt_pass;
	}
	public String getNt_subject() {
		return nt_subject;
	}
	public void setNt_subject(String nt_subject) {
		this.nt_subject = nt_subject;
	}
	public String getNt_content() {
		return nt_content;
	}
	public void setNt_content(String nt_content) {
		this.nt_content = nt_content;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public int getNt_re_ref() {
		return nt_re_ref;
	}
	public void setNt_re_ref(int nt_re_ref) {
		this.nt_re_ref = nt_re_ref;
	}
	public int getNt_re_lev() {
		return nt_re_lev;
	}
	public void setNt_re_lev(int nt_re_lev) {
		this.nt_re_lev = nt_re_lev;
	}
	public int getNt_re_seq() {
		return nt_re_seq;
	}
	public void setNt_re_seq(int nt_re_seq) {
		this.nt_re_seq = nt_re_seq;
	}
	public int getNt_readcount() {
		return nt_readcount;
	}
	public void setNt_readcount(int nt_readcount) {
		this.nt_readcount = nt_readcount;
	}
	public String getNt_date() {
		return nt_date;
	}
	public void setNt_date(String nt_date) {
		this.nt_date = nt_date;
	}
	public String getNt_file() {
		return nt_file;
	}
	public void setNt_file(String nt_file) {
		this.nt_file = nt_file;
	}
	public String getNt_original() {
		return nt_original;
	}
	public void setNt_original(String nt_original) {
		this.nt_original = nt_original;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	
	
}
