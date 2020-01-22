package com.notspend.dao.impl;

import com.notspend.dao.CategoryDao;
import com.notspend.entity.Category;
import com.notspend.util.SecurityUserHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> query = session.createQuery("FROM Category WHERE username = :param AND income = 0", Category.class);
        query.setParameter("param", SecurityUserHandler.getCurrentUser());
        return query.getResultList();
    }

    @Override
    public List<Category> getAllIncome() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> query = session.createQuery("FROM Category WHERE username = :param AND income = 1", Category.class);
        query.setParameter("param", SecurityUserHandler.getCurrentUser());
        return query.getResultList();
    }

    @Override
    public void save(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
    }

    @Override
    public Optional<Category> get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.of(session.get(Category.class, id));
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, id);
        session.delete(category);
    }

    @Override
    public void update(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public boolean isCategoryNameExist(Category category) {
        return getAll().stream()
                .filter(a -> a.getName().equalsIgnoreCase(category.getName()))
                .count() > 0;
    }

    @Override
    public boolean isCategoryHaveRelations(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = get(id).orElseThrow();
        Query query = session.createQuery("FROM Expense E WHERE E.category = :obj");
        query.setParameter("obj", category);
        return !query.list().isEmpty();
    }

    @Override
    public int replaceCategoryInAllExpenses(Integer fromCategoryId, Integer toCategoryId){
        Session session = sessionFactory.getCurrentSession();

        Category fromCategory = get(fromCategoryId).orElseThrow();
        Category toCategory = get(toCategoryId).orElseThrow();

        Query query = session.createQuery("UPDATE Expense SET category = :toCategory" +
                " WHERE category = :fromCategory");
        query.setParameter("toCategory", toCategory);
        query.setParameter("fromCategory", fromCategory);
        return query.executeUpdate();
    }
}
