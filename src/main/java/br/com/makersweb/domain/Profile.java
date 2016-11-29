/**
 * 
 */
package br.com.makersweb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author anderson.aristides
 */
@Entity
@Table(name = "mw_profile", uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
public class Profile extends DefaultDomain implements Serializable {

	private static final long serialVersionUID = -5897199907807086301L;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "nome", nullable = false)
	private String nome;

	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "mw_profile_role", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "profile_id", nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<Role>();

	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
	private Set<User> users = new HashSet<User>();

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
