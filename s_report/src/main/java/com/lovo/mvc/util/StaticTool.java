package com.lovo.mvc.util;

public class StaticTool {
	
	public static final String IMGERROR="文件类型错误！！";
	public static final String EXEPTIONMSG="系统暂时无法访问请联系管理员或稍后再试";
	public static final String LOGMISERROR="请输入正确的用户名或密码!!";
	public static final String POWERERROR="你的权限不足！！！";
  /**
   * 设置上传文件类型
   * @return
   */
	public static String[] getImgType(){
	  String[] str=new String[3];
	  str[0]="image/jpeg";
	  str[1]="image2/jpeg";
	  str[2]="image3/jpeg";
	  return str;
	}
	/**
	 * 判断上传文件类型是否合法
	 * @param imgType
	 * @return 
	 */
	public static boolean blImg(String imgType){
		boolean bl=false;
		if(null==imgType||imgType.equals("")){
			return bl;
		}
	
		for(String t:StaticTool.getImgType()){
			if(t.equals(imgType)){
				bl=true;
				break; //如果类型存在，就结束循环返回true
			}
		}
		return bl;
	}
     /**
      * 返回图片后缀
      * @param imgType
      * @return
      */
	public static String getSuffixImg(String imgType){
		String imgSuffix="";
		switch (imgType) {
		case "image/jpeg":
			imgSuffix=".jpg";
			break;

		default:
			break;
		}
	 return imgSuffix;
	}

	
}
