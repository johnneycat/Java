package javanettest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author wlw
 */


public class ServerThead extends Thread {
    
    Socket socket = null;

    
    ServerThead(Socket socket)
    {
        System.out.println("ServerThead");
        this.socket = socket;
    }
    
    public void run()
    {
        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStreamReader isr =new InputStreamReader(is);
        BufferedReader br;
        br = new BufferedReader(isr);
        String info =null;
        try {
            while((info=br.readLine())!=null)
            {
                System.out.println("我是服务器，客户端说：" + info);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.shutdownInput();
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
        OutputStream os = null;
        try {
            os = socket.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter pw = new PrintWriter(os);
        pw.write("欢迎您！");
        pw.flush();
        
        //close source
        pw.close();
        try {
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            isr.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
