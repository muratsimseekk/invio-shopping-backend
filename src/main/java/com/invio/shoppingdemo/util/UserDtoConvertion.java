package com.invio.shoppingdemo.util;

import com.invio.shoppingdemo.dto.UserResponse;
import com.invio.shoppingdemo.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoConvertion {

    public static List<UserResponse> convertUserList(List<User> userList){
        List<UserResponse> userResponses = new ArrayList<>();

        userList.stream().forEach(user -> userResponses.add(new UserResponse(user.getId(), user.getName()
                , user.getSurname(), user.getEmail() , AddressDtoConvertion.convertAddressList(user.getAddressList()))));
        return userResponses;
    }

    public static UserResponse convertUser(User user) {

        return new UserResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail()
                , AddressDtoConvertion.convertAddressList(user.getAddressList()));
    }

}
