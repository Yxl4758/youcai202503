package com.youcai.day10._03Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 1、获取本机
            InetAddress address1 = InetAddress.getLocalHost();
            // 2、通过主机名字，获取一个主机
            InetAddress address2 = InetAddress.getByName("懿范");
            // 3、通过IP地址字节数组，获取一个主机（需要注意字节数组中的每一个元素是否溢出）
            InetAddress address3 = InetAddress.getByAddress(new byte[] {10, 0, (byte)153, 27});
            // 4、通过IP地址字符串获取一个主机
            InetAddress address4 = InetAddress.getByName("10.0.153.27");
            // 5、通过域名获取主机
            InetAddress address5 = InetAddress.getByName("www.taobao.com");
            // 6、获取一个域名对应的所有的主机
//            InetAddress[] addresses = InetAddress.getAllByName("www.taobao.com");
//            for (InetAddress address : addresses) {
//                System.out.println(address);
//            }
//
//
//            // 通过  InetAddress 对象 // 1、获取主机名字
//            System.out.println(address1.getHostName());
//            // 2、获取主机地址
//            System.out.println(address1.getHostAddress());
//            // 3、获取一个IP地址字节数组
//            byte[] addr = address1.getAddress();
//            for (byte b : addr) {
//                System.out.print(b);
//                System.out.print(" ");
//            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
