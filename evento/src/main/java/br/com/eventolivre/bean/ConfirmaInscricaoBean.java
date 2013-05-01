package br.com.eventolivre.bean;

import br.com.eventolivre.model.Participante;
import br.com.eventolivre.service.ParticipanteService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author otaviojava
 */
@ManagedBean
@ViewScoped
public class ConfirmaInscricaoBean implements  Serializable{
    
    private Long codigoEvento;
    
    private List<Participante> participantes;
    
    private Participante participante;
    
    @Inject
    private ParticipanteService participanteService;

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participanteSelecionado) {
        this.participante = participanteSelecionado;
    }
    
    
    
    public void presente(){
        participante=participanteService.marcarPresente(participante.getId());
        criarMensagemSucesso();  
        atualizarEvento();
    }

    public Long getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(Long codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    
    
    @Inject
    public void init(){
        codigoEvento=2l;
        atualizarEvento();
    }

    /**
     * Cria a mensagem de sucesso para edição do participante
     */
    private void criarMensagemSucesso() {
        FacesContext context = FacesContext.getCurrentInstance();            
        StringBuilder mensagem=new StringBuilder();
        mensagem.append("Modificado status do ");
        mensagem.append(participante.getNome());
        mensagem.append(" para ");
        mensagem.append(participante.getStatus());
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Realizado", mensagem.toString()));
    }

    /**
     * Atualiza a lista de participantes a partir do evento selecionado
     */
    public void atualizarEvento() {
        participantes=participanteService.buscarEvento(codigoEvento);
    }
    
    public void gerarCertificado(){
    participanteService.gerarCertificados(codigoEvento);
    }
}
