package com.example.mybatisexamples.example05;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisexamples.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper05 extends BaseMapper<User> {
    @Results(value = {
            @Result(column = "id",
            property = "addresses",
            javaType = List.class,
            many = @Many(select =
                    "com.example.mybatisexamples.example05.AddressMapper05.listAddresses"))
    })
    @Select("select * from user where id=#{uid}")
    UserDTO05 getById(long uid);
    //-----------------
    UserDTO05 getByXML2(long uid);
    @ResultMap("userDTOResultMap")
    @Select("select u.*, a.id a_id, a.detail a_detail, a.user_id a_user_id, "+
            "a.create_time a_create_time from user u join address a "+
            "on u.id = a.user_id where u.id=#{uid}")
    UserDTO05 getByXML(long uid);
}
