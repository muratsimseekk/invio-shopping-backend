package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.UserResponse;
import com.invio.shoppingdemo.entity.User;
import com.invio.shoppingdemo.exceptions.CommonException;
import com.invio.shoppingdemo.repository.UserRepository;
import com.invio.shoppingdemo.util.UserDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Override
    public List<UserResponse> findAll() {
        return UserDtoConvertion.convertUserList(userRepository.findAll());
    }

    @Override
    public UserResponse save(User user) {
        userRepository.save(user);
        return UserDtoConvertion.convertUser(user);
    }

    @Override
    public UserResponse delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()){
            userRepository.delete(user.get());
            return UserDtoConvertion.convertUser(user.get());
        }

        throw new CommonException("Ilgili ID user bulunamadi . ID: " + id , HttpStatus.NOT_FOUND);
    }



    @Override
    public UserResponse findById(Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()){
            return UserDtoConvertion.convertUser(user.get());
        }
        throw new CommonException("Ilgili ID user bulunamadi . ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public User findByUserId(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()){
            return user.get();
        }
        throw new CommonException("Ilgili ID user bulunamadi . ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public UserResponse update(String name , String surname , String email , Long id) {
        Optional<User> user1 = userRepository.findById(id);

        if (user1.isPresent()){
            User existingUser = user1.get();
            existingUser.setName(name);
            existingUser.setSurname(surname);
            existingUser.setEmail(email);
            existingUser.setPassword1(user1.get().getPassword());
             userRepository.save(existingUser);
             return UserDtoConvertion.convertUser(existingUser);
        }
        throw new CommonException("Ilgili ID user bulunamadi . ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public UserResponse updatePassword(String password, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            User existingUser = user.get();
            existingUser.setPassword1(password);
             userRepository.save(existingUser);
             return UserDtoConvertion.convertUser(existingUser);
        }
        throw new CommonException("Ilgili ID user bulunamadi . ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->{
            throw new UsernameNotFoundException("User bilgileri sistemde yok . ");
        });
    }
}
