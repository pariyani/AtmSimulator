package com.pariyani.service;

import com.pariyani.exception.InsufficientFundsException;

/**
 * @author imran
 * 
 */
public interface ATMService {

	/**
	 * Here we find out of the amount requested by the user is available with us
	 * or not. If its available the we give him the amount in such a way that he
	 * has a few notes of lower denomination and the rest of 50 dollars. So for
	 * example if he requested 100 dollars the he will receive 5 notes of 20
	 * dollar bills if we have 20 dollars otherwise 2 notes of 50 dollar bills.
	 * If he requested 120 dollars then he will get 1 200 dollar bill and 2 50
	 * dollar bill.
	 * 
	 * @param amount
	 * @return
	 * @throws InsufficientFundsException
	 */
	public String withdraw(Integer amount) throws InsufficientFundsException;
}
