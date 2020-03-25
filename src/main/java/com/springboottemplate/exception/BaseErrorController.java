package com.springboottemplate.exception;

import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;

/**
 * @Description:springboot得错误处理计制
 * @author: 唐涛
 * @date:   2019年12月11日 下午2:23:45   
 *   
 */
public class BaseErrorController extends AbstractErrorController {

	public BaseErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
