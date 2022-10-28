package online.niuma.blog.common;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public enum ErrorCode {

    /**
     * 错误代码
     */
    PARAMS_ERROR(10001, "参数错误"),
    USERNAME_PWD_NOT_EXIST(10002, "用户名或密码不存在"),
    COMMIT_ERROR(10003, "提交失败"),
    GET_ERROR(10004, "提交失败"),
    ;

    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
