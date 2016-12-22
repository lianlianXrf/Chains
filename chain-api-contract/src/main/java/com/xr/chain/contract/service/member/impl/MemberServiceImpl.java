package com.xr.chain.contract.service.member.impl;

import org.hyperledger.fabric.sdk.Member;
import org.hyperledger.fabric.sdk.RegistrationRequest;
import org.hyperledger.fabric.sdk.exception.EnrollmentException;
import org.hyperledger.fabric.sdk.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xr.chain.api.common.sdk.XRChainService;
import com.xr.chain.contract.service.member.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private XRChainService xrChainService;

    @Override
    public Member getMember(String enrollmentId, String affiliation) throws RegistrationException, EnrollmentException {
        Member member = xrChainService.getMember(enrollmentId);
        if (!member.isRegistered()) {
            RegistrationRequest registrationRequest = new RegistrationRequest();
            registrationRequest.setEnrollmentID(enrollmentId);
            registrationRequest.setAffiliation(affiliation);
            member = xrChainService.registerAndEnroll(registrationRequest);
        } else if (!member.isEnrolled()) {
            member = xrChainService.enroll(enrollmentId, member.getEnrollmentSecret());
        }
        return member;

    }

}
