package jaefactory.community.handler;

import jaefactory.community.dto.CommonResDto;
import jaefactory.community.handler.exception.CustomValidationException;
import jaefactory.community.util.Script;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {

        return Script.back(e.getErrorMap().toString());
//        return new CommonResDto<Map<String,String>>(-1,e.getMessage(),e.getErrorMap()); // 에러 상황 => statusCode -1
    }
}
