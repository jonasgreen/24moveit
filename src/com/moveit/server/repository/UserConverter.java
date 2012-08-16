package com.moveit.server.repository;

import com.moveit.client.model.CreateUser;
import com.moveit.client.model.User;
import com.moveit.client.model.Address;
import com.moveit.server.jdo.UserJDO;

/**
 *
 */
public class UserConverter extends Converter<UserJDO, User, CreateUser> {

    public UserJDO convert(CreateUser model) {
        if (model == null) {
            return null;
        }
        UserJDO jdo = new UserJDO();

        Address add = model.getAddress();
        jdo.setNationality(add.getNationalCode());
        jdo.setCity(add.getCity());
        jdo.setCityCode(add.getCityCode());
        jdo.setStreet(add.getStreet());

        jdo.setFirmName(model.getFirmName());
        jdo.setCvrNr(model.getCvrnr());
        jdo.setWebsite(model.getWebsite());

        jdo.setEmail(model.getEmail().trim().toLowerCase());
        jdo.setPassword(model.getPassword().trim());
        jdo.setPhone(model.getPhone());
        jdo.setName(model.getName());
        jdo.setUserType(model.getUserType());
        return jdo;
    }

    public User convert(UserJDO jdo) {
        if (jdo == null) {
            return null;
        }
        User user = new User();
        user.setNationality(jdo.getNationality());
        user.setUserType(jdo.getUserType());
        user.setEmail(jdo.getEmail());
        user.setPassword(jdo.getPassword());
        user.setName(jdo.getName());
        user.setPhone(jdo.getPhone());
        user.setId(jdo.getKeyId());
        user.setCreatedDate(jdo.getCreatedDate());
        return user;
    }


}
