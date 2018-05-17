package com.tsh.example.dao;

import com.tsh.example.model.User;
//import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface UserMapper {
    void save(User user);
    User getById(Integer id);
    List<User> listAll();
    void deleteById(Integer id);
    void update(User usre);

}
