package com.xr.chain.api.security.service;

/**
 * Created by xps15 on 2016/12/13.
 */
public interface ECAAService {

    public void registerUser(String enrollID,String affID) throws Exception;

    public void readUserSet() throws Exception;

    public void revokeCertificate() throws Exception;

    public void publishCRL() throws Exception;
}
