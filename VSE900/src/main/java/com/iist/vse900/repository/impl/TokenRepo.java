package com.iist.vse900.repository.impl;

import com.iist.vse900.domain.dto.TokenDTO;
import com.iist.vse900.domain.model.Token;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class TokenRepo {
    @PersistenceContext
    private EntityManager em;

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public void Save(String username, String token) {
        String sqlSelectId = "select user_id from Customer where user_name = :username";
        Query query = em.createNativeQuery(sqlSelectId.toString());
        query.setParameter("username", username);
        List<Object> id = query.getResultList();
        String sqlSelectToken = "SELECT * FROM Token where user_id =:id";
        Query query1 = em.createNativeQuery(sqlSelectToken.toString(), Token.class);
        query1.setParameter("id", Integer.parseInt(id.get(0).toString()));
        List<Token> listToken =  query1.getResultList();
        if (listToken.isEmpty()) {

            Date createdDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(createdDate);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date expriedDate = cal.getTime();
            //
            Token tokenObj = new Token();
            tokenObj.setUserId(Integer.parseInt(id.get(0).toString()));
            tokenObj.setToken(token);
            tokenObj.setCreatedDate(createdDate);
            tokenObj.setExpriedDate(expriedDate);
            em.persist(tokenObj);
        } else if (listToken.get(0).getCreatedDate().compareTo(listToken.get(0).getExpriedDate()) > 0) {
            Update(token, Integer.parseInt(id.get(0).toString()));
        }
    }

    public void Update(String token, int id) {
        Date createdDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(createdDate);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date expriedDate = cal.getTime();
        String sqlUpdate = "update Token set expried_date = :expriedDate , token = :token , created_date = :createdDate Where user_id = :id";
        Query query = em.createNativeQuery(sqlUpdate.toString());
        query.setParameter("expriedDate", expriedDate);
        query.setParameter("token", token);
        query.setParameter("createdDate", createdDate);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
