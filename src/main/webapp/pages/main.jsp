<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<title>❤爱情公寓❤</title>
		<jsp:include page="../pages/support/easyui_support.jsp"></jsp:include>
		<script type="text/javascript">
			var mainMenu;
			var mainTabs;
		
			$(function() {
				/*-------------------- 上下左右刷新关闭工具start --------------------*/
				mainTabs = $("#mainTabs").tabs({
					fit : true,
					border : false,
					tools : [ 
						{
							text : '刷新',
							iconCls : 'ext-icon-arrow_refresh',
							handler : function() {
								var panel = mainTabs.tabs('getSelected').panel('panel');
								var frame = panel.find('iframe');
								try {
									if (frame.length > 0) {
										for (var i = 0; i < frame.length; i++) {
											frame[i].contentWindow.document.write('');
											frame[i].contentWindow.close();
											frame[i].src = frame[i].src;
										}
										if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
											try {
												CollectGarbage();
											} catch (e) {
											}
										}
									}
								} catch (e) {
								}
							}
						},
						{
							text : '关闭',
							iconCls : 'ext-icon-cross',
							handler : function() {
								var index = mainTabs.tabs('getTabIndex', mainTabs.tabs('getSelected'));
								var tab = mainTabs.tabs('getTab', index);
								if (tab.panel('options').closable) {
									mainTabs.tabs('close', index);
								} else {
									$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');
								}
							}
						} 
					]
				});
				/*-------------------- 上下左右刷新关闭工具end --------------------*/
				
				$(".tabs-header").bind('contextmenu',function(e){         
					e.preventDefault();         
					$('#rcmenu').menu('show', {             
						left: e.pageX,             
						top: e.pageY         
						});     
					});     
				//关闭当前标签页     
				$("#closecur").bind("click",function(){         
					var tab = mainTabs.tabs('getSelected');         
					var index = mainTabs.tabs('getTabIndex',tab);         
					if (tab.panel('options').closable) {
						mainTabs.tabs('close', index);
					} else {
						$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');
					}     
					});     
				//关闭所有标签页    
				$("#closeall").bind("click",function(){         
					var tablist = mainTabs.tabs('tabs');         
					for(var i=tablist.length-1;i>=0;i--){     
						if(tablist[i].panel('options').closable==false)continue;
						mainTabs.tabs('close',i);         
						}     
					});     
				//关闭非当前标签页（先关闭右侧，再关闭左侧）     
				$("#closeother").bind("click",function(){         
					var tablist = mainTabs.tabs('tabs');         
					var tab = mainTabs.tabs('getSelected');         
					var index = mainTabs.tabs('getTabIndex',tab);         
					for(var i=tablist.length-1;i>index;i--){       
						if(tablist[i].panel('options').closable==false)continue;
						mainTabs.tabs('close',i);         
						}         
					var num = index-1;         
					for(var i=num;i>=0;i--){             
						if(mainTabs.tabs('tabs')[i].panel('options').closable==false)continue;
						mainTabs.tabs('close',i);         
						}     
					});     
				//关闭当前标签页右侧标签页     
				$("#closeright").bind("click",function(){         
					var tablist = mainTabs.tabs('tabs');         
					var tab = mainTabs.tabs('getSelected');         
					var index = mainTabs.tabs('getTabIndex',tab);         
					for(var i=tablist.length-1;i>index;i--){    
						if(tablist[i].panel('options').closable==false)continue;
						mainTabs.tabs('close',i);         
						}     
					});     
				//关闭当前标签页左侧标签页    
				$("#closeleft").bind("click",function(){         
					var tab = mainTabs.tabs('getSelected');         
					var index = mainTabs.tabs('getTabIndex',tab);         
					var num = index-1;         
					for(var i=0;i<=num;i++){        
						if(mainTabs.tabs('tabs')[i].panel('options').closable==false)continue;
						mainTabs.tabs('close',i);         
						}     
					}); 


				
			});
		</script>
	</head>
	<body id="mainLayout" class="easyui-layout">
		<div data-options="region:'north',href:'<%=contextPath%>/sysMenuAction!openNorth.action'" style="height: 60px; overflow: hidden; background-color: #1e95cd; background-image:url('<%=contextPath%>/image/mainback/top.bk_03.png'); background-repeat: no-repeat;" class="logo"></div>
		<div data-options="region:'west',href:'<%=contextPath%>/sysMenuAction!queryMenu.action',split:true" title="导航" style="width: 200px"></div>
		<div data-options="region:'center'" style="overflow: hidden;">
			<div id="mainTabs">
				<div title="欢迎页面" data-options="">
					<iframe src="<%=contextPath%>/pages/welcome.jsp" allowTransparency="true" scrolling="no" style="border: 0; width: 100%; height: 99% " id="mainIframe" frameBorder="0"></iframe>
				</div>
			</div>
		</div>
		<div data-options="region:'south',href:'<%=contextPath%>/pages/south.jsp',border:false" style="height: 30px; overflow: hidden;"></div>
		
		<div id="mainTabDiv" data-options="region:'center'" style="background: #eee; border: none;"></div>
		<!-- 右键关闭 -->
		 <div id="rcmenu" class="easyui-menu" style="display: none;">     
		 <div data-options="iconCls:'icon-cancel'" id="closecur">关闭     </div>    
		 <div class="menu-sep"></div> 
		 <div id="closeall">关闭全部</div>
		 <div class="menu-sep"></div>
         <div id="closeother">关闭其他</div>
         <div class="menu-sep"></div>     
         <div id="closeright">关闭右侧标签页 </div>  
         <div class="menu-sep"></div>   
         <div id="closeleft">关闭左侧标签页 </div>
         </div> 

		
	</body>
	<style type="text/css">
	#tip {
		position: absolute;
		right: 0px;
		bottom: 0px;
		height: 0px;
		width: 260px;
		border: 1px solid #CCCCCC;
		background-color: #eeeeee;
		padding: 1px;
		overflow: hidden;
		display: none;
		font-size: 12px;
		z-index: 10;
	}
	
	#tip p {
		padding: 6px;
	}
	
	#tip h1,#detail h1 {
		font-size: 14px;
		height: 25px;
		line-height: 25px;
		background-color: #E0ECFF;
		color: black;
		padding: 0px 3px 0px 3px;
		filter: Alpha(Opacity = 100);
	}
	
	#tip h1 a,#detail h1 a {
		float: right;
		text-decoration: none;
		color: black;
	}
</style> 
<script type="text/javascript">
	var handle; 
	function start() { 
		var obj = document.getElementById("tip"); 
		if (parseInt(obj.style.height)==0){ 
			obj.style.display="block"; 
			handle = setInterval("changeH('up')",20); 
		}else { 
			handle = setInterval("changeH('down')",20) 
		} 
	} 
	function changeH(str){ 
		var obj=document.all?document.all["tip"] : document.getElementById("tip"); 
		if(str=="up"){ 
			if (parseInt(obj.style.height)>150) 
				clearInterval(handle); 
			else 
				obj.style.height=(parseInt(obj.style.height)+8).toString()+"px"; 
		} 
		if(str=="down"){ 
			if (parseInt(obj.style.height)<8){ 
				clearInterval(handle); 
				obj.style.display="none"; 
			} 
		else 
			obj.style.height=(parseInt(obj.style.height)-8).toString()+"px"; 
		} 
	} 
</script>
</html>