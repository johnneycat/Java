/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanettest;
import java.net.*;
import java.io.*;

/**
 *
 * @author wlw
 */
public class JavaNetTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        HelloWorld m = new HelloWorld();
        ServerSocket serverSocket =new ServerSocket(10086);
        
        while(true)
        {
            Socket socket = serverSocket.accept();
            ServerThead serverThread =new ServerThead(socket);
            serverThread.start();
        }

/*
        InputStream is = socket.getInputStream();
        InputStreamReader isr =new InputStreamReader(is);
        BufferedReader br =new BufferedReader(isr);
        String info =null;
        while((info=br.readLine())!=null)
        {
            System.out.println("我是服务器，客户端说：" + info);
        }
        socket.shutdownInput();
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("欢迎您！");
        pw.flush();
        
        //close source
        pw.close();
        os.close();
        br.close();
        isr.close();
        is.close();
        socket.close();
        serverSocket.close();
*/
    }
    
}
