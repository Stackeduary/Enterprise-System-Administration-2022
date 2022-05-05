package com.adilsdeals.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
public class Duration{
    private Date startTime;
    private Date finishTime;
}