package com.qorb.service.implement;

import com.qorb.model.Role;
import com.qorb.model.Unit;
import com.qorb.model.User;
import com.qorb.repository.RoleRepository;
import com.qorb.repository.UnitRepository;
import com.qorb.repository.UserRepository;
import com.qorb.service.IUser;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserImpl implements IUser {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public DataSourceResult getAllUsers(DataSourceRequest request) {
        return userRepository.getAllKendo(request,User.class);
    }

    @Override
    public User createUser(Map<String, Object> model) {
        return null;
    }

    @Override
    public User updateUser(Map<String, Object> model) {
        return null;
    }

    @Override
    public User deleteUser(Map<String, Object> model) {
        return null;
    }

    @Override
    @Transactional
    public void createUser(String radeId, String userNameId, String passId,Integer idRole) {
        User user=new User();
        user.setInsertDate(new Date());
        PasswordEncoder shaPasswordEncoder=new BCryptPasswordEncoder();
        user.setPassword(shaPasswordEncoder.encode(passId));
        user.setUserName(userNameId);
        user.setUnit(unitRepository.findByIdUnit(Integer.valueOf(radeId)));
        Set<Role> roleSet=new HashSet<>();
        roleSet.add(roleRepository.findByIdRole(idRole));
        user.setRoles(roleSet );
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Integer editId, String radeId, String userNameId, String passId,Integer idRole) {
        try {
            User user = userRepository.findByIdUser(editId);
            user.setInsertDate(new Date());
            PasswordEncoder shaPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(shaPasswordEncoder.encode(passId));
            user.setUserName(userNameId);
            user.setUnit(unitRepository.findByIdUnit(Integer.valueOf(radeId)));
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleRepository.findByIdRole(idRole));
            user.setRoles(roleSet);
            user = userRepository.save(user);

        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }

    @Override
    public User findByIdUser(Integer editId) {
        return userRepository.findByIdUser(editId);
    }
}
