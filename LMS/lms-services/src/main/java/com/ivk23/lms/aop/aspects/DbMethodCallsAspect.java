package com.ivk23.lms.aop.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;
import com.ivk23.lms.dao.domain.MentorshipProgram;
import com.ivk23.lms.service.LoggerService;

/**
 * This aspect is responsible for persisting methods invocation into database.
 * 
 * @author ivk23
 *
 */
@Aspect
public class DbMethodCallsAspect extends BaseAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DbMethodCallsAspect.class);
	
	@Autowired
	private LoggerService loggerService;

	/* ======================================================== POINTCUTS ================================================================ */
	@Pointcut("execution(* com.ivk23.lms.dao.repository.MentorshipProgramRepository.save(com.ivk23.lms.commons.interfaces.IMentorshipProgram)) && args(program)")
	public void saveProgramPointcut(IMentorshipProgram program) {
	}
	
	@Pointcut("execution(* com.ivk23.lms.dao.repository.PhaseRepository.save(com.ivk23.lms.commons.interfaces.IPhase)) && args(phase)")
	public void savePhasePointcut(IPhase phase) {
	}
	
	@Pointcut("execution(* com.ivk23.lms.dao.repository.PhaseRepository.delete(com.ivk23.lms.commons.interfaces.IPhase)) && args(phase)")
	public void deletePhasePointcut(IPhase phase) {
	}
	
	@Pointcut("execution(* com.ivk23.lms.dao.repository.EmployeeRepository.findAll(..))")
	public void findAllEmplPointcut() {
	}
	
	/* =================================================================================================================================== */
	
	/**
	 * This advice adds creationDate and createdByUser values to the
	 * MentorshipProgram entity just before it will be persisted.
	 * 
	 * @param jp
	 * @param program
	 */
	@Before("saveProgramPointcut(program)")
	public void beforeSaveProgramAdvice(JoinPoint jp, IMentorshipProgram program) {
		
		//TODO ikos for now assume admin makes all changes :)
		// anyway new program will be saved with creationDate and createdByUser
		((MentorshipProgram) program).setCreationDate(new Date());
		((MentorshipProgram) program).setCreatedByUser("admin"); 

	}

	/**
	 * This advice save log entity which represents method invocation data
	 * (class, method name, input params, invocation date).
	 * 
	 * @param jp
	 * @param program
	 */
	@After("saveProgramPointcut(program)")
	public void afterSaveProgramAdvice(JoinPoint jp, IMentorshipProgram program) {
		// save log of method call to DB
		loggerService.createLog(createLogByParams(jp.getSignature().getDeclaringTypeName() 
				+ "." + jp.getSignature().getName(), jp.getArgs(), new Date()));
	}
	
	@After("savePhasePointcut(phase)")
	public void afterSavePhaseAdvice(JoinPoint jp, IPhase phase) {
		loggerService.createLog(createLogByParams(jp.getSignature().getDeclaringTypeName() 
				+ "." + jp.getSignature().getName(), jp.getArgs(), new Date()));
	}
	
	@After("deletePhasePointcut(phase)")
	public void afterDeletePhaseAdvice(JoinPoint jp, IPhase phase) {
		loggerService.createLog(createLogByParams(jp.getSignature().getDeclaringTypeName() 
				+ "." + jp.getSignature().getName(), jp.getArgs(), new Date()));
	}
	
	@Before("findAllEmplPointcut()")
	public void beforeFindAllEmplAdvice(JoinPoint jp) {
		loggerService.createLog(createLogByParams(jp.getSignature().getDeclaringTypeName() 
				+ "." + jp.getSignature().getName(), jp.getArgs(), new Date()));
	}
	
	@AfterThrowing(pointcut = "saveProgramPointcut(program)", throwing="ex")
	public void afterExceptionWhenSaveProgram(JoinPoint jp, IMentorshipProgram program, Exception ex) {
		final String method = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
		final String params = createLogByParams(method, jp.getArgs(), new Date()).getParams();
		
		LOGGER.error("FAIL : " + jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName()
				+ " for " + params + " with error " + ex.getStackTrace().toString());
	}
	
	@AfterThrowing(pointcut = "savePhasePointcut(phase)", throwing="ex")
	public void afterExceptionWhenSavePhase(JoinPoint jp, IPhase phase, Exception ex) {
		final String method = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
		final String params = createLogByParams(method, jp.getArgs(), new Date()).getParams();
		
		LOGGER.error("FAIL : " + jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName()
				+ " for " + params + " with error " + ex.getStackTrace().toString());
	}
	
	@AfterThrowing(pointcut = "deletePhasePointcut(phase)", throwing="ex")
	public void afterExceptionWhenDeletePhase(JoinPoint jp, IPhase phase, Exception ex) {
		final String method = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
		final String params = createLogByParams(method, jp.getArgs(), new Date()).getParams();
		
		LOGGER.error("FAIL : " + jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName()
				+ " for " + params + " with error " + ex.getStackTrace().toString());
	}

}
