package com.livethegame.Monitoring.dto;

import com.livethegame.Monitoring.entities.Types;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@ApiModel()
public class LogRecordsResponse {

    @ApiModelProperty(name = "Id", required = true,example = "", value = "")
    private Long id;
    @ApiModelProperty(name = "Nombre del servicio", required = true,example = "", value = "")
    private String service_name;
    @ApiModelProperty(name = "Id de transaccion", required = true,example = "", value = "")
    private String service_id_value;
    @ApiModelProperty(name = "Informacion", required = true,example = "", value = "")
    private String information;
    @ApiModelProperty(name = "Tipo de log", required = true,example = "", value = "")
    private Types type;
    @ApiModelProperty(name = "Fecha creacion", required = true,example = "", value = "")
    private LocalDateTime date_created;

    public LogRecordsResponse(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getType() {
        return type.getName();
    }

    public void setType(Types type) {
        this.type = type;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }
}
