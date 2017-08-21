/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaudpserver;

import java.io.IOException;
import java.net.*;
import java.util.*;



/**
 *
 * @author wlw
 */
public class JavaUDPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
        
        DatagramSocket socket =new DatagramSocket(10010);
        byte[] data =new byte[1024];//
        
        
        DatagramPacket packet =new DatagramPacket(data,data.length);
        socket.receive(packet);//此方法在接受数据报之前会一直阻塞
        //读取数据
        String info =new String(data,0,data.length);
        System.out.println("我是服务器，客户端告诉我"+info);
        
        //向客户端响应数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();        
        byte[] data2 = "欢迎您！".getBytes();
        //2、创建数据报，包含响应的数据信息
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
        socket.send(packet2);
        socket.close();
    }
    
}
