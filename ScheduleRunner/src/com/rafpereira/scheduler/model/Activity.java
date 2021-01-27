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
 * An activity is a command (or a group of commands) set in a schedule. For
 * example, if a process is a "copy files to a directory", an activity will be:
 * every single work day, at 08:00, copy files from directory X to directory Y.
 * 
 * @author rafaeldearaujopereira
 */

@Entity
@Table(name = "activity")
public class Activity {

	/** Id of the process. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activitySeqGen")
	@SequenceGenerator(name = "activitySeqGen", allocationSize = 1, sequenceName = "activity_seq")
	private Long id;

	/** Name of the process. */
	@Column(name = "name")
	private String name;

	/** Description of the process. */
	@Column(name = "description")
	private String description;

	/** The schedule that "owns" the activity. */
	@ManyToOne
	@JoinColumn(name = "schedule_id", referencedColumnName = "id")
	private Schedule schedule;

	/** The process that is executed in the activity. */
	@ManyToOne
	@JoinColumn(name = "process_id", referencedColumnName = "id")
	private Process process;

	/** Start time. (Using string to comply with different RDBMS) */
	@Column(name = "start_time")
	private String startTime;

	/** End time. (Using string to comply with different RDBMS) */
	@Column(name = "end_time")
	private String endTime;

	/** Repeat interval (in milliseconds). */
	@Column(name = "repeat_interval")
	private Long repeatInterval;
	
	
	/** The list of activities that must be completed in order to execute the current one (dependencies). */
	@Transient
	private List<Activity> dependencies = new ArrayList<>();

	/** The parameters set for the process behalf this activity. */
	@Transient
	private List<ConfiguredParameter> parameters = new ArrayList<>();

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

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Long getRepeatInterval() {
		return repeatInterval;
	}

	public void setRepeatInterval(Long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public List<Activity> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Activity> dependencies) {
		this.dependencies = dependencies;
	}

	public List<ConfiguredParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<ConfiguredParameter> parameters) {
		this.parameters = parameters;
	}

}
