package com.iist.vse900.repository.impl;

import com.iist.vse900.domain.dto.CustomerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CustomerRepo {
    @Bean
    public PasswordEncoder passwordEncoders() {
        return new BCryptPasswordEncoder();
    }

    @PersistenceContext
    private EntityManager em;

    public boolean checkUsername(String username) {
        String sql = "select * from Customer where user_name = :username";
        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("username", username);
        List<Object> list = query.getResultList();
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    //get customer
    public List<CustomerDTO> getById(int id) {
        String sql = "select * from Customer where user_id =:id";
        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("id", id);
        List<CustomerDTO> list = query.getResultList();
        return list;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!checkUsername(username)) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        String sql = "SELECT u.user_id FROM `User` AS u JOIN Customer AS c ON u.user_id = c.user_id WHERE c.user_name = :username and u.is_active = 'Y'";
        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("username", username);
        List<Object> list = query.getResultList();

        String sqlSetTimeLogin = "Update User Set last_time_login = :timeNow Where user_id = :id";
        Query q = em.createNativeQuery(sqlSetTimeLogin.toString());
        q.setParameter("timeNow", new Date());
        int id = Integer.parseInt(list.get(0).toString());
        q.setParameter("id", id);
        q.executeUpdate();
        String sqlSelectPassword = "select password from User where user_id = :id";
        Query query1 = em.createNativeQuery(sqlSelectPassword.toString());
        query1.setParameter("id", id);
        List<Object> passwordSl = query1.getResultList();
        String password = passwordSl.get(0).toString();
        return new User(username, passwordEncoders().encode(password), new ArrayList<>());
    }
}
