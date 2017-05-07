package com.lijie.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lijie.empty.DUser;
import com.lijie.util.HibernateSessionFactory;

public class HibernateTest {
	public static Session session = null;

	@Test
	public void Test() {
		HibernateTest ht = new HibernateTest();
		ht.getCurrentSession();
		ht.saveUser();
		System.out.println("保存用户，增加一条记录！");
		ht.queryUser();
		ht.updateUser();
		System.out.println("修改用户，修改一条记录！");
		ht.queryUser();
		ht.deleteUser();
		System.out.println("删除用户，删除一条记录！");
		ht.queryUser();

		ht.closeSession();
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.updateUser
	 * @Description: TODO{更新用户信息}
	 * @author: 疯狂机械师
	 * @date: 2017年5月4日 void
	 * @update [日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public void updateUser() {
		getCurrentSession();
		Transaction t2 = session.beginTransaction();
		DUser dUser = session.get(DUser.class, 5);
		dUser.setNickname("王五");
		session.update(dUser);
		t2.commit();
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.closeSession
	 * @Description: TODO{关闭session 方法}
	 * @author: 疯狂机械师
	 * @date: 2017年5月4日 void
	 * @update [日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	private void closeSession() {
		if (session != null) {
			HibernateSessionFactory.closeSession();
		}
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.deleteUser
	 * @Description: TODO{删除一个用户}
	 * @author: 疯狂机械师
	 * @date: 2017年5月4日 void
	 * @update [日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	private void deleteUser() {
		// TODO 删除一条记录的方法
		System.out.println("删除一条记录的方法");
		Transaction t3 = session.beginTransaction();
		DUser dUser = session.get(DUser.class, 8);
		session.delete(dUser);
		t3.commit();
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.queryUser
	 * @Description: TODO{查询一个用户}
	 * @author: 疯狂机械师
	 * @date: 2017年5月4日 void
	 * @update [日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public void queryUser() {
		// TODO Auto-generated method stub
		try {
			Query query = session.createQuery("from DUser");
			List<?> list = query.list();
			for (int i = 0; i < list.size(); i++) {
				DUser dUser = (DUser) list.get(i);
				System.out.println(dUser);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.saveUser
	 * @Description: TODO{保存一个用户}
	 * @author: 疯狂机械师
	 * @date: 2017年5月4日 void
	 * @update [日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public void saveUser() {
		// TODO 插入一条记录
		Transaction t1 = session.beginTransaction();
		DUser dUser = new DUser();
		dUser.setEmail("www.46687@qq.com");
		dUser.setNickname("李杰");
		dUser.setPassword("lijie123");
		dUser.setIsEmailVerify("YES");
		dUser.setEmailVerifyCode("hfakjhfdsauigfkujgfdrhasgu");
		dUser.setLastLoginTime(System.currentTimeMillis());
		dUser.setLastLoginIp("192.168.1.1");
		dUser.setUserIntegral(100);
		session.save(dUser);
		try {
			t1.commit();
		} catch (Exception e) {
			t1.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.getCurrentSession
	 * @Description: TODO{获得session方法}
	 * @author: 疯狂机械师
	 * @date: 2017年5月4日 void
	 * @update [日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	private void getCurrentSession() {
		// TODO HibernateSessionFactory 的 getSession 方法创建 Session 对象
		System.out.println("HibernateSessionFactory 的 getSession 方法创建 Session 对象");
		session = HibernateSessionFactory.getSession();
	}
}
