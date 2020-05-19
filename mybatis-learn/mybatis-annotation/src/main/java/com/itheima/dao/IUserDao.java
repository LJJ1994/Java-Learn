package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)
public interface IUserDao {

    @Select("select * from user")
    @Results(id = "userMap",
            value = {
                    @Result(id=true, column = "id", property = "userId"),
                    @Result(column = "username", property = "userName"),
                    @Result(column = "address", property = "userAddress"),
                    @Result(column = "sex", property = "userSex"),
                    @Result(column = "birthday", property = "userBirthday"),
                    @Result(column = "id",
                            property = "accounts",
                            many = @Many(select = "com.itheima.dao.IAccountDao.findByUid", fetchType = FetchType.LAZY))
            })
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    @ResultMap("userMap")
    User findById(Integer id);

    @Insert("insert into user(username,sex,address,birthday) values(#{userName}, #{userSex}, #{userAddress}, #{userBirthday})")
    @SelectKey(keyColumn = "id", keyProperty = "userId", resultType = Integer.class, before = false,
            statement = {"select last_insert_id()"})
    int saveUser(User user);

    @Update("update user set username=#{userName}, address=#{userAddress}, sex=#{userSex}, birthday=#{userBirthday} where id=#{uid}")
    int updateUser(User user);

    @Delete("delete from user where id=#{uid}")
    int deleteUser(Integer userId);

    @Select("select count(*) from user")
    int findTotal();

    @Select("select * from user where username like #{username}")
    User findByUsername(String username);
}
