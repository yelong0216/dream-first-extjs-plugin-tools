package dream.first.extjs.plugin.tools.running.log.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yelong.support.servlet.resource.response.ResourceResponseException;

import dream.first.extjs.base.controller.DFBaseExtJSController;
import dream.first.extjs.base.login.DFLoginValidate;
import dream.first.extjs.base.msg.DFEJsonMsg;
import dream.first.extjs.plugin.tools.ExtJSPluginTools;
import dream.first.extjs.plugin.tools.running.log.RunningLogs;

@Controller
@RequestMapping({ "runninglog", "extjs/plugin/tools/running/log" })
@DFLoginValidate(validate = false)
public class RunningLogController extends DFBaseExtJSController {

	@ResponseBody
	@RequestMapping("index")
	public void index() throws ResourceResponseException, IOException {
		responseHtml(ExtJSPluginTools.RESOURCE_PRIVATES_PACKAGE,
				ExtJSPluginTools.RESOURCE_PREFIX + "/html/running/log/runningLogPreview.html");
	}

	@ResponseBody
	@RequestMapping("readRunningLog")
	public String readRunningLog() throws IOException {
		return RunningLogs.readRuningLog();
	}

	@ResponseBody
	@RequestMapping("readRunningLogByJson")
	public String readRunningLogByJson() throws IOException {
		return toJson(new DFEJsonMsg(true, RunningLogs.readRuningLog()));
	}
}
