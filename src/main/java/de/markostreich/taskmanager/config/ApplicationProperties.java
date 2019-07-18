package de.markostreich.taskmanager.config;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;

@Getter
public class ApplicationProperties {

	@Value("${persistence.filesystem.path}")
	private String filesystemPath;
}
