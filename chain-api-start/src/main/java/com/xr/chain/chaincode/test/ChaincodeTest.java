package com.xr.chain.chaincode.test;

import java.security.cert.CertificateException;

import org.hyperledger.fabric.sdk.Chain;
import org.hyperledger.fabric.sdk.ChainCodeResponse;
import org.hyperledger.fabric.sdk.FileKeyValStore;
import org.hyperledger.fabric.sdk.Member;
import org.hyperledger.fabric.sdk.RegistrationRequest;
import org.hyperledger.fabric.sdk.exception.ChainCodeException;
import org.hyperledger.fabric.sdk.exception.EnrollmentException;
import org.hyperledger.fabric.sdk.exception.RegistrationException;
import org.junit.Before;
import org.junit.Test;

public class ChaincodeTest {

	private Chain chain = null;
	private final String MEMBER_NAME = "diego";
	private static ChainCodeResponse deployResponse = null;
	private static ChainCodeResponse javaDeployResponse = null;

	@Before
	public void setUp() {
		chain = new Chain("chain1");
		try {
			chain.setMemberServicesUrl("grpc://192.168.50.157:7054", null);
			chain.setKeyValStore(new FileKeyValStore(System
					.getProperty("user.home") + "/test.properties"));
			chain.addPeer("grpc://192.168.50.157:7051", null);
			// chain.setDevMode(true);
			Member registrar = chain.getMember(MEMBER_NAME);
			if (!registrar.isEnrolled()) {
				registrar = chain.enroll(MEMBER_NAME, "DRJ23pEQl16a");
			}
			chain.setRegistrar(registrar);
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (EnrollmentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Member getMember(String enrollmentId, String affiliation)
			throws RegistrationException, EnrollmentException {
		Member member = chain.getMember(enrollmentId);
		if (!member.isRegistered()) {
			RegistrationRequest registrationRequest = new RegistrationRequest();
			registrationRequest.setEnrollmentID(enrollmentId);
			registrationRequest.setAffiliation(affiliation);
			member = chain.registerAndEnroll(registrationRequest);
		} else if (!member.isEnrolled()) {
			member = chain.enroll(enrollmentId, member.getEnrollmentSecret());
		}
		return member;
	}

	@Test
	public void delopy() throws RegistrationException, EnrollmentException,
			ChainCodeException {

	}
}
