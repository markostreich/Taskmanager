package de.markostreich.taskmanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.Getter;

@Getter
@Service
public class ApplicationProperties {

	@Value("${persistence.filesystem.path:tasks}")
	@Getter(AccessLevel.NONE)
	private String fileSystemPath;

	public String getFileSystemPath() {
		if (fileSystemPath.endsWith("/"))
			return fileSystemPath;
		return fileSystemPath + "/";

	}
	
	@Bean
	public ApplicationProperties configure() {
		return new ApplicationProperties();
	}
}
