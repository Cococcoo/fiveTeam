package com.lovo.mvc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileUtils 
{
	/**
	 * 通过路径名得到所有文件
	 * @param path 路径名
	 * @return 文件
	 */
	public static List<File> getAllFilesByPath(String path)
	{
		List<File> list = new ArrayList<>();
		LinkedList<File> linkedList = new LinkedList<>();
		
		File file = new File(path);
		File[] files = file.listFiles();
		
		if (EmptyUtils.isNotEmpty(files))
		{
			for (File eachFile : files)
			{
				if (eachFile.isDirectory())
				{
					linkedList.add(eachFile);
				}
				list.add(eachFile);
			}
		}
		
		//非递归遍历所有目录
		while (!linkedList.isEmpty())
		{
			File removedFile = linkedList.removeFirst();
			if (removedFile.isDirectory())
			{
				File[] removedFiles = removedFile.listFiles();
				if (EmptyUtils.isNotEmpty(removedFiles))
				{
					for (File eachFile :removedFiles)
					{
						if (eachFile.isDirectory())
						{
							linkedList.add(eachFile);
						}
						list.add(eachFile);
					}
				}
			}
		}
		
		return list;
	}
	
	/**
	 * 通过包名得到所有文件
	 * @param packageName 包名
	 * @return 文件
	 */
	public static List<File> getAllFilesByPackage(String packageName)
	{
		return getAllFilesByPath(transPackage2Path(packageName));
	}
	
	/**
	 * 转换包名到路径名
	 * @param packageName 包名
	 * @return
	 */
	public static String transPackage2Path(String packageName)
	{
		//replace代替全部,基于普通字符串
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        //加载包下的所有资源
        URL url = loader.getResource(packagePath);

        //url.getPath()得到形如 /C:/.../target的形式
        String targetPath = url.getPath().trim().substring(1);
       
        //replaceAll基于参数regex表达式
        return targetPath.replace("target/classes", "src/main/java");
	}
	
	/**
	 * 将路径转换为包名
	 * @param path 路径名
	 * @return
	 */
	public static String transPath2Package(String path)
	{
		return path.split("src\\\\main\\\\java\\\\")[1].replace("\\", ".").split("\\.java")[0];
	}
	
	/**
	 * 导出excel工具类
	 * @param fileDir 目录
	 * @param fileName 文件名称
	 */
	public static FileOutputStream fileOutputStream(String fileDir, String fileName)
	{
		FileOutputStream fos = null;	
		File dir = new File(fileDir);
		
		if (!dir.isDirectory())
		{
			dir.mkdir();
		}
		
		File xls = new File(fileDir + fileName);
		
		if (xls.isFile() && xls.exists())
		{
			xls.delete();
		}
		
		try 
		{
			//创建文件流
			fos = new FileOutputStream(fileDir + fileName);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return fos;
	}
}
