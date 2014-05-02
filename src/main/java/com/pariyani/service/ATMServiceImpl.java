package com.pariyani.service;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pariyani.beans.ApplicationBean;
import com.pariyani.exception.InsufficientFundsException;
import com.pariyani.faceshelper.FacesUtils;


/**
 * In this Class we perform the withdrawal process.  
 * 
 * @author imran
 */
@Service
public class ATMServiceImpl implements ATMService {
	
	@Autowired
	private ApplicationBean	  applicationBean;
	
	/* (non-Javadoc)
	 * @see com.pariyani.service.ATMService#withdraw(java.lang.Integer)
	 */
	public String withdraw(Integer amount) throws InsufficientFundsException{
		if (amount % 20 == 0 && applicationBean.getDollar20Bills() != 0) {
			int dollar50Amount = amount - 20;
			while (dollar50Amount % 50 != 0) {
				dollar50Amount = dollar50Amount - 20;
			}
			int dollar20Bills = (amount - dollar50Amount) / 20;
			if(applicationBean.getDollar50Bills() >= (dollar50Amount / 50)){
				if (applicationBean.getDollar20Bills() >= dollar20Bills)
					return updateAmount(dollar20Bills, (dollar50Amount / 50),amount);
			}else if(applicationBean.getDollar20Bills() >= amount/20)
				return updateAmount(amount/20, 0,amount);
		}
		if (amount % 50 == 0 && applicationBean.getDollar50Bills() >= (amount / 50))
			return updateAmount(0, amount/50,amount);
		else
			throw new InsufficientFundsException();
	}
	
	private String updateAmount(int dollar20Bills,int dollar50Bills,Integer amount){
		FacesUtils.addMessage(null, FacesMessage.SEVERITY_INFO, "withdraw.success",dollar20Bills,dollar50Bills,amount);
		applicationBean.setDollar20Bills(applicationBean.getDollar20Bills() - dollar20Bills);
		applicationBean.setDollar50Bills(applicationBean.getDollar50Bills() - dollar50Bills);
		return null;
	}
	
}
