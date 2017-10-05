package com.aconex.hackathon.opendoor.handler;

import io.sentry.Sentry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Conditional(ExceptionHandlerResolverCondition.class)
public class ExceptionHandlerResolver extends DefaultHandlerExceptionResolver {
    @Value("${sentry_dsn}")
    private String dsn;

    @PostConstruct
    public void init() {
        Sentry.init(dsn);
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Sentry.capture(ex);
        return super.resolveException(request, response, handler, ex);
    }

}

