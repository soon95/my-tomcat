import java.io.IOException;

/**
 * @author: Leon Song
 * @date: 2020/5/19
 */
public class HealthCheckServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("health! use get");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("health! use post");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
