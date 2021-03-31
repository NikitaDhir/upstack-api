package org.upgrad.upstac.testrequests.consultation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upgrad.upstac.users.User;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

    List<Consultation> findByDoctor(User user);
}
