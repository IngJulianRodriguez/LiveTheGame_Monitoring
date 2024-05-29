package com.livethegame.Monitoring.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.*;
import javax.persistence.*;

@Entity
public class LogRecords {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence_users", allocationSize = 1)
    private long id;
    private String service_name;
    private String service_id_value;
    private String information;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Types type;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;


    public LogRecords() {
        this.setDate_created();
        this.setLast_updated();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_id_value() {
        return service_id_value;
    }

    public void setService_id_value(String service_id_value) {
        this.service_id_value = service_id_value;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    private void setDate_created() {
        ZoneId easternTime = ZoneId.of("America/Bogota");
        this.date_created = LocalDateTime.now(easternTime);;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    private void setLast_updated() {
        this.last_updated = this.getDate_created();
    }



}
