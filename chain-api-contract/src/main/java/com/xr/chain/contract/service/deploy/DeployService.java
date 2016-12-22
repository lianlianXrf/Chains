package com.xr.chain.contract.service.deploy;

import org.hyperledger.fabric.sdk.ChainCodeResponse;

/**
 * 
 * @author yaobo
 *
 */
public interface DeployService {

    public ChainCodeResponse deploy(String chaincodeName);
}
