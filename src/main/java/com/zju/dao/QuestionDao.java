package com.zju.dao;

import com.zju.model.Question;
import com.zju.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */
@Mapper
public interface QuestionDao {

    public String TABLE_NAME = " question ";
    public String INSERT_FIELDS = " title, content, created_date, user_id, comment_count";
    public String SELECT_FIELDS = " id " + INSERT_FIELDS;

    @Insert({"insert into "+TABLE_NAME + " ( " +INSERT_FIELDS +" ) "
            + " values( #{title}, #{content}, #{createdDate}, #{userId}, #{commentCount} )" })
    int addQuestion(Question question);

    @Select({"select "+SELECT_FIELDS + " from " + TABLE_NAME +" where id = #{id}"})
    User getQuestionById(int id);

    List<Question> getLatestQuestions(@Param(value = "userId") int userId,
                                      @Param(value = "offset") int offset,
                                      @Param(value = "limit") int limit);



}
