<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<title>Insert title here</title>
</head>
<body>
<s:form action="UserUpdateCompleteAction">
<table>
  <tr>
   <th>ユーザーID</th>
   <td><s:property value="%{session.user_id}"/>
   <s:hidden name="user_id" value="%{session.user_id}" /></td>
   </tr>
   <s:if test="session.newPassword != null" >
   <tr>
   <th>新規パスワード</th>
   <td><s:property value="%{session.newPassword}"/>
   <s:hidden name="newPassword" value="%{session.newPassword}" /></td>
   </tr>
   </s:if>
   <s:if test="session.newEmail != ''" >
   <tr>
   <th>メールアドレス</th>
   <td><s:property value="%{session.newEmail}"/>
   <s:hidden name="newEmail" value="%{session.newEmail}" /></td>
   </tr>
   </s:if>
   <tr>
   <td>変更内容が正しければ右のボタンで変更を完了してください。</td>
   <td><s:a href="javascrrpt:void(0)"
	onclick="document.UserUpdateCompleteAction.submit();return false;"
	 class="button">変更</s:a>
  </table>
  </s:form>



</body>
</html>