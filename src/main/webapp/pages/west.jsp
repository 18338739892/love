<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String contextPath = request.getContextPath();
%>

<script type="text/javascript" charset="utf-8">
	function openTabInMain(title, menuurl, imgurl) {
		menuurl = '<%=contextPath%>' + "/" + menuurl;
 		var tabs = $("#mainTabs");
		var opts = {
			title : title,
			closable : true,
			iconCls: imgurl,
			content : sy.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>', menuurl),
			border : false,
			fit : true
		};
		if (tabs.tabs('exists', opts.title)) {
			tabs.tabs('select', opts.title);
			var current_tab = $('#mainTabs').tabs('getSelected');
	 		$("#mainTabs").tabs('update',{
	 			tab:current_tab,
	 	options: {
				title : title,
				closable : true,
				iconCls: imgurl,
				content : sy.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>', menuurl),
				border : false,
				fit : true
				}
	 		});
		} else {
			tabs.tabs('add', opts);
		}
 	}
</script>
<div class="easyui-accordion" data-options="border:false" >
	<s:set name="sms" value="sysMenus"></s:set>
	<s:iterator value="sms" var="parentSms">
		<s:if test="#parentSms.parentid == 0">
			<div title="<s:property value="#parentSms.menuname"/>" style="padding:10px;">
				<s:iterator value="sms" var="childrenSms">
					<s:if test="#childrenSms.parentid != 0 && #childrenSms.parentid == #parentSms.id">
	   					<a href="#" class="easyui-linkbutton" style="text-align: left" data-options="plain:true,width:170,iconCls:'<s:property value="#childrenSms.imgurl"/>'"
	   						onClick="openTabInMain('<s:property value="#childrenSms.menuname"/>','<s:property value="#childrenSms.menuurl"/>','<s:property value="#childrenSms.imgurl"/>')"><s:property value="#childrenSms.menuname"/></a>
					</s:if>
				</s:iterator>
			</div>
		</s:if>
	</s:iterator>
</div>
