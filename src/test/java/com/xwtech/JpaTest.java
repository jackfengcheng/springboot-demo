package com.xwtech;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.xwtech.dao.UsersRepository;
import com.xwtech.dao.UsersRepositoryByName;
import com.xwtech.dao.UsersRepositoryCrud;
import com.xwtech.dao.UsersRepositoryPaginAndShorting;
import com.xwtech.dao.UsersRepositorySpeciafication;
import com.xwtech.pojo.Users;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class JpaTest {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private UsersRepositorySpeciafication usersRepositorySpeciafication;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersRepositoryPaginAndShorting usersRepositoryPaginAndShorting;
	
	@Autowired
	private UsersRepositoryByName usersRepositoryByName;
	
	@Autowired
	private UsersRepositoryCrud usersRepositoryCrud;
	
	@Test
	public void findByName(){
		List<Users> userList = this.usersRepositoryByName.findByName("张三");
		for (Users users : userList) {
			System.out.println(users);
		}
	}
	
	
	@Test
	public void findByNameAndAge(){
		List<Users> userList = this.usersRepositoryByName.findByNameAndAge("张三", 15);
		for (Users users : userList) {
			System.out.println(users);
		}
	}
	
	
	
	@Test
	public void findByNameLike(){
		List<Users> userList = this.usersRepositoryByName.findByNameLike("张%");
		for (Users users : userList) {
			System.out.println(users);
		}
	}
	
	/**
	 * Crud添加
	 */
	@Test
	public void crudSaveTest(){
		Users user = new Users();
		user.setAge(18);
		user.setName("Jack");
		user.setAddress("城关区  峡谷办事自");
		this.usersRepositoryCrud.save(user);
	}
	
	/**
	 * Crud更新
	 */
	@Test
	public void crudUpdateTest(){
		Users user = new Users();
		user.setId(5);
		user.setAge(180);
		user.setName("Jack");
		user.setAddress("城关区  下关十字");
		this.usersRepositoryCrud.save(user);
	}
	
	/**
	 * Crud查询单个
	 */
	@Test
	public void crudFindOneTest(){
		Users users = this.usersRepositoryCrud.findOne(4);
		System.out.println(users);
	}
	
	/**
	 * Crud查询所有
	 */
	@Test
	public void crudFindAllTest(){
		List<Users> list = (List<Users>) this.usersRepositoryCrud.findAll();
		for (Users users2 : list) {
			System.out.println(users2);
			this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
			this.redisTemplate.boundHashOps("user_info").put(users2.getId()+"", users2);
		}
	}
	
	/**
	 * Crud判断是否存在
	 */
	@Test
	public void crudExistsTest(){
		boolean b = this.usersRepositoryCrud.exists(20);
		if(b){
			System.out.println("用户已经存在！");
		}else{
			System.out.println("用户不存在！！可以添加");
		}
	}
	
	/**
	 * Crud删除
	 */
	@Test
	public void crudDeleteTest(){
		this.usersRepositoryCrud.delete(5);
	}
	
	/**
	 * Shorting测试
	 */
	
	@Test
	public void shortingTest(){
		Order orders = new Order(Direction.DESC,"id");
		Sort sort = new Sort(orders );
		List<Users> listUsers = (List<Users>)this.usersRepositoryPaginAndShorting.findAll(sort );
		for (Users users : listUsers) {
			System.out.println(users);
		}
	}
	
	/**
	 * Pagin测试
	 */
	
	@Test
	public void pagingTest(){
		Pageable pageable = new PageRequest(1, 4);
		Page<Users> page = this.usersRepositoryPaginAndShorting.findAll(pageable);
		System.out.println("总条数"+page.getTotalElements());
		System.out.println("总页数"+	page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * PaginAndShorting测试
	 */
	@Test
	public void PaginAndShortingTest(){
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(0, 10,sort);
		
		Page<Users> page = this.usersRepositoryPaginAndShorting.findAll(pageable);
		System.out.println("总条数"+page.getTotalElements());
		System.out.println("总页数"+	page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	
	@Test
	public void JpaRepositoryTest(){
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
//		Pageable pageable = new PageRequest(0, 10,sort);
		
		List<Users> list = this.usersRepository.findAll(sort);

		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * Specification用于封装查询条件   单条件
	 */
	@Test
	public void  repositorySpeciaficationTest(){
		
		Specification<Users> spec = new Specification<Users>() {
			
			/**
			 * Predicate 封装单个的查询条件
			 * Root<Users> root ：查询的属性的封装
			 * CriteriaQuery<?> query ：封装了  我们要执行的查询中的各个部分的信息。select   from    order by 等
			 * CriteriaBuilder cb ：查询条件的构造器
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				/**
				 * 参数一：查询的条件属性
				 * 参数二：条件的值
				 */
				Predicate predicate = cb.equal(root.get("name"), "张三");
				return predicate;
			}
		};
		
		List<Users> list = this.usersRepositorySpeciafication.findAll(spec);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * Specification用于封装查询条件   多条件1
	 */
	@Test
	public void  repositorySpeciaficationTest2(){
		
		Specification<Users> spec = new Specification<Users>() {
			
			/**
			 * Predicate 封装单个的查询条件
			 * Root<Users> root ：查询的属性的封装
			 * CriteriaQuery<?> query ：封装了  我们要执行的查询中的各个部分的信息。select   from    order by 等
			 * CriteriaBuilder cb ：查询条件的构造器
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("name"), "张三"));
				list.add(cb.equal(root.get("age"), 15));
				Predicate[] arr = new Predicate[list.size()]; 
				return cb.and(list.toArray(arr));
			}
		};
		
		List<Users> list = this.usersRepositorySpeciafication.findAll(spec);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	
	/**
	 * Specification用于封装查询条件   多条件2
	 */
	@Test
	public void  repositorySpeciaficationTest3(){
		
		Specification<Users> spec = new Specification<Users>() {
			
			/**
			 * Predicate 封装单个的查询条件
			 * Root<Users> root ：查询的属性的封装
			 * CriteriaQuery<?> query ：封装了  我们要执行的查询中的各个部分的信息。select   from    order by 等
			 * CriteriaBuilder cb ：查询条件的构造器
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
//				List<Predicate> list = new ArrayList<>();
//				list.add(cb.equal(root.get("name"), "张三"));
//				list.add(cb.equal(root.get("age"), 15));
//				Predicate[] arr = new Predicate[list.size()]; 
				return cb.or(cb.and(cb.equal(root.get("name"), "张三"),cb.equal(root.get("age"), 15)),cb.equal(root.get("id"),1));
			}
		};
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
		List<Users> list = this.usersRepositorySpeciafication.findAll(spec,sort);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	
}
