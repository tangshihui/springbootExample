import com.tsh.example.dao.UserMapper;
import com.tsh.example.model.User;
import com.tsh.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={UserMapper.class})
public class AppTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void testAdd(){

        User user=userService.getUser();
        userMapper.save(user);
    }
}
