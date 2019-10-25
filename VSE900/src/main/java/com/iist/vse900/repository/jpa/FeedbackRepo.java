package com.iist.vse900.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.iist.vse900.domain.dto.FeedbackDTO;
import com.iist.vse900.domain.model.Feedback;

@Repository
public class FeedbackRepo {

	@PersistenceContext
	private EntityManager em;

	public List<FeedbackDTO> getAllFeedback() {
		String sql = "select * from Feedback where is_active = 'Y'";
		Query query = em.createNativeQuery(sql.toString(), Feedback.class);
		List<FeedbackDTO> list = query.getResultList();
		return list;
	}

	public void Save(Feedback feedback) {
		em.persist(feedback);
	}
	

	public void Delete(Long id) {
		Feedback feedback = em.find(Feedback.class, id);
		em.remove(feedback);
	}

	public void Update(Long id, Feedback feedback) {
		Feedback feedbackupdate = em.find(Feedback.class, id);
		feedbackupdate.setFullName(feedback.getFullName());
		feedbackupdate.setEmail(feedback.getEmail());
		feedbackupdate.setPhoneNumber(feedback.getPhoneNumber());
		feedbackupdate.setContent(feedback.getContent());
		feedbackupdate.setIsActive(feedback.getIsActive());
		feedbackupdate.setCreatedDate(feedback.getCreatedDate());
		feedbackupdate.setCreatedBy(feedback.getCreatedBy());
	}
}
