package ua.com.un_th.http_url;

import com.ebay.xcelite.annotations.Column;

public class DataNode {
	@Column(name="requestType")
	private String requestType;
	@Column(name="accountId")
	private String accountId;
	@Column(name="amount")
	private String amount;
	@Column(name="accountType")
	private String accountType;
	@Column(name="transactionIndustryType")
	private String transactionIndustryType;
	@Column(name="holderType")
	private String holderType;
	@Column(name="holderName")
	private String holderName;
	@Column(name="accountNumber")
	private String accountNumber;
	@Column(name="accountAccessory")
	private String accountAccessory;
	@Column(name="street")
	private String street;
	@Column(name="city;")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zipCode")
	private String zipCode;
	@Column(name="customerAccountCode")
	private String customerAccountCode;
	@Column(name="transactionCode")
	private String transactionCode;

}
