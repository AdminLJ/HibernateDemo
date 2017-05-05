package com.lijie.empty;

/**
 * DUser entity. @author MyEclipse Persistence Tools
 */

public class DUser implements java.io.Serializable {

	// Fields

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private Integer userIntegral;
	private String isEmailVerify;
	private String emailVerifyCode;
	private Long lastLoginTime;
	private String lastLoginIp;

	// Constructors

	/** default constructor */
	public DUser() {
	}

	/** minimal constructor */
	public DUser(String email, String password, Integer userIntegral) {
		this.email = email;
		this.password = password;
		this.userIntegral = userIntegral;
	}

	/** full constructor */
	public DUser(String email, String nickname, String password, Integer userIntegral, String isEmailVerify,
			String emailVerifyCode, Long lastLoginTime, String lastLoginIp) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
	}

	// Property accessors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}

	public String getIsEmailVerify() {
		return isEmailVerify;
	}

	public void setIsEmailVerify(String isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public String toString() {
		return "DUser [id=" + id + ", email=" + email + ", nickname=" + nickname + ", password=" + password
				+ ", userIntegral=" + userIntegral + ", isEmailVerify=" + isEmailVerify + ", emailVerifyCode="
				+ emailVerifyCode + ", lastLoginTime=" + lastLoginTime + ", lastLoginIp=" + lastLoginIp + "]";
	}

}