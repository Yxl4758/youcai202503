package com.youcai.day10._05UDP;

import java.net.*;

/**
 * 步骤一: 维护要发送的数据包
 * 步骤二：维护一个客户端套接字，IP和host都不需要指定，系统会自动分配
 * 步骤三：发送数据包
 */
public class UDPClient {
    public static void main(String[] args) {
        try {
            byte[] bytes = "hello world".getBytes();
            /**
             * 参数1：要发送的数据的字节序列
             * 参数2：实际发送的字节长度
             * 参数3：目标IP
             * 参数4：目标端口
             */
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9000);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);

            byte[] bytes1 = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length);
            socket.receive(packet1);
            String string = new String(packet1.getData(), 0, packet1.getLength());
            System.out.println(string);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
