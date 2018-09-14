package com.testcases;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.spring.SpringConfiguration;

@ContextConfiguration(classes = { SpringConfiguration.class })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class BaseTestCase extends AbstractTestNGSpringContextTests {

	
	
}
