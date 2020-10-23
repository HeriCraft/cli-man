package tv.nosy.climanage.models.dao.test;

import java.sql.Date;
import java.util.List;

import tv.nosy.climanage.models.dao.Code;
import tv.nosy.climanage.models.dao.Users;
import tv.nosy.climanage.models.dao.UsersImpl;

public class Test {
    public static void main(String[] args){
        UsersImpl dao = new UsersImpl();
        dao.addUsers(new Users(0, "Test Name", "test_name", new Code(0, null, "sassasd", Date.valueOf("2020-04-30"))));
        dao.addUsers(new Users(0, "Test Name 1", "test_name1", new Code(0, null, "ajskdgf", Date.valueOf("2020-05-21"))));
        dao.addUsers(new Users(0, "Test Name 2", "test_name2", new Code(0, null, "akjsdgf", Date.valueOf("2020-12-01"))));
        dao.addUsers(new Users(0, "Test Name 3", "test_name3", new Code(0, null, "aksdgjf", Date.valueOf("2020-06-20"))));
        List<Users> usrs = dao.getAllUsers();
        for(Users u:usrs){
            System.out.println(u.getUsername());
        }
    }
}
