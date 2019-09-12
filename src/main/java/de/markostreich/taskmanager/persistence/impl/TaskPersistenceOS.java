package de.markostreich.taskmanager.persistence.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import de.markostreich.taskmanager.config.ApplicationProperties;
import de.markostreich.taskmanager.entity.Task;
import de.markostreich.taskmanager.persistence.TaskPersistence;

@Service
public class TaskPersistenceOS implements TaskPersistence {

	@Autowired
	private ApplicationProperties applicationProperties;
	
    @Autowired
    private Environment env;
	
	@Value("${persistence.filesystem.path:task}")
	private String fileSystemPath;

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
//		final File path = new File(env.getProperty("persistence.filesystem.path"));
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

}
