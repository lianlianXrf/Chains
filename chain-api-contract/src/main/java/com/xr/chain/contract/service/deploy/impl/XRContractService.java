package com.xr.chain.contract.service.deploy.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.hyperledger.fabric.sdk.ChainCodeResponse;
import org.hyperledger.fabric.sdk.ChaincodeLanguage;
import org.hyperledger.fabric.sdk.DeployRequest;
import org.hyperledger.fabric.sdk.Member;
import org.hyperledger.fabric.sdk.exception.ChainCodeException;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.NoAvailableTCertException;

import com.xr.chain.api.common.sdk.XRChainService;

public class XRContractService {

    private String chaincodeName;

    private String chaincodePath;

    private ChaincodeLanguage chaincodeLanguage;

    private XRChainService xrChainService;

    private String enrollmentId;

    private String affiliation;

    private ChainCodeResponse resp;

    public XRContractService() {

    }

    public ChainCodeResponse deploy() {
        Member member = xrChainService.getMember(enrollmentId);

        DeployRequest request = new DeployRequest();
        request.setChaincodePath(chaincodePath);
        request.setChaincodeName(chaincodeName);
        request.setChaincodeLanguage(chaincodeLanguage);
        request.setFcn("");
        request.setArgs(new ArrayList<String>());
        ChainCodeResponse response = null;
        try {
            response = member.deploy(request);
        } catch (ChainCodeException | NoAvailableTCertException | CryptoException | IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getChaincodeName() {
        return chaincodeName;
    }

    public void setChaincodeName(String chaincodeName) {
        this.chaincodeName = chaincodeName;
    }

    public String getChaincodePath() {
        return chaincodePath;
    }

    public void setChaincodePath(String chaincodePath) {
        this.chaincodePath = chaincodePath;
    }

    public ChaincodeLanguage getChaincodeLanguage() {
        return chaincodeLanguage;
    }

    public void setChaincodeLanguage(ChaincodeLanguage chaincodeLanguage) {
        this.chaincodeLanguage = chaincodeLanguage;
    }

    public ChainCodeResponse getResp() {
        return resp;
    }

    public XRChainService getXrChainService() {
        return xrChainService;
    }

    public void setXrChainService(XRChainService xrChainService) {
        this.xrChainService = xrChainService;
    }

}
