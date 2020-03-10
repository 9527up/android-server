package com.example.android.mapper;

import com.example.android.entity.sijientity;
import com.example.android.entity.userentity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface usermapper {
    @Select("SELECT * FROM user1 WHERE userid = #{userid}")
    userentity getUserByid(String userid);


    @Insert("INSERT INTO user1(userid,userpass,username,school,acadamy,number,user_img" +
            ") VALUES(#{userid},#{userpass},#{username},#{school},#{acadamy},#{number},#{user_img})")
    void userregister(userentity user);

    @Update({"UPDATE user1 set userid=#{userid} ,userpass =#{userpass},username=#{username},school=#{school},acadamy=#{acadamy},number=#{number},user_img=#{user_img} where userid=#{userid}"})
        int updateUser(userentity userentity);

}
