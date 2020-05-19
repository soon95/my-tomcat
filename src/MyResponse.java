import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: Leon Song
 * @date: 2020/5/19
 */
public class MyResponse {

    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {

//        HTTP响应协议格式
//        HTTP/1.1 200 OK
//        Content-Type: application/json
//
//        content

        // 这里可能需要根据响应具体情况填充
        // 先不管这么多了
        String httpHead = "HTTP/1.1 200 OK";
        String contentType = "Content-Type: application/json";

        StringBuffer httpReponse = new StringBuffer();
        httpReponse.append(httpHead + "\n")
                .append(contentType + "\n")
                .append("\r\n")
                .append(content);

        outputStream.write(httpReponse.toString().getBytes());
        outputStream.close();
    }

}
