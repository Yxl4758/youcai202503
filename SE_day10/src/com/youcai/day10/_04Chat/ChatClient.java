package com.youcai.day10._04Chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    //维护一个客户端的套接字属性
    private Socket clientSocket;
    public ChatClient() {
        try {
            //第一个参数为要连接的服务器的ip
            //第二个参数为服务器的端口号
            //本机ip代词：127.0.0.1  localhost   0.0.0.0
            //该构造器会向服务器发送请求
            clientSocket =new Socket("127.0.0.1",10086);
        } catch (IOException e) {
            System.out.println("连接失败，该端口被占用");
        }
    }
    private void start() {
        try {
            Runnable rb = new ServerInfoHamder();
            new Thread(rb).start();
            OutputStream out = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(
                    new OutputStreamWriter(out,"utf-8"),true);
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("请输入要发送的内容。。。");
                String msg = in.nextLine();
                pw.println(msg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.start();
    }
    class ServerInfoHamder implements Runnable {

        @Override
        public void run() {
            //通过socket获取输出流对象，将数据发送给对应的客户端
            try {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String msg = null;
                while ((br.readLine()) != null) {
                    msg = br.readLine();
                    System.out.println(msg);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
