package ssh.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Author
 * @Date
 */
public class HelloWorldAction extends ActionSupport {

    private static final long serialVersionUID = 6376321702451566673L;
    private String name;

    public String execute() {
        if ("SECRET".equals(name)) {
            return SUCCESS;
        } else return ERROR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
