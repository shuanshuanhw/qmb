package com.sdlib.qmb;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.http.Header;
import cn.hutool.http.webservice.SoapClient;
import cn.hutool.http.webservice.SoapProtocol;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名： Test
 * 描述 TODO：
 * 创建时间： 2022/4/29 9:58
 * 创建人： Administrator
 */
@Component
@Lazy(value = false)

public class Test implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    // 读者信息查询接口
    public void queryReaderInfo()
    {
        String ReaderID = "9177008239";
        String body = "";
        try {
            //       String apiURL = "http://202.105.30.39/fslibNew5U/queryReaderInfo";
            String apiURL = "http://202.105.30.39:8280/fslibNew5U/queryReaderInfo";

            Base64 base64=new Base64();
            byte[] encode = base64.encode("SD001.lib:159##sd001:af316282b8c94b95bafd324b38a3d6e3".getBytes());

            SoapClient client = SoapClient.create(apiURL).init(SoapProtocol.SOAP_1_2)
                    // 设置要请求的方法，传入对应的命名空间
                    .setMethod("impl:queryReaderInfo", "http://impl.services.webservice.ilas.com")
                    // 设置参数，此处自动添加方法的前缀：impl
                    .setParam("identifier", ReaderID)
                    .header(Header.AUTHORIZATION, "Basic "+new String(encode))
                    .header(Header.CONTENT_TYPE, "text/html");
            // 发送请求，参数true表示返回一个格式化后的XML内容
            body = client.send(true);
        } catch (RestClientException e) {
            e.printStackTrace();
            //    AssertUtil.isTrue(true, "访问SOA错误");
        }
        if (body != null && !"".equals(body)) {
            //  返回内容为XML字符串，配合XmlUtil解析这个响应
            //           User user = new User();
            try {
                Document document = XmlUtil.parseXml(body);

                String xpath = "//soapenv:Envelope/soapenv:Body/ns:queryReaderInfoResponse/ns:return/ax21:";
//                String gid = GuidUtil.GetGuid();
//                user.setId(gid);
                String readername = XmlUtil.getByXPath(xpath + "patronName", document, XPathConstants.STRING).toString();
                System.out.println(readername);
//                user.setUsername(readername);
//                user.setReaderid(XmlUtil.getByXPath(xpath + "patronIdentifier", document, XPathConstants.STRING).toString());
//                user.setIdnumber(XmlUtil.getByXPath(xpath + "certify", document, XPathConstants.STRING).toString());
//                user.setIdtype(XmlUtil.getByXPath(xpath + "cettype", document, XPathConstants.STRING).toString());
//                user.setRoletype(1);
//                user.setSex(XmlUtil.getByXPath(xpath + "sex", document, XPathConstants.STRING).toString());
//                String bornDate = XmlUtil.getByXPath(xpath + "bornDate", document, XPathConstants.STRING).toString();
//                bornDate = DateUtil.format(DateUtil.parse(bornDate, "yyyyMMdd"), "yyyy-MM-dd");
//                user.setBirthdate(bornDate);
//                user.setLibcode(XmlUtil.getByXPath(xpath + "libcode", document, XPathConstants.STRING).toString());
//                user.setLibname(XmlUtil.getByXPath(xpath + "institutionId", document, XPathConstants.STRING).toString());
//                user.setPhone(XmlUtil.getByXPath(xpath + "phone", document, XPathConstants.STRING).toString());
//                user.setEmail(XmlUtil.getByXPath(xpath + "email", document, XPathConstants.STRING).toString());
//                user.setCredit(0);
//                user.setCreditsum(0);
//                user.setHolditemscount(0);
//                user.setChargeditemscount(0);
//                user.setLastlogintime(DateTime.now());
//                user.setStatus("n");
//                user.setCreatetime(DateTime.now());
//                user.setCreateuserid(gid);
//                user.setCreateuser(readername);
//                user.setUpdatetime(DateTime.now());
//                user.setUpdateuser(readername);
//                user.setUpdateuserid(gid);
//                user.setAddress(XmlUtil.getByXPath(xpath + "address", document, XPathConstants.STRING).toString());
            } catch (UtilException e) {
                e.printStackTrace();
                //      AssertUtil.isTrue(true, "读者不存在");
            }
            //         AssertUtil.isTrue(userMapper.insert(user) != 1, "添加读者失败");
            //    return user;
        } else
        {

        }
        //     AssertUtil.isTrue(true, "访问SOA错误");
    }
    // 过期文献信息查询接口
    static public void queryOverdueBooks() {
        String ReaderID = "9177008239";
        String body = "";
        try {
            //       String apiURL = "http://202.105.30.39/fslibNew5U/queryReaderInfo";
            String apiURL = "http://202.105.30.39:8280/fslibNew5U/queryOverdueBooks";

            Base64 base64=new Base64();
            byte[] encode = base64.encode("SD001.lib:159##sd001:a30d90bc6cb04947a43a98c474732a99".getBytes());

            SoapClient client = SoapClient.create(apiURL).init(SoapProtocol.SOAP_1_2)
                    // 设置要请求的方法，传入对应的命名空间
                    .setMethod("impl:queryOverdueBooks", "http://impl.services.webservice.ilas.com")
                    // 设置参数，此处自动添加方法的前缀：impl
                    .setParam("libcode", "SD001")
                    .setParam("days",3)
                    .setParam("page",1)
                    .setParam("size",500)
                    .header(Header.AUTHORIZATION, "Basic "+new String(encode))
                    .header(Header.CONTENT_TYPE, "text/html");
            // 发送请求，参数true表示返回一个格式化后的XML内容
            body = client.send(true);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        if (body != null && !"".equals(body)) {
            //  返回内容为XML字符串，配合XmlUtil解析这个响应
            //           User user = new User();
            try {
                Document document = XmlUtil.parseXml(body);
                String xpath = "//soapenv:Envelope/soapenv:Body/ns:queryOverdueBooksResponse/ns:return/ax21:overdueBooks/ax21:";
                String barCode = XmlUtil.getByXPath(xpath + "barCode", document, XPathConstants.STRING).toString();

                Map<String, Object> result1 = new HashMap<>(50);
                Map<String, Object> stringObjectMap = XmlUtil.xmlToMap(body, result1);

           //     Map<String, Object> msgInfo = (Map<String, Object>) stringObjectMap.get("ns:return");

                Map<String, Object> soapenvBody = (Map<String, Object>) stringObjectMap.get("soapenv:Body");
                Map<String, Object> queryOverdueBooksResponse = (Map<String, Object>) soapenvBody.get("ns:queryOverdueBooksResponse");
                Map<String, Object> nsReturn = (Map<String, Object>) queryOverdueBooksResponse.get("ns:return");
                List<Map<String, Object>> overdueBooks = (List<Map<String, Object>>) nsReturn.get("ax21:overdueBooks");
                for(Map<String, Object> map : overdueBooks)
                {
                    System.out.println(map.get("ax21:barCode"));
                }
//                List<Map<String, Object>> msgList = new ArrayList<>();
//
//                msgList = (List<Map<String, Object>>) msgInfo.get("ax21:overdueBooks");


//                NodeList list = (NodeList) XmlUtil.getByXPath(xpath + "barCode", document);

                System.out.println(barCode);
            } catch (UtilException e) {
                e.printStackTrace();
                //      AssertUtil.isTrue(true, "读者不存在");
            }
            //         AssertUtil.isTrue(userMapper.insert(user) != 1, "添加读者失败");
            //    return user;
        } else
        {

        }
        //     AssertUtil.isTrue(true, "访问SOA错误");

    }
    // 还书案例
    static public void returnBook()
    {

        String ReaderID = "9177008239";
        String body = "";
        try {
            //       String apiURL = "http://202.105.30.39/fslibNew5U/queryReaderInfo";
            String apiURL = "http://202.105.30.39:8280/fslibNew5U/ReturnBook";

            Base64 base64=new Base64();
            byte[] encode = base64.encode("SD001.lib:159##sd001:fe2738fd689f44cf8262e79eee6b9923".getBytes());

            SoapClient client = SoapClient.create(apiURL).init(SoapProtocol.SOAP_1_2)
                    // 设置要请求的方法，传入对应的命名空间
                    .setMethod("impl:ReturnBook", "http://impl.services.webservice.ilas.com")
                    // 设置参数，此处自动添加方法的前缀：impl
                    .setParam("identifier", "1000000109")
                    .setParam("dueLocal","SD001")
                    .setParam("barcode","FS00101993839")
                  //  .setParam("dueman","")
                    .setParam("keycode",new SetUserCheck().getMD5Code("1000000109"))
                    .header(Header.AUTHORIZATION, "Basic "+new String(encode))
                    .header(Header.CONTENT_TYPE, "text/html");
            // 发送请求，参数true表示返回一个格式化后的XML内容
            body = client.send(true);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        if (body != null && !"".equals(body)) {
            //  返回内容为XML字符串，配合XmlUtil解析这个响应
            //           User user = new User();
            try {
              //  Document document = XmlUtil.parseXml(body);
//                String xpath = "//soapenv:Envelope/soapenv:Body/ns:queryReaderInfoResponse/ns:return/ax21:";
//                String readername = XmlUtil.getByXPath(xpath + "patronName", document, XPathConstants.STRING).toString();
//                System.out.println(readername);
                Map<String, Object> result1 = new HashMap<>(50);
                Map<String, Object> stringObjectMap = XmlUtil.xmlToMap(body, result1);
                Map<String, Object> soapenvBody = (Map<String, Object>) stringObjectMap.get("soapenv:Body");
                System.out.println(soapenvBody.toString());
            } catch (UtilException e) {
                e.printStackTrace();
                //      AssertUtil.isTrue(true, "读者不存在");
            }
            //         AssertUtil.isTrue(userMapper.insert(user) != 1, "添加读者失败");
            //    return user;
        } else
        {

        }
        //     AssertUtil.isTrue(true, "访问SOA错误");
    }



    public static void main(String[] args) {
        Test.returnBook();
    }
}
