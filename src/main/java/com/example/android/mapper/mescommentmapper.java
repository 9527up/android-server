package com.example.android.mapper;

import com.example.android.entity.liucommententity;
import com.example.android.entity.mescommententity;
import com.example.android.entity.sicommententity;
import com.example.android.entity.userentity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface mescommentmapper {
    @Select("select *from xinxicomment where mes_id=#{mes_id}")
    List<mescommententity> mescomment(String mes_id);

    @Select("SELECT * FROM user1 WHERE userid = #{userid}")
    userentity getUserByid(String userid);

    @Insert("INSERT INTO xinxicomment(userid,username,mes_comment,mes_id" +
            ") VALUES(#{userid},#{username},#{mes_comment},#{mes_id})")
    void mescommentadd(mescommententity mescomment);

}
