package org.upgrad.upstac.testrequests;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestRequestRepository extends JpaRepository<TestRequest, Long> {

    List<TestRequest> findByEmailOrPhoneNumber(String email, String phoneNumber);
    List<TestRequest> findByStatus(RequestStatus status);
    Optional<TestRequest> findByRequestIdAndStatus(Long id, RequestStatus status);

}
