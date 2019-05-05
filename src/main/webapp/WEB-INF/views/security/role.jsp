<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="stylesite" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/security/Role/readRole" var="readObj" />
<c:url value="/security/Role/createRole" var="createObj" />
<c:url value="/security/Role/updateRole" var="updateUrl" />
<c:url value="/security/Role/destroyRole" var="destroyUrl" />
<stylesite:layout>
    <script>
        function OnRequest_Start(e) {
            var grid = $("#grid").data('kendoGrid');
            var data = grid.dataSource.read();
        }
    </script>
    <div class="k-rtl">
        <kendo:grid name="grid" pageable="true" filterable="true"
                    sortable="true">

            <kendo:grid-editable mode="inline"
                                 confirmation="آیا از حذف اين سطر مطمئن هستید؟" />
            <kendo:grid-toolbar>
                <kendo:grid-toolbarItem name="create" text="ثبت جدید" />
            </kendo:grid-toolbar>
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
                <kendo:grid-column title="roleTitle" field="roleName" />
                <kendo:grid-column title="roleTitlePersian" field="roleNamePersian" />
                <kendo:grid-column title="&nbsp;" width="250px">
                    <kendo:grid-column-command>

                        <kendo:grid-column-commandItem name="edit">
                            <kendo:grid-column-commandItem-text cancel="انصراف"
                                                                update="ثبت تغییرات" edit="ويرايش" />
                        </kendo:grid-column-commandItem>
                        <kendo:grid-column-commandItem name="destroy" text="حذف" />
                    </kendo:grid-column-command>
                </kendo:grid-column>
            </kendo:grid-columns>
            <kendo:dataSource pageSize="10" serverPaging="true"
                              serverSorting="true" serverFiltering="true" serverGrouping="true"
                              sync="OnRequest_Start">
                <kendo:dataSource-schema data="data" total="total" groups="data">
                    <kendo:dataSource-schema-model id="idRole">
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
</stylesite:layout>