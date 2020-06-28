package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserMapper {
    User Sel(String id);

    User login_user(String phone, String pwd);

    boolean save_user(User user);

    User finduserphone(String phone);

    User getuserbyopenid(String openid);

    boolean update_info(String id,String name,int gender);

    List<User> selectAllUserInfo();

    User selectByUserID(String userId);

}
