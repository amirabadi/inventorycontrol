<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/security/person/readperson" var="readObj"/>
<c:url value="/security/person/createperson" var="createObj"/>
<c:url value="/security/person/updateperson" var="updateUrl"/>
<c:url value="/security/person/destroyperson" var="destroyUrl"/>
<%@taglib prefix="stylesite" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<stylesite:layout>
    <script src="/inventorycontrol/resources/js/checkNationalCode.js"></script>
    <c:set var="col1"><spring:message code="msg.name"/></c:set>
    <c:set var="col2"><spring:message code="msg.lastname"/></c:set>
    <c:set var="col3"><spring:message code="msg.nationalcode"/></c:set>
    <c:set var="bottommessage"><spring:message code="msg.bottommessage"/></c:set>
    <c:set var="emptymessage"><spring:message code="msg.emptygrid"/></c:set>

    <script>

        function OnRequest_Start(e) {
            var grid = $("#grid").data('kendoGrid');
            var data = grid.dataSource.read();
        }

        $(document).ready(function () {
            $('#rrr').click(function () {
                $.post('/inventorycontrol//security/person/readperson1', function (xx) {

                })
            });
        });
    </script>
    <div class="k-rtl">
            <%-- <input type="button" value="1111" id="rrr"/>--%>

        <kendo:grid name="grid" pageable="true" filterable="true"
                    sortable="true">

            <kendo:grid-editable mode="inline"
                                 confirmation="آیا از حذف اين سطر مطمئن هستید؟"/>
            <kendo:grid-toolbar>
                <kendo:grid-toolbarItem name="create" text="ثبت جدید"/>
            </kendo:grid-toolbar>
            <kendo:grid-pageable buttonCount="5" info="true">
                <kendo:grid-pageable-messages
                        display="${bottommessage}"
                        empty="${emptymessage}"/>
            </kendo:grid-pageable>
            <kendo:grid-filterable extra="false">
                <kendo:grid-filterable-messages and="و" clear="حذف" filter="فیلتر"
                                                info="جستجو" isFalse="نادرست" isTrue="درست"/>
                <kendo:grid-filterable-operators>
                    <kendo:grid-filterable-operators-number eq="برابر" gt="بزرگتر از"
                                                            lt="کوچکتر از"/>
                    <kendo:grid-filterable-operators-enums eq="برابر" neq="کوچکتر از"/>
                    <kendo:grid-filterable-operators-date eq="برابر" lt="کوچکتر از"
                                                          gt="بزرگتر از"/>
                    <kendo:grid-filterable-operators-string contains="شامل"
                                                            endswith="پایان با" startswith="شروع با"/>
                </kendo:grid-filterable-operators>
            </kendo:grid-filterable>
            <kendo:grid-columns>
                <kendo:grid-column title="${col1}" field="name"/>
                <kendo:grid-column title="${col2}" field="lastName"/>
                <kendo:grid-column title="${col3}" field="nationalCode"/>
                <kendo:grid-column title="&nbsp;" width="250px">
                    <kendo:grid-column-command>

                        <kendo:grid-column-commandItem name="edit">
                            <kendo:grid-column-commandItem-text cancel="انصراف"
                                                                update="ثبت تغییرات" edit="ويرايش"/>
                        </kendo:grid-column-commandItem>
                        <kendo:grid-column-commandItem name="destroy" text="حذف"/>
                    </kendo:grid-column-command>
                </kendo:grid-column>
            </kendo:grid-columns>
            <kendo:dataSource pageSize="10" serverPaging="true"
                              serverSorting="true" serverFiltering="true" serverGrouping="true"
                              sync="OnRequest_Start">
                <kendo:dataSource-schema data="data" total="total" groups="data">
                    <kendo:dataSource-schema-model id="idPerson">
                        <kendo:dataSource-schema-model-fields>
                            <kendo:dataSource-schema-model-field name="name" type="string">
                                <kendo:dataSource-schema-model-field-validation required="true"/>
                            </kendo:dataSource-schema-model-field>
                            <kendo:dataSource-schema-model-field name="lastName" type="string">
                                <kendo:dataSource-schema-model-field-validation required="true"/>
                            </kendo:dataSource-schema-model-field>
                            <kendo:dataSource-schema-model-field name="nationalCode" type="string">
                                <kendo:dataSource-schema-model-field-validation required="true" />
                            </kendo:dataSource-schema-model-field>
                        </kendo:dataSource-schema-model-fields>
                    </kendo:dataSource-schema-model>
                </kendo:dataSource-schema>
                <kendo:dataSource-transport>
                    <kendo:dataSource-transport-create url="${createObj}"
                                                       dataType="json" type="POST" contentType="application/json"/>
                    <kendo:dataSource-transport-read url="${readObj}" dataType="json"
                                                     type="POST" contentType="application/json"/>
                    <kendo:dataSource-transport-update url="${updateUrl}"
                                                       dataType="json" type="POST" contentType="application/json"/>
                    <kendo:dataSource-transport-destroy url="${destroyUrl}"
                                                        dataType="json" type="POST" contentType="application/json"/>
                    <kendo:dataSource-transport-parameterMap>
                        function(options){return JSON.stringify(options);}
                    </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
            </kendo:dataSource>
        </kendo:grid>
        <script>
            //register custom validation rules
            (function ($, kendo) {
                $.extend(true, kendo.ui.validator, {
                    rules: { // custom rules
                        productnamevalidation: function (input, params) {
                            //check for the name attribute
                            if (input.is("[name='nationalCode']") && input.val()) {
                                return checkMelliCode(input.val());
                            }
                            return true;
                        }
                    },
                    messages: { //custom rules messages
                        productnamevalidation: "<spring:message code="msg.error.code"/>",
                        required:"<spring:message code="msg.error.required"/>"
                    }
                });
            })(jQuery, kendo);
        </script>
    </div>
    <%--
    <kendo:dataSource-transport parameterMap="additionalParameters">
     <kendo:dataSource-transport-read url="/ListBeer" type="GET" contentType="application/json"/>
 </kendo:dataSource-transport>
 <script type="text/javascript">
     var theId = "xyz";

     function additionalParameters(data, type) {
         if (type === "read") {
             return "id=" + theId;
         }
         return data;
     }
     OR
     function additionalParameters(data, type) {
     if (type === "read") {
         return "id=" + data + "&param=" + JSON.stringify(data);
     }
     return "param= "+ JSON.stringify(data);
 }
 </script>
 ------------------validate---------------------
 <%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <c:url value="/grid/editing-inline/create" var="createUrl" />
 <c:url value="/grid/editing-inline/read" var="readUrl" />
 <c:url value="/grid/editing-inline/update" var="updateUrl" />
 <c:url value="/grid/editing-inline/destroy" var="destroyUrl" />


     <kendo:grid name="grid" pageable="true" sortable="true" height="550px" >
         <kendo:grid-editable mode="inline" confirmation="Are you sure you want to remove this item?"/>
         <kendo:grid-toolbar>
             <kendo:grid-toolbarItem name="create"/>
         </kendo:grid-toolbar>
         <kendo:grid-columns>
             <kendo:grid-column title="Product Name" field="productName" />
             <kendo:grid-column title="Unit Price" field="unitPrice" format="{0:c}" width="120px" />
             <kendo:grid-column title="Units In Stock" field="unitsInStock" width="120px" />
             <kendo:grid-column title="Discontinued" field="discontinued" width="120px"/>
             <kendo:grid-column title="&nbsp;" width="250px">
                 <kendo:grid-column-command>
                     <kendo:grid-column-commandItem name="edit" />
                     <kendo:grid-column-commandItem name="destroy" />
                 </kendo:grid-column-command>
             </kendo:grid-column>
         </kendo:grid-columns>
         <kendo:dataSource pageSize="20">
             <kendo:dataSource-transport>
                 <kendo:dataSource-transport-create url="${createUrl}" dataType="json" type="POST" contentType="application/json" />
                 <kendo:dataSource-transport-read url="${readUrl}" dataType="json" type="POST" contentType="application/json"/>
                 <kendo:dataSource-transport-update url="${updateUrl}" dataType="json" type="POST" contentType="application/json" />
                 <kendo:dataSource-transport-destroy url="${destroyUrl}" dataType="json" type="POST" contentType="application/json" />
                 <kendo:dataSource-transport-parameterMap>
                     <script>
                         function parameterMap(options,type) {
                             return JSON.stringify(options);
                         }
                     </script>
                 </kendo:dataSource-transport-parameterMap>
             </kendo:dataSource-transport>
             <kendo:dataSource-schema>
                 <kendo:dataSource-schema-model id="productId">
                     <kendo:dataSource-schema-model-fields>
                         <kendo:dataSource-schema-model-field name="productName" type="string">
                             <kendo:dataSource-schema-model-field-validation required="true" />
                         </kendo:dataSource-schema-model-field>
                         <kendo:dataSource-schema-model-field name="unitPrice" type="number">
                             <kendo:dataSource-schema-model-field-validation required="true" min="1" />
                         </kendo:dataSource-schema-model-field>
                         <kendo:dataSource-schema-model-field name="unitsInStock" type="number">
                             <kendo:dataSource-schema-model-field-validation required="true" min="0" />
                         </kendo:dataSource-schema-model-field>
                         <kendo:dataSource-schema-model-field name="discontinued" type="boolean" />
                     </kendo:dataSource-schema-model-fields>
                 </kendo:dataSource-schema-model>
             </kendo:dataSource-schema>
         </kendo:dataSource>
     </kendo:grid>

     <script>
             //register custom validation rules
             (function ($, kendo) {
                 $.extend(true, kendo.ui.validator, {
                      rules: { // custom rules
                          productnamevalidation: function (input, params) {
                              //check for the name attribute
                              if (input.filter("[name='productName']").length && input.val()) {
                                  return /^[A-Z]/.test(input.val());
                              }
                              return true;
                          }
                      },
                      messages: { //custom rules messages
                          productnamevalidation: "Product Name should start with capital letter"
                      }
                 });
             })(jQuery, kendo);
     </script>
    --%>
</stylesite:layout>