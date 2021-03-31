package org.upgrad.upstac.testrequests.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Validated
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Transactional
    public Consultation assignForConsultation(TestRequest testRequest, User doctor) {
        Consultation consultation = new Consultation();
        consultation.setDoctor(doctor);
        consultation.setRequest(testRequest);
        return consultationRepository.save(consultation);
    }

    public Consultation updateConsultation(TestRequest testRequest , CreateConsultationRequest createConsultationRequest) {
        Consultation consultation = new Consultation();
        consultation.setComments(consultation.getComments());
        consultation.setUpdatedOn(LocalDate.now());
        consultation.setSuggestion(consultation.getSuggestion());
        return consultationRepository.save(consultation);
    }

}
