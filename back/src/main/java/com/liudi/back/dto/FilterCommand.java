package com.liudi.back.dto;

import lombok.Data;

@Data
public class FilterCommand {
    String startdate;

    String enddate;

    String field;
}
