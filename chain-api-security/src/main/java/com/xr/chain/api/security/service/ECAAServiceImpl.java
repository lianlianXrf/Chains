package com.xr.chain.api.security.service;

import org.hyperledger.fabric.sdk.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.chain.api.common.sdk.XRChainService;

/**
 * Created by xps15 on 2016/12/13.
 */
@Service("ecaaService")
public class ECAAServiceImpl implements ECAAService {

    @Autowired
    private XRChainService xrChainService;

    public void setXrChainService(XRChainService xrChainService) {
        this.xrChainService = xrChainService;
    }

    @Override
    public void registerUser(String enrollmentID, String affiliation) throws Exception {
        RegistrationRequest req = new RegistrationRequest();
        req.setAffiliation(affiliation);
        req.setEnrollmentID(enrollmentID);
        this.xrChainService.register(req);
    }

    @Override
    public void readUserSet() throws Exception {

    }

    @Override
    public void revokeCertificate() throws Exception {

    }

    @Override
    public void publishCRL() throws Exception {

    }
}
