package com.example.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

public class MyTLDialect extends AbstractDialect 
		implements IExpressionEnhancingDialect {
	
	private static final Map<String, Object> EXPRESSION_OBJECTS;

	static {
		Map<String, Object> objects = new HashMap<>();
		objects.put("myTLHelper", new MyTLUtility());
		EXPRESSION_OBJECTS = Collections.unmodifiableMap(objects);
	}

	public MyTLDialect() {
		super();
	}
	
	@Override
	public Map<String, Object> getAdditionalExpressionObjects
			(IProcessingContext processingContext) {
		return EXPRESSION_OBJECTS;
	}

	@Override
	public String getPrefix() {
		return null;
	}
}
