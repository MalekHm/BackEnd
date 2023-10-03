package com.backend.hrportal.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractRequest {
    Long   employee ;
    String type ;
    String duration ;
    String    nature ;
    Date  startDate ;
    Date endDate ;
    String   workingCalendar ;
}
