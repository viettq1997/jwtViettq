package com.iist.vse900.service;

import com.iist.vse900.domain.dto.NotifyDTO;
import com.iist.vse900.domain.model.Notify;

import java.util.List;

public interface NotifyService {
    List<NotifyDTO> getAllNotify();
    void Save(Notify notify);
    void Delete(int id);
    void Update(int id, Notify notify);
}
