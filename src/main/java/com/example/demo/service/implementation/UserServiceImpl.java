package com.example.demo.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    List<User> list=new ArrayList<>();

    public User registerUser(User user){
        list.add(user);
        return user;
    }
    
    public User getUser(long id){
        for(User li:list){
            if(li.getId()==id){
                return li;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return list;
    }
    public User getByEmail(String email){
        for(User li:list){
            if(li.getEmail()==email){
                return li;
            }
        }
        return null;
    }
}
