package com.xr.chain.chaincode.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.sdk.shim.ChaincodeBase;
import org.hyperledger.fabric.sdk.shim.ChaincodeStub;

public class Example extends ChaincodeBase {
	private static Log log = LogFactory.getLog(Example.class);

	@Override
	public String run(ChaincodeStub stub, String function, String[] args) {
		log.info("In run,function:" + function);

		if ("put".equals(function)) {
			for (int i = 0; i < args.length; i += 2) {
				stub.putState(args[i], args[i + 1]);
			}
		} else if ("del".equals(function)) {
			for (String arg : args) {
				stub.delState(arg);
			}
		} else if ("hello".equals(function)) {
			System.out.println("hello invoked");
			log.info("hello invoked");
		}

		log.error("No matching case for function:" + function);
		return null;
	}

	@Override
	public String query(ChaincodeStub stub, String function, String[] args) {
		log.info("query");
		System.out.println("Hello world!function:" + function);
		log.debug("query:" + args[0] + "=" + stub.getState(args[0]));
		if (stub.getState(args[0]) != null && !stub.getState(args[0]).isEmpty()) {
			log.trace("returning:Hello world!from " + stub.getState(args[0]));
			return "Hello world! from " + stub.getState(args[0]);
		}

		log.debug("No value found for key '" + args[0] + "'");
		return "Hello " + args[0] + "1";
	}

	@Override
	public String getChaincodeID() {
		return "hello world";
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Hello world!starting " + args);
		log.info("starting");
		String[] as = new String[4];
		as[0] = "A";
		as[1] = "100";
		as[2] = "B";
		as[3] = "50";
		new Example().start(as);
	}

}
