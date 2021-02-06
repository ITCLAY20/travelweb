package xyz.itclay.travel.domain;

import lombok.Data;

/**
 * 封装注册返回的结果
 * 属性:是否成功、提示信息、封装数据
 *
 * @author ZhangSenmiao
 * @date 2021/2/6 12:19
 **/
@Data
public class ResultInfo {
    private Boolean success;
    private String message;
    private Object data;

    public ResultInfo() {
    }

    public ResultInfo(Boolean success) {
        this.success = success;
    }

    public ResultInfo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultInfo(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
