package com.iist.vse900.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iist.vse900.domain.dto.FeedbackDTO;
import com.iist.vse900.domain.model.Feedback;
import com.iist.vse900.repository.jpa.FeedbackRepo;
import com.iist.vse900.service.FeedbackService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
    private FeedbackRepo feedbackRepo;

    @Override
    public List<FeedbackDTO> getAllFeedback() {
        return feedbackRepo.getAllFeedback();
    }

    @Override
    public void Save(Feedback feedback) {
    	feedbackRepo.Save(feedback);
    }

    @Override
    public void Delete(Long id) {
    	feedbackRepo.Delete(id);
    }

    @Override
    public void Update(Long id, Feedback feedback) {
    	feedbackRepo.Update(id,feedback);
    }
	

}
