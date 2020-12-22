package com.springboottemplate.string;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * @Description:map与对象互转
 * @author: 唐涛
 * @date:   2019年12月13日 下午2:13:08
 *
 */
public class TestString {


	/**
	 **
	 * @Description:分割字符串
	 * @param:
	 * @return: void
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException {
		String data = "姓名=张三；手机号=123456；密码=970509；地址=郑州市中原区";
		if (data == null || data.length() == 0) {
			return;
		}

		String key;
		String value;
		Map<String, String> maps = new HashMap<String, String>();
		String[] split = data.split("；");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			String valueOf = toString().valueOf(split[i]);
			String[] split2 = valueOf.split("=");
			key = split2[0];
			value = split2[1];
			maps.put(key, value);
		}

		for (Map.Entry<String, String> entry : maps.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());

		}
		// System.out.println(maps.toString());
		Map<String, String> maps2 = new HashMap<String, String>();
		maps2.put("姓名", "name");
		maps2.put("密码", "password");
		maps2.put("手机号", "phone");
		maps2.put("地址", "address");

		Map<String, Object> maps3 = new HashMap<String, Object>();
		for (Map.Entry<String, String> entry : maps.entrySet()) {
			String newVaString = maps2.get(entry.getKey());
			maps3.put(newVaString, maps.get(entry.getKey()));
		}
		System.out.println(maps3.toString());



	//	BeanUtils.populate(user, maps3);
		try {
			UserAA useraa = map2bean(maps3, UserAA.class);
			System.out.println(useraa);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	// Map转换为JavaBean
	public  <T> T map2bean(Map<String, Object> map, Class<T> clz) throws Exception {
		// 创建JavaBean对象
		T obj = clz.newInstance();
		// 获取指定类的BeanInfo对象
		BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
		// 获取所有的属性描述器
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			Object value = map.get(pd.getName());
			Method setter = pd.getWriteMethod();
			setter.invoke(obj, value);
		}
		return obj;
	}

}

class UserAA {

	private String name;
	private String password;
	private String phone;
	private String address;

	public UserAA() {
		super();
	}

	public UserAA(String name, String password, String phone, String address) {
		super();
		this.name = name;
		// this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", phone=" + phone + ", address=" + address + "]";
	}

}
