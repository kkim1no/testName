<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- <form action="upload" method="post" enctype="multipart/form-data">
		<li><label>UserID : </label> <input type="text" name="userid"
			placeHolder="유저 아이디를 입력해주세요"></li>
		<li><label>제목 :</label> <input type="text" name="title"
			placeHolder="게시물제목을 입력해주세요"></li>
		<li><label>설명 :</label> <input type="text" name="dsc"
			placeHolder="노래에 대한 설명을 입력해주세요"></li>
		<li><label>장르 : </label> <select name="cate">
				<option value="댄스">댄스
				<option value="발라드">발라드
				<option value="팝">팝
				<option value="클래식">클래식
				<option value="락">락
				<option value="기타">기타
		</select></li> <br>
		<li><label>파일 업로드</label> <input type="file" name="file"></li>
		<li><label>img : </label> <input type="text" name="img"
			placeHolder="이미지 경로"></li>
		<li><label>가수 :</label> <input type="text" name="artist"
			placeHolder="가수이름"></li>
		<li><label>앨범 : </label> <input type="text" name="albname"
			placeHolder="앨범 제목"></li> <br> <input type="submit"
			name="upload" value="업로드"> -->

		<form action="upload" method="post" enctype="multipart/form-data">
			<div class="modal-body">
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"> UserID </span> <input
							name="userid" type="text" class="form-control"
							placeholder="UserID">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"> Title </span> <input name="title"
							type="text" class="form-control" placeholder="게시물 제목">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"> Artist </span> <input name="artist"
							type="text" class="form-control" placeholder="가수이름">
					</div>
				</div>
				<div class="form-group">
					<textarea name="dsc" class="form-control"
						placeholder="노래에 대한 상세정보를 입력해 주세요" style="height: 120px;"></textarea>
				</div>
				<div class="form-group">
					<div class="btn btn-success btn-file">
						<i class="fa fa-paperclip"></i> Attachment <input type="file"
							name="file" />
					</div>
				</div>

			</div>
			<div class="modal-footer clearfix">

				<button type="button" class="btn btn-danger" data-dismiss="modal">
					<i class="fa fa-times"></i> Discard
				</button>

				<button type="submit" class="btn btn-primary pull-left">
					<i class="fa fa-envelope"></i> File Upload
				</button>
			</div>
		</form>



</body>
</html>