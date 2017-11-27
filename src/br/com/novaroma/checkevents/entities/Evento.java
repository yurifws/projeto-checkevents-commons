/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.checkevents.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rodrigo alves
 */
@Entity
@Table(name = "evento")
@XmlRootElement
public class Evento extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Contato contatoEvento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "localizacao_id")
    private Integer localizacaoId;
    @Column(name = "endereco_id")
    private Integer enderecoId;
    @Column(name = "tipo_evento_id")
    private Integer tipoEventoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Endereco endereco;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Localizacao localizacao;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TipoEvento tipoEvento;
    @ManyToMany(mappedBy = "evento")
    private Collection<Usuario> usuarios;
    
    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Usuario organizador;

    public Evento() {
    }

    public Evento(String descricao, Date datainicio, Date datatermino) {
        this.descricao = descricao;
        this.dataInicio = datainicio;
        this.dataTermino = datatermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getLocalizacaoId() {
        return localizacaoId;
    }

    public void setLocalizacaoId(Integer localizacaoId) {
        this.localizacaoId = localizacaoId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Integer getTipoEventoId() {
        return tipoEventoId;
    }

    public void setTipoEventoId(Integer tipoEventoId) {
        this.tipoEventoId = tipoEventoId;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    
    @Override
    public String toString() {
        return "br.com.novaroma.checkevents.entities.Evento[ id=" + this.getId() + " ]";
    }
    
    public Contato getContatoEvento() {
        return contatoEvento;
    }

    public void setContatoEvento(Contato contatoEvento) {
        this.contatoEvento = contatoEvento;
    }

    /**
     * @return the usuarios
     */
    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the organizador
     */
    public Usuario getOrganizador() {
        return organizador;
    }

    /**
     * @param organizador the organizador to set
     */
    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}
