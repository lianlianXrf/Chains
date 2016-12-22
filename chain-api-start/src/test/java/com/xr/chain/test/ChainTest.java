package com.xr.chain.test;

import java.security.cert.CertificateException;

import org.hyperledger.fabric.sdk.Chain;
import org.hyperledger.fabric.sdk.FileKeyValStore;
import org.hyperledger.fabric.sdk.Member;
import org.hyperledger.fabric.sdk.exception.EnrollmentException;
import org.junit.Test;

public class ChainTest {

	@Test
	public void testConnect() throws EnrollmentException, CertificateException {
		Chain testChain = new Chain("chain1");

		testChain.setMemberServicesUrl("grpc://localhost:7054", null);

		testChain.setKeyValStore(new FileKeyValStore(System
				.getProperty("user.home") + "/test.properties"));

		testChain.addPeer("grpc://localhost:7051", null);

		Member registrar = testChain.getMember("admin");

		Member member = testChain.enroll("user", "secret");
	}

}
