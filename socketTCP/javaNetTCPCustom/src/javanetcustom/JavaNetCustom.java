/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetcustom;

import java.io.IOException;
import java.net.*;
import java.io.*;

/**
 *
 * @author wlw
 */
public class JavaNetCustom {
    
    public static Fucker m;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        m = new Fucker();
        m.hello();
        
        Socket socket = new Socket("localhost", 10086);
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
        pw.write("用户名：admin；密码：123");
        pw.flush();
        socket.shutdownOutput();
        //3、获取输入流，并读取服务器端的响应信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while((info=br.readLine())!= null) {
            System.out.println("我是客户端，服务器说："+info);
        }
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }
    
}
