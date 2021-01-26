package com.rafpereira.scheduler.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * A process, a command or an executable unit of logic.
 * @author rafaeldearaujopereira
 */

@Entity
@Table(name = "process")
public class Process {

	/** Id of the process. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "processSeqGen")
	@SequenceGenerator(name = "processSeqGen", allocationSize = 1, sequenceName = "process_seq")
	private Long id;

	/** Name of the process. */
	@Column(name = "name")
	private String name;

	/** Description of the process. */
	@Column(name = "description")
	private String description;

	/** The type of the process. */
	@ManyToOne
	@JoinColumn(name = "process_type_id", referencedColumnName = "id")
	private ProcessType type;

	/** The parent process (when exists). */
	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	private Process parent;

	/** The children processes of the process (group processes). */
	@Transient
	private List<Process> children = new ArrayList<>();

	/** The parameters of the process. */
	@Transient
	private List<ProcessParameter> parameters = new ArrayList<>();

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

	public ProcessType getType() {
		return type;
	}

	public void setType(ProcessType type) {
		this.type = type;
	}

	public Process getParent() {
		return parent;
	}

	public void setParent(Process parent) {
		this.parent = parent;
	}

	public List<Process> getChildren() {
		return children;
	}

	public void setChildren(List<Process> children) {
		this.children = children;
	}

	public List<ProcessParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<ProcessParameter> parameters) {
		this.parameters = parameters;
	}

}
