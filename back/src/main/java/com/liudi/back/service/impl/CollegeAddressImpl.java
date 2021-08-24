package com.liudi.back.service.impl;

import com.alibaba.fastjson.JSON;
import com.liudi.back.entity.BaiduMapAddressBean;
import com.liudi.back.entity.BaiduMapLngLatBean;
import com.liudi.back.entity.Location;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class CollegeAddressImpl {

    final static String AK = "BeqejGylWPRCWzMXA0apoq9I24RDauzK";

    /**
     * 地理编码 URL
     */
    final static String ADDRESS_TO_LONGITUDEA_URL = "http://api.map.baidu.com/geocoding/v3/?output=json&location=showLocation";

    /**
     * 逆地理编码 URL
     */
    final static String LONGITUDE_TO_ADDRESS_URL = "http://api.map.baidu.com/reverse_geocoding/v3/?output=json&coordtype=BD09&pois=1";


    /**
     * 通过百度地图 api 获取各高校地址
     */
    public void getCollegeAddress() {

    }

    public static void main(String[] args) {
        BaiduMapLngLatBean locationBean = addressTolongitudea("济宁师范专科学校");
//        Object result = map.get("result");
        System.out.println("======= " + JSON.toJSONString(locationBean));
        Location location = locationBean.getLocation();


        BaiduMapAddressBean baiduMapAddressBean = longitudeToAddress(locationBean.getLocation().getLat(), locationBean.getLocation().getLng());
        System.out.println("======= " + JSON.toJSONString(baiduMapAddressBean));
    }


    /**
     * 获取经纬度
     *
     * @param address 详细的位置信息
     * @return 经纬度
     */
    public static BaiduMapLngLatBean addressTolongitudea(String address) {
        if (StringUtils.isBlank(address)) {
            return null;
        }
        String url = ADDRESS_TO_LONGITUDEA_URL + "&ak=" + AK + "&address=" + address;
        log.info("请求url:" + url);
        HttpClient client = HttpClients.createDefault(); // 创建默认http连接
        HttpPost post = new HttpPost(url);// 创建一个post请求
        try {
            HttpResponse response = client.execute(post);// 用http连接去执行get请求并且获得http响应
            HttpEntity entity = response.getEntity();// 从response中取到响实体
            String html = EntityUtils.toString(entity);// 把响应实体转成文本
            log.info("返回信息：" + html);
            // JSON转对象
            Map map = JSON.parseObject(html, Map.class);
            return JSON.parseObject(map.get("result").toString(), BaiduMapLngLatBean.class);
        } catch (Exception e) {
            log.error("地理编码[异常],", e);
            return null;
        }
    }


    /**
     * 逆地理编码
     *
     * @param lat 纬度
     * @param lng 经度
     * @return
     */
    public static BaiduMapAddressBean longitudeToAddress(String lat, String lng) {
        String url = LONGITUDE_TO_ADDRESS_URL + "&ak=" + AK + "&location=" + lat + "," + lng;
        log.info("请求url:" + url);
        HttpClient client = HttpClients.createDefault(); // 创建默认http连接
        HttpPost post = new HttpPost(url);// 创建一个post请求
        try {
            HttpResponse response = client.execute(post);// 用http连接去执行get请求并且获得http响应
            HttpEntity entity = response.getEntity();// 从response中取到响实体
            String html = EntityUtils.toString(entity);// 把响应实体转成文本
            log.info("返回信息：" + html);
            // JSON转对象
            Map map = JSON.parseObject(html, Map.class);
            String result = map.get("result").toString();
//            Map resultMap = JSON.parseObject(result, Map.class);
//            resultMap.get("")

            return JSON.parseObject(result, BaiduMapAddressBean.class);
        } catch (Exception e) {
            log.error("逆地理编码[异常],", e);
            return null;
        }
    }

}
