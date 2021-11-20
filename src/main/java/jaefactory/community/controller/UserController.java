package jaefactory.community.controller;

import jaefactory.community.config.auth.PrincipalDetails;
import jaefactory.community.domain.user.User;
import jaefactory.community.dto.SignUpDto;
import jaefactory.community.dto.UserProfileDto;
import jaefactory.community.handler.exception.CustomValidationException;
import jaefactory.community.service.BoardService;
import jaefactory.community.service.CategoryService;
import jaefactory.community.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final CategoryService categoryService;
    private final BoardService boardService;

    @GetMapping("/user/{id}")
    public String profile(@PathVariable long id){
        return "profile";
    }

    @GetMapping("/user/{id}/update")
    public String profileUpdate(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model){
        model.addAttribute("principal",principalDetails.getUser());
        return "profile";
    }
}



