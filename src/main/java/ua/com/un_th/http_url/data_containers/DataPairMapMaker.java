package ua.com.un_th.http_url.data_containers;

import ua.com.un_th.http_url.ExitException;
import ua.com.un_th.http_url.utils.HttpUrlRequest;
import ua.com.un_th.http_url.utils.LoadRequestParams;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataPairMapMaker {
	private Map<DataRequestNode, Map<String, String>> dataPairMap;
	private LoadRequestParams loader;


	public DataPairMapMaker() throws ExitException {
		this.dataPairMap = new LinkedHashMap<>();
		this.loader = new LoadRequestParams();
	}

	public Map<DataRequestNode, Map<String, String>> getDataPairMap() throws ExitException {
		String postUrl = loader.getUrlConnect();
		String userNameAndPasswd = loader.getUserNameAndPasswd();
		Collection<DataRequestNode> requestList = loader.getRequestList();

		for (DataRequestNode requestFields : requestList) {
			StringBuilder sb = new StringBuilder();
			sb.append("requestType").append("=").append(requestFields.getRequestType()).append(userNameAndPasswd);
			sb.append("&accountId").append("=").append(requestFields.getAccountId());
			sb.append("&amount").append("=").append(requestFields.getAmount());
			sb.append("&accountType").append("=").append(requestFields.getAccountType());
			sb.append("&transactionIndustryType").append("=").append(requestFields.getTransactionIndustryType());
			sb.append("&holderType").append("=").append(requestFields.getHolderType());
			sb.append("&holderName").append("=").append(requestFields.getHolderName());
			sb.append("&accountNumber").append("=").append(requestFields.getAccountNumber());
			sb.append("&accountAccessory").append("=").append(requestFields.getAccountAccessory());
			sb.append("&street").append("=").append(requestFields.getStreet());
			sb.append("&city").append("=").append(requestFields.getCity());
			sb.append("&state").append("=").append(requestFields.getState());
			sb.append("&zipCode").append("=").append(requestFields.getZipCode());
			sb.append("&customerAccountCode").append("=").append(requestFields.getCustomerAccountCode());
			sb.append("&transactionCode").append("=").append(requestFields.getTransactionCode());
			sb.append("&accountData").append("=").append(requestFields.getAccountData());
			sb.append("&csc").append("=").append(requestFields.getCsc());
			sb.append("&splits").append("=").append(requestFields.getSplits());


			String urlParameters = sb.toString();
			HttpUrlRequest huc = new HttpUrlRequest();
			Map<String, String> responseFields = huc.postRequest(postUrl, urlParameters);
			dataPairMap.put(requestFields, responseFields);
		}
		return dataPairMap;
	}
}
