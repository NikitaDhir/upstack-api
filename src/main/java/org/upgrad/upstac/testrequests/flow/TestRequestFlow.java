package org.upgrad.upstac.testrequests.flow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.upgrad.upstac.testrequests.RequestStatus;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class TestRequestFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JsonIgnore
    private TestRequest request;

    private RequestStatus fromStatus ;
    private RequestStatus toStatus ;

    @ManyToOne
    private User changedBy;

    private LocalDate happenedOn=LocalDate.now();
}
