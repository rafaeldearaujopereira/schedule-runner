package com.rafpereira.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines the ownership of a given schedule. The ownership defines who can run,
 * and change the configuration of a schedule.
 * 
 * @author rafaeldearaujopereira
 */

@Entity
@Table(name = "schedule_ownership")
public class ScheduleOwnership {

	public static final ScheduleOwnership PUBLIC = new ScheduleOwnership();
	public static final ScheduleOwnership PRIVATE = new ScheduleOwnership();
	public static final ScheduleOwnership ROLE = new ScheduleOwnership();

	static {
		PUBLIC.setId(1);
		PRIVATE.setId(2);
		ROLE.setId(3);
	}

	/**
	 * Id of the ownership.
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * Description of the ownership.
	 */
	@Column(name = "description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
