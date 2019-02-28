package com.castel.dao.impl;

import com.castel.dao.UserDao;
import com.castel.models.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDaoImp extends HibernateDaoSupport implements UserDao {

    @Override
    @Transactional
    public void addUser(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        getHibernateTemplate().update(user);
    }

    @Override
    public List<User> listUsers(int user_id) {
        return (List<User>) getHibernateTemplate().find("from com.castel.models.User where not USER_ID = "+ user_id);
    }

    @Override
    public User getUserById(int id) {
        User user = getHibernateTemplate().get(User.class, id);
        return user;
    }

    @Override
    public User getUserByName(String name){
        List<User> users;
        String query = "from com.castel.models.User as u where username = '"+name+"'";
        users = (List<User>) getHibernateTemplate().find(query);

        User user;
        if(users.isEmpty()){ user = new User();}
        else{user = users.get(0);}
        return user;
    }


    @Override
    @Transactional
    public void removeUser(int id) {
        User user = this.getUserById(id);

        if(user.getUsername().equals("iago.machado")){
            throw new RuntimeException("Ação não autorizada, o usuário iago.machado não pode ser removido.");
        }

        getHibernateTemplate().delete(this.getUserById(id));
    }

}
