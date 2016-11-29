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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author anderson.aristides
 */
@Entity
@Table(name = "mw_role")
public class Role extends DefaultDomain implements Serializable {

	private static final long serialVersionUID = 6695475997837986006L;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "role", nullable = false)
	private String role;

	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "mw_profile_role", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "profile_id", nullable = false, updatable = false) })
	private Set<Profile> profiles = new HashSet<Profile>();

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the profiles
	 */
	public Set<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles
	 *            the profiles to set
	 */
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

}
