package com.iist.vse900.service;

import java.util.List;

import com.iist.vse900.domain.dto.FeedbackDTO;
import com.iist.vse900.domain.model.Feedback;

public interface FeedbackService {
	
	List<FeedbackDTO> getAllFeedback();
    void Save(Feedback feedback);
    void Delete(Long id);
    void Update(Long id, Feedback feedback);

}
