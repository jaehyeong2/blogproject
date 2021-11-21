package jaefactory.community.controller;

import jaefactory.community.dto.BoardDto;
import jaefactory.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final BoardService boardService;

    @GetMapping("/admin")
    public String adminHome(){
        return "admin";
    }

//    @GetMapping("/admin/categories")
//    public String getCategories(Model model){
//        return "categories";
//    }
//
//    @GetMapping("/admin/categories/add")
//    public String categoriesAdd(Model model){
//        model.addAttribute("category", new Category());
//        return "categoriesAdd";
//    }
//
//    @PostMapping("/admin/categories/add")
//    public String categoriesPost(@ModelAttribute("category") Category category){
//        categoryService.addCategory(category);
//        return "redirect:/admin/categories";
//    }
//
//    @GetMapping("/admin/categories/delete/{id}")
//    public String categoriesDelete(@PathVariable long id){
//        categoryService.deleteCategoryById(id);
//        return "redirect:/admin/categories";
//    }
//
//    @GetMapping("/admin/categories/update/{id}")
//    public String categoriesUpdate(@PathVariable long id, Model model){
//        Category category =categoryService.getCategoryById(id);
//        model.addAttribute("category",category);
//        return "categoriesAdd";
//    }

    @GetMapping("/admin/boards")
    public String boards(Model model){
        model.addAttribute("boards",boardService.getAllBoards());
        return "boards";
    }

    @GetMapping("/admin/boards/add")
    public String boardAddGet(Model model){
        model.addAttribute("boardDto",new BoardDto());
//        model.addAttribute("categories",categoryService.getAllCategories());
        return "boardSave";
    }

}
