package com.zju.service;

import com.zju.dao.QuestionDao;
import com.zju.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */
@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public int addQueston(Question question){
        question.setTitle(HtmlUtils.htmlEscape(question.getTitle()));
        question.setContent(HtmlUtils.htmlEscape(question.getContent()));
        return questionDao.addQuestion(question);
    }

    public List<Question> getLatestQuestions(int userId,int offset,int limit){
        return questionDao.getLatestQuestions(userId, offset, limit);
    }
}
