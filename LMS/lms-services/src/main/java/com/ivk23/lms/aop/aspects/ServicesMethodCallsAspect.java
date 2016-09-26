package com.ivk23.lms.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;

@Aspect
public class ServicesMethodCallsAspect extends BaseAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicesMethodCallsAspect.class);

	/* ======================================================== POINTCUTS ================================================================ */
	@Pointcut("execution(* com.ivk23.lms.service.MentorshipProgramService.createNewProgram(com.ivk23.lms.commons.interfaces.IMentorshipProgram)) && args(program)")
	public void createProgramPointcut(IMentorshipProgram program) { }
		
	@Pointcut("execution(* com.ivk23.lms.service.EmployeeService.updateEmployeeData(..))")
	public void updateUserPointcut() { }
	
	@Pointcut("execution(* com.ivk23.lms.service.MentorshipProgramService.createNewPhase(com.ivk23.lms.commons.interfaces.IPhase)) && args(phase)")
	public void createPhasePointcut(IPhase phase) { }
	
	/* =================================================================================================================================== */
	 
	@Around("createProgramPointcut(program)")
	public void aroundCreateProgramAdvice(ProceedingJoinPoint jp, IMentorshipProgram program) {
		try {
			LOGGER.debug("New program [ {} ] will be created.", program);
			
			jp.proceed();
			
			LOGGER.debug("New program [ {} ] has been created.", program);
			
		} catch (Throwable e) {
			LOGGER.error("FAIL: com.ivk23.lms.aop.aspects.ServicesMethodCallsAspect.aroundCreateProgramAdvice(ProceedingJoinPoint, IMentorshipProgram)");
			e.printStackTrace();
		}
	}
	
	@After("createPhasePointcut(phase)")
	public void afterCreatePhaseAdvice(IPhase phase) {
		LOGGER.debug("PHASE # {} HAS BEEN CREATED.", phase);
	}
	
	@After("updateUserPointcut()")
	public void afterUpdateUserAdvice(JoinPoint jp) {
		
		LOGGER.debug("EMPLOYEE # {} HAS BEEN UPDATED.", jp.getArgs()[0].toString());
		
	}
	
	@AfterThrowing(pointcut = "updateUserPointcut()", throwing = "ex")
	public void afterExceptionWhenUpdateUserAdvice(JoinPoint jp, Exception ex) {
		LOGGER.error("UPDATE EMPLOYEE # {} FAILED WITH {}", jp.getArgs()[0].toString(), ex.getMessage());
	}
	
	@AfterThrowing(pointcut = "createProgramPointcut(program)", throwing = "ex")
	public void afterExceptionWhenCreateProgramAdvice(JoinPoint jp, IMentorshipProgram program, Exception ex) {
		LOGGER.error("CREATE PROGRAM # {} FAILED WITH {}", program, ex.getMessage());
	}
	
	@AfterThrowing(pointcut = "createPhasePointcut(phase)", throwing = "ex")
	public void afterExceptionWhenCreatePhaseAdvice(IPhase phase, Exception ex) {
		LOGGER.error("CREATE PHASE # {} FAILED WITH {}", phase, ex.getMessage());
	}
	
}
