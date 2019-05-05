<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/security/user/user/readuser" var="readObj" />
<c:url value="/security/user/user/updateuser" var="createObj" />
<c:url value="/security/user/user/updateuser" var="updateUrl" />
<c:url value="/security/user/user/destroyuser" var="destroyUrl" />
<%@taglib prefix="stylesite" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<stylesite:layout>
    <c:set var="col1"><spring:message code="msg.name" /></c:set>
    <c:set var="col2"><spring:message code="lname" /></c:set>
    <c:set var="col3"><spring:message code="nationalcode" /></c:set>
    <c:set var="bottommessage"><spring:message code="msg.bottommessage" /></c:set>
    <c:set var="col3"><spring:message code="nationalcode" /></c:set>
    <c:set var="col3"><spring:message code="nationalcode" /></c:set>
    <c:set var="col3"><spring:message code="nationalcode" /></c:set>
    <script type="application/javascript">
        function OnRequest_Start(e) {
            var grid = $("#grid").data('kendoGrid');
            var data = grid.dataSource.read();
        }

        function createUser(){
            $.post('/inventorycontrol/security/user/user/create',function(xx){
                $('#WraperScreenMiddle').css({ 'display': 'block' });
                $('#BlockRenderMiddle').html(xx);
                $('#BlockRenderMiddle').css({ 'display': 'block' });

            })
        }
    </script>
    <div class="k-rtl">
        <input type="button" class="k-button" id="createBtn" onclick="createUser()" value="create"/>
        <kendo:grid name="grid" pageable="true" filterable="true"
                    sortable="true">
            <kendo:grid-pageable buttonCount="5"  info="true" >
                <kendo:grid-pageable-messages
                        display="${bottommessage}"
                        empty="آیتمی برای نمايش وجود ندارد" />
            </kendo:grid-pageable>
            <kendo:grid-filterable extra="false">
                <kendo:grid-filterable-messages and="و" clear="حذف" filter="فیلتر"
                                                info="جستجو" isFalse="نادرست" isTrue="درست" />
                <kendo:grid-filterable-operators>
                    <kendo:grid-filterable-operators-number eq="برابر" gt="بزرگتر از"
                                                            lt="کوچکتر از" />
                    <kendo:grid-filterable-operators-enums eq="برابر" neq="کوچکتر از" />
                    <kendo:grid-filterable-operators-date eq="برابر" lt="کوچکتر از"
                                                          gt="بزرگتر از" />
                    <kendo:grid-filterable-operators-string contains="شامل"
                                                            endswith="پایان با" startswith="شروع با" />
                </kendo:grid-filterable-operators>
            </kendo:grid-filterable>
            <kendo:grid-columns>
                <kendo:grid-column title="${col1}" field="userName" />
                <kendo:grid-column title="${col2}" field="password" />
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
                    <kendo:dataSource-schema-model id="idUser">
                        <%-- <kendo:dataSource-schema-model-fields>

                            &lt;%&ndash; 							<kendo:dataSource-schema-model-field name="roleId" type="number" /> &ndash;%&gt;
                            &lt;%&ndash;<kendo:dataSource-schema-model-field name="isShow" type="boolean"&ndash;%&gt;
                                                                 &lt;%&ndash;nullable="true" />&ndash;%&gt;
                            &lt;%&ndash;<kendo:dataSource-schema-model-field name="isActive"&ndash;%&gt;
                                                                 &lt;%&ndash;type="boolean" nullable="true" />&ndash;%&gt;
                            &lt;%&ndash;<kendo:dataSource-schema-model-field name="objectPerName"&ndash;%&gt;
                                                                 &lt;%&ndash;type="string" nullable="true" />&ndash;%&gt;
                            &lt;%&ndash;<kendo:dataSource-schema-model-field name="objectEngName"&ndash;%&gt;
                                                                 &lt;%&ndash;type="string" nullable="true" />&ndash;%&gt;
                            &lt;%&ndash;<kendo:dataSource-schema-model-field name="parentObjectId"&ndash;%&gt;
                                                                 &lt;%&ndash;type="string" nullable="true" />&ndash;%&gt;
                         </kendo:dataSource-schema-model-fields>--%>
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
    <div id="WraperScreenMiddle"  style="width: 100%; height: 100%; background-color: Black;
    z-index: 2000; position: fixed; display: none; top: 0px; left: 0px; margin: 0px;
    padding: 0px; opacity: 0.4; filter: alpha(opacity=40);overflow: scroll">
    </div>
    <div id="BlockRenderMiddle" class="modal-body" style="background-color: White;
    z-index: 2800; position: fixed; display: none; top: 5%;
    left: 12%;right:12%;bottom:2%;border-radius:20px;overflow: scroll"></div>
</stylesite:layout>