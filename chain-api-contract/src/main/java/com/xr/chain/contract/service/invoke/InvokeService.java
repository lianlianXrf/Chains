package com.xr.chain.contract.service.invoke;

import java.util.ArrayList;

import org.hyperledger.fabric.sdk.ChainCodeResponse;

import com.xr.chain.api.common.ResultData;

public interface InvokeService {

    public ResultData<ChainCodeResponse> invoker(String chaincodeName, ArrayList<String> args);
}
