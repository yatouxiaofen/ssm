package com.susu.ssm.aop;

import com.susu.ssm.bean.ResultBean;
import com.susu.ssm.exception.CheckException;
import com.susu.ssm.exception.UnloginException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class ControllerAOP {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

    public  Object handlerControllerMethod(ProceedingJoinPoint pjp){
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;

        try {
            result = (ResultBean<?>)pjp.proceed();
            logger.info(pjp.getSignature()+"use time:"+(System.currentTimeMillis()-startTime));
        }catch (Throwable e){
            result = handlerException(pjp, e);
        }
        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e){
        ResultBean<?> result = new ResultBean();

        if(e instanceof CheckException){
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        }else if(e instanceof UnloginException){
            result.setMsg("Unlogin");
            result.setCode(ResultBean.NO_LOGIN);
        }else{
            //TODO 未知错误,应格外注意，可以发邮件通知等
            logger.error(pjp.getSignature()+" error",e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);
        }
        return result;
    }
}
