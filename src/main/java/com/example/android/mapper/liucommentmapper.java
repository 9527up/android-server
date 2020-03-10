package com.example.android.mapper;

import com.example.android.entity.liucommententity;
import com.example.android.entity.sicommententity;
import com.example.android.entity.userentity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface liucommentmapper {
    @Select("select *from liujicomment where liu_id=#{liu_id}")
    List<liucommententity> liucomment(String liu_id);

    @Select("SELECT * FROM user1 WHERE userid = #{userid}")
    userentity getUserByid(String userid);

    @Insert("INSERT INTO liujicomment(userid,username,liu_comment,liu_id" +
            ") VALUES(#{userid},#{username},#{liu_comment},#{liu_id})")
    void liucommentadd(liucommententity ljcomment);
}
