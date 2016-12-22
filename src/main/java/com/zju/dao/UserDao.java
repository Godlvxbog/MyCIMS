package com.zju.dao;

import com.zju.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/12/22.
 */
@Mapper
public interface UserDao {
    public String TABLE_NAME = " user ";
    public String INSERT_FIELDS = " name, password, salt, head_url, org, skill, project,profile, url ";
    public String SELECT_FIELDS = " id " + INSERT_FIELDS;

    @Insert({"insert into "+TABLE_NAME + " ( " +INSERT_FIELDS +" ) "
            + " values( #{name}, #{password}, #{salt}, #{headUrl}, #{org}, #{skill}, #{project}, #{profile}, #{url} )"})
    int addUser(User user);

    @Select({"select "+SELECT_FIELDS + " from " + TABLE_NAME +" where id = #{id}"})
    User getUserById(int id);

    @Select({"select "+SELECT_FIELDS + " from " + TABLE_NAME +" where name = #{name}"})
    User getUserByName(int id);

}
