package com.iist.vse900.service.impl;

import com.iist.vse900.domain.dto.NotifyDTO;
import com.iist.vse900.domain.model.Notify;
import com.iist.vse900.repository.impl.NotifyRepo;
import com.iist.vse900.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    private NotifyRepo notifyRepo;

    @Override
    public List<NotifyDTO> getAllNotify() {
        return notifyRepo.getAllNotify();
    }

    @Override
    public void Save(Notify notify) {
        notifyRepo.Save(notify);
    }

    @Override
    public void Delete(int id) {
        notifyRepo.Delete(id);
    }

    @Override
    public void Update(int id, Notify notify) {
        notifyRepo.Update(id,notify);
    }
}
