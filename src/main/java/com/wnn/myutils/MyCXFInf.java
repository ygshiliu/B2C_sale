package com.wnn.myutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.springframework.beans.factory.FactoryBean;

public class MyCXFInf<T> implements FactoryBean<T>{
	
	private Class<T> t;
	private String url;
	

	public Class<T> getT() {
		return t;
	}

	public void setT(Class<T> t) {
		this.t = t;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public T getObject() throws Exception {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress(url);
		factoryBean.setServiceClass(t);
		//访问的接口为指定时才加密
		
//		Map<String, Object> props=new HashMap<String, Object>();
//		props.put("action", ConfigurationConstants.ACTION);
//		props.put("user", ConfigurationConstants.USER);
//		props.put("passwordType", ConfigurationConstants.PASSWORD_TYPE);
//		props.put(ConfigurationConstants.PW_CALLBACK_REF,MyWsClientCallBackFunction.class.getName());
//		
//		System.err.println("=======client>>>>>>>>>>>>======="+MyWsClientCallBackFunction.class.getName());
//		
//		WSS4JOutInterceptor e = new WSS4JOutInterceptor(props);
//		factoryBean.getOutInterceptors().add(e);
//		
		T create = (T) factoryBean.create();
		return create;
	}

	
	@Override
	public Class<?> getObjectType() {
		return t;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
