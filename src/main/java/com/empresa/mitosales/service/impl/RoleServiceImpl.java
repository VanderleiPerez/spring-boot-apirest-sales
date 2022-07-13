package com.empresa.mitosales.service.impl;

import com.empresa.mitosales.model.Category;
import com.empresa.mitosales.model.Role;
import com.empresa.mitosales.repo.IGenericRepo;
import com.empresa.mitosales.repo.IRoleRepo;
import com.empresa.mitosales.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends CRUDImpl<Role,Integer> implements IRoleService {

    //@Autowired
    private IRoleRepo repo;

    public RoleServiceImpl(IRoleRepo repo) {
        this.repo = repo;
    }
    @Override
    protected IGenericRepo<Role, Integer> getRepo() {
        return repo;
    }

}
