<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 <title>게시판</title>
</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='selectForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/board/updateView");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				formObj.attr("action", "/board/delete");
				formObj.attr("method", "post");
				formObj.submit();
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/board/list";
			})
		})
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form name="selectForm" role="form" method="post">
					<input type="hidden" id="bno" name="bno" value="${select.bno}"/>
				</form>
					<table>
						<tbody>
							<%-- <tr>
								<td>
									<label for="bno">게시글 번호</label><input type="text" id="bno" name="bno" value="${select.bno }"/>
								</td>
							</tr> --%>
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" value="${select.title }" readonly="readonly"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="content" readonly="readonly">${select.content }</textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${select.writer }" readonly="readonly"/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="regdate">작성일</label>
									<fmt:formatDate value="${select.regdate}" pattern="yyyy-MM-dd"/>
								</td>
							</tr>			
						</tbody>			
					</table>
					<div>
					<button type="submit" class="update_btn">수정</button>
					<button type="submit" class="delete_btn">삭제</button>
					<button type="submit" class="list_btn">목록</button>	
				</div>
				
			</section>
			<hr />
		</div>
	</body>
</html>