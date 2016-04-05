package com.yyabl.api.crm.biz.Aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import net.spy.memcached.MemcachedClient;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yyabl.api.crm.biz.Bean.RequestBaseBean;
import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Util.BeanUtil;

/**
 * 
 * @author 舒阜东
 * @version 1.0.0.1  
 * Copyright Copyright (c)  2015 
 * Company 湖南友阿云商网络有限公司
 */
@Aspect
public class InvokeAspect {
	private Logger logger;
	
	@Resource(name="memcachedClient")
	private MemcachedClient memcachedClient;

	public Object invokeAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		ResponseBaseBean responseBaseBean = new ResponseBaseBean();
		try {
			Object[] args = joinPoint.getArgs();
			for(Object obj:args){
				//用memcached检查接口的重入性
				if(obj instanceof RequestBaseBean){
					RequestBaseBean requestBaseBean = (RequestBaseBean)obj;
					//如果请求Bean没有定义重入性检查的字段，则不进行重入性检查
					if(requestBaseBean.getKeyFields() != null){
						//构建key值
						StringBuffer keyString = new StringBuffer(BeanUtil.buildReqKeyString(requestBaseBean));
						MethodSignature signature = (MethodSignature)joinPoint.getSignature();
						Method method = signature.getMethod();
						keyString = keyString.append(method.getName());
						//在memcached中检查key值是否存在,如果存在则表示相同参数的请求还没有处理完。
						if(memcachedClient.get(keyString.toString()) == null){
							//对请求加锁,锁的有效时间为10秒
							memcachedClient.set(keyString.toString(), 10, new Date());
							//进入业务逻辑
							try
							{
								result = joinPoint.proceed();
							}catch (Exception e) {
								responseBaseBean.setMessage(EnumGeneralException.MSG_MEMCACHED_CONNECT_FAIL);
								responseBaseBean.setStatus(EnumGeneralException.CODE_MEMCACHED_CONNECT_FAIL);
								logger.error(responseBaseBean.toString());
								e.printStackTrace();
								result = responseBaseBean;
							}finally{
								//对请求解锁
								memcachedClient.delete(keyString.toString());								
							}
						}else{
							responseBaseBean.setMessage(EnumGeneralException.MSG_INVOKE_REPEATING);
							responseBaseBean.setStatus(EnumGeneralException.CODE_INVOKE_REPEATING);
							logger.error(responseBaseBean.toString());
							result = responseBaseBean;
						}
					} else {
						result = joinPoint.proceed();
					}
				}
			}
		} catch (Exception e) {
			responseBaseBean.setMessage(EnumGeneralException.MSG_MEMCACHED_CONNECT_FAIL);
			responseBaseBean.setStatus(EnumGeneralException.CODE_MEMCACHED_CONNECT_FAIL);
			logger.error(responseBaseBean.toString());
			e.printStackTrace();
			result = responseBaseBean;
		}
		return result;
	}
}
