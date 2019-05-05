<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="stylesite" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/baseinformation/equityReceiver/equityReceiver/read" var="readObj" />
<c:url value="/security/AccessLevel/createAccessLevel" var="createObj" />
<c:url value="/security/AccessLevel/updateAccessLevel" var="updateUrl" />
<c:url value="/security/AccessLevel/destroyAccessLevel" var="destroyUrl" />
<c:set var="col1"><spring:message code="msg.name" /></c:set>
<c:set var="col2"><spring:message code="lname" /></c:set>
<c:set var="col3"><spring:message code="nationalcode" /></c:set>
<c:set var="bottommessage"><spring:message code="msg.bottommessage" /></c:set>
<c:set var="emptymessage"><spring:message code="msg.emptygrid" /></c:set>
<c:set var="filter"><spring:message code="grid.filter" /></c:set>
<c:set var="remove"><spring:message code="grid.remove" /></c:set>
<c:set var="and"><spring:message code="grid.and" /></c:set>
<c:set var="true"><spring:message code="grid.true" /></c:set>
<c:set var="false"><spring:message code="grid.false" /></c:set>
<c:set var="info"><spring:message code="grid.info" /></c:set>
<c:set var="gridgt"><spring:message code="grid.gt" /></c:set>
<c:set var="grideq"><spring:message code="grid.eq" /></c:set>
<c:set var="gridlt"><spring:message code="grid.lt" /></c:set>
<c:set var="gridneq"><spring:message code="grid.neq" /></c:set>
<c:set var="contains"><spring:message code="grid.contains" /></c:set>
<c:set var="endswith"><spring:message code="grid.endswith" /></c:set>
<c:set var="startswith"><spring:message code="grid.startswith" /></c:set>

<stylesite:layout>
    <script>

    function OnRequest_Start(e) {
    var grid = $("#grid").data('kendoGrid');
    var data = grid.dataSource.read();
    }
    </script>
    <div class="k-rtl">
        <input type="button" class="k-button" id="createBtn" value="create"/>
        <kendo:grid name="grid" pageable="true" filterable="true"
                    sortable="true">
            <kendo:grid-pageable buttonCount="10"  info="true" >
                <kendo:grid-pageable-messages
                        display="${bottommessage}"
                        empty="${emptymessage}" />
            </kendo:grid-pageable>
            <kendo:grid-filterable extra="false">
                <kendo:grid-filterable-messages and="${filter}" clear="${filter}" filter="${filter}"
                                                info="${filter}" isFalse="${filter}" isTrue="${filter}" />
                <kendo:grid-filterable-operators>
                    <kendo:grid-filterable-operators-number eq="${grideq}" gt="${gridgt}"
                                                            lt="${gridlt}" />
                    <kendo:grid-filterable-operators-enums eq="${grideq}" neq="${gridneq}" />
                    <kendo:grid-filterable-operators-date eq="${grideq}" lt="${gridlt}"
                                                          gt="${gridgt}" />
                    <kendo:grid-filterable-operators-string contains="${contains}"
                                                            endswith="${endswith}" startswith="${startswith}" />
                </kendo:grid-filterable-operators>
            </kendo:grid-filterable>
            <kendo:grid-columns>
                <kendo:grid-column title="${col1}" field="aminName" />
                <kendo:grid-column title="${col2}" field="entesabDate" />
                <kendo:grid-column title="${col2}" field="enabled" />
                <kendo:grid-column title="&nbsp;" width="250px">
                    <kendo:grid-column-command>
                        <kendo:grid-column-commandItem name="viewDetails" text="View Details">
                            <kendo:grid-column-commandItem-click>
                                <script>
                                    function showDetails(e) {
                                        e.preventDefault();
                                        var row = $(e.target).closest("tr");
                                        var grid = $("#grid").data("kendoGrid");
                                        var dataItem = grid.dataItem(row);
                                        $.post('/inventorycontrol/security/user/user/edit',{editId:dataItem.idUser},function(xx){
                                            $('#WraperScreenMiddle').css({ 'display': 'block' });
                                            $('#BlockRenderMiddle').html(xx);
                                            $('#BlockRenderMiddle').css({ 'display': 'block' });
                                        })
                                    }
                                </script>
                            </kendo:grid-column-commandItem-click>
                        </kendo:grid-column-commandItem>
                    </kendo:grid-column-command>
                </kendo:grid-column>
            </kendo:grid-columns>
            <kendo:dataSource pageSize="10" serverPaging="true"
                              serverSorting="true" serverFiltering="true" serverGrouping="true"
                              sync="OnRequest_Start">
                <kendo:dataSource-schema data="data" total="total" groups="data">
                    <kendo:dataSource-schema-model id="id">
                    </kendo:dataSource-schema-model>
                </kendo:dataSource-schema>
                <kendo:dataSource-transport>
                    <kendo:dataSource-transport-create url="${createObj}"
                                                       dataType="json" type="POST" contentType="application/json" />
                    <kendo:dataSource-transport-read url="${readObj}" dataType="json"
                                                     type="POST" contentType="application/json" />
                    <kendo:dataSource-transport-update url="${updateUrl}"
                                                       dataType="json" type="POST" contentType="application/json" />
                    <kendo:dataSource-transport-destroy url="${destroyUrl}"
                                                        dataType="json" type="POST" contentType="application/json" />
                    <kendo:dataSource-transport-parameterMap>
                        function(options){return JSON.stringify(options);}
                    </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
            </kendo:dataSource>
        </kendo:grid>
    </div>
</stylesite:layout>