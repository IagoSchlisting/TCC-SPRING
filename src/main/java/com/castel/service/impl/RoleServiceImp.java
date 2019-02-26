package com.castel.service.impl;
import com.castel.dao.RoleDao;
import com.castel.service.RoleService;
import com.castel.models.Role;
import javax.annotation.Resource;

public class RoleServiceImp implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        this.roleDao.addRole(role);
    }

    @Override
    public Role getRoleById(int id) { return this.roleDao.getRoleById(id); }

}
