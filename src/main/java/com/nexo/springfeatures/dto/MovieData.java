package com.nexo.springfeatures.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class MovieData implements Serializable {

    private String name;

    private String genre;

    private BigInteger capacity;
}
