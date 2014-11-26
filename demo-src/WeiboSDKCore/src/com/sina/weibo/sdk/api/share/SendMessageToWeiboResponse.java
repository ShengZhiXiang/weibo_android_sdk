/*
 * Copyright (C) 2010-2013 The SINA WEIBO Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

import com.sina.weibo.sdk.constant.WBConstants;

/**
 * 第三方应用主动向微博发起的消息分享请求后，该类用于包装微博的响应数据。
 * @see {@link IWeiboHandler.Response#onResponse(baseResponse)}
 * 
 * @author SINA
 * @since 2013-10-29
 */
public class SendMessageToWeiboResponse extends BaseResponse {

    public SendMessageToWeiboResponse() {
    }

    public SendMessageToWeiboResponse(Bundle data) {
        fromBundle(data);
    }

    @Override
    public int getType() {
        return WBConstants.COMMAND_TO_WEIBO;
    }

    @Override
    final boolean check(Context context, VersionCheckHandler handler) {
        return true;
    }
}
