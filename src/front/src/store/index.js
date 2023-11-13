import { createStore } from 'vuex'

import common from '@/store/modules/common.js'
import event from '@/store/modules/event.js'
import payment from '@/store/modules/payment.js'
import product from '@/store/modules/product.js'
import user from '@/store/modules/user.js'

export default createStore({
	modules: {
		common,
		event,
		payment,
		product,
		user
	}
});
