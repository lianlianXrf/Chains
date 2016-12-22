package com.xr.chain.contract.service.deploy.impl;

import java.util.concurrent.ExecutionException;

import org.hyperledger.fabric.sdk.ChainCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.chain.api.common.cache.CacheUtil;
import com.xr.chain.contract.common.SpringContextUtil;
import com.xr.chain.contract.service.deploy.DeployService;

@Service("deployService")
public class DeployServiceImpl implements DeployService {
    public final String PREFIX_BEANNAME = "xrContractService_";

    @Autowired
    private SpringContextUtil springContextUtil;

    @Override
    public ChainCodeResponse deploy(String chaincodeName) {
        XRContractService xrContractService = (XRContractService) SpringContextUtil.getBean(PREFIX_BEANNAME + chaincodeName);

        ChainCodeResponse response = null;
        try {
            Object object = CacheUtil.get(chaincodeName);
            if (object instanceof ChainCodeResponse) {
                return (ChainCodeResponse) object;
            } else {
                response = xrContractService.deploy();
                CacheUtil.put(chaincodeName, response);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return response;
    }

}
