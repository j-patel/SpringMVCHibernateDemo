<%-- 
    Document   : employee
    Created on : Sep 23, 2018, 4:18:22 PM
    Author     : jay20
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
        <style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
    </head>
    <body>
        <c:if test="${empty employee.firstName}">
            <h1>Add an Employee</h1>
        </c:if>
        <c:if test="${!empty employee.firstName}">
            <h1>Update Employee Details</h1>
        </c:if>

        <c:url var="addAction" value="/employee/add" ></c:url>

        <form:form action="${addAction}" commandName="employee">
            <table>
                <c:if test="${!empty employee.firstName}">
                <tr>
                    <td>
                            <form:label path="id">
                                    <spring:message text="ID"/>
                            </form:label>
                    </td>
                    <td>
                            <form:input path="id" readonly="true" size="8"  disabled="true" />
                            <form:hidden path="id" />
                    </td> 
                </tr>
                </c:if>
                <tr>
                    <td>
                            <form:label path="firstName">
                                    <spring:message text="First Name"/>
                            </form:label>
                    </td>
                    <td>
                            <form:input path="firstName" />
                    </td> 
                </tr>
                <tr>
                    <td>
                            <form:label path="lastName">
                                    <spring:message text="Last Name"/>
                            </form:label>
                    </td>
                    <td>
                            <form:input path="lastName" />
                    </td> 
                </tr>
                <tr>
                    <td>
                            <form:label path="designation">
                                    <spring:message text="Designation"/>
                            </form:label>
                    </td>
                    <td>
                            <form:input path="designation" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                            <c:if test="${!empty employee.firstName}">
                                    <input type="submit"
                                            value="<spring:message text="Update Employee"/>" />
                            </c:if>
                            <c:if test="${empty employee.firstName && empty employee.lastName}">
                                    <input type="submit"
                                            value="<spring:message text="Add Employee"/>" />
                            </c:if>
                    </td>
                </tr>
            </table>	
        </form:form>
        <br>
        <h3>Employees List</h3>
        <c:if test="${!empty listEmployees}">
	<table class="tg">
            <tr>
                    <th width="80">Employee ID</th>
                    <th width="120">First Name</th>
                    <th width="120">Last Name</th>
                    <th width="120">Designation</th>
                    <th width="60">Edit</th>
                    <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listEmployees}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.designation}</td>
                    <td><a href="<c:url value='/edit/${employee.id}' />" >Edit</a></td>
                    <td><a href="<c:url value='/remove/${employee.id}' />" >Delete</a></td>
		</tr>
            </c:forEach>
	</table>
        </c:if>
    </body>
</html>