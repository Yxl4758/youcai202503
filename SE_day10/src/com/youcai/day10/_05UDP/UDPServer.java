package com.youcai.day10._05UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

/**
 * 该类也可以理解为另外一个客户端
 * 步骤一：维护一个数据包，用于接受数据
 * 步骤二：维护一个该端的套接字socket
 * 步骤三：调用方法接受数据，存入准备好的数据包对象
 */
public class UDPServer {
    public static void main(String[] args) {
        try {
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            DatagramSocket socket = new DatagramSocket(9000);
            socket.receive(packet);
            //将数据包转成字符串
            String string = new String(packet.getData(), 0, packet.getLength());
            System.out.println(string);
            //发送数据
            DatagramPacket packet2 = new DatagramPacket(string.getBytes(), string.getBytes().length, packet.getAddress(), packet.getPort());
            DatagramSocket socket2 = new DatagramSocket();
            socket2.send(packet2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
