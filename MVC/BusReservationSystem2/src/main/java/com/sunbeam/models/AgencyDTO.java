package com.sunbeam.models;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Agency;

@Component
public class AgencyDTO {
	private int agencyId;
	private String name;
	private String ownerName;
	private String email;
	private String password;

	public AgencyDTO() {
		// TODO Auto-generated constructor stub
	}

	public AgencyDTO(int agencyId, String name, String ownerName, String email, String password) {
		this.agencyId = agencyId;
		this.name = name;
		this.ownerName = ownerName;
		this.email = email;
		this.password = password;
	}

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AgencyDTO [agencyId=" + agencyId + ", name=" + name + ", ownerName=" + ownerName + ", email=" + email
				+ ", password=" + password + "]";
	}

	public AgencyDTO fromEntity(Agency entity) {
		AgencyDTO dto = new AgencyDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
