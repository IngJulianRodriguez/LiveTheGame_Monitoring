package com.livethegame.Monitoring.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class ServicesUrlUpdateRequest {

    @ApiModelProperty(name = "Nombre del servicio", required = true,example = "MyService", value = "")
    private String name;
    @ApiModelProperty(name = "Url del endpoint test", required = true,example = "http://myservice/test", value = "")
    private String url;
    @ApiModelProperty(name = "Indica si el servicio esta activo", required = false,example = "", value = "")
    private Boolean active;

    public ServicesUrlUpdateRequest(){
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
