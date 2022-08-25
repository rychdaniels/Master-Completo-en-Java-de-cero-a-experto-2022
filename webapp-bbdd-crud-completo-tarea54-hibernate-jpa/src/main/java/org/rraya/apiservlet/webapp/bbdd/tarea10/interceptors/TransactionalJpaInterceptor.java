package org.rraya.apiservlet.webapp.bbdd.tarea10.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import org.rraya.apiservlet.webapp.bbdd.tarea10.configs.MySqlConn;

import java.sql.Connection;
import java.util.logging.Logger;

@TransactionalJpa
@Interceptor
public class TransactionalJpaInterceptor {

    @Inject
    private EntityManager em;

    @Inject
    private Logger log;

    @AroundInvoke
    public Object transactional(InvocationContext invocation) throws Exception {

        try {
            log.info(" ------> iniciando transaccion " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());

            em.getTransaction().begin();
            Object resultado = invocation.proceed();
            em.getTransaction().commit();
            log.info(" ------> realizando commit y finalizando transaccion " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            return resultado;
        } catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }
    }
}
