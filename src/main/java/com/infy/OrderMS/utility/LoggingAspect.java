package com.infy.OrderMS.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.infy.OrderMS.exception.OrderMSException;


@Component
@Aspect
public class LoggingAspect {
	
	@AfterThrowing(pointcut = "execution(* com.oms.order.service.*Impl.*(..))", throwing = "exception")	
	public void logExceptionFromService(Exception exception) throws OrderMSException {
			log(exception);
	}

	
	private void log(Exception exception) {
		Logger logger = LogManager.getLogger(this.getClass());
		if(exception.getMessage()!=null ){
			
			logger.info(exception.getMessage());
		}
		else{
			logger.info(exception.getMessage(), exception);
		}
	}

}
