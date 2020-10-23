package tv.nosy.climanage.models.job;

import tv.nosy.climanage.models.dao.Users;
import tv.nosy.climanage.models.dao.UsersImpl;

public class SubmitLogin {
    public static boolean submit(Users u){
        boolean res = false;

        try{
            UsersImpl umeth = new UsersImpl();
            umeth.addUsers(u);
            res = true;
        }catch(Exception e){
            e.printStackTrace();
        }

        return res;
    }

    private static boolean isMatch(long id, String pass){
        boolean res = false;
        UsersImpl ui = new UsersImpl();
        Users u = ui.getUsers(id);
        if(u.getCd().getPass() == pass){
            res = true;
        }
        return res;
    }
    private static Users getUsersInfo(long id){

        UsersImpl ui = new UsersImpl();
        Users res = ui.getUsers(id);

        return res;
    }

    public static Users login(long id, String pass){
        Users res = null;
        if(isMatch(id, pass)){
            res = getUsersInfo(id);
        }
        return res;
    }
}
