package ua.com.un_th.http_url.data_containers;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.un_th.http_url.ExitException;

import java.util.Map;

import static org.junit.Assert.*;

public class DataPairMapMakerTest {

    private static DataPairMapMaker dataPairMapMaker;
    private static Map<DataRequestNode, Map<String, String>> pairMap;

    @BeforeClass
    public static void setUpBefore()throws Exception {
        dataPairMapMaker = new DataPairMapMaker();
        pairMap = dataPairMapMaker.getDataPairMap();
    }


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTestResponseCodeExpectedA01() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getAmount().equals("5000")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("A01", responseMap.get("responseCode"));
    }

    @Test
    public void getTestResponseCodeExpectedD03() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getAmount().equals("12500")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("D03", responseMap.get("responseCode"));
    }

    @Test
    public void getTestResponseCodeExpectedD05() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getAmount().equals("7500")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("D05", responseMap.get("responseCode"));
    }

    @Test
    public void getTestResponseCodeExpectedE02() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getAmount().equals("13500")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("E02", responseMap.get("responseCode"));
    }

    @Test
    public void getTestAVSVerificationExpected00() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getZipCode().equals("11111")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("00", responseMap.get("avsResponseCode"));
    }

    @Test
    public void getTestAVSVerificationExpected46() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getZipCode().equals("22222")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("46", responseMap.get("avsResponseCode"));
    }

    @Test
    public void getTestAVSVerificationExpected43() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getZipCode().equals("33333")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("43", responseMap.get("avsResponseCode"));
    }

    @Test
    public void getTestAVSVerificationExpected40() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getZipCode().equals("44444")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("40", responseMap.get("avsResponseCode"));
    }

    @Test
    public void getCSCVerificationExpectedMTest() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getCsc().equals("111")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("M", responseMap.get("cscResponseCode"));
    }

    @Test
    public void getTestCSCVerificationExpectedN() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getCsc().equals("222")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("N", responseMap.get("cscResponseCode"));
    }

    @Test
    public void getTestCSCVerificationExpectedP() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getCsc().equals("333")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("P", responseMap.get("cscResponseCode"));
    }

    @Test
    public void getTestCSCVerificationExpectedS() throws ExitException {
        DataRequestNode requestKey = null;
        Map<String, String> responseMap = null;
        for (Map.Entry<DataRequestNode, Map<String, String>> entry : pairMap.entrySet()) {
             requestKey = entry.getKey();
             if(requestKey.getCsc().equals("444")) {
                 responseMap = entry.getValue();
                 break;
             }
        }
        assertEquals("S", responseMap.get("cscResponseCode"));
    }

}