<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kendoUI" uri="http://www.kendoui.com/jsp/tags" %>
<c:url value="/security/user/user/read" var="transportReadUrl"/>
<script>
    function ClearScreenMiddle(){
        $('#WraperScreenMiddle').css({ 'display': 'none' });
        $('#BlockRenderMiddle').css({ 'display': 'none' });
    }
    $('#cancel').click(function () {
        ClearScreenMiddle();
    })
    $('#saveChange').click(function () {
        var mytree = $("#treeview").data("kendoTreeView");
        var selected = mytree.select();
        var selItem = mytree.dataItem(selected);
        var roles = $("#idRoleCombo").data("kendoDropDownList");
        $.post('/inventorycontrol/security/user/user/doAdd', {
            editId: $('#editId').val(),
            userNameId: $('#userNameId').val(),
            passId: $('#passId').val(),
            radeId: selItem.id,
            idRole: roles.value()
        }, function (xx) {

        }).done(function () {
            ClearScreenMiddle();

            OnRequest_Start(null);
            /* var tree = $("#treeview").data("kendoTreeView");
             tree.dataSource.read();*/
        })
    });
    $('#deleteBtn').click(function () {
        $.post('/inventorycontrol/security/user/user/doDelete', {radeId: $('#radeId').val()}, function (xx) {

        }).done(function () {
            $('#WraperScreenMiddle').css({ 'display': 'block' });
            $('#BlockRenderMiddle').html(xx);
            $('#BlockRenderMiddle').css({ 'display': 'block' });
            var tree = $("#treeview").data("kendoTreeView");
            tree.dataSource.read();
        })
    });
</script>
<script>
    function onSelect(e) {
        var data = $('#treeview').data('kendoTreeView').dataItem(e.node);
        $.post('/inventorycontrol/baseinformation/unit/unit/edit', {
            nodeval: data.idUnit,
            nodetxt: data.unitName
        }, function (xx) {
            $('#WraperScreenMiddle').css({ 'display': 'block' });
            $('#BlockRenderMiddle').html(xx);
            $('#BlockRenderMiddle').css({ 'display': 'block' });
        })
    }

    /*    $('document').ready(function(){
            $('#btnModel').click(function(){
                $.post('/inventorycontrol/baseinformation/unit/unit/edit',function(xx){
                    $('#tempModel').html(xx);
                    $('#myModal').modal('show');
                })
            });

        });*/


</script>

<!-- Modal -->
<div class="container-fluid">

    <div class="row">
        <div class="col-md-4">
            <div class="k-rtl" style="max-height:500px; overflow: scroll;">
                <kendoUI:treeView name="treeview" dataTextField="unitName" >
                    <kendoUI:dataSource>
                        <kendoUI:dataSource-transport>
                            <kendoUI:dataSource-transport-read url="${transportReadUrl}" type="POST"
                                                               contentType="application/json"/>
                            <kendoUI:dataSource-transport-parameterMap>
                                <script>
                                    function parameterMap(options, type) {
                                        return JSON.stringify(options);
                                    }
                                </script>
                            </kendoUI:dataSource-transport-parameterMap>
                        </kendoUI:dataSource-transport>
                        <kendoUI:dataSource-schema>
                            <kendoUI:dataSource-schema-hierarchical-model id="idUnit"
                                                                          hasChildren="hasUnits"/>
                        </kendoUI:dataSource-schema>
                    </kendoUI:dataSource>
                </kendoUI:treeView>
            </div>
        </div>
        <div class="col-md-4">
            <div class="row">
                <div class="col-md-2"><span>user name:</span></div>
                <div class="col-md-2"><input type="text" id="userNameId" value="${userNameId}"/></div>
            </div>
            <div class="row">
                <div class="col-md-2"><span>password:</span></div>
                <div class="col-md-2"><input type="text" id="passId" disabled="${editValue}>'true':'false'"
                                             value="${passId}"/></div>
            </div>
            <div class="row">
                <div class="col-md-2"><span>role:</span></div>
                <div class="col-md-2">
                    <kendoUI:dropDownList name="idRoleCombo" id="idRoleCombo" dataTextField="text"
                                          dataValueField="value" value="${roleIds}">
                        <kendoUI:dataSource data="${allRoles}"></kendoUI:dataSource>
                    </kendoUI:dropDownList>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
            <div class="col-md-3">
                <input type="button" id="saveChange" class="btn btn-default" value="savechange"/>
            </div>
            <div class="col-md-2">
                <button id="deleteBtn" type="button" class="btn btn-default">delete</button>
            </div>
            <div class="col-md-3">
                <button type="button" id="cancel" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
     </div>
</div>
<input type="hidden" id="editId" value="${editValue}"/>
<script type="application/javascript">
    $(document).ready(function () {
        var treeview = $("#treeview").data("kendoTreeView");
        treeview.one("dataBound", function () {
            //treeview.expandPath([1,2], function() {
            treeview.expandPath([1, 2]);
        });
    })
</script>