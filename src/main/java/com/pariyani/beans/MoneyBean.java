package com.pariyani.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pariyani.exception.InsufficientFundsException;
import com.pariyani.faceshelper.FacesUtils;
import com.pariyani.service.ATMService;

/**
 * This is the JSF Request scoped bean used by the index page.
 * 
 * @author imran
 */
@Component
@Scope("request")
public class MoneyBean implements Serializable {

	/**
     * 
     */
	private static final long	serialVersionUID	= 7325029378897886085L;

	@Autowired
	private ATMService	      atmService;

	/**
	 * Holds the amount user wants to withdraw.
	 */
	private Integer	          amount;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * This method is called from the xhtml file and it returns to the same page
	 * after performing the withdrawal logic.
	 * 
	 * @return
	 */
	public String withdraw() {
		try {
			return atmService.withdraw(this.amount);
		} catch (InsufficientFundsException e) {
			FacesUtils.addMessage(null, FacesMessage.SEVERITY_ERROR, "withdraw.error");
			return null;
		}
	}
}
