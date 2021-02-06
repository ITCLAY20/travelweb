package xyz.itclay.travel.service;

import org.apache.ibatis.session.SqlSession;
import xyz.itclay.travel.dao.UserDao;
import xyz.itclay.travel.domain.ResultInfo;
import xyz.itclay.travel.domain.User;
import xyz.itclay.travel.utils.Md5Utils;
import xyz.itclay.travel.utils.MyBatisUtils;

/**
 * @author ZhangSenmiao
 * @date 2021/2/6 13:02
 **/
public class UserService {
    /**
     * 注册
     *
     * @param user 封装用户信息
     * @return 封装了注册结果的信息
     */
    public ResultInfo register(User user) {
//        创建接口代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        调用dao查询，验证用户名
        User byUsername = userDao.findByUsername(user.getUsername());
        if (byUsername != null) {
//            释放资源
            MyBatisUtils.close(sqlSession);
//            如果byUsername不是null，表示该用户已经是存在的
            return new ResultInfo(false, "用户名已存在！");
        }
//        调用dao查询，验证手机号
        User byTelephone = userDao.findByTelephone(user.getPassword());
        if (byTelephone != null) {
//            释放资源
            MyBatisUtils.close(sqlSession);
//            如果byTelePhone不是null，表示手机号已经存在，有绑定的用户
            return new ResultInfo(false, "手机号已存在！");
        }

//        使用MD5对密码进行加密
        String password = Md5Utils.encodeByMd5(user.getPassword());
//        将user对象中的密码设置成加密后的
        user.setPassword(password);
//        调用dao保存user对象,完成注册
        userDao.save(user);
//        释放资源
        MyBatisUtils.close(sqlSession);
//        返回ResultInfo,封住注册结果
        return new ResultInfo(true);

    }
}
