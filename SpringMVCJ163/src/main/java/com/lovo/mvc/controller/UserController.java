package com.lovo.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lovo.mvc.entity.PowerEntity;
import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.entity.UserInfoEntity;
import com.lovo.mvc.service.IPowerService;
import com.lovo.mvc.service.IUserService;
import com.lovo.mvc.service.ImgPath;
import com.lovo.mvc.util.StaticTool;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;


	
	Logger log=Logger.getLogger(this.getClass());

    @RequestMapping("/savaUser.lovo")
  	public ModelAndView savaRedirect(String userName,String password,UserEntity user,HttpServletRequest rq){
      	userService.regist(userName, password);
  		ModelAndView mv=new ModelAndView();
  		//重定向视图
  		RedirectView rv=new RedirectView("findUserList.lovo");
  		mv.setView(rv);
     return mv;  
  	}
    @RequestMapping("/findUserList.lovo")
    public String findUserList(HttpServletRequest rq){
    	
    	List<UserEntity> listUser=new ArrayList<UserEntity>();
    	listUser=userService.getListUser();
    	//放入到request环境
    	rq.setAttribute("listUser",listUser);
    	return "show";
    }
   @RequestMapping("/delUserById.lovo")
   public  String delUserById(String userId) {
	   userService.delUserById(userId);
		return "show";
   }
   @RequestMapping("getUserInfoListByUserId.lovo")
   @ResponseBody
   public String findUserById(String id,HttpServletRequest request) {
	   UserEntity user = userService.findUserById(id);
	   HttpSession session = request.getSession();
	   session.setAttribute("user", user);
	  
 	     return "userInfo";  
   }
}
