package online.mmdwz.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import online.mmdwz.entity.User;
import online.mmdwz.service.UserService;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Namespace("/user")
@ParentPackage("json-default")  
@Results( { @Result(name = "error", location = "/Error.html") })  
public class UserAction extends ActionSupport {
	//implements ModelDriven<User>, Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2472674320287527836L;

	private static final Logger LOGGER = Logger.getLogger(UserAction.class);
	private int id;
	private User user;
	private List<User> users;
	private String result;
	@Autowired
	private UserService userService;

/*	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public User getModel() {
		// TODO Auto-generated method stub
		if (null != id) {
			user = userService.get(id);
		} else {
			user = new User();
		}
		return user;
	}*/
	
	public List<User> getUsers() {
		return users;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Action(value = "user",results={@Result(type="json", params={"excludeNullProperties","true"})})
	public String execute() throws Exception {
		LOGGER.info("查询所有用户");
		users = userService.findAll();
		result = "ture";
		return SUCCESS;
		
	}
	
	@Action(value = "list",results={@Result(type="json", params={"root","users"})})
	public String list() throws Exception {
		LOGGER.info("查询所有用户");
		users = userService.findAll();
		result = "ture";
		return SUCCESS;
		
	}
	
	@Action(value = "detail", results={@Result(type="json", params={"root","user"})})
	public String detail() {
		LOGGER.info("查看用户详情：" + id);
		user = userService.get(id);
		result = "ture";
		System.out.println(JSON.toJSONString(user));
		return SUCCESS;
	}
	
	@Action(value = "delete", results={@Result(type="json", params={"root","user"}),
									   @Result(name = "fail", location = "/Success.html")})
	public String delete() {
		LOGGER.info("删除用户：" + id);
		//userService.delete(id);
		//result = "ture";
		return "fail";
	}

}
