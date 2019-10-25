package com.iist.vse900.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ApiModel(value = "")
@Table(name = "Categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@ApiModelProperty("Id danh mục")
	private Long id;
	
	@Column(name = "type")
	@ApiModelProperty("Loại danh mục")
	private String type;

	@Column(name = "code")
	@ApiModelProperty("Mã danh mục")
	private String code;

	@Column(name = "name")
	@ApiModelProperty("Tên danh mục")
	private String name;

	@Column(name = "description")
	@ApiModelProperty("Mô tả")
	private String description;

	@Column(name = "is_active")
	@ApiModelProperty("Trạng thái hoạt động(xóa)")
	private char isActive;

	@Column(name = "created_date")
	@ApiModelProperty("Ngày tạo")
	private Date createdDate;

	@Column(name = "created_by")
	@ApiModelProperty("Ngày sửa")
	private String createdBy;

	@Column(name = "modified_date")
	@ApiModelProperty("Người sửa")
	private String modifiedDate;

	@Column(name = "modified_by")
	@ApiModelProperty("Mô tả")
	private String modifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
