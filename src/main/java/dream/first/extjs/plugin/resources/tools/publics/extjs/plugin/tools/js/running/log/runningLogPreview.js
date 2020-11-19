Coe.initialize();
Co.initialize();

Ext.onReady(function() {
	var API = {
			readRunningLog : rootPath + "/extjs/plugin/tools/running/log/readRunningLogByJson",
	};

	var panel = Ext.create("Ext.panel.Panel", {
		layout : "fit",
		dockedItems : [{
			xtype: 'toolbar',
			dock: 'top',
			items: [{
				text: '刷新',
				handler : reloadLog
			}]
		}],
		items : {
			xtype : "textarea",
			id : "logContent",
			allowBlank : true,
			editable : false,
			readOnly : true
		}
	});
	
	Ext.create("Ext.container.Viewport", {
		layout : "fit",
		items : panel
	});
	
	reloadLog();
	
	function reloadLog(){
		Co.request(API.readRunningLog,{},function(result){
			Ext.getCmp("logContent").setValue(result.msg);
		});
	}
	
});