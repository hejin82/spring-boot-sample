package org.hejin.messaging.rest.aop;

import java.lang.reflect.Parameter;
import java.util.stream.IntStream;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hejin.messaging.rest.annotation.ToUpper;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrencyCodeAudit {

    @Pointcut("execution(* org.hejin.messaging.service.*Service.*(.., @org.hejin.messaging.annotation.ToUpper (*),..))")
    public void methodPointcut() {

    }

    public Object codeAudit(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        Parameter[] parameters =
                ((MethodSignature) point.getSignature()).getMethod().getParameters();
        return point.proceed(IntStream.range(0, args.length)
                .mapToObj(index -> (parameters[index].isAnnotationPresent(ToUpper.class)
                        ? (new String(args[index].toString().toUpperCase()))
                        : (args[index])))
                .toArray());
    }
}
