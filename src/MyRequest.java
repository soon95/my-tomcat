import java.io.IOException;
import java.io.InputStream;

/**
 * @author: Leon Song
 * @date: 2020/5/19
 */
public class MyRequest {

    // 请求地址
    private String url;
    // 请求方法
    private String method;
    // HTTP请求版本
    private String version;

    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        // 每次读取1kb的数据
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            httpRequest = new String(httpRequestBytes, 0, length);
        }


//        Http请求协议格式
//        POST /hello HTTP/1.1
//        Accept: text/html, application/json, */*
//        Referer: http://localhost:8080/hello
//        Accept-language: zh-CN
//        Connection:Keep-Alive
//        Host:localhost
//        User-Agent:Mozila/4.0(compatible;MSIE5.01;Window NT5.0)
//        ....

        // 拿到报文头的前三项：POST /hello HTTP/1.1
        String httpHead = httpRequest.split("\n")[0];
        String[] temp = httpHead.split("\\s");
        method = temp[0];
        url = temp[1];
        version = temp[2];

        System.out.println(this);
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public String getVersion() {
        return version;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
