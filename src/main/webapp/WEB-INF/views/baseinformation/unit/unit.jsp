<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="stylesite" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/baseinformation/unit/unit/read" var="transportReadUrl" />
<stylesite:layout>
    <div class="k-rtl">
        <kendo:treeView name="treeview" dataTextField="unitName" select="onSelect">
            <kendo:dataSource>
                <kendo:dataSource-transport>
                    <kendo:dataSource-transport-read url="${transportReadUrl}" type="POST"  contentType="application/json"/>
                    <kendo:dataSource-transport-parameterMap>
                        <script>
                            function parameterMap(options,type) {
                                return JSON.stringify(options);
                            }
                        </script>
                    </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
                <kendo:dataSource-schema>
                    <kendo:dataSource-schema-hierarchical-model id="idUnit" hasChildren="hasUnits" />
                </kendo:dataSource-schema>
            </kendo:dataSource>
        </kendo:treeView>
    </div>

    <div id="WraperScreenMiddle"  style="width: 100%; height: 100%; background-color: Black;
    z-index: 2000; position: fixed; display: none; top: 0px; left: 0px; margin: 0px;
    padding: 0px; opacity: 0.4; filter: alpha(opacity=40);overflow: scroll">
    </div>
    <div id="BlockRenderMiddle" class="modal-body" style="background-color: White;
    z-index: 2800; position: fixed; display: none; top: 5%;
    left: 30%;right:30%;border-radius:20px;overflow: scroll"></div>
   <%-- <button type="button" id="btnModel" class="btn btn-success openBtn">Open Modal</button>--%>
    <script>
        function onSelect(e) {
            var data = $('#treeview').data('kendoTreeView').dataItem(e.node);
            $.post('/inventorycontrol/baseinformation/unit/unit/edit',{nodeval:data.idUnit,nodetxt:data.unitName},function(xx){

                $('#WraperScreenMiddle').css({ 'display': 'block' });
                $('#BlockRenderMiddle').html(xx);
                $('#BlockRenderMiddle').css({ 'display': 'block' });
            })
        }




    </script>

</stylesite:layout>