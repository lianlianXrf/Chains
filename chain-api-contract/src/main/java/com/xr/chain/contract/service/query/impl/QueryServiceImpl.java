package com.xr.chain.contract.service.query.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.hyperledger.fabric.sdk.ChainCodeResponse;
import org.hyperledger.fabric.sdk.ChaincodeLanguage;
import org.hyperledger.fabric.sdk.Member;
import org.hyperledger.fabric.sdk.QueryRequest;
import org.hyperledger.fabric.sdk.exception.ChainCodeException;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.NoAvailableTCertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.chain.api.common.ResultData;
import com.xr.chain.api.common.sdk.XRChainService;
import com.xr.chain.contract.service.deploy.DeployService;
import com.xr.chain.contract.service.query.QueryService;

@Service("queryService")
public class QueryServiceImpl implements QueryService {

    @Autowired
    private DeployService deployService;

    @Autowired
    private Properties configProperties;

    @Autowired
    private XRChainService xrChainService;

    @Override
    public ResultData<ChainCodeResponse> query(String chaincodeName, ArrayList<String> args) {
        ResultData<ChainCodeResponse> result = new ResultData<>();

        ChainCodeResponse queryResp = null;
        ChainCodeResponse deployResp = deployService.deploy(chaincodeName);

        QueryRequest queryReq = new QueryRequest();
        queryReq.setArgs(new ArrayList<>(args));
        queryReq.setChaincodeID(deployResp.getChainCodeID());
        queryReq.setChaincodeName(deployResp.getChainCodeID());
        queryReq.setChaincodeLanguage(ChaincodeLanguage.JAVA);

        String enrollmentId = configProperties.getProperty("contract.member_name");
        Member member = xrChainService.getMember(enrollmentId);
        try {
            queryResp = member.query(queryReq);

            result.setData(queryResp);
            result.setCode(ResultData.SUCCESS);
        } catch (ChainCodeException | NoAvailableTCertException | CryptoException | IOException e) {
            result.setMsg(e.getMessage());
        }

        return result;

    }

}
