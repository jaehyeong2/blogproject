package jaefactory.community.service;


import jaefactory.community.domain.category.Category;
import jaefactory.community.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Transactional
    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategoryById(long id){
        categoryRepository.deleteById(id);
    }

}
