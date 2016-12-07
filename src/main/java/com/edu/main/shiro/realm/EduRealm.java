package com.edu.main.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 
 * @Description  自定义的shiro realm
 * @author       lujiawei
 * @date         2016年12月2日 上午11:12:23
 * @version      V1.0
 *
 */
public class EduRealm extends AuthorizingRealm {
	
	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("准备登录.....");
		
		String username = (String) token.getPrincipal();
		
		if(!"lujiawei".equals(username)){
			return null;
		}
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, "123", "eduRealm");
		
		return simpleAuthenticationInfo;
	}

	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		List<String> permissionList = new ArrayList<String>();
		permissionList.add("user:findAllUser");
		simpleAuthorizationInfo.addStringPermissions(permissionList);
		return simpleAuthorizationInfo;
	}

}
