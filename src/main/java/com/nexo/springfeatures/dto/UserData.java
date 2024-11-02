package com.nexo.springfeatures.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserData implements Serializable {

    private String name;

    private String mobile;

    private String email;
}
