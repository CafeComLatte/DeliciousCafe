<template>
	<div id="search">
		<div id="search_wrap" @click="search(search_name)" :class="isFocus === true?'login-input-focus':'login-input-unFocus'">
			<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="#c8c8c8">
				<path d="M784-120 532-372q-30 24-69 38t-83 14q-109 0-184.5-75.5T120-580q0-109 75.5-184.5T380-840q109 0 184.5 75.5T640-580q0 44-14 83t-38 69l252 252-56 56ZM380-400q75 0 127.5-52.5T560-580q0-75-52.5-127.5T380-760q-75 0-127.5 52.5T200-580q0 75 52.5 127.5T380-400Z"/>
			</svg>
			<input v-model="search_name" type="text" :search_place_holder="info.search_place_holder" @focus="focus" @blur="unFocus" @input="search_name = $event.target.value"/>
			<button class="cancel_button pointer p-10" :class="{hidden:hidden}" >
				<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="#c8c8c8">
					<path d="m336-280 144-144 144 144 56-56-144-144 144-144-56-56-144 144-144-144-56 56 144 144-144 144 56 56ZM480-80q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"/>
				</svg>
			</button>
		</div>
	</div>
</template>
<script setup>
import {defineProps,ref,computed,watch} from 'vue'

const v = ref(20);

const props = defineProps({
	search_place_holder : {
		type: String,
		required: true
	},
	onSearch: {
		type: Function
	}
});

const search_name = ref('');

const info = computed(()=>{
	return props;
});

const search = (search_name) => {
	info.value.onSearch(search_name);
}

const isFocus = ref(false);
const hidden = ref(true);

watch(()=>search_name.value,(value)=>{
	if(search_name.value === ''){
		hidden.value = true;
	}else{
		hidden.value = false;
	}
})

const focus = () => {
	isFocus.value = true;
}

const unFocus = () => {
	isFocus.value = false;	
}
</script>
<style scoped>
#search{
	width: 1000px;
	height: 60px;	
}


#search>#search_wrap {
	display: flex;
	justify-content: space-between;
	border-radius: 5px;
	
}

#search>#search_wrap>* {
	display: inline-flex;
	align-items: center;
}

#search>#search_wrap>input {
	width: 900px;
	outline: none;
}

#search>#search_wrap>svg {
	margin: 10px;
}


</style>