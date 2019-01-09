package com.xwtech.bit.api.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JackFeng
 */
@Entity
@Table(name = "token")
public class Token  implements Serializable{

	private static final long serialVersionUID = -7433423796259059858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "memberId")
    private String memberId;
	
	@Column(name = "accessToken")
    private String accessToken;
	
	@Column(name = "secret")
    private String secret;
	
	@Column(name = "createdTime")
    private Date createdTime;
	
	@Column(name = "expiresTime")
    private Date expiresTime;
	
	@Column(name = "clientIp")
    private String clientIp;
	
	@Column(name = "clientType")
    private String clientType;
	
	@Column(name = "eCode")
    private String eCode;
	
	@Column(name = "uCode")
    private String uCode;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(Date expiresTime) {
        this.expiresTime = expiresTime;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String getuCode() {
        return uCode;
    }

    public void setuCode(String uCode) {
        this.uCode = uCode;
    }

	@Override
	public String toString() {
		return "Token [id=" + id + ", memberId=" + memberId + ", accessToken=" + accessToken + ", secret=" + secret
				+ ", createdTime=" + createdTime + ", expiresTime=" + expiresTime + ", clientIp=" + clientIp
				+ ", clientType=" + clientType + ", eCode=" + eCode + ", uCode=" + uCode + "]";
	}
    
    
}
