<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String contextPath = request.getContextPath();
%>
<script type="text/javascript" src="<%=contextPath%>/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
    /*------------- 锁定窗口 -------------*/
    var lockWindowFun = function () {
        $.post(
                '<%=contextPath%>/login!userLogout.action',
                function (result) {
                    $("#loginDialog").dialog('open');
                },
                'json'
        );
    };
    /*------------- 锁定窗口 -------------*/

    /*------------- 解锁窗口 -------------*/
    //增加登录按钮
    $("#loginDialog").show().dialog({
        modal: true,
        closable: false,
        iconCls: 'ext-icon-lock_open',
        buttons: [
            {
                id: 'loginBtn',
                text: '登录',
                handler: function () {
                    loginFun();
                }
            }
        ],
        onOpen: function () {
            $("#loginDialog form :input[name='adminInfoVO.passwd']").val('');
            $("form :input").keyup(function (event) {
                if (event.keyCode == 13) {
                    loginFun();
                }
            });
        }
    }).dialog('close');

    //解锁窗口提交
    var loginFun = function () {
        if ($("#loginDialog form").form('validate')) {
            $("#loginBtn").linkbutton('disable');
            $.post(
                    '<%=contextPath%>/login!userLogin.action',
                    $("#loginDialog form").serialize(), function (result) {
                        if (result.success) {
                            $("#loginDialog").dialog('close');
                        } else {
                            $.messager.alert('提示', result.msg, 'error', function () {
                                $("#loginDialog form :input:eq(1)").focus();
                            });
                        }
                        $('#loginBtn').linkbutton('enable');
                    },
                    'json'
            );
        }
    };
    /*------------- 解锁窗口 -------------*/

    /*------------- 注销 -------------*/
    var logoutFun = function () {
        $.post(
                '<%=contextPath%>/userLoginAction!userLogout.action',
                function (result) {
                    location.replace('<%=contextPath%>/');

                },
                'json'
        );
    };
    /*------------- 注销 -------------*/

    /*------------- 修改密码 -------------*/
    $("#passwordDialog").show().dialog({
        modal: true,
        closable: true,
        iconCls: 'ext-icon-lock_edit',
        buttons: [
            {
                text: '修改',
                width: 100,
                handler: function () {
                    if ($("#passwordDialog form").form('validate')) {
                        $.post(
                                '<%=contextPath%>/userLoginAction!updateCurrentUserPassword.action',
                                {
                                    'passwd': $('#password').val()
                                },
                                function (result) {
                                    if (result.success) {
                                        parent.$.messager.confirm('提示', '修改成功，是否重新登录？', function (r) {
                                            if (r) {
                                                logoutFun();
                                            }
                                        });
                                    } else {
                                        $.messager.alert('提示', result.msg, 'info');
                                    }
                                },
                                'json'
                        );
                    }
                }
            }
        ],
        onOpen: function () {
            $("#passwordDialog form :input").val('');
        }
    }).dialog('close');
    /*------------- 修改密码 -------------*/

    /*------------- 操作指南 -------------*/
    $("#playVideo").show().dialog({
        modal: false,
        closable: true
    }).dialog('close');

    /*------------- 下载操作指南 -------------*/
    var downloadfile = function () {
        var url = "<%=contextPath%>/downloadFile.action?path=" + encodeURI("/video/jmfczzn.mp4") +
                "&filename=" + encodeURI("❤爱情公寓❤操作指南.mp4");
        window.location.href = url;
    };

</script>
<!-- Logo -->
<div style="position: absolute; left: 10px; top: 2px;">
    <%--   <img src="<%=contextPath%>/lib/style/images/login/logo2.png" > --%>
    <h1 style="color:white;font-size:20px;">❤爱情公寓❤</h1>
</div>
<!-- 显示欢迎信息 -->
<div id="adminInfoDiv" style="position: absolute; right: 10px; top: 5px; color: white;">
    <s:if test="#session.sysUserInfo != null">
        欢迎您，<s:property value="#session.sysUserInfo.username"/>
    </s:if>
</div>
<!-- 功能菜单 -->
<div style="position: absolute; right: 0px; bottom: 0px;">
    <!-- 	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'ext-icon-rainbow'">
        <font color="#ffffff">更换皮肤</font>
      </a>  -->
    <a href="javascript:void(0);" class="easyui-menubutton"
       data-options="menu:'#layout_north_kzmbMenu',iconCls:'ext-icon-cog'">
        <font color="#ffffff">控制面板</font>
    </a>
</div>

<!-- 皮肤选项 -->
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
    <div onclick="sy.changeTheme('metro-blue');" title="default">默认皮肤</div>
    <div onclick="sy.changeTheme('default');" title="metro-blue">宝石蓝</div>
    <div onclick="sy.changeTheme('bootstrap');" title="bootstrap">经典灰色</div>
    <div onclick="sy.changeTheme('black');" title="black">经典黑色</div>
    <div onclick="sy.changeTheme('ui-cupertino');" title="ui-cupertino">天蓝色</div>
    <div onclick="sy.changeTheme('ui-dark-hive');" title="ui-dark-hive">亮黑色</div>
    <div onclick="sy.changeTheme('ui-pepper-grinder');" title="ui-pepper-grinder">酒红色</div>
    <div onclick="sy.changeTheme('ui-sunny');" title="ui-sunny">阳光色</div>
    <div onclick="sy.changeTheme('metro');" title="metro">白色</div>

    <div onclick="sy.changeTheme('metro-gray');" title="metro-gray">荧光灰</div>
    <div onclick="sy.changeTheme('metro-green');" title="metro-green">荧光绿</div>
    <div onclick="sy.changeTheme('metro-orange');" title="metro-orange">荧光黄</div>
    <div onclick="sy.changeTheme('metro-red');" title="metro-red">荧光粉</div>
</div>

<!-- 控制面板选项 -->
<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
    <div data-options="iconCls:'ext-icon-user_edit'" onclick="$('#passwordDialog').dialog('open');">修改密码</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'ext-icon-door_out'" onclick="logoutFun();">退出系统</div>
    <div class="menu-sep"></div>
    <!-- 在线观看 -->
    <!-- <div data-options="iconCls:'ext-icon-film'" onclick="$('#playVideo').dialog('open');">操作指南</div> -->
    <div data-options="iconCls:'ext-icon-film'" onclick="downloadfile();">操作指南</div>
</div>

<!-- 解锁窗口 -->
<div id="loginDialog" title="解锁登录" style="display: none;">
    <form method="post" class="form" onsubmit="return false;">
        <table class="table">
            <tr>
                <th style="width: 70px;">管理员账号</th>
                <td>
                    <input name="adminInfoVO.useraccno" readonly="readonly"
                           value='<s:property value="#session.sysUserInfo.useraccno"/>'/>
                </td>
            </tr>
            <tr>
                <th>密码</th>
                <td>
                    <input name="adminInfoVO.passwd" type="password" class="easyui-validatebox"
                           data-options="required:true,validType:'length[1,20]',invalidMessage:'密码最长20位'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<!-- 修改密码 -->
<div id="passwordDialog" title="修改密码" style="display: none;">
    <form method="post" class="form" onsubmit="return false;">
        <table class="table">
            <tr>
                <th style="width: 70px;">新密码</th>
                <td>
                    <input id="password" type="password" class="easyui-validatebox"
                           data-options="required:true,validType:'chkCharAndNum[20]'"/>
                </td>
            </tr>
            <tr>
                <th>重复密码</th>
                <td>
                    <input type="password" class="easyui-validatebox"
                           data-options="required:true,validType:'eqPwd[\'#password\']'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<link href="<%=contextPath%>/js/lib/video/video-js.min.css" rel="stylesheet">
<script src="<%=contextPath%>/js/lib/video/video.min.js"></script>
<!-- 操作指南 -->
<div id="playVideo" title="操作指南" style="display: none;">
    <video id="my-player" class="video-js" controls preload="none" width="684" height="384" data-setup='{}'>
        <source src="<%=contextPath%>/video/jmfczzn.mp4" type="video/mp4"></source>
        <source src="<%=contextPath%>/video/jmfczzn.mp4" type="video/webm"></source>
        <source src="<%=contextPath%>/video/jmfczzn.mp4" type="video/ogg"></source>
        <p class="vjs-no-js">请使用支持html5的浏览器</p>
    </video>
</div>