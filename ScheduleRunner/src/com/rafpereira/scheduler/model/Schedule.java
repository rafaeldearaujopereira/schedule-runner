package com.rafpereira.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Defines a schedule. 
 * The schedule aggregates the sequence of activities (schedule items)
 * @author rafaeldearaujopereira
 *
 */
public class Schedule {

	/**
	 * Id of the schedule (in the database).
	 */
	@Id
	@Column(name = "id")
	private Long id;

	/**
	 * Name of the schedule.
	 */
	@Column(name = "name")
	private String name;

	/**
	 * Description of the schedule.
	 */
	@Column(name = "description")
	private String description;

	@Column(name = "owner_id")
	private Long ownerId;

	@Column(name = "roleId")
	private Long roleId;

	@ManyToOne
	@JoinColumn(name = "schedule_ownership_id", referencedColumnName = "schedule_ownership_id")
	private ScheduleOwnership ownership;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public ScheduleOwnership getOwnership() {
		return ownership;
	}

	public void setOwnership(ScheduleOwnership ownership) {
		this.ownership = ownership;
	}

}
