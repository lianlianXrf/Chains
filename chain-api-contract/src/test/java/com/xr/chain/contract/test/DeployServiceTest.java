package com.xr.chain.contract.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xr.chain.contract.service.deploy.DeployService;

public class DeployServiceTest {

    private ApplicationContext context;
    private DeployService deployService;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        deployService = (DeployService) context.getBean("deployService");
    }

    @Test
    public void testDeploy() {

    }
}
