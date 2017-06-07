package dev.paie.config.aspect;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Performance;
import dev.paie.repository.PerformanceRepository;

@Configuration
@Aspect
@Transactional
public class ControllerPerformanceAspect {

	
	 @Autowired
	 private PerformanceRepository perfR;
	    
	    @PersistenceContext EntityManager em;

	private static final Logger LOGGER = LoggerFactory.getLogger
			(ControllerPerformanceAspect.class);
	@Around("execution(* dev.paie.web.controller.*.*(..))")
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		LOGGER.debug("Début d'exécution de la méthode " + pjp.getSignature().toString());
		long before = System.currentTimeMillis();
		Object resultat = pjp.proceed();
		LOGGER.debug("Fin d'exécution de la méthode");
		long after = System.currentTimeMillis();
		Performance perf = new Performance();
		
		perf.setNomService(pjp.getSignature().toString());
		perf.setDateHeure(LocalDateTime.now());
		perf.setTempsExecution(after-before);
		
		perfR.saveAndFlush(perf);
		
		return resultat;
	}
}
