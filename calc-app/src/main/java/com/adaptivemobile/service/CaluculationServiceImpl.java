package com.adaptivemobile.service;

import com.adaptivemobile.exceptions.NegativeResultException;

public class CaluculationServiceImpl implements CaluculationService {

	public CaluculationServiceImpl() {
	}
	 public synchronized int  add(int x, int y) {
		 int sum = x+y;
		 if(sum<0)
			 throw new NegativeResultException(" The integer value can't hold in int variable");
		return x+y;
	}

	public synchronized int sub(int x, int y) {

		return x-y;
	}

}
