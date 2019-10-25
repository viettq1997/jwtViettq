package com.iist.vse900.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iist.vse900.controller.base.BaseController;
import com.iist.vse900.domain.dto.FeedbackDTO;
import com.iist.vse900.domain.model.Feedback;
import com.iist.vse900.service.FeedbackService;

@RestController
@RequestMapping(value="/feedback")
public class FeedbackController extends BaseController{

    @Autowired
    private FeedbackService feedbackService;

    @CrossOrigin
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<FeedbackDTO>> getAllFeedback() {
        List<FeedbackDTO> list = feedbackService.getAllFeedback();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FeedbackDTO>>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/saveFeedback", method = RequestMethod.POST)
    public void saveFeedback(@RequestBody Feedback feedback) {
    	feedbackService.Save(feedback);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteFeedback", method = RequestMethod.DELETE)
    public void saveFeedback(@RequestParam Long id) {
    	feedbackService.Delete(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateFeedback", method = RequestMethod.PUT)
    public void updateFeedback(@RequestParam Long id, @RequestBody Feedback feedback) {
    	feedbackService.Update(id, feedback);
    }
}
