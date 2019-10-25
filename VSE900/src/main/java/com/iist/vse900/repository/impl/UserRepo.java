package com.iist.vse900.repository.impl;

import com.iist.vse900.domain.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepo {
    @PersistenceContext
    private EntityManager em;

    //    doi mk
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        String sqlSelect = "SELECT user_id FROM Customer WHERE user_name = :username";
        Query q = em.createNativeQuery(sqlSelect.toString());
        q.setParameter("username", username);
        List<Object> userId = q.getResultList();
        if (userId.isEmpty()){
            return false;
        }
        String sql = "Update User SET password = :newPassword , history_password = :oldPassword , last_time_changed_pass = :dateNow where password = :oldPassword and user_id = :id";
        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("oldPassword", oldPassword);
        query.setParameter("id", Integer.parseInt(userId.get(0).toString()));
        query.setParameter("newPassword", newPassword);
        query.setParameter("dateNow", new Date());
        int rs = query.executeUpdate();
        if (rs == 0) {
            return false;
        }
        return true;
    }

    public boolean resetPassword(String username) {
        String newPassword = "abc";
        String sqlSelectId = "SELECT user_id FROM Customer WHERE user_name = :username";
        Query qId = em.createNativeQuery(sqlSelectId.toString());
        qId.setParameter("username", username);
        List<Object> userId = qId.getResultList();
        if (userId.isEmpty()){
            return false;
        }
        String sqlSelect = "select password from User where user_id = :id";
        Query q = em.createNativeQuery(sqlSelect.toString());
        q.setParameter("id", Integer.parseInt(userId.get(0).toString()));
        List<Object> password = q.getResultList();
        String sql = "Update User SET password = :newPassword , history_password = :oldPassword ,last_time_changed_pass = :dateNow WHERE user_id = :id";
        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("id", Integer.parseInt(userId.get(0).toString()));
        query.setParameter("newPassword", newPassword);
        query.setParameter("oldPassword", password.get(0).toString());
        query.setParameter("dateNow", new Date());
        int rs = query.executeUpdate();
        if (rs == 0) {
            return false;
        }
        return true;
    }
}
