/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaudpcustom;

import java.io.IOException;
import java.util.*;
import java.net.*;

/**
 *
 * @author wlw
 */
public class JavaUDPCustom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        // TODO code application logic here
        InetAddress address =InetAddress.getByName("localhost");
        int port =10010;
        byte[] data ="用户名：admin;密码：123".getBytes();
        
        //todo
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        //3、创建DatagramSocket对象
        DatagramSocket socket =new DatagramSocket();
        //4、向服务器发送数据
        socket.send(packet);
        
        //接受服务器端响应数据
        //1、创建数据报，用于接受服务器端响应数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
        //2、接受服务器响应的数据
        socket.receive(packet2);
        String reply = new String(data2,0,packet2.getLength());
        System.out.println("我是客户端，服务器说："+reply);
        //4、关闭资源
        socket.close();
    }
    
}
