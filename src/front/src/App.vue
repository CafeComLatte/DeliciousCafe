<template>
	<router-view/>
</template>
<script setup>
import {ref} from 'vue'
const v = ref(3);
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

:global(.f-30){
	font-size: 30px;
}

</style>
