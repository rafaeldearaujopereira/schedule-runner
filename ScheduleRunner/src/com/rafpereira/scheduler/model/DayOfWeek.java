package com.rafpereira.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The days of week (I know, it is a bit stupid, but I think it will be needed somehow, filtering of reporting schedules).
 * It uses the same values as Calendar.DAY_OF_WEEK constants.
 * @author rafaeldearaujopereira
 */

@Entity
@Table(name = "day_of_week")
public class DayOfWeek {

	/** Sunday. */
	public static final DayOfWeek SUNDAY = new DayOfWeek();

	/** Monday. */
	public static final DayOfWeek MONDAY = new DayOfWeek();

	/** Tuesday. */
	public static final DayOfWeek TUESDAY = new DayOfWeek();

	/** Wednesday. */
	public static final DayOfWeek WEDNESDAY = new DayOfWeek();

	/** Thursday. */
	public static final DayOfWeek THURSDAY = new DayOfWeek();

	/** Friday. */
	public static final DayOfWeek FRIDAY = new DayOfWeek();

	/** Saturday. */
	public static final DayOfWeek SATURDAY = new DayOfWeek();

	static {
		SUNDAY.setId(1L);
		MONDAY.setId(2L);
		TUESDAY.setId(3L);
		WEDNESDAY.setId(4L);
		THURSDAY.setId(5L);
		FRIDAY.setId(6L);
		SATURDAY.setId(7L);
	}

	/** Id. */
	@Id
	@Column(name = "id")
	private Long id;

	/** Description. */
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
