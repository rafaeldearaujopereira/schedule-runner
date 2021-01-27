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
 * A configured parameter, is the value set for a process' parameter as part of
 * an activity.
 * 
 * @author rafaeldearaujopereira
 */

@Entity
@Table(name = "configured_parameter")
public class ConfiguredParameter {

	/** Id of the process. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuredParameterSeqGen")
	@SequenceGenerator(name = "configuredParameterSeqGen", allocationSize = 1, sequenceName = "configured_parameter_seq")
	private Long id;

	/** The activity that "executes" the process that uses the parameter. */
	@ManyToOne
	@JoinColumn(name = "activity_id", referencedColumnName = "id")
	private Activity activity;

	/** The process' parameter. */
	@ManyToOne
	@JoinColumn(name = "process_parameter_id", referencedColumnName = "id")
	private ProcessParameter parameter;

	/** The value of the configured parameter. */
	@Column(name = "parameter_value")
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public ProcessParameter getParameter() {
		return parameter;
	}

	public void setParameter(ProcessParameter parameter) {
		this.parameter = parameter;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
