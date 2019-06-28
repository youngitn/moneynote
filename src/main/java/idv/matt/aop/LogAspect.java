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
 * AOP��Aspect���O�A�Ψӳ]�w���J�I(Pointcut)�Τ��J���޿�(Advice)�AAspect���O�W���[�W@Aspect
 * 
 * @author u52116
 *
 */
@Aspect
@Component
public class LogAspect {
	/**
	 * �n�QAOP���J����m�A�ϥ�pointcut expression�Ӫ�ܡA��Pointcut��m��Join
	 * point�Y��Advice�I�檺�ؼСC�U����
	 * @Pointcut("execution(*idv.matt.controller..*(..))")�Y��ܤ��J��m��idv.matt.controller�U�����Nmethod�C
	 */
	@Pointcut("execution(* idv.matt.controller..*(..))")
	public void pointcut() {
	}
	
	/**
	 * Joint point�GPointcut��m����ڪ����J�I�A�q�`�O�@��method�A�]�N�O�W����HelloController.hello()
	 * Advice�G��joint point�n�I�檺�ʧ@�A���h�اΦ��A�p�U��������@Before��@After��method�Y��Advice�C
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