package com.edu.main.redis;

import java.util.List;

/**
 * 
 * @description     redis工具类接口
 * @author          lujiawei
 * @data            2016年12月4日 下午2:09:25
 * @version         v1.0
 */
public interface IRedisUtils {

	/**
	 * 
	 * @description     将字符串放入到redis中
	 * @author          lujiawei
	 * @data            2016年12月4日 下午2:09:37
	 * @version         v1.0
	 * @param key
	 * @param value
	 */
	public void put(String key, String value);

	/**
	 * 
	 * @description     将对象放入到redis中
	 * @author          lujiawei
	 * @data            2016年12月4日 下午2:09:53
	 * @version         v1.0
	 * @param key
	 * @param value
	 */
    public void put(String key, Object value);
  
    /**
     * 
     * @description     获取对象
     * @author          lujiawei
     * @data            2016年12月4日 下午2:10:16
     * @version         v1.0
     * @param key
     * @param className
     * @return
     */
    public <T> T get(String key, Class<T> className);
  
    /**
     * 
     * @description     获取对象
     * @author          lujiawei
     * @data            2016年12月4日 下午2:10:26
     * @version         v1.0
     * @param key
     * @return
     */
    public String get(String key);
    
    /**
     * 
     * @Description  提交事务
     * @author       lujiawei
     * @date         2016年12月5日 上午10:27:51
     */
	public void exec();
    
}
