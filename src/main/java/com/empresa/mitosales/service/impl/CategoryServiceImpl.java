package com.empresa.mitosales.service.impl;

import com.empresa.mitosales.model.Category;
import com.empresa.mitosales.repo.ICategoryRepo;
import com.empresa.mitosales.repo.IGenericRepo;
import com.empresa.mitosales.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl extends CRUDImpl<Category,Integer> implements ICategoryService {

    //@Autowired
    private ICategoryRepo repo;

    public CategoryServiceImpl(ICategoryRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }

    /* En su reemplazo se está usando el genérico CRUDImpl
    @Override
    public Category create(Category cat) throws Exception {
        return repo.save(cat); // Si cat no posee una llave primaria existente -> CREATE
    }

    @Override
    public Category update(Category cat) throws Exception {
        return repo.save(cat); // Si cat posee una llave primaria existente -> UPDATE
    }

    @Override
    public List<Category> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Category readById(Integer id) throws Exception {
        return repo.getReferenceById(id); //2.7.1
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
    */
}
