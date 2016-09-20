package com.ivk23.lms.web.validators;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ivk23.lms.web.utils.Error;

@Component
public class CustomValidator {
 
	/**
	 * Can be used to valid two dates for range.
	 * Valid range is when startDate <= endDate.
	 * That is actually what this method does.
	 * 
	 * @param start
	 * @param end
	 * @param errors
	 */
	public Optional<Error> validateDateRange(Date start, Date end) {
		Error err = null;
		
		if (start.after(end)) {
			err = new Error("Start Date value must be before End Date");
		}

		return Optional.ofNullable(err);
	}

}
