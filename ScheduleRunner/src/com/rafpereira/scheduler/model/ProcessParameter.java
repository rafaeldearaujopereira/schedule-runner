package com.rafpereira.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * A parameter of a process.
 * 
 * @author rafaeldearaujopereira
 */

@Entity
@Table(name = "process_parameter")
public class ProcessParameter {

	/** Id of the parameter. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "processParameterSeqGen")
	@SequenceGenerator(name = "processParameterSeqGen", allocationSize = 1, sequenceName = "process_parameter_seq")
	private Long id;

	/** Name of the parameter. */
	@Column(name = "name")
	private String name;

	/** Description of the parameter. */
	@Column(name = "description")
	private String description;

	/** The default value of the parameter. */
	@Column(name = "default_value")
	private String defaultValue;

	/** The process. */
	@ManyToOne
	@JoinColumn(name = "process_id", referencedColumnName = "id")
	private Process process;

	/** The parameter must be informed when true. */
	@Column(name = "required")
	private Boolean required;

	/** The parameter is editable when true. */
	@Column(name = "editable")
	private Boolean editable;

	/** The parameter allows multiple values when true. */
	@Column(name = "multiple")
	private Boolean multiple;

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

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

}
