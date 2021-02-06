package xyz.itclay.travel.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author ZhangSenmiao
 * @date 2021/2/6 12:17
 **/
@Data
public class User implements Serializable {
    private int uid;
    private String username;
    private String password;
    private String telephone;
    private String nickname;
    private String sex;
    private String birthday;
    private String email;
    private String pic;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
