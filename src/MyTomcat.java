import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Leon Song
 * @date: 2020/5/19
 */
public class MyTomcat {

    // 默认端口号
    private int port = 8080;

    private Map<String, String> urlServletMap = new HashMap<>();

    public MyTomcat() {
    }

    public MyTomcat(int port) {
        this.port = port;
    }

    private void initServletMapping() {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappings) {
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    /**
     * 请求分发方法
     *
     * @param myRequest
     * @param myResponse
     */
    private void dispatch(MyRequest myRequest, MyResponse myResponse) {
        // 根据url找到实际处理的类
        String clazz = urlServletMap.get(myRequest.getUrl());

        try {
            // 通过反射创建对应类
            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();

            // 处理请求
            myServlet.service(myRequest, myResponse);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        // 初始化
        initServletMapping();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("******my tomcat startup******");

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                dispatch(myRequest, myResponse);

                socket.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new MyTomcat().start();
    }

}



