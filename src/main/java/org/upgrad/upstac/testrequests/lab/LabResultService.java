package org.upgrad.upstac.testrequests.lab;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Validated
public class LabResultService {

    @Autowired
    private LabResultRepository labResultRepository;

    private LabResult createLabResult(User tester, TestRequest testRequest) {
        LabResult labResult = new LabResult();
        labResult.setTester(tester);
        labResult.setRequest(testRequest);
        return saveLabResult(labResult);
    }

    public LabResult assignForLabTest(TestRequest testRequest, User tester) {
        return createLabResult(tester, testRequest);
    }

    @Transactional
    LabResult saveLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }

    public LabResult updateLabTest(TestRequest testRequest, CreateLabResult createLabResult) {
        LabResult labResult = new LabResult();
        labResult.setBloodPressure(labResult.getBloodPressure());
        labResult.setComments(labResult.getComments());
        labResult.setOxygenLevel(labResult.getOxygenLevel());
        labResult.setTemperature(labResult.getTemperature());
        labResult.setHeartBeat(labResult.getHeartBeat());
        labResult.setUpdatedOn(LocalDate.now());
        labResult.setResult(TestStatus.NEGATIVE);
        return saveLabResult(labResult);
    }


}
