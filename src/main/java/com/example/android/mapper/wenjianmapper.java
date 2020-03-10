package com.example.android.mapper;

import com.example.android.entity.wenjianentity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface wenjianmapper {
    @Insert("INSERT INTO wenjian(file_id,file_name,file_url" +
            ") VALUES(#{file_id},#{file_name},#{file_url})")
    void wenjian(wenjianentity wenjian);
    @Select("select *from wenjian")
    List<wenjianentity> wenjianlist();
}
