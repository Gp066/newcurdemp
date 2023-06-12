import com.gp.StartApplication;
import com.gp.dao.EmpDao;
import com.gp.pojo.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class testtt {

    @Autowired
    private EmpDao empDao;

    @Test
    public void ss(){

        Emp byId = empDao.findById(1).get();
        System.out.println(byId);
    }
}
