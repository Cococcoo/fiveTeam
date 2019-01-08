package com.lovo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lovo.mvc.entity.PowerEntity;
import com.lovo.mvc.entity.RoleEntity;
import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.service.IPowerService;
import com.lovo.mvc.service.IRoleService;
import com.lovo.mvc.service.IUserService;

@Controller
public class RoleController {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserService userService ;
	@Autowired
	private IPowerService powerService;
	/**
	 * 查询所有角色
	 * @return
	 */
	@RequestMapping("findListRole.lovo")
	public ModelAndView findListRole(){
		ModelAndView mv=new ModelAndView("role");
		//获得角色集合
		List<RoleEntity> listRole=roleService.getListRole();
		//把结果放入模型
		mv.addObject("listRole", listRole);
		return mv;
	}
	@RequestMapping("gotoRoleUser.lovo")
	public ModelAndView gotoRoleUser(String roleName,String roleId){
		ModelAndView mv=new ModelAndView("roleUser");
		//根据角色ID查询出该角色拥有的所有用户
	List<UserEntity> listRoleUser=	userService.getListUserByRoleId(roleId);
		//获取所有的用户集合
	List<UserEntity> listAll=	userService.getListUser();
		//获取没有被选中的用户集合
	List unRoleUser=userService.getUNListUserByRole(listAll, listRoleUser);
	 //把角色名、拥有的和不拥有的用户集合字放入模型	
		mv.addObject("roleName", roleName);
		mv.addObject("listRoleUser", listRoleUser);
		mv.addObject("unRoleUser", unRoleUser);
		mv.addObject("roleId",roleId);
		return mv;
	}
	/**
	 * 跳转到权限维护
	 * @param roleName
	 * @param roleId
	 * @return
	 */
	@RequestMapping("gotoRolePower.lovo")
	public ModelAndView gotoRolePower(String roleName,String roleId){
		ModelAndView mv=new ModelAndView("rolePower");
		//根据角色ID查询出该角色拥有的所有权限
		List<PowerEntity> rolePowerList=	powerService.getListPowerByRoleId(roleId);
		//获取所有的权限集合
		List<PowerEntity> powerList=powerService.getListPower();
		//获取没有被选中的权限集合
		List<PowerEntity> unRolePowerList=powerService.getUNListPowerByRoleId(powerList, rolePowerList);
	 //把角色拥有的和不拥有的权限集合放入模型	
		mv.addObject("rolePowerList", rolePowerList);
		mv.addObject("unRolePowerList", unRolePowerList);
		mv.addObject("roleName", roleName);
		mv.addObject("roleId", roleId);
		return mv;
	}
	
	@RequestMapping("updateRoleUser.lovo")
	public ModelAndView updateRoleUser(String roleName,String roleId,String userListId){
		ModelAndView mv=new ModelAndView("roleUser");
		//根据角色ID查询出该角色拥有的所有用户
		List<UserEntity> roleListUser=	userService.getListUserByRoleId(roleId);
		//修改角色用户
		roleService.updateRoleUser(roleListUser, userListId, roleId);
		
		//根据角色ID查询出该角色拥有的所有用户
				List<UserEntity> listRoleUser=	userService.getListUserByRoleId(roleId);	
		//获取所有的用户集合
	List<UserEntity> listAll=	userService.getListUser();
		//获取没有被选中的用户集合
	List unRoleUser=userService.getUNListUserByRole(listAll, listRoleUser);
	 //把角色名、拥有的和不拥有的用户集合字放入模型	
		mv.addObject("roleName", roleName);
		mv.addObject("listRoleUser", listRoleUser);
		mv.addObject("unRoleUser", unRoleUser);
		mv.addObject("roleId",roleId);
		return mv;
	}
	
	@RequestMapping("updateRolePower")
	public ModelAndView  updateRolePower
	           (String roleName,String roleId,String addName,String delName){
		ModelAndView mv=new ModelAndView("roleUser");

		//修改角色权限
		powerService.updateRolePower(roleId, delName, addName);
		//重定向到查询controller
//		String param="roleName="+roleName+"&roleId="+roleId;	
//		RedirectView rv=new RedirectView("gotoRolePower.lovo?"+param);
//		mv.setView(rv);
		
		//根据角色ID查询出该角色拥有的所有权限
		List<PowerEntity> rolePowerList=	powerService.getListPowerByRoleId(roleId);
		//获取所有的权限集合
		List<PowerEntity> powerList=powerService.getListPower();
		//获取没有被选中的权限集合
		List<PowerEntity> unRolePowerList=powerService.getUNListPowerByRoleId(powerList, rolePowerList);
	 //把角色拥有的和不拥有的权限集合放入模型	
		mv.addObject("rolePowerList", rolePowerList);
		mv.addObject("unRolePowerList", unRolePowerList);
		mv.addObject("roleName", roleName);
		mv.addObject("roleId", roleId);
		return mv;
	}
}
