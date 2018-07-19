package ua.com.un_th.http_url;

public class Main {
    public static void main(String[] args) {
        try {
            HttpUrlRequest huc = new HttpUrlRequest();
            String urlParameters  = "requestType=sale" +
                    "&userName=test_api_user" +
                    "&password=C8v20gAdHjig3LMRWGhm5PK1G00v08V1" +
                    "&accountId=2001&amount=5000" +
                    "&accountType=R" +
                    "&transactionIndustryType=RE" +
                    "&holderType=P" +
                    "&holderName=John+Smith" +
                    "&accountNumber=4111111111111111" +
                    "&accountAccessory=0422" +
                    "&street=12+Main+St" +
                    "&city=Denver" +
                    "&state=CO" +
                    "&zipCode=30301" +
                    "&customerAccountCode=0000000001" +
                    "&transactionCode=0000000001";
            String postUrl = "https://sandbox-secure.unitedthinkers.com/gates/xurl";
            huc.post(postUrl, urlParameters);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


