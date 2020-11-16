package src.test.json;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

/**
 * @description:
 * @author: ttao
 * @create: 2020-07-08 10:12
 **/
public class TestJson {


    @Test
    public void test1() {
        String s = "";

        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(s);
        System.out.println(map);
        Map<String, Object> formDataMap  = (Map<String, Object>) JSONObject.parse(map.get("formData").toString());
        System.out.println(formDataMap);
    }


    @Test
    public void test() {
        String s = "{\n" +
                "\t\"rsj2XY710Request\": {\n" +
                "\t\t\"fhndText\": \"2020\",\n" +
                "\t\t\"xyjf\": \"12\",\n" +
                "\t\t\"yydm\": \"2\",\n" +
                "\t\t\"data\": {\n" +
                "\t\t\t\"title\": \"申请原因\",\n" +
                "\t\t\t\"name\": \"yydm\",\n" +
                "\t\t\t\"value\": \"\",\n" +
                "\t\t\t\"type\": \"select\",\n" +
                "\t\t\t\"validate\": {\n" +
                "\t\t\t\t\"required\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"disabled\": false,\n" +
                "\t\t\t\"dataSet\": [{\n" +
                "\t\t\t\t\"ID\": \"\",\n" +
                "\t\t\t\t\"MC\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ID\": \"1\",\n" +
                "\t\t\t\t\"MC\": \"对积分事项有异议\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ID\": \"2\",\n" +
                "\t\t\t\t\"MC\": \"其他\"\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"extraDisabled\": false\n" +
                "\t\t},\n" +
                "\t\t\"getValidator\": {\n" +
                "\t\t\t\"flag\": true,\n" +
                "\t\t\t\"tip\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"xxqksm\": \"XXXXX\",\n" +
                "\t\t\"zgswjg\": \"原河北省无极县国家税务局稽查局局长室\",\n" +
                "\t\t\"shxydm\": \"930322320223009XYDM\",\n" +
                "\t\t\"sszyfwjgmc\": \"秦皇岛朗税务师事务所有限公司(09)\",\n" +
                "\t\t\"fhnd\": \"2020\",\n" +
                "\t\t\"jbrText\": \"刘强\",\n" +
                "\t\t\"jbr\": \"13113113113\",\n" +
                "\t\t\"yydmText\": \"其他\",\n" +
                "\t\t\"xwlist\": [],\n" +
                "\t\t\"key\": \"xxqksm\",\n" +
                "\t\t\"jbrdh\": \"13113113113\"\n" +
                "\t},\n" +
                "\t\"formData\": {\n" +
                "\t\t\"fhndText\": \"2020\",\n" +
                "\t\t\"xyjf\": \"12\",\n" +
                "\t\t\"yydm\": \"2\",\n" +
                "\t\t\"data\": {\n" +
                "\t\t\t\"title\": \"申请原因\",\n" +
                "\t\t\t\"name\": \"yydm\",\n" +
                "\t\t\t\"value\": \"\",\n" +
                "\t\t\t\"type\": \"select\",\n" +
                "\t\t\t\"validate\": {\n" +
                "\t\t\t\t\"required\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"disabled\": false,\n" +
                "\t\t\t\"dataSet\": [{\n" +
                "\t\t\t\t\"ID\": \"\",\n" +
                "\t\t\t\t\"MC\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ID\": \"1\",\n" +
                "\t\t\t\t\"MC\": \"对积分事项有异议\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ID\": \"2\",\n" +
                "\t\t\t\t\"MC\": \"其他\"\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"extraDisabled\": false\n" +
                "\t\t},\n" +
                "\t\t\"getValidator\": {\n" +
                "\t\t\t\"flag\": true,\n" +
                "\t\t\t\"tip\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"xxqksm\": \"\",\n" +
                "\t\t\"zgswjg\": \"原河北省无极县国家税务局稽查局局长室\",\n" +
                "\t\t\"shxydm\": \"930322320223009XYDM\",\n" +
                "\t\t\"sszyfwjgmc\": \"秦皇岛朗税务师事务所有限公司(09)\",\n" +
                "\t\t\"fhnd\": \"2020\",\n" +
                "\t\t\"jbrText\": \"刘强\",\n" +
                "\t\t\"jbr\": \"13113113113\",\n" +
                "\t\t\"yydmText\": \"其他\",\n" +
                "\t\t\"key\": \"yydm\",\n" +
                "\t\t\"jbrdh\": \"13113113113\"\n" +
                "\t},\n" +
                "\t\"formDataQt\": {\n" +
                "\t\t\"getValidator\": {\n" +
                "\t\t\t\"flag\": true,\n" +
                "\t\t\t\"tip\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"xxqksm\": \"XXXXX\",\n" +
                "\t\t\"key\": \"xxqksm\"\n" +
                "\t},\n" +
                "\t\"fbzlRequestParaVOs\": [{\n" +
                "\t\t\"swsxMxDmList\": [],\n" +
                "\t\t\"swsxDm\": \"500019\"\n" +
                "\t}],\n" +
                "\t\"blxx\": \"{\\\"slswjgMc\\\":\\\"国家税务总局新疆维吾尔自治区税务局\\\",\\\"slswjgDm\\\":\\\"16500000000\\\",\\\"slrDm\\\":\\\"Administrator\\\",\\\"slrq\\\":\\\"2020-06-17\\\"}\",\n" +
                "\t\"sqfhxwjllbDataSource\": []\n" +
                "}";

        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(s);
        System.out.println(map);
        Map<String, Object> formDataMap  = (Map<String, Object>) JSONObject.parse(map.get("formData").toString());
        System.out.println(formDataMap);
    }
}
