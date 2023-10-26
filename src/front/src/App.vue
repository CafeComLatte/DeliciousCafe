<template>
	<router-view/>
</template>
<script setup>

</script>
<style scoped>
:global(*) {
	box-sizing: border-box;
	margin : 0;
	padding : 0;	
	font-family: "Nanum HaNaSonGeurSsi";
	list-style: none;
	text-overflow:ellipsis;
	overflow:hidden;
	white-space: nowrap;
}

:global(*::after){
	box-sizing: border-box;
	margin : 0;
	padding : 0;	
}

:global(*::before){
	box-sizing: border-box;
	margin : 0;
	padding : 0;	
}

:global(.left){
	float : left;
}

:global(.right){
	float : right;
}

:global(.f-40){
	font-size: 40px;
}
</style>
