package com.lovo.mvc.util;

import java.util.Collection;
import java.util.Map;

/**
 * 判断空值类
 * @author reborn
 *
 */
public class EmptyUtils
{
	/**
	 * 判断对象是否为空
	 * @param obj 对象
	 * @return 布尔值
	 */
	public static boolean isEmpty(Object obj)
	{
		if (null == obj)
		{
			return true;
		}
		else if (obj instanceof Collection<?> && ((Collection<?>)obj).size() == 0)
		{
			return true;
		}
		else if (obj instanceof Map<?,?> && ((Map<?,?>) obj).size() == 0)
		{
			return true;
		}
		else if (obj instanceof String && ((String) obj).trim().length() == 0)
		{
			return true;
		}
		else if (obj instanceof Object [] && ((Object [])obj).length == 0)
		{
			return true;
		}
		else if (obj instanceof int[] && ((int[])obj).length == 0)
		{
			return true;
		}
		else if (obj instanceof char[] && ((char[])obj).length == 0)
		{
			return true;
		}
		else if (obj instanceof boolean[] && ((boolean[])obj).length == 0)
		{
			return true;
		}
		else if (obj instanceof short[] && ((short[])obj).length == 0)
		{
			return true;
		}
		else if (obj instanceof double[] && ((double[])obj).length == 0)
		{
			return true;
		}
		else if (obj instanceof float[] && ((float[])obj).length == 0)
		{
			return true;
		}
		else if (obj instanceof long[] && ((long[])obj).length == 0)
		{
			return true;
		}
		else if (obj instanceof byte[] && ((byte[])obj).length == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 判断对象是否非空
	 * @param obj 对象
	 * @return 布尔值
	 */
	public static boolean isNotEmpty(Object obj)
	{
		return !isEmpty(obj);
	}
	
}
