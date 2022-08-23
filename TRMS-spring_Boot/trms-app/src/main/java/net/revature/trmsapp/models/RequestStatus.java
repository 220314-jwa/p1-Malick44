package net.revature.trmsapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RequestStatus {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int requestId;
    private int statusId;
    private String status;
}
