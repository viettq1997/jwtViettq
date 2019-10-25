package com.iist.vse900.repository.impl;

import com.iist.vse900.domain.dto.NotifyDTO;
import com.iist.vse900.domain.model.Notify;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class NotifyRepo {
    @PersistenceContext
    private EntityManager em;

    public List<NotifyDTO> getAllNotify() {
        String sql = "select * from Notify where is_active = 'Y'";
        Query query = em.createNativeQuery(sql.toString(), Notify.class);
        List<NotifyDTO> list = query.getResultList();
        return list;
    }

    public void Save(Notify notify) {
        em.persist(notify);
        em.close();
    }

    public void Delete(int id) {
        Notify notify = em.find(Notify.class, id);
        em.remove(notify);
        em.close();
    }

    public void Update(int id, Notify notify) {
        Notify notifyupdate = em.find(Notify.class, id);
        notifyupdate.setNotifyCode(notify.getNotifyCode());
        notifyupdate.setType(notify.getType());
        notifyupdate.setIcon(notify.getIcon());
        notifyupdate.setTitle(notify.getTitle());
        notifyupdate.setContent(notify.getContent());
        notifyupdate.setStatus(notify.getStatus());
        notifyupdate.setStartDate(notify.getStartDate());
        notifyupdate.setEndDate(notify.getEndDate());
        notifyupdate.setIsActive(notify.getIsActive());
        notifyupdate.setCreateDate(notify.getCreateDate());
        notifyupdate.setCreateBy(notify.getCreateBy());
        notifyupdate.setModifiedDate(new Date());
        notifyupdate.setModifiedBy(notify.getModifiedBy());
        em.close();
    }
}
