package com.rafpereira.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The list of possible process types.
 * @author rafaeldearaujopereira
 */

@Entity
@Table(name = "process_type")
public class ProcessType {

	public static final ProcessType JAVA = new ProcessType();
	public static final ProcessType FILE_SYSTEM = new ProcessType();
	public static final ProcessType COMMAND_LINE = new ProcessType();
	public static final ProcessType GROUP = new ProcessType();

	static {
		JAVA.setId(1);
		FILE_SYSTEM.setId(2);
		COMMAND_LINE.setId(3);
		GROUP.setId(4);
	}

	/**
	 * Id of the type.
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * Description of the type.
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
