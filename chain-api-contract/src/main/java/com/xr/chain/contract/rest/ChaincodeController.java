package com.xr.chain.contract.rest;

import java.util.ArrayList;

import org.hyperledger.fabric.sdk.ChainCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.xr.chain.api.common.ResultData;
import com.xr.chain.contract.service.deploy.DeployService;
import com.xr.chain.contract.service.invoke.InvokeService;
import com.xr.chain.contract.service.query.QueryService;

@RestController
@RequestMapping("/chaincode")
public class ChaincodeController {
    @Autowired
    private DeployService deployService;

    @Autowired
    private InvokeService invokeService;

    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/invoke", method = RequestMethod.GET)
    @ResponseBody
    public Object invoke(String chaincodeName, String args) {
        ArrayList<String> arrayArgs = Lists.newArrayList(Splitter.on(",").split(args));

        ResultData<ChainCodeResponse> result = invokeService.invoker(chaincodeName, arrayArgs);

        return result;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Object query(String chaincodeName, String args) {
        ArrayList<String> arrayArgs = Lists.newArrayList(Splitter.on(",").split(args));

        ResultData<ChainCodeResponse> result = queryService.query(chaincodeName, arrayArgs);

        return result;
    }
}
