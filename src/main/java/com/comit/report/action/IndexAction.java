package com.comit.report.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comit.base.session.SessionFactory;
import com.comit.report.dao.UserMapper;
import com.comit.report.model.MUser;
import com.comit.report.po.User;
import com.comit.report.service.UserService;

@Controller
@RequestMapping("/user")
public class IndexAction {
	//@Autowired
	SqlSessionFactory sqlSessionFactory;
    @Resource
    private UserService userService;
	@RequestMapping(value="/index.do")
	public String index(HttpServletRequest request,HttpServletResponse response){
		return "index";
	}

	@RequestMapping("/hello.do") 
	public ModelAndView hello(){ 
//		SqlSession sqlSession = null;
//		try {
//			sqlSession = SessionFactory.getSqlSession();
//			UserMapper m = sqlSession.getMapper(UserMapper.class);
//			List<User>ls = m.getObjects();
//			for (int i = 0; i < ls.size(); i++) {
//				System.out.println("==============="+ls.get(i).getName());
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			if(sqlSession!=null)
//			sqlSession.close();
//		}
		MUser u = new MUser();
		u.setAd_user_id(124);
		u.setName("bnbnbnbnnb");
		u.save();

		ModelAndView mv =new ModelAndView(); 
		mv.addObject("spring", "spring mvc"); 
		mv.setViewName("index"); 
		return mv; 

	} 

}
