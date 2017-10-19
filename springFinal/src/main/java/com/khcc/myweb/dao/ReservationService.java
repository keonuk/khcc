package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import com.khcc.myweb.model.CarBean;

public interface ReservationService {

	/* �ڵ��� ���� �ҷ����� */
	public List<CarBean> selectCar(String title) throws Exception;

	/* ������ �� ���� */
	public CarBean payCar(String c_model) throws Exception;

	/* ���� ���� ��� */
	public void insertPay(Map res) throws Exception;
}
