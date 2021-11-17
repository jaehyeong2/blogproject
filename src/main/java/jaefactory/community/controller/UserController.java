package jaefactory.community.controller;

import jaefactory.community.domain.user.User;
import jaefactory.community.dto.SignUpDto;
import jaefactory.community.handler.exception.CustomValidationException;
import jaefactory.community.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/signup")
    public String signUpForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid SignUpDto signUpDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error:bindingResult.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패",errorMap);
        }else {
            User user = signUpDto.toEntity();
            User userEntity = userService.join(user);
            return "signin";
        }
    }

        @GetMapping("/signin")
        public String signInForm() {
            return "signin";
        }
    }

