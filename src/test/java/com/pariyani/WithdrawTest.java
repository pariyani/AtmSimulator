package com.pariyani;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pariyani.beans.ApplicationBean;
import com.pariyani.exception.InsufficientFundsException;
import com.pariyani.service.ATMServiceImpl;

/**
 * Test class to test the withdrawal functionality. 
 * @author imran
 *
 */
@ContextConfiguration(value = "file:src/test/resources/Junit-config.xml ")
@RunWith(SpringJUnit4ClassRunner.class)
public class WithdrawTest {

	@Autowired
	private ATMServiceImpl	atmService;

	@Autowired
	private ApplicationBean	applicationBean;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		try {
			FacesContext context = ContextMocker.mockFacesContext();
			Application app = Mockito.mock(Application.class);
			Mockito.when(context.getApplication()).thenReturn(app);
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("messages.properties");

			Mockito.when(app.getResourceBundle(context, "msg")).thenReturn(new PropertyResourceBundle(input));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void sampleTest() {
		try {
			applicationBean.setDollar20Bills(10);
			applicationBean.setDollar50Bills(10);
	        atmService.withdraw(140);
        
	        Assert.assertEquals(8, applicationBean.getDollar20Bills().intValue());
	        Assert.assertEquals(8, applicationBean.getDollar50Bills().intValue());
	        
	        atmService.withdraw(540);
	        Assert.assertEquals(1, applicationBean.getDollar20Bills().intValue());
	        Assert.assertEquals(0, applicationBean.getDollar50Bills().intValue());
	        
	        atmService.withdraw(60);
	        exception.expect(InsufficientFundsException.class);
		} catch (InsufficientFundsException e) {
	        //e.printStackTrace();
        }
	}
}