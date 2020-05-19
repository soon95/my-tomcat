/**
 * @author: Leon Song
 * @date: 2020/5/19
 */
public class ServletMapping {

    private String servletName;
    private String url;
    private String clazz;

    public ServletMapping(String servletName, String url, String clazz) {
        this.servletName = servletName;
        this.url = url;
        this.clazz = clazz;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getServletName() {
        return servletName;
    }

    public String getUrl() {
        return url;
    }

    public String getClazz() {
        return clazz;
    }
}
