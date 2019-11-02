package de.markostreich.taskmanager.persistence.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.markostreich.taskmanager.config.ApplicationProperties;
import de.markostreich.taskmanager.entity.Task;
import de.markostreich.taskmanager.persistence.TaskPersistence;

@Service
public class TaskPersistenceFileSystem implements TaskPersistence {

	@Autowired
	private ApplicationProperties applicationProperties;

	/**
	 * All files ({@link Path}) in the storage directory set by an application
	 * property.
	 */
	private List<Path> allFiles;

	@Override
	public Task loadTask(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findTask(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getOpenTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getClosedTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveTask(Task task) {
		final File path = new File(applicationProperties.getFileSystemPath());
		if (!path.exists())
			try {
				FileUtils.forceMkdir(path);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		final String taskNameOS = task.getId() + "_" + task.getTitle().replace(' ', '_');
		final File taskFile = new File(applicationProperties.getFileSystemPath() + taskNameOS + ".xml");
		final JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Task.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(task, taskFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public int getNextId() {
		int nextId = 0;
		if (allFiles == null) {
			allFiles = getAllFiles();
		}
		if (allFiles != null && !allFiles.isEmpty()) {
			final JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(Task.class);
				Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
				nextId = allFiles.stream().map(path -> {
					Task task = new Task();
					task.setId(0);
					try {
						task = (Task) jaxbMarshaller.unmarshal(new File(path.toString()));
					} catch (JAXBException e) {
						e.printStackTrace();
					}
					return task;
				}).max(Comparator.comparingInt(Task::getId)).map(Task::getId).orElse(0);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		return ++nextId;
	}

	private List<Path> getAllFiles() {
		List<Path> allFiles = new ArrayList<>();
		final File path = new File(applicationProperties.getFileSystemPath());
		if (path.exists()) {
			try {
				allFiles = Files.walk(Paths.get(path.getAbsolutePath())).filter(Files::isRegularFile)
						.collect(Collectors.toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return allFiles;
	}

}
