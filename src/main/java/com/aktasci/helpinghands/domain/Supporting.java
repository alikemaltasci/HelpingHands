package com.aktasci.helpinghands.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supporting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long neededSupportId;

	private Long userId;

	private Long amount;

	public Supporting() {

	}

	public Long getNeededSupportId() {
		return neededSupportId;
	}

	public void setNeededSupportId(Long neededSupportId) {
		this.neededSupportId = neededSupportId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Supporting [id=" + id + ", neededSupportId=" + neededSupportId + ", userId=" + userId + ", amount="
				+ amount + "]";
	}

}
