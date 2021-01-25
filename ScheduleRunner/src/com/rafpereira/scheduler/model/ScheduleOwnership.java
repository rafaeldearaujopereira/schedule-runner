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
		PUBLIC.setId(1L);
		PRIVATE.setId(2L);
		ROLE.setId(3L);
	}

	/**
	 * Id of the ownership.
	 */
	@Id
	@Column(name = "id")
	private Long id;

	/**
	 * Description of the ownership.
	 */
	@Column(name = "description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
