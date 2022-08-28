package org.aguzman.apiservlet.webapp.headers.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Logging
@Interceptor
public class LoggingInterceptor {

    @Inject
    private Logger log;

    @AroundInvoke
    public Object logging(InvocationContext invocation) throws Exception {

        log.info(" ***** entrando antes de invacar el metodo "+
                invocation.getMethod().getName() +
                " de la clase " +  invocation.getMethod().getDeclaringClass());
        Object resultado = invocation.proceed();

        log.info(" ***** saliendo de la invocacion del metodo " +
                invocation.getMethod().getName());
        return resultado;
    }
}
