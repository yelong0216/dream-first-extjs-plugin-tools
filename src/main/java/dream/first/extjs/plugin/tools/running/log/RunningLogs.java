package dream.first.extjs.plugin.tools.running.log;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.yelong.commons.io.FileUtilsE;
import org.yelong.commons.io.FilenameUtilsE;
import org.yelong.commons.io.IOUtilsE;
import org.yelong.commons.util.ResourcesUtils;
import org.yelong.support.yaml.YamlProperties;
import org.yelong.support.yaml.YamlWrapper;

/**
 * 运行日志工具类
 */
public final class RunningLogs {

	private RunningLogs() {
	}

	/**
	 * 读取运行日志，返回日志内容
	 * 
	 * @return 运行日志的内容
	 * @throws IOException 流异常
	 */
	public static String readRuningLog() throws IOException {
		File logFile = getRuningLogFile();
		return FileUtils.readFileToString(logFile, IOUtilsE.defaultCharset);

	}

	/**
	 * 获取运行日志文件
	 * 
	 * @return 运行日志的文件
	 */
	public static File getRuningLogFile() {
		return LogFileSupplier.getLogFile();
	}

	@SuppressWarnings("rawtypes")
	private static final class LogFileSupplier {

		private static final String logFilePath;

		static {
			YamlWrapper yamlWrapper = new YamlWrapper();
			YamlProperties yamlProperties = yamlWrapper.load(ResourcesUtils.getResourceAsStream("log4j2.yml"));
			Map<String, Object> sourceMap = yamlProperties.getSourceMap();
			Map configuration = (Map) sourceMap.get("Configuration");
			Map properties = (Map) configuration.get("Properties");
			List property = (List) properties.get("Property");

			String logPath = null;
			String projectName = null;
			for (Object object : property) {
				if (object instanceof Map) {
					Map m = (Map) object;
					Object name = m.get("name");
					if (name.equals("log.path")) {
						logPath = (String) m.get("value");
					}
					if (name.equals("project.name")) {
						projectName = (String) m.get("value");
					}
				}
			}
			logFilePath = FilenameUtilsE.getFilePath(logPath, projectName + ".log");
		}

		public static File getLogFile() {
			return FileUtilsE.getFile(logFilePath);
		}

	}

}
