package com.mvabal.prueba_tecnica.spaceships.application;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.logger;
import org.slf4j.loggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpaceShipUpdateAspect {

    private static final Logger logger = LoggerFactory.getLogger(SpaceShipUpdateAspect.class);

    @Pointcut("execution(* com.mvabal.prueba_tecnica.controller.SpaceShipController.updateSpaceShip(..))")
    private void updateSpaceShipMethod() {
    }

    @Before("updateSpaceShipMethod()")
    public void beforeUpdateSpaceShip(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("Before update space ship");
        if (args.length > 0 && args[0] instanceof Long) {
            Long id = (Long) args[0];
            if (id < 0) {
                logger.error("Invalid id");
            }
        }
    }

}
