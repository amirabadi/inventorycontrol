<%@ tag language="java" pageEncoding="UTF-8"%>
this is footer
<script type="application/javascript">
$("#Logout").click(function(){
$form=$("<form>").attr({"action":"${pageContext.request.contextPath}"+"/logout","method":"post"})
.append($("<input>").attr({"type":"hidden","name":"${_csrf.parameterName}","value":"${_csrf.token}"}))
$("#Logout").append($form);
$form.submit();
});
</script>
</body>
</html>