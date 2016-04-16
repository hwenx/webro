package org.jbros.webro.common.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbros.webro.common.models.Response;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

public class GeneralValidation {
	
	/**
	 * controller에서 bindingResult 타입 오브젝트 사용
	 * @param validator
	 * @param model
	 * @param bindingResult
	 * @return
	 */
	public <T> Response hasHttpParamsErrors(Validator validator, T model, BindingResult bindingResult) {
		Response resp = null;
		
		if (validator != null) {
			validator.validate(model, bindingResult);
			if (bindingResult.hasErrors()) {
				resp = new Response();
				resp.setStat("fail");
				resp.setCode("invalid parameter");
				
				List<Map<String, Object>> httpParamsErrors = new ArrayList<Map<String, Object>>();
				for (ObjectError objectError : bindingResult.getAllErrors()) {
					Map<String, Object> errorMap = new HashMap<String, Object>();
					errorMap.put("key", objectError.getArguments()[0]);
					errorMap.put("message", objectError.getDefaultMessage());
					
					httpParamsErrors.add(errorMap);
				}
				
				resp.setData(httpParamsErrors);
			}
		} /*else {
			resp = new Response();
			resp.setStat("ok");
			resp.setData("success");
		}*/
		
		return resp;
	}
}
