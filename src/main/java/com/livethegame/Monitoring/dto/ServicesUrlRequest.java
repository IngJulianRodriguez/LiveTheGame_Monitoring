package com.livethegame.Monitoring.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class ServicesUrlRequest {

    @ApiModelProperty(name = "Nombre del servicio", required = true,example = "MyService", value = "")
    private String name;
    @ApiModelProperty(name = "Url del endpoint test", required = true,example = "http://myservice/test", value = "")
    private String url;

    public ServicesUrlRequest(){
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
}
