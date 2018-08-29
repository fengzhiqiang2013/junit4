package com.two.utils;

import com.two.bean.TUser;

/**
 * 
 * @author aran
 *
 */
public class OrganizationUtil {
	/**
     * 得到当前登录人的userID
     * @return
     */
    public static String getCurrUserId() {
    	//这里假如是获取的当前用户，如Artery的方法ArteryOrganUtil.getCurrUserInfo();
        TUser user = new TUser();
        return user == null ? null : user.getId();
    }
}
