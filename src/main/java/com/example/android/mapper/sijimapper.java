package com.example.android.mapper;

import com.example.android.entity.sijientity;
import com.example.android.entity.userentity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface sijimapper {
    @Insert("INSERT INTO siji(userid,username,si_title,si_content,si_id,si_img" +
            ") VALUES(#{userid},#{username},#{si_title},#{si_content},#{si_id},#{si_img})")
    void sijiadd(sijientity siji);
    @Select("SELECT * FROM user1 WHERE userid = #{userid}")
    userentity getUserByid(String userid);

    @Select("select * from siji")
    List<sijientity> sijilist();

}
