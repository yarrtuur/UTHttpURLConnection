package ua.com.un_th.http_url;

public class Main {
    public static void main(String[] args) {
        try {
            HttpUrlConnect huc = new HttpUrlConnect();
            String urlParameters  = "requestType=sale" +
                    "&userName=myUsername" +
                    "&password=myP%40ssword" +
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
            String body = huc.post(postUrl, urlParameters);

            System.out.println(body);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


