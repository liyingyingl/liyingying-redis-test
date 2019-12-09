package com.liyingying.test;

import java.rmi.server.UID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liyingying.StringUtils;
import com.liyingying.bean.User;
import com.liyingying.bean.UserUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:redis.xml")
public class RedisTest {
	@Autowired
	RedisTemplate redisTemplate;
	
	//使用JDK系列化方式保存5万个user随机对象到Redis，并计算耗时
	@Test
	public void redisJDKtest() {
		long start=System.currentTimeMillis();
		for (int i = 1; i <= 50000; i++) {
			User user=new User();
			user.setId(i);
			user.setName(StringUtils.getRandomCn(3));
			user.setGender(UserUtils.getSex());
			user.setPhone("13"+StringUtils.getRandomNumber(9));
			user.setEmail(UserUtils.getMail());
			user.setBirthday(UserUtils.getBirthday());
			
			redisTemplate.opsForValue().set("user"+i, user);
			
		}
		long end=System.currentTimeMillis();
		
		System.out.println("使用了jdk的序列化方式");
		//计算时间
		System.out.println("共用了:"+(end-start)+"时间");
		System.out.println("共保存了5w条数据");
		
		
		
	}
	//使用JSON系列化方式保存5万个user随机对象到Redis，并计算耗时
	@Test
	public void redisJSONtest() {
		long start=System.currentTimeMillis();
		for (int i = 1; i <= 50000; i++) {
			User user=new User();
			user.setId(i);
			user.setName(StringUtils.getRandomCn(3));
			user.setGender(UserUtils.getSex());
			user.setPhone("13"+StringUtils.getRandomNumber(9));
			user.setEmail(UserUtils.getMail());
			user.setBirthday(UserUtils.getBirthday());
			
			redisTemplate.opsForValue().set("user"+i, user);
			
		}
		long end=System.currentTimeMillis();
		
		System.out.println("使用了JSON的序列化方式");
		//计算时间
		System.out.println("共用了:"+(end-start)+"时间");
		System.out.println("共保存了5w条数据");
		
		
		
	}
	//使用hash系列化方式保存5万个user随机对象到Redis，并计算耗时
	@Test
	public void redisHashtest() {
		long start=System.currentTimeMillis();
		for (int i = 1; i <= 50000; i++) {
			User user=new User();
			user.setId(i);
			user.setName(StringUtils.getRandomCn(3));
			user.setGender(UserUtils.getSex());
			user.setPhone("13"+StringUtils.getRandomNumber(9));
			user.setEmail(UserUtils.getMail());
			user.setBirthday(UserUtils.getBirthday());
			
			redisTemplate.opsForHash().put("users"+i, "user"+i, user.toString());
			
		}
		long end=System.currentTimeMillis();
		
		System.out.println("使用了hash的序列化方式");
		//计算时间
		System.out.println("共用了:"+(end-start)+"时间");
		System.out.println("共保存了5w条数据");
		
		
		
	}

}
