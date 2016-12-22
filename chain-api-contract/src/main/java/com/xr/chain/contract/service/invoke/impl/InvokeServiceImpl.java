package com.xr.chain.contract.service.invoke.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.hyperledger.fabric.sdk.ChainCodeResponse;
import org.hyperledger.fabric.sdk.ChaincodeLanguage;
import org.hyperledger.fabric.sdk.InvokeRequest;
import org.hyperledger.fabric.sdk.Member;
import org.hyperledger.fabric.sdk.exception.ChainCodeException;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.NoAvailableTCertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.chain.api.common.ResultData;
import com.xr.chain.api.common.sdk.XRChainService;
import com.xr.chain.contract.service.deploy.DeployService;
import com.xr.chain.contract.service.invoke.InvokeService;

@Service("invokeService")
public class InvokeServiceImpl implements InvokeService {

    @Autowired
    private DeployService deployService;

    @Autowired
    private Properties configProperties;

    @Autowired
    private XRChainService xrChainService;

    @Override
    public ResultData<ChainCodeResponse> invoker(String chaincodeName, ArrayList<String> args) {
        ResultData<ChainCodeResponse> result = new ResultData<>();
        ChainCodeResponse invokeResp = null;
        ChainCodeResponse deployResp = null;

        deployResp = deployService.deploy(chaincodeName);

        InvokeRequest invokeReq = new InvokeRequest();
        invokeReq.setArgs(new ArrayList<>(args));
        invokeReq.setChaincodeID(deployResp.getChainCodeID());
        invokeReq.setChaincodeName(deployResp.getChainCodeID());
        invokeReq.setChaincodeLanguage(ChaincodeLanguage.JAVA);

        String enrollmentId = configProperties.getProperty("contract.member_name");
        Member member = xrChainService.getMember(enrollmentId);
        try {
            invokeResp = member.invoke(invokeReq);

            result.setData(invokeResp);
            result.setCode(ResultData.SUCCESS);
        } catch (ChainCodeException | NoAvailableTCertException | CryptoException | IOException e) {
            result.setMsg(e.getMessage());
        }

        return result;
    }
}
