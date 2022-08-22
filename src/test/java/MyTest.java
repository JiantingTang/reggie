import com.uestc.reggie.entity.Employee;
import org.junit.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

public class MyTest {
    @Test
    public void func() throws UnsupportedEncodingException {
        String a = "qazwsx";
        System.out.println(a);
        String b = DigestUtils.md5DigestAsHex(a.getBytes());
        System.out.println(b.length());
        System.out.println(Factory.getEmplyee().toString());
        System.out.println(new User("jingcz", "boy"));
    }

    @Test
    public void func1() {
        String sVersion = SpringVersion.getVersion();
        System.out.println("Spring 版本号：" + sVersion);
        String bVersion = SpringBootVersion.getVersion();
        System.out.println("SpringBoot 版本号：" + bVersion);

    }
}

class Factory {

    public static Employee getEmplyee() {
        String cla = "com.uestc.reggie.entity.Employee";
        Class claa = null;
        Employee emp = null;
        try {
            claa = Class.forName(cla);
            System.out.println(claa);
            emp = (Employee) claa.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return emp;
    }
}

class User {
    String name;
    String gender;

    public User(String name, String gender) {
        this.name = name;
        this.gender = gender;
        String.class.getClassLoader();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
