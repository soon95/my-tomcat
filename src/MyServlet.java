/**
 * @author: Leon Song
 * @date: 2020/5/19
 */
public abstract class MyServlet {

    public abstract void doGet(MyRequest myRequest, MyResponse myResponse);

    public abstract void doPost(MyRequest myRequest, MyResponse myResponse);

    public void service(MyRequest myRequest, MyResponse myResponse) {

        String requestMethod = myRequest.getMethod();

        if (requestMethod.equalsIgnoreCase("POST")) {
            doPost(myRequest, myResponse);
        } else if (requestMethod.equalsIgnoreCase("GET")) {
            doGet(myRequest, myResponse);
        }

    }
}
