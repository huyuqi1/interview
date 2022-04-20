package com.yuqi.interview.mapper;

import com.yuqi.interview.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Usermapper{

    public User findall(int id);

    public User getgrade(User user);

    public void update(User user);

    public void insert(User user);

    User getgradebyname(String name);
}
