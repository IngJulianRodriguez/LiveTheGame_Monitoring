package com.livethegame.Monitoring.dto;

import com.livethegame.Monitoring.entities.Types;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel()
public class ServicesUrlResponse {

    @ApiModelProperty(name = "Id", required = true,example = "", value = "")
    private Long id;
    @ApiModelProperty(name = "Nombre del servicio", required = true,example = "", value = "")
    private String name;
    @ApiModelProperty(name = "Url del endpoint test", required = true,example = "", value = "")
    private String url;
    @ApiModelProperty(name = "Activo", required = true,example = "", value = "")
    private boolean active;

    public ServicesUrlResponse(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
