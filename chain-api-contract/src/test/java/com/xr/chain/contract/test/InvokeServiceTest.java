package com.xr.chain.contract.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.hyperledger.fabric.sdk.ChainCodeResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xr.chain.api.common.ResultData;
import com.xr.chain.api.exception.XrInvokerException;
import com.xr.chain.contract.service.invoke.InvokeService;

public class InvokeServiceTest {
    private ApplicationContext context;
    private InvokeService invokeService;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        invokeService = (InvokeService) context.getBean("invokeService");
    }

    @Test
    public void testInvoke() throws XrInvokerException {
        String chaincodeName = "myccj";
        ArrayList<String> args = new ArrayList<>(Arrays.asList("init", "a", "700", "b", "20000"));

        ResultData<ChainCodeResponse> result = invokeService.invoker(chaincodeName, args);

        Assert.assertTrue(result.getCode() == ResultData.SUCCESS);
    }
}
