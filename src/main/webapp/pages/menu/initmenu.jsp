<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String contextPath = request.getContextPath();
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>初始化菜单</title>
    <jsp:include page="/pages/support/easyui_support.jsp"></jsp:include>
</head>
<body>
<form name="form1" method="post" id="form1" action="" enctype="multipart/form-data">
    <input type="hidden" id="userid" name="userid" value="<s:property value="#session.user.id"/>"/>
    <!-- 操作员id -->
    <table>
        <tr>
            <td>
                <!-- 竖向分割线 -->
                <div class="datagrid-btn-separator"></div>
            </td>
            <td><a id="refresh" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">增加菜单</a>
                <a id="repflag" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'">菜单管理</a>
            </td>
        </tr>
    </table>
    <!-- 横向分割线 -->
    <div class="datagrid-toolbar"></div>


    <%--父菜单创建--%>
    <div>
        <table>
            <tr>
                <td height="30px" align="center">
                    菜单名称:
                </td>
                <td>
                    <input type="text" id="menuname" name="sysMenu.menuname">
                </td>
                <td height="30px" align="center">
                    菜单地址:
                </td>
                <td>
                    <input type="text" id="menuurl" name="sysMenu.menuurl">
                </td>
            </tr>
            <tr>
                <td height="30px" align="center">
                    菜单状态:
                </td>
                <td>
                    <select class="easyui-validatebox"
                            style="height: 22px" id="status" name="sysMenu.status">
                        <option value="-1" selected="selected">---请选择---</option>
                        <option value="0">关闭</option>
                        <option value="1">开启</option>
                    </select>
                </td>
                <td height="30px" align="center">
                    是否父节点:
                </td>
                <td width="100px">
                    <select class="easyui-validatebox"
                            style="width:inherit" id="plevel" name="sysMenu.plevel" onchange="closeMenuUrl()">
                        <option value="-1" selected="selected">---请选择---</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </td>
            </tr>
            <tr id="parentmenu" style="display: none">
                <td height="30px" align="center">
                    父级菜单:
                </td>
                <td>
                    <select class="easyui-validatebox"
                            style="height: 22px" id="parentid" name="sysMenu.parentid">
                        <option value="-1" selected="selected">---请选择---</option>
                        <s:iterator value="#request.dictionary.userType" id="dd">
                            <option value='<s:property value="datavalue"/>'><s:property value="dataname"/></option>
                        </s:iterator>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><a style="width: 70px;float: inherit"
                       class="easyui-linkbutton" id="savemenubutton"
                       data-options="iconCls:'icon-save',plain:false">
                    <font color="black" style="display: block; text-align:center">保&nbsp;&nbsp;存</font></a>
                </td>
            </tr>
        </table>


    </div>


</form>

<script type="text/javascript">
    /*jquery的使用*/
    $(document).ready(function () {

        /*进入提示*/
        /*初始化操作*/
        $.messager.confirm('知晓', '菜单初始化只会在管理员用户初始创建没有菜单时，进行的一种初始化操作，用户只可一次性添加完菜单，不可以多次操作。下次将不再显示。', function (r) {
        });


        //--------------------

        $("#savemenubutton").click(function () {
            var userid = $("#userid").val();
            var menuname = $("#menuname").val();
            var menuurl = $("#menuurl").val();
            var status = $("#status").val();
            var plevel = $("#plevel").val();

            if (menuname == null || menuname.length <= 0) {
                $.messager.alert("提示", "菜单名称不能为空", "error");
                return;
            }

            if (status == null || status.length <= 0) {
                $.messager.alert("提示", "菜单状态不能为空", "error");
                return;
            }

            if (plevel == null || plevel.length <= 0) {
                $.messager.alert("提示", "菜单是否父类不能为空", "error");
                return;
            }

            if (status == "-1") {
                $.messager.alert("提示", "请选择菜单状态", "error");
                return;
            }

            if (plevel == "-1") {
                $.messager.alert("提示", "请选择是否父菜单", "error");
                return;
            }

            if (!verifyMneuName(menuname, userid)) {
                $.messager.alert("提示", "菜单已经存在，请重试", "error");
                return;
            }


            if (submitMneu(userid, menuname, menuurl, status, plevel)) {
                $.messager.alert("提示", "创建菜单成功", "info");
            } else {
                $.messager.alert("提示", "创建菜单失败", "error");
                return;
            }

        });


        /*提交菜单创建表单*/
        function submitMneu(userid, menuname, menuurl, status, plevel) {
            var result = false;
            $.ajax({
                url: '<%=contextPath%>/sysMenuAction!markMenu.action',
                type: "post",
                async: false,//取消异步通知
                dataType: "json",
                data: {
                    "sysMenu.plevel": plevel,
                    "sysMenu.menuname": menuname,
                    "sysMenu.menuurl": menuurl,
                    "sysMenu.status": status,
                    "userid": userid,
                    "sysMenu.inputuserid": userid
                },
                error: function (data) {
                    result = false;
                },
                success: function (data) {
                    if (data.code == "success") {
                        result = true;
                    } else {
                        result = false;
                    }
                }
            });
            return result;
        }


        /*检测菜单名称*/
        $("#menuname").blur(function () {
            var userid = $("#userid").val();
            var menuname = $("#menuname").val();
            verifyMneuName(menuname, userid);
        });

        function verifyMneuName(menuname, userid) {
            var result = false;
            $.ajax({
                url: '<%=contextPath%>/sysMenuAction!verifyMenuName.action',
                type: "post",
                async: false,//取消异步通知
                dataType: "json",
                data: {
                    "menuname": menuname,
                    "userid": userid
                },
                success: function (data) {
                    if (data.code == "success") {
                        result = false;
                        $.messager.alert("提示", menuname + "-已经存在,请换个名字重试!", "error");
                    } else {
                        result = true;
                    }

                }
            });
            return result;
        }


        $("#plevel").change(function () {
            var userid = $("#userid").val();
            var plevel = $("#plevel").val();
            if (plevel == "1") {
                $("#menuurl").val("");
                $("#menuurl").attr("readonly", "readonly");
                $("#parentmenu").hide();
                $.messager.alert("提示", "父菜单不需要菜单地址", "info");
                loadMenu(userid);
            } else {
                $("#menuurl").removeAttr("readonly");
                $("#parentmenu").show();
            }

        });


        function loadMenu(userid) {
            var result = false;
            $.ajax({
                url: '<%=contextPath%>/sysMenuAction!loadMenu.action',
                type: "post",
                async: false,//取消异步通知
                dataType: "json",
                data: {
                    "userid": userid
                },
                success: function (data) {
                    if (data.code == "success") {
                        alert(data.msg);
                        $.each(data.msg, function (i, sysmenu) {
                            alert("测试" + sysmenu.id);
                        })
                        
                        /*for (i = 0; i < data.msg.length; i++) {
                         alert("数据为:" + data.msg.id);
                         $("#selectId").append("<option value='" + data.msg[i].id + "'>" + data.msg[i].menuname + "</option>");
                         }*/
                        result = false;
                        /*$.messager.alert("提示", menuname + "-已经存在,请换个名字重试!", "error");*/
                    } else {
                        result = true;
                        alert(data.msg);
                    }
                }
            });
            return result;
        }


    });

</script>

</body>
</html>
