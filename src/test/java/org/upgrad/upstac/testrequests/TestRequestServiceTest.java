package org.upgrad.upstac.testrequests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.upgrad.upstac.exception.AppException;
import org.upgrad.upstac.users.User;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestRequestServiceTest {

    @InjectMocks
    TestRequestService testRequestService;

    @Mock
    TestRequestRepository testRequestRepository;

    @Test
    public void when_saveTestRequest_called_with_valid_parameters_expect_save_method_of_testRequestRepository_is_called(){

        //Arrange
        User loggedInUser = new User();
        loggedInUser.setUserName("SometestUser");

        TestRequestInput testRequestInput = new TestRequestInput();
        testRequestInput.setAddress("someaddress");
        testRequestInput.setAge(87);
        testRequestInput.setEmail("someone@someemail.com");
        testRequestInput.setPhoneNumber("93757338");

        when(testRequestRepository.findByEmailOrPhoneNumber(testRequestInput.getEmail(), testRequestInput.getPhoneNumber())).thenReturn(new ArrayList<>());

        //Act
        testRequestService.saveTestRequest(loggedInUser, testRequestInput);

        //Assert
        verify(testRequestRepository,times(1)).save(any());

    }

    @Test
    public void when_saveTestRequest_called_with_same_values_in_database_expect_AppException_is_thrown(){

        //Arrange
        User loggedInUser = new User();
        loggedInUser.setUserName("SometestUser");

        TestRequestInput testRequestInput = new TestRequestInput();
        testRequestInput.setAddress("someaddress");
        testRequestInput.setAge(87);
        testRequestInput.setEmail("someone@someemail.com");
        testRequestInput.setPhoneNumber("93757338");

        TestRequest testRequest = new TestRequest();
        testRequest.setStatus(RequestStatus.INITIATED);
        testRequest.setEmail("someone@someemail.com");
        testRequest.setPhoneNumber("93757338");
        List<TestRequest> mockedTestRequestsForFindByEmailOrPhoneNumber = new ArrayList<>();
        mockedTestRequestsForFindByEmailOrPhoneNumber.add(testRequest);

        when(testRequestRepository.findByEmailOrPhoneNumber(testRequestInput.getEmail(), testRequestInput.getPhoneNumber())).thenReturn(mockedTestRequestsForFindByEmailOrPhoneNumber);

        //ACT
        AppException appException = assertThrows(AppException.class, ()->{
            testRequestService.saveTestRequest(loggedInUser, testRequestInput);
        });

        //Assert
        assertThat(appException.getMessage(), containsString(" A request with same email or phone number already exists..!!"));

    }

}