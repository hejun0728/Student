package com.biz.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.biz.entity.Student;
import com.biz.service.StudentService;

import redis.clients.jedis.Jedis;

public class StudentServiceImpl implements StudentService {

	private static Jedis jedis;

	static {
		jedis = new Jedis("localhost", 6379);
	}

	public int addStudent(Student student) {
		String hashKey = getHashKey(student.getId());
		if (jedis.exists(hashKey)) {
			return 0;
		} else {
			saveToRedis(student, hashKey);
			/*
			 * ZADD key score member [[score member] [score member] ...]
			 * 
			 * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
			 */
			jedis.zadd("student_number", student.getAvgscore(), student.getId());
			return 1;
		}
	}

	/*
	 * ZREM key member [member ...]
	 * 
	 * 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。
	 */
	public Long deleteStudent(String id) {
		jedis.zrem("student_number", id);
		return jedis.del(getHashKey(id));
	}

	public List<Student> getOnePage(int cur_page) {
		List<Student> studentList = new LinkedList<Student>();

		/*
		 * ZREVRANGE key start stop [WITHSCORES]
		 * 
		 * 返回有序集 key 中，指定区间内的成员。 其中成员的位置按 score 值递减(从大到小)来排列。
		 */

		Set<String> id_set = jedis.zrevrange("student_number", (cur_page - 1) * 10, cur_page * 10 - 1);
		for (String id : id_set) {
			studentList.add(getById(id));
		}
		return studentList;
	}

	public int getTotalPage() {

		/*
		 * ZCARD key
		 * 
		 * 返回有序集 key 的基数。
		 */
		int len = jedis.zcard("student_number").intValue();
		if (len % 10 == 0) {
			return len / 10;
		} else {
			return len / 10 + 1;
		}
	}

	public void updateStudent(Student student) {
		saveToRedis(student, getHashKey(student.getId()));
	}

	public Student getById(String id) {

		String key = getHashKey(id);
		Student student = new Student();
		student.setId(jedis.hget(key, "id"));
		student.setName(jedis.hget(key, "name"));
		try {
			student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(jedis.hget(key, "birthday")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		student.setDescription(jedis.hget(key, "description"));
		student.setAvgscore(Integer.parseInt(jedis.hget(key, "avgscore")));
		return student;
	}

	private void saveToRedis(Student student, String hashKey) {
		/*
		 * HSET key field value 将哈希表 key 中的域 field 的值设为 value 。
		 */

		jedis.hset(hashKey, "id", student.getId());
		jedis.hset(hashKey, "name", student.getName());
		jedis.hset(hashKey, "birthday", new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday()));
		jedis.hset(hashKey, "description", student.getDescription());
		jedis.hset(hashKey, "avgscore", String.valueOf(student.getAvgscore()));
	}

	private String getHashKey(String id) {
		return "student_info_" + id;
	}
}
