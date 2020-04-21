package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class CustomConfig {

    @Autowired
    private NodeMap nodeMap;

    private Map<String,String> ipDomainMap;

    @PostConstruct
    public void initCustom(){
        System.out.println(nodeMap.getNode());
        Map<String,String> nodesMap = nodeMap.getNode();
        List<String> nodeList = new ArrayList<>();
//        nodeList = nodesMap.values().stream().map(m -> m.split(",")).forEach();


        for (Map.Entry<String,String> e :nodesMap.entrySet()) {
            String key = e.getKey();
            String value = e.getValue();
            String[] node = value.split(",");
            nodeList.addAll(Arrays.asList(node));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("redis//");
        for (String s:nodeList) {
            sb.append(s);
        }
        sb.append("/0");

        String uri = sb.toString();



        for (String s: nodeList) {
            System.out.println(s);
        }
        System.out.println(uri);

        getIPByName("www.qq.com");





    }



    //根据域名获得主机的IP地址
    public  void getIPByName(String hostName){
        try {
            InetAddress addr=InetAddress.getByName(hostName);//根据域名创建主机地址对象
            String hostAddr=addr.getHostAddress();//获取主机IP地址
            System.out.println("域名为："+hostName+"的主机IP地址："+hostAddr);
            System.out.println("域名为："+hostName+"的主机IP地址："+hostAddr);
        } catch (UnknownHostException e) {
            System.out.println("不能根据域名获得主机IP地址：" + e.getMessage());
            System.out.println("不能根据域名获得主机IP地址：" + e.getMessage());
            System.exit(1);
        }
    }

    public  void getAllIPByName(String hostName){
        try {
            InetAddress[] addrs=InetAddress.getAllByName(hostName);//根据域名创建主机地址对象
            String[] ips=new String[addrs.length];

            System.out.println("域名为："+hostName+"的所有的主机IP地址：");
            System.out.println("域名为："+hostName+"的所有的主机IP地址：");
            for (int i = 0; i < addrs.length; i++) {
                ips[i]=addrs[i].getHostAddress();//获取主机IP地址
                System.out.println(ips[i]);
                System.out.println(ips[i]);
            }
        } catch (UnknownHostException e) {
            System.out.println("不能根据域名获得 主机所有IP地址：" + e.getMessage());
            System.exit(1);
            System.out.println(("不能根据域名获得 主机所有IP地址：" + e.getMessage()));
        }

    }

}
