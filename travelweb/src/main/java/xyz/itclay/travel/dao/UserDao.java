package xyz.itclay.travel.dao;

import xyz.itclay.travel.domain.User;

/**
 * @author ZhangSenmiao
 * @date 2021/2/6 12:43
 **/
public interface UserDao {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据手机号查询用户信息
     *
     * @param telephone 手机号
     * @return
     */
    User findByTelephone(String telephone);

    /**
     * 添加用户
     *
     * @param user user对象
     */
    void save(User user);
}
