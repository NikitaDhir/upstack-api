package org.upgrad.upstac.testrequests.consultation;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateConsultationRequest {

    @NotNull
    private DoctorSuggestion suggestion;

    private String comments;
}
