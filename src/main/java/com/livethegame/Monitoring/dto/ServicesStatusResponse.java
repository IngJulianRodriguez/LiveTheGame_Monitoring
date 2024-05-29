package com.livethegame.Monitoring.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class ServicesStatusResponse {

    @ApiModelProperty(name = "Id", required = true,example = "", value = "")
    private Long id;
    @ApiModelProperty(name = "Nombre del servicio", required = true,example = "", value = "")
    private String name;
    @ApiModelProperty(name = "Url del endpoint test", required = true,example = "", value = "")
    private String url;
    @ApiModelProperty(name = "Estado del servicio", required = true,example = "", value = "")
    private String status;



    public ServicesStatusResponse(){
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
