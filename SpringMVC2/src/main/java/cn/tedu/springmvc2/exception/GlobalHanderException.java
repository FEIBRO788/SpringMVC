package cn.tedu.springmvc2.exception;

import cn.tedu.springmvc2.responce.JsonResult;
import cn.tedu.springmvc2.responce.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalHanderException {
    @ExceptionHandler(IllegalArgumentException.class)
    public JsonResult doHandleIllegalArgumentException(IllegalArgumentException e){
        log.warn("IllegalArgumentException msg is:",e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED,e.getMessage());
    }
    @ExceptionHandler({RuntimeException.class})
    public JsonResult doHeaderRuntimeException(RuntimeException e){
        log.warn("RuntimeException msg:",e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED,e.getMessage());

    }
    @ExceptionHandler(Throwable.class)
    public JsonResult handleThrowable(Throwable e) {
        return new JsonResult(StatusCode.OPERATION_FAILED, "程序运行过程中出现了Throwable");
    }

}
