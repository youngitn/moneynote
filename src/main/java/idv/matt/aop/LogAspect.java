package idv.matt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AOP的Aspect類別，用來設定切入點(Pointcut)及切入的邏輯(Advice)，Aspect類別上須加上@Aspect
 * 
 * @author u52116
 *
 */
@Aspect
@Component
public class LogAspect {
	/**
	 * 要被AOP切入的位置，使用pointcut expression來表示，而Pointcut位置的Join
	 * point即為Advice施行的目標。下面的
	 * @Pointcut("execution(*idv.matt.controller..*(..))")即表示切入位置為idv.matt.controller下的任意method。
	 */
	@Pointcut("execution(* idv.matt.controller..*(..))")
	public void pointcut() {
	}
	
	/**
	 * Joint point：Pointcut位置中實際的切入點，通常是一個method，也就是上面的HelloController.hello()
	 * Advice：對joint point要施行的動作，有多種形式，如下面的掛有@Before及@After的method即為Advice。
	 */	
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("start");
	}

	@After("pointcut()")
	public void after(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("end");
	}

}