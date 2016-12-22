package com.xr.chain.contract.service.query;

import java.util.ArrayList;

import org.hyperledger.fabric.sdk.ChainCodeResponse;

import com.xr.chain.api.common.ResultData;

public interface QueryService {

    public ResultData<ChainCodeResponse> query(String chaincodeName, ArrayList<String> args);
}
