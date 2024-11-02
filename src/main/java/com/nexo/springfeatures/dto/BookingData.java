package com.nexo.springfeatures.dto;

import com.nexo.springfeatures.dao.Movie;
import com.nexo.springfeatures.dao.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BookingData implements Serializable {

    private User user;

    private Movie movie;

    private String bookingId;

    private BigDecimal amount;

    private String status;
}
