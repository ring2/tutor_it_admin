package xyz.ring2.admin.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author :  weiquanquan
 * @date :   2020/2/3 12:56
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Accessors(chain = true)
public class RestResult<T> {
    private Integer statusCode;
    private String message;
    private T data;

    public RestResult(CommonStatus commonStatus, T data) {
        this.statusCode = commonStatus.getStatusCode();
        this.message = commonStatus.getMessage();
        this.data = data;
    }

    public RestResult(String message) {
        this.message = message;
    }

    public RestResult(CommonStatus commonStatus) {
        this.statusCode = commonStatus.getStatusCode();
        this.message = commonStatus.getMessage();
    }

    public static <T> RestResult success(T data) {
        return new RestResult<>(CommonStatus.SUCCESS, data);
    }

    public static <T> RestResult<T> success() {
        return new RestResult<>(CommonStatus.SUCCESS);
    }

    public static <T> RestResult<T> failureOfAuthority() {
        return new RestResult<>(CommonStatus.FAILED_AUTHORITY);
    }

    public static <T> RestResult<T> failureOfNotLogin() {
        return new RestResult<>(CommonStatus.FAILED_NOT_LOGIN);
    }

    public static <T> RestResult<T> failureOfQuery() {
        return new RestResult<>(CommonStatus.FAILURE);
    }

    public static <T> RestResult<T> failure() {
        return new RestResult<>(CommonStatus.FAILURE);
    }

    public static <T> RestResult<T> failure(String message) {
        return new RestResult<>(message);
    }

    public static <T> RestResult<T> failure(CommonStatus commonStatus) {
        return new RestResult<>(commonStatus);
    }

    public static <T> RestResult<T> failureOfParam() {
        return new RestResult<>(CommonStatus.FAILED_BAD_PARAM);
    }

    public static <T> RestResult<T> failureOfRepeatName() {
        return new RestResult<>(CommonStatus.REPEAT_NAME);
    }

    public static <T> RestResult<T> failureOfCaptcha() {
        return new RestResult<>(CommonStatus.FAILED_CAPTCHA);
    }

    public static <T> RestResult<T> failureOfPassword() {
        return new RestResult<>(CommonStatus.FAILED_PASSWORD);
    }

    public static <T> RestResult<T> failureOfUsername() {
        return new RestResult<>(CommonStatus.FAILED_FOUND_NAME);
    }

}
