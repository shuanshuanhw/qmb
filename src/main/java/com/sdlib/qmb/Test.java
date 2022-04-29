package com.sdlib.qmb;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.http.Header;
import cn.hutool.http.webservice.SoapClient;
import cn.hutool.http.webservice.SoapProtocol;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.client.RestClientException;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;

/**
 * 类名： Test
 * 描述 TODO：
 * 创建时间： 2022/4/29 9:58
 * 创建人： Administrator
 */

public class Test {

    public static void main(String[] args) {

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
}
