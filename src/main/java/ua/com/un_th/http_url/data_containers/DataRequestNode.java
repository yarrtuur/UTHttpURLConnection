package ua.com.un_th.http_url.data_containers;

import com.ebay.xcelite.annotations.Column;

import java.util.Objects;

public class DataRequestNode {
    @Column(name = "requestType")
    private String requestType;
    @Column(name = "accountId")
    private String accountId;
    @Column(name = "amount")
    private String amount;
    @Column(name = "accountType")
    private String accountType;
    @Column(name = "transactionIndustryType")
    private String transactionIndustryType;
    @Column(name = "holderType")
    private String holderType;
    @Column(name = "holderName")
    private String holderName;
    @Column(name = "accountNumber")
    private String accountNumber;
    @Column(name = "accountAccessory")
    private String accountAccessory;
    @Column(name = "street")
    private String street;
    @Column(name = "city;")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zipCode")
    private String zipCode;
    @Column(name = "customerAccountCode")
    private String customerAccountCode;
    @Column(name = "transactionCode")
    private String transactionCode;
    @Column(name = "accountData")
    private String accountData;
    @Column(name = "csc")
    private String csc;
    @Column(name = "splits")
    private String splits;

    public String getRequestType() {
        return requestType;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAmount() {
        return amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getTransactionIndustryType() {
        return transactionIndustryType;
    }

    public String getHolderType() {
        return holderType;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountAccessory() {
        return accountAccessory;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCustomerAccountCode() {
        return customerAccountCode;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public String getAccountData() {
        return accountData;
    }

    public String getCsc() {
        return csc;
    }

    public String getSplits() {
        return splits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRequestNode that = (DataRequestNode) o;
        return Objects.equals(requestType, that.requestType) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(accountType, that.accountType) &&
                Objects.equals(transactionIndustryType, that.transactionIndustryType) &&
                Objects.equals(holderType, that.holderType) &&
                Objects.equals(holderName, that.holderName) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(accountAccessory, that.accountAccessory) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(customerAccountCode, that.customerAccountCode) &&
                Objects.equals(transactionCode, that.transactionCode) &&
                Objects.equals(accountData, that.accountData) &&
                Objects.equals(csc, that.csc) &&
                Objects.equals(splits, that.splits);
    }

    @Override
    public int hashCode() {

        return Objects.hash(requestType, accountId, amount, accountType, transactionIndustryType, holderType, holderName, accountNumber, accountAccessory, street, city, state, zipCode, customerAccountCode, transactionCode, accountData, csc, splits);
    }

    @Override
    public String toString() {
        return "DataRequestNode{" +
                "requestType='" + requestType + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount='" + amount + '\'' +
                ", accountType='" + accountType + '\'' +
                ", transactionIndustryType='" + transactionIndustryType + '\'' +
                ", holderType='" + holderType + '\'' +
                ", holderName='" + holderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountAccessory='" + accountAccessory + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", customerAccountCode='" + customerAccountCode + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                ", accountData='" + accountData + '\'' +
                ", csc='" + csc + '\'' +
                ", splits='" + splits + '\'' +
                '}';
    }
}
