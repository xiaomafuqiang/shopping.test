package net.htmlonline;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

class F {
    static {
        ConvertUtils.register(new Converter() {
            @Override
            public <T> T convert(Class<T> aClass, Object o) {
                Date date = new Date();
                System.out.println(date);
                return ((T) date);
            }
        }, Date.class);
    }
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        run();


    }

    static void run() throws InvocationTargetException, IllegalAccessException {

        HashMap<String, String> map = new HashMap<>();
        map.put("id", "34");
        map.put("name", "xx");
        map.put("date", "xx");
        User user = new User();

        BeanUtils.populate(user, map);
        System.out.println(user);
        user.setId(9999);
        System.out.println(user);

        BeanUtils.populate(user, map);
        System.out.println(user);
    }
}

public class User {
    private int id;
    private String name;
    private Date date;


    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}