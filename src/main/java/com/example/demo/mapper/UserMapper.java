package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserMapper {

    List<User> selectAllUser(int role_id);

    List<User> selectUserByParams(String user_id,String user_name,String user_phone, int kind);

    User Sel(String id);

    User login_user(String phone, String pwd);

    boolean save_user(User user);

    User finduserphone(String phone);

    User getuserbyopenid(String openid);

    boolean update_info(String id,String name,int gender);

    List<User> selectAllUserInfo();

    User selectByUserID(String userId);

    boolean del_user(String user_id);

    boolean reset_user(String user_id);

}
