package dream.first.extjs.plugin.tools.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import dream.first.extjs.plugin.tools.running.log.controller.RunningLogController;
import dream.first.extjs.plugin.tools.servlet.ToolsResourceServletRegistrationBean;

public class ExtJSPluginToolsRunningConfiguration {

	@Bean
	public RunningLogController runningLogController() {
		return new RunningLogController();
	}

	@Bean
	@ConditionalOnMissingBean
	public ToolsResourceServletRegistrationBean toolsResourceServletRegistrationBean() {
		return new ToolsResourceServletRegistrationBean();
	}
	
}
