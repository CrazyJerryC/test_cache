import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {
    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作 k-v 字符串

    @Autowired
    RedisTemplate redisTemplate;  //k- v 都是对象

    @Test
    public void test1() {
        stringRedisTemplate.opsForValue().append("StringKey", "字符串数值");
        String value = stringRedisTemplate.opsForValue().get("StringKey");
        System.out.println(value);
    }
}