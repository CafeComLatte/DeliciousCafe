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
