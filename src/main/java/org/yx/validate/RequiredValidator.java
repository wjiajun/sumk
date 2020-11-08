/**
 * Copyright (C) 2016 - 2030 youtongluan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yx.validate;

import org.yx.annotation.Bean;
import org.yx.conf.AppInfo;
import org.yx.exception.InvalidParamException;

@Bean
public class RequiredValidator implements Validator {

	@Override
	public void valid(ParamInfo param, Object arg) throws InvalidParamException {
		if (!param.param.required()) {
			return;
		}
		if (arg == null || "".equals(arg)) {
			throw new InvalidParamException(AppInfo.get("sumk.valid.msg.null", "#不能为空"), param);
		}
	}

}