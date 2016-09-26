package com.ivk23.lms.aop.aspects;

import java.util.Date;

import com.ivk23.lms.commons.interfaces.ILogs;

public class BaseAspect {

	protected ILogs createLogByParams(final String method, final Object[] args, final Date date) {

		String res = "";
		for (Object o : args) {
			res += o.toString() + ",";
		}
		final String argsAsStr = (res.length() > 0) ? res.substring(0, res.length() - 1) : "( )";
		return new ILogs() {

			@Override
			public String getParams() {
				return argsAsStr;
			}

			@Override
			public String getMethod() {
				return method;
			}

			@Override
			public Date getInvokationDate() {
				return date;
			}

			@Override
			public Long getId() {
				return 0L;
			}

		};
	}

}
