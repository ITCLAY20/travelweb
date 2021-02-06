package xyz.itclay.md5;

import org.junit.Test;
import xyz.itclay.travel.utils.Md5Utils;

public class MD5Test {
    @Test
    public void test01(){
        String password="123456";
        String md5 = Md5Utils.encodeByMd5(password);
        System.out.println(md5);
    }
}
