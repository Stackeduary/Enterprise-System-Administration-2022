package com.adilsdeals.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Duration{
    private Date startTime;
    private Date finishTime;
}