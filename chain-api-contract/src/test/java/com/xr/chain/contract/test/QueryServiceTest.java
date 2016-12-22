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
import com.xr.chain.contract.service.query.QueryService;

public class QueryServiceTest {
    private ApplicationContext context;
    private QueryService queryService;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        queryService = (QueryService) context.getBean("queryService");
    }

    @Test
    public void testQuery() {
        String chaincodeName = "myccj";
        ArrayList<String> args = new ArrayList<>(Arrays.asList("query", "a"));

        ResultData<ChainCodeResponse> result = queryService.query(chaincodeName, args);

        Assert.assertTrue(result.getCode() == ResultData.SUCCESS);
    }
}
