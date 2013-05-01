package br.com.eventolivre.model.vo;

import br.com.eventolivre.model.Participante;
import java.io.File;
import java.io.Serializable;

/**
 * Classe que contém as informações dos certificados
 * @author otaviojava
 */
public class CertificadoVO implements  Serializable{
    
    private String nome;
    
    private String email;
    
    private Long codigoParticipante;
    
    private File certificado;

    private String assunto;
    
    private String mensagem;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCodigoParticipante() {
        return codigoParticipante;
    }

    public void setCodigoParticipante(Long codigoParticipante) {
        this.codigoParticipante = codigoParticipante;
    }

    public File getCertificado() {
        return certificado;
    }

    public void setCertificado(File certificado) {
        this.certificado = certificado;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    public CertificadoVO(Participante participante,File certificado){
        this.codigoParticipante=participante.getId();
        this.email=participante.getEmail();
        this.nome=participante.getNome();
        this.certificado=certificado;
        this.assunto="Certificado de participação do Evento: ".concat(participante.getEvento().getNome());
        this.mensagem="Segue em anexo o seu comprovante do evento".concat(participante.getEvento().getNome());
    }
    
    
}
