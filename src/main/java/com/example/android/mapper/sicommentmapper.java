package com.example.android.mapper;

import com.example.android.entity.sicommententity;
import com.example.android.entity.sijientity;
import com.example.android.entity.userentity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface sicommentmapper {
    @Select("select *from sijicomment where si_id=#{si_id}")
    List<sicommententity>sicomment(String si_id);

    @Select("SELECT * FROM user1 WHERE userid = #{userid}")
    userentity getUserByid(String userid);

    @Insert("INSERT INTO sijicomment(userid,username,si_comment,si_id" +
            ") VALUES(#{userid},#{username},#{si_comment},#{si_id})")
    void sicommentadd(sicommententity sjcomment);
}
