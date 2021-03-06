package de.markostreich.taskmanager.persistence;

import java.util.List;
import java.util.Optional;

import de.markostreich.taskmanager.entity.Task;

/**
 * Persistence interface for {@link Task}s.
 * 
 * @author markostreich
 *
 */
public interface TaskPersistence {

	/**
	 * Loads an {@link Optional}<{@link Task}> by its id.
	 * 
	 * @param id {@link String} - Id of a {@link Task} to load.
	 * @return  {@link Optional}<{@link Task}> - Has a value if one is marked with the id.
	 */
	public Optional<Task> loadTask(final String id);

	/**
	 * Searches in all fields of all {@link Task}s for a given {@link String}.
	 * 
	 * @param searchString {@link String} - Text to search in all fields of all
	 *                     {@link Task}s.
	 * @return List&lt;{@link Task}&gt; - List of {@link Task}s that contain the
	 *         given {@link String}.
	 */
	public List<Task> findTask(final String searchString);

	/**
	 * Returns a List of all reachable {@link Task}s.
	 * 
	 * @return List&lt;{@link Task}&gt; - List of all reachable Tasks.
	 */
	public List<Task> getAllTasks();
	
	/**
	 * Returns a List of all open {@link Task}s.
	 * 
	 * @return List&lt;{@link Task}&gt; - List of all open Tasks.
	 */
	public List<Task> getOpenTasks();
	
	/**
	 * Returns a List of all closed {@link Task}s.
	 * 
	 * @return List&lt;{@link Task}&gt; - List of all closed Tasks.
	 */
	public List<Task> getClosedTasks();

	/**
	 * Makes a {@link Task} persistent.
	 * 
	 * @param task {@link Task} - {@link Task} to save.
	 * @return boolean - true if saving procedure was successful.
	 */
	public boolean saveTask(final Task task);
	
	/**
	 * Returns the next useable Id für a new task.
	 * 
	 * @return int - the next usable Iid.
	 */
	public int getNextId();
}
