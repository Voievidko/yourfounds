package com.notspend.service.impl;

import com.notspend.dao.CategoryDao;
import com.notspend.entity.Category;
import com.notspend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDAO;

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryDAO.save(category);
    }

    @Override
    @Transactional
    public List<Category> getAllExpenseCategories() {
        return categoryDAO.getAll();
    }

    @Override
    @Transactional
    public List<Category> getAllIncomeCategories() {
        return categoryDAO.getAllIncome();
    }

    @Override
    @Transactional
    public Optional<Category> getCategory(int id) {
        return categoryDAO.get(id);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        categoryDAO.delete(id);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryDAO.update(category);
    }

    @Override
    @Transactional
    public boolean isCategoryNameExist(Category category) {
        return categoryDAO.isCategoryNameExist(category);
    }

    @Override
    @Transactional
    public boolean isCategoryHaveRelations(int id) {
        return categoryDAO.isCategoryHaveRelations(id);
    }

    @Override
    @Transactional
    public int replaceCategoryInAllExpenses(int fromCategoryId, int toCategoryId) {
        int numberOfReplace = categoryDAO.replaceCategoryInAllExpenses(fromCategoryId, toCategoryId);
        categoryDAO.delete(fromCategoryId);
        return numberOfReplace;
    }
}
