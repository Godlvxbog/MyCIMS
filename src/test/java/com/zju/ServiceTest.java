package com.zju;

import com.ThinkersApplication;
import com.zju.controller.HomeController;
import com.zju.dao.QuestionDao;
import com.zju.dao.UserDao;
import com.zju.model.Question;
import com.zju.model.User;
import com.zju.model.ViewObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ThinkersApplication.class)
@WebAppConfiguration
public class ServiceTest {

	@Autowired
	UserDao userDao;
	@Autowired
	QuestionDao questionDao;

	@Autowired
	HomeController homeController;



	@Test
	public void addUser(){
		for (int i = 0; i< 10 ; i++){

			User user =new User();
			user.setName("NAME  - " + i);
			user.setPassword(UUID.randomUUID().toString());
			user.setSalt(UUID.randomUUID().toString().substring(1,5));
			user.setOrg("科学院 - "+ i);

			userDao.addUser(user);
		}
	}

	@Test
	public void getUser(){
		for (int i = 1; i<5;i++){
			User user = userDao.getUserById(i);
			System.out.println(user);
			System.out.println(user.getOrg() + " ---- " + user.getPassword());



		}
	}

	@Test
	public void addQuestion(){
		for (int i = 0; i< 10; i++){
			Question question =new Question();
			question.setTitle("TITLE-"+i);
			question.setContent("CONTENT- "+i);

			questionDao.addQuestion(question);
		}
	}

	@Test
	public void getLatestQuestion(){
		List<Question> questionList =questionDao.getLatestQuestions(1,1,5);
		for (Question  question: questionList){
			System.out.println(question.getTitle() + " == === == " + question.getContent());

		}
	}

	@Test
	public void getQuestion(){
		List<ViewObject> vos =  homeController.getQuestions(0,1,5);

		for (ViewObject vo :vos){
		   Question question=(Question)vo.get("question");
			System.out.println(question.getTitle());
		}
	}







}
