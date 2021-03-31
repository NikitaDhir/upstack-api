package org.upgrad.upstac.testrequests.lab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upgrad.upstac.users.User;

import java.util.List;

public interface LabResultRepository extends JpaRepository<LabResult,Long> {

    List<LabResult> findByTester(User user);
}
