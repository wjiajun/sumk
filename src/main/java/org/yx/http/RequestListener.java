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
package org.yx.http;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.yx.annotation.Bean;

@Bean
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		if (sre == null) {
			return;
		}
		HttpHeadersHolder.remove();
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		if (sre == null) {
			return;
		}
		ServletRequest request = sre.getServletRequest();
		if (HttpServletRequest.class.isInstance(request)) {
			HttpHeadersHolder.setHttpRequest((HttpServletRequest) request);
		}

	}

}
