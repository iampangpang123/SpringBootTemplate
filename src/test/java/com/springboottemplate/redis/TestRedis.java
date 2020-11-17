//
//package cn.tang.web1.redis;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//public class TestRedis {
//
//	@Test
//	public void test1() {
//		/*
//		 * 注意，放进去后，你在ssh上看是乱码，因为他保存的是一个二进制数，所以你看见的死二进制，只有我们java代码获取到才能解码
//		 */
//		Jedis jedis = new Jedis("192.168.25.129", 6379);// 第一个是我虚拟机的ip地址，第二个死端口号
//		// 放入一个String的类型
//		jedis.set("aaaa", "aaaaa");
//		// 放入一个map类型
//		Map map = new HashMap<>();
//		map.put("age", "20");
//		map.put("sex", "男");
//		jedis.hmset("王五", map);
//	}
//
//	/**
//	 * @Description: TODO(获取值)
//	 * @return void 返回类型
//	 */
//	@Test
//	public void test2() {
//		/*
//		 * 注意，放进去后，你在ssh上看是乱码，因为他保存的是一个二进制数，只有我们java代码获取到才能解码
//		 */
//		Jedis jedis = new Jedis("192.168.25.129", 6379);// 第一个是我虚拟机的ip地址，第二个死端口号
//		System.out.println(jedis.hkeys("王五"));
//		;
//		System.out.println(jedis.hvals("王五"));
//		;
//		System.out.println(jedis.hgetAll("王五"));
//	}
//
//	/**
//	 * @Description: TODO(jedis连接池)
//	 * @return void 返回类型
//	 */
//	@Test
//	public void test3() {
//
//		// 1、设置连接池的配置对象
//		JedisPoolConfig config = new JedisPoolConfig();
//		// 设置池中最大连接数【可选】
//		config.setMaxTotal(50);
//		// 设置空闲时池中保有的最大连接数【可选】
//		config.setMaxIdle(10);
//		// 2、设置连接池对象
//		JedisPool pool = new JedisPool(config, "192.168.25.129", 6379);
//		// 3、从池中获取链接对象
//		Jedis jedis = pool.getResource();
//		System.out.println(jedis.hgetAll("王五"));
//		// 4、连接归还池中
//		jedis.close();
//	}
//}
