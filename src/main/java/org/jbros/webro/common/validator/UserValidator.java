package org.jbros.webro.common.validator;

import org.jbros.webro.models.UserModel;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{
	/**
	 * supports Method -  검증 할 수있는 오브젝트 타입인지를 확인하는 메서드
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return UserModel.class.isAssignableFrom(clazz);
	}
	/**
	 * supports 통과 후 호출
	 * DB에서 NOT NULL 컬럼 SERVER 단에서 체크
	 * 
	 */
	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required", new Object[] {"memberId" }, "Enter your Id");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "required", new Object[] {"memberPass" }, "Enter your Password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", new Object[] {"memberName"}, "Enter your name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required", new Object[] {"permission"}, "Enter your phone");
	}
}
