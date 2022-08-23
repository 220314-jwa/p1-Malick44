package net.revature.trmsapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventType {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int eventTypeId;

    private String eventTypeName;
}
