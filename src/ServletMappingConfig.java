import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon Song
 * @date: 2020/5/19
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappings = new ArrayList<>();


    // 真实场景中通常通过xml或者注解进行配置
    static {
        servletMappings.add(new ServletMapping("helloWorld", "/hello", "HelloWorldServlet"));
        servletMappings.add(new ServletMapping("healthCheck", "/health", "HealthCheckServlet"));
        servletMappings.add(new ServletMapping("favicon", "/favicon.ico", "FaviconServlet"));
    }
}
