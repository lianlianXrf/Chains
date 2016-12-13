package com.xr.chain.api.common.sdk;


import org.hyperledger.fabric.sdk.Chain;
import org.hyperledger.fabric.sdk.FileKeyValStore;
import org.hyperledger.fabric.sdk.Member;

/**
 * Created by xps15 on 2016/12/13.
 */
public class XRChainService extends Chain {
	

	private String name;
	private String memberUrl;
	private String pem;
	private String peerUrl;
	private String adminName;
	private String adminToken;
	private String keyStorePath;
	
    public XRChainService(String name) {
        super(name);
    }

    public void init() {
    	try {
        	super.setMemberServicesUrl(memberUrl, pem);
        	super.setKeyValStore(new FileKeyValStore(keyStorePath));
        	super.addPeer(peerUrl, pem);
        	Member member = super.getMember(adminName);
        	if(!member.isEnrolled()) {
                member = super.enroll(this.adminName, this.adminToken);
            }
            super.setRegistrar(member);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberUrl() {
		return memberUrl;
	}

	public void setMemberUrl(String memberUrl) {
		this.memberUrl = memberUrl;
	}

	public String getPem() {
		return pem;
	}

	public void setPem(String pem) {
		this.pem = pem;
	}

	public String getPeerUrl() {
		return peerUrl;
	}

	public void setPeerUrl(String peerUrl) {
		this.peerUrl = peerUrl;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminToken() {
		return adminToken;
	}

	public void setAdminToken(String adminToken) {
		this.adminToken = adminToken;
	}

	public String getKeyStorePath() {
		return keyStorePath;
	}

	public void setKeyStorePath(String keyStorePath) {
		this.keyStorePath = keyStorePath;
	}



}
