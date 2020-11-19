package dream.first.extjs.plugin.tools.servlet;

import org.yelong.support.servlet.resource.ResourceServlet;
import org.yelong.support.servlet.resource.response.ResourceResponseHandler;
import org.yelong.support.spring.boot.servlet.resource.ResourceServletRegistrationBean;

import dream.first.extjs.plugin.tools.servlet.ToolsResourceServletRegistrationBean.ToolsResourceServlet;

public class ToolsResourceServletRegistrationBean extends ResourceServletRegistrationBean<ToolsResourceServlet> {

	public static final String urlPrefix = "/resources/extjs/plugin/tools";

	public static final String resourceRootPath = "/dream/first/extjs/plugin/resources/tools/publics/extjs/plugin/tools";

	public ToolsResourceServletRegistrationBean() {
		this(urlPrefix);
	}

	public ToolsResourceServletRegistrationBean(String urlPrefix) {
		this(urlPrefix, resourceRootPath);
	}

	public ToolsResourceServletRegistrationBean(String urlPrefix, String resourceRootPath) {
		super(urlPrefix, resourceRootPath, new ToolsResourceServlet());
	}

	public static final class ToolsResourceServlet extends ResourceServlet {

		private static final long serialVersionUID = -454745587938652439L;

		public ToolsResourceServlet() {
		}

		public ToolsResourceServlet(ResourceResponseHandler resourceResponseHandler) {
			super(resourceResponseHandler);
		}

	}

}
