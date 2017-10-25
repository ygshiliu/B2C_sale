package com.wnn.myutils;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class MyWsClientCallBackFunction implements CallbackHandler{

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback ps =  (WSPasswordCallback) callbacks[0];
		ps.setIdentifier("haha");
		ps.setPassword("123");
		
	}

}
