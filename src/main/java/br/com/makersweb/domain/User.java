/**
 * 
 */
package br.com.makersweb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author anderson.aristides
 */
@Entity
@Table(name = "mw_user")
public class User extends DefaultDomain implements Serializable {

	private static final long serialVersionUID = 328210117701911461L;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "nome", nullable = false)
	private String nome;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "email", nullable = false)
	@Email
	private String email;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "senha", nullable = false, length = 256)
	@ColumnTransformer(write = "SHA2(?, 256)")
	private String senha;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "senha_code", nullable = false)
	private String code;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "enabled", nullable = false)
	private Boolean enabled;

	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Profile profile;

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
