package br.com.eventolivre.service.email;

import br.com.eventolivre.model.Participante;
import java.io.UnsupportedEncodingException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Objetivo com o objetivo de estar criando a mesnagem para a confirmação da inscrição 
 * do participante
 * @author otaviojava
 */
 class ConfirmacaoInscricaoMensagem implements  GerarMensagem{

    private Participante participante;

    ConfirmacaoInscricaoMensagem(Participante participante) {
        this.participante=participante;
    }
    
    @Override
    public Message criarMensagem(Session mailSession)throws UnsupportedEncodingException,MessagingException{
              Message mensagem = new MimeMessage(mailSession);
              mensagem.setSubject(criarAssuntoMensagem());
              mensagem.setText(criarAssuntoMensagem());
              mensagem.setRecipient(Message.RecipientType.TO,new InternetAddress(participante.getEmail(),participante.getNome()));
              return mensagem;
    }
    
    /**
     * Cria o texto que será utilizado tanto no texto quanto no assunto
     * @return 
     */
    private String criarAssuntoMensagem(){
        StringBuilder assunto=new StringBuilder();
        assunto.append("Confirmação de inscrição para o evento: ");
        assunto.append(participante.getEvento().getNome());
        assunto.append(" realizada com sucesso!");
        return assunto.toString();
    }
    
}
