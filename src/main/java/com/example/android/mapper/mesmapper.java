package com.example.android.mapper;

import com.example.android.entity.mesentity;
import com.example.android.entity.sijientity;
import com.example.android.entity.userentity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface mesmapper {
    @Select("SELECT * FROM user1 WHERE userid = #{userid}")
    userentity getUserByid(String userid);
    @Insert("INSERT INTO xinxi(userid,username,mes_title,mes_content,mes_id" +
            ") VALUES(#{userid},#{username},#{mes_id},#{mes_title},#{mes_content})")
    void mesadd(mesentity mes);

    @Select("select * from xinxi")
    List<mesentity> meslist();
}
