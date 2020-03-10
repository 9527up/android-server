package com.example.android.mapper;

import com.example.android.entity.liujientity;
import com.example.android.entity.sijientity;
import com.example.android.entity.userentity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface liujimapper {
    @Insert("INSERT INTO liuji(userid,username,liu_title,liu_content,liu_id,liu_img" +
            ") VALUES(#{userid},#{username},#{liu_title},#{liu_content},#{liu_id},#{liu_img})")
    void liujiadd(liujientity liuji);
    @Select("SELECT * FROM user1 WHERE userid = #{userid}")
    userentity getUserByid(String userid);

    @Select("select * from liuji")
    List<liujientity> liujilist();

}
