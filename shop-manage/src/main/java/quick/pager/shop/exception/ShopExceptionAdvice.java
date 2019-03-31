package quick.pager.shop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;

/**
 * 统一异常处理机制
 *
 * @author siguiyang
 */
@RestControllerAdvice
@Slf4j
public class ShopExceptionAdvice {

    @ExceptionHandler
    public Object doException(Exception e) {
        log.error("统一异常处理机制，触发异常 msg = {}", e.getMessage());
        if (e instanceof ShopException) {
            ShopException exception = (ShopException) e;
            return new Response<>(exception.getCode(), exception.getMessage());
        } else if (e instanceof AccessDeniedException) {
            return new Response<>(ResponseStatus.Code.NO_PERMISSION, ResponseStatus.NO_PERMISSION);
        }
        return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
    }
}
