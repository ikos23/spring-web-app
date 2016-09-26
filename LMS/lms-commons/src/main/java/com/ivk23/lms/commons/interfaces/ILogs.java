package com.ivk23.lms.commons.interfaces;

import java.util.Date;

public interface ILogs {

	Long getId();

	String getMethod();

	String getParams();

	Date getInvokationDate();

}
