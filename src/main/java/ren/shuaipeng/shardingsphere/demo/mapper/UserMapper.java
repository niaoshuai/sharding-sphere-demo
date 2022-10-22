package ren.shuaipeng.shardingsphere.demo.mapper;

import org.apache.ibatis.annotations.*;
import ren.shuaipeng.shardingsphere.demo.model.UserEntity;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO test1 (id,user_name,password)\n" +
            "\tVALUES (#{id},#{userName},#{password})")
    int insertUser(UserEntity entity);

    @Select("SELECT id, user_name, password\n" +
            "FROM test1 WHERE user_name = #{userName}")
    UserEntity findByUserName(@Param("userName") String userName);
}
