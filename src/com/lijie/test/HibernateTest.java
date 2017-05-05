package com.lijie.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lijie.empty.DUser;
import com.lijie.util.HibernateSessionFactory;

public class HibernateTest {
	public Session session;

	@Test
	public void Test() {
		HibernateTest ht = new HibernateTest();
		ht.getCurrentSession();
		ht.saveUser();
		System.out.println("�����û�������һ����¼��");

		// ht.queryUser();
		// ht.updateUser();
		// System.out.println("�޸��û����޸�һ����¼��");
		ht.queryUser();
		ht.deleteUser();
		System.out.println("ɾ���û���ɾ��һ����¼��");
		ht.queryUser();

		ht.closeSession();
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.updateUser
	 * @Description: TODO{�����û���Ϣ}
	 * @author: ����еʦ
	 * @date: 2017��5��4�� void
	 * @update [����YYYY-MM-DD][����������][�������]
	 */
	private void updateUser() {
		System.out.println("�����û���Ϣ");
		Transaction t2 = session.beginTransaction();
		DUser dUser = session.get(DUser.class, 2);
		dUser.setNickname("����");
		session.update(dUser);
		t2.commit();
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.closeSession
	 * @Description: TODO{�ر�session ����}
	 * @author: ����еʦ
	 * @date: 2017��5��4�� void
	 * @update [����YYYY-MM-DD][����������][�������]
	 */
	private void closeSession() {
		if (session != null) {
			HibernateSessionFactory.closeSession();
		}
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.deleteUser
	 * @Description: TODO{ɾ��һ���û�}
	 * @author: ����еʦ
	 * @date: 2017��5��4�� void
	 * @update [����YYYY-MM-DD][����������][�������]
	 */
	private void deleteUser() {
		// TODO ɾ��һ����¼�ķ���
		System.out.println("ɾ��һ����¼�ķ���");
		Transaction t3 = session.beginTransaction();
		DUser dUser = session.get(DUser.class, 2);
		session.delete(dUser);
		t3.commit();
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.queryUser
	 * @Description: TODO{��ѯһ���û�}
	 * @author: ����еʦ
	 * @date: 2017��5��4�� void
	 * @update [����YYYY-MM-DD][����������][�������]
	 */
	private void queryUser() {
		// TODO Auto-generated method stub
		System.out.println("��ѯһ����¼�ķ���");
		try {
			Query query = session.createQuery("from d_user");
			List<?> list = query.list();
			for (int i = 0; i < list.size(); i++) {
				DUser dUser = (DUser) list.get(i);
				System.out.println(dUser);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.saveUser
	 * @Description: TODO{����һ���û�}
	 * @author: ����еʦ
	 * @date: 2017��5��4�� void
	 * @update [����YYYY-MM-DD][����������][�������]
	 */
	private void saveUser() {
		// TODO ����һ����¼
		System.out.println("����һ����¼");
		Transaction t1 = session.beginTransaction();
		DUser dUser = new DUser();
		dUser.setEmail("www.609446687@qq.com");
		dUser.setNickname("���");
		dUser.setPassword("lijie123");
		dUser.setIsEmailVerify("YES");
		dUser.setEmailVerifyCode("hfakjhfdsauigfkujgfdrhasgu");
		dUser.setLastLoginTime(System.currentTimeMillis());
		dUser.setLastLoginIp("192.168.1.1");
		try {
			t1.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Method: com.lijie.test.HibernateTest.getCurrentSession
	 * @Description: TODO{���session����}
	 * @author: ����еʦ
	 * @date: 2017��5��4�� void
	 * @update [����YYYY-MM-DD][����������][�������]
	 */
	private void getCurrentSession() {
		// TODO HibernateSessionFactory �� getSession �������� Session ����
		System.out.println("HibernateSessionFactory �� getSession �������� Session ����");
		session = HibernateSessionFactory.getSession();
	}
}
