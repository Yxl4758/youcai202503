package com.youcai.day10._04Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ChatServer {
    //维护一个服务端的套接字
    private ServerSocket serverSocket;
    //创建一个Map集合用来存储每个socket的输出流对象。
    //PrintWrtiter作为value、服务端获取的客户端的第一句话，应该是用户名可以作为key
    private Map<String,PrintWriter> socketMap;
    public ChatServer() {
        try {
            serverSocket = new ServerSocket(10086);
            socketMap =new HashMap<>();
        } catch (IOException e) {
            System.out.println("服务器启动失败，端口被占用！！");
        }
    }
    private void start() {
        try {
            while (true) {
                System.out.println("---正在等待客户端的连接---");
                //调用accept方法，等待客户端连接
                Socket clientSocket = serverSocket.accept();  //有阻塞效果，如果没有客户端连接，则阻塞在这里
                System.out.println("---一个客户端连接了---");
                //创建线程对象，来处理该客户端的信息
                Runnable r = new ClientInfoHandler(clientSocket);
                Thread t = new Thread(r);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }
    //创建该类是用来处理客户端发送过来的数据的
    class ClientInfoHandler implements Runnable {
        private Socket clientSocket;
        public ClientInfoHandler(Socket socket) {
            this.clientSocket = socket;
        }
        public void run() {
            String userName = null;
            try {
                //使用socket获取输入流对象，读取客户端发送的数据
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));
                //通过socket获取输出流对象，将数据发送给对应的客户端
                PrintWriter pw = new PrintWriter(
                        new OutputStreamWriter(
                                clientSocket.getOutputStream(),"UTF-8"),true);

                //获取的收到的第一句话，应该就是用户名，作为key
                userName = br.readLine();
                socketMap.put(userName,pw);
                String line = null;
                //  IO流的特点： 是阻塞IO,如果没有数据，则阻塞在这里，等待下一次数据，而不是死掉。
                while ((line = br.readLine()) != null) {
//                    System.out.println(line);
//                    //将客户端发送过来的信息，再发回去。
//                    pw.println(line);
                    //判断是否为群聊还是私聊
                    if(groupChat(line)){
                        sendGroupMessage(line);
                    }else {
                        sendPrivateMessage(line,userName);
                    }
                }
            } catch (Exception e) {
                System.out.println("客户端断开连接");
                //还要删除对应的socket对象
                socketMap.remove(userName);
            }
        }

        /**
         * 私聊方法
         *
         * @param line
         * @param name
         */
        private void sendPrivateMessage(String line, String name) {
            //解析出用户名
            CharSequence userName = line.substring(1,line.indexOf(':'));
            PrintWriter pw = socketMap.get(userName);
            pw.println(name + "私聊我说" + line.substring(line.indexOf(':') + 1));
            pw.flush();
        }

        /**
         * 群聊：不是以@开始的文字
         * 私聊：以@开头的文字
         * @return
         */
        private boolean groupChat(String Line) {
            return !Line.startsWith("@");
        }

        /**
         * 群聊方法：遍历集合将拿到的所有输出流，发送给客户端
         * @param line
         */
        private void sendGroupMessage(String line) {
            Set<String> keys = socketMap.keySet();
            for (String key : keys) {
                PrintWriter pw = socketMap.get(key);
                pw.println(line);
                pw.flush();
            }
        }
    }
}
