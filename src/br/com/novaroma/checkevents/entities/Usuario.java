/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.checkevents.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigo alves
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario extends BaseEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_usuario")
    private boolean tipoUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "sobrenome")
    private String sobrenome;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private String sexo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Contato contatoUsuario;
     
    @OneToMany(mappedBy = "organizador")
    private Collection<Evento> eventosCriados;
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    private Collection<Evento> usuarioEvento;
    
    

    public Usuario() {
    }

    public Usuario(String login, String senha, boolean tipo) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Contato getContatoUsuario() {
        return contatoUsuario;
    }

    public void setContatos(Contato contatoUsuario) {
        this.contatoUsuario = contatoUsuario;
    }

    /**
     * @return the usuarioEvento
     */
    public Collection<Evento> getUsuarioEvento() {
        return usuarioEvento;
    }

    /**
     * @param usuarioEvento the usuarioEvento to set
     */
    public void setUsuarioEvento(Collection<Evento> usuarioEvento) {
        this.usuarioEvento = usuarioEvento;
    }

    /**
     * @return the eventosCriados
     */
    public Collection<Evento> getEventosCriados() {
        return eventosCriados;
    }

    /**
     * @param eventosCriados the eventosCriados to set
     */
    public void setEventosCriados(Collection<Evento> eventosCriados) {
        this.eventosCriados = eventosCriados;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the tipoUsuario
     */
    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}
