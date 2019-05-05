<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="kendo" uri="http://www.springframework.org/tags/form" %>
<script type="application/javascript">
    $(document).ready(function () {
        var ch = $('#chBoxId').val();
        if (ch == 'false') {
            $('#radeTxt').removeAttr('disabled');
            $('#newradeDiv').css('display', 'none');
            $('#deleteBtn').css('display', 'block');
        }
        else {
            $('#radeTxt').attr('disabled', 'disabled');
            ;
            $('#newradeDiv').css('display', 'block');
            $('#deleteBtn').css('display', 'none');
        }
        $('#chBoxId').change(function () {
            if ($(this).is(":checked")) {
                $('#radeTxt').attr('disabled', 'disabled');
                ;
                $('#newradeDiv').css('display', 'block');
                $('#deleteBtn').css('display', 'none');
            }
            else {
                $('#radeTxt').removeAttr('disabled');
                $('#newradeDiv').css('display', 'none');
                $('#deleteBtn').css('display', 'block');
            }
        });
    })
    $('#saveChange').click(function () {
        $.post('/inventorycontrol/baseinformation/unit/unit/doEdit', {
            check: $('#chBoxId').is(":checked"),
            rade: $('#radeTxt').val(),
            radeNew: $('#newRadeTxt').val(),
            radeId: $('#radeId').val()
        }, function (xx) {

        }).done(function () {
            ClearScreenMiddle();
            var tree = $("#treeview").data("kendoTreeView");
            tree.dataSource.read();
        })
    });
    $('#deleteBtn').click(function () {
        $.post('/inventorycontrol/baseinformation/unit/unit/doDelete', {radeId: $('#radeId').val()}, function (xx) {

        }).done(function () {
            ClearScreenMiddle();
            var tree = $("#treeview").data("kendoTreeView");
            tree.dataSource.read();
        })
    });

    function ClearScreenMiddle() {
        $('#WraperScreenMiddle').css({'display': 'none'});
        $('#BlockRenderMiddle').css({'display': 'none'});
    }

    $('#cancelBtn').click(function () {
        ClearScreenMiddle();
    });
</script>
<!-- Modal -->

<div class="container-fluid">
    <div class="row">
        <div class="col-md-5">
            <span>آیا رده جدیدی اضافه خواهید کرد؟</span><input id="chBoxId" type="checkbox" value="false"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3"><span>نام رده:</span></div>
        <div class="col-md-2">
            <input type="text" id="radeTxt" value="${unitname}"/>
            <input type="hidden" id="radeId" value="${unitid}"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3"><span>نام رده جدید:</span></div>
        <div class="col-md-2"><input type="text" id="newRadeTxt"/></div>
    </div>


    <div class="row">
        <div class="col-md-3">
            <input type="button" id="saveChange" class="btn btn-default" value="savechange"/>
        </div>
        <div class="col-md-2">
            <button id="deleteBtn" type="button" class="btn btn-default">delete</button>
        </div>
        <div class="col-md-1">
            <button id="cancelBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
<input type="hidden"
       name="${_csrf.parameterName}"
       value="${_csrf.token}"/>

