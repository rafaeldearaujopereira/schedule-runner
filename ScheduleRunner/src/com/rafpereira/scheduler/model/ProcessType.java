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

	/** Java process. */
	public static final ProcessType JAVA = new ProcessType();

	/** File system process. */
	public static final ProcessType FILE_SYSTEM = new ProcessType();

	/** Command line process. */
	public static final ProcessType COMMAND_LINE = new ProcessType();

	/** Group (abstract) process. */
	public static final ProcessType GROUP = new ProcessType();

	static {
		JAVA.setId(1L);
		FILE_SYSTEM.setId(2L);
		COMMAND_LINE.setId(3L);
		GROUP.setId(4L);
	}

	/** Id of the type. */
	@Id
	@Column(name = "id")
	private Long id;

	/** Description of the type. */
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
