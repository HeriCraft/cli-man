package tv.nosy.climanage.models.dao;

import java.util.List;

public interface IUsersDAO{
    public void addUsers(Users u);
    public Users getUsers(long id);
    public List<Users> getAllUsers();
    public void updateUsers(Users u);
    public void deleteUsers(Users u);
    public void deleteUsers(long id);
}