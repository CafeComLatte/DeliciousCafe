const v = 1;

const rules = (type, value) => {
	if (value === '') {
		return '필수입력 사항입니다.';
	}

	if (type === 'id') {
		if (value.length >= 5 && value.length < 12) {
			return '';
		} else {
			return '5글자 이상, 12글자 미만이어야 합니다.';
		}
	} else if (type === 'password') {
		if (value.first && value.first === value.second) {
			return '';
		} else {
			return '비밀번호를 다시 확인해주세요.';
		}
	} else if (type === 'email') {
		if (/^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(value)) {
			return '';
		} else {
			return '이메일 형식이 아닙니다.';
		}
	} else if (type === 'phone') {
		if (/^[0-9]{3}-[0-9]{3}-[0-9]{4}$/.test(value)) {
			return '';
		} else {
			return '핸드폰번호 형식이 아닙니다.';
		}
	} else if (type === 'name') {
		return '';
	} else{
		return '알수없는 오류입니다.';
	}

};

export default rules;