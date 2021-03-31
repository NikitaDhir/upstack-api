package org.upgrad.upstac.testrequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.consultation.Consultation;
import org.upgrad.upstac.testrequests.consultation.ConsultationRepository;
import org.upgrad.upstac.testrequests.lab.LabResult;
import org.upgrad.upstac.testrequests.lab.LabResultRepository;
import org.upgrad.upstac.users.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class TestRequestQueryService {

    @Autowired
    private TestRequestRepository testRequestRepository;

    @Autowired
    private LabResultRepository labResultRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<TestRequest> findBy(RequestStatus requestStatus) {
        return testRequestRepository.findByStatus(requestStatus);
    }

    public List<TestRequest> findByTester(User user) {
        return  labResultRepository.findByTester(user)
                .stream()
                .map(LabResult::getRequest)
                .collect(Collectors.toList());
    }

    public List<TestRequest> findByDoctor(User user) {
        return  consultationRepository.findByDoctor(user)
                .stream()
                .map(Consultation::getRequest)
                .collect(Collectors.toList());
    }


}
