package online.niuma.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private boolean success;
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(true, 200, "success", data);
    }

    public static <T> Result<T> fail(Integer code, String msg) {
        return new Result<>(false, code, msg, null);
    }
}
