package com.xr.chain.contract.service.member;

import org.hyperledger.fabric.sdk.Member;
import org.hyperledger.fabric.sdk.exception.EnrollmentException;
import org.hyperledger.fabric.sdk.exception.RegistrationException;

public interface MemberService {

    public Member getMember(String enrollmentId, String affiliation) throws RegistrationException, EnrollmentException;
}
