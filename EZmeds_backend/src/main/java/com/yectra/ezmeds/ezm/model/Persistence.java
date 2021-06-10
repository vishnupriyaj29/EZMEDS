package com.yectra.ezmeds.ezm.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

public abstract class Persistence {
	
	@Id
	private String id;
	
	@CreatedDate
	protected LocalDateTime createdTime;
	
	@LastModifiedDate
	protected LocalDateTime updatedTime;
	
	@CreatedBy
    protected String createdBy;
	
	@LastModifiedBy
    protected String updatedBy;

	public Persistence() {
		super();
	}

	public Persistence(String id, LocalDateTime createdTime, LocalDateTime updatedTime, String createdBy,
			String updatedBy) {
		super();
		this.id = id;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Persistence [id=" + id + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
	
}
