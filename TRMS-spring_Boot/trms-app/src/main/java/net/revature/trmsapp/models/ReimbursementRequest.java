package net.revature.trmsapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReimbursementRequest {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int requestId;

    private int employeeId;
    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private EventType eventTypeId;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private  RequestStatus statusId;
    private double cost;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern= "MM-dd-yyyy")
    private Date eventDate;
    private String description;

    private String location;

    private Instant submissionTime;

    public RequestStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(RequestStatus statusId) {
        this.statusId = statusId;
    }

    public EventType getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(EventType eventTypeId) {
        this.eventTypeId = eventTypeId;
    }
}
