package com.pariyani.beans;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This class is initialized when the application starts. It holds the number of
 * 20 dollar and 50 dollars bills present. When some one withdraws certain
 * amount this class is updated.
 * 
 * @author imran
 */
@Component
@Scope("singleton")
public class ApplicationBean implements Serializable {

	/**
     * 
     */
	private static final long	serialVersionUID	= 3823554908961735239L;

	/**
	 * No. of 20 dollar bills
	 */
	private Integer	          dollar20Bills	     = null;

	/**
	 * No. of 50 dollar bills
	 */
	private Integer	          dollar50Bills	     = null;

	/**
	 * @return No of 20 dollar bills present.
	 */
	public Integer getDollar20Bills() {
		return dollar20Bills;
	}

	/**
	 * @param dollar20Bills
	 */
	public void setDollar20Bills(Integer dollar20Bills) {
		this.dollar20Bills = dollar20Bills;
	}

	/**
	 * @return No of 50 dollar bills present.
	 */
	public Integer getDollar50Bills() {
		return dollar50Bills;
	}

	/**
	 * @param dollar50Bills
	 */
	public void setDollar50Bills(Integer dollar50Bills) {
		this.dollar50Bills = dollar50Bills;
	}

}
