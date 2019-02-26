package com.castel.dao;

import com.castel.models.Role;

public interface RoleDao {
    public void addRole(Role r);
    public Role getRoleById(int id);

}
