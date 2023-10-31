package com.example.algafoodapi.di.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
// é possivel criar uma classe para reunir as propriedes de configuração da aplicação
// é necessario criar os getters and setters
@Component
@ConfigurationProperties("notificador.email")
public class NotificadorProperties {
    private String hostServidor;
    private Integer portaServidor;

    public String getHostServidor() {
        return hostServidor;
    }

    public void setHostServidor(String hostServidor) {
        this.hostServidor = hostServidor;
    }

    public Integer getPortaServidor() {
        return portaServidor;
    }

    public void setPortaServidor(Integer portaServidor) {
        this.portaServidor = portaServidor;
    }
}
