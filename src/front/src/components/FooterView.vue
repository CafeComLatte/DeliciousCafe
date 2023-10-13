<template>
	<div id="footer">
		<div id="footer_wrap">
			<p>해당 프로그램은 포트폴리오용입니다. 상업적 이용 불가합니다.</p>
			<div>
				<ul>
					<li>공지사항</li>
					<li>고객센터</li>
					<li>이용약관</li>
					<li>개인정보 처리방침</li>
					<li><span>연락처 : 010-5555-5555</span></li>
				</ul>
			</div>
		</div>
	</div>
</template>
<script setup>
</script>
<style scoped>
#footer {
	background-color: black;
	width:1263px;
	height:200px;
	text-align: center;
}

#footer > #footer_wrap{
	margin : 0 auto;
	width:800px;
	height:200px;
	padding-top: 50px;
	color: white;
}

#footer > #footer_wrap > div > ul{
	display:inline-block;	
	list-style: none;
}

#footer > #footer_wrap > div > ul > li {
	float:left;
	padding:5px;
		
}

#footer > #footer_wrap > div > ul > li::after {	
	content: "|";
	float: right;
	display: block;	
	margin-left: 10px;
}

</style>