package com.moveit.server.repository;

import com.moveit.client.SystemException;
import com.moveit.client.model.CreateUser;
import com.moveit.client.model.User;
import com.moveit.server.Logger;
import com.moveit.server.dao.Dao;
import com.moveit.server.dao.FindByOneParam;
import com.moveit.server.jdo.UserJDO;

import java.util.Collection;
import java.util.Date;

/**
 *
 */
public class UserRepository extends Repository<UserJDO, User, CreateUser> {


    public UserRepository() {
        this(new Dao(UserJDO.class), new UserConverter());
    }

    public UserRepository(Dao dao, Converter con) {
        super(dao, con);
    }

    public Class<User> getRepositoryType() {
        return User.class;
    }


    //FINDERS

    public User findByEmail(String email) {
        if (email == null || email.equals("")) {
            return null;
        }
        FindByOneParam findByParam = FindByOneParam.findByEmail();
        findByParam.setValue(email.trim().toLowerCase());
        Collection<User> users = findBy(findByParam);
        if (users.isEmpty()) {
            if (!email.equalsIgnoreCase("dummy")) {
                Logger.log("Unable to find User from email " + email.toLowerCase());
            }
        }
        if (users.size() > 1) {
            throw new SystemException("Data error - " + users.size() + " users with same email exist. Email=" + email);
        }
        return users.isEmpty() ? null : users.iterator().next();
    }

    public User update(User user) {
        UserJDO jdo = dao.read(user.getId());
        jdo.setName(user.getName());
        jdo.setLastChangeDate(new Date());
        jdo.setNationality(user.getNationality());
        jdo.setPhone(user.getPhone());
        jdo.setPassword(user.getPassword());
        return conv.convert(dao.update(jdo));
    }
}
